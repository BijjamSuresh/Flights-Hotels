package com.automation.rehlat.hotels.tests.workFlows;

import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.hotels.Labels_Hotels.*;

public class TicketBooking_WithOutCouponCode_And_WithoutKaramCash_WithoutSignUp_Nor_SignIn extends BaseTest {
    @Test
    public void testTicketBooking_WithOutCouponCode_And_WithoutKaramCash() throws Exception{
        Logger.beginTest("Ticket Booking without coupon code and without karam cash");
        HotelsScreen.tapOnHotelsTab();
        HotelsScreen.checkHotelScreenISDisplayed();
        HotelsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (MenuScreen.isUserSignedIn()){
            MenuScreen.tapOnLogoutButton();
            HotelsScreen.tapOnHotelsTab();
        }else {
            MenuScreen.navigateToFlightsTab();
        }
        HotelsScreen.checkHotelScreenISDisplayed();
        HotelsScreen.tapOnSearchButton();
        HotelsScreen.sendKeysToSearchResultsScreen("dxb");
        String selectedName = HotelsScreen.tapOnFirstCityNameInSearchResults("Dubai, United Arab Emirates");
        HotelsScreen.checkTheSearchTextFieldIsFilledWithSelectedNameOf(selectedName);
        HotelsScreen.tapOnCheckInButton();
        HotelsScreen.tapOnCheckInOptionInCalendarView();
        HotelsScreen.selectCheckInDate(CHECK_IN_MONTH,CHECK_IN_DAY);
        HotelsScreen.tapOnDoneButtonInCalendarView();
        HotelsScreen.tapOnCheckOutButton();
        HotelsScreen.selectCheckOutDate(CHECK_OUT_MONTH,CHECK_OUT_DAY);
        HotelsScreen.tapOnDoneButtonInCalendarView();
        HotelsScreen.tapOnAdultAndChildLayout();
        HotelsScreen.setTheGuestCountTo(1,1,2);
        HotelsScreen.tapOnAddRoomButton();
        HotelsScreen.setTheGuestCountTo(2,1,1);
        HotelsScreen.tapOnDoneButtonOnRoomListView();
        HotelsScreen.checkHotelScreenISDisplayed();
        HotelsScreen.tapOnCheckAvailabilityButton();
        HotelsSearchResultsScreen.checkTheHotelsSRPScreenIsDisplayed();
        HotelsSearchResultsScreen.getThePriceOfHotelAndTapOnItsCardView(1);
        if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
            HotelsProfileScreen.tapOnChangeYourDatesButtonInSoldOutAlert();
            HotelsScreen.tapOnCheckInOptionInCalendarView();
            HotelsScreen.selectCheckInDate(SECOND_CHECK_IN_MONTH,"17");
            HotelsScreen.selectCheckOutDate(SECOND_CHECK_OUT_MONTH,"18");
            HotelsScreen.tapOnDoneButtonInCalendarView();
            if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
                Logger.logError("Tried two times but still the sold out alert is displaying");
            }
        }
        HotelsProfileScreen.checkTheHotelProfileScreenIsDisplayed();
        HotelsProfileScreen.compareSelectedHotelPriceInSRPAndInHotelProfileScreens();
        HotelsProfileScreen.tapOnSelectRoomButton();
        SelectRoomsScreen.checkSelectRoomScreenIsDisplayed();
        SelectRoomsScreen.tapOnSelectButtonInRoomCellNumber(2,1); // Todo:- Yet to discuss with the dev as multiple individual rooms selection is not possible [Eg: One user, multiple types of room selections are not possible]
        SelectRoomsScreen.compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(1);
        SelectRoomsScreen.tapOnContinueButton();
        if (SelectRoomsScreen.isHotelsSoldOutAlertIsDisplayed()){
            Logger.logStep("Sold out alert is displayed in select rooms screen where as not displayed in the SRP or hotel profile screen");
            SelectRoomsScreen.tapOnChangeYourRoomTypeButtonInSoldOutAlert();
            SelectRoomsScreen.tapOnSelectButtonInRoomCellNumber(2,2);
            SelectRoomsScreen.compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(1);
            SelectRoomsScreen.tapOnContinueButton();
            if (SelectRoomsScreen.isHotelsSoldOutAlertIsDisplayed()) {
                Logger.logError("Tried two times but still the sold out alert is displaying");
            }
        }
        BookingSummaryScreen.checkBookingPageScreenIsDisplayed();
        BookingSummaryScreen.enterUserBookingInfo();
        BookingSummaryScreen.disableKaramPointsToggleSwitch();
        BookingSummaryScreen.checkFinalFareCalculationIsCorrect();
        BookingSummaryScreen.tapOnAddGuestTravellersDetailsButton();
        GuestTravellersDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
        GuestTravellersDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
        GuestTravellersDetailsScreen.enterTravellersDetailsForPassengers(1,1,2);
        GuestTravellersDetailsScreen.tapOnSaveButton();
        GuestTravellersDetailsScreen.enterTravellersDetailsForPassengers(2,1,1);
        GuestTravellersDetailsScreen.tapOnSaveButton();
        BookingSummaryScreen.tapOnContinueButton();
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
//        PaymentOptionsScreen.enterCreditOrDebitCardDetails();
//        PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
//        PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
//        PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
        Logger.endTest("Ticket Booking without coupon code and without karam cash");
    }
}
