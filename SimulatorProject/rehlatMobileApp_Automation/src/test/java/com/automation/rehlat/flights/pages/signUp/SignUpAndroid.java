package com.automation.rehlat.flights.pages.signUp;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignUpAndroid extends SignUpBase {
    public static final String XPATH_OF_SELECT_COUNTRY_LISTVIEW = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView";
    public static final String SIGN_UP_BUTTON = "com.app.rehlat:id/signup";
    public static final String FIRST_NAME_TEXT_FIELD = "com.app.rehlat:id/signupFirtNameEditText";
    public static final String LAST_NAME_TEXT_FIELD = "com.app.rehlat:id/signupLastNameText";
    public static final String EMAIL_TEXT_FIELD = "com.app.rehlat:id/signupEmailEditText";
    public static final String PASSWORD_TEXT_FIELD = "com.app.rehlat:id/signupPwdEditText";
    public static final String REPEAT_PASSWORD_TEXT_FIELD = "com.app.rehlat:id/signupConfPwdEditText";
    public static final String SELECT_DOMAIN_TEXT_FIELD = "com.app.rehlat:id/domainSpinner";
    public static final String REFERRAL_CODE_TEXT_FIELD = "com.app.rehlat:id/signupreferalcodeEditText";
    public static final String SELECT_COUNTRY_TEXT_VIEW = "android.widget.TextView";
    public static final String XPATH_OF_SELECT_COUNTRY_VIEW_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[";



    /**
     * Check sign up screen is displayed
     */
    @Override
    public void checkSignUpScreenIsDisplayed() {
        Logger.logAction("Checking the sign in or sign up screen is displayed or not ?");
        try {
            if (isElementDisplayedById(SIGN_UP_BUTTON) && isElementDisplayedById(REPEAT_PASSWORD_TEXT_FIELD) && isElementDisplayedById(LAST_NAME_TEXT_FIELD)){
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
            enterUserFirstName();
            enterUserLastName();
            enterUserEmailId();
            enterUserPassword();
            enterUserRepeatPassword();
            enterReferralCode();
            selectDomain();
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
            if (isElementDisplayedById(FIRST_NAME_TEXT_FIELD)){
                driver.findElement(By.id(FIRST_NAME_TEXT_FIELD)).sendKeys(Labels_Flights.FIRST_NAME);
                Logger.logComment(Labels_Flights.FIRST_NAME+" - element name is parsed");
                closeTheKeyboard_Android();
            }else {
                Logger.logError(FIRST_NAME_TEXT_FIELD+" - element name is not displayed in the current active screen");
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
            if (isElementDisplayedById(LAST_NAME_TEXT_FIELD)){
                driver.findElement(By.id(LAST_NAME_TEXT_FIELD)).sendKeys(Labels_Flights.LAST_NAME);
                Logger.logComment(Labels_Flights.LAST_NAME+" - element name is parsed");
                closeTheKeyboard_Android();
            }else {
                Logger.logError(LAST_NAME_TEXT_FIELD+" - element name is not displayed in the current active screen");
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
            if (isElementDisplayedById(EMAIL_TEXT_FIELD)){
                driver.findElement(By.id(EMAIL_TEXT_FIELD)).sendKeys(Labels_Flights.EMAIL_ID_SIGN_UP);
                Logger.logComment(Labels_Flights.EMAIL_ID_SIGN_UP+" - element name is parsed");
                closeTheKeyboard_Android();
            }else {
                Logger.logError(EMAIL_TEXT_FIELD+" - element name is not displayed in the current active screen");
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
            if (isElementDisplayedById(PASSWORD_TEXT_FIELD)){
                driver.findElement(By.id(PASSWORD_TEXT_FIELD)).sendKeys(Labels_Flights.PASSWORD);
                Logger.logComment(Labels_Flights.PASSWORD+" - element name is parsed");
                closeTheKeyboard_Android();
            }else {
                Logger.logError(PASSWORD_TEXT_FIELD+" - element name is not displayed in the current active screen");
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
            if (isElementDisplayedById(REPEAT_PASSWORD_TEXT_FIELD)){
                driver.findElement(By.id(REPEAT_PASSWORD_TEXT_FIELD)).sendKeys(Labels_Flights.REPEAT_PASSWORD);
                Logger.logComment(Labels_Flights.REPEAT_PASSWORD+" - element name is parsed");
                closeTheKeyboard_Android();
            }else {
                Logger.logError(REPEAT_PASSWORD_TEXT_FIELD+" - element name is not displayed in the current active screen");
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
            if (isElementDisplayedById(SELECT_DOMAIN_TEXT_FIELD)){
                driver.findElement(By.id(SELECT_DOMAIN_TEXT_FIELD)).click();
                Logger.logComment(SELECT_DOMAIN_TEXT_FIELD+" :- Domain is selected");
                selectCountryName();
            }else {
                Logger.logError(REPEAT_PASSWORD_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Select the country domain and tap on Continue button
     */
    public static void selectCountryName() {
        Logger.logAction("Selecting user country domain and tap on tap on continue button");
        try {
            Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
            if (isElementDisplayedByXPath(XPATH_OF_SELECT_COUNTRY_LISTVIEW)){
                List<WebElement> listOfTextViews = driver.findElements(By.className(SELECT_COUNTRY_TEXT_VIEW));
                for (int index=0 ; index <= listOfTextViews.size()-1; index++){
                    String eachTextViewName = listOfTextViews.get(index).getText();
                    if (eachTextViewName.matches(Labels_Flights.KUWAIT_LANGUAGE_COUNTRY_LABEL)){
                        Thread.sleep(2000);
                        index =index+1;
                        driver.findElement(By.xpath(XPATH_OF_SELECT_COUNTRY_VIEW_WITHOUT_INDEX+index+"]")).click();
                        break;
                    }
                }
            }else {
                Logger.logError(Labels_Flights.KUWAIT_LANGUAGE_COUNTRY_LABEL+" - element name is not displayed in the current active screen");
            }
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
            if (isElementDisplayedById(REFERRAL_CODE_TEXT_FIELD)){
                driver.findElement(By.id(REFERRAL_CODE_TEXT_FIELD)).sendKeys(Labels_Flights.REFERRAL_CODE);
                Logger.logComment(Labels_Flights.REFERRAL_CODE+" :- referral code is parsed");
                closeTheKeyboard_Android();
                Thread.sleep(2000);
            }else {
                Logger.logError(REFERRAL_CODE_TEXT_FIELD +" - element name is not displayed in the current active screen");
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
            if (isElementDisplayedById(SIGN_UP_BUTTON)){
                findElementByIdAndClick(SIGN_UP_BUTTON);
                Logger.logComment(" Tapped on signed up button");
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR);
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR);
                closeTheKeyboard_Android();
                if (isElementDisplayedById(SIGN_UP_BUTTON)){
                    Logger.logError("Sign up screen is displaying on getting the app to back ground after tapping on sign up button with valid sign up credentials");
                }
                declineTheSyncPreviousTravellersDataModalView_Android();
            }else {
                Logger.logComment(SIGN_UP_BUTTON+" - element name is not displayed in the current active screen");
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
