package com.automation.rehlat.hotels.pages.signUp;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.General;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpIos extends SignUpBase {

    public static final String TOUCH_ID__AS_SIGN_UP_BUTTON = "USE TOUCHID FOR SIGN UP";
    public static final String FACE_ID__AS_SIGN_UP_BUTTON = "USE FACEID FOR SIGN UP";
    public static final String SIGN_UP_BUTTON = "Sign Up";
    public static final String ACCESSIBILITY_ID_OF_FIRST_NAME_TEXT_FIELD = "signupFirstName";
    public static final String ACCESSIBILITY_ID_OF_LAST_NAME_TEXT_FIELD = "signupLastName";
    public static final String ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD = "signupEmail";
    public static final String ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD = "signupPassword";
    public static final String ACCESSIBILITY_ID_OF_REPEAT_PASSWORD_TEXT_FIELD = "signupRepeatPassword";
    public static final String ACCESSIBILITY_ID_OF_SELECT_DOMAIN_TEXT_FIELD = "signupDomain";
    public static final String ACCESSIBILITY_ID_OF_REFERRAL_CODE_TEXT_FIELD = "signupReferral";
    public static final String CONTINUE_BUTTON = "CONTINUE";


    /**
     * Check sign up screen is displayed
     */
    @Override
    public void checkSignUpScreenIsDisplayed() {
        Logger.logAction("Checking the sign in or sign up screen is displayed or not ?");
        try {
            scrollDown(); //Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
            if (isElementDisplayedByAccessibilityId(SIGN_UP_BUTTON) && isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_REPEAT_PASSWORD_TEXT_FIELD) && isElementDisplayedByName(TOUCH_ID__AS_SIGN_UP_BUTTON) || isElementDisplayedByName(FACE_ID__AS_SIGN_UP_BUTTON)){
                Logger.logStep("Sign Up screen is displayed");
            }else {
                Logger.logError("Sign Up screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter sign up credentials
     */
    @Override
    public void enterSignUpCredentials() {
        Logger.logAction("Entering Sign up credentials");
        try {
            scrollUp(); //Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
            enterUserFirstName();
            enterUserLastName();
            enterUserEmailId();
            enterUserPassword();
            enterUserRepeatPassword();
            selectDomain();
            enterReferralCode();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user first name
     */
    @Override
    public void enterUserFirstName() {
        Logger.logAction("Entering user first name");
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_FIRST_NAME_TEXT_FIELD)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_FIRST_NAME_TEXT_FIELD);
                String firstName = General.getTheTestDataOfField("First_Name");
                element.sendKeys(firstName);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(ACCESSIBILITY_ID_OF_FIRST_NAME_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user last name
     */
    @Override
    public void enterUserLastName() {
        Logger.logAction("Entering user last name");
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_LAST_NAME_TEXT_FIELD)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_LAST_NAME_TEXT_FIELD);
                String lastName = General.getTheTestDataOfField("Last_Name");
                element.sendKeys(lastName);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(ACCESSIBILITY_ID_OF_LAST_NAME_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user email id
     */
    @Override
    public void enterUserEmailId() {
        Logger.logAction("Entering user email id");
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD);
                element.sendKeys(Labels_Hotels.EMAIL_ID_SIGN_UP);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user password for sign up
     */
    @Override
    public void enterUserPassword() {
        Logger.logAction("Entering user sign up password");
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD);
                element.sendKeys(Labels_Hotels.PASSWORD);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user sign up repeat password
     */
    @Override
    public void enterUserRepeatPassword() {
        Logger.logAction("Entering user sign up repeat password");
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_REPEAT_PASSWORD_TEXT_FIELD)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_REPEAT_PASSWORD_TEXT_FIELD);
                element.sendKeys(Labels_Hotels.REPEAT_PASSWORD);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(ACCESSIBILITY_ID_OF_REPEAT_PASSWORD_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Select the user domain (Country domain)
     */
    @Override
    public void selectDomain() {
        Logger.logAction("Selecting user country domain");
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_SELECT_DOMAIN_TEXT_FIELD)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_SELECT_DOMAIN_TEXT_FIELD);
                element.click();
                selectCountryNameAndTapOnContinueButton();
            }else {
                Logger.logError(ACCESSIBILITY_ID_OF_SELECT_DOMAIN_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Select the country domain and tap on Continue button
     */
    public static void selectCountryNameAndTapOnContinueButton() {
        Logger.logAction("Selecting user country domain and tap on tap on continue button");
        try {
            findElementByNameAndClick(Labels_Hotels.LANGUAGE_COUNTRY_LABEL);
            findElementByNameAndClick(CONTINUE_BUTTON);

//            if (isElementDisplayedByName(Labels_Hotels.KUWAIT_LANGUAGE_COUNTRY_LABEL)){
//                driver.findElement(By.name(Labels_Hotels.KUWAIT_LANGUAGE_COUNTRY_LABEL)).click();
//                driver.findElement(By.name(FlightsIos.CONTINUE_BUTTON)).click();
//            }else {
//                Logger.logError(Labels_Hotels.KUWAIT_LANGUAGE_COUNTRY_LABEL+" - element name is not displayed in the current active screen");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter referral code
     */
    @Override
    public void enterReferralCode() {
        Logger.logAction("Entering referral code");
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_REFERRAL_CODE_TEXT_FIELD)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_REFERRAL_CODE_TEXT_FIELD);
                element.sendKeys(Labels_Hotels.REFERRAL_CODE);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(ACCESSIBILITY_ID_OF_REFERRAL_CODE_TEXT_FIELD +" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Tap on Sign Up button
     */
    @Override
    public void tapOnSignUpButton() {
        Logger.logAction("Taping on create account button");
        try {
            scrollDown(); //Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
            if (isElementDisplayedByAccessibilityId(SIGN_UP_BUTTON)){
                driver.findElementByAccessibilityId(SIGN_UP_BUTTON).click();
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Hotels.IOS_ACTIVITY_INDICATOR,1);
            }else {
                Logger.logError(SIGN_UP_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on button name :- "+SIGN_UP_BUTTON);
        }
    }

    /**
     * Checking all the fields are filled with information is valid or not
     */
    public static void checkAllTheFieldsAreFilledWithValidInformation() {
        Logger.logAction("Checking the entered information is valid or not");
        try {


        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check all the fields are filled with valid information or not ?");
        }
    }
}

