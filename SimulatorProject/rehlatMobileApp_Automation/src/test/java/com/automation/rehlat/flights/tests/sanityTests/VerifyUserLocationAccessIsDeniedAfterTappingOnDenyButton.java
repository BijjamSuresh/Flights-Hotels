package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyUserLocationAccessIsDeniedAfterTappingOnDenyButton extends BaseTest {
    @Test
    public void  testRLTC_4() throws Exception{
        Logger.beginTest("Verify user location access is denied after tapping on deny button");
        reInstallApp();
        General.launchApp();
        General.declineTheLocationAccessAlert();
        Logger.endTest("Verify user location access is denied after tapping on deny button");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        Logger.logStep("User location access is denied after tapping on deny button in the notification access alert");
        Logger.endTest("Verify user location access is denied after tapping on deny button");

    }
}
