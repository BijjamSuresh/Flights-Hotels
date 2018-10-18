package com.automation.rehlat.hotels.pages.bookingSummary;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.pages.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DecimalFormat;
import java.util.List;

public class BookingSummaryAndroid extends BookingSummaryBase {

    public static final String BOOKING_SUMMARY_TIMER_VIEW_ID = "com.app.rehlat:id/bookingSummaryTimerView";
    public static final String EMAIL_FIELD = "com.app.rehlat:id/travellerEmailEditText";
    public static final String PHONE_NUMBER_FIELD = "com.app.rehlat:id/phoneNumberEditText";
    public static final String PLACEHOLDER_TEXT_OF_PHONE_NUMBER_TEXT_FIELD = "Phone Number";
    public static final String PLACEHOLDER_TEXT_OF_EMAIL_ID_TEXT_FIELD = "Please enter your email id";
    public static final String ADD_GUEST_ID = "com.app.rehlat:id/addguest_alert";
    public static final String CONTINUE_BUTTON = "com.app.rehlat:id/continue_text";
    public static final String LOGIN_TO_USE_KARAM_CASH_OPTION_ID = "com.app.rehlat:id/loginToEarnKarmPoints";
    public static final String ACTUAL_DISPLAYING_FARE = "com.app.rehlat:id/total_amt_textview";
    public static final String COUPON_AMOUNT = "com.app.rehlat:id/coupondiscount_price";
    public static final String KARAM_POINTS = "com.app.rehlat:id/walletPointsTextView";
    public static final String ADD_GUEST_TRAVELLERS_VIEW_TITLE = "com.app.rehlat:id/travellerDetailsCardView";
    public static final String FINAL_FARE = "com.app.rehlat:id/final_amt_textview";
    public static final String KARAM_POINTS_TOGGLE_BUTTON = "com.app.rehlat:id/use_karm_checkbox";
    public static final String COUPON_CODE_TEXT_VIEW = "com.app.rehlat:id/enterCouponCodeTextViewEditText";
    public static final String APPLY_COUPON_CODE_BUTTON = "com.app.rehlat:id/coupon_apply";
    public static final String COUPON_CODE_VALIDATION_MESSAGE = "com.app.rehlat:id/couponcode_apply_layout_message_text_view";
    public static final String COUPON_INVALID_MESSAGE = "Invalid coupon";
    public static final String GUEST_TRAVELLERS_CARD_VIEW_ID = "com.app.rehlat:id/travellerDetailsCardView";
    public static final String SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL="com.app.rehlat:id/searchFlightEditText";
    public static final String XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String XPATH_OF_SECOND_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String CONTACT_INFO_COUNTRY_LAYOUT = "com.app.rehlat:id/country_code_llayt";
    public static final String CONTACT_INFO_COUNTRY_NAME = "com.app.rehlat:id/contact_info_country_name_textview";
    public static final String PRICE_ID_IN_BOOKING_SUMMARY_SCREEN_FOOTER_VIEW = "com.app.rehlat:id/booking_summaryfooter_total_fare_textview";
    public static final String XPATH_OF_LOGIN_TO_USE_KARAM_CASH_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView";
    public static final String LOGIN_TO_USE_KARAM_CASH_LABEL = "Login to use Karam Cash";
    public static boolean SIGN_IN_STATUS = false;
    public static Double displayedActualFare;
    public static Double couponAmount ;
    public static Double karamPoints;
    public static Double finalDisplayedFare;

    /**
     * Check booking summary screen is displayed
     */
    @Override
    public void checkBookingPageScreenIsDisplayed() {
        Logger.logAction("Checking the Booking Summary screen is displayed or not ?");
        try{
            if (isElementDisplayedById(BOOKING_SUMMARY_TIMER_VIEW_ID) || isElementDisplayedById(ADD_GUEST_ID)){
                Logger.logStep("Booking Summary screen is displayed");
            }else{
                Logger.logError("Booking Summary screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
    }

    /**
     * Check booking page screen is displayed
     */
    @Override
    public boolean isUserIsSignedIn() {
        Logger.logAction("Checking the user is signed in or not ?");
        try{
            scrollToAnElementById_ANDROID(LOGIN_TO_USE_KARAM_CASH_OPTION_ID,true);
            if (isElementDisplayedById(LOGIN_TO_USE_KARAM_CASH_OPTION_ID)){
                Logger.logStep("User is not signed in");
                SIGN_IN_STATUS = true;
                return false;
            }else {
                Logger.logStep("User is signed in");
                return true;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the user sign in status");
        }
        return false;
    }

    /**
     * Enter user booking information
     */
    @Override
    public void enterUserBookingInfo() {
        Logger.logAction("Entering the user information");
        try {
//            TouchAction action = new TouchAction(driver);
//            action.longPress(459, 758).moveTo(459, 50).release().perform();
//            if (isUserIsSignedIn()){
                enterTextInEmailTextField();
                selectTheCountryCodeByCountryName(Labels_Hotels.INDIA_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID);
                enterTextInPhoneNumberTextField();
                BasePage.closeTheKeyboard_Android();
//            }else{
//                enterTextInEmailTextField();
//                selectTheCountryCodeByCountryName(Labels_Hotels.INDIA_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID);
//                enterTextInPhoneNumberTextField();
//                BasePage.closeTheKeyboard_Android();
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the user info in the respected fields");
        }
    }

    /**
     * Send keys to email text field
     */
    @Override
    public void enterTextInEmailTextField() {
        Logger.logAction("Entering the email id "+ Labels_Hotels.EMAIL_ID_SIGN_IN+" in email id text field");
        try{
            scrollToAnElementById_ANDROID(EMAIL_FIELD,true);
            if (isElementDisplayedById(EMAIL_FIELD)){
                String emailField = driver.findElementById(EMAIL_FIELD).getText();
                if (emailField.equals(PLACEHOLDER_TEXT_OF_EMAIL_ID_TEXT_FIELD)){
                    Logger.logComment("Entering the email id:- "+ Labels_Hotels.EMAIL_ID_SIGN_IN);
                    WebElement textField = driver.findElement(By.id(EMAIL_FIELD));
                    tapOnElementBasedOnLocation(textField,"bottomRight");
//                    clearKeysByUsingKeycode(EMAIL_FIELD,EMAIL_FIELD.length());
                    sendTextById(EMAIL_FIELD, Labels_Hotels.EMAIL_ID_SIGN_IN);
                    closeTheKeyboard_Android();
                }else if (emailField.equals(Labels_Hotels.EMAIL_ID_SIGN_IN)){
                    Logger.logComment(Labels_Hotels.EMAIL_ID_SIGN_IN+" :- Email id is already entered in the text field");
                }else if (emailField.equals(Labels_Hotels.STRING_NULL)){
                    Logger.logComment("Entering the phone number as :- "+ Labels_Hotels.phoneNumber);
                    sendTextById(EMAIL_FIELD, Labels_Hotels.EMAIL_ID_SIGN_IN);
                    closeTheKeyboard_Android();
                }else {
                    Logger.logComment("Replacing current email id "+emailField+" with "+ Labels_Hotels.EMAIL_ID_SIGN_IN);
                    WebElement textField = driver.findElement(By.id(EMAIL_FIELD));
                    tapOnElementBasedOnLocation(textField,"bottomRight");
                    clearKeysByUsingKeycode(EMAIL_FIELD,EMAIL_FIELD.length());
                    sendTextById(EMAIL_FIELD, Labels_Hotels.EMAIL_ID_SIGN_IN);
                    closeTheKeyboard_Android();
                }
            }else {
                Logger.logError(EMAIL_FIELD+" - text field is not displaying in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the keys to email text field");
        }
    }

    /**
     * Send keys to phone number text field
     */
    @Override
    public void enterTextInPhoneNumberTextField() {
        Logger.logAction("Entering the number "+ Labels_Hotels.phoneNumber+" in number text field");
        try{
            if (isElementDisplayedById(PHONE_NUMBER_FIELD)){
                String phoneNumberField = driver.findElementById(PHONE_NUMBER_FIELD).getText();
                if (phoneNumberField.equals(PLACEHOLDER_TEXT_OF_PHONE_NUMBER_TEXT_FIELD)){
                    Logger.logComment("Entering the phone number:- "+ Labels_Hotels.phoneNumber);
                    WebElement textField = driver.findElementById(PHONE_NUMBER_FIELD);
                    tapOnElementBasedOnLocation(textField,"bottomRight");
                    sendTextById(PHONE_NUMBER_FIELD, Labels_Hotels.phoneNumber);
//                    closeTheKeyboard_Android(); //Todo:- Once keys are sent automatically keyboard will be closed
                }else if (phoneNumberField.equals(Labels_Hotels.phoneNumber)){
                    Logger.logComment(Labels_Hotels.EMAIL_ID_SIGN_IN+" :- Email id is already entered in the text field");
                } else if (phoneNumberField.equals(Labels_Hotels.STRING_NULL)){
                    Logger.logComment("Entering the phone number as :- "+ Labels_Hotels.phoneNumber);
                    sendTextById(PHONE_NUMBER_FIELD, Labels_Hotels.phoneNumber);
//                    closeTheKeyboard_Android(); //Todo:- Once keys are sent automatically keyboard will be closed
                } else {
                    Logger.logComment("Replacing current phone number text "+phoneNumberField+" with "+ Labels_Hotels.phoneNumber);
                    WebElement textField = driver.findElementById(PHONE_NUMBER_FIELD);
                    tapOnElementBasedOnLocation(textField,"bottomRight");
                    clearKeysByUsingKeycode(PHONE_NUMBER_FIELD,PHONE_NUMBER_FIELD.length());
                    sendTextById(PHONE_NUMBER_FIELD, Labels_Hotels.phoneNumber);
//                    closeTheKeyboard_Android(); //Todo:- Once keys are sent automatically keyboard will be closed
                }
            }else {
                Logger.logError(PHONE_NUMBER_FIELD+" - text field is not displaying in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the keys to phone number text field");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton() {
        Logger.logAction("Tapping on continue button");
        try{
            compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout(); // Todo:- After iOS is implemented by "Online Check In toggle button", this method needs to be removed from here and call it as a step of TC from workflows directly
            Thread.sleep(2000);
            if (isElementDisplayedById(CONTINUE_BUTTON)){
                driver.findElementById(CONTINUE_BUTTON).click();
                Logger.logComment("Tapped on continue button");
            }else{
                Logger.logError("Unable to tap on continue button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Continue button is not displayed in the current active screen");
        }
    }

    /**
     * Tap on add guest travellers details button
     */
    @Override
    public void tapOnAddGuestTravellersDetailsButton() {
        Logger.logAction("Tapping on adult add guest travellers details button");
        try{
            Thread.sleep(2000);
            closeTheKeyboard_Android(); //Todo:- This line of code is to close the keyboard triggered while swiping
//            scrollTheScreenUpwards();
            scrollToAnElementById_ANDROID(ADD_GUEST_ID,true);
            if (isElementDisplayedById(ADD_GUEST_ID)){
                WebElement locationOfDay = driver.findElementById(ADD_GUEST_ID);
                Point table = locationOfDay.getLocation();
                int elementYAxisValue = table.getY();
                if (Labels_Hotels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                    driver.swipe(507,850,507,450, Labels_Hotels.SWIPE_DURATION_MIN); // scrolling values inside are hardcoded by screen basis
                }
                driver.findElementById(ADD_GUEST_ID).click();
                Logger.logComment("Tapped on room icon");
            }else{
                scrollToAnElementById_ANDROID(ADD_GUEST_ID,true);
                if (isElementDisplayedById(ADD_GUEST_ID)){
                    WebElement locationOfDay = driver.findElementById(ADD_GUEST_ID);
                    Point table = locationOfDay.getLocation();
                    int elementYAxisValue = table.getY();
                    if (Labels_Hotels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                        driver.swipe(507,850,507,450, Labels_Hotels.SWIPE_DURATION_MIN); // scrolling values inside are hardcoded by screen basis
                    }
                    driver.findElementById(ADD_GUEST_ID).click();
                    Logger.logComment("Tapped on room icon");
                }else{
                    scrollTheScreenDownwards();
                    if (isElementDisplayedById(ADD_GUEST_ID)){
                        WebElement locationOfDay = driver.findElementById(ADD_GUEST_ID);
                        Point table = locationOfDay.getLocation();
                        int elementYAxisValue = table.getY();
                        if (Labels_Hotels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                            driver.swipe(507,850,507,450, Labels_Hotels.SWIPE_DURATION_MIN); // scrolling values inside are hardcoded by screen basis
                        }
                        driver.findElementById(ADD_GUEST_ID).click();
                        Logger.logComment("Tapped on room icon");
                    }else{
                        Logger.logError("Unable to tap on add travellers details button");
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Add travellers details button is not displayed in the current active screen");
        }
    }

    /**
     * Tap on login in to use karam cash button
     */
    @Override
    public void tapOnLoginToUseKaramCashButton() {
        Logger.logStep("Tapping on login in to use karam cash button");
        try {
//            scrollTheCalenderPageUpByDaysGap_Android();
//            String elementName = findElementByXpathAndReturnItsAttributeText(XPATH_OF_LOGIN_TO_USE_KARAM_CASH_BUTTON);
            if (isElementDisplayedById(LOGIN_TO_USE_KARAM_CASH_OPTION_ID)){
                driver.findElementById(LOGIN_TO_USE_KARAM_CASH_OPTION_ID).click();
                Logger.logAction("Tapped on signed in for faster booking button");
            }else {
                Logger.logError(LOGIN_TO_USE_KARAM_CASH_LABEL+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on Sign in for faster bookings button");
        }
    }


    /**
     * Check the final fare calculations are correct
     */
    @Override
    public void checkFinalFareCalculationIsCorrect() {
        Double finalFareInternalMathCalculation;
        DecimalFormat decimalFormat;
        Logger.logAction("Checking the final fare calculation is correct or not ?");
        try {
            displayedActualFare = Double.valueOf(getDisplayedActualFare());
            scrollToAnElementById_ANDROID(GUEST_TRAVELLERS_CARD_VIEW_ID,true);
            Double bookingHotelCostInSelectRoomScreen = Double.valueOf(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_SELECT_ROOM_SCREEN);
            couponAmount = Double.valueOf(getCouponAmount());
            karamPoints = Double.valueOf(getKaramPoints());
            Double finaValuePrice = Double.valueOf(getFinalDisplayedFare());
            decimalFormat = new DecimalFormat("0.00");
            String finalDisplayedFareAsString = decimalFormat.format(finaValuePrice); // This line of code is because of getting final value as in two decimals because some times final price value will be shown as 19.9999999999, to avoid this implemented this line pf code
            finalDisplayedFare = Double.parseDouble(finalDisplayedFareAsString);            Logger.logStep("Flights booking details are :- ");
            Logger.logComment("Actual Fare cost of booking flight :- "+displayedActualFare);
            Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmount);
            Logger.logComment("Applied Karam points cost of booking flight :- "+karamPoints);
            Logger.logComment("Final Fare cost of booking flight :- "+finalDisplayedFare);
            if (finalDisplayedFare == 0.0){
                finalDisplayedFare = displayedActualFare;
            }
            if (displayedActualFare.equals(bookingHotelCostInSelectRoomScreen) || displayedActualFare == bookingHotelCostInSelectRoomScreen) {
                finalFareInternalMathCalculation = displayedActualFare-couponAmount-karamPoints;
                decimalFormat = new DecimalFormat("0.00");
                String finalFareInternalMathCalculationAsString = decimalFormat.format(finalFareInternalMathCalculation);
                finalFareInternalMathCalculation = Double.parseDouble(finalFareInternalMathCalculationAsString);
                Logger.logComment("Final fare math calculation value is :- "+finalFareInternalMathCalculation);
                if ((finalFareInternalMathCalculation == finalDisplayedFare) || (finalFareInternalMathCalculation.equals(finalDisplayedFare))) {
                    Logger.logStep("Final fare calculation is correct");
                    Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN = String.valueOf(finalFareInternalMathCalculation); // Code that returns the final price displaying in booking page screen
                }else if (finalFareInternalMathCalculation.toString().contains(finalDisplayedFare.toString())){ // This logic is because of internal math calculation is giving more than a digit after the decimal point eg: 14.10000000000000001 which is not matching with the actual value of Eg: 14.1
                    Logger.logStep("Final fare calculation is correct");
                    Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN = String.valueOf(finalFareInternalMathCalculation); // Code that returns the final price displaying in booking page screen
                }
                else {
                    Logger.logError("Final fare calculation is in correct");
                }
            }else {
                Logger.logError("Booking seat cost in review booking screen is not matching with the cost displaying in booking page..,i.e.., Booking seat cost in Booking page screen & Review Booking screen is:- "+displayedActualFare+" & "+ Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the final fare calculation");
        }
    }

    /**
     * Get the actual displaying fare
     * @return
     */
    public static Double getDisplayedActualFare() {
        Logger.logAction("Getting the displayed actual fare");
        Double actualDisplayingFare = 0.00;
        try
        {
            if (isElementDisplayedById(ACTUAL_DISPLAYING_FARE)){ // Note: Here actual fare is equal to total amount value in the app
                String amount = driver.findElementById(ACTUAL_DISPLAYING_FARE).getText().replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                actualDisplayingFare = Double.parseDouble(amount);
                return actualDisplayingFare;
            }else {
                Logger.logError(ACTUAL_DISPLAYING_FARE+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to get the actual displayed fare");
        }
        return actualDisplayingFare;
    }

    /**
     * Get the coupon applied amount
     * @return
     */
    public Double getCouponAmount() {
        Logger.logAction("Getting the coupon amount");
        Double couponAmount = 0.00;
        try
        {
            if (isCouponCodeAppliedSuccessfully()){
                if (isElementDisplayedById(COUPON_AMOUNT)){
                    String amount = driver.findElementById(COUPON_AMOUNT).getText().replace("( - ) "+ Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                    couponAmount = Double.parseDouble(amount);
                    Logger.logComment("Applied coupon amount is :- "+couponAmount);
                    return couponAmount;
                }else {
                    Logger.logError(COUPON_AMOUNT+" - element name is not displayed in the current active screen");
                }
            }else {
                Logger.logComment("Coupon code is not applied.., So coupon amount applied is :- "+couponAmount);
                return couponAmount;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the Coupon amount");
        }
        return couponAmount;
    }

    /**
     * Get the applied karam points
     * @return
     */
    public Double getKaramPoints() {
        Logger.logAction("Getting the karam points");
        Double karamPoints = 0.00;
        try
        {
            if (SIGN_IN_STATUS == true) {
                scrollToAnElementById_ANDROID(ADD_GUEST_TRAVELLERS_VIEW_TITLE,true);
                if (isKaramPointsToggleSwitchEnabled()){
                    if (isElementDisplayedById(KARAM_POINTS)){
                        String amount = driver.findElementById(KARAM_POINTS).getText().replace("( - ) "+ Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                        karamPoints = Double.valueOf(amount);
                        return karamPoints;
                    }else {
                        Logger.logError(KARAM_POINTS+" - element name is not displayed in the current active screen");
                    }
                }else {
                    Logger.logComment("Karam points toggle switch is disabled, so applied karam points are:- "+karamPoints);
                    return karamPoints;
                }
            }else {
                Logger.logComment("Karam points are applicable only for signed in users, currently user is not signed so applied karam points are:- "+karamPoints);
                return karamPoints;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the karam points");
        }
        return karamPoints;
    }

    /**
     * Get the final displaying fare
     * @return
     */
    public Double getFinalDisplayedFare() {
        Logger.logAction("Getting the displayed final fare");
        Double finalDisplayedFare = 0.00;
        try {
//            scrollToAnElementById_ANDROID(KARAM_POINTS,true);
            String finalFareWithCurrency = findElementByIdAndReturnText(FINAL_FARE);
            if (finalFareWithCurrency.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
                String finalFareWithoutCurrency = finalFareWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                return Double.parseDouble(finalFareWithoutCurrency);
            }
//            if (isUserIsSignedIn() && isCouponCodeAppliedSuccessfully()){
//                if (isElementDisplayedById(FINAL_FARE)) {
//                    String amount = driver.findElementById(FINAL_FARE).getText();
//                    finalDisplayedFare = Double.valueOf(amount);
//                    return finalDisplayedFare;
//                } else {
//                    Logger.logError(FINAL_FARE + " - element name is not displayed in the current active screen");
//                    return finalDisplayedFare;
//                }
//            }else if (isUserIsSignedIn() && !isCouponCodeAppliedSuccessfully()){
//                if (isElementDisplayedById(FINAL_FARE)) {
//                    String amount = driver.findElementById(FINAL_FARE).getText();
//                    finalDisplayedFare = Double.valueOf(amount);
//                    return finalDisplayedFare;
//                } else {
//                    Logger.logComment(FINAL_FARE + " - element name is not displayed in the current active screen");
//                    return finalDisplayedFare;
//                }
//            }
//            else if (!isUserIsSignedIn() && isCouponCodeAppliedSuccessfully()){
//                if (isElementDisplayedById(FINAL_FARE)) {
//                    String amount = driver.findElementById(FINAL_FARE).getText();
//                    finalDisplayedFare = Double.valueOf(amount);
//                    return finalDisplayedFare;
//                } else {
//                    Logger.logComment(FINAL_FARE + " - element name is not displayed in the current active screen");
//                    return finalDisplayedFare;
//                }
//            }
//            else {
//                Logger.logComment("User is neither signed in nor applied coupon code .., So the final fare will not be displayed in the current active screen");
//                finalDisplayedFare = displayedActualFare;
//                return finalDisplayedFare;
//            }
        } catch (Exception OtherThanElementNotFoundException) {
            Logger.logError("Encountered error: Unable to find the displayed final fare amount in the current active screen");
        }
        return finalDisplayedFare;
    }

    /**
     * Check karam points toggle is enabled
     * @return
     */
    public static boolean isKaramPointsToggleSwitchEnabled() {
        Logger.logAction("Checking the karam points toggle is enabled");
        try
        {
            if (isElementDisplayedById(KARAM_POINTS_TOGGLE_BUTTON)){
                String karamPointsToggleStatus = driver.findElementById(KARAM_POINTS_TOGGLE_BUTTON).getAttribute(Labels_Hotels.CHECKED_ATTRIBUTE);
                return karamPointsToggleStatus.equals(Labels_Hotels.STATUS_TRUE);
            }else {
                Logger.logError(KARAM_POINTS_TOGGLE_BUTTON+" - element id is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the karam points toggle button status");
        }
        return false;
    }

    /**
     * Enable the karam points toggle
     * @return
     */
    @Override
    public void enableKaramPointsToggleSwitch() {
        Logger.logAction("Enabling the karam points toggle");
        try
        {
            if (isKaramPointsToggleSwitchEnabled()){
                Logger.logComment("karam points toggle button is already enabled");
            }else {
                WebElement karamPointsToggleSwitch = driver.findElementById(KARAM_POINTS_TOGGLE_BUTTON);
                karamPointsToggleSwitch.click();
                Logger.logComment("Karam points toggle button is enabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enable the karam points toggle button");
        }
    }

    /**
     * Disable the karam points toggle
     * @return
     */
    @Override
    public void disableKaramPointsToggleSwitch() {
        Logger.logAction("Disabling the karam points toggle");
        try
        {
            scrollToAnElementById_ANDROID(KARAM_POINTS_TOGGLE_BUTTON,true);
            if (!(isKaramPointsToggleSwitchEnabled())){
                Logger.logComment("karam points toggle button is already disabled");
            }else {
                WebElement karamPointsToggleSwitch = driver.findElementById(KARAM_POINTS_TOGGLE_BUTTON);
                karamPointsToggleSwitch.click();
                Logger.logComment("Karam points toggle button is disabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enable the karam points toggle button");
        }
    }

    /**
     * Apply coupon code
     */
    @Override
    public void applyTheCouponCode() {
        Logger.logAction("Applying the coupon code");
        try {
            scrollToAnElementById_ANDROID(COUPON_CODE_TEXT_VIEW,true);
            sendKeysToCouponCodeTextField();
            tapOnApplyCouponCodeButton();
            if (isCouponCodeAppliedSuccessfully()){
                Logger.logComment("Coupon code is applied successfully");
            }else {
                Logger.logError("Coupon code is not applied successfully");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to apply the coupon code");
        }
    }

    /**
     * Send keys to coupon code text field
     */
    public void sendKeysToCouponCodeTextField() {
        Logger.logAction("Sending the keys to coupon code text field");
        try {
            if (isElementDisplayedById(COUPON_CODE_TEXT_VIEW)){
                driver.findElementById(COUPON_CODE_TEXT_VIEW).sendKeys(Labels_Hotels.COUPON_CODE);
                Logger.logComment(Labels_Hotels.COUPON_CODE+":- coupon code is parsed");
                closeTheKeyboard_Android();
            }else {
                Logger.logError(COUPON_CODE_TEXT_VIEW+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to send keys to apply coupon code text field");
        }
    }

    /**
     * Tap on apply coupon code button
     */
    public void tapOnApplyCouponCodeButton() {
        Logger.logAction("Tapping on apply coupon code button");
        try {
            if (isElementDisplayedById(APPLY_COUPON_CODE_BUTTON)){
                List<WebElement> element = driver.findElementsById(APPLY_COUPON_CODE_BUTTON);
//                Thread.sleep(2000);
                element.get(0).click();
                if (isElementDisplayedById(APPLY_COUPON_CODE_BUTTON)) { // Todo:- The below if condition are implemented because of tapping is not working on first time
                    WebElement couponID = driver.findElementById(APPLY_COUPON_CODE_BUTTON);
                    tapOnElementBasedOnLocation(couponID,"centerRight");
                }
                Logger.logComment("Tapped on apply coupon button");
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Labels_Hotels.ANDROID_ACTIVITY_INDICATOR))); // Before running check this activity indicator label is correct or not?
            }else {
                Logger.logError(APPLY_COUPON_CODE_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("encountered error: unable to tap on apply coupon code button");
        }
    }

    /**
     * Check the coupon code is applied successfully
     */
    public boolean isCouponCodeAppliedSuccessfully() {
        Logger.logAction("Checking coupon code is applied or not ?");
        try {
            closeTheKeyboard_Android();
            if(isElementDisplayedById(COUPON_AMOUNT)){
                Logger.logComment("Coupon code is applied successfully");
                return true;
            }else if(isElementDisplayedById(COUPON_CODE_TEXT_VIEW)){
                if (isElementDisplayedById(COUPON_CODE_VALIDATION_MESSAGE)){
                    String couponValidationMessage = driver.findElementById(COUPON_CODE_VALIDATION_MESSAGE).getText();
                    if (couponValidationMessage.equals(COUPON_INVALID_MESSAGE)){
                        Logger.logComment("Coupon code is not applied because of incorrect coupon code is entered");
                        return false;
                    }else {
                        Logger.logComment("Coupon code is not applied due to the reason :- "+couponValidationMessage);
                        return false;
                    }
                }else if (isElementDisplayedById(COUPON_AMOUNT)) {
                    Logger.logComment("Coupon code is applied successfully");
                    return true;
                }
                else {
                    Logger.logComment("Coupon code is not yet applied");
                    return false;
                }
            }else {
                Logger.logError(COUPON_CODE_TEXT_VIEW+" Or "+COUPON_AMOUNT+" element names are not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check whether the coupon is applied or not ?");
        }
        return false;
    }

//    /**
//     * Disable the online check in toggle button
//     */
//    public static void disableOnlineCheckInToggleButton(){
//        Logger.logAction("Disabling the online check in toggle button");
//        try{
//            scrollToAnElementById_ANDROID(ONLINE_CHECKIN_TOGGLE_BUTTON,true);
//            if(isElementDisplayedByIdWithOneTimeChecking(ONLINE_CHECKIN_TOGGLE_BUTTON)){
//                WebElement locationOfDay = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
//                Point table = locationOfDay.getLocation();
//                int elementYAxisValue = table.getY();
//                if (Labels_Hotels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
//                    scrollTheCalenderPageUpByDaysGap_Android(); // scrolling values inside are hardcoded by screen basis
//                }
//                WebElement onlineCheckInToggleButton = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
//                String checkedAttribute = onlineCheckInToggleButton.getAttribute(Labels_Hotels.CHECKED_ATTRIBUTE);
//                if (checkedAttribute.equals(Labels_Hotels.STATUS_TRUE)){
//                    Logger.logComment("Online check in toggle button is enabled.., Going to disable by tapping on it");
//                    onlineCheckInToggleButton.click();
//                }else {
//                    Logger.logComment("Online check in toggle button is already disabled");
//                }
//            }else {
//                scrollToAnElementById_ANDROID(ONLINE_CHECKIN_TOGGLE_BUTTON,false);
//                if(isElementDisplayedById(ONLINE_CHECKIN_TOGGLE_BUTTON)){
//                    WebElement locationOfDay = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
//                    Point table = locationOfDay.getLocation();
//                    int elementYAxisValue = table.getY();
//                    if (Labels_Hotels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
//                        scrollTheCalenderPageUpByDaysGap_Android(); // scrolling values inside are hardcoded by screen basis
//                    }
//                    WebElement onlineCheckInToggleButton = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
//                    String checkedAttribute = onlineCheckInToggleButton.getAttribute(Labels_Hotels.CHECKED_ATTRIBUTE);
//                    if (checkedAttribute.equals(Labels_Hotels.STATUS_TRUE)){
//                        Logger.logComment("Online check in toggle button is enabled.., Going to disable by tapping on it");
//                        onlineCheckInToggleButton.click();
//                    }else {
//                        Logger.logComment("Online check in toggle button is already disabled");
//                    }
//                }else {
//                    Logger.logWarning("Online check in button is not visible in the current active screen");
//                }
//            }
//        }catch(Exception exception){
//            Logger.logError("Encountered error: Unable to disable the online check in toggle button");
//        }
//    }

    /**
     * Compare the final price displayed in footer view with the final fare displayed in offers and discounts layout
     */
    public static void compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout() {
        Logger.logAction("Comparing the final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
        try{
            Double reviewBookingPriceInFooterView = getThePriceDisplayedInTheBookingSummaryFooterView();
            Logger.logComment("Review Booking price in footer view :- "+reviewBookingPriceInFooterView);
            Double FinalFareAmountInBookingPage = Double.parseDouble(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN);
            Logger.logComment("Final Fare displayed in the offers and discounts layout :- "+ Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN);
            if((FinalFareAmountInBookingPage == reviewBookingPriceInFooterView) || (FinalFareAmountInBookingPage.equals(reviewBookingPriceInFooterView))){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView == Double.valueOf(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView.toString().contains(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else {
                Logger.logError("Final price displayed in footer view is not matches with the final fare displayed in offers and discounts layout");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to compare the final price displayed in footer view with the final fare displayed in the offers and discounts layout");
        }
    }

    /**
     * Get the price displayed in the booking summary footer view
     * @return
     */
    public static Double getThePriceDisplayedInTheBookingSummaryFooterView(){
        Logger.logAction("Getting the price displayed in the booking summary footer view");
        try {
            String hotelPriceInFooterViewWithCurrency = findElementByIdAndReturnText(PRICE_ID_IN_BOOKING_SUMMARY_SCREEN_FOOTER_VIEW);
            String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
            return Double.parseDouble(hotelPriceWithoutCurrency);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the price displayed in the booking summary footer view");
        }
        return null;
    }

    /**
     * Select the country code by country name
     * @param parsingCountryName
     */
    @Override
    public void selectTheCountryCodeByCountryName(String parsingCountryName){
        Logger.logAction("Selecting the country code of :- "+parsingCountryName);
        try {
            tapOnContactInfoCountryName();
            Thread.sleep(2000);
            selectCountryName(parsingCountryName);
            String contactInfoCountryName = getTheContactInfoCountryName();
            if (contactInfoCountryName.equalsIgnoreCase(parsingCountryName)){
                Logger.logComment("Country code is selected correctly");
            }else {
                Logger.logComment("Parsing country name :- "+parsingCountryName);
                Logger.logComment("Selected country name :- "+contactInfoCountryName);
                Logger.logError("Country code is selected in correctly");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to select the country code by is country name :- "+parsingCountryName);
        }
    }

    /**
     * Tap on contact info country name
     */
    public static void tapOnContactInfoCountryName(){
        Logger.logAction("Tapping on contact info country name");
        try {
            Thread.sleep(2000);
            findElementByIdAndClick(CONTACT_INFO_COUNTRY_LAYOUT);
            Logger.logComment(" Tapped on contact info country name");
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on element name :- "+CONTACT_INFO_COUNTRY_NAME);
        }
    }

    /**
     * Tap on contact info country name
     */
    public static String getTheContactInfoCountryName(){
        Logger.logAction("Getting on contact info country name");
        try {
            WebElement contactInfoCountryNameField = driver.findElementById(CONTACT_INFO_COUNTRY_NAME);
            String contactInfoCountryName = contactInfoCountryNameField.getText();
            Logger.logComment(" Contact info country name displaying in the booking page :- "+contactInfoCountryName);
            return contactInfoCountryName;
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to get the current displaying  contact info country value");
        }
        return null;
    }

    /**
     * Select the country name
     * @param parsingCountryName
     */
    public static void selectCountryName(String parsingCountryName){
        Logger.logAction("Selecting the country name :- "+parsingCountryName);
        try {
            if (isElementDisplayedById(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL)){
                sendTextById(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL,parsingCountryName);
                Thread.sleep(2000);
                if (isElementDisplayedByXPath(XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN)){
                    WebElement firstSearchResult = driver.findElementByXPath(XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN);
                    if (firstSearchResult.getText().equalsIgnoreCase(parsingCountryName)){
                        firstSearchResult.click();
                        Logger.logComment(firstSearchResult.getText()+" :- element name is selected as country");
                    }else {
                        WebElement secondSearchResult = driver.findElementByXPath(XPATH_OF_SECOND_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN);
                        if (secondSearchResult.getText().equalsIgnoreCase(parsingCountryName)){
                            secondSearchResult.click();
                            Logger.logComment(secondSearchResult.getText()+" :- element name is selected as country");
                        }else {
                            Logger.logError(parsingCountryName+" - is not matched with the displayed country name in second search cell :- "+firstSearchResult.getText());
                        }
                    }
                }else {
                    Logger.logError(parsingCountryName+" is not displaying in the current active screen");
                }
            }else {
                Logger.logError(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL+ " - is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to select the country name :- "+parsingCountryName);
        }
    }
}
