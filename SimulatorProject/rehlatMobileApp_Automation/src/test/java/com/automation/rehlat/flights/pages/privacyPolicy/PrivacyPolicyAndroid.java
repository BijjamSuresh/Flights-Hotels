package com.automation.rehlat.flights.pages.privacyPolicy;

import com.automation.rehlat.flights.libCommon.Logger;

public class PrivacyPolicyAndroid extends PrivacyPolicyBase {

    public static final String XPATH_OF_PRIVACY_POLICY_NAME_IN_WEB_VIEW = "//android.view.View[@content-desc=\"Privacy Policy\"]";
    public static final String PRIVACY_POLICY = "Privacy Policy";
    public static final String BACK_BUTTON = "com.app.rehlat:id/back_webview";
    /**
     * Check the privacy policy screen is displayed
     * @return
     */
    @Override
    public void checkPrivacyPolicyScreenIsDisplayed(){
        Logger.logAction("Checking the privacy policy screen is displayed or not ?");
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID("com.app.rehlat:id/webview_progress_bar");
//            String elementName = findElementByXpathAndReturnItsAttributeText(XPATH_OF_PRIVACY_POLICY_NAME_IN_WEB_VIEW);
            if (isElementDisplayedByXPath(XPATH_OF_PRIVACY_POLICY_NAME_IN_WEB_VIEW)){
                Logger.logStep("Privacy policy screens is displayed");
            }else {
                Logger.logError("Privacy policy screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen tittle");
        }
    }

    /**
     * Tap on back button in the privacy policy screen
     */
    @Override
    public void tapOnBackButtonInPrivacyPolicyScreen(){
        Logger.logAction("Tapping on back button in the privacy policy screen");
        try {
            findElementByIdAndClick(BACK_BUTTON);
            Logger.logComment("Tapped on back button in the privacy policy screen");

        }catch (Exception exception){
            Logger.logError("Unable to tap on back button in privacy policy screen");
        }
    }
}
