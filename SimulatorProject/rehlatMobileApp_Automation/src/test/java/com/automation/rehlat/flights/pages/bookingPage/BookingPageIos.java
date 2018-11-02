package com.automation.rehlat.flights.pages.bookingPage;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingPageIos extends BookingPageBase {

    public static final String XPATH_OF_EMAIL_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[1]";
    public static final String XPATH_OF_PHONE_NUMBER_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[2]";
    public static final String OFFERS_AND_DISCOUNTS_LAYOUT_ID = "OffersAndDiscountsSection";
    public static final String ADULT_TRAVELLERS_BUTTON = "Adult";
    public static final String CONTACT_DETAILS_VIEW ="Contact Details";
    public static final String ADD_TRAVELLERS_DETAILS = "Add Travellers Details";
    public static final String SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON = "Sign in for faster bookings";
    public static final String CONTINUE_BUTTON_IN_BOOKING_PAGE = "Continue";
    public static final String XPATH_OF_COUPON_CODE_TEXT_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField";
    public static final String APPLY_COUPON_CODE_BUTTON = "Apply";
    public static final String COUPON_CODE_FAILED_LABEL = "Coupon is invalid or expired";
    public static final String XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]";
    public static final String KARAM_POINTS_TOGGLE_BUTTON = "XCUIElementTypeSwitch";
    public static final String XPATH_OF_CONTACT_INFO_COUNTRY_CELL = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton";
    public static final String XPATH_OF_CONTACT_INFO_COUNTRY_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText";
    public static final String CHOOSE_COUNTRY_MODAL="Choose Country";
    public static boolean COUPON_CODE_APPLIED_STATUS = false;
    public static final String COUPON_CODE_CLOSE_BUTTON = "X";
    public static final String XPATH_OF_ADD_TRAVELLERS_DETAILS_LABEL = "//XCUIElementTypeStaticText[@name=\"Add Travellers Details\"]";
    public static final String KARAM_WALLET_MESSAGE_ID = "Your Karam wallet is empty.";
    public static final String USE_KARAM_CASH_LABEL_ID = "Use Karam Points";
    public static final String FOOTER_VIEW_PRICE_ID = "price";


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
                Logger.logComment("User is signed in.., so changing the email string with new email");
                enterTextInEmailTextField();
                selectTheCountryCodeByCountryName(Labels_Flights.CONTACT_INFO_COUNTRY_NAME_IOS);
                enterTextInPhoneNumberTextField();
            }else{
                enterTextInEmailTextField();
                selectTheCountryCodeByCountryName(Labels_Flights.CONTACT_INFO_COUNTRY_NAME_IOS);
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
//            String phoneNumber = General.getTheTestDataOfField("Phone_Number");
            sendTextByXpath(XPATH_OF_PHONE_NUMBER_FIELD, Labels_Flights.PHONE_NUMBER);
            Logger.logComment(Labels_Flights.PHONE_NUMBER+" :- is parsed");
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
            String firstName = General.getTheTestDataOfField("First_Name");
            String lastName = General.getTheTestDataOfField("Last_Name");
            String gmailId = firstName+"."+lastName+"@gmial.cm";
            sendTextByXpath(XPATH_OF_EMAIL_FIELD, gmailId);
            Logger.logComment(gmailId+" :- is parsed");
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
            compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout(); // After iOS is implemented by "Online Check In toggle button", this method needs to be removed from here and call it as a step of TC from workflows directly
            if (isElementDisplayedByName(CONTINUE_BUTTON_IN_BOOKING_PAGE)){
                driver.findElementByName(CONTINUE_BUTTON_IN_BOOKING_PAGE).click();
                if (isElementDisplayedByName(CONTINUE_BUTTON_IN_BOOKING_PAGE)) { //Todo :- On first  tap continue button is scrolling the screen upwards. so to navigate to payment screen re tapping on continue button
                    driver.findElementByName(CONTINUE_BUTTON_IN_BOOKING_PAGE).click();
                }
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
    public void tapOnAdultAddTravellersDetailsButton() {
        Logger.logStep("Tapping on adult add travellers details button");
        try{
            scrollDown();
            if (isElementDisplayedByName(ADULT_TRAVELLERS_BUTTON)){
                driver.findElementByName(ADULT_TRAVELLERS_BUTTON).click();
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
    public void tapOnSignInForFasterBookingsButton() {
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
     * Get the price based on price type and element xpath index value
     * @param priceType
     * @return
     */
    public Double getThePriceOf(String priceType) {
        Logger.logAction("Getting the price of element :-"+priceType);
        Double priceValue = null;
        String fareWithCurrency;
        try{
            switch (priceType){
                case "displayedActualFare":
                        if (isElementDisplayedByAccessibilityId("actualFare")){
                            fareWithCurrency = driver.findElementByAccessibilityId("actualFare").getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                            if (fareWithCurrency.contains(Labels_Flights.STRING_COMMA)){
                                fareWithCurrency = fareWithCurrency.replace(Labels_Flights.STRING_COMMA,Labels_Flights.STRING_NULL);
                            }
                            Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE,Labels_Flights.STRING_NULL).trim());
                            return  fareWithoutCurrency;
                        }else {
                            Logger.logError("Actual Fare element is not displayed");
                        }
                case "couponAmount":
                        if (isElementDisplayedByAccessibilityId("couponAmount")){
                            fareWithCurrency = driver.findElementByAccessibilityId("couponAmount").getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                            try {
                                if(!(fareWithCurrency == null)){
                                    Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Flights.MINUS_WITH_IN_BRACKETS+Labels_Flights.CURRENT_USER_CURRENCY_TYPE,Labels_Flights.STRING_NULL).trim());
                                    return  fareWithoutCurrency;
                                }
                            }catch (Exception exception){
                                Logger.logComment("Coupon code is not applied or amount is null..,");
                                return  0.00;
                            }
                        }else {
                            Logger.logError("Coupon amount element is not displayed");
                        }
                case "karamCash":
                        if (isElementDisplayedByAccessibilityId("karamCash")){
                            fareWithCurrency = driver.findElementByAccessibilityId("karamCash").getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                            Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Flights.MINUS_WITH_IN_BRACKETS+Labels_Flights.CURRENT_USER_CURRENCY_TYPE,Labels_Flights.STRING_NULL).trim());
                            return  fareWithoutCurrency;
                        }else {
                            Logger.logError("Karam amount element is not displayed");
                        }
                case "finalDisplayedFare":
                        if (isElementDisplayedByAccessibilityId("finalAmount")){
                            fareWithCurrency = driver.findElementByAccessibilityId("finalAmount").getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                            if (fareWithCurrency.contains(Labels_Flights.STRING_COMMA)){
                                fareWithCurrency = fareWithCurrency.replace(Labels_Flights.STRING_COMMA,Labels_Flights.STRING_NULL);
                            }
                            Double fareWithoutCurrency = Double.parseDouble(fareWithCurrency.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE,Labels_Flights.STRING_NULL).trim());
                            return  fareWithoutCurrency;
                        }else {
                            Logger.logError("Final amount element is not displayed");
                        }
                default: {
                    Logger.logError("For the price of :- "+priceType+" - is not listed in this methods");
                }
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
            Double reviewBookingPriceInFooterView = Double.valueOf(getTheDisplayedTicketBookingValueInFooterView("BookingPageScreen",3));
            Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(reviewBookingPriceInFooterView);
            Logger.logComment("Cost of ticket in Booking page is :- "+reviewBookingPriceInFooterView);

            ////// Below code is to check the values of math calculation done in offers and discounts layout /////
            Double bookingSeatCostInReviewBookingScreen = null;
            Double couponAmount;
            Double finalDisplayedFare;
            Double displayedActualFare;
            Double karamPoints;

            // Checking and getting the booking cost displaying in review booking screen
            if (Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN == null){
                Logger.logError("Booking cost displaying in the review booking screen is :- "+Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
            }else {
                bookingSeatCostInReviewBookingScreen = Double.valueOf(Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
            }
            scrollUp();
            if (COUPON_CODE_APPLIED_STATUS == true){
                couponAmount = getThePriceOf("couponAmount");
            }else {
                couponAmount = 0.00;
                Logger.logComment("Coupon is not applied. So for internal math calculation coupon amount is :- "+couponAmount);
            }
            finalDisplayedFare = getThePriceOf("finalDisplayedFare");
            displayedActualFare = getThePriceOf("displayedActualFare");
            if (isUserSignedIn == true){
                boolean status = isKaramPointsToggleSwitchEnabled();
                if (status == true){
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
            Logger.logAction("All the values are ready for to calculate the math");
            if (displayedActualFare.equals(bookingSeatCostInReviewBookingScreen)){
                Double finalFareMathCalculation = (displayedActualFare)-(couponAmount)-(karamPoints); // Internal math calculation logic
                Logger.logComment("Final fare math calculation value is :- "+finalFareMathCalculation);
                if (finalFareMathCalculation.equals(finalDisplayedFare)){
                    Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
                    Logger.logStep("Final fare calculation is correct");
                }else if (finalFareMathCalculation.toString().contains(finalDisplayedFare.toString())){ // This method is because of internal math calculation is giving more than a digit after the decimal point eg: 14.10000000000000001 which is not matching with the actual value of Eg: 14.1
                    Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
                    Logger.logStep("Final fare calculation is correct");
                }else {
                    Logger.logError("Final fare calculation is in-correct");
                }
            }else {
                Logger.logError("Booking seat cost in review booking screen is not matching with the cost displaying in booking page..,i.e.., Booking seat cost in Booking page screen & Review Booking screen is:- "+displayedActualFare+" & "+Labels_Flights.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
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
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS_LABEL,true); // This logic is to for different iPhones with different sizes
            if ((!(isElementDisplayedByAccessibilityId(KARAM_WALLET_MESSAGE_ID))) || isElementDisplayedByAccessibilityId(USE_KARAM_CASH_LABEL_ID)){
            if (isElementEnabledByClassName(TOGGLE_SWITCH)){
                String karamPointsToggleStatus = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON)).getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
               if (karamPointsToggleStatus.equals(Labels_Flights.VALUE_ONE)){
                   return true;
               }else {
                   return false;
               }
            }else {
                Logger.logWarning(TOGGLE_SWITCH+" - element name is not displayed in the current active screen");
                return false;
            }
            }else
            {
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
            scrollToAnElementByXPath(XPATH_OF_ADD_TRAVELLERS_DETAILS_LABEL,true); // This logic is to for different iPhones with different sizes
            if ((!isElementDisplayedByAccessibilityId(KARAM_WALLET_MESSAGE_ID)) || isElementDisplayedByAccessibilityId(USE_KARAM_CASH_LABEL_ID) ) {
                boolean status = isKaramPointsToggleSwitchEnabled();
                if (status == true) {
                    Logger.logComment("karam points toggle button is already enabled");
                } else {
                    WebElement karamPointsToggleSwitch = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON));
                    karamPointsToggleSwitch.click();
                    Logger.logComment("Karam points toggle button is enabled");
                }
            }else
            {
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
    public static void disableKaramPointsToggleSwitch() {
        Logger.logAction("Enabling the karam points toggle");
        try
        {
            boolean status = isKaramPointsToggleSwitchEnabled();
            if (status!= true){
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
                COUPON_CODE_APPLIED_STATUS = true;
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
        Logger.logAction("Sending the keys to coupon code :- "+ Labels_Flights.COUPON_CODE);
        try {
            if (isElementDisplayedByXPath(XPATH_OF_COUPON_CODE_TEXT_VIEW)){
                driver.findElement(By.xpath(XPATH_OF_COUPON_CODE_TEXT_VIEW)).sendKeys(Labels_Flights.COUPON_CODE);
                Logger.logComment(Labels_Flights.COUPON_CODE+"  :- coupon is parsed");
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
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,2);
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
            if (isElementDisplayedByAccessibilityId(OFFERS_AND_DISCOUNTS_LAYOUT_ID)){
                try{
                    WebElement offersAndDiscountsCloseButton = driver.findElementByAccessibilityId(COUPON_CODE_CLOSE_BUTTON);
                    boolean status = offersAndDiscountsCloseButton.isDisplayed();
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
            Logger.logError("encountered error: unable to check the coupon code status");
        }
        return false;
    }

    /**
     * Compare the final price displayed in footer view with the final fare displayed in offers and discounts layout
     */
    public static void compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout() {
        Logger.logAction("Comparing the final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
        try{
            Double reviewBookingPriceInFooterView = getTheBookingPriceDisplayedInFooterView();
            if (Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN.equals(String.valueOf(reviewBookingPriceInFooterView))){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView == Double.valueOf(Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView.toString().contains(Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN)){
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
//            String contactInfoCountryName = getTheContactInfoCountryName(); //Todo:- This line of code needs to be enabled after setting the name for country name
//            if (contactInfoCountryName.equalsIgnoreCase(parsingCountryName)){
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
            List<WebElement> contactInfoCountryNameFields = driver.findElementsByXPath(XPATH_OF_CONTACT_INFO_COUNTRY_NAME);
            for (int count =0; count <= contactInfoCountryNameFields.size()-1;count++){
                String contactInfoCountryName = contactInfoCountryNameFields.get(count+1).getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                if (contactInfoCountryName.contains("+")){
                    Logger.logComment(" Contact info country name displaying in the booking page :- "+contactInfoCountryName);
                    return contactInfoCountryName;
                }else {
                    continue;
                }
            }
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
