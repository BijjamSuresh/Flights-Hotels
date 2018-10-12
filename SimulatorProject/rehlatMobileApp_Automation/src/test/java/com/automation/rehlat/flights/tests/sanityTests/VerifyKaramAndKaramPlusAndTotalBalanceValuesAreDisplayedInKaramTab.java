package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyKaramAndKaramPlusAndTotalBalanceValuesAreDisplayedInKaramTab extends BaseTest {
    @Test
    public void testVerifyKaramAndKaramPlusAndTotalBalanceValuesAreDisplayedInKaramTab() throws Exception{
        Logger.beginTest("verify karam, karam plus and total balance values are displayed in the karam tab");
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
        KaramScreen.checkTheTotalKaramBalanceIsDisplayed();
        KaramScreen.checkTheKaramValueIsDisplayed();
        KaramScreen.checkTheKaramPlusValueIsDisplayed();
        Logger.endTest("verify karam, karam plus and total balance values are displayed in the karam tab");

    }
}
