package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyUserLocationCountryNameIsDisplayedInFifthPlaceOfSelectCountryLayout extends BaseTest {
    @Test
    public void  testRLTC_3() throws Exception{
        Logger.beginTest("Verify user location country name is displayed in the fifth place of select country layout");
        reInstallApp();
        General.launchApp();
        General.acceptTheLocationAccessAlert();
        General.acceptTheNotificationAccessAlert();
        if(FlightsScreen.isSelectLanguageModalIsDisplayed()){
            String nameOfTheLastCountryNameInSelectCountryLayout = FlightsScreen.getTheLastPositionCountryNameInSelectCountryLayout();
            if (nameOfTheLastCountryNameInSelectCountryLayout.equalsIgnoreCase(Labels_Flights.INDIA_LANGUAGE_COUNTRY_LABEL)){
                Logger.logStep("User location country name is displayed in correct position in select language modal layout ");
            }else {
                Logger.logError("User location country name is displayed in incorrect position in select language modal layout ");
            }
        }else {
            Logger.logError("Select country layout is not displayed in the current active screen");
        }
        Logger.endTest("Verify user location country name is displayed in the fourth place of select country layout");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
    }
}
