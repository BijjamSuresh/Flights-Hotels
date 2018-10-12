package com.automation.rehlat.hotels.pages;

import com.automation.rehlat.hotels.Base;
import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.pages.bookingSummary.BookingSummaryBase;
import com.automation.rehlat.hotels.pages.guestTravellersDetails.GuestTravellersDetailsBase;
import com.automation.rehlat.hotels.pages.hotelProfile.HotelsProfileBase;
import com.automation.rehlat.hotels.pages.hotels.HotelsBase;
import com.automation.rehlat.hotels.pages.hotelsSearchResults.HotelsSearchResultsBase;
import com.automation.rehlat.hotels.pages.menu.MenuBase;
import com.automation.rehlat.hotels.pages.paymentsOptions.PaymentOptionsBase;
import com.automation.rehlat.hotels.pages.selectRooms.SelectRoomsBase;
import com.automation.rehlat.hotels.pages.signIn.SignInBase;
import com.automation.rehlat.hotels.pages.signUp.SignUpBase;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class BasePage extends Base {

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






    ////////////////////////////// IOS Strings Related To The Methods In Base Page //////////////////////////////////////
    public static final String IOS_DONE_BUTTON = "Done";
    public static final String IOS_DATE_PICKER = "XCUIElementTypeDatePicker";
    public static final String TOGGLE_SWITCH = "XCUIElementTypeSwitch";
    public static String TRIP_TYPE ;
    public static String SELECTED_AIRLINE_NAME_IN_SRP;
    public static boolean isUserSignedIn;
    public static final String SRP_ONE_WAY_VIEW = "Rehlat.SRPOneWayView";
    public static final String SRP_TWO_WAY_VIEW = "Rehlat.SRPRoundTripView";
    public static final String NO_BUTTON = "No";
    public static final String YES_BUTTON = "Yes";

    ////////////////////////////// Android Strings Related To The Methods In Base Page //////////////////////////////////////
    public static final String MODAL_VIEW = "com.app.rehlat:id/networkErrormsgTextview";
    public static final String SYNC_PREVIOUS_MODAL_VIEW_DATA = "Do you want to sync previous travellers data to your account?";
    public static final String DONT_SYNC_PREVIOUS_TRAVELLERS_DATA = "com.app.rehlat:id/noBtn";
    public static final String PRICE_ID_IN_FOOTER_VIEW_OF_HOTEL_PROFILE_PAGE = "com.app.rehlat:id/footer_total_fare_textview";



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                                         //Android Methods //

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Scroll the calender page upwards //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageUpByAMonthGap_Android() {
        Logger.logAction("Scrolling up action with more length is started");
        try {
            TouchAction action = new TouchAction(driver);
            action.longPress(459, 758).moveTo(459, 50).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the calender page downwards //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageDownAMonthGap_Android() {
        Logger.logAction("Scrolling down action with more length is started");
        try {
            TouchAction action = new TouchAction(driver);
            action.longPress(459, 831).moveTo(459, 1630).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the calender page upwards by days gap //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageUpByDaysGap_Android() {
        Logger.logAction("Scrolling up action with less length is started");
        try {
            Thread.sleep(2000);
            TouchAction action = new TouchAction(driver);
            action.longPress(500, 967).moveTo(500, 532).release().perform();
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }
    /**
     * Scroll the calender page downwards by days gap //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageDownByDaysGap_Android() {
        Logger.logAction("Scrolling down action with less length is started");
        try {
            TouchAction action = new TouchAction(driver);
            action.longPress(459, 732).moveTo(459, 967).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen up by a card gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenUpByACardGap_Android() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(512, 967).moveTo(512, 932).release().perform();
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen down by a card gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenDownByACardGap_Android() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(459, 932).moveTo(454, 967).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen down by three cards gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenDownByThreeCardsGap_Android() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(507, 663).moveTo(507, 709).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen up by three cards gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenUpByThreeCardsGap_Android() {
        try {
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            TouchAction action = new TouchAction(driver);
            action.press(507, 709).moveTo(507, 663).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Decline the sync previous travellers data modal view
     */
    public static void declineTheSyncPreviousTravellersDataModalView_Android() {
        Logger.logAction("Declining the sync previous travellers data modal view ");
        try{
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Hotels.ANDROID_ACTIVITY_INDICATOR,1);
            if (isElementEnabledById(MODAL_VIEW)){
//                driver.runAppInBackground(2);
                String modalViewName = driver.findElementById(MODAL_VIEW).getText();
                if (modalViewName.equals(SYNC_PREVIOUS_MODAL_VIEW_DATA)){
                    if (isElementDisplayedById(DONT_SYNC_PREVIOUS_TRAVELLERS_DATA)){
                        driver.findElementById(DONT_SYNC_PREVIOUS_TRAVELLERS_DATA).click();
                    }else {
                        Logger.logError(" - element id is not displayed in the current active screen");
                    }
                }else {
                    Logger.logError("Sync previous travellers data modal view is not displayed but another modal view is displayed");
                }
            }else {
                Logger.logComment("No modal view is displayed");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: unable to decline the sync travellers data modal view");
        }
    }

    /**
     * Wait till the progress indicator is invisible
     * @throws Exception
     */
    public static void waitTillTheProgressIndicatorIsInvisibleById_ANDROID( String parsingID, Integer iterationsCount) throws Exception{
        int count =1;
        while (count<=iterationsCount){
            try{
//                driver.runAppInBackground(1);
////                Thread.sleep(2000);
                if (isElementDisplayedById(parsingID) || isElementEnabledById(parsingID)){
                    Logger.logStep("Waiting till the activity indicator is invisible in the current active screen");
//                    Thread.sleep(2000);
                    driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(parsingID)));
                }else {
                    Logger.logStep("Activity indicator is not displayed in the current active screen");
                }
            }catch (Exception exception){
                Logger.logComment(count+" :- time trying to find the element name");
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            count++;
        }
    }

    /**
     * Scroll to an element by id // Scrolling the screen is based on screen size which are hard coded values
     * @param down
     */
    public static void scrollToAnElementById_ANDROID(String parsingId,boolean down){
        try {
            if(!isElementDisplayedByIdWithOneTimeChecking(parsingId)) {
                int counter = 0;
                if (down) {
                    while (!isElementDisplayedByIdWithOneTimeChecking(parsingId)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + parsingId +" - by scrolling down ");
                        scrollTheCalenderPageUpByAMonthGap_Android(); // scrolling values inside the method are hardcoded for all the screens
                        counter++;
                        if (counter > 8) {
                            break;
                        }
                    }
                    if (!isElementDisplayedByIdWithOneTimeChecking(parsingId)) {
                        while (!isElementDisplayedByIdWithOneTimeChecking(parsingId)) {
                            Logger.logComment(counter + "  time trying to find the calender month and year - " + parsingId +" - by scrolling up ");
                            scrollTheCalenderPageDownAMonthGap_Android(); // scrolling values inside the method are hardcoded for all the screens
                            counter++;
                            if (counter > 13) {
                                break;
                            }
                        }
                    }
                } else {
                    while (!isElementDisplayedByIdWithOneTimeChecking(parsingId)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + parsingId +" - by scrolling up ");
                        scrollTheCalenderPageDownAMonthGap_Android(); // scrolling values inside the method are hardcoded for all the screens
                        counter++;
                        if (counter > 8) {
                            break;
                        }
                    }
                    if (!isElementDisplayedByIdWithOneTimeChecking(parsingId)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + parsingId +" - by scrolling down ");
                        while (!isElementDisplayedById(parsingId)) {
                            scrollTheCalenderPageUpByAMonthGap_Android(); // scrolling values inside the method are hardcoded for all the screens
                            counter++;
                            if (counter > 13) {
                                break;
                            }
                        }
                    }
                }
                if(!isElementDisplayedByIdWithOneTimeChecking(parsingId)) {
                    Logger.logWarning(parsingId+" - element name is not displayed in the current active screen.., So moving to the next action");
                }else {
                    Logger.logComment(parsingId+ " - element is displayed");
                }
            }else {
                Logger.logComment(parsingId+ " - element is already displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name in the current active screen :- " +parsingId);
        }
    }

    /**
     * Close the keyboard for Android Platform
     */
    public static boolean closeTheKeyboard_Android() {
        Logger.logAction("Closing the Android Keyboard");
        int counter = 0;
        while (counter < 2) {
            try {
                driver.hideKeyboard();
                Logger.logComment("Tapped on done button in the Keyboard");
                return true;
            }catch(Exception exception){
                Logger.logStep(counter +" - time trying the keyboard is displayed in the current active screen");
                counter++;
            }
//            break;
        }
        Logger.logWarning("Encountered error: Unable to close the keyboard");
        return true;
    }

    /**
     * Get the booking price displayed in the footer view layout
     * @return
     */
    public static Double getTheBookingPriceDisplayedInFooterView(){
        Logger.logAction("Getting the booking price displayed in footer view");
        try{
            String hotelPriceInFooterViewWithCurrency = findElementByIdAndReturnText(PRICE_ID_IN_FOOTER_VIEW_OF_HOTEL_PROFILE_PAGE);
            String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
            return Double.parseDouble(hotelPriceWithoutCurrency);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking price displayed in footer view");
        }
        return null;
    }


//    /**
//     * Check the test running device is an samsung device and if it is pushing it to background for a second
//     * @throws Exception
//     */
//    public static void runAppInBackGroundIfTheCurrentRunningDeviceIsSamsungDevice() throws Exception{
//        Logger.logAction(" Checking the test running device is a samsung device");
//        try{
////        String deviceName = getAndroidDeviceId();
//        if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)){
//            Logger.logComment("Pushing the app to background");
//            driver.runAppInBackground(1);
//            Logger.logComment("Getting the app to foreground");
//        }else {
//            Logger.logStep("Current device is not an Android device with ID :- "+Labels_Hotels.SAMSUNG_DEVICE_ID);
//        }
//    }catch (Exception exception){
//            Logger.logError("Unable to run the app in background for a second");
//        }
//    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                            //iOS Methods //

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Disable toggle switch in iOS platform
     */
    public void disableToggleSwitch_iOS() {
        Logger.logAction("Disabling the toggle button");
        try {
            if (isElementDisplayedByClassName(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElementByClassName(TOGGLE_SWITCH);
                String toggleSwitchValue = toggleSwitch.getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                if (toggleSwitchValue.equals(Labels_Hotels.VALUE_ONE)){
                    Logger.logComment("Toggle switch is enabled and making it to disable by tapping on it");
                    driver.findElementByClassName(TOGGLE_SWITCH).click();
                    Logger.logComment("Toggle switched is disabled");
                }else if (toggleSwitchValue.equals(Labels_Hotels.VALUE_ZERO)){
                    Logger.logStep("Toggle switch is already disabled");
                }
            }
            else {
                Logger.logError("Toggle switch is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " + TOGGLE_SWITCH);
        }
    }

    /**
     * Enable the toggle switch in iOS platform
     */
    public void enableToggleSwitch_iOS() {
        Logger.logAction("Enabling the toggle button");
        try {
            if (isElementEnabledByClassName(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElementByClassName(TOGGLE_SWITCH);
                String toggleSwitchValue = toggleSwitch.getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                if (toggleSwitchValue.equals(Labels_Hotels.VALUE_ZERO)){
                    Logger.logStep("Toggle switch is disabled and making it to enable by tapping on it");
                    driver.findElementByClassName(TOGGLE_SWITCH).click();
                }else if (toggleSwitchValue.equals(Labels_Hotels.VALUE_ONE)){
                    Logger.logStep("Toggle switch is already enabled");
                }
            }else {
                Logger.logError("Toggle switch is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " +TOGGLE_SWITCH);
        }
    }

    /**
     * Close the keyboard for iOS Platform
     */
    public static void closeTheKeyboard_iOS() {
        try{
            if (isElementDisplayedByName(IOS_DONE_BUTTON)){
                driver.findElementByName(IOS_DONE_BUTTON).click();
                Logger.logComment("Tapped on done button in the Keyboard");
            }else{
                Logger.logStep("Keyboard is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to close the keyboard");
        }
    }

    /**
     * Close the date picker for iOS Platform
     */
    public static void closeTheDatePicker_iOS() {
        try{
            if (isElementDisplayedByClassName(IOS_DATE_PICKER)){
                driver.findElementByName(IOS_DONE_BUTTON).click();
                Logger.logComment("Tapped on done button in the date picker");
            }else{
                Logger.logStep("Date picker is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to close the date picker");
        }
    }

    /**
     * Wait till the progress indicator is invisible
     * @throws Exception
     */
    public static void waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(String parsingClassName, Integer iterationCounts) throws Exception{
        int count =1;
        while (count <= iterationCounts){
            try{
                if (isElementDisplayedByClassName(parsingClassName)){
                    Logger.logStep("Waiting till the activity indicator is invisible in the current active screen");
                    driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(parsingClassName)));
                }else {
                    Logger.logComment("Activity indicator is not displayed in the current active screen");
                }
            }catch (Exception exception){
                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                Logger.logComment(count+" :- time trying to find the element name");
            }
            count++;
        }
    }

    /**
     * Get the displayed ticket booking value
     * @return
     */
    public static Double getTheDisplayedTicketBookingValueInFooterView(String screeName, Integer footerViewCellNumber) {
        Logger.logAction("Getting the ticket cost displayed at footer view of the screen");
        String flightCellTypeText = null;
        WebElement bookingFlightCell;
        WebElement flightCellType;
        List<WebElement> flightCellDetails;
        String actualAmountPrice;
        try{
            int cellIndex;
            // The below if condition is because  footer view cell number is changed to "2" when user is signed in and is "3" when user is not signed in...To handle this logic implemented below if condition.
            if (screeName.equalsIgnoreCase("BookingPageScreen") && isUserSignedIn==true){
                footerViewCellNumber = footerViewCellNumber -1;
            }
            bookingFlightCell = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther["+footerViewCellNumber+"]");
            flightCellDetails = bookingFlightCell.findElements(By.className("XCUIElementTypeStaticText"));
            for (cellIndex=0;cellIndex<flightCellDetails.size();cellIndex++){
                flightCellType = flightCellDetails.get(cellIndex);
                flightCellTypeText = flightCellType.getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                if (flightCellTypeText.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE) && flightCellTypeText.contains(Labels_Hotels.DOT_STRING)){
                    actualAmountPrice = flightCellTypeText.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+ Labels_Hotels.ONE_CHARACTER_SPACE, Labels_Hotels.STRING_NULL).trim();
                    if (actualAmountPrice.contains(Labels_Hotels.STRING_COMMA)){
                        String actualAmountWithoutComma = actualAmountPrice.replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL);
                        actualAmountPrice = actualAmountWithoutComma;
                    }
                    Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
                    return Double.valueOf(actualAmountPrice);
                }else if(flightCellTypeText.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
                    actualAmountPrice = flightCellTypeText.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                    Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
                    return Double.valueOf(actualAmountPrice);
                }
//            else if(flightCellTypeText.contains("updating...") || flightCellTypeText.contains("updating.") || flightCellTypeText.contains("updating..")){
//                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
//                Logger.logStep("Booking flight cost is not displayed, price label is still loading");
//                bookingFlightCell = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]");
//                flightCellDetails = bookingFlightCell.findElements(By.className("XCUIElementTypeStaticText"));
//                for (cellIndex=0;cellIndex<flightCellDetails.size();cellIndex++) {
//                    flightCellType = flightCellDetails.get(cellIndex);
//                    flightCellTypeText = flightCellType.getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
//                    if (flightCellTypeText.contains(".")){
//                        Logger.logComment("Displayed booking cost is: " +flightCellTypeText);
//                        return flightCellTypeText;
//                    } else if(flightCellTypeText.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
//                        String actualAmountPrice = flightCellTypeText.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+Labels_Hotels.ONE_CHARACTER_SPACE, "").trim();
//                        Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
//                        return actualAmountPrice;
//                    }else{
//                        Logger.logError("Booking flight cost is not displayed in the current active screen");
//                    }
//                }
//            }
                else
                {
                    Logger.logComment(cellIndex+" time finding the booking flight cost");
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to get the displayed ticket booking value in footer view");
        }
        if (flightCellTypeText==null){
            Logger.logError("Booking flight cost is not displayed in the current active screen");
        }
        return Double.valueOf(flightCellTypeText);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                            //Common Methods //

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Scroll the screen upwards
     */
    public static void scrollTheScreenUpwards() {
        try {
            TouchAction action = new TouchAction(driver);
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            action.press(459, 620).moveTo(454, 600).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }
    /**
     * Scroll the screen downwards
     */
    public static void scrollTheScreenDownwards() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(459, 600).moveTo(454, 630).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the menu screen downwards
     */
    public static void scrollTheMenuScreenDownwards() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(400, 739).moveTo(400, 929).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }
}
