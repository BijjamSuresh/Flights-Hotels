package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyMenuScreenIsDisplayedWithAllTheRequiredOptions extends BaseTest {
    @Test
    public void  testRLTC_6() throws Exception{
        Logger.beginTest("Verify menu screen is displayed with all the required options");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkAllTheSubMenuOptionsAreDisplayed();
        Logger.endTest("Verify menu screen is displayed with all the required options");
    }
}
