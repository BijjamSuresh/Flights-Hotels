package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.flights.Labels_Flights.CURRENT_USER_COUNTRY_NAME;

public class VerifyUserIsAbleToNavigateBackFromNewEmailWindowToAppSupportScreen extends BaseTest {
    @Test
    public void testVerifyUserIsAbleToNavigateBackFromNewEmailWindowToAppSupportScreen() throws Exception{
        Logger.beginTest("Verify user is able to navigate back from new email window to app support screen");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnTwentyFourBarSevenOptionInSubMenuList();
        AppSupportScreen.checkSupportScreenIsDisplayed();
        AppSupportScreen.tapOnMailUsButton();
        if (AppSupportScreen.isNewEmailWindowIsDisplayed()){
            AppSupportScreen.tapOnCancelButtonInNewEmailWindow();
            AppSupportScreen.tapOnDeleteDraftButtonInNewEmailWindow();
            AppSupportScreen.checkSupportScreenIsDisplayed();
        }else {
            Logger.logError("New email window is not displayed");
        }
        Logger.endTest("Verify user is able to navigate back from new email window to app support screen");

    }
}
