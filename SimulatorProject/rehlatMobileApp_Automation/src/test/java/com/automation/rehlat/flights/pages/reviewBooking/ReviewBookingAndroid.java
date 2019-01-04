package com.automation.rehlat.flights.pages.reviewBooking;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ReviewBookingAndroid extends ReviewBookingBase {
    public static final String REVIEW_BOOKING_SCREEN_TITTLE = "com.app.rehlat:id/reviewBookingTextView";
    public static final String IN_PROGRESS_INDICATOR = "com.app.rehlat:id/journeContinueProgressBar";
    public static final String CONTINUE_BUTTON = "com.app.rehlat:id/countinue_text";
    public static final String TOGGLE_SWITCH = "com.app.rehlat:id/set_subscription_switch";
    public static final String REVIEW_BOOKING_PRICE ="com.app.rehlat:id/reviewbooking_price";


    /**
     * Check Review Booking screen is displayed or not
     */
    @Override
    public void checkReviewBookingScreenIsDisplayed() {
        Logger.logAction("Checking the review booking screen is displayed or not ?");
        try{
            if (isElementDisplayedById(REVIEW_BOOKING_SCREEN_TITTLE)){
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
        Logger.logAction("Tapping on continue button");
        try{
            waitTillInProgressIndicatorIsInvisible();
            Logger.logAction("Tapping on continue button");
            if (isElementDisplayedById(CONTINUE_BUTTON)){
                driver.findElementById(CONTINUE_BUTTON).click();
            }else {
                Logger.logError("Continue button is not displayed in the current screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on continue button");
        }
    }

    /**
     * Wait till the loading in-progress indicator is in visible
     * @return
     */
    public static void waitTillInProgressIndicatorIsInvisible() {
        Logger.logAction("Waiting till In progress indicator is invisible");
        try{
            if (isElementDisplayedById(IN_PROGRESS_INDICATOR)){
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(IN_PROGRESS_INDICATOR)));
            }else {
                Logger.logStep("In progress indicator is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the visibility of an element");
        }
    }

    /**
     * Enable the security check in toggle button
     */
    @Override
    public void enableSecurityCheckInToggle() {
        Logger.logAction("Enabling the security check in toggle");
        try {
            if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElement(By.id(TOGGLE_SWITCH));
                String toggleSwitchValue = toggleSwitch.getAttribute(Labels_Flights.CHECKED_ATTRIBUTE);
                if (toggleSwitchValue.equals(Labels_Flights.STATUS_FALSE)){
                    Logger.logStep("Toggle switch is disabled and making it to enable by tapping on it");
                    driver.findElementById(TOGGLE_SWITCH).click();
                }else if (toggleSwitchValue.equals(Labels_Flights.STATUS_TRUE)){
                    Logger.logStep("Toggle switch is already enabled");
                }
            }else {
                scrollToToggleButton();
                if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                    WebElement toggleSwitch = driver.findElement(By.id(TOGGLE_SWITCH));
                    String toggleSwitchValue = toggleSwitch.getAttribute(Labels_Flights.CHECKED_ATTRIBUTE);
                    if (toggleSwitchValue.equals(Labels_Flights.STATUS_FALSE)){
                        Logger.logStep("Toggle switch is disabled and making it to enable by tapping on it");
                        driver.findElementById(TOGGLE_SWITCH).click();
                    }else if (toggleSwitchValue.equals(Labels_Flights.STATUS_TRUE)){
                        Logger.logStep("Toggle switch is already enabled");
                    }
                }else {
                    Logger.logError("Tried two times scrolling to Toggle button but it is not displayed in the current active screen");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " + TOGGLE_SWITCH);
        }
    }

    /**
     * Disable the security check in toggle button
     */
    @Override
    public void disableSecurityCheckInToggle() {
        Logger.logAction("Disabling the security check in toggle");
        try {
            if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElementById(TOGGLE_SWITCH);
                String toggleSwitchValue = toggleSwitch.getAttribute(Labels_Flights.CHECKED_ATTRIBUTE);
                if (toggleSwitchValue.equalsIgnoreCase(Labels_Flights.STATUS_TRUE)){
                    Logger.logStep("Toggle switch is enabled and making it to disable by tapping on it");
                    driver.findElementById(TOGGLE_SWITCH).click();
                }else if (toggleSwitchValue.equals(Labels_Flights.STATUS_FALSE)){
                    Logger.logStep("Toggle switch is already disabled");
                }
            }else {
                scrollToToggleButton();
                if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                    WebElement toggleSwitch = driver.findElementById(TOGGLE_SWITCH);
                    String toggleSwitchValue = toggleSwitch.getAttribute(Labels_Flights.CHECKED_ATTRIBUTE);
                    if (toggleSwitchValue.equalsIgnoreCase(Labels_Flights.STATUS_TRUE)){
                        Logger.logStep("Toggle switch is enabled and making it to disable by tapping on it");
                        driver.findElementById(TOGGLE_SWITCH).click();
                    }else if (toggleSwitchValue.equals(Labels_Flights.STATUS_FALSE)){
                        Logger.logStep("Toggle switch is already disabled");
                    }
                }
                else {
                    scrollTheScreenUpwards();
                    if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                        WebElement toggleSwitch = driver.findElementById(TOGGLE_SWITCH);
                        String toggleSwitchValue = toggleSwitch.getAttribute(Labels_Flights.CHECKED_ATTRIBUTE);
                        if (toggleSwitchValue.equalsIgnoreCase(Labels_Flights.STATUS_TRUE)){
                            Logger.logStep("Toggle switch is enabled and making it to disable by tapping on it");
                            driver.findElementById(TOGGLE_SWITCH).click();
                        }else if (toggleSwitchValue.equals(Labels_Flights.STATUS_FALSE)){
                            Logger.logStep("Toggle switch is already disabled");
                        }
                    }else {
                        Logger.logError("Tried two times scrolling to Toggle button but it is not displayed in the current active screen");
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " + TOGGLE_SWITCH);
        }
    }

    /**
     * Scroll to the toggle button for Android
     */
    public static void scrollToToggleButton() throws Exception {
        Logger.logAction("Scrolling to toggle button");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Flights.DEFAULT_SCROLL_ATTEMPTS) {
            try {
                element = driver.findElementById(TOGGLE_SWITCH);
                if (element.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                driver.swipe(507,850,507,450, Labels_Flights.SWIPE_DURATION_MIN);
                Logger.logComment(counter + " time trying to find the element id of - " + TOGGLE_SWITCH);
            }
//            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            Thread.sleep(1000);
            counter++;
        }
        if (element.isDisplayed()) {
            Logger.logComment(TOGGLE_SWITCH + " - element id is displayed and moving forward to next step");
        }else {
            Logger.logWarning(TOGGLE_SWITCH + " - element id is not displayed in the current active screen");
        }
    }
//        try {
//            if (isElementDisplayedById(TOGGLE_SWITCH)){
//                Logger.logComment("Toggle button is already displayed, no need to scroll the screen");
//            }else {
//                scrollTheScreenUpwards();
//                scrollTheScreenUpwards();
//                driver.swipe(507,800,507,600,Labels_Hotels.SWIPE_DURATION_MIN);
//            }
//        }catch (Exception exception){
//            exception.printStackTrace();
//            Logger.logError("Encountered error: Unable to scroll to toggle button");
//        }
//    }

    /**
     * Compare the selected booking seat cost in search results screen and displayed in review booking screen
     */
    @Override
    public void compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen() {
        Logger.logAction("Comparing the selected booking flight cost displayed in the search results screen and in the review booking screen");
        String bookingSeatCostDisplayedInReviewBookingScreen;
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR,false);
            bookingSeatCostDisplayedInReviewBookingScreen = getTheDisplayedTicketBookingValue();
            double selectedSeatBookingCostInFlightSearchResultsScreen = Double.parseDouble((Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID));
            double selectedSeatCostDisplayedInReviewBookingScreen = Double.parseDouble(bookingSeatCostDisplayedInReviewBookingScreen);
            Logger.logComment("Displayed flight booking cost in review booking screen is:- " +bookingSeatCostDisplayedInReviewBookingScreen+"\n"+"        -> Displayed selected flight booking cost in search results screen is:- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID);
            if (bookingSeatCostDisplayedInReviewBookingScreen.equals(Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID)){
                Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID;
                Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen.ie.., "+bookingSeatCostDisplayedInReviewBookingScreen);
            } else if(selectedSeatBookingCostInFlightSearchResultsScreen <= selectedSeatCostDisplayedInReviewBookingScreen) {
                Logger.logComment("Selected flight booking cost in flight search results is lesser than the booking flight cost displayed in review booking screen.., So rechecking the flight cost by disabling the security check in toggle button");
                disableSecurityCheckInToggle();
                bookingSeatCostDisplayedInReviewBookingScreen = getTheDisplayedTicketBookingValue();
                if (bookingSeatCostDisplayedInReviewBookingScreen.contains(Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID) || (bookingSeatCostDisplayedInReviewBookingScreen.equals(Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID))){
                    Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID;
                    Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen");
                }else if (selectedSeatBookingCostInFlightSearchResultsScreen <= selectedSeatCostDisplayedInReviewBookingScreen){
                    Logger.logComment("Displayed flight booking cost in review booking screen is:- " +bookingSeatCostDisplayedInReviewBookingScreen+"\n"+"        -> Displayed selected flight booking cost in search results screen is:- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID);
                    Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = bookingSeatCostDisplayedInReviewBookingScreen;
                    Logger.logStep("Selected seat booking cost is not matches in review booking screen and in search results screen, it got increased.. So continuing with the latest price : "+bookingSeatCostDisplayedInReviewBookingScreen);
                }else if (selectedSeatBookingCostInFlightSearchResultsScreen > selectedSeatCostDisplayedInReviewBookingScreen){
                    Logger.logComment("Displayed flight booking cost in review booking screen is:- " +bookingSeatCostDisplayedInReviewBookingScreen+"\n"+"        -> Displayed selected flight booking cost in search results screen is:- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID);
                    Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = bookingSeatCostDisplayedInReviewBookingScreen;
                    Logger.logStep("Selected seat booking cost is not matches in review booking screen and in search results screen, it got decreased.. So continuing with the latest price : "+bookingSeatCostDisplayedInReviewBookingScreen);
                }else {
                    Logger.logComment("Displayed flight booking cost in review booking screen is:- " +bookingSeatCostDisplayedInReviewBookingScreen+"\n"+"        -> Displayed selected flight booking cost in search results screen is:- "+ Labels_Flights.SELECTED_SEAT_BOOKING_COST_ANDROID);
                    Logger.logError("Selected set cost in SRP and review booking is neither lesser nor greater");
                }
            } else if (selectedSeatBookingCostInFlightSearchResultsScreen > selectedSeatCostDisplayedInReviewBookingScreen) {
                disableSecurityCheckInToggle();
                bookingSeatCostDisplayedInReviewBookingScreen = getTheDisplayedTicketBookingValue();
                Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = String.valueOf(bookingSeatCostDisplayedInReviewBookingScreen);
                Logger.logStep("Booking cost is reduced in review booking screen compared to the SRP Value..,So after disabling the toggle, continuing with the amount - "+bookingSeatCostDisplayedInReviewBookingScreen+"- as final fare for further price verifications in coming screens ");
            }
            else{
                Logger.logError("Selected seat booking cost is not matches in review booking screen and in search results screen");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to verify the cost of selected booking seat in search results screen displayed in review booking screen");
        }
    }

    /**
     * Get the displayed ticket booking value
     * @return
     */
    public static String getTheDisplayedTicketBookingValue() {
        Logger.logAction("Getting the displayed ticket booking value");
        String flightCellTypeText = null;
        try {
//            WebElement footerView = driver.findElementById("com.app.rehlat:id/footer_view");
            if (isElementDisplayedById(IN_PROGRESS_INDICATOR)){
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(IN_PROGRESS_INDICATOR)));
            }
//            else {
//                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                if (isElementDisplayedById(REVIEW_BOOKING_PRICE)){
                    WebElement reviewBookingPriceLabel = driver.findElementById(REVIEW_BOOKING_PRICE);
                    String reviewBookingPrice = reviewBookingPriceLabel.getText();
                    if (reviewBookingPrice.contains(Labels_Flights.STRING_COMMA)){
                        String  reviewBookingPriceWithoutComma = reviewBookingPrice.replace(Labels_Flights.STRING_COMMA,Labels_Flights.STRING_NULL);
                        flightCellTypeText = reviewBookingPriceWithoutComma;
                        return flightCellTypeText;
                    }else {
//                if (reviewBookingPrice.contains(".")){
//                    Logger.logComment("Displayed booking cost is: " +reviewBookingPrice);
                    flightCellTypeText = reviewBookingPrice;
                    return flightCellTypeText;
//                }else{
//                    Logger.logStep("Booking flight cost is not displayed in the current active screen");
//                }
                    }
                }else {
                    Logger.logError("Review booking price element name is not displayed");
                }
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the displayed ticket booking value");
        }
        return flightCellTypeText;
    }


}
