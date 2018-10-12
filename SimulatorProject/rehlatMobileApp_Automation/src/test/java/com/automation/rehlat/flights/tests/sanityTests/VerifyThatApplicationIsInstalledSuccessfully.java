package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyThatApplicationIsInstalledSuccessfully extends BaseTest {
    @Test
    public void testRLTC_1() throws Exception {
        Logger.beginTest("Verify that application is installed successfully");
        reInstallApp();
        General.launchApp();
        Logger.endTest("Verify that application is installed successfully");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
    }
}
