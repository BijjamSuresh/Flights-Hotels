package com.automation.rehlat.flights.tests;

import com.automation.rehlat.flights.Base;
import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.pages.BasePage;
import com.automation.rehlat.flights.pages.appSupport.AppSupportBase;
import com.automation.rehlat.flights.pages.bookingPage.BookingPageBase;
import com.automation.rehlat.flights.pages.flights.FlightsBase;
import com.automation.rehlat.flights.pages.flightsSearchResults.FlightsSearchResultsBase;
import com.automation.rehlat.flights.pages.flightsSimilarOptionsSearchResults.FlightsSimilarOptionsSearchResultsBase;
import com.automation.rehlat.flights.pages.karam.KaramBase;
import com.automation.rehlat.flights.pages.menu.MenuBase;
import com.automation.rehlat.flights.pages.myProfile.MyProfileBase;
import com.automation.rehlat.flights.pages.myTrips.MyTripsBase;
import com.automation.rehlat.flights.pages.notificatios.NotificationsBase;
import com.automation.rehlat.flights.pages.paymentOptions.PaymentOptionsBase;
import com.automation.rehlat.flights.pages.privacyPolicy.PrivacyPolicyBase;
import com.automation.rehlat.flights.pages.rateUs.RateUsBase;
import com.automation.rehlat.flights.pages.referYourFriends.ReferYourFriendsBase;
import com.automation.rehlat.flights.pages.reviewBooking.ReviewBookingBase;
import com.automation.rehlat.flights.pages.settings.SettingsBase;
import com.automation.rehlat.flights.pages.signIn.SignInBase;
import com.automation.rehlat.flights.pages.signUp.SignUpBase;
import com.automation.rehlat.flights.pages.travellerDetails.TravellerDetailsBase;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.automation.rehlat.flights.Labels_Flights.setCountryLanguageAndAirportFromAndToLabels;
import static com.automation.rehlat.flights.pages.constructors.PageConstructor.initializePageObject;


/**
 * Basic actions to be done before the test script execution starts
 */
public class BaseTest extends Base {
    ////////////////////////////// Common Strings Used In All The Tests //////////////////////////////////////
    public static final String SELECT_LANGUAGE = "Language";
    public static final String IOS_USER_LOCATION_ACCESS = "Allow “Rehlat” to access your location while you are using the app?";
    public static final String ANDROID_USER_LOCATION_ACCESS = "Allow Rehlat to access this device's location?";
    public static final String NOTIFICATION_ACCEPTANCE = "“Rehlat” Would Like to Send You Notifications";
    public static final String IOS_ALLOW_BUTTON = "Allow";
    public static final String ANDROID_PERMISSION_ALERT = "com.android.packageinstaller:id/permission_message";
    public static final String ANDROID_ALLOW_BUTTON = "com.android.packageinstaller:id/permission_allow_button";
    public static final String ANDROID_DENY_BUTTON = "com.android.packageinstaller:id/permission_deny_button";
    public static final String DONT_ALLOW_BUTTON = "Don’t Allow";
    public static final String DENY = "DENY";
    public static final String ANDROID_SPLASH_SCREEN = "com.app.rehlat:id/splash_please_wait_dots";
    public static final String SPLASH_SCREEN_ID = "com.app.rehlat:id/splash_please_wait_dots";
    public static final String SPLASH_SCREEN = "android.widget.ImageView";

    ////////////////////////////// Strings Related To The WorkFlows //////////////////////////////////////
    public static final String INTERNATIONALS_TRAVELLERS_COUNTRY_NAME = "Kuwait"; // Using kuwait as a default user country to all the domains
    public static final String DOMESTIC_TRAVELLERS_COUNTRY_NAME = "India";

    public static final String KUWAIT_AIRPORT_NAME_XPATH_IN_SEARCH_RESULTS = "//XCUIElementTypeStaticText[@name=\"Kuwait - Kuwait Intl - Kuwait\"]";
    public static String DEPARTURE_DAY = "2";
    public static String RETURN_DAY = "5";
    public static final String CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS = "1"; // For Android should give number less than 3, because flight card ids/xpaths are reset to 1 to 4 only
    public static final String CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS_WHEN_SOLDOUT_POPUP_INTERRUPTRED = "2"; // For Android should give number less than 3, because flight card ids/xpaths are reset to 1 to 4 only
    public static final String TESTING_BANK_CARD = "Knet Test Card [KNET1]";



    ////////////////////////////// Initialising The Screen Names W.R.T. The Screen Base Names //////////////////////////////////////
    public static FlightsBase FlightsScreen;
    public static MenuBase MenuScreen;
    public static SignInBase SignInScreen;
    public static SignUpBase SignUpScreen;
    public static FlightsSearchResultsBase FlightsSearchResultsScreen;
    public static FlightsSimilarOptionsSearchResultsBase FlightsSimilarOptionsSearchResultsScreen;
    public static ReviewBookingBase ReviewBookingScreen;
    public static BookingPageBase BookingPageScreen;
    public static TravellerDetailsBase TravellerDetailsScreen;
    public static PaymentOptionsBase PaymentOptionsScreen;
    public static MyProfileBase MyProfileScreen;
    public static ReferYourFriendsBase ReferYourFriendsScreen;
    public static MyTripsBase MyTripsScreen;
    public static SettingsBase SettingsScreen;
    public static AppSupportBase AppSupportScreen;
    public static PrivacyPolicyBase PrivacyPolicyScreen;
    public static RateUsBase RateUsScreen;
    public static NotificationsBase NotificationsScreen;
    public static KaramBase KaramScreen;




    ////////////////////////////// Before Class For All The Base Tests Folder //////////////////////////////////////
    @BeforeClass
    public static void setUp() throws Exception{
        Base.setUp();
        BasePage.setUp();

        initializePageObject("signIn", Labels_Flights.platform);
        initializePageObject("flights", Labels_Flights.platform);
        initializePageObject("menu", Labels_Flights.platform);
        initializePageObject("signUp", Labels_Flights.platform);
        initializePageObject("flightsSearchResults", Labels_Flights.platform);
        initializePageObject("flightsSimilarOptionsSearchResultsScreen", Labels_Flights.platform);
        initializePageObject("reviewBookingScreen", Labels_Flights.platform);
        initializePageObject("bookingPageScreen", Labels_Flights.platform);
        initializePageObject("travellerDetailsScreen", Labels_Flights.platform);
        initializePageObject("paymentOptionsScreen", Labels_Flights.platform);
        initializePageObject("myProfileScreen", Labels_Flights.platform);
        initializePageObject("referYourFriendsScreen", Labels_Flights.platform);
        initializePageObject("myTrips", Labels_Flights.platform);
        initializePageObject("settings", Labels_Flights.platform);
        initializePageObject("appSupport", Labels_Flights.platform);
        initializePageObject("rateUs", Labels_Flights.platform);
        initializePageObject("privacyPolicy", Labels_Flights.platform);
        initializePageObject("notifications", Labels_Flights.platform);
        initializePageObject("karam", Labels_Flights.platform);





        checkAndWaitTillTheSplashScreenIsInvisible();
        runTheAppInTheConfigurationOf("KUWAIT","Stage");
//        acceptAutoAlertsIfDisplayed();
    }

    /**
     * Set the coupon code as per the app configuration
     */
    public static void runTheAppInTheConfigurationOf(String domainName, String parsingConfiguration) {
        try {
            setCountryLanguageAndAirportFromAndToLabels(domainName);
            if (parsingConfiguration.equalsIgnoreCase("Live")){
                Labels_Flights.CONFIGURATION_TYPE = Labels_Flights.LIVE_CONFIGURATION_TYPE;
                Labels_Flights.COUPON_CODE = "app8";

            }else if (parsingConfiguration.equalsIgnoreCase("Stage")){
            {
                Labels_Flights.CONFIGURATION_TYPE =  Labels_Flights.STAGE_CONFIGURATION_TYPE;
                Labels_Flights.COUPON_CODE = "automate";
                }
            }else {
                Logger.logError("App configuration is neither live nor stage");
            }
        }catch (Exception exception){
            Logger.logError("Unable to run the live app");
        }
    }
    /**
     * Auto accepting the alerts
     */
    public static void acceptAutoAlertsIfDisplayed() {
        Logger.logStep("Auto accepting alerts if displayed");
        try
        {
        if (Labels_Flights.platform.equals(Labels_Flights.IOS))
        {
            acceptUserLocationAlertInIos();
            acceptNotificationAlertInIos();
        }else if (Labels_Flights.platform.equals(Labels_Flights.ANDROID))
        {
            checkAndWaitTillTheSplashScreenIsInvisible();
            acceptUserLocationAlertInAndroid();
//            acceptNotificationAlertInAndroid(); // Notifications alert is by default allowed in the android app [While installing the app from google store user needs to accept notifications alert]
        }else {
                Logger.logWarning("The platform mentioned for the test script is neither iOS or Android");
        }
        }catch (Exception elementNotFound){
            Logger.logError("Alerts are causing problems and not able to execute the test script");
        }
    }

    /**
     * Creating new sign up email id every time when the new test script run...,Logic: Base email id should be changed in between the range of 101 to 109..,Eg: Base-101 then for every test script should create one new signup email id as 111,121,131,141,..,191..[Formula: Base Email id + 10]
     */
    public static void createNewSignUpEmailId() {
        Logger.logStep("Creating new sign up email id for the current test run");
        Integer newEmailNumber ;
        try {
            if (Labels_Flights.WDA_LOCAL_PORT=="9001" || Labels_Flights.WDA_LOCAL_PORT=="9010" ){
                String BASE_EMAIL_ID_FOR_SIGN_UP = "rehlatAutomationPort1TestingEmail";
                String MAIL_OPERATOR = "@gmail.com";
                String currentEmailIdForSignUp = Labels_Flights.EMAIL_ID_SIGN_UP_PORT_1;
                Integer currentEmailIdNumber = Integer.valueOf(currentEmailIdForSignUp.substring(33, 36));
                for (int index = 0; index <= 999; index++) {
                    Integer settingEmailValue = index;
                    if ((settingEmailValue == currentEmailIdNumber) || (settingEmailValue.equals(currentEmailIdNumber)))  {
                        newEmailNumber = settingEmailValue + 1;
                        String newEmailId = BASE_EMAIL_ID_FOR_SIGN_UP + newEmailNumber + MAIL_OPERATOR;
                        Labels_Flights.EMAIL_ID_SIGN_UP = newEmailId;
                        Labels_Flights.EMAIL_ID_SIGN_UP_PORT_1 = newEmailId;
                        break;
                    }
                }
                Logger.logComment("Newly created email id for to the current test run is :-  " + Labels_Flights.EMAIL_ID_SIGN_UP);
            }else if(Labels_Flights.WDA_LOCAL_PORT =="9005"|| Labels_Flights.WDA_LOCAL_PORT=="9015"){
                String BASE_EMAIL_ID_FOR_SIGN_UP = "rehlatAutomationPort2TestingEmail";
                String MAIL_OPERATOR = "@gmail.com";
                String currentEmailIdForSignUp = Labels_Flights.EMAIL_ID_SIGN_UP_PORT_2;
                Integer currentEmailIdNumber = Integer.parseInt(currentEmailIdForSignUp.substring(33, 36));
                for (int index = 0; index <= 999; index++) {
                    Integer settingEmailValue = index;
                    if ((settingEmailValue == currentEmailIdNumber) || (settingEmailValue.equals(currentEmailIdNumber))) {
                        newEmailNumber = settingEmailValue + 1;
                        String newEmailId = BASE_EMAIL_ID_FOR_SIGN_UP + newEmailNumber + MAIL_OPERATOR;
                        Labels_Flights.EMAIL_ID_SIGN_UP = newEmailId;
                        Labels_Flights.EMAIL_ID_SIGN_UP_PORT_2 = newEmailId;
                        break;
                    }
                }
                Logger.logComment("Newly created email id for to the current test run is :-  " + Labels_Flights.EMAIL_ID_SIGN_UP);
            }else {
                Logger.logError("Encountered error: Unable to get the current WDA LOCAL PORT..,");
            }
        }catch (Exception elementNotFound){
            Logger.logError("Encountered error: Unable to create new email id");
        }
    }

    /**
     * Accepting the User location alerts in iOS
     * @throws Exception
     */
    public static void acceptUserLocationAlertInIos() throws Exception {
        Logger.logStep("Accepting location alert");
        if (isElementDisplayedByName(SELECT_LANGUAGE)) {
            Logger.logComment("Location alert is not displayed, moving to test case execution");
        } else {
            if (isElementDisplayedByName(IOS_USER_LOCATION_ACCESS)) {
                Logger.logComment("Location access alert is displayed and accepting it");
                driver.findElementByName(IOS_ALLOW_BUTTON).click();
                Logger.logComment("Tapped on Allow button");
            } else {
                Logger.logComment("Location alert is not displayed, moving to next alert verification");
            }
        }
    }

    /**
     * Decline the User location alerts in iOS
     * @throws Exception
     */
    public static void declineUserLocationAlertInIos() throws Exception {
        Logger.logStep("Accepting location alert");
        if (isElementDisplayedByName(SELECT_LANGUAGE)) {
            Logger.logComment("Location alert is not displayed, moving to test case execution");
        } else {
            if (isElementDisplayedByName(IOS_USER_LOCATION_ACCESS)) {
                Logger.logComment("Location access alert is displayed and declining it");
                driver.findElementByName(DONT_ALLOW_BUTTON).click();
                Logger.logComment("Tapped on don't allow button");
            } else {
                Logger.logComment("Location alert is not displayed, moving to next alert verification");
            }
        }
    }


    /**
     * Accepting the User location in iOS
     * @throws Exception
     */
     public static void acceptNotificationAlertInIos() throws Exception{
         Logger.logStep("Accepting notification alert");
         if(isElementDisplayedByName(SELECT_LANGUAGE)){
             Logger.logComment("Location alert is not displayed, moving to test script execution");
         }else{
             if (isElementDisplayedByName(NOTIFICATION_ACCEPTANCE)){
                 Logger.logComment("Notification Acceptance access alert is displayed and accepting it");
                 driver.findElementByName(IOS_ALLOW_BUTTON).click();
                 Logger.logComment("Tapped on allow button");
             }else{
                 Logger.logComment("Notification alert is not displayed, moving to test script execution");
             }
         }
     }

    /**
     * Decline the User location in iOS
     * @throws Exception
     */
    public static void declineNotificationAlertInIos() throws Exception{
        Logger.logStep("Accepting notification alert");
        if(isElementDisplayedByName(SELECT_LANGUAGE)){
            Logger.logComment("Location alert is not displayed, moving to test script execution");
        }else{
            if (isElementDisplayedByName(NOTIFICATION_ACCEPTANCE)){
                Logger.logComment("Notification Acceptance access alert is displayed and declining it");
                driver.findElementByName(DONT_ALLOW_BUTTON).click();
                Logger.logComment("Tapped on don't allow button");
            }else{
                Logger.logComment("Notification alert is not displayed, moving to test script execution");
            }
        }
    }

    /**
     * Accepting the User location alerts in Android
     * @throws Exception
     */
    public static void acceptUserLocationAlertInAndroid() throws Exception {
        Logger.logStep("Accepting the location alert");
        if (isElementDisplayedByName(SELECT_LANGUAGE)) {
            Logger.logComment("Location alert is not displayed, moving to test case execution");
        } else {
            if (isElementDisplayedById(ANDROID_PERMISSION_ALERT)){
                String permissionAlert = driver.findElementById(ANDROID_PERMISSION_ALERT).getText();
                if (permissionAlert.equals(ANDROID_USER_LOCATION_ACCESS)) {
                    Logger.logComment("Location access alert is displayed and accepting it");
                    driver.findElementById(ANDROID_ALLOW_BUTTON).click();
                    Logger.logComment("Tapped on allow button");
                } else {
                    Logger.logComment("Location alert is not displayed, moving to next alert verification");
                }
            }else {
                Logger.logComment("Location alert is not displayed and moving to next step");
            }

        }
    }


    /**
     * Decline the User location alerts in Android
     * @throws Exception
     */
    public static void declineUserLocationAlertInAndroid() throws Exception {
        Logger.logStep("Declining the location alert");
        if (isElementDisplayedByName(SELECT_LANGUAGE)) {
            Logger.logComment("Location alert is not displayed, moving to test case execution");
        } else {
            if (isElementDisplayedById(ANDROID_PERMISSION_ALERT)){
                String permissionAlert = driver.findElementById(ANDROID_PERMISSION_ALERT).getText();
                if (permissionAlert.equals(ANDROID_USER_LOCATION_ACCESS)) {
                    Logger.logComment("Location access alert is displayed and declining it");
                    driver.findElementById(ANDROID_DENY_BUTTON).click();
                    Logger.logComment("Tapped on deny button");
                } else {
                    Logger.logComment("Location alert is not displayed, moving to next alert verification");
                }
            }else {
                Logger.logComment("Location alert is not displayed and moving to next step");
            }

        }
    }

    /**
     * Accepting the User location in Android
     * @throws Exception
     */
    public static void acceptNotificationAlertInAndroid() throws Exception{
        Logger.logStep("Accepting notification alert");
        if(isElementDisplayedByName(SELECT_LANGUAGE)){
            Logger.logComment("Location alert is not displayed, moving to test script execution");
        }else{
            if (isElementDisplayedByName(NOTIFICATION_ACCEPTANCE)){
                Logger.logComment("Notification Acceptance access alert is displayed and accepting it");
                driver.findElementById(ANDROID_ALLOW_BUTTON).click();
                Logger.logComment("Tapped on allow button");
            }else{
                Logger.logComment("Notification alert is not displayed, moving to test script execution");
            }
        }
    }

    /**
     * Check the splash screen is displayed and waits till invisibility of the splash screen (Implemented only for android platform)
     */
    public static void checkAndWaitTillTheSplashScreenIsInvisible() {
        Logger.logStep("Checking splash screen is displayed or not ?");
        try {
            if (Labels_Flights.platform.equals(Labels_Flights.ANDROID)){
                if (isElementDisplayedById(ANDROID_SPLASH_SCREEN)){
                    Logger.logComment("Splash screen is displayed and waiting till the screen is invisible");
                    waitForAnElementToDisappear_ById(ANDROID_SPLASH_SCREEN);
                }else {
                    Logger.logComment("Splash screen is not displayed and moving forward to basic test(s)");
                }
            }else if (Labels_Flights.platform.equals(Labels_Flights.IOS)) {
                Logger.logComment("No Splash screen for iOS Device on launching multiple times");
            }else {
                Logger.logError("Platform of the testing device is neither android nor iOS");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the current active screen name");
        }
    }

    /**
     * Used to take a screen shot of the screen when ever sold out popup is is displayed.
     * @return void
     */
    public static void takeScreenshotAndSaveInSoldOutsFolder() {
        try {
            Logger.logComment(" Failure in the script, so taking the screenshot");
            String nameOfTestCase = getTestCaseName();
            String pathOfScreenshot = "Screenshots/SoldOuts"+ nameOfTestCase + "_" + getPlatform();
            String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            System.out.println(new File(pathOfScreenshot + "_" + time + ".jpg"));
            File screenshot = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(pathOfScreenshot + "_" + time + ".jpg"));
        } catch (Exception e) {
            Logger.logWarning(" couldn't take screenshot");
        }
    }

    /**
     * Getting the simulator app path
     * @param parsingUDID
     * @return
     */
    public static String getTheSimulatorAppPath(String parsingUDID){
        Logger.logAction("Setting up the app path");
        try {
            if (Labels_Flights.DEFAULT_PLATFORM.equals(Labels_Flights.IOS)){
                if (parsingUDID.contains("-")){
                    Logger.logComment("Current running script is on simulator");

                     String appPath = "/Users/rehlat/Documents/SimulatorProject/Rehlat.app"; //Todo:- This code is used as the simulator build is configured as common one
                     return appPath;
                }else {
                    Logger.logComment("Current running script is on real device, will go with the relative app path");
                    String appPath = "../Rehlat.app";
                    Labels_Flights.CALENDAR_SWIPE_DURATION = 400;
                    return appPath;
                }
            }else if (Labels_Flights.DEFAULT_PLATFORM.equals(Labels_Flights.ANDROID)){
                Labels_Flights.CALENDAR_SWIPE_DURATION = 700; // by default set to 400
                Logger.logComment("Current running script is on android device, will go with the relative app path");
            }else {
                Logger.logError("Current running script is either android nor iOS");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the device path");
        }
        return null;
    }
}
