package com.automation.rehlat.flights.pages.rateUs;

import com.automation.rehlat.flights.libCommon.Logger;

public class RateUsAndroid extends RateUsBase {
    public static final String GOOGLE_PLAY_SEARCH_BUTTON = "Search Google Play";

    /**
     * Check play store screen is displayed
     */
    @Override
    public void checkRespectedOsStoreScreenIsDisplayed(){
        Logger.logAction("Check the play store screen is displayed");
        try {
            if (isElementDisplayedByAccessibilityId(GOOGLE_PLAY_SEARCH_BUTTON)){
                Logger.logStep("Google play store screen is displayed");
            }else {
                Logger.logError("Google play store screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen title");
        }
    }

    /**
     * Tap on return to rehlat button in play store screen
     */
    @Override
    public void tapOnReturnToRehlatButtonInStoreScreen(){
        Logger.logAction("Tapping on back button in the play store screen");
        try {
            driver.navigate().back();
            Logger.logComment("Tapped on device back button");
        }catch (Exception exception){
            Logger.logError("Encountered error:- unable to tap on the return rehlat button in play store screen ");
        }
    }
}
