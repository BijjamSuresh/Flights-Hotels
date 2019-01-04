package com.automation.rehlat.hotels.tests.workFlows.StageOrLive;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.hotels.Labels_Hotels.*;

public class RefundableHotelBooking_WithOutCouponCode_And_WithoutKaramCash_WithoutSignUp_Nor_SignIn extends BaseTest {
    @Test
    public void testTicketBooking_WithOutCouponCode_And_WithoutKaramCash() throws Exception{
        Logger.beginTest("Ticket Booking without coupon code and without karam cash");
        Integer iterationCount = 0;
        Integer childCountInRoom1 = 2;
        Integer childCountInRoom2 = 1;
        Integer adultCountInRoom1 = 1;
        Integer adultCountInRoom2 = 1;
        printCurrentTestRunningInformation();
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
        String selectedName = HotelsScreen.tapOnFirstCityNameInSearchResults("Dubai,United Arab Emirates");
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
        while (iterationCount<7){ //Todo:- Below condition is to change the pax value if sold outs are displayed in SRP
            boolean status = HotelsSearchResultsScreen.isSoldOutsAreDisplayedInSRP();
            if (status == false){
                iterationCount = 7;
            }else {
                if (childCountInRoom1 == 0){
                    if (adultCountInRoom2 == 1){
                        adultCountInRoom1 = adultCountInRoom1-1;
                        if (adultCountInRoom1 == 1){
                            iterationCount = 7;
                        }
                    }else {
                        adultCountInRoom2 = adultCountInRoom2-1;
                    }

                }else {
                    if (childCountInRoom2 == 0){
                        childCountInRoom1 = childCountInRoom1-1;
                    }else {
                        childCountInRoom2 = childCountInRoom2-1;
                    }
                }
                if (iterationCount == 7 && status == false){
                    addTestResultStatusToExecutionResultsJsonFile(Labels_Hotels.testCaseName,"false Hotel is Sold Out In Two Attempts");// Todo:- By Default setting the test case execution status as false
                    Logger.logError("Tried reducing the pax count to minimum.ie..,2-Rooms, 2-Adult (one in each room) and 0-Child from 2-Rooms, 2-Adults & 4-child, still showing sold outs in SRP");
                }else {
                    iterationCount = iterationCount+1;
                    HotelsSearchResultsScreen.tapOnNavigateBackButtonInSRP();
                    HotelsScreen.tapOnAdultAndChildLayout();
                    HotelsScreen.setTheGuestCountTo(1,adultCountInRoom1,childCountInRoom1);
                    HotelsScreen.setTheGuestCountTo(2,adultCountInRoom1,childCountInRoom2);
                    HotelsScreen.tapOnDoneButtonOnRoomListView();
                    HotelsScreen.checkHotelScreenISDisplayed();
                    HotelsScreen.tapOnCheckAvailabilityButton();
                    HotelsSearchResultsScreen.checkTheHotelsSRPScreenIsDisplayed();
                }
            }
        }
        HotelsSearchResultsScreen.getThePriceOfHotelAndTapOnItsCardView(true,true);
        if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
            Logger.logStep("Sold out alert is displayed, so re selecting the hotel from SRP");
            HotelsProfileScreen.tapOnSeeAvailablePropertiesButtonInSoldOutAlert();
            HotelsSearchResultsScreen.checkTheHotelsSRPScreenIsDisplayed();
            HotelsSearchResultsScreen.getThePriceOfHotelAndTapOnItsCardView(true,false);
            if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
                Logger.logStep("Sold out alert is displayed even after selecting the new hotel from SRP, so re changing the hotel dates from hotel profile screen");
                HotelsProfileScreen.tapOnChangeYourDatesButtonInSoldOutAlert();
                HotelsScreen.tapOnCheckInOptionInCalendarView();
                HotelsScreen.selectCheckInDate(SECOND_CHECK_IN_MONTH,"1");
                HotelsScreen.selectCheckOutDate(SECOND_CHECK_OUT_MONTH,"2");
                HotelsScreen.tapOnDoneButtonInCalendarView();
                if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
                    addTestResultStatusToExecutionResultsJsonFile(Labels_Hotels.testCaseName,"false Hotel is Sold Out In Two Attempts");// Todo:- By Default setting the test case execution status as false
                    Logger.logError("Tried selecting new hotel and changing the dates still shows the sold out alert");
                }
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
            Logger.logStep("Sold out alert is displayed, so re selecting the hotel from SRP");
            SelectRoomsScreen.tapOnSeeAvailablePropertiesButtonInSoldOutAlert();
            HotelsSearchResultsScreen.checkTheHotelsSRPScreenIsDisplayed();
            HotelsSearchResultsScreen.getThePriceOfHotelAndTapOnItsCardView(true,false);
            if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
                Logger.logStep("Sold out alert is displayed even after selecting the new hotel from SRP when sold out alert is displayed in hotel profile screen");
                HotelsProfileScreen.tapOnChangeYourDatesButtonInSoldOutAlert();
                HotelsScreen.tapOnCheckInOptionInCalendarView();
                HotelsScreen.selectCheckInDate(SECOND_CHECK_IN_MONTH,"2");
                HotelsScreen.selectCheckOutDate(SECOND_CHECK_OUT_MONTH,"3");
                HotelsScreen.tapOnDoneButtonInCalendarView();
                if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
                    addTestResultStatusToExecutionResultsJsonFile(Labels_Hotels.testCaseName,"false Hotel is Sold Out In Two Attempts");// Todo:- By Default setting the test case execution status as false
                    Logger.logError("Tried selecting new hotel and changing the dates still shows the sold out alert");
                }
            }
            HotelsProfileScreen.checkTheHotelProfileScreenIsDisplayed();
            HotelsProfileScreen.compareSelectedHotelPriceInSRPAndInHotelProfileScreens();
            HotelsProfileScreen.tapOnSelectRoomButton();
            SelectRoomsScreen.checkSelectRoomScreenIsDisplayed();
            SelectRoomsScreen.tapOnSelectButtonInRoomCellNumber(2,1); // Todo:- Yet to discuss with the dev as multiple individual rooms selection is not possible [Eg: One user, multiple types of room selections are not possible]
            SelectRoomsScreen.compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(1);
            SelectRoomsScreen.tapOnContinueButton();
            if (SelectRoomsScreen.isHotelsSoldOutAlertIsDisplayed()) {
                addTestResultStatusToExecutionResultsJsonFile(Labels_Hotels.testCaseName,"false Hotel is Sold Out In Two Attempts");// Todo:- By Default setting the test case execution status as false
                Logger.logError("Tried two times still shows the sold out alert even after selecting the new hotel from SRP when sold out alert is displayed in hotel profile screen");
            }
        }
        if (BookingSummaryScreen.isFareJumpAlertIsDisplayed()){
            BookingSummaryScreen.tapOnProceedButtonInFareJumpAlert();
        }
        BookingSummaryScreen.checkBookingPageScreenIsDisplayed();
        BookingSummaryScreen.enterUserBookingInfo();
        BookingSummaryScreen.disableKaramPointsToggleSwitch();
        BookingSummaryScreen.checkFinalFareCalculationIsCorrect(false,false);
        BookingSummaryScreen.tapOnAddGuestTravellersDetailsButton();
        GuestTravellersDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
        GuestTravellersDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
        GuestTravellersDetailsScreen.enterTravellersDetailsForPassengers(1,1,2);
        GuestTravellersDetailsScreen.tapOnSaveButton();
        GuestTravellersDetailsScreen.enterTravellersDetailsForPassengers(2,1,1);
        GuestTravellersDetailsScreen.tapOnSaveButton();
        BookingSummaryScreen.tapOnContinueButton();
//        if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
//            Logger.logStep("Sold out alert is displayed, so re selecting the hotel from SRP");
//            HotelsProfileScreen.tapOnSeeAvailablePropertiesButtonInSoldOutAlert();
//            HotelsSearchResultsScreen.checkTheHotelsSRPScreenIsDisplayed();
//            HotelsSearchResultsScreen.getThePriceOfHotelAndTapOnItsCardView(2);
//            if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
//                Logger.logStep("Sold out alert is displayed even after selecting the new hotel from SRP, so re changing the hotel dates from hotel profile screen");
//                HotelsProfileScreen.tapOnChangeYourDatesButtonInSoldOutAlert();
//                HotelsScreen.tapOnCheckInOptionInCalendarView();
//                HotelsScreen.selectCheckInDate(SECOND_CHECK_IN_MONTH,"1");
//                HotelsScreen.selectCheckOutDate(SECOND_CHECK_OUT_MONTH,"2");
//                HotelsScreen.tapOnDoneButtonInCalendarView();
//                if (HotelsProfileScreen.isSoldOutAlertIsDisplayed()){
//                    Logger.logError("Tried selecting new hotel and changing the dates still shows the sold out alert");
//                }
//            }
//        }
        if(PaymentOptionsScreen.isTicketSoldOutPopUpIsDisplayed()){
            addTestResultStatusToExecutionResultsJsonFile(Labels_Hotels.testCaseName,"false Hotel is Sold Out In Two Attempts");// Todo:- By Default setting the test case execution status as false
            Logger.logError("Hotel is sold out on navigating from booking details screen to payment screen");
        }else {
            PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
            PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
        }
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
        addTestResultStatusToExecutionResultsJsonFile(Labels_Hotels.testCaseName,"true");
    }
}
