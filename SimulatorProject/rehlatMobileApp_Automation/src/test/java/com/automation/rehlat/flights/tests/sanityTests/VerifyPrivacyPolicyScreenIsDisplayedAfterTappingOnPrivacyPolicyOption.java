package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.flights.Labels_Flights.CURRENT_USER_COUNTRY_NAME;

public class VerifyPrivacyPolicyScreenIsDisplayedAfterTappingOnPrivacyPolicyOption extends BaseTest {
    @Test
    public void testVerifyPrivacyPolicyScreenIsDisplayedAfterTappingOnPrivacyPolicyOption() throws Exception{
        Logger.beginTest("Verify privacy policy screen is displayed after tapping on privacy policy option in menu screen");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnPrivacyPolicyOption();
        PrivacyPolicyScreen.checkPrivacyPolicyScreenIsDisplayed();
        Logger.endTest("Verify privacy policy screen is displayed after tapping on privacy policy option in menu screen");

    }
}
