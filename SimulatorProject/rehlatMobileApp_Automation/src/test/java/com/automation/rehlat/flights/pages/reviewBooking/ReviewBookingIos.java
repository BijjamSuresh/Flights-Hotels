package com.automation.rehlat.flights.pages.reviewBooking;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;

public class ReviewBookingIos extends ReviewBookingBase {

    public static final String REVIEW_BOOKING_SCREEN_TITTLE = "Review Booking";
    public static final String IN_PROGRESS_INDICATOR = "In progress";
    public static final String CONTINUE_BUTTON = "CONTINUE";
    public static final String FOOTER_VIEW_PRICE_ID = "price";



    /**
     * Check Review Booking screen is displayed or not
     */
    @Override
    public void checkReviewBookingScreenIsDisplayed() {
        Logger.logAction("Checking the review booking screen is displayed or not ?");
        try{
//            Thread.sleep(4000);
            if (isElementDisplayedByName(REVIEW_BOOKING_SCREEN_TITTLE)){
                Logger.logStep("Review Booking screen is displayed");
            }else {
                Logger.logError("Review Booking screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to check the current active screen name");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton() {
        try{
//            if (waitTillInProgressIndicatorIsInvisible()){
                Logger.logAction("Tapping on continue button");
                if (isElementDisplayedByName(CONTINUE_BUTTON)){
                    driver.findElementByName(CONTINUE_BUTTON).click();
                    Logger.logStep("Tapped on continue button");
                }else {
                    Logger.logError("Continue button is not displayed in the current screen");
                }
//            }
//            else {
//                Logger.logError("In progress indicator is still visible");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on continue button");
        }
    }

//    /**
//     * Wait till the loading in-progress indicator is in visible
//     * @return
//     */
//    public static boolean waitTillInProgressIndicatorIsInvisible() {
//        Logger.logAction("Waiting till In progress indicator is invisible");
//        try{
//            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Hotels.IOS_ACTIVITY_INDICATOR);
////
////            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(IN_PROGRESS_INDICATOR)));
//            Logger.logStep("In progress indicator is not visible");
//            return true;
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to find the visibility of an element");
//        }
//        return false;
//    }

    /**
     * Enable the security check in toggle button
     */
    @Override
    public void enableSecurityCheckInToggle() {
        Logger.logAction("Enabling the security check in toggle");
        try {
            enableToggleSwitch_iOS();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enable the toggle switch");
        }
    }

    /**
     * Disable the security check in toggle button
     */
    @Override
    public void disableSecurityCheckInToggle() {
        Logger.logAction("Disabling the security check in toggle");
        try {
            if (isElementDisplayedByClassName(TOGGLE_SWITCH)){
                disableToggleSwitch_iOS();
            }else {
                scrollDown();
                disableToggleSwitch_iOS();
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to disable the security toggle switch");
        }
    }

    /**
     * Compare the selected booking seat cost in search results screen and displayed in review booking screen
     */
    @Override
    public void compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen() {
        Logger.logAction("Comparing the selected booking seat cost in search results screen displayed in review booking screen");
        Double bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen;
        try {
//            waitTillInProgressIndicatorIsInvisible();
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,2);
             bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen = getTheBookingPriceDisplayedInFooterView();
             Logger.logComment("Selecting flight cost is :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
            if (bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen == Double.parseDouble(Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS)){
                String bookingCostIncludingCurrencyName = Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS;
                Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = bookingCostIncludingCurrencyName;
                Logger.logComment("Booking seat cost in Review booking screen :- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen");
            } else {
                Logger.logComment("Booking seat cost in Review booking screen :- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                Logger.logStep("Selected seat booking cost is not matches in review booking screen and in search results screen.., So checking the booking flight cost again by disabling the toggle button");
                disableSecurityCheckInToggle();
//                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen = getTheBookingPriceDisplayedInFooterView();
                if (bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen == Double.parseDouble(Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS)){
                    String bookingCostIncludingCurrencyName = Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS;
//                    String bookingCostExcludingCurrencyName = bookingCostIncludingCurrencyName.replace("KWD ", "");
                    Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = bookingCostIncludingCurrencyName;
                    Logger.logComment("Booking seat cost in Review booking screen :- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                    Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen");
                }else{
                    Logger.logComment("Booking seat cost in Review booking screen :- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_IOS + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                    Logger.logError("Selected seat booking cost is not matches in review booking screen and in search results screen");
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to verify the cost of selected booking seat in search results screen displayed in review booking screen");
        }
    }

    /**
     * Get the booking price displayed in the footer view layout
     * @return
     */
    public static Double getTheBookingPriceDisplayedInFooterView(){
        Logger.logAction("Getting the booking price displayed in footer view");
        try{
            String hotelPriceInFooterViewWithCurrency = driver.findElementByAccessibilityId(FOOTER_VIEW_PRICE_ID).getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
            String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE, Labels_Flights.STRING_NULL).trim();
            if (hotelPriceWithoutCurrency .contains(Labels_Flights.STRING_COMMA)) {
                String hotelPriceWithoutComma = hotelPriceWithoutCurrency.replace(Labels_Flights.STRING_COMMA, Labels_Flights.STRING_NULL).trim();
                return Double.parseDouble(hotelPriceWithoutComma);
            }else {
                return Double.parseDouble(hotelPriceWithoutCurrency);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking price displayed in footer view");
        }
        return null;
    }



}
