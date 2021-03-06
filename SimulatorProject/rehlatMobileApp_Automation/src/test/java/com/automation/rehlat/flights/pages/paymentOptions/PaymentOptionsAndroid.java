package com.automation.rehlat.flights.pages.paymentOptions;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class PaymentOptionsAndroid extends PaymentOptionsBase {
    public static final String PAYMENT_OPTIONS_TITLE = "com.app.rehlat:id/paymentheaderllyt";
    public static final String PAYMENT_RELATIVE_LAYOUT_TITLE_FOR_EG_DOMAIN = "com.app.rehlat:id/paymentRelativeLayout";
    public static final String PAYMENT_GATEWAY_SCREEN_TITLE = "com.app.rehlat:id/transactionHeaderBck";
    public static final String ACTIVITY_INDICATOR = "com.app.rehlat:id/flight_search_progressbar";
    public static final String XPATH_OF_SELECT_YOUR_BANK_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.GridView/android.view.View[2]/android.view.View/android.view.View/android.view.View[6]/android.view.View[2]/android.widget.Spinner";
    public static final String XPATH_OF_CARD_NUMBER_VIEW = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.GridView/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]";
    public static final String PIN_TEXTFIELD = "Ecom_Payment_Pin_id";
    public static final String SUBMIT_BUTTON = "EntrySubmitAction_id";
    public static final String CONFIRM_BUTTON = "ConfirmAction_id";
    public static final String FARE_DIFFER_ALERT = "com.app.rehlat:id/information_fare_differ";
    public static final String YES_BUTTON_IN_FARE_DIFFER_ALERT = "com.app.rehlat:id/yesFareDifference";
    public static final String SELECT_YOUR_BANK_MODAL_SHEET = "android:id/customPanel";
    public static final String TRANSACTION_IN_PROGRESS = "Transaction in progress...";
    public static final String PAYMENT_SUCCESS = "Payment Success Please wait for a while and do not refresh the page..........";
    public static final String BOOKING_SUCCESS = "BOOKING SUCCESS";
    public static final String POST_TRANSACTIONS_SCREEN = "form1";
    public static final String TICKET_SOLD_OUT_POPUP = "com.app.rehlat:id/searchForDifferentFlights";
    public static final String OK_BUTTON = "OK";
    public static final String FINAL_AMOUNT_PAYABLE_LINEAR_LAYOUT = "com.app.rehlat:id/totalAmoutPayableLinearLayout";
    public static final String FINAL_AMOUNT_PAYABLE_PRICE = "com.app.rehlat:id/totalAmountPayablePrice";
    public static final String PAYMENT_FAILED_TITLE = "com.app.rehlat:id/payment_tryAgain";
    public static final String XPATH_OF_KNET_PAYMENT_CELL = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout";
    public static final String XPATH_OF_KNET_PAYMENT_CELL_NAME = XPATH_OF_KNET_PAYMENT_CELL+"/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView";
    public static final String XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[";
    public static boolean FARE_JUMP_STATUS = false;

    /**
     * Check the payment options screen is displayed
     */
    @Override
    public void checkPaymentOptionsScreenIsDisplayed() {
        Logger.logAction("Checking payment option screen is displayed or not ?");
        try{
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(ACTIVITY_INDICATOR,false);
            if (Labels_Flights.CONFIGURATION_TYPE.equalsIgnoreCase("Stage")){
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(ACTIVITY_INDICATOR,false);
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(ACTIVITY_INDICATOR,false);
            }
//            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
            acceptTheFareDifferAlert();
            Logger.logComment("Checking payment option screen is displayed or not ?");
            //Todo:- The below if condition is commented as PG screen of all domains is same in the current running builds(in previous builds EG domain PG screen is different compared to other domains)
//            if (Labels_Flights.CURRENT_USER_CURRENCY_TYPE.equalsIgnoreCase(Labels_Flights.EGYPT_CURRENCY_TYPE)){
//                if (isElementDisplayedById(PAYMENT_RELATIVE_LAYOUT_TITLE_FOR_EG_DOMAIN)){
//                    Logger.logStep("Payment options screen is displayed and moving to next step");
//                }else {
//                    Logger.logError("Payment options screen is not displayed");
//                }
//            }else {
                if (isElementDisplayedById(PAYMENT_OPTIONS_TITLE)){
                    Logger.logStep("Payment options screen is displayed and moving to next step");
                }else {
                    Logger.logError("Payment options screen is not displayed");
                }
//            }//Todo:- Logic ends till this line
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
    }

    /**
     * Checking the ticket sold out popup is displayed
     * @return
     */
    @Override
    public boolean isTicketSoldOutPopUpIsDisplayed() {
        Logger.logAction("Checking the ticket sold out popup is displayed or not ?");
        try{
//            acceptTheFareDifferAlert(); // Todo:- This line of code and the below if condition is implemented so that the app may change the layout to payment list screen from booking page
//            if (isElementDisplayedById(ACTIVITY_INDICATOR)){
//                Logger.logStep("Waiting till the activity indicator is invisible in the current active screen");
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
//            }else {
//                Logger.logStep("Activity indicator is not displayed in the current active screen");
//            }
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(ACTIVITY_INDICATOR,false);
            acceptTheFareDifferAlert();
            if (isElementDisplayedById(TICKET_SOLD_OUT_POPUP)){
                BaseTest.takeScreenshotAndSaveInSoldOutsFolder();
                Logger.logStep(TICKET_SOLD_OUT_POPUP +" - popup is displayed in the current active screen");
                return true;
            }else {
                Logger.logStep(TICKET_SOLD_OUT_POPUP +" - popup is not displayed in the current active screen");
                return false;
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the popup is displayed or not");
        }
        return false;
    }

    /**
     * Tap on ok button in ticket sold out popup
     */
    @Override
    public void tapOnOkButtonInTicketSoldOutPopup() {
        Logger.logAction("Tapping on "+TICKET_SOLD_OUT_POPUP+ " button");
        try {
            if (isElementDisplayedById(TICKET_SOLD_OUT_POPUP)){
                driver.findElementById(TICKET_SOLD_OUT_POPUP).click();
                Logger.logComment("Tapped on ok button in sold out popup");
            }else {
                Logger.logError(" - button name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on OK button in ticket sold out popup");
        }
    }


    /**
     * Check the auto fare differ information popup is displayed
     */
    public static void acceptTheFareDifferAlert() {
        Logger.logAction("Accepting the fare differ alert if displayed");
        try {
            if (isElementDisplayedById(FARE_DIFFER_ALERT)){
                FARE_JUMP_STATUS = true;
                Logger.logStep("Fare differ alert is displayed and going to accept it by tapping on yes button");
                driver.findElementById(YES_BUTTON_IN_FARE_DIFFER_ALERT).click();
            }else {
                Logger.logComment(FARE_DIFFER_ALERT+" :- element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the fare differ alert is displayed or not");
        }
    }

    /**
     * Compare the final payment displayed in payment checkout screen with the amount displayed in review booking screen
     */
    @Override
    public void compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen() {
        String finalAmountPayablePriceInPaymentCheckOutScreen;
        Double differnce;
        Logger.logAction("Comparing the final payment displayed in payment checkout screen with the amount displayed in review booking screen");
        try {
            if (isElementDisplayedById(FINAL_AMOUNT_PAYABLE_LINEAR_LAYOUT)){
                Logger.logAction("Total amount payable price linear layout is displayed");
                if (isElementDisplayedById(FINAL_AMOUNT_PAYABLE_PRICE)){
                    finalAmountPayablePriceInPaymentCheckOutScreen = driver.findElementById(FINAL_AMOUNT_PAYABLE_PRICE).getText();
                    if (finalAmountPayablePriceInPaymentCheckOutScreen.contains(Labels_Flights.CURRENT_USER_CURRENCY_TYPE)){
                        finalAmountPayablePriceInPaymentCheckOutScreen = finalAmountPayablePriceInPaymentCheckOutScreen.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE,Labels_Flights.STRING_NULL).trim();
                    }
                    if(finalAmountPayablePriceInPaymentCheckOutScreen.contains(Labels_Flights.STRING_COMMA)){
                        finalAmountPayablePriceInPaymentCheckOutScreen = finalAmountPayablePriceInPaymentCheckOutScreen.replace(Labels_Flights.STRING_COMMA,Labels_Flights.STRING_NULL).trim();
                    }
                    Double finalPriceInFinalAmountPayablePriceInPaymentCheckOutScreen = Double.valueOf(finalAmountPayablePriceInPaymentCheckOutScreen);
//                    if (finalLetterInFinalAmountPayablePriceInPaymentCheckOutScreen.equals("0")){
//                        finalAmountPayablePriceInPaymentCheckOutScreen = finalAmountPayablePriceInPaymentCheckOutScreen.replace("0","");
//                    }
                    Logger.logComment("Final Amount displayed in the payment check out screen is :- "+finalPriceInFinalAmountPayablePriceInPaymentCheckOutScreen);
                    Logger.logComment("Booking cost displayed in review booking screen is :- "+ Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN);
                    if (FARE_JUMP_STATUS == true){
                        Logger.logStep("Fare jump was happened.,So fare displaying in the payment check out screen is the final one .ie.., final payment is : " +finalPriceInFinalAmountPayablePriceInPaymentCheckOutScreen);
                        FARE_JUMP_STATUS =false;// Todo:- Resetting the fare jump status to false.
                    }else {
                        if (Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN.equalsIgnoreCase(finalAmountPayablePriceInPaymentCheckOutScreen) || Double.parseDouble(Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN) == (finalPriceInFinalAmountPayablePriceInPaymentCheckOutScreen)){
                            Logger.logStep("Final Amount displayed in the payment check out screen is matches with booking cost displayed in review booking screen");
                        }
                        else {
                            differnce = Double.parseDouble(Labels_Flights.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN) - finalPriceInFinalAmountPayablePriceInPaymentCheckOutScreen;
                            if (differnce < 0.2){
                                Logger.logStep("Final Amount displayed in the payment check out screen is not matches with booking cost displayed in review booking screen but the difference is very less .ie.., "+differnce+", so continuing with the final amount as :- "+finalPriceInFinalAmountPayablePriceInPaymentCheckOutScreen);
                            }else {
                                Logger.logError("Final Amount displayed in the payment check out screen is not matches with booking cost displayed in review booking screen");
                            }
                        }
                    }
                }else {
                    Logger.logError(FINAL_AMOUNT_PAYABLE_PRICE+" :- Element id is not displaying in payment checkout screen");
                }
            }else {
                Logger.logError(FINAL_AMOUNT_PAYABLE_LINEAR_LAYOUT+" :- Linear layout is not displaying in payment checkout screen");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to compare the final payment price in payment list screen with the price dispalyed in review booking screen");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                                        //** KNET PAYMENT METHODS **\\

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Tap on KNET payment gateway
     */
    @Override
    public void tapOnKnetPaymentGateWay() {
        Logger.logAction("Tapping on KNET payment gateway");
        try{
        List<WebElement> paymentsList = driver.findElementsById("com.app.rehlat:id/card_type_textview");// Checking the knet payment cell is displayed
        for (int count=0; count < paymentsList.size()-1;count++){
            WebElement paymentGateWayCell = paymentsList.get(count);
            String paymentGateWayName = paymentGateWayCell.getText(); // Getting the value of KNET payment cell name
                if (paymentGateWayName.contains("Knet")){ // 'Contains' is because of in SA domain KNET button is having some text along with KNET label
                    paymentGateWayCell.click();
                    Logger.logComment("Tapped on Knet payment option");
                    break;
                }else {
                    Logger.logError("Knet Payment gateway xpath is changed, please do re check the KNET xpath and re-run again");
                }
                if (count == paymentsList.size()-1){
                    Logger.logError("KNET Payment gateway option is not displayed");
                }
        }

    }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name - " + XPATH_OF_KNET_PAYMENT_CELL_NAME);
        }
    }

    /**
     * Check KNET payment gateway screen is displayed
     */
    @Override
    public void checkKnetPaymentOptionsScreenIsDisplayed() {
        Logger.logAction("Checking KNET payment gateway screen is displayed or not ?");
        try{
//            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(ACTIVITY_INDICATOR,false);
            if (isElementDisplayedById(PAYMENT_GATEWAY_SCREEN_TITLE) && (isElementDisplayedById(SUBMIT_BUTTON))){
                Logger.logStep("KNET Payment gateway screen is displayed and moving to next step");
            }else if (isElementDisplayedById(PAYMENT_FAILED_TITLE)){
                System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                        "//////////////////////////////////////////  "+"PAYMENT FAILED"+"////////////////////////////////////////////////////\n"+
                        "        ////////////////////////////////////////////////////////////////////////////////////\n");
                Logger.logError("Payment failed error screen is displayed");
            }else {
                Logger.logError("Payment screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name - " + PAYMENT_GATEWAY_SCREEN_TITLE +","+CONFIRM_BUTTON);
        }
    }

    /**
     * Selecting bank name
     */
    @Override
    public void selectingBankName(String bankName) {
        Logger.logAction("Selecting bank name - " + bankName );
        try{
            if (isElementDisplayedByXPath(XPATH_OF_SELECT_YOUR_BANK_BUTTON)){
//                Logger.logStep("KNET Payment gateway screen is displayed and moving to next step");
                driver.findElementByXPath(XPATH_OF_SELECT_YOUR_BANK_BUTTON).click();
                Logger.logComment("Tapped on select your bank field");
                selectBankNameFromBankPicker(bankName);
            }else {
                Logger.logError("Select your bank option is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the field name xpath:- " +XPATH_OF_SELECT_YOUR_BANK_BUTTON);
        }
    }

    /**
     * Selecting the bank name from the picker wheel
     */
    public static void selectBankNameFromBankPicker(String bankName) {
        WebElement nameOfTheCell;
        Logger.logAction("Selecting the bank :- "+bankName);
        try {
            if(isElementDisplayedById(SELECT_YOUR_BANK_MODAL_SHEET)){
                int cellNumber = scrollToTheBankName(bankName);
                nameOfTheCell = driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]");
                if (nameOfTheCell.getText().equals(bankName)){
                    driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]").click();
                    Logger.logComment(bankName+" :- bank name is parsed");
//                    runAppInBackground(2);
                }else {
                    scrollTheScreenUpwards();
                    nameOfTheCell = driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]");
                    if (nameOfTheCell.getText().equals(bankName)){
                        driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]").click();
                        Logger.logComment(bankName+" :- bank name is parsed");
                    }else {
                        Logger.logError("Tried scrolling the modal view twice, but didn't find the bank name:-"+bankName);
                    }
                }
            }else {
                Logger.logError("Banks list modal view is not displayed to select the bank name:-" +bankName);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the bank picker");
        }
    }

    /**
     * Scroll to the bank name
     * @param bankName
     */
    public static int scrollToTheBankName(String bankName) {
        Logger.logAction("Scrolling to the bank name:-" + bankName);
        Integer bankCellNumber = 8;
        List<WebElement> listOfBanksDisplayed = null;
        int count = 0;
        try {
            while (count < 4) {
                try {
                    Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
                    listOfBanksDisplayed = driver.findElements(By.className("android.widget.CheckedTextView"));
                    for (int index = 0; index <= listOfBanksDisplayed.size() - 1; index++) {
                        String eachCellName = listOfBanksDisplayed.get(index).getText();
                        if (eachCellName.equals(bankName)) {
                            Logger.logComment(bankName + " is displayed and tapping on it");
                            bankCellNumber = index+1;
                            return bankCellNumber;
                        } else {
                            Logger.logComment(index + " - times trying to find the element name:-" + bankName);
                        }
                    }
                    scrollTheScreenUpwards(); // Check this method tomorrow

//                scrollToTheBankName(bankName);
//            scrollTheScreenUpwards(); // Implement a separate method such that it should scroll to the exact payment method
//                Logger.logComment("Unable to find the element -"+bankName+" - so scrolling the screen upwards");
//                listOfBanksDisplayed = driver.findElements(By.className("android.widget.CheckedTextView"));
//                for (int indexCount = 0; indexCount <= listOfBanksDisplayed.size()-1; indexCount++) {
//                    String eachCellCountName = listOfBanksDisplayed.get(indexCount).getText();
//                    if (eachCellCountName.equals(bankName)) {
//                        Logger.logComment(bankName + " is displayed and tapping on it");
//                        bankCellNumber = indexCount;
//                        return bankCellNumber;
//                    } else {
//                        Logger.logComment(indexCount+" - times trying to find the element name:-" +bankName);
//                    }
//                }
                } catch (Exception exception) {
                    Logger.logComment(count + " - times trying to scroll the screen upwards");
                    scrollTheScreenUpwards();
                }
                Logger.logComment(count + " - times trying to scroll the screen upwards");
                count = count+1;
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to scroll the exact card name :- "+bankName);
        }
        //Todo :- Implement a logic such that should display error after the counts is finished and not scroll to the element
//        Logger.logComment("Unable to scroll to the exact card name :- "+bankName);
        return bankCellNumber;
    }

    /**
     * Enter the card number
     */
    @Override
    public void enterCardNumber() {
        Logger.logAction("Tapping on card number text field");
        try{
            Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
            if (isElementDisplayedByXPath(XPATH_OF_CARD_NUMBER_VIEW)){
                WebElement cardNumberView = driver.findElementByXPath(XPATH_OF_CARD_NUMBER_VIEW);
                List<WebElement> getTheCardNumberTextFieldId = cardNumberView.findElements(By.className("android.widget.EditText"));
                String xPathOfCardNumberTextField = XPATH_OF_CARD_NUMBER_VIEW+"/android.widget.EditText["+getTheCardNumberTextFieldId.size()+"]";
                Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
//                ((WebDriver)driver).findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.GridView/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText["+getTheCardNumberTextFieldId.size()+"]")).sendKeys("0000000001");

//                if (isElementDisplayedByXPath(xPathOfCardNumberTextField)){
                    Logger.logStep("Entering the card number");
//                    MobileDriver mobileDiver = new Driver();
                    // Logic one
//                    MobileElement cardNumberTextField = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(xPathOfCardNumberTextField));
////                    driver.tap(1,cardNumberTextField,Labels_Hotels.DEFAULT_TAP_DURATION);
////                    cardNumberTextField.sendKeys(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
//                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
//
//                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ACTION_DOWN);
//                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ACTION_DOWN);


//                    cardNumberTextField.setId(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                    cardNumberTextField.sendKeys(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//
//                    MobileElement cardNumberTextField2 = (MobileElement) driver.findElementByXPath(xPathOfCardNumberTextField);
//                    cardNumberTextField2.setId(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                    cardNumberTextField2.setId(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                    cardNumberTextField2.setId(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);


                    // Logic two
                    Set<String> contextName = driver.getContextHandles();
                    if (contextName.contains("WEBVIEW_chrome")){
//                        driver.context("WEBVIEW_chrome");
//                        ChromeDriver driverdriver = new ChromeDriver(ChromeDriverService.createDefaultService());
//                        driverdriver = new ChromeDriver(new URL(Labels_Hotels.ANDROID_CAPABILITIES_URL), capabilities);
                        driver.findElement(By.xpath(xPathOfCardNumberTextField)).click();
                        driver.context("WEBVIEW_chrome").findElement(By.xpath(xPathOfCardNumberTextField)).sendKeys("0000000001");

//                    String cardNumber = driver.findElement(By.xpath(xPathOfCardNumberTextField)).getAttribute("resource-id");
//                    ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().id(\"" + xPathOfCardNumberTextField + "\")").sendKeys(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                        driver.findElementByXPath(xPathOfCardNumberTextField).sendKeys(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                    driver.context("NATIVE_APP");

                    }else {
//                        ((ChromeDriver) driver).findElement(By.xpath(xPathOfCardNumberTextField)).sendKeys("0000000001");
                        driver.findElement(By.xpath(xPathOfCardNumberTextField)).click();
                        driver.findElementByXPath(xPathOfCardNumberTextField).sendKeys(Labels_Flights.KNET_PAYMENT_CARD_NUMBER);
                    }


//                    driver.findElementByXPath(xPathOfCardNumberTextField).click();
//                    driver.getKeyboard().sendKeys(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                    driver.findElementByXPath(xPathOfCardNumberTextField).sendKeys(Labels_Hotels.KNET_PAYMENT_CARD_NUMBER);
//                    Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
//                    driver.hideKeyboard();
//                }
//                else {
//                    Logger.logError("Card number text field index is incorrect");
//                }
            }else {
                Logger.logError("Card number field is not displayed");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the element name by Xpath :- \n" + XPATH_OF_CARD_NUMBER_VIEW);
        }
    }
    /**
     * Enter the Pin number
     */
    @Override
    public void enterPinNumber() {
        Logger.logAction("Tapping on pin number text field");
        try{
            if (isElementDisplayedById(PIN_TEXTFIELD)){
                WebElement pinNumberTextField = driver.findElementById(PIN_TEXTFIELD);
//                pinNumberTextField.click();
                Logger.logStep("Entering the pin number");
                pinNumberTextField.sendKeys(Labels_Flights.KNET_PAYMENT_CARD_PIN_NUMBER);
                Logger.logComment(Labels_Flights.KNET_PAYMENT_CARD_PIN_NUMBER+" :- is entered as pin number");
                Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
                closeTheKeyboard_Android();
            }else {
                Logger.logError("Card number field is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name by Xpath :- \n" + PIN_TEXTFIELD);
        }
    }

    /**
     * Tap on Submit button
     */
    @Override
    public void tapOnSubmitButton() {
        Logger.logAction("Tapping on submit button");
        try{
            if (isElementDisplayedById(SUBMIT_BUTTON)){
                driver.findElementById(SUBMIT_BUTTON).click();
                Logger.logComment(" Tapped on submit button");
            }else {
                Logger.logError("Submit button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name :- \n" + SUBMIT_BUTTON);
        }
    }

    /**
     * Check post transactions screen is displayed
     */
    @Override
    public void checkPostTransactionScreenIsDisplayed() {
        Logger.logAction("Checking post transactions screen is displayed or not ?");
        try{
//            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(POST_TRANSACTIONS_SCREEN)));
            if (isElementDisplayedById(POST_TRANSACTIONS_SCREEN)){
                Logger.logStep("Post transactions screen is displayed and moving to next step");
            }else {
                Logger.logError("Post transactions screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name - " + POST_TRANSACTIONS_SCREEN);
        }
    }

    /**
     * Tap on Confirm button
     */
    @Override
    public void tapOnConfirmButton() {
        Logger.logAction("Tapping on Confirm button");
        try{
            if (isElementDisplayedById(CONFIRM_BUTTON)){
                driver.findElementById(CONFIRM_BUTTON).click();
                Logger.logComment("Tapped on confirm button");
            }else {
                Logger.logError("Confirm button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name :- " + CONFIRM_BUTTON);
        }
    }

    /**
     * Check the booking is success
     */
    @Override
    public void checkTheKnetBookingProcessIsSuccess() {
        Logger.logAction("Checking Booking is success or not ?");
        try {
            if (isElementDisplayedByName(ACTIVITY_INDICATOR)){
                Logger.logComment("Booking process is started");
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR,false);
                if (isElementDisplayedById("com.app.rehlat:id/paymentDoneLayout")){
                    Logger.logStep("Payment is success");
                }else if (isElementDisplayedById("com.app.rehlat:id/paymentFailureLayout")){
                    String errorCause = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]").getText();
                    Logger.logComment("Payment id failed due to :- " +errorCause);
                }
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(TRANSACTION_IN_PROGRESS)));
//                Logger.logComment(TRANSACTION_IN_PROGRESS);
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(TRANSACTION_IN_PROGRESS)));
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(PAYMENT_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PAYMENT_SUCCESS)));
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(BOOKING_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
            }else {
                Logger.logError("Activity indicator is not displayed, looks like booking process is not started");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the booking status");
        }
    }


    //Todo: Initialize or create the variable for the below strings of element names [Which are placed in the strings],after the developers made 'debugging is enabled' for the elements displayed in the payment checkOut screens
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                                         //** CREDIT OR DEBIT CARD METHODS **\\

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Enter credit or debit card details
     */
    @Override
    public void enterCreditOrDebitCardDetails() {
        Logger.logAction("Entering the credit or debit card details");
        try {
            enterCreditOrDebitCardNumber();
            enterCreditOrDebitCardExpiryMonth();
            enterCreditOrDebitCardExpiryYear();
            enterCreditOrDebitCardCvvNumber();
            enterCreditOrDebitCardPlaceHolderName();
            tapOnCreditOrDebitCardCheckOutPaymentButton();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter the credit or debit card number
     */
    public static void enterCreditOrDebitCardNumber() {
        Logger.logAction("Entering the credit or debit card number");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/numberTextInputLayout")){
                driver.findElement(By.id("com.app.rehlat:id/numberTextInputLayout")).sendKeys(Labels_Flights.CREDIT_OR_DEBIT_CARD_NUMBER);
                Logger.logComment("Entered the card number :- "+ Labels_Flights.CREDIT_OR_DEBIT_CARD_NUMBER);
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit expiry month and year
     */
    public static void enterCreditOrDebitCardExpiryMonth() {
        Logger.logAction("Entering the credit or debit card Expiry month");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/mmEditText")){
                driver.findElement(By.id("com.app.rehlat:id/mmEditText")).sendKeys("05");
                Logger.logComment("Entered the card expiry number :- "+"05");
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit expiry year
     */
    public static void enterCreditOrDebitCardExpiryYear() {
        Logger.logAction("Entering the credit or debit card Expiry year");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/yearEditText")){
                driver.findElement(By.id("com.app.rehlat:id/yearEditText")).sendKeys("2021");
                Logger.logComment("Entered the card expiry year :- "+"2021");
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit card cvv number
     */
    public static void enterCreditOrDebitCardCvvNumber() {
        Logger.logAction("Entering the credit or debit card CVV number");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/cvv")){
                driver.findElement(By.id("com.app.rehlat:id/cvv")).sendKeys("100");
                Logger.logComment("Entered the card expiry year :- "+"100");
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit card place holder name
     */
    public static void enterCreditOrDebitCardPlaceHolderName() {
        Logger.logAction("Entering the credit or debit card holder name");
        try {
                if (isElementDisplayedById("com.app.rehlat:id/nameTextInputLayout")){
                    driver.findElement(By.id("com.app.rehlat:id/nameTextInputLayout")).sendKeys(Labels_Flights.CREDIT_OR_DEBIT_CARD_HOLDER_NAME);
                    Logger.logComment("Entered the card expiry year :- "+ Labels_Flights.CREDIT_OR_DEBIT_CARD_HOLDER_NAME);
                    closeTheKeyboard_Android();
                }else {
                    Logger.logError("Element name is not displayed in the current active screen:- ");
                }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Tap on credit or debit checkout payment button
     */
    public static void tapOnCreditOrDebitCardCheckOutPaymentButton() {
        Logger.logAction("Tapping on pay securely check out button");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/checkoutPayButton")){
                driver.findElement(By.id("com.app.rehlat:id/checkoutPayButton")).click();
                Logger.logStep("Tapped on checkout payment button");
            }else {
                driver.findElement(By.id("com.app.rehlat:id/checkoutPayButton")).click();
//                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Check 3D payment screen is displayed
     * @return
     */
    @Override
    public boolean check3DPaymentScreenIsDisplayed() {
        Logger.logAction("Checking the 3D payment screen is displayed");
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR,false);
            if (isElementDisplayedById("txtPassword")){
                Logger.logStep("3D checkout payment screen is displayed");
                return true;
            }
        }catch (Exception exception){
            Logger.logError("Unable to check the current screen status");
        }
        return false;
    }

    /**
     * Enter keys in the password field of 3D secure credit or debit checkout payment
     */
    @Override
    public void enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment() {
        Logger.logAction("Tapping on pay securely check out button");
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR,false);
            if (isElementDisplayedById("txtPassword")){
                driver.findElement(By.id("txtPassword")).sendKeys("Checkout1!");
            }else if (isElementDisplayedById(PAYMENT_FAILED_TITLE)){
                System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                        "//////////////////////////////////////////  "+"PAYMENT FAILED"+"////////////////////////////////////////////////////\n"+
                        "        ////////////////////////////////////////////////////////////////////////////////////\n");
                Logger.logError("Payment failed error screen is displayed");
            }
            else {
//                driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Checkout 3D Simulator\"]/XCUIElementTypeOther[5]/XCUIElementTypeSecureTextField")).sendKeys("Checkout1!");
                Logger.logError("3D secure payment screen is not displayed in the current active screen");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to send keys to the pay securely check out button");
        }
    }

    /**Tap on continue button in 3D secure credit or debit checkout payment screen
     */
    @Override
    public  void tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment() {
        Logger.logAction("Tapping on pay securely check out button");
        try {
            if (isElementDisplayedById("txtButton")){
                driver.findElement(By.id("txtButton")).click();
            }else {
//                driver.findElement(By.id("txtButton")).click();
                Logger.logError("3D secure password text field button is not displayed in the current active screen");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Check the booking is success
     */
    @Override
    public void checkTheCreditOrDebitCardBookingProcessIsSuccess() {
        Logger.logAction("Checking Booking is success or not ?");
        try {
            if (isElementDisplayedByClassName(ACTIVITY_INDICATOR)){
                Logger.logComment("Booking process is started");
                if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                    Logger.logComment(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(PAYMENT_SUCCESS);
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(PAYMENT_SUCCESS);
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else {
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(PAYMENT_SUCCESS);
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(BOOKING_SUCCESS);
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }
            }else if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                Logger.logComment(TRANSACTION_IN_PROGRESS);
                if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                    Logger.logComment(PAYMENT_SUCCESS);
                    waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                    }else {
                        Logger.logError("Booking process is failed");
                    }
                }else {
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                    }else {
                        Logger.logError("Booking process is unsuccessful");
                    }
                }
            }else if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                Logger.logComment(PAYMENT_SUCCESS);
                waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    Logger.logComment(PAYMENT_SUCCESS);
                }else {
                    Logger.logError("Booking process is failed");
                }
            }else {
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    Logger.logComment(BOOKING_SUCCESS);
                }else {
                    Logger.logError("Booking process is unsuccessful");
                }
            }
//            if (isElementDisplayedByClassName(IOS_ACTIVITY_INDICATOR)){
//                Logger.logComment("Booking process is started");
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(IOS_ACTIVITY_INDICATOR)));
////                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(TRANSACTION_IN_PROGRESS)));
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(TRANSACTION_IN_PROGRESS)));
//                Logger.logComment(TRANSACTION_IN_PROGRESS);
////                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PAYMENT_SUCCESS)));
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(PAYMENT_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(BOOKING_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//            }else {
//                Logger.logError("Activity indicator is not displayed, looks like booking process is not started");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the booking status");
        }
    }
}
