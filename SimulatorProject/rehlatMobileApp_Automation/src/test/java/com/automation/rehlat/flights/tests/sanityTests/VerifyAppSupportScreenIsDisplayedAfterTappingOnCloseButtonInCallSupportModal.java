package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.flights.Labels_Flights.CURRENT_USER_COUNTRY_NAME;

public class VerifyAppSupportScreenIsDisplayedAfterTappingOnCloseButtonInCallSupportModal extends BaseTest {
    @Test
    public void testVerifyAppSupportScreenIsDisplayedAfterTappingOnCloseButtonInCallSupportModal() throws Exception{
        Logger.beginTest("Verify app support screen is displayed after tapping on close button in call support modal");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnTwentyFourBarSevenOptionInSubMenuList();
        AppSupportScreen.checkSupportScreenIsDisplayed();
        AppSupportScreen.tapOnCallCenterButton();
        AppSupportScreen.checkCallCenterModalViewIsDisplayed();
        AppSupportScreen.tapOnCallCenterModalViewCloseButton();
        AppSupportScreen.checkSupportScreenIsDisplayed();
        Logger.endTest("Verify app support screen is displayed after tapping on close button in call support modal");
    }
}
