package com.automation.rehlat.flights.pages.appSupport;


import com.automation.rehlat.flights.libCommon.Logger;

public class AppSupportIos extends AppSupportBase {

    /**
     * Check the support screen is displayed
     */
    @Override
    public void checkSupportScreenIsDisplayed(){
        Logger.logAction("Checking the support screen is displayed");
        try {
            if (isElementDisplayedByAccessibilityId("Rehlat 24X 7 Support")){
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
            findElementByNameAndClick("Mail Us");
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
            if (isCouldNotSendEmailAlertIsDisplayed()){
                Logger.logComment("Email set up is not done in the device");
                closeCouldNotSendEmailAlert();
                if (isNoMailAccountsAlertIsDisplayed()){
                    closeNoMailAccountsAlert();
                    return false;
                }else {
                    Logger.logWarning("No mails account alert is not displayed");
                }
            }else if (isElementDisplayedByName("New Message") && isElementDisplayedByName("Send") && isElementEnabledByName("To:"))
            {
                Logger.logStep("New email window is displayed");
                return true;
            }else {
                Logger.logError("Could not check the displayed screen type");
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
                findElementByNameAndClick("Send");
                Logger.logComment("Tapped on email send button");
                if (isElementDisplayedByName("Send") || isElementDisplayedByName("Empty Subject")){
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
    public static boolean isCouldNotSendEmailAlertIsDisplayed(){
        Logger.logAction("Checking Could not send email alert is displayed or not ?");
        try {
            if (isElementDisplayedByName("Could Not Send Email")){
                Logger.logComment("Could not send email alert is displayed");
                return true;
            }else {
                Logger.logWarning("Could not send email alert is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the alert is displayed or not");
        }
        return false;
    }


    /**
     * Close could not send email alert by tapping on OK button
     */
    public static void closeCouldNotSendEmailAlert(){
        Logger.logAction("Closing Could not send email alert ");
        try {
            findElementByNameAndClick("OK");
            Logger.logComment("Closed the alert by tapping on OK button in the alert");
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to close the alert");
        }
    }

    /**
     * Check the no mail alert is displayed
     */
    public static boolean isNoMailAccountsAlertIsDisplayed(){
        Logger.logAction("Checking no mail alert is displayed or not ?");
        try {
            if (isElementDisplayedByName("No Mail Accounts")){
                Logger.logComment("No email alert is displayed");
                return true;
            }else {
                Logger.logWarning("No mail alert is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the alert is displayed or not");
        }
        return false;
    }


    /**
     * Close no mail alert by tapping on OK button
     */
    public static void closeNoMailAccountsAlert(){
        Logger.logAction("Closing no mail alert");
        try {
            findElementByNameAndClick("OK");
            Logger.logComment("Closed the alert by tapping on OK button in the alert");
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to close the alert");
        }
    }

    /**
     * Tap on cancel button in new email window
     */
    @Override
    public void tapOnCancelButtonInNewEmailWindow(){
        Logger.logAction("Tapping on cancel button in new email window");
        try {
            if (isNewEmailWindowIsDisplayed()){
                findElementByNameAndClick("Cancel");
                Logger.logComment("Tapped on cancel button");
            }else {
                Logger.logError("New Email window is not displayed");
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
            findElementByNameAndClick("Delete Draft");
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
            findElementByNameAndClick("FAQ’S");
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
            if (isElementDisplayedByName("crossButton") || isElementDisplayedByName("Rehlat")){ // Todo:- Check with unique elements as right know white screen is displaying
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
            findElementByNameAndClick("crossButton");
            Logger.logComment("Tapped on FAQ’S close button");
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
            findElementByNameAndClick("Call Support");
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
            if (isElementDisplayedByName("all screens cancel icon") && isElementDisplayedByName("Call Support")){
                Logger.logStep("CallCenter modal view is displayed");
            }else {
                Logger.logError("CallCenter modal view is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen title");
        }
    }

    /**
     * Tap on FAQ’S close button
     */
    @Override
    public void tapOnCallCenterModalViewCloseButton(){
        Logger.logAction("Tapping on CallCenterModalView close button");
        try {
            findElementByNameAndClick("all screens cancel icon");
            Logger.logComment("Tapped on CallCenterModalView close button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on CallCenterModalView close button");
        }
    }


}
