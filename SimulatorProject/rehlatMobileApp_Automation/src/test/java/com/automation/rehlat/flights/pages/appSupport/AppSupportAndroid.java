package com.automation.rehlat.flights.pages.appSupport;

import com.automation.rehlat.flights.libCommon.Logger;

public class AppSupportAndroid extends AppSupportBase {

    public static final String XPATH_OF_SUPPORT_SCREEN_TITLE ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
    public static final String XPATH_OF_DISCARD_BUTTON_IN_NEW_EMAIL_WINDOW = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
    public static final String XPATH_OF_FAQS_NAME_IN_WEB_VIEW = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[3]";
    /**
     * Check the support screen is displayed
     */
    @Override
    public void checkSupportScreenIsDisplayed(){
        Logger.logAction("Checking the support screen is displayed");
        try {
            runAppInBackground(2);
            String screenTitle = findElementByXpathAndReturnItsAttributeText(XPATH_OF_SUPPORT_SCREEN_TITLE);
            if (screenTitle.equalsIgnoreCase("Rehlat 24/7 Support")){
                Logger.logStep("Support screen is displayed");
            }else {
                Logger.logError("Support screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the current screen name");
        }
    }

                                                                         ///////////////////////////         EmailSupport              /////////////////////////////

    /**
     * Tap on mail us button
     */
    @Override
    public void tapOnMailUsButton(){
        Logger.logAction("Tapping on mail us button");
        try {
            findElementByIdAndClick("com.app.rehlat:id/expressSupportLayout");
            Logger.logComment("Tapped on Mail us button");

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on mail us button");
        }
    }

    /**
     * Check is new email window is displayed
     * @return
     */
    @Override
    public boolean isNewEmailWindowIsDisplayed(){
        Logger.logAction("Checking the new email window is displayed or not ?");
        try {
            if (isWelcomeEmailScreenIsDisplayed()){
                Logger.logStep("Email set up is not done in the device");
                return false;
            }else if (isElementDisplayedById("android:id/button_always") && isElementDisplayedById("android:id/button_once"))
            {
                Logger.logComment("New email suggestion email modal view is displayed");
                findElementByIdAndClick("android:id/button_once");
                if(isElementDisplayedByAccessibilityId("More options") && isElementDisplayedById("com.google.android.gm:id/send") && isElementDisplayedByAccessibilityId("From")){
                    Logger.logStep("New email window is displayed");
                    return true;
                }
            }else {
                Logger.logError("Could not check the displayed alert type");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the email window is displayed or not?");
        }
        return false;
    }

    /**
     * Send the email by tapping on send button
     */
    @Override
    public void sendEmail(){
        Logger.logAction("Sending the email");
        try {
            if (isNewEmailWindowIsDisplayed()){
                findElementByIdAndClick("com.google.android.gm:id/send");
                Logger.logComment("Tapped on email send button");
                if (isElementDisplayedByName("com.google.android.gm:id/send")){
                    Logger.logError("Email is not sent");
                }else {
                    Logger.logStep("Email is sent");
                }
            }else {
                Logger.logError("New email window is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the email");
        }
    }

    /**
     * Check the could not send email alert is displayed
     */
    public static boolean isWelcomeEmailScreenIsDisplayed(){
        Logger.logAction("Checking Could not send email alert is displayed or not ?");
        try {
            if (isElementDisplayedById("com.google.android.gm:id/welcome_tour_pager")){
                Logger.logComment("Welcome email window is displayed");
                return true;
            }else {
                Logger.logWarning("Welcome email window is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the screen title");
        }
        return false;
    }

    /**
     * Tap on cancel button in new email window
     */
    @Override
    public void tapOnCancelButtonInNewEmailWindow(){
        Logger.logAction("Tapping on cancel button in new email window");
        try {
            if (isNewEmailWindowIsDisplayed()){
                findElementByXPathAndClick("//android.widget.ImageView[@content-desc=\"More options\"]");
                Logger.logComment("Tapped on More options button");
            }else {
                Logger.logError("New email window is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to tap on new email window cancel button");
        }
    }

    /**
     * Tap on delete draft button in new email window
     */
    @Override
    public void tapOnDeleteDraftButtonInNewEmailWindow(){
        Logger.logAction("Tapped on delete draft button");
        try {
            String elementName = findElementByXpathAndReturnItsAttributeName(XPATH_OF_DISCARD_BUTTON_IN_NEW_EMAIL_WINDOW);
            if (elementName.equalsIgnoreCase("Discard"))
            findElementByXPathAndClick(XPATH_OF_DISCARD_BUTTON_IN_NEW_EMAIL_WINDOW);
            Logger.logComment("Tapped on delete draft button");
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to tap on delete draft button in new email window ");
        }
    }

                                                                              ///////////////////////////          FAQ'S              /////////////////////////////

    /**
     * Tap on FAQ’S button
     */
    @Override
    public void tapOnFAQSButton(){
        Logger.logAction("Tapping on FAQ’S button");
        try {
            findElementByIdAndClick("com.app.rehlat:id/faqLinearLayout");
            Logger.logComment("Tapped on FAQ’S button");

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on FAQ’S button");
        }
    }

    /**
     * Check  FAQ’S screen is displayed
     */
    @Override
    public void checkFAQSScreenIsDisplayed(){
        Logger.logAction("Checking FAQ’S screen is displayed");
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID("com.app.rehlat:id/webview_progress_bar");
//            String elementName = findElementByXpathAndReturnItsAttributeText(XPATH_OF_FAQS_NAME_IN_WEB_VIEW);
            if (isElementDisplayedByXPath("//android.view.View[@content-desc=\"FAQs\"]")){
                Logger.logStep("FAQ’S screen is displayed");
            }else {
                Logger.logError("FAQ's screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen title");
        }
    }

    /**
     * Tap on FAQ’S close button
     */
    @Override
    public void tapOnFAQSCloseButton(){
        Logger.logAction("Tapping on FAQ’S close button");
        try {
            findElementByIdAndClick("com.app.rehlat:id/back_webview");
            Logger.logComment("Tapped on back button in FAQ’S screen");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on FAQ’S close button");
        }
    }



                                                                            ///////////////////////////          CallCenter              /////////////////////////////


    /**
     * Tap on call support button
     */
    @Override
    public void tapOnCallCenterButton(){
        Logger.logAction("Tapping on call support button");
        try {
            findElementByIdAndClick("com.app.rehlat:id/call_support_llyt");
            Logger.logComment("Tapped on call support button");

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on call support button");
        }
    }

    /**
     * Check  FAQ’S screen is displayed
     */
    @Override
    public void checkCallCenterModalViewIsDisplayed(){
        Logger.logAction("Checking CallCenterModalView is displayed");
        try {
            tapOnAllowButtonInAllowPhoneCallsAlertIfDisplayed();
            runAppInBackground(2);
            if (isElementDisplayedById("com.app.rehlat:id/callUsListView") && isElementDisplayedById("com.app.rehlat:id/currency_back_btn")){
                Logger.logStep("CallCenter modal view is displayed");
            }else {
                Logger.logError("CallCenter modal view is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen title");
        }
    }

    /**
     * Check allow alert is displayed
     * @return
     */
    public static boolean isAllowPhoneCallsAlertDisplayed(){
        Logger.logAction("Checking allow phone calls alert is displayed");
        try {
            String alertName = findElementByIdAndReturnText("com.android.packageinstaller:id/permission_message");
            if (alertName == null){
                return false;
            }else if (alertName.equalsIgnoreCase("Allow Rehlat to make and manage phone calls?")){
                return true;
            } else {
                Logger.logError("Allow Phone calls permission alert is not displayed but some other alert type is displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the alert is displayed or not ?");
        }
        return false;
    }

    /**
     * Tap on Allow button in allow phone calls alert
     */
    public static void tapOnAllowButtonInAllowPhoneCallsAlertIfDisplayed(){
        Logger.logAction("Tapping on allow button in allow phone calls alert");
        try {
            if (isAllowPhoneCallsAlertDisplayed()){
                Logger.logComment("Allow Phone calls permission alert is displayed and going to tap on allow button");
                findElementByIdAndClick("com.android.packageinstaller:id/permission_allow_button");
                Logger.logComment("Tapped on allow button in the allow phone call alert");
            }else {
                Logger.logWarning("Allow phone calls permission alert is not displayed ");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on allow button in allow phone call alert");
        }
    }

    /**
     * Tap on FAQ’S close button
     */
    @Override
    public void tapOnCallCenterModalViewCloseButton(){
        Logger.logAction("Tapping on CallCenterModalView close button");
        try {
            findElementByIdAndClick("com.app.rehlat:id/currency_back_btn");
            Logger.logComment("Tapped on CallCenterModalView close button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on CallCenterModalView close button");
        }
    }
}
