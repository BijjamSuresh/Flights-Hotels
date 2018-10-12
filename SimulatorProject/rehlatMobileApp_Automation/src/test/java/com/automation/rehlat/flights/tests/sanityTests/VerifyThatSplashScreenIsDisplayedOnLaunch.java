package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyThatSplashScreenIsDisplayedOnLaunch extends BaseTest {
    @Test
    public void  testRLTC_2() throws Exception{
        Logger.beginTest("Verify that splash screen is displayed on launch");
        General.reInstallApp();
        General.launchApp();
        checkAndWaitTillTheSplashScreenIsInvisible();
        Logger.endTest("Verify that splash screen is displayed on launch");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
    }
}
