package com.automation.rehlat.flights.tests.workflows.departureAndReturnBookings.domesticFlightBookings;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;
import static com.automation.rehlat.flights.Labels_Flights.*;

public class TwoWayBooking_DomesticTicket_WithAppliedCouponCode_And_WithSignIn_FromBookingsPageScreen extends BaseTest {
    @Test
    public void testTicketBookingWithAppliedCouponCodeAndWithSignInFromBookingsPageScreen() throws Exception{
        Logger.beginTest("TwoWay_Domestic_Ticket Booking with sign in from booking page and with applied coupon code ");
        printCurrentTestRunningInformation();
        Labels_Flights.FLIGHT_BOOKING_TYPE = DOMESTIC_FLIGHT_BOOKING;
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels_Flights.CURRENT_USER_COUNTRY_NAME); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        if (MenuScreen.isUserSignedIn()){
            MenuScreen.tapOnLogoutButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
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
        FlightsScreen.setThePassengersCountTo(1,1,0); // This should be same as travellers details passengers count
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
            Logger.logError("User is already signed in where as not signed in or signed up from menu screen");
        }
        BookingPageScreen.tapOnSignInForFasterBookingsButton();
        SignInScreen.checkSignInScreenIsDisplayed();
        SignInScreen.enterLoginCredentials();
        SignInScreen.tapOnLoginButton();
        BookingPageScreen.checkBookingPageScreenIsDisplayed();
        BookingPageScreen.enterUserBookingInfo();
        if (Labels_Flights.FLIGHT_BOOKING_TYPE == INTERNATIONAL_FLIGHT_BOOKING){
            BookingPageScreen.applyTheCouponCode();
        }else {
            Logger.logStep("No coupon codes for domestic flights of live/stage configuration");
        }
        BookingPageScreen.enableKaramPointsToggleSwitch();
        BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
        TravellerDetailsScreen.EnterTravellersDetailsForPassengers(2); // This should be same as passengers count in flights tab
        TravellerDetailsScreen.tapOnSaveButton();
        BookingPageScreen.checkBookingPageScreenIsDisplayed();
        BookingPageScreen.enableKaramPointsToggleSwitch();
        BookingPageScreen.checkFinalFareCalculationIsCorrect();
        BookingPageScreen.tapOnContinueButton();
        if (PaymentOptionsScreen.isTicketSoldOutPopUpIsDisplayed()){
            PaymentOptionsScreen.tapOnOkButtonInTicketSoldOutPopup();
            Logger.logStep("Second time selecting the seat for different flight");
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
//            BookingPageScreen.tapOnSignInForFasterBookingsButton(); // Todo:- No need of the below logic as user is already logged in before sold out
//            SignInScreen.checkSignInScreenIsDisplayed();
//            SignInScreen.enterLoginCredentials();
//            SignInScreen.tapOnLoginButton();
//            BookingPageScreen.checkBookingPageScreenIsDisplayed();
            BookingPageScreen.enterUserBookingInfo();
            if (Labels_Flights.FLIGHT_BOOKING_TYPE == INTERNATIONAL_FLIGHT_BOOKING){
                BookingPageScreen.applyTheCouponCode();
            }else {
                Logger.logStep("No coupon codes for domestic flights of live/stage configuration");
            }
            BookingPageScreen.enableKaramPointsToggleSwitch();
            BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
            if (platform.equalsIgnoreCase(Labels_Flights.IOS)){
                TravellerDetailsScreen.acceptAutoFillPopulateModalIfDisplayed(2);
            }else {
                TravellerDetailsScreen.EnterTravellersDetailsForPassengers(2); // This should be same as passengers count in flights tab
            }
            TravellerDetailsScreen.tapOnSaveButton();
            BookingPageScreen.checkBookingPageScreenIsDisplayed();
            BookingPageScreen.enableKaramPointsToggleSwitch();
            BookingPageScreen.checkFinalFareCalculationIsCorrect();
            BookingPageScreen.tapOnContinueButton();
            if (PaymentOptionsScreen.isTicketSoldOutPopUpIsDisplayed()) {
                addTestResultStatusToExecutionResultsJsonFile(Labels_Flights.testCaseName,"false Tickets Are Sold Out In Two Attempts");// Todo:- By Default setting the test case execution status as false
                Logger.logError("Tried booking seats for two flights, both tickets are sold out......, Please re-run the script with different dates");
            }else {
                PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
                PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
                if (Labels_Flights.platform.equalsIgnoreCase(IOS)){
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

                    // CREDIT OR DEBIT CARD PAYMENT PROCESS
            PaymentOptionsScreen.enterCreditOrDebitCardDetails();
            PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
            PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
            PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
                }
            }
        }else {
            Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
            PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
            PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
            if (Labels_Flights.platform.equalsIgnoreCase(IOS)){
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
            PaymentOptionsScreen.enterCreditOrDebitCardDetails();
            PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
            PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
            PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
            }
        }
        Logger.endTest("- Ticket Booking with sign in from booking page and with applied coupon code ");
        addTestResultStatusToExecutionResultsJsonFile(Labels_Flights.testCaseName,"true");
    }
}
