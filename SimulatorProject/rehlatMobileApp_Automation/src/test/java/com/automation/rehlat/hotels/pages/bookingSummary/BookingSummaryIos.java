package com.automation.rehlat.hotels.pages.bookingSummary;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookingSummaryIos extends BookingSummaryBase {

    public static final String XPATH_OF_EMAIL_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[1]";
    public static final String XPATH_OF_PHONENUMBER_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[2]";
    public static final String PLACEHOLDER_TEXT_OF_PHONENUMBER_TEXTFIELD = "Enter your PhoneNumber";
    public static final String ADULT_BUTTON = "Adult";
    public static final String CONTACT_DETAILS_VIEW ="Contact Details";
    public static final String ADD_TRAVELLERS_DETAILS = "Add Travellers Details";
    public static final String XPATH_OF_LOGIN_TO_USE_KARAM_CASH_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView";
    public static final String SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON = "Sign in for faster bookings";
    public static final String APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT = "(-) KWD ";
    public static final String XPATH_OF_COUPON_CODE_TEXT_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField";
    public static final String APPLY_COUPON_CODE_BUTTON = "Apply";
    public static final String COUPON_CODE_FAILED_LABEL = "Coupon is invalid or expired";
    public static final String XPATH_OF_FOOTER_VIEW_LAYOUT = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]";
    public static final String XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]";
    public static final String KARAM_POINTS_TOGGLE_BUTTON = "XCUIElementTypeSwitch";
    public static final String XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]";
    public static final String SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL="com.app.rehlat:id/searchFlightEditText";
    public static final String XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String XPATH_OF_SECOND_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String XPATH_OF_CONTACT_INFO_COUNTRY_CELL = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton";
    public static final String XPATH_OF_CONTACT_INFO_COUNTRY_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText";
    public static final String CHOOSE_COUNTRY_MODAL="Choose Country";
    public static final String CONTINUE_BUTTON = "CONTINUE";


    // These are used in multiple methods, be on caution while editing these values
    public static Integer indexOfActualFareElementXPath = null;
    public static Integer indexOfFinalFareElementXPath = null;
    public static Integer indexOfAppliedCouponAmountElementXPath = null;

    /**
     * Check booking page screen is displayed
     */
    @Override
    public void checkBookingPageScreenIsDisplayed() {
        Logger.logAction("Checking the Booking page screen is displayed or not ?");
        try{
            if (isElementDisplayedByName(CONTACT_DETAILS_VIEW) || isElementDisplayedByName(ADD_TRAVELLERS_DETAILS)){
                Logger.logStep("Booking Page screen is displayed");
            }else{
                Logger.logError("Booking page screen is not displayed");
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
        Logger.logAction("Checking the Booking page screen is displayed or not ?");
        try{
            if (isElementDisplayedByName(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON)){
                Logger.logStep("User is not signed in");
                isUserSignedIn = false;
                return false;
            }else{
                Logger.logStep("User is signed in");
                isUserSignedIn = true;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the user sign in status");
        }
        return true;
    }

    /**
     * Enter user booking information
     */
    @Override
    public void enterUserBookingInfo() {
        Logger.logAction("Entering the user information");
        try {
            if (isUserIsSignedIn()){
                Logger.logComment("User is signed in.., so no need to parse the email string");
                selectTheCountryCodeByCountryName(Labels_Hotels.CONTACT_INFO_COUNTRY_NAME_IOS);
                enterTextInPhoneNumberTextField();
            }else{
                enterTextInEmailTextField();
                selectTheCountryCodeByCountryName(Labels_Hotels.CONTACT_INFO_COUNTRY_NAME_IOS);
                enterTextInPhoneNumberTextField();
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the user info in the respected fields");
        }
    }

    /**
     * Enter the text in phone number text field
     */
    @Override
    public void enterTextInPhoneNumberTextField() {
        Logger.logAction("Entering the text in phone number text field");
        try {
            sendTextByXpath(XPATH_OF_PHONENUMBER_FIELD, Labels_Hotels.phoneNumber);
            Logger.logComment(Labels_Hotels.phoneNumber+" :- is parsed");
            closeTheKeyboard_iOS();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter tje text in phone number text field");
        }
    }

    /**
     * Enter the text in email text field
     */
    @Override
    public void enterTextInEmailTextField() {
        Logger.logAction("Entering the text in email text field");
        try {
            sendTextByXpath(XPATH_OF_EMAIL_FIELD, Labels_Hotels.EMAIL_ID_SIGN_IN);
            Logger.logComment(Labels_Hotels.EMAIL_ID_SIGN_IN+" :- is parsed");
            closeTheKeyboard_iOS();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter tje text in phone number text field");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton() {
        Logger.logAction("Tapping on continue button");
        try{
//            Thread.sleep(2000); //Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
//            compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout(); // After iOS is implemented by "Online Check In toggle button", this method needs to be removed from here and call it as a step of TC from workflows directly
            if (isElementDisplayedByName(CONTINUE_BUTTON)){
                driver.findElementByName(CONTINUE_BUTTON).click();
                if (isElementDisplayedByName(CONTINUE_BUTTON)) { //Todo :- On first  tap continue button is scrolling the screen upwards. so to navigate to payment screen re tapping on continue button
                    driver.findElementByName(CONTINUE_BUTTON).click();
                }
//                if (Labels_Hotels.DEVICENAME.equalsIgnoreCase("iPhone 5s")){ // Todo :- On first  tap in iPhone 5S continue button is doing incorrect functionality
//                    driver.findElementByName(CONTINUE_BUTTON).click();
//                }
                Logger.logStep("Tapped on continue button");
            }else{
                Logger.logError("Unable to tap on continue button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Continue button is not displayed in the current active screen");
        }
    }

    /**
     * Tap on add travellers details button
     */
    @Override
    public void tapOnAddGuestTravellersDetailsButton() {
        Logger.logStep("Tapping on adult add travellers details button");
        try{
            scrollDown();
            if (isElementDisplayedByName(ADULT_BUTTON)){
                driver.findElementByName(ADULT_BUTTON).click();
                Logger.logComment("Tapped on adult button");
            }else{
                Logger.logError("Unable to tap on add travellers details button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Add travellers details button is not displayed in the current active screen");
        }
    }

    /**
     * Tap on sign in for faster bookings button
     */
    @Override
    public void tapOnLoginToUseKaramCashButton() {
        Logger.logStep("Tapping on sign in for faster bookings button");
        try {
            if (isElementDisplayedById(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON)){
                driver.findElementById(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON).click();
                Logger.logAction("Tapped on signed in for faster booking button");
            }else {
                Logger.logError(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON+" - element name is not displayed in the current active screen");
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
        Logger.logStep("Checking the final fare calculation is correct or not ?");
        try {
            Double reviewBookingPriceInFooterView = Double.valueOf(getTheDisplayedTicketBookingValueInFooterView("BookingPageScreen",3));
            Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN = String.valueOf(reviewBookingPriceInFooterView);
            Logger.logComment("Cost of ticket in Booking page is :- "+reviewBookingPriceInFooterView);

            ////// Below code is to check the values of math calculation done in offers and discounts layout /////
            Logger.logComment("Unable to check the final fare calculation due to improper elements implementation on multiple probabilities and conditions...,");
//            Double bookingSeatCostInReviewBookingScreen = null;
//            Double couponAmount;
//            Double finalDisplayedFare;
//            Double displayedActualFare;
//            Double karamPoints;
//
//           // Checking and getting the booking cost displaying in review booking screen
//            if (Labels_Hotels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN == null){
//                Logger.logError("Booking cost displaying in the review booking screen is :- "+Labels_Hotels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
//            }else {
//                bookingSeatCostInReviewBookingScreen = Double.valueOf(Labels_Hotels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
//            }
//            setTheXpathIndexesForPriceDetailsInOffersAndDiscountsCell();
//            couponAmount = getThePriceOf("couponAmount", indexOfAppliedCouponAmountElementXPath);
//            finalDisplayedFare = getThePriceOf("finalDisplayedFare", indexOfFinalFareElementXPath);
//            displayedActualFare = getThePriceOf("displayedActualFare", indexOfActualFareElementXPath);
//            if (isUserIsSignedIn()){
//                karamPoints = Double.valueOf(getKaramPoints()); // Implement if condition after developer enable the karam points price element visibility
//            }else {
//                karamPoints = 0.00;
//                Logger.logComment("User is not logged in. So applied karam points are:- "+karamPoints);
//            }
//            Logger.logStep("Flights booking details are :- ");
//            Logger.logComment("Actual Fare cost of booking flight :- "+displayedActualFare);
//            Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmount);
//            Logger.logComment("Applied Karam points cost of booking flight :- "+karamPoints);
//            Logger.logComment("Final Fare cost of booking flight (Displaying value) :- "+finalDisplayedFare);
//            if (finalDisplayedFare.equals(0.00)){
//                finalDisplayedFare = displayedActualFare;
//                Logger.logComment("Final Fare cost of booking flight (For Math Calculation) :- "+finalDisplayedFare);
//                Logger.logAction("All the values are ready for to calculate the math");
//            }else {
//              Logger.logAction("All the values are ready for to calculate the math");
//            }
//            if (displayedActualFare.equals(bookingSeatCostInReviewBookingScreen)){
//                Double finalFareMathCalculation = (displayedActualFare)-(couponAmount)-(karamPoints); // Internal math calculation logic
//                Logger.logComment("Final fare math calculation value is :- "+finalFareMathCalculation);
//                if (finalFareMathCalculation.equals(finalDisplayedFare)){
//                    Labels_Hotels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
//                    Logger.logStep("Final fare calculation is correct");
//                }else if (finalFareMathCalculation.toString().contains(finalDisplayedFare.toString())){ // This method is because of internal math calculation is giving more than a digit after the decimal point eg: 14.10000000000000001 which is not matching with the actual value of Eg: 14.1
//                    Labels_Hotels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
//                    Logger.logStep("Final fare calculation is correct");
//                }else {
//                    Logger.logError("Final fare calculation is in-correct");
//                }
//            }else {
//                Logger.logError("Booking seat cost in review booking screen is not matching with the cost displaying in booking page..,i.e.., Booking seat cost in Booking page screen & Review Booking screen is:- "+displayedActualFare+" & "+Labels_Hotels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
//            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the final fare calculation");
        }
    }

    /**
     * Get the price based on price type and element xpath index value
     * @param priceType
     * @param indexOfAPriceDisplayingInOffersAndDiscountsCell
     * @return
     */
    public Double getThePriceOf(String priceType, Integer indexOfAPriceDisplayingInOffersAndDiscountsCell) {
        Logger.logAction("Getting the price of element :-"+indexOfAPriceDisplayingInOffersAndDiscountsCell);
        Double priceValue = null;
        try{
            if (priceType.equals("couponAmount")){
                // Checking and getting the applied coupon amount
                if (indexOfAppliedCouponAmountElementXPath == null){
                    priceValue = 0.00;
                    return  priceValue;
                }else {
                    priceValue = Double.valueOf(getCouponAmount(indexOfAppliedCouponAmountElementXPath));
                    return  priceValue;
                }
            }
            if (priceType.equals("displayedActualFare")){
                //Checking and getting the actual displaying fare of booking flight
                if (indexOfActualFareElementXPath == null){
                    Logger.logError("Actual displaying Booking cost is :- "+ Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN);
                }else {
                    priceValue = Double.valueOf(getDisplayedActualFare(indexOfActualFareElementXPath));
                    return  priceValue;
                }
            }
            if (priceType.equals("finalDisplayedFare")){
                //Checking and getting the final displaying fare of booking flight
                if (indexOfFinalFareElementXPath == null){
                    priceValue = 0.00;
                    return  priceValue;
                }else {
                    priceValue = Double.valueOf(getFinalDisplayedFare(indexOfFinalFareElementXPath));
                    return  priceValue;
                }
            }
            else {
                Logger.logError("For the price of :- "+priceType+" - is not listed in this method");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the price of element :- "+indexOfAPriceDisplayingInOffersAndDiscountsCell);
        }
        return  priceValue;
    }

    /**
     * Set the xpath indexes for price details in offers and discounts
     */
    public void setTheXpathIndexesForPriceDetailsInOffersAndDiscountsCell() {
        Logger.logAction("Setting xpath indexes for price details in offers and discounts cell");
        try {
            if (isUserIsSignedIn()){
                if (isCouponCodeApplied() && isKaramPointsToggleSwitchEnabled()){
                    indexOfActualFareElementXPath = 6;
                    indexOfFinalFareElementXPath = 8;
                    indexOfAppliedCouponAmountElementXPath = 7;
                    // Add karam points xpath integer value also after enabling the element detection by developer
                }else if (isCouponCodeApplied() && !(isKaramPointsToggleSwitchEnabled())){
                    indexOfActualFareElementXPath = 6;
                    indexOfFinalFareElementXPath = 8;
                    indexOfAppliedCouponAmountElementXPath = 7;
                } else {
                    indexOfActualFareElementXPath = 3;
                }
            }else {
                if (isCouponCodeApplied()){
                    indexOfActualFareElementXPath = 6;
                    indexOfFinalFareElementXPath = 8;
                    indexOfAppliedCouponAmountElementXPath = 7;
                } else {
                    indexOfActualFareElementXPath = 3;
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the xpath indexes for price details in offers and discounts cell");
        }
    }

    /**
     * Get the actual displaying fare
     * @return
     */
    public static String getDisplayedActualFare(Integer indexOfActualFareElementXPAth) {
        Logger.logAction("Getting the displayed actual fare");
        String actualDisplayingFare = null;
        try
        {
            String xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfActualFareElementXPAth+"]"; // "indexOfActualFareElementXPath" is the hard coded value of actual fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
            String ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
            String actualAmountPrice = ActualFareWithCurrentName.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+ Labels_Hotels.STRING_NULL, Labels_Hotels.STRING_NULL);
            Logger.logComment("Actual Fare cost of booking flight :- "+actualAmountPrice);
            actualDisplayingFare = actualAmountPrice;
            return actualDisplayingFare;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the actual displayed fare");
        }
        return actualDisplayingFare;
    }

    /**
     * Get the coupon applied amount
     * @return
     */
    public static String getCouponAmount(Integer indexOfAppliedCouponAmountElementXPAth) {
        Logger.logAction("Getting the coupon amount");
        String couponAmount = "0";
        String xPathOfActualFare;
        String ActualFareWithCurrentName;
        try
        {
            xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfAppliedCouponAmountElementXPAth+"]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
            try {
                ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                if(ActualFareWithCurrentName.contains(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT)){
                    String couponAmountPrice = ActualFareWithCurrentName.replace(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT,"");
                    Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmountPrice);
                    couponAmount = couponAmountPrice;
                    return couponAmount;
                }else {
                    indexOfAppliedCouponAmountElementXPAth = indexOfAppliedCouponAmountElementXPAth+1;
                    xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfAppliedCouponAmountElementXPAth+"]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
                    ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                    if (ActualFareWithCurrentName.contains(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT)){
                        String couponAmountPrice = ActualFareWithCurrentName.replace(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT,"");
                        Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmountPrice);
                        couponAmount = couponAmountPrice;
                        indexOfFinalFareElementXPath = 7;
                        return couponAmount;
                    }
                    else {
                        Logger.logError(ActualFareWithCurrentName+" - element is not matching with the coupon amount nor with the actual fare");
                    }
                }
            }catch (Exception exception){
                Logger.logComment("Coupon code is not applied..,");
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
    public static String getKaramPoints() {
        Logger.logAction("Getting the karam points");
        String karamPoints = "0";
        try
        {
            if (isKaramPointsToggleSwitchEnabled()){
                Logger.logWarning("Karam points locator is invisible in inspector, discuss with developer and implement a method to get the displaying karam points");
                Logger.logComment("Currently hardcoding the karam points as:- " + Labels_Hotels.IOS_APPLIED_KARAM_POINTS);
                karamPoints = Labels_Hotels.IOS_APPLIED_KARAM_POINTS;
                Logger.logComment("Applied Karam points cost of booking flight :- "+karamPoints);
                return karamPoints;
            }else {
                Logger.logComment("Karam points toggle switch is disabled.So, the applied karam points are :- "+karamPoints);
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
    public static String getFinalDisplayedFare(Integer indexOfFinalFareElementXPAth) {
        Logger.logAction("Getting the displayed final fare");
        String finalDisplayedFare = null;
        try
        {
            String xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfFinalFareElementXPAth+"]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
            String ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
            String actualAmountPrice = ActualFareWithCurrentName.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+ Labels_Hotels.STRING_NULL, Labels_Hotels.STRING_NULL);
            finalDisplayedFare = actualAmountPrice;
            Logger.logComment("Final Fare cost of booking flight :- "+finalDisplayedFare);
            return finalDisplayedFare;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the final displayed fare");
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
            if (isElementEnabledByClassName(TOGGLE_SWITCH)){
                scrollDown(); // This logic is to for different iPhones with different sizes
                String karamPointsToggleStatus = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON)).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                return karamPointsToggleStatus.equals(Labels_Hotels.VALUE_ONE);
            }else {
                Logger.logError(TOGGLE_SWITCH+" - element name is not displayed in the current active screen");
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
                WebElement karamPointsToggleSwitch = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON));
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
        Logger.logAction("Enabling the karam points toggle");
        try
        {
            if (!isKaramPointsToggleSwitchEnabled()){
                Logger.logComment("karam points toggle button is already disabled");
            }else {
                WebElement karamPointsToggleSwitch = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON));
                karamPointsToggleSwitch.click();
                Logger.logComment("Karam points toggle button is disabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to disable the karam points toggle button");
        }
    }

    /**
     * Apply coupon code
     */
    @Override
    public void applyTheCouponCode() {
        Logger.logStep("Applying the coupon code");
        try {
            sendKeysToCouponCodeTextField();
            tapOnApplyCouponCodeButton();
            if (isCouponCodeApplied()){
                Logger.logComment("Coupon code is applied successfully");
            }else {
                Logger.logComment("Coupon code is not applied successfully");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to apply the coupon code");
        }
    }

    /**
     * Send keys to coupon code text field
     */
    public void sendKeysToCouponCodeTextField() {
        Logger.logAction("Sending the keys to coupon code :- "+ Labels_Hotels.COUPON_CODE);
        try {
            if (isElementDisplayedByXPath(XPATH_OF_COUPON_CODE_TEXT_VIEW)){
                driver.findElement(By.xpath(XPATH_OF_COUPON_CODE_TEXT_VIEW)).sendKeys(Labels_Hotels.COUPON_CODE);
                Logger.logComment(Labels_Hotels.COUPON_CODE+"  :- coupon is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(XPATH_OF_COUPON_CODE_TEXT_VIEW+" - element xpath is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to send keys to apply coupon code text field");
        }
    }

    /**
     * Tap on apply coupon code button
     */
    public void tapOnApplyCouponCodeButton() {
        Logger.logAction("Tapping on apply coupon code");
        try {
            if (isElementDisplayedById(APPLY_COUPON_CODE_BUTTON)){
                driver.findElement(By.id(APPLY_COUPON_CODE_BUTTON)).click();
                Logger.logComment("Tapped on apply coupon code button");
                waitForAnElementToDisappear_ById(APPLY_COUPON_CODE_BUTTON);
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(APPLY_COUPON_CODE_BUTTON)));
            }else {
                Logger.logError(APPLY_COUPON_CODE_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to tap on apply coupon code button");
        }
    }

    /**
     * Check the applied coupon code is applied successfully
     */
    public static boolean isCouponCodeApplied() {
        Logger.logAction("Checking coupon code is applied successfully");
        try {
            if (isElementDisplayedByXPath(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW)){
                try{
                    WebElement offersAndDiscountsXpath = driver.findElementByXPath(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW);
                    boolean status = offersAndDiscountsXpath.findElement(By.id(Labels_Hotels.COUPON_CODE)).isDisplayed();
                    if (status==true){
                        return true;
                    }else if (isElementDisplayedById(COUPON_CODE_FAILED_LABEL)){
                        return false;
                    }else {
                        return false;
                    }
                }catch (Exception elementNotFound){
                    return false;
                }
            }else {
                Logger.logError(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+" \n - element xpath is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to tap on apply coupon code button");
        }
        return false;
    }

    /**
     * Compare the final price displayed in footer view with the final fare displayed in offers and discounts layout
     */
    public static void compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout() {
        Logger.logAction("Comparing the final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
        try{
            Double reviewBookingPriceInFooterView = Double.valueOf(getTheDisplayedTicketBookingValueInFooterView("BookingPageScreen",3));
            if (Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN.equals(String.valueOf(reviewBookingPriceInFooterView))){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView == Double.valueOf(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView.toString().contains(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else {
                Logger.logError("Final price displayed in footer view is not matches with the final fare displayed in offers and discounts layout");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to compare the final price displayed in footer view with the final fare displayed in the offers and discounts layout");
        }
    }

//    /**
//     * Get the booking price displayed in the footer view layout
//     * @return
//     */
//    public static Double getTheBookingPriceDisplayedInFooterView(){
//        Logger.logAction("Getting the booking price displayed in footer view");
//        try{
//            Thread.sleep(1000);
////            if (isElementDisplayedByXPath(XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE)){
////                String xPathOfReviewBookingPrice = XPATH_OF_FOOTER_VIEW_LAYOUT+"/XCUIElementTypeStaticText[2]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
////                if (isElementDisplayedByXPath(xPathOfReviewBookingPrice)){
//                WebElement footerView = driver.findElementByXPath(XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE);
//                List<WebElement> xcuiElementTypeStaticText = footerView.findElements(By.className("XCUIElementTypeStaticText"));
//                for (int index=0;index<=xcuiElementTypeStaticText.size();index++){
//                    String eachValueInFooterView = xcuiElementTypeStaticText.get(index).getAttribute("name");
//                    if (eachValueInFooterView.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
//                        String actualAmountPrice = eachValueInFooterView.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+Labels_Hotels.ONE_CHARACTER_SPACE, "");
//                        Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
//                        return Double.valueOf(actualAmountPrice);
//                    }
//                }
////                    String ActualFareWithCurrentName = driver.findElementByXPath(xPathOfReviewBookingPrice).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
////                    String actualAmountPrice = ActualFareWithCurrentName.replace("KWD ", "");
////                    return Double.valueOf(actualAmountPrice);
////                }else {
////                    Logger.logError(xPathOfReviewBookingPrice+" xpath is incorrect..,Please re check the xpath of review booking price in footer view");
////                }
//
////            }else {
////                Logger.logError(XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE+" :- Xpath of footer view is not displayed in the current screen");
////            }
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to get the booking price displayed in footer view");
//        }
//        return null;
//    }
    /**
     * Select the country code by country name
     * @param parsingCountryName
     */
    @Override
    public void selectTheCountryCodeByCountryName(String parsingCountryName){
        Logger.logAction("Selecting the country code of :- "+parsingCountryName);
        try {
            tapOnContactInfoCountryName();
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
            findElementByXPathAndClick(XPATH_OF_CONTACT_INFO_COUNTRY_CELL);
            Logger.logComment(" Tapped on contact info country name");
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on element name :- "+XPATH_OF_CONTACT_INFO_COUNTRY_CELL);
        }
    }

    /**
     * Tap on contact info country name
     */
    public static String getTheContactInfoCountryName(){
        Logger.logAction("Getting on contact info country name");
        try {
            WebElement contactInfoCountryNameField = driver.findElementByXPath(XPATH_OF_CONTACT_INFO_COUNTRY_NAME);
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
     * @param parsingCountryNameWithCode
     */
    public static void selectCountryName(String parsingCountryNameWithCode){
        Logger.logAction("Selecting the country name :- "+parsingCountryNameWithCode);
        try {
            if (isElementDisplayedByName(CHOOSE_COUNTRY_MODAL)) {
                chooseCountry(parsingCountryNameWithCode);
            }else{
                Logger.logError("Choose country modal is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to select the country name :- "+parsingCountryNameWithCode);
        }
    }

    /**
     * Select the country name from choose country modal
     * @param parsingCountryNameWithCode
     */
    // To do: Implement a method such that automatically select the country name (if country name is not on visible list scroll to that element and click on it)
    public static void chooseCountry(String parsingCountryNameWithCode) {
        Logger.logAction("Choosing the country name :- "+parsingCountryNameWithCode);
        try{
            findElementByNameAndClick(parsingCountryNameWithCode);
            Logger.logComment(parsingCountryNameWithCode+" :- country name with code is selected");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to choose the country name");
        }
    }
}
