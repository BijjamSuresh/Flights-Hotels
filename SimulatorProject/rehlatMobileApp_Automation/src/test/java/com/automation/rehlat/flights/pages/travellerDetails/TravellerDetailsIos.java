package com.automation.rehlat.flights.pages.travellerDetails;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.automation.rehlat.flights.tests.BaseTest.INTERNATIONALS_TRAVELLERS_COUNTRY_NAME;


public class TravellerDetailsIos extends TravellerDetailsBase {

    public static final String TRAVELLERS_FIRST_NAME="infoFirstName";
    public static final String TRAVELLERS_MIDDLE_NAME="infoMiddleName";
    public static final String TRAVELLERS_LAST_NAME="infoLastName";
    public static final String TRAVELLERS_DATEOFBIRTH_NAME="infoDOB";
    public static final String TRAVELLERS_PASSPORT_NUMBER="infoPassportNum";
    public static final String TRAVELLERS_PASSPORT_EXPIRY_NUMBER="infoPassportValidity";
    public static final String TRAVELLERS_PASSPORT_ISSUING_COUNTRY="infoPasspostCountry";
    public static final String TRAVELLERS_NATIONALITY="infoNationality";
    public static final String CHOOSE_COUNTRY_MODAL="Choose Country";
    public static final String SAVE_BUTTON="Save";
    public static final String NEXT_BUTTON="Next";
    public static final String PICKER_WHEEL = "XCUIElementTypePickerWheel";
    public static final String XPATH_OF_TRAVELLERS_DETAILS_SCREEN_TITLE ="//XCUIElementTypeNavigationBar[@name=\"Traveller Details\"]";
    public static final String TRAVELLERS_PRE_POPULLATE_MODAL_VIEW = "Do you want to fill the data automatically from previous entry?";
    public static final String XPATH_OF_TRAVELLERS_DETAILS_MODAL ="//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";


    /**
     * Check the travellers details screen is displayed
     */
    @Override
    public void checkTravellersDetailsScreenIsDisplayed() {
        Logger.logAction("Checking the travellers details screen is displayed or not ?");
        try {
            Thread.sleep(2000);
            if (isElementDisplayedByXPath(XPATH_OF_TRAVELLERS_DETAILS_SCREEN_TITLE)){
                Logger.logStep("Travellers details screen is displayed");
            } else {
                Logger.logError("Travellers details screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the current active screen name");
        }
    }

    /**
     * Accept the auto fill populate modal if displayed
     */
    @Override
    public boolean acceptAutoFillPopulateModalIfDisplayed(Integer parsingPassengersCount) {
        Logger.logAction("Accepting the auto fill popup if displayed");
        Integer count = 0;
        try{
            while (count <= parsingPassengersCount) {
                if (isElementDisplayedByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_SHEET)) {
                    WebElement popUpModal = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_SHEET);
                    String popUpModalTitle = popUpModal.findElement(By.className(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels_Flights.NAME_ATTRIBUTE);
                    if (popUpModalTitle.equals(TRAVELLERS_PRE_POPULLATE_MODAL_VIEW)) {
                        Logger.logStep("Auto fill popup modal is displayed and going to accept it");
                        if (isElementDisplayedByName(YES_BUTTON)) {
                            driver.findElementByName(YES_BUTTON).click();
                            Logger.logComment("Tapped on yes button");
                            if (!(parsingPassengersCount == count+1)){
                                tapOnNextButton();
                                count++;
                            }
                        } else {
                            Logger.logError("Button with - Yes - name is not displayed in the popup");
                        }
                    } else {
                        Logger.logError("Auto fill PopUp is not displayed but a popup is displayed with different title");
                    }
                } else {
                    Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
                    return false;
                }
            }
            return true;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
        return false;
    }
    /**
     * Decline the auto fill populate modal if displayed
     */
    @Override
    public boolean declineAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Declining the auto fill popup if displayed");
        try{
            if (isElementDisplayedByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_SHEET)){
                WebElement popUpModal = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_SHEET);
                String popUpModalTitle = popUpModal.findElement(By.className(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels_Flights.NAME_ATTRIBUTE);
                if (popUpModalTitle.equals(TRAVELLERS_PRE_POPULLATE_MODAL_VIEW)){
                    Logger.logStep("Auto fill popup modal is displayed and going to decline it");
                    if (isElementDisplayedByName(NO_BUTTON)){
                        driver.findElementByName(NO_BUTTON).click();
                        Logger.logComment("Tapped on no button");
                        return true;
                    }else{
                        Logger.logError("Button with - No - name is not displayed in the popup");
                    }
                }else{
                    Logger.logError("Auto fill PopUp is not displayed but a popup is displayed with different title");
                }
            } else {
                Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
        return false;
    }

    /**
     * Enter travellers details for passengers
     * @param parsingPassengerCount
     */
    @Override
    public void EnterTravellersDetailsForPassengers(Integer parsingPassengerCount){
        Logger.logAction("Entering the travelling details of passengers :-"+parsingPassengerCount);
        boolean autoAcceptAlertStatus = false;
        try {
            for (int passengerCount=1;passengerCount<=parsingPassengerCount;passengerCount++){
                if (TravellerDetailsScreen.declineAutoFillPopulateModalIfDisplayed()){ // We are declining here because if the previous travellers details are not enough to fill the current travellers details scripts will fail
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                    autoAcceptAlertStatus = false;
                }
                if (autoAcceptAlertStatus != true){
                    Logger.logStep("Entering the traveller details of passenger :- "+passengerCount);
                    enterTravellersDetails(INTERNATIONALS_TRAVELLERS_COUNTRY_NAME);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }
                if (passengerCount == (parsingPassengerCount)){
                    continue;
                }else {
                    tapOnNextButton();
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers details of passengers :- "+parsingPassengerCount);
        }
    }

    /**
     * Enter adult travellers details
     */
    @Override
    public void enterAdultTravellersDetails(String travellersCountry) {
        Logger.logStep("Entering the adult travellers details");
        try{
            if (isElementDisplayedByXPath(XPATH_OF_TRAVELLERS_DETAILS_MODAL)){
                Logger.logStep("Travellers details modal is displayed and moving to next step");
                enterTravellersDetails(travellersCountry);
            }else {
                Logger.logError("Travellers details modal is not displayed or interactions are not available for the current active screen");
            }
        } catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the adult travellers details in the current active screen");
        }
    }

    /**
     * Enter the travellers details
     */
    public static void enterTravellersDetails(String travellersCountry) {
        Logger.logAction("Entering travellers details");
        try{
            enterTravellersFirstName();
            enterTravellersMiddleName();
            enterTravellersLastName();
            if (Labels_Flights.FLIGHT_BOOKING_TYPE.equals(Labels_Flights.INTERNATIONAL_FLIGHT_BOOKING)){
                enterTravellersDateOfBirth();
                enterTravellersPassportNumber();
                enterTravellersPassportExpiryDate();
                scrollDown();//Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
                selectPassportIssuingCountry(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                selectTravellersNationality(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            }else if (Labels_Flights.FLIGHT_BOOKING_TYPE.equals(Labels_Flights.DOMESTIC_FLIGHT_BOOKING)){
                Logger.logStep("For domestic flights DOB, Passport and its expiry date and passport issuing country are might or might not necessary.., So filling the necessary information for the current flight ...,");
                if (isElementDisplayedByName(TRAVELLERS_DATEOFBIRTH_NAME)){
                    enterTravellersDateOfBirth();
                }
                if (isElementDisplayedByName(TRAVELLERS_PASSPORT_NUMBER)){
                    enterTravellersPassportNumber();
                }
                if (isElementDisplayedByName(TRAVELLERS_PASSPORT_EXPIRY_NUMBER)){
                    enterTravellersPassportExpiryDate();
                }
                if (isElementDisplayedByName(TRAVELLERS_PASSPORT_ISSUING_COUNTRY)){
                    selectPassportIssuingCountry(travellersCountry);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }
                if (isElementDisplayedByName(TRAVELLERS_NATIONALITY)){
                    selectTravellersNationality(travellersCountry);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to enter the travellers details");
        }
    }

    /**
     * Enter the travellers first name
     */
    public static void enterTravellersFirstName() {
        Logger.logAction("Entering travellers first name");
        try{
            if (isElementDisplayedByAccessibilityId(TRAVELLERS_FIRST_NAME)){
                WebElement firstNameLabel = driver.findElementByAccessibilityId(TRAVELLERS_FIRST_NAME);
//                tapOnElementBasedOnLocation(firstName,"bottomRight");
                String firstName = General.getTheTestDataOfField("First_Name");
                firstNameLabel.sendKeys(firstName);
                Logger.logComment(firstName+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("Travellers first name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to enter the travellers first name");
        }
    }

    /**
     * Enter the travellers middle name
     */
    public static void enterTravellersMiddleName() {
        Logger.logAction("Entering travellers middle name");
        try{
            if (isElementDisplayedByAccessibilityId(TRAVELLERS_MIDDLE_NAME)){
                WebElement middleNameLabel = driver.findElementByAccessibilityId(TRAVELLERS_MIDDLE_NAME);
//                tapOnElementBasedOnLocation(middleName,"bottomRight");
                String middleName = General.getTheTestDataOfField("Middle_Name");
                middleNameLabel.sendKeys(middleName);
                Logger.logComment(middleName+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("Travellers middle name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers middle name");
        }
    }

    /**
     * Enter the travellers last name
     */
    public static void enterTravellersLastName() {
        Logger.logAction("Entering travellers last name");
        try{
            if (isElementDisplayedByAccessibilityId(TRAVELLERS_LAST_NAME)){
                WebElement lastNameLabel = driver.findElementByAccessibilityId(TRAVELLERS_LAST_NAME);
//                tapOnElementBasedOnLocation(lastName,"bottomRight");
                String lastName = General.getTheTestDataOfField("Last_Name");
                lastNameLabel.sendKeys(lastName);
                Logger.logComment(lastName+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("Travellers last name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers last name");
        }
    }
    /**
     * Enter the travellers Date of Birth
     */
    public static void enterTravellersDateOfBirth() {
        Logger.logAction("Entering travellers Date of Birth");
        try{
            if (isElementDisplayedByName(TRAVELLERS_DATEOFBIRTH_NAME)){
                WebElement lastName = driver.findElementByAccessibilityId(TRAVELLERS_DATEOFBIRTH_NAME);
                tapOnElementBasedOnLocation(lastName,"bottomRight");
                Logger.logComment("Tapped on Travellers date of birth field");
                if (isDatePickerDisplayed()){
                    List<IOSElement> wheels = (List) driver.findElements(By.className(PICKER_WHEEL));
                    wheels.get(0).sendKeys(Labels_Flights.DAY_IN_TRAVELLERS_DATEOFBIRTH_IOS);
                    Logger.logComment("Selected the day "+ Labels_Flights.DAY_IN_TRAVELLERS_DATEOFBIRTH_IOS+" in travellers date of birth");
                    wheels.get(1).sendKeys(Labels_Flights.MONTH_IN_TRAVELLERS_DATEOFBIRTH_IOS);
                    Logger.logComment("Selected the month "+ Labels_Flights.MONTH_IN_TRAVELLERS_DATEOFBIRTH_IOS+" in travellers date of birth");
                    wheels.get(2).sendKeys(Labels_Flights.YEAR_IN_TRAVELLERS_DATEOFBIRTH_IOS);
                    Logger.logComment("Selected the year "+ Labels_Flights.YEAR_IN_TRAVELLERS_DATEOFBIRTH_IOS+" in travellers date of birth");
                    closeTheDatePicker_iOS();
                }else {
                    Logger.logError("Date picker is not displayed");
                }
            }else {
                Logger.logError("Travellers date of birth field is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers date of birth");
        }
    }

    /**
     * Enter the travellers passport number
     */
    public static void enterTravellersPassportNumber() {
        Logger.logAction("Entering travellers passport number");
        try{
            if (isElementDisplayedByAccessibilityId(TRAVELLERS_PASSPORT_NUMBER)){
                WebElement passportNumberLabel = driver.findElementByAccessibilityId(TRAVELLERS_PASSPORT_NUMBER);
//                tapOnElementBasedOnLocation(passportNumber,"bottomRight");
                String passportNumber = General.getTheTestDataOfField("Passport_Number");
                passportNumberLabel.sendKeys(passportNumber);
                Logger.logComment(passportNumber+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("Travellers passport field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers passport number");
        }
    }
    /**
     * Enter the travellers passport expiry date
     */
    public static void enterTravellersPassportExpiryDate() {
        Logger.logAction("Entering travellers passport expiry date");
        try{
            if (isElementDisplayedByAccessibilityId(TRAVELLERS_PASSPORT_EXPIRY_NUMBER)){
                WebElement passportExpiryNumber = driver.findElementByAccessibilityId(TRAVELLERS_PASSPORT_EXPIRY_NUMBER);
                passportExpiryNumber.click();
//                tapOnElementBasedOnLocation(passportExpiryNumber,"bottomRight");
                Logger.logComment("Tapped on Travellers passport expiry text field");
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(PICKER_WHEEL)));
                if (isDatePickerDisplayed()){
                    List<IOSElement> wheels = (List) driver.findElements(By.className(PICKER_WHEEL));
                    wheels.get(0).sendKeys(Labels_Flights.DAY_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS);
                    Logger.logComment("Selected the day "+ Labels_Flights.DAY_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS+" in travellers passport expiry day");
                    wheels.get(1).sendKeys(Labels_Flights.MONTH_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS);
                    Logger.logComment("Selected the month "+ Labels_Flights.MONTH_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS+" in travellers passport expiry month");
                    wheels.get(2).sendKeys(Labels_Flights.YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS);
                    Logger.logComment("Selected the year "+ Labels_Flights.YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS+" in travellers passport expiry year");
                    closeTheDatePicker_iOS();
                }else {
                    Logger.logError("Date picker is not displayed");
                }
            }else {
                Logger.logError("Travellers passport expiry field is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers passport expiry field");
        }
    }

    /**
     * Select passport issuing country name
     */
    public static void selectPassportIssuingCountry(String passportIssuingCountryName) {
        Logger.logAction("Selecting the passport issuing country");
        try{
            if (isElementDisplayedByAccessibilityId(TRAVELLERS_PASSPORT_ISSUING_COUNTRY)){
                WebElement passportIssuingNumber = driver.findElementByAccessibilityId(TRAVELLERS_PASSPORT_ISSUING_COUNTRY);
                passportIssuingNumber.click();
//                tapOnElementBasedOnLocation(passportIssuingNumber,"bottomRight");
                Logger.logComment("Tapped on Issuing country text field");
                if (isElementDisplayedByName(CHOOSE_COUNTRY_MODAL)) {
                    chooseCountry(passportIssuingCountryName);
                }else{
                    Logger.logError("Choose country modal is not displayed in the current active screen");
                }
            }else{
                Logger.logError("Passport issuing field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the passport issuing country");
        }
    }

    /**
     * Select traveller nationality
     */
    public static void selectTravellersNationality(String travellersNationality) {
        Logger.logAction("Selecting the travellers nationality");
        try{
            if (isElementDisplayedByAccessibilityId(TRAVELLERS_NATIONALITY)){
                WebElement travellersNationalityField = driver.findElementByAccessibilityId(TRAVELLERS_NATIONALITY);
                travellersNationalityField.click();
//                tapOnElementBasedOnLocation(travellersNationalityField,"bottomRight");
                Logger.logComment("Tapped on travellers nationality country field");
                if (isElementDisplayedByName(CHOOSE_COUNTRY_MODAL)) {
                    chooseCountry(travellersNationality);
                }else{
                    Logger.logError("Choose country modal is not displayed in the current active screen");
                }
            }else{
                Logger.logError("Nationality field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the Nationality field");
        }
    }

    /**
     * Select the country name from choose country modal
     * @param countryName
     */
    // To do: Implement a method such that automatically select the country name (if country name is not on visible list scroll to that element and click on it)
    public static void chooseCountry(String countryName) {
        Logger.logAction("Choosing the country name :- "+countryName);
        try{
            if (isElementEnabledByName(countryName)){
                driver.findElementByName(countryName).click();
                Logger.logComment(countryName+" :- country name is selected");
            }else {
                Logger.logError(countryName+ " - is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to choose the country name");
        }
    }

    /**
     * Tap on save button
     */
    @Override
    public void tapOnSaveButton() {
        Logger.logAction("Tapping on save button");
        try{
            if (isElementDisplayedByName(SAVE_BUTTON)){
                driver.findElementByName(SAVE_BUTTON).click();
                Logger.logComment("Tapped on save button");
            }else {
//                if (isElementDisplayedByName("Next")) // Implement a method such that should verify multiple travellers info (Verify the save button name if it is NEXT, return false and call a method that enters the other travellers info), this process needs to be continued till save button is displayed.
                Logger.logError("Save button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the save button in the current active screen");
        }
    }

    /**
     * Tap on next button
     */
    @Override
    public void tapOnNextButton() {
        Logger.logAction("Tapping on next button");
        try{
            if (isElementDisplayedByName(NEXT_BUTTON)){
                driver.findElementByName(NEXT_BUTTON).click();
                Logger.logComment("Tapped on next button");
            }else {
//                if (isElementDisplayedByName("Next")) // Implement a method such that should verify multiple travellers info (Verify the save button name if it is NEXT, return false and call a method that enters the other travellers info), this process needs to be continued till save button is displayed.
                Logger.logError("Save button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the save button in the current active screen");
        }
    }

}
