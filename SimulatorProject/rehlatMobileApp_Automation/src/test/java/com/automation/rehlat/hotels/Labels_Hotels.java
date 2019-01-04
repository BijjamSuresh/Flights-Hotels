package com.automation.rehlat.hotels;

import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.tests.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class Labels_Hotels extends Base {
    //////// APPIUM Capabilities /////////////////////
    public static final String APPIUM_PORT_NUMBER_DEFAULT = "4790";
    public static final String DEVICE_TYPE_DEFAULT = "phone";
    public static final String PATH_OF_EMAIL_WRT_PORT_NUMBER_JSON_FILE = "/Users/rehlat/Documents/PortNumbers_WRT_EmailCount.json";
    public static final String PATH_OF_iOS_DEVICES_LIST_WRT_DEVICE_NAMES_JSON_FILE = "/Users/rehlat/Documents/iPhoneSimulatorsDevicesList.json";
    public static final String PATH_OF_ANDROID_DEVICES_LIST_WRT_DEVICE_NAMES_JSON_FILE = "/Users/rehlat/Documents/AndroidSimulatorsDevicesList.json";

    ////////////////////  Types of devices ////////////////////
    public static final String IOS="iOS";
    public static final String ANDROID="Android";

    //////  Important Capabilities//////////
    //Todo:- Please recheck on editing the below labels
    public static String DEFAULT_PLATFORM = ANDROID;
    public static final String CURRENT_RUNNING_DOMAIN = "KWI";
    public static final String CURRENT_RUNNING_APP_ENVIRONMENTAL_CONFIGURATION = "Live";
    public static String DEVICE_NAME = "Nexus6";
    public static String DEVICE_OS = "12.1"; //Todo:- Device OS needs to be changed only for iOS, for android automatically it will pick up the device by OS base while test script running.
    public static String CURRENT_RUNNING_PORT_NUMBER_TYPE = "6"; // Max:10 -- If this port number is changed make sure you have an Integer w.r.t. changed port number as below Integers
    public static Integer EMAIL_ID_NUMBER_FOR_SIGN_UP_WRT_PORT_NUMBER; // This is for port two connected device [Either iOS or Android]
    public static String WDA_LOCAL_PORT_DEFAULT = "8050";
    public static final String ANDROID_CAPABILITIES_DEVICE_TYPE = "Emulator";
    public static String DEVICE_UDID ;
    public static String ANDROID_DEVICE_OS;
    public static final String APPIUM_DEVICE_ID_DEFAULT = "BH901M4F4C"; // Sony device id //Todo:- Before running the script check the UDID w.r.t. devices is listed/added in the android devices list json file.
    //    public static final String ANDROID_CAPABILITIES_APP_PATH = "../app_debug.apk";
    public static final String ANDROID_CAPABILITIES_APP_PATH = "../app_release.apk";
    public static final String ReportFileName = "Execution_Results_"+DEVICE_NAME+"_"+CURRENT_RUNNING_DOMAIN+"_Domain.json"; //Todo:- Before running the scripts make sure this json is created in the project location


    /**
     * Assigning the device UDID that needs to be run w.r.t the device name
     */
    static {
        try {
            if (DEFAULT_PLATFORM.equalsIgnoreCase(IOS)){
                String UDID_OF_DEVICE_TO_RUN = getTheIosDeviceUDIDWrtTheDeviceName(DEVICE_NAME);
                DEVICE_UDID = UDID_OF_DEVICE_TO_RUN;
            }else if (DEFAULT_PLATFORM.equalsIgnoreCase(ANDROID)){
                String OS_OF_DEVICE_TO_RUN = getTheAndroidDeviceOS(DEVICE_NAME);
                ANDROID_DEVICE_OS = OS_OF_DEVICE_TO_RUN;
                DEVICE_OS = ANDROID_DEVICE_OS;
            }else {
                Logger.logError("Current Running platform is neither iOS nor Android");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    //////  APPIUM  iOS app capabilities//////////
    public static final String IOS_BUNDLE_ID="com.Rehlat.RehlatMobile";
    public static final String IOS_CAPABILITIES_APP_PATH = "../Rehlat.app";
    public static final String APPIUM_PORT_NUMBER_IOS = System.getProperty("port", APPIUM_PORT_NUMBER_DEFAULT);
    public static final String IOS_CAPABILITIES_URL = "http://localhost:" + APPIUM_PORT_NUMBER_IOS + "/wd/hub";
    public static final String IOS_CAPABILITIES_DEVICE_NAME = "iPhone 7 Plus";
    public static final String IOS_CAPABILITIES_PLATFORM_VERSION_IPHONE7PLUS = "12.0";
    public static final String IOS_CAPABILITIES_PLATFORM_NAME = "iOS";
    public static final String IOS_CAPABILITIES_APPIUM_VERSION = "1.9.1";
    public static final String TERMINAL_COMMAND_LISTING_CONNECTED_IOS_DEVICES = "instruments -s devices";


    /////////  APPIUM  android app capabilities /////////
    public static final String ANDROID_PLATFORM = "Android";
    public static final String ANDROID_CAPABILITIES_PLATFORM_VERSION = ANDROID_DEVICE_OS; // Nexus emulator version
    public static final String ANDROID_CAPABILITIES_APPIUM_VERSION = "1.8.1";
    public static final String APPIUM_PORT_NUMBER = System.getProperty("port", APPIUM_PORT_NUMBER_DEFAULT);
    protected static final String ANDROID_CAPABILITIES_DEVICE_ID = System.getProperty("deviceId", APPIUM_DEVICE_ID_DEFAULT);
    public static final String ANDROID_CAPABILITIES_URL = "http://localhost:" + APPIUM_PORT_NUMBER + "/wd/hub";
    public static final String ANDROID_CAPABILITIES_PACKAGE_NAME = "com.app.rehlat";
    public static final int DEFAULT_TAP_DURATION = 50;
    public static final int DEFAULT_FINGER_FOR_TAP = 1;


    ///////////  ORIENTATION  ///////////
    public static final String PORTRAIT_ORIENTATION ="PORTRAIT";
    public static final String LANDSCAPE_ORIENTATION ="LANDSCAPE";

    ///////////  WAIT  and DURATION //////////////
    public static final int WAIT_TIME_MIN =3000;
    public static final int WAIT_TIME_DEFAULT =5000;
    public static final int WAIT_TIME_MAX =10000;
    public static final int BACKGROUND_TIME_MIN =3;
    public static final int BACKGROUND_TIME_DEFAULT =5;
    public static final int BACKGROUND_TIME_MAX =10;
    public static final int DEFAULT_WAITING_TIME = 20;
    public static final double DEFAULT_SWIPE_DURATION_ANDROID = 500; // This is in milliseconds
    public static final double DEFAULT_SWIPE_DURATION_iOS = 1; // This is in seconds
    public static final double DEFAULT_SWIPE_MARGIN = 0.1;
    public static final int SWIPE_DURATION_MIN = 500;
    public static final int SWIPE_DURATION_DEFAULT = 5000;
    public static final int SWIPE_DURATION_MAX = 10000;
    public static final int TAP_DURATION_MIN = 100;
    public static final int TAP_DURATION_DEFAULT = 3000;
    public static final int TAP_DURATION_MAX = 10000;


    ////////////////////  File paths ////////////////////
    public static final String homeDirectory = System.getProperty("user.home");
    public static final String SOURCE_FOLDER_PATH = homeDirectory+"/Rehlat/IdeaProjects/rehlatMobileApp_Automation"; //changes based on project


    ////////////////////  Integer value for direction ////////////////////
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_RIGHT = 4;

    ////////////////////  Number of attempts to iterate  ////////////////////
    public static final int MIN_ATTEMPTS = 2;
    public static final int DEFAULT_ATTEMPTS = 5;
    public static final int MAX_ATTEMPTS = 8;
    public static final int DEFAULT_SCROLL_ATTEMPTS = 5;



    ////////////////////  Web element attribute values ////////////////////
    public static final String UIA_DATEPICKER ="XCUIElementTypeDatePicker";
    public static final String IOS_ACTIVITY_INDICATOR = "XCUIElementTypeActivityIndicator";
    public static final String IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW = "XCUIElementTypeCollectionView";
    public static final String IOS_XCUI_ELEMENT_TYPE_SCROLL_VIEW = "XCUIElementTypeScrollView";
    public static final String IOS_XCUI_ELEMENT_TYPE_SHEET = "XCUIElementTypeSheet";
    public static final String IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT = "XCUIElementTypeStaticText";
    public static final String IOS_XCUI_ELEMENT_TYPE_TEXT_FIELD = "XCUIElementTypeTextField";
    public static final String IOS_XCUI_ELEMENT_TYPE_CELL = "XCUIElementTypeCell";
    public static final String ANDROID_LINEAR_LAYOUT = "android.widget.LinearLayout";
    public static final String ANDROID_VIEW_GROUP = "android.view.ViewGroup";
    public static final String ANDROID_TEXT_VIEW = "android.widget.TextView";
    public static final String ANDROID_TAB_BAR = "android.support.v7.app.ActionBar$Tab";
    public static final String UIA_KEYBOARD = "UIAKeyboard";
    public static final String ALERT_ID = "android:id/contentPanel";
    public static final String TERMINAL_COMMAND_LIST_CONNECTED_USB_DEVICE = "system_profiler SPUSBDataType";
    public static final String ANDROID_DATE_PICKER = "android:id/datePicker";
    public static final String ANDROID_ACTIVITY_INDICATOR = "com.app.rehlat:id/progressBar";
    public static final String VALUE_ONE ="1";
    public static final String VALUE_ZERO ="0";
    public static final String ANDROID_TOGGLE_TEXT_ON ="ON";
    public static final String ANDROID_TOGGLE_TEXT_OFF ="OFF";
    public static final String VALUE_ATTRIBUTE="value";
    public static final String CHECKED_ATTRIBUTE = "checked";
    public static final String VISIBLE_ATTRIBUTE="visible";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String SELECTED_ATTRIBUTE = "selected";
    public static final String STATUS_TRUE="true";
    public static final String STATUS_FALSE="false";
    public static final String STRING_NULL = "";
    public static final String STRING_COMMA = ",";
    public static final String DOT_STRING = ".";
    public static String TRAVELLERS_TYPE;




    ////////////////////  Regular Expression pattern ////////////////////
    public static final String IOS_VERSION_PATTERN = "(\\([0-9](.)[0-9]\\)|\\([0-9]+(.)[0-9].[0-9]\\)|\\([0-9](.)[0-9](.)[0-9]\\)|\\([0-9]\\))";

    ///////////  Property value getters ////////////
    public static String platform = System.getProperty("platform", DEFAULT_PLATFORM);
    public static final String ANDROID_DEVICE_TYPE = System.getProperty("device_type", DEVICE_TYPE_DEFAULT);
    public static final String udid = System.getProperty("udid",DEVICE_UDID );
    public static final String WDA_LOCAL_PORT = System.getProperty("wda",WDA_LOCAL_PORT_DEFAULT);
    ///////////////  Test script execution details ///////////////
    boolean resetStatus;
    public static final int numberOfTestCasesToRun = 250;
    public static String testCaseName;

    //////  Backend Server data //////
    // Any information from the backend server will be written here..,

    /////////////////  User  Credentials And Inspector Elements ////////////////

    public static final String ADULT_TRAVELLERS_FIRST_NAME="Suresh";
    public static final String ADULT_TRAVELLERS_MIDDLE_NAME="Reddy";
    public static final String ADULT_TRAVELLERS_LAST_NAME="Bijjam";
    public static final String CHILD_TRAVELLERS_FIRST_NAME="Suresh";
    public static final String CHILD_TRAVELLERS_MIDDLE_NAME="Reddy";
    public static final String CHILD_TRAVELLERS_LAST_NAME="Automation";
    public static final String TRAVELLERS_DATEOFBIRTH_ANDROID="02 June 2005";
    public static final String TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID="02 February 2020";
    public static final String YEAR_IN_TRAVELLERS_DATEOFBIRTH_ANDROID ="2005";
    public static final String DAY_IN_TRAVELLERS_DATEOFBIRTH_ANDROID ="02";
    public static final String DAY_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID ="27";
    public static final String MONTH_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID ="January";
    public static final String YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID ="2020";
    public static final String DAY_IN_TRAVELLERS_DATEOFBIRTH_IOS ="27";
    public static final String MONTH_IN_TRAVELLERS_DATEOFBIRTH_IOS ="January";
    public static final String YEAR_IN_TRAVELLERS_DATEOFBIRTH_IOS ="1993";
    public static final String DAY_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS ="27";
    public static final String MONTH_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS ="January";
    public static final String YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS ="2020";
    public static final String PASSPORT_EXPIRY_CALENDAR ="passportExpiryDate";
    public static final String DATEOFBIRTH_CALENDAR ="dateOfBirth";
    public static final String CHECK_IN_FOR_IOS = "Mar 2019";
    public static final String CHECK_IN_FOR_ANDROID = "MAR 2019";
    public static final String SECOND_CHECK_IN_FOR_IOS = "Mar 2019";
    public static final String SECOND_CHECK_IN_FOR_ANDROID = "MAR 2019";
    public static final String DEPARTURE_MONTH_IN_CALENDAR_VIEW = "Mar";
    public static final String JOURNEY_YEAR = "2019";
    public static final String CURRENT_RUNNING_MONTH_FOR_ANDROID ="OCT 2018";
    public static final String CURRENT_RUNNING_MONTH_FOR_IOS ="Oct 2018";
    public static final String CHECK_OUT_FOR_IOS = "Mar 2019";
    public static final String CHECK_OUT_FOR_ANDROID = "MAR 2019";
    public static final String SECOND_CHECK_OUT_FOR_IOS = "Mar 2019";
    public static final String SECOND_CHECK_OUT_FOR_ANDROID = "MAR 2019";
    public static final String TRAVELLERS_PASSPORT_NUMBER="ASDFGHJKLZXCV";
    public static final String KNET_PAYMENT_CARD_NUMBER="0000000001";
    public static final String KNET_PAYMENT_CARD_PIN_NUMBER="1234";
    public static final String ONE_CHARACTER_SPACE = " ";
    public static final String CONTACT_INFO_COUNTRY_NAME_IOS = "+91  India";
    public static final int SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_80_PERCENT=1800;
    public static String SELECTED_HOTEL_BOOKING_COST_IN_SRP;
    public static String BOOKING_HOTEL_COST_DISPLAYING_IN_SELECT_ROOM_SCREEN;
    public static String BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN;
    public static String BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN;
    public static String DEVICENAME;
    public static Integer CALENDAR_SWIPE_DURATION = 400;
    public static String CONFIGURATION_TYPE;
    public static final String LIVE_CONFIGURATION_TYPE = "LiveRun";
    public static final String STAGE_CONFIGURATION_TYPE = "Stage";
    public static final String MINUS_WITH_IN_BRACKETS = "(-) ";
    public static final String PLUS_WITH_IN_BRACKETS = "(+) ";


    ///////////////// Parsing strings in the classes of tests folder//////////////
    public static String TO_INTERNATIONAL_AIRPORT_NAME;
    public static String TO_INTERNATIONAL_AIRPORT_CODE;
    public static String FROM_INTERNATIONAL_AIRPORT_NAME;
    public static String FROM_INTERNATIONAL_AIRPORT_CODE;
    public static String TO_DOMESTIC_AIRPORT_NAME;
    public static String TO_DOMESTIC_AIRPORT_CODE;
    public static String FROM_DOMESTIC_AIRPORT_NAME;
    public static String FROM_DOMESTIC_AIRPORT_CODE;
    public static String INDIA_LANGUAGE_COUNTRY_LABEL ;
    public static String LANGUAGE_COUNTRY_LABEL ;
    public static String CHECK_IN_MONTH ;
    public static String CHECK_OUT_MONTH ;
    public static String SECOND_CHECK_IN_MONTH ;
    public static String SECOND_CHECK_OUT_MONTH ;
    public static String CURRENT_RUNNING_MONTH;
    public static String FLIGHT_BOOKING_TYPE;

    ///////////////// Kuwait Country Labels_Hotels /////////////////
    public static  String LANGUAGE_COUNTRY_LABEL_FOR_IOS;
    public static  String LANGUAGE_COUNTRY_LABEL_FOR_ANDROID;
    public static  String CURRENT_USER_CURRENCY_TYPE;
    public static String INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS;
    public static String INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID;
    public static String INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID;
    public static String INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS;
    public static String INTERNATIONAL_TO_AIRPORT_CODE;
    public static String INTERNATIONAL_FROM_AIRPORT_CODE;
    public static final String INTERNATIONAL_FLIGHT_BOOKING = "International";
    public static final String UAE_CURRENCY_TYPE = "AED";
    public static final String SAUDI_ARABIA_CURRENCY_TYPE = "SAR";
    public static final String EGYPT_CURRENCY_TYPE = "EGP";

    ///////////////// Country Labels_Hotels /////////////////

    public static final String INDIA_LANGUAGE_COUNTRY_LABEL_FOR_IOS = "INDIA";
    public static final String INDIA_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "India";
    public static String DOMESTIC_FROM_AIRPORT_NAME_FOR_IOS;
    public static String DOMESTIC_FROM_AIRPORT_NAME_FOR_ANDROID;
    public static String DOMESTIC_TO_AIRPORT_NAME_FOR_ANDROID;
    public static String DOMESTIC_TO_AIRPORT_NAME_FOR_IOS;
    public static String DOMESTIC_FROM_AIRPORT_CODE;
    public static String DOMESTIC_TO_AIRPORT_CODE;
    public static final String DOMESTIC_FLIGHT_BOOKING = "Domestic";
    public static final String OTHERS_COUNTRY_LABEL = "OTHERS";
    public static final String ENGLISH_LANGUAGE = "English";
    public static final String ARABIC_LANGUAGE = "Arabic";




    ///////////////// User login credentials /////////////////

    public static String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String FIRST_NAME = "Suresh";
    public static final String LAST_NAME = "Reddy";
    public static String EMAIL_ID_SIGN_UP = "rehlatAutomationPort0TestingEmail103@gmail.com";
    public static String EMAIL_ID_SIGN_IN = "rehlatAutomationTestEmail1@gmail.com";  // Always add the two digit email number so that on every test script a new email id is generated for to test sign up
    public static String PASSWORD = "testPasswordFromLabels";
    public static String REPEAT_PASSWORD = "testPasswordFromLabels";
    public static final String REFERRAL_CODE = "chaitu";
    public static final String NEW_REFERRAL_CODE = "rehHYD";
    public static String PHONE_NUMBER = "8050510545";
//    public static final String COUPON_CODE = "bijjam"; // Both for international and national flights searching should be the same
    public static String COUPON_CODE = "save15"; // Both for international and national flights searching should be the same
    public static final String[] ONLINE_CHECKIN_AIRLINES_LIST = {"AIR CHINA", "ALL NIPPON AIRWAYS", "TAP PORTUGAL","CHINA SOUTHERN AIRLINES", "PRECISION AIR", "AIR BALTIC", "LAM MOZAMBIQUE", "BRUSSELS AIRLINES", "AZUL LINHAS AEREAS", "BRASILEIRAS", "CROATIA AIRLINES", "VIRGIN AUSTRALIA INTL", "VIETNAM AIRLINES", "VIRGIN ATLANTIC", "RWANDAIR EXPRESS", "AIR SEYCHELLES", "QANTAS AIRWAYS", "NESMA AIRLINES", "SAUDI GULF AIRLINES", "ROYAL JORDANIAN", "QATAR AIRWAYS", "EMIRATES", "JAZEERA AIRWAYS", "GULF AIR", "TURKISH AIRLINES", "SAUDI ARABIAN AIRLINES", "EGYPTAIR", "JET AIRWAYS", "FLYNAS", "OMAN AIR", "KUWAIT AIRWAYS", "FLY DUBAI", "AIR INDIA", "ETIHAD AIRWAYS", "SRILANKAN AIRLINES"};

    ///////////////// CREDIT OR DEBIT CARD PAYMENT GATEWAY DETAILS /////////////////
    public static final String CREDIT_OR_DEBIT_CARD_NUMBER = "4543474002249996";
    public static final String CREDIT_OR_DEBIT_CARD_EXPIRY_MONTH_AND_YEAR_AND_CVV_NUMBER = "0625956";
    public static final String CREDIT_OR_DEBIT_CARD_CVV_NUMBER = "956";
    public static final String CREDIT_OR_DEBIT_CARD_HOLDER_NAME = "REHLATAUTOMATION";
    public static final String PASSWORD_OF_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT = "Checkout1!";


    ///////////////// Android Keycodes /////////////////
    public enum SwipeDirection {
        DIRECTION_UP,
        DIRECTION_DOWN,
        DIRECTION_LEFT,
        DIRECTION_RIGHT
    }

    /**
     * Setting the country language and airport from and to names
     */
    public static void setCountryLanguageAndAirportFromAndToLabels(String parsingDomainName) {
        Logger.logAction("Setting the country language and airport from and to names w.r.t. the domain");
        // This check will finalize the airport name and airport code based on its platform. This is implemented because Android and iOS flight search results are differently coded
        Labels_Hotels.setTheLabelsForDomain(parsingDomainName);
        if (Labels_Hotels.platform.equals(IOS)){
            ////////////////// INTERNATIONAL AIRPORTS NAMES ////////////////////
            Labels_Hotels.FROM_INTERNATIONAL_AIRPORT_NAME = INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS;
            Labels_Hotels.FROM_INTERNATIONAL_AIRPORT_CODE = INTERNATIONAL_FROM_AIRPORT_CODE;
            TO_INTERNATIONAL_AIRPORT_NAME = INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS;
            TO_INTERNATIONAL_AIRPORT_CODE = INTERNATIONAL_TO_AIRPORT_CODE;
            LANGUAGE_COUNTRY_LABEL = LANGUAGE_COUNTRY_LABEL_FOR_IOS;

            ///////////////// DOMESTIC AIRPORTS NAMES /////////////////////////
            FROM_DOMESTIC_AIRPORT_NAME = DOMESTIC_FROM_AIRPORT_NAME_FOR_IOS;
            FROM_DOMESTIC_AIRPORT_CODE = DOMESTIC_FROM_AIRPORT_CODE;
            TO_DOMESTIC_AIRPORT_NAME = DOMESTIC_TO_AIRPORT_NAME_FOR_IOS;
            TO_DOMESTIC_AIRPORT_CODE = DOMESTIC_TO_AIRPORT_CODE;
            INDIA_LANGUAGE_COUNTRY_LABEL = LANGUAGE_COUNTRY_LABEL_FOR_IOS;

            ////////////////////////// DEPARTURE & RETURN MONTHS FOR BOTH INTERNATIONAL AND DOMESTIC AIRPORTS ///////////////////////
            CHECK_IN_MONTH = CHECK_IN_FOR_IOS;
            CHECK_OUT_MONTH = CHECK_OUT_FOR_IOS;
            SECOND_CHECK_IN_MONTH = SECOND_CHECK_IN_FOR_IOS;
            SECOND_CHECK_OUT_MONTH = SECOND_CHECK_OUT_FOR_IOS;
            CURRENT_RUNNING_MONTH = CURRENT_RUNNING_MONTH_FOR_IOS;
            Integer randomDate = Base.getTheRandomValue(15);
            if (randomDate==0){
                randomDate = 1;
            }
            BaseTest.CHECK_IN_DAY = String.valueOf(randomDate);
            BaseTest.CHECK_OUT_DAY = String.valueOf(randomDate+1);

        }else if (platform.equals(ANDROID)){
            ////////////////// INTERNATIONAL AIRPORTS NAMES ////////////////////
            FROM_INTERNATIONAL_AIRPORT_NAME = INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID;
            FROM_INTERNATIONAL_AIRPORT_CODE = INTERNATIONAL_FROM_AIRPORT_CODE;
            TO_INTERNATIONAL_AIRPORT_NAME = INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID;
            TO_INTERNATIONAL_AIRPORT_CODE = INTERNATIONAL_TO_AIRPORT_CODE;
            LANGUAGE_COUNTRY_LABEL = LANGUAGE_COUNTRY_LABEL_FOR_ANDROID;

            ///////////////// DOMESTIC AIRPORTS NAMES /////////////////////////
            FROM_DOMESTIC_AIRPORT_NAME = DOMESTIC_FROM_AIRPORT_NAME_FOR_ANDROID;
            FROM_DOMESTIC_AIRPORT_CODE = DOMESTIC_FROM_AIRPORT_CODE;
            TO_DOMESTIC_AIRPORT_NAME = DOMESTIC_TO_AIRPORT_NAME_FOR_ANDROID;
            TO_DOMESTIC_AIRPORT_CODE = DOMESTIC_TO_AIRPORT_CODE;
            INDIA_LANGUAGE_COUNTRY_LABEL = LANGUAGE_COUNTRY_LABEL_FOR_IOS;

            ////////////////////////// DEPARTURE & RETURN MONTH FOR BOTH INTERNATIONAL AND DOMESTIC AIRPORTS ///////////////////////
            CHECK_IN_MONTH = CHECK_IN_FOR_ANDROID;
            CHECK_OUT_MONTH = CHECK_OUT_FOR_ANDROID;
            SECOND_CHECK_IN_MONTH = SECOND_CHECK_OUT_FOR_ANDROID;
            SECOND_CHECK_OUT_MONTH = SECOND_CHECK_OUT_FOR_ANDROID;
            CURRENT_RUNNING_MONTH = CURRENT_RUNNING_MONTH_FOR_ANDROID;
            Integer randomDate = Base.getTheRandomValue(10);
            if (randomDate==0){
                randomDate = 1;
            }
            BaseTest.CHECK_IN_DAY = String.valueOf(randomDate);
            BaseTest.CHECK_OUT_DAY = String.valueOf(randomDate+1);

        }
        ////////////////////////// FLIGHT BOOKING TYPE ///////////////////////
        // This Label should changed based on the flight booking type the test scripts needs to be run
        FLIGHT_BOOKING_TYPE = DOMESTIC_FLIGHT_BOOKING; // This one is act as default flight booking type..In every @Test will declare the flight booking type, else it will consider this default flight type
    }

    /**
     * Set the labels for the parsing domain
     * @param parsingDomain
     */
    public static void setTheLabelsForDomain(String parsingDomain){
        Logger.logAction("Setting the labels for domain :- "+parsingDomain);
        try {
            switch (parsingDomain){
                case "KWI":
                {
                    LANGUAGE_COUNTRY_LABEL_FOR_IOS = "KUWAIT";
                    LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "Kuwait";
                    CURRENT_USER_CURRENCY_TYPE = "KWD";
//                    CURRENT_USER_COUNTRY_NAME = "KUWAIT";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_IOS = "Jeddah";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_ANDROID = "Jeddah";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_ANDROID = "Riyadh";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_IOS = "Riyadh";
                    EMAIL_ID_SIGN_IN = "ComEmail@gmail.com";
                    PASSWORD = "rehlat@123";
                    REPEAT_PASSWORD= "rehlat@123";
                    break;
                }
                case "SA":
                {
                    LANGUAGE_COUNTRY_LABEL_FOR_IOS = "SAUDI ARABIA";
                    LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "Saudi Arabia";
//                    CURRENT_USER_COUNTRY_NAME = "SAR";
                    CURRENT_USER_CURRENCY_TYPE = "SAR";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_IOS = "Jeddah";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_ANDROID = "Jeddah";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_ANDROID = "Riyadh";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_IOS = "Riyadh";
                    EMAIL_ID_SIGN_IN = "SaEmail@gmail.com";
                    PASSWORD = "rehlat@123";
                    REPEAT_PASSWORD= "rehlat@123";
                    break;
                }
                case "UAE":
                {
                    LANGUAGE_COUNTRY_LABEL_FOR_IOS = "UAE";
                    LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "UAE";
//                    CURRENT_USER_COUNTRY_NAME = "UAE";
                    CURRENT_USER_CURRENCY_TYPE = "AED";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_IOS = "Jeddah";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_ANDROID = "Jeddah";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_ANDROID = "Riyadh";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_IOS = "Riyadh";
                    EMAIL_ID_SIGN_IN = "UaeEmail@gmail.com";
                    PASSWORD = "rehlat@123";
                    REPEAT_PASSWORD= "rehlat@123";
                    break;
                }
                case "EG":
                {
                    LANGUAGE_COUNTRY_LABEL_FOR_IOS = "EGYPT";
                    LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "Egypt";
//                    CURRENT_USER_COUNTRY_NAME = "EGP";
                    CURRENT_USER_CURRENCY_TYPE = "EGP";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_IOS = "Jeddah";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_ANDROID = "Jeddah";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_ANDROID = "Riyadh";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_IOS = "Riyadh";
                    EMAIL_ID_SIGN_IN = "EgEmail@gmail.com";
                    PASSWORD = "rehlat@123";
                    REPEAT_PASSWORD= "rehlat@123";
                    break;
                }
                default:
                {
                    LANGUAGE_COUNTRY_LABEL_FOR_IOS = "SAUDI ARABIA";
                    LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "Saudi Arabia";
//                    CURRENT_USER_COUNTRY_NAME = "EGP";
                    CURRENT_USER_CURRENCY_TYPE = "EGP";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_IOS = "Kuwait";
                    INTERNATIONAL_FROM_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_NAME_FOR_IOS = "Cairo";
                    INTERNATIONAL_TO_AIRPORT_CODE = "CAI";
                    INTERNATIONAL_FROM_AIRPORT_CODE = "KWI";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_IOS = "Jeddah";
                    DOMESTIC_FROM_AIRPORT_NAME_FOR_ANDROID = "Jeddah";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_ANDROID = "Riyadh";
                    DOMESTIC_TO_AIRPORT_NAME_FOR_IOS = "Riyadh";
                    EMAIL_ID_SIGN_IN = "ComEmail@gmail.com";
                    PASSWORD = "rehlat@123";
                    REPEAT_PASSWORD= "rehlat@123";
                    break;
                }
            }

        }catch (Exception exception){
            Logger.logError("Encountered exception :- Unable to set the labels fpr domain :- "+parsingDomain);
        }
    }

    /**
     * Get the UDID of device w.r.t. device name
     */
    public static String getTheIosDeviceUDIDWrtTheDeviceName(String parsingDeviceName) throws Exception{
        Logger.logAction("Getting the new email number w.r.t. the port number");
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader(Labels_Hotels.PATH_OF_iOS_DEVICES_LIST_WRT_DEVICE_NAMES_JSON_FILE);
            JSONArray arrayNumber = (JSONArray) jsonParser.parse(fileReader);
            JSONObject object = (JSONObject) arrayNumber.get(0);
            String deviceUDID = (String) object.get(parsingDeviceName);
            return deviceUDID;
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error:- Unable to get the device UDID of :- "+parsingDeviceName);
        }
        return null;
    }

    /**
     * Get the deviceOS of device w.r.t. device name
     */
    public static String getTheAndroidDeviceOS(String parsingDeviceName) throws Exception{
        Logger.logAction("Getting the new email number w.r.t. the port number");
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader(Labels_Hotels.PATH_OF_ANDROID_DEVICES_LIST_WRT_DEVICE_NAMES_JSON_FILE);
            JSONArray arrayNumber = (JSONArray) jsonParser.parse(fileReader);
            JSONObject object = (JSONObject) arrayNumber.get(0);
            String deviceOS = (String) object.get(parsingDeviceName);
            return deviceOS;
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error:- Unable to get the device OS of :- "+parsingDeviceName);
        }
        return null;
    }

}
