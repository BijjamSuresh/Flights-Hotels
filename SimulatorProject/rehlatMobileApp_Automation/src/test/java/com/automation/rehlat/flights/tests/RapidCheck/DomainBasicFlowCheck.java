package com.automation.rehlat.flights.tests.RapidCheck;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;
import static com.automation.rehlat.flights.Labels_Flights.*;

public class DomainBasicFlowCheck extends BaseTest {
    @Test
    public void testComDomain() throws Exception{
        FlightsScreen.tapOnMenuButton();
        MenuScreen.tapOnSettingsButton();
        driver.runAppInBackground(1);
        SettingsScreen.tapOnChangeCountryOption();
        SettingsScreen.selectTheDomain(Labels_Flights.KUWAIT_LANGUAGE_COUNTRY_LABEL);
        SettingsScreen.tapOnContinueButton();
        if (platform.equalsIgnoreCase(ANDROID)){
            driver.navigate().back();
        }
        FlightsScreen.tapOnFromTextField();
        FlightsScreen.enterAirportName(FROM_INTERNATIONAL_AIRPORT_NAME); // Automation Defect: search results are not matching w.r.t. the send keys and due to that using Xpath of first element in search results
        FlightsScreen.selectAirportCodeFromSearchResults(FROM_INTERNATIONAL_AIRPORT_CODE);
        FlightsScreen.tapOnToTextField();
        FlightsScreen.enterAirportName(TO_INTERNATIONAL_AIRPORT_NAME);
        FlightsScreen.selectAirportCodeFromSearchResults(TO_INTERNATIONAL_AIRPORT_CODE);
        FlightsScreen.tapOnDepartureDateBookingButton();
        FlightsScreen.selectDepartureDate(DEPARTURE_MONTH,DEPARTURE_DAY); // Automation Defect: Due to improper element names in calendar view unable to tap on accurate departure date
        FlightsScreen.tapOnDoneButton();
        driver.runAppInBackground(1);
        FlightsScreen.tapOnReturnDateBookingButton();
        FlightsScreen.selectReturnDate(RETURN_DATE_BOOKING_MONTH,RETURN_DAY);// Automation Defect: Due to improper element names in calendar view unable to tap on accurate departure date
        FlightsScreen.tapOnDoneButton();
        driver.runAppInBackground(1);
        FlightsScreen.setThePassengersCountTo(1,0,0); // This should be same as travellers details passengers count
        FlightsScreen.tapOnSearchButton();
        Thread.sleep(4000);
        FlightsSearchResultsScreen.tapOnACellInFlightSearchResults(CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS); //Change this method to tap on a flight cell by sending the cell number as string/integer like this : //  FlightsSearchResultsIos.getTheBookingCostOfSelectedFlightInSearchResults("6");
        ReviewBookingScreen.tapOnContinueButton();
        BookingPageScreen.enterUserBookingInfo();
        BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
        TravellerDetailsScreen.EnterTravellersDetailsForPassengers(2); // This should be same as passengers count in flights tab
        TravellerDetailsScreen.tapOnSaveButton();
        BookingPageScreen.tapOnContinueButton();
        PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();

    }
}
