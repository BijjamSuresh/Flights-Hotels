package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.flights.Labels_Flights.CURRENT_USER_COUNTRY_NAME;

public class VerifyCallCenterModalViewIsDisplayedAfterTappingOnCallSupportOption extends BaseTest {
    @Test
    public void testVerifyCallCenterModalViewIsDisplayedAfterTappingOnCallSupportOption() throws Exception{
        Logger.beginTest("Verify call center modal view is displayed after tapping on call support option");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnTwentyFourBarSevenOptionInSubMenuList();
        AppSupportScreen.checkSupportScreenIsDisplayed();
        AppSupportScreen.tapOnCallCenterButton();
        AppSupportScreen.checkCallCenterModalViewIsDisplayed();
        Logger.endTest("Verify call center modal view is displayed after tapping on call support option");
    }
}
