package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyRateUsOnAppStoreButtonIsDisplayedWhenTheStarRatingIsGreaterThanThree extends BaseTest {
    @Test
    public void  testVerifyRateUsOnAppStoreButtonIsDisplayedWhenTheStarRatingIsGreaterThanThree() throws Exception{
        Logger.beginTest("Verify rate us on app store button is displayed When the star rating is greater than three");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkRateUsLayoutIsDisplayed();
        for (int starCount = 4 ; starCount<= 5; starCount++){
            MenuScreen.tapOnStarNumber(starCount);
            MenuScreen.checkTheHelpUsButtonLabelIsChangedCorrectlyAsPerSelectedStarNumber(starCount);
        }
        Logger.endTest("Verify rate us on app store button is displayed When the star rating is greater than three");

    }
}
