package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyReferAndEarnScreenIsDisplayedByTappingOnReferAndEarnButtonInKaramScreen extends BaseTest {
    @Test
    public void testVerifyReferAndEarnScreenIsDisplayedByTappingOnReferAndEarnButtonInKaramScreen() throws Exception{
        Logger.beginTest("Verify refer and earn screen is displayed by tapping on refer and earn button in karam screen");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (!MenuScreen.isUserSignedIn()){
            Logger.logComment("User is already logged in. so going to signed out from that account and signed with new account");
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.checkSignInScreenIsDisplayed();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
        }else {
            MenuScreen.navigateToFlightsTab();
        }
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnKaramTab();
        KaramScreen.checkKaramScreenIsDisplayed();
        KaramScreen.tapOnReferAndEarnButton(); // Todo:- refer and earn button name will be changes as per domain, currently hardcoded the button name as for KUWAIT domain. When the script is not for kuwait then edit button name
        ReferYourFriendsScreen.checkReferYourFriendsScreenIsDisplayed();
        Logger.endTest("Verify refer and earn screen is displayed by tapping on refer and earn button in karam screen");

    }
}
