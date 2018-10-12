package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.flights.Labels_Flights.CURRENT_USER_COUNTRY_NAME;

public class VerifyUserIsAbleToNavigateBackFromPrivacyPolicyView extends BaseTest {
    @Test
    public void testVerifyUserIsAbleToNavigateBackFromPrivacyPolicyView() throws Exception{
        Logger.beginTest("Verify user is able to navigate back from privacy policy screen");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnPrivacyPolicyOption();
        PrivacyPolicyScreen.checkPrivacyPolicyScreenIsDisplayed();
        PrivacyPolicyScreen.tapOnBackButtonInPrivacyPolicyScreen();
        FlightsScreen.checkFlightsTabIsDisplayed();
        Logger.endTest("Verify user is able to navigate back from privacy policy screen");

    }
}
