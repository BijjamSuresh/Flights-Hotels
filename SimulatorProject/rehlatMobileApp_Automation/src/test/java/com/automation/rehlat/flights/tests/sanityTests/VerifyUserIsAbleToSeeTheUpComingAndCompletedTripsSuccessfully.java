package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIsAbleToSeeTheUpComingAndCompletedTripsSuccessfully extends BaseTest {
    @Test
    public void testRLTC_26() throws Exception{
        Logger.beginTest("Verify user is able to see the upcoming and completed trips successfully");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        if (!MenuScreen.isUserSignedIn()){
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.checkSignInScreenIsDisplayed();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
            MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels_Flights.EMAIL_ID_SIGN_IN);
        }
        MenuScreen.tapOnMyTripsSubMenuButton();
        MyTripsScreen.checkMyTripsScreenIsDisplayed();
        MyTripsScreen.tapOnFlightsButton();
        MyTripsScreen.tapOnUpcomingButton();
        MyTripsScreen.checkUpcomingFlightsTravelInformationIsDisplayed();
        MyTripsScreen.tapOnCompletedButton();
        MyTripsScreen.checkCompletedFlightsTravelInformationIsDisplayed();
        Logger.endTest("Verify user is able to see the upcoming and completed trips successfully");

    }
}
