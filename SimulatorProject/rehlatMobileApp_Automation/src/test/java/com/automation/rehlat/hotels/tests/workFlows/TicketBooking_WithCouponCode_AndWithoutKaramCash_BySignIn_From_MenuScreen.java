package com.automation.rehlat.hotels.tests.workFlows;

import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.hotels.Labels_Hotels.*;

public class TicketBooking_WithCouponCode_AndWithoutKaramCash_BySignIn_From_MenuScreen extends BaseTest {
    @Test
    public void testTicketBooking_WithCouponCode_AndWithoutKaramCash_BySignIn_From_MenuScreen() throws Exception{
        Logger.beginTest("Ticket booking with coupon code and without Karam cash by sign in from menu screen");
        HotelsScreen.tapOnHotelsTab();
        HotelsScreen.checkHotelScreenISDisplayed();
        HotelsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (MenuScreen.isUserSignedIn()){
            MenuScreen.tapOnLogoutButton();
            HotelsScreen.tapOnHotelsTab();
            HotelsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
        }
        MenuScreen.tapOnSignUpOrSignInButton();
        SignInScreen.checkSignInScreenIsDisplayed();
        SignInScreen.enterLoginCredentials();
        SignInScreen.tapOnLoginButton();
        HotelsScreen.tapOnHotelsTab();
        HotelsScreen.checkHotelScreenISDisplayed();
        HotelsScreen.tapOnSearchButton();
        HotelsScreen.sendKeysToSearchResultsScreen("hyd");
        String selectedName = HotelsScreen.tapOnFirstCityNameInSearchResults("Hyderabad, India");
        HotelsScreen.checkTheSearchTextFieldIsFilledWithSelectedNameOf(selectedName);
        HotelsScreen.tapOnCheckInButton();
        HotelsScreen.tapOnCheckInOptionInCalendarView();
        HotelsScreen.selectCheckInDate(CHECK_IN_MONTH,CHECK_IN_DAY);
        HotelsScreen.tapOnDoneButtonInCalendarView();
        HotelsScreen.tapOnCheckOutButton();
        HotelsScreen.selectCheckOutDate(CHECK_OUT_MONTH,CHECK_OUT_DAY);
        HotelsScreen.tapOnDoneButtonInCalendarView();
        HotelsScreen.tapOnAdultAndChildLayout();
        HotelsScreen.setTheGuestCountTo(1,1,0); //Todo:- Discuss with stake holder or dev on allowing the selection of child more than adults
//        HotelsScreen.tapOnAddRoomButton();
//        HotelsScreen.setTheGuestCountTo(2,1,0); //Todo:- Discuss with stake holder or dev on allowing the selection of child more than adults
        HotelsScreen.tapOnDoneButtonOnRoomListView();
        HotelsScreen.checkHotelScreenISDisplayed();
        HotelsScreen.tapOnCheckAvailabilityButton();
        HotelsSearchResultsScreen.checkTheHotelsSRPScreenIsDisplayed();
        HotelsSearchResultsScreen.getThePriceOfHotelAndTapOnItsCardView(1);
        if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
            HotelsProfileScreen.tapOnChangeYourDatesButtonInSoldOutAlert();
            HotelsScreen.tapOnCheckInOptionInCalendarView();
            HotelsScreen.selectCheckInDate(SECOND_CHECK_IN_MONTH,"4");
            HotelsScreen.selectCheckOutDate(SECOND_CHECK_OUT_MONTH,"5");
            HotelsScreen.tapOnDoneButtonInCalendarView();
            if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
                Logger.logError("Tried two times but still the sold out alert is displaying");
            }
        }
        HotelsProfileScreen.checkTheHotelProfileScreenIsDisplayed();
        HotelsProfileScreen.compareSelectedHotelPriceInSRPAndInHotelProfileScreens();
        HotelsProfileScreen.tapOnSelectRoomButton();
        SelectRoomsScreen.checkSelectRoomScreenIsDisplayed();
        SelectRoomsScreen.tapOnSelectButtonInRoomCellNumber(1,1); // Todo:- Yet to discuss with the dev as multiple individual rooms selection is not possible [Eg: One user, multiple types of room selections are not possible]
        SelectRoomsScreen.compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(1);
        SelectRoomsScreen.tapOnContinueButton();
        if (SelectRoomsScreen.isHotelsSoldOutAlertIsDisplayed()){
            Logger.logStep("Sold out alert is displayed in select rooms screen where as not displayed in the SRP or hotel profile screen");
            SelectRoomsScreen.tapOnChangeYourRoomTypeButtonInSoldOutAlert();
            SelectRoomsScreen.tapOnSelectButtonInRoomCellNumber(1,2);
            SelectRoomsScreen.compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(1); //Todo:- Checking the price with the selected room with the price in the footer view
            SelectRoomsScreen.tapOnContinueButton();
            if (SelectRoomsScreen.isHotelsSoldOutAlertIsDisplayed()) {
                Logger.logError("Tried two times but still the sold out alert is displaying");
            }
        }
        BookingSummaryScreen.checkBookingPageScreenIsDisplayed();
        if (!(BookingSummaryScreen.isUserIsSignedIn())){
            Logger.logError("User is signed in menu screen where as in booking summary user is not signed in");
        }
        BookingSummaryScreen.enterUserBookingInfo();
        BookingSummaryScreen.applyTheCouponCode();
        BookingSummaryScreen.disableKaramPointsToggleSwitch();
        BookingSummaryScreen.checkFinalFareCalculationIsCorrect();
        BookingSummaryScreen.tapOnAddGuestTravellersDetailsButton();
        GuestTravellersDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
        GuestTravellersDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
        GuestTravellersDetailsScreen.enterTravellersDetailsForPassengers(1,1,0);
        GuestTravellersDetailsScreen.tapOnSaveButton();
//        GuestTravellersDetailsScreen.enterTravellersDetailsForPassengers(2,1,0);
//        GuestTravellersDetailsScreen.tapOnSaveButton();
        BookingSummaryScreen.tapOnContinueButton();
        PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
        PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
        // KNET PAYMENT PROCESS
//        PaymentOptionsScreen.tapOnKnetPaymentGateWay();
//        PaymentOptionsScreen.checkKnetPaymentOptionsScreenIsDisplayed();
//        PaymentOptionsScreen.selectingBankName(TESTING_BANK_CARD);
//        PaymentOptionsScreen.enterCardNumber(); // Automation Defect: Card number text field is not intractable in iOS Platform
//        PaymentOptionsScreen.enterPinNumber();
//        PaymentOptionsScreen.tapOnSubmitButton();
//        PaymentOptionsScreen.checkPostTransactionScreenIsDisplayed();
//        PaymentOptionsScreen.tapOnConfirmButton();
//        PaymentOptionsScreen.checkTheKnetBookingProcessIsSuccess();

//                 CREDIT OR DEBIT CARD PAYMENT PROCESS
//        PaymentOptionsScreen.enterCreditOrDebitCardDetails();
//        PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
//        PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
//        PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
        Logger.endTest("Ticket booking with coupon code and without Karam cash by sign in from menu screen");
    }
}
