package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIaAbleToCheckAllTheFieldsAreVisibleToUserInFlightsTab extends BaseTest {
    @Test
    public void testRLTC_32() throws Exception{
        Logger.beginTest("Verify user is able to check all the fields are visible to the user in flights tab");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.checkAllTheFieldsAreVisibleInFlightsTab();
        Logger.endTest("Verify user is able to check all the fields are visible to the user in flights tab");

    }
}
