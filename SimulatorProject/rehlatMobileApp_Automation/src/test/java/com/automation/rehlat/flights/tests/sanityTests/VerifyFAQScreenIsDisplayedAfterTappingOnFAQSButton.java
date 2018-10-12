package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;
import static com.automation.rehlat.flights.Labels_Flights.CURRENT_USER_COUNTRY_NAME;

public class VerifyFAQScreenIsDisplayedAfterTappingOnFAQSButton extends BaseTest {
    @Test
    public void testVerifyFAQScreenIsDisplayedAfterTappingOnFAQSButton() throws Exception{
        Logger.beginTest("Verify FAQ's screen is displayed after tapping on FAQ's button");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnTwentyFourBarSevenOptionInSubMenuList();
        AppSupportScreen.checkSupportScreenIsDisplayed();
        AppSupportScreen.tapOnFAQSButton();
        AppSupportScreen.checkFAQSScreenIsDisplayed();
        Logger.endTest("Verify FAQ's screen is displayed after tapping on FAQ's button");

    }
}
