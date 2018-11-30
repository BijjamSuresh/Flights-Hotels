package com.automation.rehlat.flights.pages.signIn;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInIos extends SignInBase {
    public static final String TOUCH_ID_ACCESS_MODAL_TITLE = "Would you like to login using your TouchID?";
    public static final String FACE_ID_ACCESS_MODAL_TITLE = "Would you like to login using your FaceID?";
    public static final String NO_BUTTON_ON_TOUCH_ID_ACCESS_MODAL = "No";
    public static final String LOGIN_BUTTON = "Login";
    public static final String CREATE_ACCOUNT_BUTTON = "Create Account";
    public static final String NOT_REGISTERED_LABEL = "Not registered?";
    public static final String ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN = "loginEmail";
    public static final String ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN = "loginPassword";


    /**
     * Check sign in screen is displayed
     */
    @Override
    public void checkSignInScreenIsDisplayed() {
        Logger.logAction("Checking the sign in screen is displayed or not ?");
        try {
//            driverWait.withTimeout(5,TimeUnit.SECONDS);
            declineTheFaceIdAccessSetUpPopupIfDisplayed();
            declineTheTouchIdAccessSetUpPopupIfDisplayed();
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,1);
            if (isElementDisplayedByName(LOGIN_BUTTON) && isElementDisplayedByName(CREATE_ACCOUNT_BUTTON) && isElementDisplayedByName(NOT_REGISTERED_LABEL)){
                Logger.logStep("Sign In screen is displayed");
            }else {
                scrollDown(); //Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
                if (isElementDisplayedByName(LOGIN_BUTTON) && isElementDisplayedByName(CREATE_ACCOUNT_BUTTON) && isElementDisplayedByName(NOT_REGISTERED_LABEL)){
                    Logger.logStep("Sign In screen is displayed");
                }else {
                    Logger.logError("Sign In screen is not displayed");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Decline the touch id access set up Popup if displayed
     */
    @Override
    public void declineTheTouchIdAccessSetUpPopupIfDisplayed() {
        Logger.logAction("Declining the touch id access popup if displayed");
        try {
            Thread.sleep(2000);
            if (isElementDisplayedByName(TOUCH_ID_ACCESS_MODAL_TITLE)){
                Logger.logComment("Touch id access popup is displayed and going to decline it by tapping on no button");
                driver.findElementByName(NO_BUTTON_ON_TOUCH_ID_ACCESS_MODAL).click();
                Logger.logComment("Touch id access popup is declined");
            }else {
                Logger.logComment("Touch id access alert is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Decline the face id access set up Popup if displayed
     */
    public static void declineTheFaceIdAccessSetUpPopupIfDisplayed() {
        Logger.logAction("Declining the face id access popup if displayed");
        try {
//            Thread.sleep(2000);
            if (isElementDisplayedByName(FACE_ID_ACCESS_MODAL_TITLE)){
                Logger.logComment("Face id access popup is displayed and going to decline it by tapping on no button");
                driver.findElementByName(NO_BUTTON_ON_TOUCH_ID_ACCESS_MODAL).click();
                Logger.logComment("Face id access popup is declined");
            }else {
                Logger.logComment("Face id access alert is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Tap on create account button
     */
    @Override
    public void tapOnCreateAccountButton() {
        Logger.logAction("Taping on create account button");
        try {
            if (isElementDisplayedByName(CREATE_ACCOUNT_BUTTON)){
                driver.findElement(By.name(CREATE_ACCOUNT_BUTTON)).click();
                Logger.logComment("Tapped on create account button");
            }else {
                Logger.logComment(CREATE_ACCOUNT_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on button name :- "+CREATE_ACCOUNT_BUTTON);
        }
    }

    /**
     * Entering login credentials
     */
    @Override
    public void enterLoginCredentials() {
        Logger.logAction("Entering login credentials");
        try {
            enterEmailId();
            enterPassword();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the login credentials");
        }
    }

    /**
     * Entering login credentials
     */
    public static void enterEmailId() {
        Logger.logAction("Entering email id :-"+ Labels_Flights.EMAIL_ID_SIGN_IN);
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN);
                element.sendKeys(Labels_Flights.EMAIL_ID_SIGN_IN);
                Logger.logComment(Labels_Flights.EMAIL_ID_SIGN_IN+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("unable to find the element name :- "+ACCESSIBILITY_ID_OF_EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the login credentials");
        }
    }

    /**
     * Entering login credentials
     */
    public static void enterPassword() {
        Logger.logAction("Entering password :- "+ Labels_Flights.PASSWORD);
        try {
            if (isElementDisplayedByAccessibilityId(ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN)){
                WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN);
                element.sendKeys(Labels_Flights.PASSWORD);
                Logger.logComment(Labels_Flights.PASSWORD+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("unable to find the element name :- "+ACCESSIBILITY_ID_OF_PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the login credentials");
        }
    }

    /**
     * Tap on Login button
     */
    @Override
    public void tapOnLoginButton() {
        Logger.logAction("Tapping on Login button");
        try
        {
            if (isElementDisplayedByName(LOGIN_BUTTON)){
                driver.findElementByName(LOGIN_BUTTON).click();
                Logger.logComment("Tapped on Login is button");
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,1);
            }else {
                Logger.logError(LOGIN_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the element name :- "+LOGIN_BUTTON);
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
