package com.automation.rehlat.flights.pages.flightsSearchResults;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;

public class FlightsSearchResultsIos extends FlightsSearchResultsBase {

    public static final String SRP_ONE_WAY_VIEW = "SRPOneway";
    public static final String SRP_TWO_WAY_VIEW = "SRPRoundtrip";
    public static final String XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS = "(//XCUIElementTypeCell[@name=\"SRPLoaderCell\"])[1]";
    public static final String XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ROUND_TRIP_LOADED_SEARCH_RESULTS = "(//XCUIElementTypeStaticText[@name=\"SRPRoundTripPriceLabel\"])[";
    public static final String XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ONE_WAY_LOADED_SEARCH_RESULTS = "(//XCUIElementTypeStaticText[@name=\"SRPOnewayPriceLabel\"])[";
    public static final String XPATH_OF_FLIGHT_CELL_IN_ROUND_TRIP_LOADED_SEARCH_RESULTS = "(//XCUIElementTypeCell[@name=\"SRPRoundTripCell\"])[";
    public static final String XPATH_OF_FLIGHT_CELL_IN_ONE_WAY_LOADED_SEARCH_RESULTS = "(//XCUIElementTypeCell[@name=\"SRPOnewayCell\"])[";
    public static final String PRICE_LABEL = "Price";
    public static String XPATH_OF_PRICE_FLIGHT_CARD_VIEW ;
    public static String XPATH_OF_FLIGHT_CARD_VIEW_WITHOUT_INDEX ;




    /**
     * Check flights search results screen is displayed or not
     */
    @Override
    public void checkFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Checking the flights search results screen is displayed or not ?");
        try {
            if (TRIP_TYPE.equalsIgnoreCase(Labels_Flights.STRING_NULL)) {
                waitTillFlightsSearchResultsScreenIsDisplayed();
            }else {
                runAppInBackground(2);
            }
                if (isElementEnabledByName(PRICE_LABEL) && isElementDisplayedByAccessibilityId(SRP_ONE_WAY_VIEW))
                {
                    TRIP_TYPE = SRP_ONE_WAY_VIEW;
                    XPATH_OF_PRICE_FLIGHT_CARD_VIEW = XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ONE_WAY_LOADED_SEARCH_RESULTS;
                    XPATH_OF_FLIGHT_CARD_VIEW_WITHOUT_INDEX = XPATH_OF_FLIGHT_CELL_IN_ONE_WAY_LOADED_SEARCH_RESULTS;
                    Logger.logStep(" SRP One Way Flights search results screen is displayed and the results are loaded");
                } else if (isElementEnabledByName(PRICE_LABEL) && isElementDisplayedByAccessibilityId(SRP_TWO_WAY_VIEW)){
                    TRIP_TYPE = SRP_TWO_WAY_VIEW;
                    XPATH_OF_PRICE_FLIGHT_CARD_VIEW = XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ROUND_TRIP_LOADED_SEARCH_RESULTS;
                    XPATH_OF_FLIGHT_CARD_VIEW_WITHOUT_INDEX = XPATH_OF_FLIGHT_CELL_IN_ROUND_TRIP_LOADED_SEARCH_RESULTS;
                    Logger.logStep("SRP Two Way Flights search results screen is displayed");
                }
                else {
                    Logger.logError("Flights search screen is not displayed and the results are loaded");
                }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to check the current active screen name");
        }
    }


    /**
     * Wait till the flights search results screen is displayed
     * @return
     */
    public static void waitTillFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Waiting till the active screen is loaded");
        try{
            if (isElementDisplayedByAccessibilityId(SRP_ONE_WAY_VIEW)){
                try
                {
                    if (isElementDisplayedByXPath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)){
                        Logger.logStep("SRP screen is displayed with one way view and waiting for the flights information to be loaded.....,");
                        try {
                            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                        }catch (Exception exceptionTwo){
                            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ONE_WAY_LOADED_SEARCH_RESULTS+1+"]")));
                        }
                    }else {
                        Logger.logStep("Active screen is loaded and moving to check the screen name");
                    }
                }catch (Exception exception){
                    try {
                        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                    }catch (Exception exceptionTwo){
                        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ONE_WAY_LOADED_SEARCH_RESULTS+1+"]")));
                    }
                }
            }else if (isElementDisplayedByAccessibilityId(SRP_TWO_WAY_VIEW)){
                try
                {
                if (isElementDisplayedByXPath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)){
                    Logger.logStep("SRP screen is displayed with two way view and waiting for the flights information to be loaded.....,");
                    try {
                        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                    }catch (Exception exceptionTwo){
                        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ROUND_TRIP_LOADED_SEARCH_RESULTS+1+"]")));
                    }
                }else {
                    Logger.logStep("Active screen is loaded and moving to check the screen name");
                }
                }catch (Exception exception){
                    try {
                        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_IN_LOADING_SEARCH_RESULTS)));
                    }catch (Exception exceptionTwo){
                        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL_PRICE_IN_ROUND_TRIP_LOADED_SEARCH_RESULTS+1+"]")));
                    }
                }
            }else {
                Logger.logError("Current booking type is not an domestic nor international");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to find the visibility of an element");
        }
    }

    /**
     * Tap on a cell in the flights search results screen
     */
    @Override
    public void tapOnACellInFlightSearchResults(String flightSearchResultCellNumber) {
        Logger.logAction("Tapping on "+ flightSearchResultCellNumber + " cell in the flights search results screen");
        String xPathOfBookingFlightCellType = XPATH_OF_PRICE_FLIGHT_CARD_VIEW+ flightSearchResultCellNumber + "]";
        try{
            //This logic is to find the parsing element by scrolling to the element and if displayed then immediately tap on it else throws error
//            scrollToAnElementByXPath(xPathOfBookingFlightCellType,true);
            getTheBookingCostOfSelectingFlightInSearchResultsAndTapOnIt(flightSearchResultCellNumber);
//            findElementByXPathAndClick(xPathOfBookingFlightCellType);
            // Logic ends here

            //Todo: - Below code is very important on tapping on the flight cell more than 2..,For to reduce the execution time implemented the above logic is implemented
            // The below logic is find the parsing flight cell number is displayed and if displayed and then search for the element and tap on it else scroll to the element and then check the element is displayed and if displayed find the element and tap on it else throw error
//            if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
//                getTheBookingCostOfSelectingFlightInSearchResults(flightSearchResultCellNumber);
//                Logger.logComment(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
//                driver.findElementByXPath(xPathOfBookingFlightCellType).click();
//                Logger.logStep("Tapped on "+flightSearchResultCellNumber+" flight cell");
//            }else{
//                scrollToAnElementByXPath(xPathOfBookingFlightCellType,true);
//                if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
//                    getTheBookingCostOfSelectingFlightInSearchResults(flightSearchResultCellNumber);
//                    Logger.logComment(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
//                    driver.findElementByXPath(xPathOfBookingFlightCellType).click();
//                    Logger.logStep("Tapped on "+flightSearchResultCellNumber+" flight cell");
//                }else {
//                    Logger.logError(flightSearchResultCellNumber+" - cell number is not displayed in the search results screen");
//                }
//            }
            // Logic ends here

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the "+ flightSearchResultCellNumber + "cell in Flights search results");

        }
    }

    /**
     * Get the booking cost of selecting flight in search results screen
     * @param selectedFlightCellTypeNumber
     * @return
     */
    public static String getTheBookingCostOfSelectingFlightInSearchResultsAndTapOnIt(String selectedFlightCellTypeNumber) {
        Logger.logAction("Getting the booking cost of "+selectedFlightCellTypeNumber+" flight in search results");
        String xPathOfBookingFlightCellType = XPATH_OF_PRICE_FLIGHT_CARD_VIEW+ selectedFlightCellTypeNumber + "]";
        WebElement bookingFlightCell = null;
        try{
            Logger.logComment("Selecting flights cell is displayed in the current search results and moving forward to get the booking seat cost of selected flight");
            if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                bookingFlightCell = driver.findElementByXPath(xPathOfBookingFlightCellType);
                Logger.logComment("Flight cell number - "+selectedFlightCellTypeNumber+" is displayed");
            }else {
                Logger.logError("SRP results are not loaded with all the elements");
            }
            String flightCellTypeText = bookingFlightCell.getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
            if (flightCellTypeText.contains(Labels_Flights.CURRENT_USER_CURRENCY_TYPE)){
                String bookingCostExcludingCurrencyName = flightCellTypeText.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE+ Labels_Flights.ONE_CHARACTER_SPACE, Labels_Flights.STRING_NULL).trim();
                if (bookingCostExcludingCurrencyName.contains(Labels_Flights.STRING_COMMA)){
                    String actualAmountWithoutComma = bookingCostExcludingCurrencyName.replace(Labels_Flights.STRING_COMMA, Labels_Flights.STRING_NULL);
                    Labels_Flights.SELECTED_SEAT_BOOKING_COST = actualAmountWithoutComma;
                    Logger.logComment("Booking cost of the flight cell number - " +selectedFlightCellTypeNumber + " and with complete index " + flightCellTypeText + " is :- " + Labels_Flights.SELECTED_SEAT_BOOKING_COST);
                    if(TRIP_TYPE == SRP_ONE_WAY_VIEW){
                        bookingFlightCell.click();
                        Logger.logStep("Tapped on flight cell number :- "+selectedFlightCellTypeNumber);
                    }else if (TRIP_TYPE == SRP_TWO_WAY_VIEW){
                        bookingFlightCell.click();
                        Logger.logStep("Tapped on flight cell number :- "+selectedFlightCellTypeNumber);
                    }
                    return  Labels_Flights.SELECTED_SEAT_BOOKING_COST;
                }else {
                    Labels_Flights.SELECTED_SEAT_BOOKING_COST = bookingCostExcludingCurrencyName;
                    Logger.logComment("Booking cost of the flight cell number - " +selectedFlightCellTypeNumber + " and with complete index " + flightCellTypeText + " is :- " + Labels_Flights.SELECTED_SEAT_BOOKING_COST);
                    if(TRIP_TYPE == SRP_ONE_WAY_VIEW){
                        bookingFlightCell.click();
                        Logger.logStep("Tapped on flight cell number :- "+selectedFlightCellTypeNumber);
                    }else if (TRIP_TYPE == SRP_TWO_WAY_VIEW){
                        bookingFlightCell.click();
                        Logger.logStep("Tapped on flight cell number :- "+selectedFlightCellTypeNumber);
                    }
                    return  Labels_Flights.SELECTED_SEAT_BOOKING_COST;
                }
            }else{
                Logger.logError("Flight currency type is incorrectly displaying .ie.., Instead of "+Labels_Flights.CURRENT_USER_CURRENCY_TYPE+" showing as :- "+flightCellTypeText);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to get the booking cost of first flight in search results");
        }
        return Labels_Flights.SELECTED_SEAT_BOOKING_COST;
    }

}
