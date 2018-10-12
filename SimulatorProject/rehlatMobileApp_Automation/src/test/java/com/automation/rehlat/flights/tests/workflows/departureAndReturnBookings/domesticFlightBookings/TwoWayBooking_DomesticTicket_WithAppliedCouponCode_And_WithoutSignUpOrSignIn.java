package com.automation.rehlat.flights.tests.workflows.departureAndReturnBookings.domesticFlightBookings;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.pages.BasePage;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;
import static com.automation.rehlat.flights.Labels_Flights.*;

public class TwoWayBooking_DomesticTicket_WithAppliedCouponCode_And_WithoutSignUpOrSignIn extends BaseTest {
    @Test
    public void testTicketBookingWithAppliedCouponCodeAndWithoutSignUpOrSignIn() throws Exception{
        BasePage.waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,1);
        Labels_Flights.FLIGHT_BOOKING_TYPE = DOMESTIC_FLIGHT_BOOKING;
        Logger.beginTest(" - Ticket booking with applied coupon code and without sign in or sign up ");
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (MenuScreen.isUserSignedIn()){
            Logger.logComment("User is signed with an account.., So going to logout form that account");
            MenuScreen.tapOnLogoutButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
        }
        MenuScreen.navigateToFlightsTab();
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnFromTextField();
        FlightsScreen.checkSearchViewScreenIsDisplayed();
        FlightsScreen.checkKeyboardIsDisplayed();
        FlightsScreen.enterAirportName(FROM_DOMESTIC_AIRPORT_NAME); // Automation Defect: search results are not matching w.r.t. the send keys and due to that using Xpath of first element in search results
        FlightsScreen.selectAirportCodeFromSearchResults(FROM_DOMESTIC_AIRPORT_CODE);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnToTextField();
        FlightsScreen.checkKeyboardIsDisplayed();
        FlightsScreen.enterAirportName(TO_DOMESTIC_AIRPORT_NAME);
        FlightsScreen.selectAirportCodeFromSearchResults(TO_DOMESTIC_AIRPORT_CODE);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnDepartureDateBookingButton();
        FlightsScreen.selectDepartureDate(DEPARTURE_MONTH,DEPARTURE_DAY); // Automation Defect: Due to improper element names in calendar view unable to tap on accurate departure date
        FlightsScreen.tapOnDoneButton();
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnReturnDateBookingButton();
        FlightsScreen.selectReturnDate(RETURN_DATE_BOOKING_MONTH,RETURN_DAY);// Automation Defect: Due to improper element names in calendar view unable to tap on accurate departure date
        FlightsScreen.tapOnDoneButton();
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.setThePassengersCountTo(1,1,1);
        FlightsScreen.tapOnSearchButton();
        FlightsSearchResultsScreen.checkFlightsSearchResultsScreenIsDisplayed();
        FlightsSearchResultsScreen.tapOnACellInFlightSearchResults(CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS); //Change this method to tap on a flight cell by sending the cell number as string/integer like this : //  FlightsSearchResultsIos.getTheBookingCostOfSelectedFlightInSearchResults("6");
        if ( FlightsSimilarOptionsSearchResultsScreen.checkFlightsSimilarOptionsSearchResultsScreenIsDisplayed()){
            FlightsSimilarOptionsSearchResultsScreen.tapOnFirstSimilarOptionCell();
        }else{
            Logger.logComment("Flights similar options screen is not displayed");
        }
        ReviewBookingScreen.checkReviewBookingScreenIsDisplayed();
        ReviewBookingScreen.compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen();
        ReviewBookingScreen.tapOnContinueButton();
        BookingPageScreen.checkBookingPageScreenIsDisplayed();
        if (BookingPageScreen.isUserIsSignedIn()){
            Logger.logError("User is signed-in in booking page where as not signed in or signed up from menu screen");
        }
        BookingPageScreen.enterUserBookingInfo();
        BookingPageScreen.applyTheCouponCode();
        BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
        TravellerDetailsScreen.EnterTravellersDetailsForPassengers(3); // This should be same as passengers count in flights tab
        TravellerDetailsScreen.tapOnSaveButton();
        BookingPageScreen.checkBookingPageScreenIsDisplayed();
        BookingPageScreen.checkFinalFareCalculationIsCorrect();
        BookingPageScreen.tapOnContinueButton();
        if (PaymentOptionsScreen.isTicketSoldOutPopUpIsDisplayed()){
            PaymentOptionsScreen.tapOnOkButtonInTicketSoldOutPopup();
            Logger.logComment("Second time selecting the seat for different flight");
            FlightsSearchResultsScreen.checkFlightsSearchResultsScreenIsDisplayed();
            FlightsSearchResultsScreen.tapOnACellInFlightSearchResults(CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS_WHEN_SOLDOUT_POPUP_INTERRUPTRED); //Change this method to tap on a flight cell by sending the cell number as string/integer like this : //  FlightsSearchResultsIos.getTheBookingCostOfSelectedFlightInSearchResults("6");
            if ( FlightsSimilarOptionsSearchResultsScreen.checkFlightsSimilarOptionsSearchResultsScreenIsDisplayed()){
                FlightsSimilarOptionsSearchResultsScreen.tapOnFirstSimilarOptionCell();
            }else{
                Logger.logComment("Flights similar options screen is not displayed");
            }
            ReviewBookingScreen.checkReviewBookingScreenIsDisplayed();
            ReviewBookingScreen.compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen();
            ReviewBookingScreen.tapOnContinueButton();
            BookingPageScreen.checkBookingPageScreenIsDisplayed();
            if (BookingPageScreen.isUserIsSignedIn()){
                Logger.logError("User is signed in in booking page where as not signed in or signed up from menu screen");
            }
            BookingPageScreen.enterUserBookingInfo();
            BookingPageScreen.applyTheCouponCode();
            BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
            TravellerDetailsScreen.EnterTravellersDetailsForPassengers(3); // This should be same as passengers count in flights tab
            TravellerDetailsScreen.tapOnSaveButton();
            BookingPageScreen.checkBookingPageScreenIsDisplayed();
            BookingPageScreen.checkFinalFareCalculationIsCorrect();
            BookingPageScreen.tapOnContinueButton();
            if (PaymentOptionsScreen.isTicketSoldOutPopUpIsDisplayed()) {
                PaymentOptionsScreen.tapOnOkButtonInTicketSoldOutPopup();
                Logger.logError("Tried booking seats for two flights, both tickets are sold out......, Please re-run the script with different dates");
            }else {
                PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
                PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
                // KNET PAYMENT PROCESS
//                PaymentOptionsScreen.tapOnKnetPaymentGateWay();
//                PaymentOptionsScreen.checkKnetPaymentOptionsScreenIsDisplayed();
//                PaymentOptionsScreen.selectingBankName(TESTING_BANK_CARD);
//                PaymentOptionsScreen.enterCardNumber(); // Automation Defect: Card number text field is not intractable in iOS Platform
//                PaymentOptionsScreen.enterPinNumber();
//                PaymentOptionsScreen.tapOnSubmitButton();
//                PaymentOptionsScreen.checkPostTransactionScreenIsDisplayed();
//                PaymentOptionsScreen.tapOnConfirmButton();
//                PaymentOptionsScreen.checkTheKnetBookingProcessIsSuccess();

//                 CREDIT OR DEBIT CARD PAYMENT PROCESS
//            PaymentOptionsScreen.enterCreditOrDebitCardDetails();
//            PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
            }
        }else {
            Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
            PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
            PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
            // KNET PAYMENT PROCESS
//            PaymentOptionsScreen.tapOnKnetPaymentGateWay();
//            PaymentOptionsScreen.checkKnetPaymentOptionsScreenIsDisplayed();
//            PaymentOptionsScreen.selectingBankName(TESTING_BANK_CARD);
//            PaymentOptionsScreen.enterCardNumber(); // Automation Defect: Card number text field is not intractable in iOS Platform
//            PaymentOptionsScreen.enterPinNumber();
//            PaymentOptionsScreen.tapOnSubmitButton();
//            PaymentOptionsScreen.checkPostTransactionScreenIsDisplayed();
//            PaymentOptionsScreen.tapOnConfirmButton();
//            PaymentOptionsScreen.checkTheKnetBookingProcessIsSuccess();

            // CREDIT OR DEBIT CARD PAYMENT PROCESS
//            PaymentOptionsScreen.enterCreditOrDebitCardDetails();
//            PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
        }
        Logger.endTest(" - Ticket booking with applied coupon code and without sign in or sign up ");
    }
}
