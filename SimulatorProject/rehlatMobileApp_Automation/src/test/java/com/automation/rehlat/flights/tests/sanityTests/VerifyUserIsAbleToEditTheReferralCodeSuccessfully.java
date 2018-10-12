package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIsAbleToEditTheReferralCodeSuccessfully extends BaseTest {
    @Test
    public void  testRLTC_20() throws Exception{
        Logger.beginTest("Verify that user is able to edit the referral code successfully");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (!MenuScreen.isUserSignedIn()){
            Logger.logComment("User is not signed, referral code is only for signed in users. So going to sign in");
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
            MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels_Flights.EMAIL_ID_SIGN_IN);
        }
        MenuScreen.tapOnReferAndEarnIcon();
        ReferYourFriendsScreen.checkReferralCodeIsDisplayed();
        ReferYourFriendsScreen.editTheReferralCode();
        Logger.endTest("Verify that user is able to edit the referral code successfully");
    }
}
