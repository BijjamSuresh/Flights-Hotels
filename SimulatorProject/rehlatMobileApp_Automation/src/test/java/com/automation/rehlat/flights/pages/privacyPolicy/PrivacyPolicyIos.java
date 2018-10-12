package com.automation.rehlat.flights.pages.privacyPolicy;

import com.automation.rehlat.flights.libCommon.Logger;

public class PrivacyPolicyIos extends PrivacyPolicyBase {
    public static final String XPATH_OF_WEB_VIEW_PRIVACY_POLICY_SCREEN = "//XCUIElementTypeOther[@name=\"Privacy Policy | Rehlat\"]";
    public static final String URL_STOP_BUTTON = "StopButton";

    /**
     * Check the privacy policy screen is displayed
     *
     * @return
     */
    @Override
    public void checkPrivacyPolicyScreenIsDisplayed() {
        Logger.logAction("Checking the privacy policy screen is displayed or not ?");
        try {
            waitForAnElementToDisappear_ByName(URL_STOP_BUTTON);
            if (isElementEnabledByXpath(XPATH_OF_WEB_VIEW_PRIVACY_POLICY_SCREEN)) {
                Logger.logStep("Privacy policy screens is displayed");
            } else {
                Logger.logError("Privacy policy screen is not displayed");
            }
        } catch (Exception exception) {
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
            RateUsScreen.tapOnReturnToRehlatButtonInStoreScreen();
        }catch (Exception exception){
            Logger.logError("Unable to tap on back button in privacy policy screen");
        }
    }
}
