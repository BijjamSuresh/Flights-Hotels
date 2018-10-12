package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifySignInScreenIsDisplayedAfterTappingOnKaramTabWhenUserIsNotSignedIn extends BaseTest {
    @Test
    public void testVerifySignInScreenIsDisplayedAfterTappingOnKaramTabWhenUserIsNotSignedIn() throws Exception{
        Logger.beginTest("Verify sign in screen is displayed after tapping on karam tab when user is not signed in");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (MenuScreen.isUserSignedIn()){
            Logger.logComment("User is already logged in. so going to signed out from that account and signed with new account");
            MenuScreen.tapOnLogoutButton();
        }else {
            MenuScreen.navigateToFlightsTab();
        }
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnKaramTab();
        SignInScreen.checkSignInScreenIsDisplayed();
        Logger.endTest("Verify sign in screen is displayed after tapping on karam tab when user is not signed in");


    }
}
