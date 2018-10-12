package com.automation.rehlat.flights.tests.sanityTests;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.flights.Labels_Flights.*;

public class VerifyUserIsAbleToSwipeTheCityNamesByTappingOnSwapButton extends BaseTest {
    public static final String FROM_COUNTRY_NAME_WITH_CODE = "KWI - Kuwait , Kuwait";
    public static final String TO_COUNTRY_NAME_WITH_CODE = "CAI - Cairo , Egypt";

    @Test
    public void testVerifyUserIsAbleToSwipeTheCityNamesByTappingOnSwapButton() throws Exception{
        Logger.beginTest("Verify user is able to swipe the city names by tapping on swap button");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnFromTextField();
        FlightsScreen.checkSearchViewScreenIsDisplayed();
        FlightsScreen.checkKeyboardIsDisplayed();
        FlightsScreen.enterAirportName(FROM_INTERNATIONAL_AIRPORT_NAME);
        FlightsScreen.selectAirportCodeFromSearchResults(FROM_INTERNATIONAL_AIRPORT_CODE);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnToTextField();
        FlightsScreen.checkSearchViewScreenIsDisplayed();
        FlightsScreen.checkKeyboardIsDisplayed();
        FlightsScreen.enterAirportName(TO_INTERNATIONAL_AIRPORT_NAME);
        FlightsScreen.selectAirportCodeFromSearchResults(TO_INTERNATIONAL_AIRPORT_CODE);
        FlightsScreen.checkFlightsTabIsDisplayed();
        if (platform.equals(Labels_Flights.IOS)){
            Integer[] fromAirportLocationBeforeSwap = FlightsScreen.getTheLocationOfFromAirPortName(FROM_COUNTRY_NAME_WITH_CODE);
            Integer[] toAirportLocationBeforeSwap = FlightsScreen.getTheLocationOfToAirPortName(TO_COUNTRY_NAME_WITH_CODE);
            FlightsScreen.tapOnSwapButton();
            Integer[] fromAirportLocationAfterSwap = FlightsScreen.getTheLocationOfFromAirPortName(TO_COUNTRY_NAME_WITH_CODE);
            Integer[] toAirportLocationAfterSwap = FlightsScreen.getTheLocationOfToAirPortName(FROM_COUNTRY_NAME_WITH_CODE);
            if (fromAirportLocationBeforeSwap[0] == fromAirportLocationAfterSwap[0] || fromAirportLocationBeforeSwap[1] == fromAirportLocationAfterSwap[1]){
                if (toAirportLocationBeforeSwap[0] == toAirportLocationAfterSwap[0] || toAirportLocationBeforeSwap[1] == toAirportLocationAfterSwap[1]){
                    Logger.logStep("From and to airport names are swapped correctly");
                }else {
                    Logger.logError("To airport names are not swapped correctly");
                }
            }else {
                Logger.logError("From airport names are not swapped correctly");
            }
        }else if (platform.equals(Labels_Flights.ANDROID)){
            String fromAirportNameBeforeSwap = FlightsScreen.getTheFromAirportName();
            String toAirportNameBeforeSwap = FlightsScreen.getTheToAirportName();
            FlightsScreen.tapOnSwapButton();
            String fromAirportNameAfterSwap = FlightsScreen.getTheFromAirportName();
            String toAirportNameAfterSwap = FlightsScreen.getTheToAirportName();
            if (fromAirportNameBeforeSwap.equalsIgnoreCase(toAirportNameAfterSwap) && toAirportNameBeforeSwap.equalsIgnoreCase(fromAirportNameAfterSwap)){
                Logger.logStep("From and to airport names are swapped correctly");
            }else {
                Logger.logError("From and To airport names are not swapped correctly");
            }
        }else {
            Logger.logError("Current testing device OS is neither android nor iOS");
        }
        Logger.endTest("Verify user is able to swipe the city names by tapping on swap button");
    }
}
