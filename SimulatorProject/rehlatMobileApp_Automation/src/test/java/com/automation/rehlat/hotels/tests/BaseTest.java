package com.automation.rehlat.hotels.tests;

import com.automation.rehlat.hotels.Base;
import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.pages.BasePage;
import com.automation.rehlat.hotels.pages.bookingSummary.BookingSummaryBase;
import com.automation.rehlat.hotels.pages.guestTravellersDetails.GuestTravellersDetailsBase;
import com.automation.rehlat.hotels.pages.hotelProfile.HotelsProfileBase;
import com.automation.rehlat.hotels.pages.hotels.HotelsBase;
import com.automation.rehlat.hotels.pages.hotelsSearchResults.HotelsSearchResultsBase;
import com.automation.rehlat.hotels.pages.menu.MenuBase;
import com.automation.rehlat.hotels.pages.paymentsOptions.PaymentOptionsBase;
import com.automation.rehlat.hotels.pages.selectRooms.SelectRoomsBase;
import com.automation.rehlat.hotels.pages.settings.SettingsBase;
import com.automation.rehlat.hotels.pages.signIn.SignInBase;
import com.automation.rehlat.hotels.pages.signUp.SignUpBase;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.automation.rehlat.hotels.Labels_Hotels.*;
import static com.automation.rehlat.hotels.pages.constructors.PageConstructor.initializePageObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

/**
 * Basic actions to be done before the test script execution starts
 */
public class BaseTest extends Base {
    ////////////////////////////// Common Strings Used In All The Tests //////////////////////////////////////
    public static final String SELECT_LANGUAGE = "Select Language";
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
    public static String CHECK_IN_DAY = "4";
    public static String CHECK_OUT_DAY = "5";
    public static final String CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS = "2"; // For Android should give number less than 3, because flight card ids/xpaths are reset to 1 to 4 only
    public static final String CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS_WHEN_SOLDOUT_POPUP_INTERRUPTRED = "1"; // For Android should give number less than 3, because flight card ids/xpaths are reset to 1 to 4 only
    public static final String TESTING_BANK_CARD = "Knet Test Card [KNET1]";



    ////////////////////////////// Initialising The Screen Names W.R.T. The Screen Base Names //////////////////////////////////////
    public static BookingSummaryBase BookingSummaryScreen;
    public static MenuBase MenuScreen;
    public static HotelsBase HotelsScreen;
    public static HotelsProfileBase HotelsProfileScreen;
    public static PaymentOptionsBase PaymentOptionsScreen;
    public static SelectRoomsBase SelectRoomsScreen;
    public static HotelsSearchResultsBase HotelsSearchResultsScreen;
    public static GuestTravellersDetailsBase GuestTravellersDetailsScreen;
    public static SignInBase SignInScreen;
    public static SignUpBase SignUpScreen;
    public static SettingsBase SettingsScreen;



    ////////////////////////////// Before Class For All The Base Tests Folder //////////////////////////////////////
    @BeforeClass
    public static void setUp() throws Exception{
        Base.setUp();
        BasePage.setUp();

        initializePageObject("signIn", platform);
        initializePageObject("hotels", platform);
        initializePageObject("menu", platform);
        initializePageObject("signUp", platform);
        initializePageObject("bookingSummary", platform);
        initializePageObject("hotelsProfile", platform);
        initializePageObject("hotelsSearchResults", platform);
        initializePageObject("selectRooms", platform);
        initializePageObject("paymentOptionsScreen", platform);
        initializePageObject("myProfileScreen", platform);
        initializePageObject("guestTravellersDetailsScreen", platform);
        initializePageObject("settings", platform);
//        initializePageObject("referYourFriendsScreen", Labels_Hotels.platform);
//        initializePageObject("myTrips", Labels_Hotels.platform);
//        initializePageObject("appSupport", Labels_Hotels.platform);
//        initializePageObject("rateUs", Labels_Hotels.platform);
//        initializePageObject("privacyPolicy", Labels_Hotels.platform);
//        initializePageObject("notifications", Labels_Hotels.platform);
//        initializePageObject("karam", Labels_Hotels.platform);
//




        checkAndWaitTillTheSplashScreenIsInvisible();
        runTheAppInTheConfigurationOf(Labels_Hotels.CURRENT_RUNNING_DOMAIN, Labels_Hotels.CURRENT_RUNNING_APP_ENVIRONMENTAL_CONFIGURATION);
//        acceptAutoAlertsIfDisplayed();
    }

    /**
     * Set the coupon code as per the app configuration
     */
    public static void runTheAppInTheConfigurationOf(String domainName, String parsingConfigurationType) {
        try {
            setCountryLanguageAndAirportFromAndToLabels(domainName);
            if (parsingConfigurationType.equalsIgnoreCase("Live")){
                Labels_Hotels.CONFIGURATION_TYPE = Labels_Hotels.LIVE_CONFIGURATION_TYPE;
                Labels_Hotels.COUPON_CODE = "save15";
            }else if (parsingConfigurationType.equalsIgnoreCase("Stage")){
                Labels_Hotels.CONFIGURATION_TYPE = Labels_Hotels.STAGE_CONFIGURATION_TYPE;
                Labels_Hotels.COUPON_CODE = "save15";
            }else {
                Logger.logError("App configuration is neither live nor stage");
            }
        }catch (Exception exception){
            Logger.logError("Unable to run the live app");
        }
    }

    /**
     * Print the current running device information
     */
    public static void printCurrentTestRunningInformation(){
        Logger.logAction("Printing the current test running information");
        try {
            Logger.logStep("Current test running information is :- ");
            Logger.logComment("Device Name          :- "+Labels_Hotels.DEVICE_NAME);
            if (platform.equalsIgnoreCase(ANDROID)){
                Logger.logComment("Device OS            :- "+Labels_Hotels.ANDROID_DEVICE_OS);
            }else if (platform.equalsIgnoreCase(IOS)){
                Logger.logComment("Device OS            :- "+Labels_Hotels.DEVICE_UDID);
            }else {
                Logger.logError("Incorrect platform..ie.., Current test running device is neither iOS and Android");
            }
            Logger.logComment("App Configuration    :- "+Labels_Hotels.CONFIGURATION_TYPE);
            Logger.logComment("Port Number          :- "+Labels_Hotels.CURRENT_RUNNING_PORT_NUMBER_TYPE);
            Logger.logComment("Current Domain       :- "+Labels_Hotels.CURRENT_RUNNING_DOMAIN);
            addTestResultStatusToExecutionResultsJsonFile(Labels_Hotels.testCaseName,"false");// Todo:- By Default setting the test case execution status as false
        }catch (Exception exception){
            Logger.logError("Unable to print the current test running information");
        }
    }

    /**
     * Auto accepting the alerts
     */
    public static void acceptAutoAlertsIfDisplayed() {
        Logger.logStep("Auto accepting alerts if displayed");
        try
        {
        if (platform.equals(IOS))
        {
            acceptUserLocationAlertInIos();
            acceptNotificationAlertInIos();
        }else if (platform.equals(ANDROID))
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
            Labels_Hotels.EMAIL_ID_NUMBER_FOR_SIGN_UP_WRT_PORT_NUMBER = Integer.valueOf(getTheNewEmailNumber(Labels_Hotels.CURRENT_RUNNING_PORT_NUMBER_TYPE));
            String BASE_EMAIL_ID_FOR_SIGN_UP_WITHOUT_PORT_NUMBER = "rehlatAutomationSimu";
            String BASE_EMAIL_ID_FOR_SIGN_UP = BASE_EMAIL_ID_FOR_SIGN_UP_WITHOUT_PORT_NUMBER+Labels_Hotels.CURRENT_RUNNING_PORT_NUMBER_TYPE+"TestingEmail";
            String MAIL_OPERATOR = "@gmial.cm";
            Integer currentEmailIdNumberForSignUp = Integer.valueOf(Labels_Hotels.EMAIL_ID_NUMBER_FOR_SIGN_UP_WRT_PORT_NUMBER);
            for (int index = 0; index <= 999; index++) {
                Integer settingEmailValue = index;
                if ((settingEmailValue == currentEmailIdNumberForSignUp) || (settingEmailValue.equals(currentEmailIdNumberForSignUp)))  {
                    newEmailNumber = settingEmailValue + 1;
                    String newEmailId = BASE_EMAIL_ID_FOR_SIGN_UP + newEmailNumber + MAIL_OPERATOR;
                    Labels_Hotels.EMAIL_ID_SIGN_UP = newEmailId;
                    break;
                }
            }
            Logger.logComment("Newly created email id for to the current test run is :-  " + Labels_Hotels.EMAIL_ID_SIGN_UP);
        }catch (Exception elementNotFound){
            Logger.logError("Encountered error: Unable to create new email id");
        }
    }

    /**
     * For sign up get the new email number w.r.t. the port number
     */
    public static String getTheNewEmailNumber(String parsingPortNumberType) throws Exception{
        Logger.logAction("Getting the new email number w.r.t. the port number");
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader(Labels_Hotels.PATH_OF_EMAIL_WRT_PORT_NUMBER_JSON_FILE);
            JSONArray arrayNumber = (JSONArray) jsonParser.parse(fileReader);
            JSONObject object = (JSONObject) arrayNumber.get(0);
            String emailCount = (String) object.get(parsingPortNumberType);
            Integer updatedEmailCount = Integer.parseInt(String.valueOf(emailCount))+1;
            object.put(parsingPortNumberType,updatedEmailCount.toString());
            FileWriter fileWriter = new FileWriter(Labels_Hotels.PATH_OF_EMAIL_WRT_PORT_NUMBER_JSON_FILE);
            fileWriter.write(arrayNumber.toString());
            fileWriter.flush();
            return emailCount;
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error:- Unable to get the new email number");
        }
        return null;
    }

    /**
     * Create a execution results json file
     */
    public static void addTestResultStatusToExecutionResultsJsonFile(String testCaseName, String executionStatus){
        Logger.logAction("Adding the test result status to execution results json file");
        try {
            try {
                String jsonParameters = "[{}]";
                FileReader fileReader;
                JSONParser jsonParser = new JSONParser();
                try {
                    fileReader = new FileReader(ReportFileName);
                }catch (FileNotFoundException fileNotfoundException){
                    FileWriter fileWriter = new FileWriter(ReportFileName);
                    fileWriter.write(jsonParameters);
                    fileWriter.flush();
                    fileReader = new FileReader(ReportFileName);
                }
                JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
                JSONObject jsonObject = (JSONObject) jsonArray.get(0);
                jsonObject.put(testCaseName,executionStatus);
                FileWriter fileWriter = new FileWriter(ReportFileName);
                fileWriter.write(jsonArray.toString());
                fileWriter.flush();
                Logger.logComment("Added the test result status to execution results json file");
            }catch (Exception fileWriterException){
                fileWriterException.printStackTrace();
                Logger.logError("Unable to create the execution results file");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to create the execution results json file");
        }
    }

    /**
     * Create an html document of execution results from execution results json file
     */
    public static String createHtmlStringOfExecutionResults(String htmlReportFile){
        Logger.logAction("Creating the html document of execution results");
        try {
            Integer totalFailTCSCount = 0;
            Integer totalPassTCSCount = 0;
            String fullHtmlReport = "";
            String headerHtmlWithoutClosingBodyAndTableHtmlStrings = headerHtmlWithoutClosingBodyAndTableHtmlStrings();
            String closingBodyAndTableHtmlStrings = closingBodyAndTableHtmlStrings();
            String htmlTcRowsReport = "";
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader(htmlReportFile);
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            Iterator keys= jsonObject.keySet().iterator();
            while (keys.hasNext())
            {
                String tcName = (String)keys.next();
                String tcReport = (String) jsonObject.get(tcName);
                if (tcReport.contains("false")){
                    totalFailTCSCount = totalFailTCSCount+1;
                }else if (tcReport.equalsIgnoreCase("true")){
                    totalPassTCSCount = totalPassTCSCount+1;
                }else {
                    Logger.logError(tcReport+" is neither true nor false");
                }
                String appendedRow = appendRowInExecutionHtmlReport(tcName,tcReport);
                htmlTcRowsReport = htmlTcRowsReport.concat(appendedRow);
            }
            String totalTCSCount = String.valueOf(jsonObject.size());
            String totalTestCasesCount_HtmlString = appendRowInExecutionHtmlReport("Total Executed Test Cases Count",totalTCSCount);
            String totalPassTCSCount_HtmlString = appendRowInExecutionHtmlReport("Total Passed Test Cases Count",totalPassTCSCount.toString());
            String totalFailTCSCount_HtmlString = appendRowInExecutionHtmlReport("Total Failed Cases Count",totalFailTCSCount.toString());
            fullHtmlReport = headerHtmlWithoutClosingBodyAndTableHtmlStrings.concat(htmlTcRowsReport).concat(totalTestCasesCount_HtmlString).concat(totalPassTCSCount_HtmlString).concat(totalFailTCSCount_HtmlString).concat(closingBodyAndTableHtmlStrings);
            Logger.logComment("Execution report in html format is created :- \n\n"+fullHtmlReport);
            return fullHtmlReport;
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to create html document of execution results");
        }
        return null;
    }

    /**
     * Append the row in the html execution report
     */
    public static String appendRowInExecutionHtmlReport(String tcName, String tcReport){
        try {
            StringBuilder htmlStringBuilder = new StringBuilder();
            htmlStringBuilder.append("<tbody>");
            htmlStringBuilder.append("<tr>");
            if (tcName.contains("Total")){
                if (tcName.equalsIgnoreCase("Total Passed Test Cases Count")){
                    htmlStringBuilder.append("<td>"+tcName+Labels_Hotels.ONE_CHARACTER_SPACE+"("+"<font color=\"green\">&#10004;<font color=\"black\">)</td>");
                }else if (tcName.equalsIgnoreCase("Total Failed Cases Count")){
                    htmlStringBuilder.append("<td>"+tcName+Labels_Hotels.ONE_CHARACTER_SPACE+"("+"<font color=\"red\">&#10006;<font color=\"black\">)</td>");
                }else {
                    htmlStringBuilder.append("<td>"+tcName+"</td>");
                }
                htmlStringBuilder.append("<td align=\"center\"><font color=\"black\">"+tcReport+"</td>");
                htmlStringBuilder.append("<td></td>");
            }else {
                htmlStringBuilder.append("<td>"+tcName+"</td>");
                if (tcReport.contains("true")){
                    htmlStringBuilder.append("<td align=\"center\"><font color=\"green\">&#10004;</td>");
                    htmlStringBuilder.append("<td></td>");
                }else if (tcReport.contains("false")){
                    String failureReason = tcReport.replace("false",Labels_Hotels.STRING_NULL).trim();
                    htmlStringBuilder.append("<td align=\"center\"><font color=\"red\">&#10006;</td>");
                    if (failureReason.equalsIgnoreCase("Tickets Are Sold Out In Two Attempts")){
                        htmlStringBuilder.append("<td>For 2 Attempts - Sold Outs</td>");
                    }else if (failureReason.equalsIgnoreCase("false Payment Failed")){
                        htmlStringBuilder.append("<td>Payment Failed</td>");
                    }
                    else {
                        htmlStringBuilder.append("<td>Issue</td>");
                    }
                }else {
                    Logger.logError(tcName+" value is neither true nor false");
                }
            }
            htmlStringBuilder.append("</tr>");
            htmlStringBuilder.append("</tbody>");
            return htmlStringBuilder.toString();
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to append the row in execution report");
        }
        return null;
    }

    /**
     * Header html without closing body and table
     */
    public static String headerHtmlWithoutClosingBodyAndTableHtmlStrings(){
        try {
            StringBuilder htmlStringBuilder = new StringBuilder();
            htmlStringBuilder.append("<table style=\"height: 59px; border-color: 330000; background-color:#FFCC99;\" border=\"3\" width=\"585\"");
            htmlStringBuilder.append("<thead>");
            htmlStringBuilder.append("<tr>");
            htmlStringBuilder.append("<th>TC'S NAMES</th>");
            htmlStringBuilder.append("<th>EXECUTION STATUS</th>");
            htmlStringBuilder.append("<th>FAILURE REASON</th>");
            htmlStringBuilder.append("</tr>");
            htmlStringBuilder.append("</thead>");
            htmlStringBuilder.append("<tfoot>");
            htmlStringBuilder.append("<tr>");
            htmlStringBuilder.append("</tr>");
            htmlStringBuilder.append("</tfoot>");
            return htmlStringBuilder.toString();
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to create header html without closing body and table");
        }
        return null;
    }

    /**
     * Header html without closing body and table
     */
    public static String closingBodyAndTableHtmlStrings(){
        try {
            StringBuilder htmlStringBuilder = new StringBuilder();
            htmlStringBuilder.append("</tbody>");
            htmlStringBuilder.append("</table>");
            return htmlStringBuilder.toString();
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to create header html without closing body and table");
        }
        return null;
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
     * Decline the User location in Android
     * @throws Exception
     */
    public static void declineNotificationAlertInAndroid() throws Exception{
        Logger.logStep("Accepting notification alert");
        if(isElementDisplayedByName(SELECT_LANGUAGE)){
            Logger.logComment("Location alert is not displayed, moving to test script execution");
        }else{
            if (isElementDisplayedByName(NOTIFICATION_ACCEPTANCE)){
                Logger.logComment("Notification Acceptance access alert is displayed and declining it");
                driver.findElementById(ANDROID_DENY_BUTTON).click();
                Logger.logComment("Tapped on decline button");
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
            if (platform.equals(ANDROID)){
                if (isElementDisplayedById(ANDROID_SPLASH_SCREEN)){
                    Logger.logComment("Splash screen is displayed and waiting till the screen is invisible");
                    waitForAnElementToDisappear_ById(ANDROID_SPLASH_SCREEN);
                }else {
                    Logger.logComment("Splash screen is not displayed and moving forward to basic test(s)");
                }
            }else if (platform.equals(IOS)) {
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
            String pathOfScreenshot = "Screenshots/SoldOuts/"+ nameOfTestCase + "_" + getPlatform();
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
            if (Labels_Hotels.DEFAULT_PLATFORM.equals(IOS)){
                if (parsingUDID.contains("-")){
                    Logger.logComment("Current running script is on simulator");
                    if (parsingUDID.equalsIgnoreCase("9A0D9008-C6C7-4A1B-A6BD-91B8A34E6032")){
                        Logger.logComment("Current script running device name is :- iPhone 5s");
                        String appPath = "/Users/rehlat/Documents/Suresh/Automation/Flights/Builds/SimulatorBuilds/iPhone5S/Rehlat.app";
                        Labels_Hotels.DEVICENAME = "iPhone 5s";
                        Labels_Hotels.CALENDAR_SWIPE_DURATION = 700; // by default set to 400
                        return appPath;
                    }else if (parsingUDID.equalsIgnoreCase("91981FA4-3BB9-4A16-9AA3-D6919C4C2FC2")){
                        Logger.logComment("Current script running device name is :- iPhone 6");
                        String appPath = "/Users/rehlat/Documents/Suresh/Automation/Flights/Builds/SimulatorBuilds/iPhone6/Rehlat.app";
                        Labels_Hotels.DEVICENAME = "iPhone 6";
                        Labels_Hotels.CALENDAR_SWIPE_DURATION = 400;
                        return appPath;
                    }else if (parsingUDID.equalsIgnoreCase("73487701-EE25-48C9-9229-8074840D3940")){
                        Logger.logComment("Current script running device name is :- iPhone 7");
                        String appPath = "/Users/rehlat/Documents/Suresh/Automation/Flights/Builds/SimulatorBuilds/iPhone7/Rehlat.app";
                        Labels_Hotels.DEVICENAME = "iPhone 7";
                        Labels_Hotels.CALENDAR_SWIPE_DURATION = 400;
                        return appPath;
                    }else if (parsingUDID.equalsIgnoreCase("45692414-3101-468A-9971-B2CEAAC6BF85")){
                        Logger.logComment("Current script running device name is :- iPhone X");
                        String appPath = "/Users/rehlat/Documents/Suresh/Automation/Flights/Builds/SimulatorBuilds/iPhoneX/Rehlat.app";
                        Labels_Hotels.DEVICENAME = "iPhone X";
                        Labels_Hotels.CALENDAR_SWIPE_DURATION = 400;
                        return appPath;
                    }else if (parsingUDID.equalsIgnoreCase("55835BA3-BC59-41C6-9A83-3F813E48E25E")){
                        Logger.logComment("Current script running device name is :- iPhone XR");
                        String appPath = "/Users/rehlat/Documents/Suresh/Automation/Flights/Builds/SimulatorBuilds/iPhoneX/Rehlat.app";
                        Labels_Hotels.DEVICENAME = "iPhone XR";
                        Labels_Hotels.CALENDAR_SWIPE_DURATION = 400;
                        return appPath;
                    }else if (parsingUDID.equalsIgnoreCase("191E84F0-2120-4A08-B33C-0AF03B4D0348")){
                        Logger.logComment("Current script running device name is :- iPhone XS");
                        String appPath = "/Users/rehlat/Documents/Suresh/Automation/Flights/Builds/SimulatorBuilds/iPhoneX/Rehlat.app";
                        Labels_Hotels.DEVICENAME = "iPhone XS";
                        Labels_Hotels.CALENDAR_SWIPE_DURATION = 400;
                        return appPath;
                    }else if (parsingUDID.equalsIgnoreCase("DB94E19B-A74A-4484-B7A2-3FEC43C0CC2D")){
                        Logger.logComment("Current script running device name is :- iPhone XS Max");
                        String appPath = "/Users/rehlat/Documents/Suresh/Automation/Flights/Builds/SimulatorBuilds/iPhoneX/Rehlat.app";
                        Labels_Hotels.DEVICENAME = "iPhone XS Max";
                        Labels_Hotels.CALENDAR_SWIPE_DURATION = 400;
                        return appPath;
                    }
                }else {
                    Logger.logComment("Current running script is on real device, will go with the relative app path");
                    String appPath = "../Rehlat.app";
                    Labels_Hotels.CALENDAR_SWIPE_DURATION = 400;
                    return appPath;
                }
            }else if (Labels_Hotels.DEFAULT_PLATFORM.equals(ANDROID)){
                Labels_Hotels.CALENDAR_SWIPE_DURATION = 700; // by default set to 400
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
