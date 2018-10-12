package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyStarRatingNameIsDisplayedCorrectlyWithRespectToTheSelectedStar extends BaseTest {
    @Test
    public void testVerifyStarRatingNameIsDisplayedCorrectlyWithRespectToTheSelectedStar() throws Exception{
        Logger.beginTest("Verify star rating name is displayed correctly wit respect to the selected star");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkRateUsLayoutIsDisplayed();
        for (int starCount = 1 ; starCount<= 5; starCount++){
            MenuScreen.tapOnStarNumber(starCount);
            MenuScreen.checkTheSelectedStarNumberNameIsCorrectlyDisplayed(starCount);
        }
        Logger.endTest("Verify star rating name is displayed correctly wit respect to the selected star");
    }
}
