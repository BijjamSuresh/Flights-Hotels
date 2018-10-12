package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIaAbleToChangeTheLocationFromEnglishToArabicAndViceVersaSuccessfully extends BaseTest {

    @Test
    public void testRLTC_28() throws Exception{
        Logger.beginTest("Verify user is able to change the localization from english to arabic and vice versa successfully");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnArabicInSubMenuButton();
        String appCurrentLocalization = FlightsScreen.checkAppLocalizationInFlightsTab();
        if (appCurrentLocalization.equalsIgnoreCase(Labels_Flights.ARABIC_LANGUAGE)){
            Logger.logStep("App localization is changed to Arabic");
        }else {
            Logger.logError("App localization is not changed to Arabic");
        }
        FlightsScreen.tapOnMenuButton();
        MenuScreen.tapOnEnglishInSubMenuButton();
        String appUpdatedLocalization = FlightsScreen.checkAppLocalizationInFlightsTab();
        if (appUpdatedLocalization.equalsIgnoreCase(Labels_Flights.ENGLISH_LANGUAGE)){
            Logger.logStep("App localization is changed to English");
        }else {
            Logger.logError("App localization is not changed to English");
        }
        Logger.endTest("Verify user is able to change the localization from english to arabic and vice versa successfully");
    }
}
