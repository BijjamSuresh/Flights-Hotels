package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class VerifyOtherIsDisplayedAsCountryLabelWhenUserDeclineTheLocationAccessAlert extends BaseTest {
    @Test
    public void  testRLTC_5() throws Exception{
        Logger.beginTest("Verify other is displayed as country label when user decline the location access alert");
        reInstallApp();
        General.launchApp();
        checkAndWaitTillTheSplashScreenIsInvisible();
        General.declineTheLocationAccessAlert();
        General.acceptTheNotificationAccessAlert();
        if(FlightsScreen.isSelectLanguageModalIsDisplayed()){
            String nameOfTheLastCountryNameInSelectCountryLayout = FlightsScreen.getTheLastPositionCountryNameInSelectCountryLayout();
            if (nameOfTheLastCountryNameInSelectCountryLayout.equalsIgnoreCase(Labels_Flights.OTHERS_COUNTRY_LABEL)){
                Logger.logStep("Other country name is displayed in correct position");
            }else {
                Logger.logError("Other country name is displayed in incorrect position");
            }
        }else {
            Logger.logError("Select country layout is not displayed in the current active screen");
        }
        Logger.endTest("Verify other is displayed as country label when user decline the location access alert");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME);
    }
}
