package com.automation.rehlat.flights.pages.flightsSearchResults;


import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.automation.rehlat.flights.Labels_Flights.WAIT_TIME_MIN;

public class FlightsSearchResultsAndroid extends FlightsSearchResultsBase {
    public static final String ACTUAL_PRICE_RESOURCE_ID = "com.app.rehlat:id/international_price";
    public static final String XPATH_OF_CARD_VIEW_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.FrameLayout[";
    public static final String XPATH_OF_ONLY_DEPARTURE_CARD_PRICE_VIEW_WITHOUT_CARD_VIEW_XPATH = "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[3]";
    public static final String XPATH_OF_DEPARTURE_AND_RETURN_CARD_PRICE_VIEW_WITHOUT_CARD_VIEW_XPATH = "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]";
    public static final String TWO_WAY_LIST_VIEW = "com.app.rehlat:id/internationalTwoWayListView";
    public static final String DOMESTIC_ONE_WAY_RECYCLER_VIEW = "com.app.rehlat:id/domesticOneWayRecyclerView";
    public static final String SRP_LOADING_PROGRESS_BAR = "com.app.rehlat:id/progress";
    /**
     * Check flights search results screen is displayed or not
     */
    @Override
    public void checkFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Checking the flights search results screen is displayed or not");
        try {
            if (waitTillFlightsSearchResultsScreenIsDisplayed())
            {
                Logger.logStep("Flights search results screen is displayed");
            }else {
                Logger.logError("Flights search screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to check the current active screen name");
        }
    }


    /**
     * Wait till the flights search results screen is displayed
     * @return
     */
    public static boolean waitTillFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Waiting till the active screen is loaded");
        try{
            runAppInBackground(2); //Todo:- Discuss with the developer and find out the final solution
            if (isElementDisplayedById(SRP_LOADING_PROGRESS_BAR)){ driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(SRP_LOADING_PROGRESS_BAR)));
                Logger.logStep("Active screen is loaded and moving to check the screen name");
                return true;
            }else {
                Logger.logStep("Active screen is loaded and moving to check the screen name");
                return true;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the visibility of an element");
        }
        return false;
    }

    /**
     * Check the round trip details list view is displayed
     */
    public static boolean isRoundTripDetailsDisplayed() {
        Logger.logAction("Checking the round trip details is displayed");
        try {
            if (isElementDisplayedById(TWO_WAY_LIST_VIEW)){
                Logger.logComment("Two ways list view filters are displayed");
                return true;
            }else {
                Logger.logComment("One way list view filters are displayed");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the type of flight search results");
        }
        return false;
    }

    /**
     * Tap on first cell in the flights search results screen
     */
    @Override
    public void tapOnACellInFlightSearchResults(String flightSearchResultCellNumber) {
        Logger.logAction("Tapping on "+ flightSearchResultCellNumber + " cell in the flights search results screen");
        try{
            if (isRoundTripDetailsDisplayed()){
                if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                    Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                    getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(flightSearchResultCellNumber);
                    driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                }else{
                    scrollToTheParsingFlightBookingCard(flightSearchResultCellNumber,true);
                    if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                        Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                        getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(flightSearchResultCellNumber);
                        driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                    }else {
                        Logger.logError(flightSearchResultCellNumber+" - cell number is not displayed in the search results screen");
                    }
                }
            }else {
                Logger.logStep("One way trip details are displayed "); // This logger needs to be an error but to make the flow continue making this logger as comment
                if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                    Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                    getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(flightSearchResultCellNumber);
                    driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                }else{
                    scrollToTheParsingFlightBookingCard(flightSearchResultCellNumber,true);
                    if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                        Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                        getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(flightSearchResultCellNumber);
                        driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                    }else {
                        Logger.logError(flightSearchResultCellNumber+" - cell number is not displayed in the search results screen");
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the "+ flightSearchResultCellNumber + "cell in Flights search results");
        }
    }

    /**
     * Get the booking cost of selecting flight in search results screen
     * @param parsingFlightCellTypeNumber
     * @return
     */
    public static String getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(String parsingFlightCellTypeNumber) {
        Logger.logAction("Getting the booking cost of second flight in search results");
        try{
            scrollToTheParsingFlightBookingCard(parsingFlightCellTypeNumber,true);
            try{
                List<WebElement> priceLists = driver.findElementsById(ACTUAL_PRICE_RESOURCE_ID);
               String bookingCostOfParsingRoomNumber = String.valueOf(priceLists.get(Integer.parseInt(parsingFlightCellTypeNumber)));
                String bookingFlightPrice = bookingCostOfParsingRoomNumber.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE+ Labels_Flights.ONE_CHARACTER_SPACE, Labels_Flights.STRING_NULL).trim();
                if (bookingFlightPrice.contains(Labels_Flights.STRING_COMMA)){
                    String bookingFlightPriceWithoutComma = bookingFlightPrice.replace(Labels_Flights.STRING_COMMA,Labels_Flights.STRING_NULL);
                    Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPriceWithoutComma);
                    Labels_Flights.SELECTED_SEAT_BOOKING_COST = bookingFlightPriceWithoutComma;
                    return  Labels_Flights.SELECTED_SEAT_BOOKING_COST ;
                }else {
                    Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                    Labels_Flights.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                    return  Labels_Flights.SELECTED_SEAT_BOOKING_COST ;
                }
            }catch (Exception exception){
                scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(parsingFlightCellTypeNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking cost of first flight in search results");
        }
        return Labels_Flights.SELECTED_SEAT_BOOKING_COST;
    }

    /**
     * Get the booking cost of selecting flight in search results screen
     * @param parsingFlightCellTypeNumber
     * @return
     */
    public static String getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(String parsingFlightCellTypeNumber) {
        Logger.logAction("Getting the booking cost of first flight in search results");
        try{
            scrollToTheParsingFlightBookingCard(parsingFlightCellTypeNumber,true);
            try{
                List<WebElement> priceLists = driver.findElementsById(ACTUAL_PRICE_RESOURCE_ID);
                String bookingCostOfParsingRoomNumber = String.valueOf(priceLists.get(Integer.parseInt(parsingFlightCellTypeNumber)-1).getText());
                String bookingFlightPrice = bookingCostOfParsingRoomNumber.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE+ Labels_Flights.ONE_CHARACTER_SPACE, Labels_Flights.STRING_NULL).trim();
                if (bookingFlightPrice.contains(Labels_Flights.STRING_COMMA)){
                    String bookingFlightWithoutComma = bookingFlightPrice.replace(Labels_Flights.STRING_COMMA,Labels_Flights.STRING_NULL);
                    Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightWithoutComma);
                    Labels_Flights.SELECTED_SEAT_BOOKING_COST = bookingFlightWithoutComma;
                    return  Labels_Flights.SELECTED_SEAT_BOOKING_COST ;
                }else {
                    Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                    Labels_Flights.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                    return  Labels_Flights.SELECTED_SEAT_BOOKING_COST ;
                }
            }catch (Exception exception){
                scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(parsingFlightCellTypeNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking cost of first flight in search results");
        }
        return Labels_Flights.SELECTED_SEAT_BOOKING_COST;
    }

    /**
     * Checking the parsing flight booking card is displayed
     * @param selectedFlightCellTypeNumber
     * @return
     */
    public static boolean isParsingFlightBookingCardIsDisplayed(String selectedFlightCellTypeNumber) {
        Logger.logAction("Checking the parsing calender month "+selectedFlightCellTypeNumber+" is displayed or not ?");
        String xPathOfBookingFlightCellType = XPATH_OF_CARD_VIEW_WITHOUT_INDEX+ selectedFlightCellTypeNumber + "]";
        try {
            Thread.sleep(WAIT_TIME_MIN);
            try{
                if(isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                    Logger.logComment(selectedFlightCellTypeNumber+" - Flight booking card is displayed");
                    return true;
                }else {
                    Logger.logComment(selectedFlightCellTypeNumber+" - Flight booking card not displayed in the current active screen");
                }
            }catch (Exception exception){
                scrollTheFlightSearchResultsScreenUpByACardGap_Android();
                isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the month :- " +selectedFlightCellTypeNumber);
        }
        return false;
    }

    /**
     * Scrolling to the parsing flight booking card
     * @param selectedFlightCellTypeNumber
     * @param down
     */
    public static void scrollToTheParsingFlightBookingCard(String selectedFlightCellTypeNumber, boolean down ) {
        Logger.logAction("Scrolling the flight search results view to the parsing flight booking card number :- " +selectedFlightCellTypeNumber);
        try {
            if(!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                int counter = 0;
                if (down) {
                    while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling up ");
                        scrollTheFlightSearchResultsScreenUpByThreeCardsGap_Android();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                            Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling down ");
                            scrollTheFlightSearchResultsScreenDownByThreeCardsGap_Android();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                } else {
                    while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling down ");
                        scrollTheFlightSearchResultsScreenDownByThreeCardsGap_Android();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling up ");
                        while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                            scrollTheFlightSearchResultsScreenUpByThreeCardsGap_Android();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                }
            }else {
                Logger.logComment("Parsing flight booking card number - "+selectedFlightCellTypeNumber+ " - is already displayed in the current calender view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the parsing flight booking card number :- " +selectedFlightCellTypeNumber);
        }
    }

}
