package com.automation.rehlat.flights.pages.rateUs;

import com.automation.rehlat.flights.libCommon.Logger;

public class RateUsIos extends RateUsBase {
    public static final String APP_STORE_LABEL = "//XCUIElementTypeApplication[@name=\"App Store\"]";
    public static final String RETURN_TO_REHLAT_BACK_BUTTON = "Return to Rehlat";
    public static final String REHLAT_APP_NAME_IN_APP_STORE = "//XCUIElementTypeStaticText[@name=\"Rehlat - رحلات\"]";


    /**
     * Check app store screen is displayed
     */
    @Override
    public void checkRespectedOsStoreScreenIsDisplayed(){
        Logger.logAction("Check the app store screen is displayed");
        try {
            if (isElementDisplayedByXPath(APP_STORE_LABEL) && isElementDisplayedByXPath(REHLAT_APP_NAME_IN_APP_STORE)){
                Logger.logStep("App store screen is displayed");
            }else {
                Logger.logError("App store screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen title");
        }
    }

    /**
     * Tap on return to rehlat button in app store screen
      */
    @Override
    public void tapOnReturnToRehlatButtonInStoreScreen(){
        Logger.logAction("Tapping on back button in the app store screen");
        try {
            findElementByNameAndClick(RETURN_TO_REHLAT_BACK_BUTTON);
            Logger.logStep("Tapped on return to rehlat back button in the app store screen");
        }catch (Exception exception){
            Logger.logError("Encountered error:- unable to tap on the return rehlat button in app store screen ");
        }
    }
}
