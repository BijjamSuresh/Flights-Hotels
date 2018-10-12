package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyStoreAppIsDisplayedAfterTappingOnRateUsOnStoreButton extends BaseTest {
    @Test
    public void testVerifyStoreAppIsDisplayedAfterTappingOnRateUsOnStoreButton() throws Exception{
        Logger.beginTest("Verify store app is displayed after tapping on rate us on store button");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkRateUsLayoutIsDisplayed();
        for (int starCount = 4 ; starCount<= 5; starCount++){
            MenuScreen.tapOnStarNumber(starCount);
            MenuScreen.checkTheHelpUsButtonLabelIsChangedCorrectlyAsPerSelectedStarNumber(starCount);
            MenuScreen.tapOnRateUsInStoreButton();
            RateUsScreen.checkRespectedOsStoreScreenIsDisplayed();
            RateUsScreen.tapOnReturnToRehlatButtonInStoreScreen();
        }
        Logger.endTest("Verify store app is displayed after tapping on rate us on store button");
    }
}
