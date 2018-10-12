package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyHelpUsImproveButtonIsDisplayedUntilTheStarRatingIsLessThanOrEqualToThree extends BaseTest {
    @Test
    public void testVerifyHelpUsImproveButtonIsDisplayedUntilTheStarRatingIsLessThanOrEqualToThree() throws Exception{
        Logger.beginTest(" Verify help us improve button is displayed until the star rating is less than or equal to three");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkRateUsLayoutIsDisplayed();
        for (int starCount = 1 ; starCount<= 3; starCount++){
            MenuScreen.tapOnStarNumber(starCount);
            MenuScreen.checkTheHelpUsButtonLabelIsChangedCorrectlyAsPerSelectedStarNumber(starCount);
        }
        Logger.endTest(" Verify help us improve button is displayed until the star rating is less than or equal to three");

    }
}
