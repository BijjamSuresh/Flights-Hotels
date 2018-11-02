package com.automation.rehlat.hotels.pages.bookingSummary;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookingSummaryIos extends BookingSummaryBase {

    public static final String XPATH_OF_EMAIL_FIELD = "//XCUIElementTypeTextField[@name=\"BS_Email_ID\"]";
    public static final String XPATH_OF_PHONE_NUMBER_FIELD = "//XCUIElementTypeTextField[@name=\"BS_PhoneNumber\"]";
    public static final String XPATH_OF_LOGIN_FOR_KARAM_CASH_BUTTON = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]";
    public static final String GUEST_ROOM_PAX_DETAILS_BUTTON = "paxDetails";
    public static final String LOGIN_FOR_KARAM_CASH_BUTTON = "Login to use Karam Cash";
    public static final String APPLY_COUPON_CODE_BUTTON = "Apply";
    public static final String COUPON_CODE_FAILED_LABEL = "Coupon is invalid or expired";
    public static final String XPATH_OF_CONTACT_DETAILS_VIEW =  "//XCUIElementTypeStaticText[@name=\"Contact Details\"]";
    public static final String XPATH_OF_ADD_TRAVELLERS_DETAILS = "//XCUIElementTypeStaticText[@name=\"Add Guest Travellers\"]";
    public static final String XPATH_OF_COUPON_CODE_TEXT_VIEW = "//XCUIElementTypeTextField[@name=\"BS_ApplyCouponCode\"]";
    public static final String XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW = "//XCUIElementTypeStaticText[@name=\"Offers and Discounts\"]";
    public static final String XPATH_OF_FINAL_FARE_PRICE = "//XCUIElementTypeStaticText[@name=\"BS_FinalAmount\"]";
    public static final String XPATH_OF_TOTAL_AMOUNT = "//XCUIElementTypeStaticText[@name=\"Total Amount\"]";
    public static final String XPATH_OF_COUPON_DISCOUNT_LABEL = "//XCUIElementTypeStaticText[@name=\"Coupon Discount\"]";
    public static final String KARAM_POINTS_TOGGLE_BUTTON = "XCUIElementTypeSwitch";
    public static final String XPATH_OF_FARE_JUMP_ALERT  = "//XCUIElementTypeImage[@name=\"hotel_sold_out\"]";
    public static final String FARE_JUMP_ALERT_ID_MESSAGE  = "hotel_sold_out";
    public static final String CHOOSE_A_DIFFERENT_ROOM_BUTTON_IN_FARE_JUMP_ALERT_MESSAGE  = "Change your Dates";
    public static final String PROCEED_BUTTON_IN_FARE_JUMP_ALERT_MESSAGE  = "See Available Properties";
    public static final String XPATH_OF_CONTACT_INFO_COUNTRY_CELL = "//XCUIElementTypeButton[@name=\"BS_CountryCodeSelction\"]";
    public static final String XPATH_OF_CONTACT_INFO_COUNTRY_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther[3]/XCUIElementTypeStaticText";
    public static final String CHOOSE_COUNTRY_MODAL="Choose Country";
    public static final String CONTINUE_BUTTON = "CONTINUE";
    public static final String BOOKING_SUMMARY = "Booking Summary";
    public static final String COUPON_AMOUNT_PRICE_LABEL_ID = "BS_CouponAmount";
    public static final String TOTAL_AMOUNT_PRICE_LABEL_ID = "BS_TotalAmount";
    public static final String FINAL_AMOUNT_PRICE_LABEL_ID = "BS_FinalAmount";
    public static final String KARAM_AMOUNT_PRICE_LABEL_ID = "BS_WalletAmount";
    public static final String FOOTER_VIEW_PRICE_ID = "BS_BottomAmount";
    public static boolean COUPON_CODE_APPLIED_STATUS = false;
    public static final String XPATH_OF_ADD_TRAVELLERS_DETAILS_LABEL = "//XCUIElementTypeStaticText[@name=\"Add Travellers Details\"]";
    public static final String XPATH_OF_HOTEL_POLICY_LABEL = "//XCUIElementTypeStaticText[@name=\"Hotel Policy\"]";
    public static final String KARAM_WALLET_MESSAGE_ID = "Your Karam wallet is empty.";
    public static final String USE_KARAM_CASH_LABEL_ID = "Use Karam Points";


    // These are used in multiple methods, be on caution while editing these values
//    public static Integer indexOfActualFareElementXPath = null;
//    public static Integer indexOfFinalFareElementXPath = null;
//    public static Integer indexOfAppliedCouponAmountElementXPath = null;

    /**
     * Check booking page screen is displayed
     */
    @Override
    public void checkBookingPageScreenIsDisplayed() {
        Logger.logAction("Checking the Booking page screen is displayed or not ?");
        try{
            if (isElementDisplayedByAccessibilityId(BOOKING_SUMMARY)){
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
        Logger.logAction("Checking the user is signed in or not ?");
        try{
//            WebElement layoutName = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_SCROLL_VIEW);
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS,true);
            if (isElementDisplayedByAccessibilityId(LOGIN_FOR_KARAM_CASH_BUTTON)){
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
            scrollToAnElementByXPath(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW,true);
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
            sendTextByXpath(XPATH_OF_PHONE_NUMBER_FIELD, Labels_Hotels.PHONE_NUMBER);
            Logger.logComment(Labels_Hotels.PHONE_NUMBER+" :- is parsed");
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
            Thread.sleep(2000); //Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
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
            scrollToAnElementByXPath(XPATH_OF_HOTEL_POLICY_LABEL,true);
            compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout(); // After iOS is implemented by "Online Check In toggle button", this method needs to be removed from here and call it as a step of TC from workflows directly
            if (isElementDisplayedByAccessibilityId(GUEST_ROOM_PAX_DETAILS_BUTTON)){
                driver.findElementByAccessibilityId(GUEST_ROOM_PAX_DETAILS_BUTTON).click();
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
            Thread.sleep(4000);
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS,true);
            if (isElementDisplayedByAccessibilityId(LOGIN_FOR_KARAM_CASH_BUTTON)){
//                driver.findElementByAccessibilityId(LOGIN_FOR_KARAM_CASH_BUTTON).click();
                boolean status = findElementByXPathAndClick(XPATH_OF_LOGIN_FOR_KARAM_CASH_BUTTON);
                if (status == true){
                    Logger.logStep("Tapped on signed in for faster booking button");
                }else {
                    Logger.logError(" Didn't tapped on sign in for faster bookings button");
                }
            }else {
                Logger.logError(LOGIN_FOR_KARAM_CASH_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on Sign in for faster bookings button");
        }
    }

    /**
     * Get the price based on price type and element xpath index value
     * @param priceType
     * @return
     */
    public Double getThePriceOf(String priceType) {
        Logger.logAction("Getting the price of element :-"+priceType);
        Double priceValue = null;
        String fareWithCurrency;
        try{
            if (priceType.equals("displayedActualFare")){
                // Checking and getting the applied coupon amount
                if (isElementDisplayedByAccessibilityId(TOTAL_AMOUNT_PRICE_LABEL_ID)){
                    fareWithCurrency = driver.findElementByAccessibilityId(TOTAL_AMOUNT_PRICE_LABEL_ID).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                    if (fareWithCurrency.contains(Labels_Hotels.STRING_COMMA)){
                        fareWithCurrency = fareWithCurrency.replace(Labels_Hotels.STRING_COMMA,Labels_Hotels.STRING_NULL);
                    }
                    Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE,Labels_Hotels.STRING_NULL).trim());
                    return  fareWithoutCurrency;
                }else {
                    Logger.logError("Actual Fare element is not displayed");
                }
            }
            if (priceType.equals("couponAmount")){
                //Checking and getting the actual displaying fare of booking flight
                if (isElementDisplayedByAccessibilityId(COUPON_AMOUNT_PRICE_LABEL_ID)){
                    fareWithCurrency = driver.findElementByAccessibilityId(COUPON_AMOUNT_PRICE_LABEL_ID).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                    try {
                        if(!(fareWithCurrency == null)){
                            Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Hotels.MINUS_WITH_IN_BRACKETS+Labels_Hotels.CURRENT_USER_CURRENCY_TYPE,Labels_Hotels.STRING_NULL).trim());
                            return  fareWithoutCurrency;
                        }
                    }catch (Exception exception){
                        Logger.logComment("Coupon code is not applied or amount is null..,");
                        return  0.00;
                    }

                }else {
                    Logger.logError("Coupon amount element is not displayed");
                }
            }
            if (priceType.equals("karamCash")){
                //Checking and getting the final displaying fare of booking flight
                if (isElementDisplayedByAccessibilityId(KARAM_AMOUNT_PRICE_LABEL_ID)){
                    fareWithCurrency = driver.findElementByAccessibilityId(KARAM_AMOUNT_PRICE_LABEL_ID).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                    Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Hotels.MINUS_WITH_IN_BRACKETS+Labels_Hotels.CURRENT_USER_CURRENCY_TYPE,Labels_Hotels.STRING_NULL).trim());
                    return  fareWithoutCurrency;
                }else {
                    Logger.logError("Karam amount element is not displayed");
                }
            }
            if (priceType.equals("finalDisplayedFare")){
                //Checking and getting the final displaying fare of booking flight
                if (isElementDisplayedByAccessibilityId(FINAL_AMOUNT_PRICE_LABEL_ID)){
                    fareWithCurrency = driver.findElementByAccessibilityId(FINAL_AMOUNT_PRICE_LABEL_ID).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                    if (fareWithCurrency.contains(Labels_Hotels.STRING_COMMA)){
                        fareWithCurrency = fareWithCurrency.replace(Labels_Hotels.STRING_COMMA,Labels_Hotels.STRING_NULL);
                    }
                    Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE,Labels_Hotels.STRING_NULL).trim());
                    return  fareWithoutCurrency;
                }else {
                    Logger.logError("Final amount element is not displayed");
                }
            }
            else {
                Logger.logError("For the price of :- "+priceType+" - is not listed in this method");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to get the price of element :- "+priceType);
        }
        return  priceValue;
    }

    /**
     * Check the final fare calculations are correct
     */
    @Override
    public void checkFinalFareCalculationIsCorrect() {
        Logger.logStep("Checking the final fare calculation is correct or not ?");
        try {
            Double bookingSeatCostInReviewBookingScreen = null;
            Double couponAmount;
            Double finalDisplayedFare;
            Double displayedActualFare;
            Double karamPoints;

            scrollToAnElementByXPath(XPATH_OF_TOTAL_AMOUNT,false);
            // Checking and getting the booking cost displaying in review booking screen
            displayedActualFare = getThePriceOf("displayedActualFare");
            if (Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN == null){
                Logger.logError("Booking cost displaying in the review booking screen is :- "+Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN);
            }else {
                bookingSeatCostInReviewBookingScreen = Double.valueOf(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN);
            }
            scrollToAnElementByXPath(XPATH_OF_COUPON_DISCOUNT_LABEL,true);
//            scrollUp();
//            scrollToAnElementByXPath(XPATH_OF_PHONE_NUMBER_FIELD,false);
//            setTheXpathIndexesForPriceDetailsInOffersAndDiscountsCell();
            if (COUPON_CODE_APPLIED_STATUS == true){
                couponAmount = getThePriceOf("couponAmount");
            }else {
                couponAmount = 0.00;
                Logger.logComment("Coupon is not applied. So for internal math calculation coupon amount is :- "+couponAmount);
            }
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS,true);
            finalDisplayedFare = getThePriceOf("finalDisplayedFare");
            if (isUserSignedIn == true){
                if (isKaramPointsToggleSwitchEnabled()){
                    karamPoints = getThePriceOf("karamCash"); // Implement if condition after developer enable the karam points price element visibility
                }else {
                    karamPoints = 0.00;
                    Logger.logComment("User is logged in, but karam points toggle switch is disabled. So applied karam points are:- "+karamPoints);
                }
            }else {
                karamPoints = 0.00;
                Logger.logComment("User is not logged in. So applied karam points are:- "+karamPoints);
            }
            Logger.logStep("Flights booking details are :- ");
            Logger.logComment("Actual Fare cost of booking flight :- "+displayedActualFare);
            Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmount);
            Logger.logComment("Applied Karam points cost of booking flight :- "+karamPoints);
            Logger.logComment("Final Fare cost of booking flight (Displaying value) :- "+finalDisplayedFare);
//            if (finalDisplayedFare.equals(0.00)){
//                finalDisplayedFare = displayedActualFare;
//                Logger.logComment("Final Fare cost of booking flight (For Math Calculation) :- "+finalDisplayedFare);
//                Logger.logAction("All the values are ready for to calculate the math");
//            }else {
            Logger.logAction("All the values are ready for to calculate the math");
//            }
            if (displayedActualFare.equals(bookingSeatCostInReviewBookingScreen)){
                Double finalFareMathCalculation = (displayedActualFare)-(couponAmount)-(karamPoints); // Internal math calculation logic
                Logger.logComment("Final fare math calculation value is :- "+finalFareMathCalculation);
                if (finalFareMathCalculation.equals(finalDisplayedFare)){
                    Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN = String.valueOf(finalFareMathCalculation);
                    Logger.logStep("Final fare calculation is correct");
                }else if (finalFareMathCalculation.toString().contains(finalDisplayedFare.toString())){ // This method is because of internal math calculation is giving more than a digit after the decimal point eg: 14.10000000000000001 which is not matching with the actual value of Eg: 14.1
                    Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN = String.valueOf(finalFareMathCalculation);
                    Logger.logStep("Final fare calculation is correct");
                }else {
                    Logger.logError("Final fare calculation is in-correct");
                }
            }else {
                Logger.logError("Booking seat cost in review booking screen is not matching with the cost displaying in booking page..,i.e.., Booking seat cost in Booking page screen & Review Booking screen is:- "+displayedActualFare+" & "+Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the final fare calculation");
        }
    }

    /**
     * Check karam points toggle is enabled
     * @return
     */
    public static boolean isKaramPointsToggleSwitchEnabled() {
        Logger.logAction("Checking the karam points toggle is enabled");
        try
        {
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS,true);
            if ((!(isElementDisplayedByAccessibilityId(KARAM_WALLET_MESSAGE_ID)))  || isElementDisplayedByAccessibilityId(USE_KARAM_CASH_LABEL_ID)){
                if (isElementEnabledByClassName(TOGGLE_SWITCH)){
//                    scrollDown(); // This logic is to for different iPhones with different sizes
                String karamPointsToggleStatus = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON)).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                return karamPointsToggleStatus.equals(Labels_Hotels.VALUE_ONE);
            }else {
                Logger.logError(TOGGLE_SWITCH+" - element name is not displayed in the current active screen");
            }
            }else {
                Logger.logStep("Karam wallet is empty.., So no need to enable it..,");
                return false;
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
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS,true);
            if ((!isElementDisplayedByAccessibilityId(KARAM_WALLET_MESSAGE_ID))  || isElementDisplayedByAccessibilityId(USE_KARAM_CASH_LABEL_ID)){
                if (isKaramPointsToggleSwitchEnabled()){
                Logger.logComment("karam points toggle button is already enabled");
            }else {
                WebElement karamPointsToggleSwitch = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON));
                karamPointsToggleSwitch.click();
                Logger.logComment("Karam points toggle button is enabled");
            }
            }else {
                Logger.logStep("Karam wallet is empty.., So no need to enable it..,");
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
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS,true);
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
            scrollToAnElementByXPath(XPATH_OF_COUPON_DISCOUNT_LABEL,true);
            sendKeysToCouponCodeTextField();
            tapOnApplyCouponCodeButton();
            if (isCouponCodeApplied()){
                COUPON_CODE_APPLIED_STATUS = true;
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
                driver.findElementById(APPLY_COUPON_CODE_BUTTON).click();
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
            scrollToAnElementByXPath(XPATH_OF_COUPON_DISCOUNT_LABEL,true);
            if (isElementDisplayedByAccessibilityId("OffersAndDiscountsSection")){
                try{
                    WebElement offersAndDiscountsXpath = driver.findElementByAccessibilityId("BS_CouponAmount");
                    boolean status = offersAndDiscountsXpath.isDisplayed();
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
            Double reviewBookingPriceInFooterView = Double.valueOf(getTheBookingPriceDisplayedInFooterView());
            if (Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN.equals(String.valueOf(reviewBookingPriceInFooterView))){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView == Double.valueOf(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView.toString().contains(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else {
                Logger.logError("Final price displayed in footer view is not matches with the final fare displayed in offers and discounts layout");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to compare the final price displayed in footer view with the final fare displayed in the offers and discounts layout");
        }
    }

    /**
     * Get the booking price displayed in the footer view layout
     * @return
     */
    public static Double getTheBookingPriceDisplayedInFooterView(){
        Logger.logAction("Getting the booking price displayed in footer view");
        try{
            String hotelPriceInFooterViewWithCurrency = driver.findElementByAccessibilityId(FOOTER_VIEW_PRICE_ID).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
            String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
            if (hotelPriceWithoutCurrency .contains(Labels_Hotels.STRING_COMMA)) {
                String hotelPriceWithoutComma = hotelPriceWithoutCurrency.replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
                return Double.parseDouble(hotelPriceWithoutComma);
            }else {
                return Double.parseDouble(hotelPriceWithoutCurrency);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking price displayed in footer view");
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
            scrollToAnElementByXPath(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW,true);
            tapOnContactInfoCountryName();
            selectCountryName(parsingCountryName);
//            String contactInfoCountryName = getTheContactInfoCountryName();//Todo:- This line of code needs to be enabled after setting the name for country name
//            if (contactInfoCountryName.equalsIgnoreCase("India +91")){
//                Logger.logComment("Country code is selected correctly");
//            }else {
//                Logger.logComment("Parsing country name :- "+parsingCountryName);
//                Logger.logComment("Selected country name :- "+contactInfoCountryName);
//                Logger.logError("Country code is selected in correctly");
//            }
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
            boolean status = findElementByXPathAndClick(XPATH_OF_CONTACT_INFO_COUNTRY_CELL);
            if (status == true){
                Logger.logComment(" Tapped on contact info country name");
            }else {
                Logger.logError(" Didn't tapped on contact info country name");
            }
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

//            WebElement contactInfoCountryNameField = driver.findElementByXPath(XPATH_OF_CONTACT_INFO_COUNTRY_NAME);
//            String contactInfoCountryName = contactInfoCountryNameField.getText();
            String contactInfoCountryName = findElementByXpathAndReturnItsAttributeText(XPATH_OF_CONTACT_INFO_COUNTRY_NAME);
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

    /**
     * Check the Fare jump alert is displayed
     */
    @Override
    public boolean isFareJumpAlertIsDisplayed(){
        Logger.logAction("Checking the fare jump alert is displayed or not ?");
        try {
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Hotels.IOS_ACTIVITY_INDICATOR,2);
            String alertMessageName = findElementByXpathAndReturnItsAttributeName(XPATH_OF_FARE_JUMP_ALERT);
            if (alertMessageName.equalsIgnoreCase(FARE_JUMP_ALERT_ID_MESSAGE)){
                Logger.logStep("Fare jump alert is displayed");
                return true;
            }else {
                Logger.logComment("Fare jump alert is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the alert status");
        }
        return false;
    }

    /**
     * Tapped on proceed button in the fare jump alert
     */
    @Override
    public void tapOnProceedButtonInFareJumpAlert(){
        Logger.logAction("Tapping on change your dates button in the Fare jump alert");
        try{
            boolean status = findElementByAccessibilityIdAndClick(PROCEED_BUTTON_IN_FARE_JUMP_ALERT_MESSAGE);
            if (status==true){
                Logger.logComment("Tapped on change your dates button in the Fare jump alert");
            }else {
                Logger.logError("Unable to tap on change your dates button in the Fare jump alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in Fare jump alert");
        }
    }

    /**
     * Tapped on choose different room button in the fare jump alert
     */
    @Override
    public void tapOnChooseDifferentRoomButtonInFareJumpAlert(){
        Logger.logAction("Tapping on change your dates button in the Fare jump alert");
        try{
            boolean status = findElementByAccessibilityIdAndClick(CHOOSE_A_DIFFERENT_ROOM_BUTTON_IN_FARE_JUMP_ALERT_MESSAGE);
            if (status==true){
                Logger.logComment("Tapped on change your dates button in the Fare jump alert");
            }else {
                Logger.logError("Unable to tap on change your dates button in the Fare jump alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in Fare jump alert");
        }
    }
}
