package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyNewEmailWindowIsDisplayedTappingOnHelpUsImproveButton extends BaseTest {
    @Test
    public void testVerifyNewEmailWindowIsDisplayedTappingOnHelpUsImproveButton() throws Exception{
        Logger.beginTest("Verify new email window is displayed tapping on help us improve button");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkRateUsLayoutIsDisplayed();
        for (int starCount = 1 ; starCount<= 3; starCount++){
            MenuScreen.tapOnStarNumber(starCount);
            MenuScreen.checkTheHelpUsButtonLabelIsChangedCorrectlyAsPerSelectedStarNumber(starCount);
            MenuScreen.tapOnHelpUsImproveButton();
            if (MenuScreen.isNewEmailWindowIsDisplayed()){
                MenuScreen.tapOnCancelButtonInNewEmailWindow();
                MenuScreen.tapOnDeleteDraftButtonInNewEmailWindow();
            }else {
                Logger.logError("New email window is not displayed");
            }
        }
        Logger.endTest("Verify new email window is displayed tapping on help us improve button");
    }
}
