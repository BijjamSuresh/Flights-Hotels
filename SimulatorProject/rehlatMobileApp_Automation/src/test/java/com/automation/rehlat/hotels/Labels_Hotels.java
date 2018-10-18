package com.automation.rehlat.hotels;

public class Labels_Hotels extends Base {
    //////// APPIUM Capabilities /////////////////////
    public static final String APPIUM_PORT_NUMBER_DEFAULT = "4723";
    public static final String DEVICE_TYPE_DEFAULT = "phone";


    //////  Multiple Run Capabilities//////////
    //Todo:- Most Important strings while running multiple runs..,Please be careful on editing the below strings..,!!!!
    ////////iOS ///////////
    ///Device One///
//        public static final String DEVICE_UDID="1e5b8dcad350fb249a73d8dc106efbd9ccea136c"; // iPhone 7 Plus
        public static final String WDA_LOCAL_PORT_DEFAULT= "8001"; // For each device one unique port number

    ///Device Two ///
//        public static final String DEVICE_UDID="85108b5bd6265ecc9c4f58a8ad1cdbe1798e21ac"; // iPhone 6
//    public static final String WDA_LOCAL_PORT_DEFAULT= "8005"; // This helps to run the parallel runs

    ///Device Three ///
//        public static final String DEVICE_UDID="2EFDD063-1B62-4986-AB49-FCAE6FB55F34"; // iPhone 7Plus simulator
//        public static final String WDA_LOCAL_PORT_DEFAULT= "8005"; // This helps to run the parallel runs

    //Device Four
//        public static final String DEVICE_UDID="6B107201-2AD7-4BC1-A0E3-19BD0D10B0E9"; // iPhone6 simulator C9A70795-2CB0-471D-8111-07D424B8EFC9

    // Device Five
//        public static final String DEVICE_UDID="67CD49A3-498F-444C-A6AC-F03A968FDA03"; // iPhone5s simulator C9A70795-2CB0-471D-8111-07D424B8EFC9

    // Device Six
//    public static final String DEVICE_UDID="f81b107b5be78e09b76bdc2540ec9a7dbfbe2319"; // iPhone5

    //Device Seven
    public static final String DEVICE_UDID="45692414-3101-468A-9971-B2CEAAC6BF85"; // iPhoneX

    //Device Eight
//    public static final String DEVICE_UDID="DB94E19B-A74A-4484-B7A2-3FEC43C0CC2D"; // iPhoneXS Max



    ////////Android ///////////
    ///Device One///
//        public static final String APPIUM_DEVICE_ID_DEFAULT = "84254a373730374d";  //Samsung Device Id
//        public static final String WDA_LOCAL_PORT_DEFAULT= "8010"; // This helps to run the parallel runs

    ///Device Two ///
    public static final String APPIUM_DEVICE_ID_DEFAULT = "emulator-5554"; // Nexus Emulator id
//    public static final String APPIUM_DEVICE_ID_DEFAULT = "emulator-5556"; // Pixel Emulator id
//
//    public static final String APPIUM_DEVICE_ID_DEFAULT = "BH901M4F4C"; // Sony device id
//        public static final String WDA_LOCAL_PORT_DEFAULT= "8015"; // This helps to run the parallel runs
//            public static final String WDA_LOCAL_PORT_DEFAULT= "192.168.3.111:5555"; // This helps to run the scripts over wifi [WDA Port number == Android device IP address : tcpip address (Used in the terminal to connect the device and PC in same network)]

    ////////Common ///////////
    // Port 1 and Port 2 email id's are used while running multiple scripts where as on single run we use port one as default
    public static String EMAIL_ID_SIGN_UP_PORT_1 = "rehlatAutomationSimu1TestingEmail210@gmail.com"; // This is for port one connected device [Either iOS or Android]
    public static String EMAIL_ID_SIGN_UP_PORT_2 = "rehlatAutomationSimu2TestingEmail180@gmail.com"; // This is for port two connected device [Either iOS or Android]


    ////////////////////  Types of devices ////////////////////
    public static final String IOS="iOS";
    public static final String ANDROID="Android";
    public static final String DEFAULT_PLATFORM = "Android"; // Need to change the default type every time w.r.t. the testing device platform
//    public static final String DEFAULT_PLATFORM = "iOS";

    //////  APPIUM  iOS app capabilities//////////
    public static final String IOS_BUNDLE_ID="com.Rehlat.RehlatMobile";
//    public static final String appPath = BaseTest.getTheSimulatorAppPath(DEVICE_UDID);
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


    //    public static final String ANDROID_CAPABILITIES_DEVICE_NAME = "Sony";
//    public static final String ANDROID_CAPABILITIES_DEVICE_NAME = "SamsungGalaxy8";
        public static final String ANDROID_CAPABILITIES_DEVICE_NAME = "Pixel_2_API_24"; //Pixel emulator
//    public static final String ANDROID_CAPABILITIES_DEVICE_NAME = "Nexus_6_API_25"; // Nexus emulator
//        public static final String ANDROID_CAPABILITIES_PLATFORM_VERSION = "7.0"; // Pixel emulator version
//    public static final String ANDROID_CAPABILITIES_PLATFORM_VERSION = "6.0.1"; // Sony version
    public static final String ANDROID_CAPABILITIES_PLATFORM_VERSION = "7.1.1"; // Nexus emulator version
    public static final String ANDROID_CAPABILITIES_APPIUM_VERSION = "1.8.1";
    public static final String APPIUM_PORT_NUMBER = System.getProperty("port", APPIUM_PORT_NUMBER_DEFAULT);
    protected static final String ANDROID_CAPABILITIES_DEVICE_ID = System.getProperty("deviceId", APPIUM_DEVICE_ID_DEFAULT);
    public static final String ANDROID_CAPABILITIES_URL = "http://localhost:" + APPIUM_PORT_NUMBER + "/wd/hub";
    public static final String ANDROID_CAPABILITIES_PACKAGE_NAME = "com.app.rehlat";
    public static final String ANDROID_CAPABILITIES_PLATFORM_NAME = "Android";
//    public static final String ANDROID_CAPABILITIES_APP_PATH = "../app_debug.apk";
    public static final String ANDROID_CAPABILITIES_APP_PATH = "../app_release.apk";
    protected static final String ANDROID_NAVIGATION_BAR_PARTY_VIEW = ANDROID_CAPABILITIES_PACKAGE_NAME + ":id/toolbar_party_view";
    public static final String ANDROID_NAVIGATION_BAR = ANDROID_CAPABILITIES_PACKAGE_NAME + ":id/toolbar";
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
    public static final String PATH_ENVIRONMENT_DETAIL = SOURCE_FOLDER_PATH+"/src/test/java/com/automation/sabre/libCommon/Environment.json";

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
    public static final String WDA_LOCAL_PORT = System.getProperty("wda",WDA_LOCAL_PORT_DEFAULT );
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
    public static final String CHECK_IN_FOR_IOS = "Jan 2019";
    public static final String CHECK_IN_FOR_ANDROID = "JAN 2019";
    public static final String SECOND_CHECK_IN_FOR_IOS = "Mar 2019";
    public static final String SECOND_CHECK_IN_FOR_ANDROID = "MAR 2019";
    public static final String DEPARTURE_MONTH_IN_CALENDAR_VIEW = "Jan";
    public static final String JOURNEY_YEAR = "2019";
    public static final String CURRENT_RUNNING_MONTH_FOR_ANDROID ="OCT 2018";
    public static final String CURRENT_RUNNING_MONTH_FOR_IOS ="Oct 2018";
    public static final String CHECK_OUT_FOR_IOS = "Jan 2019";
    public static final String CHECK_OUT_FOR_ANDROID = "JAN 2019";
    public static final String SECOND_CHECK_OUT_FOR_IOS = "Mar 2019";
    public static final String SECOND_CHECK_OUT_FOR_ANDROID = "MAR 2019";
    public static final String TRAVELLERS_PASSPORT_NUMBER="ASDFGHJKLZXCV";
    public static final String KNET_PAYMENT_CARD_NUMBER="0000000001";
    public static final String KNET_PAYMENT_CARD_PIN_NUMBER="1234";
    public static final String ONE_CHARACTER_SPACE = " ";
    public static final String CONTACT_INFO_COUNTRY_NAME_IOS = "+91  India";
    public static final String CONTACT_INFO_COUNTRY_CODE = "+91";
    public static final int SCREEN_X_AXIS_SIZE_OF_RANGE_OF_20_PERCENT =481;
    public static final int SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT=1443;
    public static String SELECTED_HOTEL_BOOKING_COST_IN_SRP;
    public static String BOOKING_HOTEL_COST_DISPLAYING_IN_SELECT_ROOM_SCREEN;
    public static String BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN;
    public static String BOOKING_HOTEL_COST_DISPLAYING_IN_BOOKING_SUMMARY_SCREEN;
    public static String DEVICENAME;
    public static Integer CALENDAR_SWIPE_DURATION = 400;


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
    public static String KUWAIT_LANGUAGE_COUNTRY_LABEL ;
    public static String CHECK_IN_MONTH ;
    public static String CHECK_OUT_MONTH ;
    public static String SECOND_CHECK_IN_MONTH ;
    public static String SECOND_CHECK_OUT_MONTH ;
    public static String CURRENT_RUNNING_MONTH;
    public static String FLIGHT_BOOKING_TYPE;

    ///////////////// Kuwait Country Labels_Hotels /////////////////
//    public static final String KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_IOS = "KUWAIT";
//    public static final String KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "Kuwait";
    public static final String KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_IOS = "SAUDI ARABIA";
    public static final String KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "Saudi Arabia";
//    public static final String CURRENT_USER_CURRENCY_TYPE = "KWD";
//    public static final String CURRENT_USER_COUNTRY_NAME = "KUWAIT";
    public static final String CURRENT_USER_COUNTRY_NAME = "SAR";
    public static final String CURRENT_USER_CURRENCY_TYPE = "SAR";
//    public static final String CURRENT_USER_COUNTRY_NAME = "UAE";
//    public static final String CURRENT_USER_CURRENCY_TYPE = "AED";
//    public static final String KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_IOS = "KUWAIT";
//    public static final String KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "Kuwait";
    public static final String KUWAIT_AIRPORT_NAME_FOR_IOS = "Kuwait";
    public static final String KUWAIT_AIRPORT_NAME_FOR_ANDROID = "Kuwait";
    public static final String CAIRO_AIRPORT_NAME_FOR_ANDROID = "Cairo";
    public static final String CAIRO_AIRPORT_NAME_FOR_IOS = "Cairo";
    public static final String CAIRO_AIRPORT_CODE = "CAI";
    public static final String KUWAIT_AIRPORT_CODE = "KWI";
    public static final String INTERNATIONAL_FLIGHT_BOOKING = "International";
    public static final String UAE_CURRENCY_TYPE = "AED";
    public static final String SAUDI_ARABIA_CURRENCY_TYPE = "SAR";
    public static final String EGYPT_CURRENCY_TYPE = "AED";

    ///////////////// Country Labels_Hotels /////////////////

    public static final String INDIA_LANGUAGE_COUNTRY_LABEL_FOR_IOS = "INDIA";
    public static final String INDIA_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID = "India";
//    public static final String HYDERABAD_AIRPORT_NAME_FOR_IOS = "Hyderabad";
//    public static final String HYDERABAD_AIRPORT_NAME_FOR_ANDROID = "Hyderabad";
//    public static final String BANGALORE_AIRPORT_NAME_FOR_ANDROID = "Bangalore";
//    public static final String BANGALORE_AIRPORT_NAME_FOR_IOS = "Bangalore";
    public static final String JEDDAH_AIRPORT_NAME_FOR_IOS = "Jeddah";
    public static final String JEDDAH_AIRPORT_NAME_FOR_ANDROID = "Jeddah";
    public static final String RIYADH_AIRPORT_NAME_FOR_ANDROID = "Riyadh";
    public static final String RIYADH_AIRPORT_NAME_FOR_IOS = "Riyadh";
//    public static final String HYDERABAD_AIRPORT_CODE = "HYD";
//    public static final String BANGALORE_AIRPORT_CODE = "BLR";
    public static final String JEDDAH_AIRPORT_CODE = "JED";
    public static final String RIYADH_AIRPORT_CODE = "RUH";
    public static final String DOMESTIC_FLIGHT_BOOKING = "Domestic";
    public static final String OTHERS_COUNTRY_LABEL = "OTHERS";
    public static final String ENGLISH_LANGUAGE = "English";
    public static final String ARABIC_LANGUAGE = "Arabic";




    ///////////////// User login credentials /////////////////

    public static String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String FIRST_NAME = "Suresh";
    public static final String LAST_NAME = "Reddy";
    public static String EMAIL_ID_SIGN_UP = "rehlatAutomationPort0TestingEmail103@gmail.com";
    public static final String EMAIL_ID_SIGN_IN = "rehlatAutomationTestEmail1@gmail.com";  // Always add the two digit email number so that on every test script a new email id is generated for to test sign up
    public static final String PASSWORD = "testPasswordFromLabels";
    public static final String REPEAT_PASSWORD="testPasswordFromLabels";
    public static final String REFERRAL_CODE = "chaitu";
    public static final String NEW_REFERRAL_CODE = "rehHYD";
    public static String phoneNumber = "8050510545";
//    public static final String COUPON_CODE = "bijjam"; // Both for international and national flights searching should be the same
    public static final String COUPON_CODE = "save15"; // Both for international and national flights searching should be the same

    public static final String IOS_APPLIED_KARAM_POINTS = "1";
    public static final String[] ONLINE_CHECKIN_AIRLINES_LIST = {"AIR CHINA", "ALL NIPPON AIRWAYS", "TAP PORTUGAL","CHINA SOUTHERN AIRLINES", "PRECISION AIR", "AIR BALTIC", "LAM MOZAMBIQUE", "BRUSSELS AIRLINES", "AZUL LINHAS AEREAS", "BRASILEIRAS", "CROATIA AIRLINES", "VIRGIN AUSTRALIA INTL", "VIETNAM AIRLINES", "VIRGIN ATLANTIC", "RWANDAIR EXPRESS", "AIR SEYCHELLES", "QANTAS AIRWAYS", "NESMA AIRLINES", "SAUDI GULF AIRLINES", "ROYAL JORDANIAN", "QATAR AIRWAYS", "EMIRATES", "JAZEERA AIRWAYS", "GULF AIR", "TURKISH AIRLINES", "SAUDI ARABIAN AIRLINES", "EGYPTAIR", "JET AIRWAYS", "FLYNAS", "OMAN AIR", "KUWAIT AIRWAYS", "FLY DUBAI", "AIR INDIA", "ETIHAD AIRWAYS", "SRILANKAN AIRLINES"};


//    public static String appVersion="3.9.7";
//    public static String buildNumber="100";
//    public static String resetPasswordEmailId;
//    public static String invalidEmailId;
//    public static String firstName;
//    public static String lastName;

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
    public static void setCountryLanguageAndAirportFromAndToLabels() {
        // This check will finalize the airport name and airport code based on its platform. This is implemented because Android and iOS flight search results are differently coded
        if (Labels_Hotels.platform.equals(IOS)){
            ////////////////// INTERNATIONAL AIRPORTS NAMES ////////////////////
            Labels_Hotels.FROM_INTERNATIONAL_AIRPORT_NAME = KUWAIT_AIRPORT_NAME_FOR_IOS;
            Labels_Hotels.FROM_INTERNATIONAL_AIRPORT_CODE = KUWAIT_AIRPORT_CODE;
            TO_INTERNATIONAL_AIRPORT_NAME = CAIRO_AIRPORT_NAME_FOR_IOS;
            TO_INTERNATIONAL_AIRPORT_CODE = CAIRO_AIRPORT_CODE;
            KUWAIT_LANGUAGE_COUNTRY_LABEL = KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_IOS;

            ///////////////// DOMESTIC AIRPORTS NAMES /////////////////////////
//            FROM_DOMESTIC_AIRPORT_NAME = HYDERABAD_AIRPORT_NAME_FOR_IOS;
//            FROM_DOMESTIC_AIRPORT_CODE = HYDERABAD_AIRPORT_CODE;
//            TO_DOMESTIC_AIRPORT_NAME = BANGALORE_AIRPORT_NAME_FOR_IOS;
//            TO_DOMESTIC_AIRPORT_CODE = BANGALORE_AIRPORT_CODE;
            FROM_DOMESTIC_AIRPORT_NAME = JEDDAH_AIRPORT_NAME_FOR_IOS;
            FROM_DOMESTIC_AIRPORT_CODE = JEDDAH_AIRPORT_CODE;
            TO_DOMESTIC_AIRPORT_NAME = RIYADH_AIRPORT_NAME_FOR_IOS;
            TO_DOMESTIC_AIRPORT_CODE =  RIYADH_AIRPORT_CODE;
            INDIA_LANGUAGE_COUNTRY_LABEL = INDIA_LANGUAGE_COUNTRY_LABEL_FOR_IOS;

            ////////////////////////// DEPARTURE & RETURN MONTHS FOR BOTH INTERNATIONAL AND DOMESTIC AIRPORTS ///////////////////////
            CHECK_IN_MONTH = CHECK_IN_FOR_IOS;
            CHECK_OUT_MONTH = CHECK_OUT_FOR_IOS;
            SECOND_CHECK_IN_MONTH = SECOND_CHECK_IN_FOR_IOS;
            SECOND_CHECK_OUT_MONTH = SECOND_CHECK_OUT_FOR_IOS;
            CURRENT_RUNNING_MONTH = CURRENT_RUNNING_MONTH_FOR_IOS;


        }else if (platform.equals(ANDROID)){
            ////////////////// INTERNATIONAL AIRPORTS NAMES ////////////////////
            FROM_INTERNATIONAL_AIRPORT_NAME = KUWAIT_AIRPORT_NAME_FOR_ANDROID;
            FROM_INTERNATIONAL_AIRPORT_CODE = KUWAIT_AIRPORT_CODE;
            TO_INTERNATIONAL_AIRPORT_NAME = CAIRO_AIRPORT_NAME_FOR_ANDROID;
            TO_INTERNATIONAL_AIRPORT_CODE = CAIRO_AIRPORT_CODE;
            KUWAIT_LANGUAGE_COUNTRY_LABEL = KUWAIT_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID;

            ///////////////// DOMESTIC AIRPORTS NAMES /////////////////////////
//            FROM_DOMESTIC_AIRPORT_NAME = HYDERABAD_AIRPORT_NAME_FOR_ANDROID;
//            FROM_DOMESTIC_AIRPORT_CODE = HYDERABAD_AIRPORT_CODE;
//            TO_DOMESTIC_AIRPORT_NAME = BANGALORE_AIRPORT_NAME_FOR_ANDROID;
//            TO_DOMESTIC_AIRPORT_CODE = BANGALORE_AIRPORT_CODE;
            FROM_DOMESTIC_AIRPORT_NAME = JEDDAH_AIRPORT_NAME_FOR_ANDROID;
            FROM_DOMESTIC_AIRPORT_CODE = JEDDAH_AIRPORT_CODE;
            TO_DOMESTIC_AIRPORT_NAME =  RIYADH_AIRPORT_NAME_FOR_ANDROID;
            TO_DOMESTIC_AIRPORT_CODE =  RIYADH_AIRPORT_CODE;
            INDIA_LANGUAGE_COUNTRY_LABEL = INDIA_LANGUAGE_COUNTRY_LABEL_FOR_ANDROID;

            ////////////////////////// DEPARTURE & RETURN MONTH FOR BOTH INTERNATIONAL AND DOMESTIC AIRPORTS ///////////////////////
            CHECK_IN_MONTH = CHECK_IN_FOR_ANDROID;
            CHECK_OUT_MONTH = CHECK_OUT_FOR_ANDROID;
            SECOND_CHECK_IN_MONTH = SECOND_CHECK_OUT_FOR_ANDROID;
            SECOND_CHECK_OUT_MONTH = SECOND_CHECK_OUT_FOR_ANDROID;
            CURRENT_RUNNING_MONTH = CURRENT_RUNNING_MONTH_FOR_ANDROID;


        }
        ////////////////////////// FLIGHT BOOKING TYPE ///////////////////////
        // This Label should changed based on the flight booking type the test scripts needs to be run
//            Labels_Hotels.FLIGHT_BOOKING_TYPE = INTERNATIONAL_FLIGHT_BOOKING;
        FLIGHT_BOOKING_TYPE = DOMESTIC_FLIGHT_BOOKING; // This one is act as default flight booking type..In every @Test will declare the flight booking type, else it will consider this default flight type
    }

}
