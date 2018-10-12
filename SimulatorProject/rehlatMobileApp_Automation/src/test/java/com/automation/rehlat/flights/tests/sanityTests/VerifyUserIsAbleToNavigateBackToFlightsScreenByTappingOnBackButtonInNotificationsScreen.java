package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.flights.Labels_Flights.CURRENT_USER_COUNTRY_NAME;

public class VerifyUserIsAbleToNavigateBackToFlightsScreenByTappingOnBackButtonInNotificationsScreen extends BaseTest {
    @Test
    public void testVerifyUserIsAbleToNavigateBackToFlightsScreenByTappingOnBackButtonInNotificationsScreen() throws Exception{
        Logger.beginTest("Verify user is able to navigate bak to flights screen by tapping on back button in notifications screen");
//        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnNotificationsButton();
        NotificationsScreen.checkNotificationsScreenIsDisplayed();
        NotificationsScreen.tapOnBackButton();
        FlightsScreen.checkFlightsTabIsDisplayed();
        Logger.endTest("Verify user is able to navigate bak to flights screen by tapping on back button in notifications screen");
    }
}
