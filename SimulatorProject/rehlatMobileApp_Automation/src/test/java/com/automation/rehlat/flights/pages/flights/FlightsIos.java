package com.automation.rehlat.flights.pages.flights;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import static com.automation.rehlat.flights.tests.BaseTest.SELECT_LANGUAGE;


public class FlightsIos extends FlightsBase {

    public static final String FROM_TEXTFIELD_ID = "fromButton";
    public static final String TO_TEXTFIELD_ID = "toButton";
    public static final String DOWN_ARROW_BUTTON_ID_OF_PASSENGER_LAYOUT = "Downward Arrow";
    public static final String XPATH_OF_ONE_WAY_BUTTON = "//XCUIElementTypeButton[@name=\"onewayButton\"]";
    public static final String XPATH_OF_TWO_WAY_BUTTON = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]";
    public static final String SEARCH_VIEW = "Rehlat.SearchView";
    public static final String SEARCH_TEXTFIELD_XPATH = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
    public static final String CONTINUE_BUTTON = "CONTINUE";
    public static final String MENU_BUTTON = "Item";
    public static final String SEARCH_BUTTON = "Search";
    public static final String XPATH_OF_DEPARTURE = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]";
    public static final String XPATH_OF_RETURN = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton";
    public static final String DONE_BUTTON_IN_CALENDAR_VIEW = "Done";
    public static final String ONE_WAY_IN_ARABIC_LANGUAGE = "الذهاب فقط";
    public static final String ONE_WAY_IN_ENGLISH_LANGUAGE = "ONE-WAY";
    public static final String XPATH_OF_SELECT_COUNTRY_SHEET = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTable";
    public static final String DEPARTURE_DAY_ID_IN_CALENDAR_VIEW = "fromDate";
    public static final String DEPARTURE_MONTH_ID_IN_CALENDAR_VIEW = "fromMonth";
    public static final String RETURN_DAY_ID_IN_CALENDAR_VIEW = "toDate";
    public static final String RETURN_MONTH_ID_IN_CALENDAR_VIEW = "toMonth";
    public static final String CALENDER_MODAL_VIEW_XPATH = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView";
    protected static String CURRENT_MONTH = "Oct";
    public static final String[] listOfElementsInFlightsTab = {"ONE-WAY","ROUND-TRIP","FROM","TO","Departure","Return","ADULTS","CHILDREN","INFANTS","ECONOMY","BUSINESS","FIRST","Search"};
    public static final String PASSENGER_LAYOUT_ID = "Passenger";
    public static final String ACCESSIBILITY_ID_OF_ADULTS_PLUS_BUTTON = "adultPlus";
    public static final String ACCESSIBILITY_ID_OF_CHILDREN_PLUS_BUTTON = "childPlus";
    public static final String ACCESSIBILITY_ID_OF_INFANTS_PLUS_BUTTON = "infantPlus";
    public static final String ACCESSIBILITY_ID_OF_ADULTS_MINUS_BUTTON = "adultMinus";
    public static final String ACCESSIBILITY_ID_OF_CHILDREN_MINUS_BUTTON = "childMinus";
    public static final String ACCESSIBILITY_ID_OF_INFANTS_MINUS_BUTTON = "infantMinus";
    public static final String SWAP_BUTTON = "rotationalSearch";
    public static final String NOTIFICATIONS_BUTTON = "notification";
    public static final String TO_AIRPORT_NAME = "com.app.rehlat:id/toCity";
    public static final String FROM_AIRPORT_NAME = "com.app.rehlat:id/fromCity";
    public static final String ACCESSIBILITY_ID_OF_ADULTS_COUNT = "adultCount";
    public static final String ACCESSIBILITY_ID_OF_CHILDREN_COUNT = "childCount";
    public static final String ACCESSIBILITY_ID_OF_INFANTS_COUNT = "infantCount";
    public static final String XPATH_OF_RETURN_BUTTON_IN_CALENDAR_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]";



    /**
     * Check select language modal is displayed
     */
    @Override
    public boolean isSelectLanguageModalIsDisplayed() {
        Logger.logAction("checking the select language modal is displayed or not ?");
        try{
            Thread.sleep(1000);
            if (isElementDisplayedByName(SELECT_LANGUAGE)){
                Logger.logStep("Select Language modal is displayed");
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            Logger.logWarning("Select Language Modal is not displayed");
        }
        return false;
    }

    /**
     * Get the position of current active user location country name
     * @return
     */
    @Override
    public String getTheLastPositionCountryNameInSelectCountryLayout(){
        Logger.logAction("Getting the position of current active user location country name");
        try{
            if (isElementDisplayedByXPath(XPATH_OF_SELECT_COUNTRY_SHEET)){
                WebElement selectCountrySheet = driver.findElementByXPath(XPATH_OF_SELECT_COUNTRY_SHEET);
                List<WebElement> listOfCountries = selectCountrySheet.findElements(By.className(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_CELL));
                String nameOfTheLastLabel = listOfCountries.get(listOfCountries.size()-1).findElement(By.className(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                if (nameOfTheLastLabel.equalsIgnoreCase(Labels_Flights.INDIA_LANGUAGE_COUNTRY_LABEL) || nameOfTheLastLabel.equalsIgnoreCase(Labels_Flights.OTHERS_COUNTRY_LABEL)){
                    return nameOfTheLastLabel;
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the position of India country Name");
        }
        return null;
    }

    /**
     * Tap on one way trip
     */
    public void tapOnOneWayTrip() throws Exception{
        Logger.logAction("Tap on one way trip");
        try {
//            MobileElement element = (MobileElement) driver.findElementByXPath(Labels_Flights.XCUI);
//            element.click();
            boolean  status = findElementByXPathAndClick(XPATH_OF_ONE_WAY_BUTTON);
            if (status == true){
             Logger.logStep("Tapped on one way trip");
            }else {
                Logger.logError("Didn't tapped on one way trip");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error:- Unable to tap on one way trip button");
        }
    }
    /**
     * Tapping on menu button
     */
    @Override
    public void tapOnMenuButton() {
        Logger.logAction("Tapping on menu button");
        try {
            if (isElementDisplayedByAccessibilityId(MENU_BUTTON)){
                driver.findElementByAccessibilityId(MENU_BUTTON).click();
                Logger.logStep("Tapped on Menu button");
            }else{
                Logger.logError("Menu button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the flights screen name");
        }
    }

    /**
     * Check the flights tab is displayed
     */
    @Override
    public void checkFlightsTabIsDisplayed() {
        Logger.logAction("Checking flights screen tab is displayed");
        try {
            Thread.sleep(Labels_Flights.WAIT_TIME_MIN);
            if (isElementDisplayedByAccessibilityId(MENU_BUTTON)){
                String menuButton = driver.findElementByAccessibilityId(MENU_BUTTON).getAttribute(Labels_Flights.VISIBLE_ATTRIBUTE);
//                String menuButton = driver.findElementByName(MENU_BUTTON).getAttribute("enabled");
                if (menuButton.equalsIgnoreCase(Labels_Flights.STATUS_TRUE)){
                    Logger.logStep("Flights Screen is displayed");
                }else{
                    Logger.logError("Flights screen is not displayed, status :- "+menuButton);
                }
            }else{
                Logger.logError("Menu button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the flights screen name");
        }
    }

    /**
     * Selects the country name of the user
     * @param userCountryName
     */
    public void selectCountryOfUser(String userCountryName) {
        Logger.logAction("selecting the country of user");
        try{
            if (userCountryName.equals(Labels_Flights.INDIA_LANGUAGE_COUNTRY_LABEL)){
                if (isElementDisplayedByName(Labels_Flights.INDIA_LANGUAGE_COUNTRY_LABEL)){
                    driver.findElementByName(userCountryName).click();
                    Logger.logStep("Tapped on element - " +userCountryName);
                }else if (isElementDisplayedByName(Labels_Flights.OTHERS_COUNTRY_LABEL)){
                    driver.findElementByName(Labels_Flights.OTHERS_COUNTRY_LABEL).click();
                    Logger.logStep("Tapped on element - " + Labels_Flights.OTHERS_COUNTRY_LABEL);
                }else {
                    Logger.logError(userCountryName+" :- element name is not displaying in the current active screen");
                }
            } else if (isElementDisplayedByName(userCountryName)){
                driver.findElementByName(userCountryName).click();
                Logger.logStep("Tapped on element - " +userCountryName);
            }else {
                Logger.logError(userCountryName+" :- element name is not displaying in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the user country from select country modal");
        }
    }

    /**
     * Tap on Continue button
     */
    public void tapOnContinueButton() {
        try{
            if (isElementDisplayedByName(CONTINUE_BUTTON)){
                driver.findElementByName(CONTINUE_BUTTON).click();
                Logger.logStep("Tapped on Continue button");
            }else{
                Logger.logError("Unable to tap on continue button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to tap on Continue button");
        }
    }

    /**
     * Select the country name and move to flights tab
     */
    @Override
    public void selectCountryNameInSelectLanguageModal(String countryName) {
        if (isSelectLanguageModalIsDisplayed()){
            selectCountryOfUser(countryName);
            tapOnContinueButton();
        }else{
            Logger.logStep("Select language modal is not displayed and moving to next test step");
        }
    }

    /**
     * Tap on From Text Field in flights tab
     */
    @Override
    public void tapOnFromTextField() {
        Logger.logAction("Tapping on From text field in flights tab");
        try {
            tapOnOneWayTrip(); //Todo:- This line of code needs to be made override once the tap on one way method is implemented in android also
            if (isElementEnabledById(FROM_TEXTFIELD_ID)){
                driver.findElementByAccessibilityId(FROM_TEXTFIELD_ID).click();
                Logger.logStep("Tapped on FROM text field button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on From text field in flights tab ");
        }
    }

    /**
     * Tap on TO text field in flights tab
     */
    @Override
    public void tapOnToTextField() {
        try {
            if (isElementEnabledById(TO_TEXTFIELD_ID)){
                driver.findElementByAccessibilityId(TO_TEXTFIELD_ID).click();
                Logger.logStep("Tapped on TO text field button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to tap on TO text field");
        }
    }

    /**
     * Check keyboard is triggered or not
     */
    @Override
    public void checkKeyboardIsDisplayed() {
        Logger.logAction("Checking keyboard is triggered or not ?");
        try {
            // Commented code is used to handle the loading indicator displayed on first time navigating to search flight screen after fresh installation
            Thread.sleep(2000);
            if (isKeyboardDisplayed()){
                Logger.logComment("Keyboard is triggered");
            }else{
                Logger.logError("Keyboard is not triggered");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify keyboard status");
        }
    }

    /**
     * Check the search view screen is displayed or not
     */
    @Override
    public void checkSearchViewScreenIsDisplayed() {
        Logger.logAction("Checking search view screen is displayed or not?");
        try{
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,1);
                if(isElementDisplayedByName(SEARCH_VIEW)){
                    Logger.logStep("Search view screen is displayed");
                }else {
                    Logger.logError("Search view screen is not displayed");
                }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
    }

    /**
     * Enter From place in search view
     */
    @Override
    public void enterAirportName(String fromPlace) {
        Logger.logAction("Entering the airport name :-"+fromPlace);
        try{
            sendTextByXpath(SEARCH_TEXTFIELD_XPATH,fromPlace);
            Logger.logComment(fromPlace+" :- value is parsed");
            closeTheKeyboard_iOS();
        }catch (Exception nullPointerException){
            Logger.logError("Encountered error: Unable to enter from place name in the search view");
        }
    }

    /**
     * Select the place name from search results of search view
     * @param airPortCodeOfPlaceName
     */
    @Override
    public void selectAirportCodeFromSearchResults(String airPortCodeOfPlaceName) {
        Logger.logAction("Selecting the airport code :-"+airPortCodeOfPlaceName);
        try {
            if (isElementDisplayedByName(airPortCodeOfPlaceName)){
                driver.findElementByName(airPortCodeOfPlaceName).click();
                Logger.logStep("Tapped on airport code :- "+airPortCodeOfPlaceName);
            }else{
                Logger.logError("Unable to tap on the airport code of place - " +airPortCodeOfPlaceName);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the airport code of place name from search results");
        }
    }

    /**
     * Tap on Departure button in flights tab
     */
    @Override
    public void tapOnDepartureDateBookingButton() {
        Logger.logAction("Tapping on departure button");
        try{
            findElementByXPathAndClick(XPATH_OF_DEPARTURE);
            Logger.logStep("Tapped on departure button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on Departure button");
        }
    }

    /**
     * Tap on Return date booking button in flights tab
     */
    @Override
    public void tapOnReturnDateBookingButton() {
        Logger.logAction("Tapping on return button");
        try{
            findElementByXPathAndClick(XPATH_OF_RETURN);
            Logger.logStep("Tapped on return button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on Departure button");
        }
    }

    /**
     * Select the departure date
     * @param departureMonthAndYear
     * @param departureDay
     */
    @Override
    public void selectDepartureDate(String departureMonthAndYear, String departureDay) {
        Logger.logAction("Selecting the departure date : Month & Year -" + departureMonthAndYear + ", Day - "+departureDay);
        int iterations = 0;
        int[] arrayListOfStartingPointLocationXAndY;
        int[] arrayListOfEndingPointLocationXAndY;
        try {
            if (isElementDisplayedByXPath(CALENDER_MODAL_VIEW_XPATH)){
                WebElement calendarView = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                scrollToAnElementByName(calendarView,departureMonthAndYear,true);
                if (isElementDisplayedByName(departureMonthAndYear)){
                    if (isElementEnabledByName(departureDay)) {
                        while (iterations <=10){
                            WebElement  calenderView = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> departureDays = calenderView.findElements(By.name(departureDay));
                            int departureDaysSize = departureDays.size();
                            if (departureDaysSize >= 2){
                                Logger.logComment("More than one similar departure days are displayed in the calender view with same departure day: "+departureDay+"");
                            if (departureDaysSize >= 2){
                                Logger.logWarning("More than one similar dates are displayed in the departure calender, so tapping on nearest possible date");
                                for (int count =0;count<=departureDays.size()-1;count++){
                                    WebElement visibleDepartureDay = departureDays.get(count);
                                    if (visibleDepartureDay.getAttribute(Labels_Flights.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Flights.STATUS_TRUE)){
                                        visibleDepartureDay.click();
                                        Logger.logComment("Tapped on day:- "+departureDay);
                                        String departureMonthName = getTheDepartureMonthDisplayedInCalenderView();
                                        String departureDayValue = getTheDepartureDayDisplayedInCalenderView();
                                        if (departureMonthName.equalsIgnoreCase(Labels_Flights.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                            if (departureDayValue.equalsIgnoreCase(departureDay)){
                                                Logger.logComment("Tapped on correct departure day:- "+departureDay);
                                                iterations = 10;
                                                break;
                                            }else {
                                                Logger.logStep("Tapped on incorrect date. So re tapping on the departure date");
                                            }
                                        }else {
                                            Logger.logStep("Tapped on incorrect date. So re tapping on the departure date");
                                            if (iterations <= 10){
                                                iterations++;
                                                arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                                arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView,"center");
                                                driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],1000);
                                            }else {
                                                Logger.logError("Tried "+iterations+" times didn't find the exact date");
                                            }
                                        }
                                    }else
                                    {
                                        continue;
                                    }
                                }

                            }else {
                                driver.findElementByName(departureDay).click();
                                Logger.logComment("Tapped on day:- "+departureDay);
                            }
                        }else {
                            Logger.logComment("One departure day is displayed in the calender: "+departureDay+"");
                            driver.findElementByName(departureDay).click();
                            Logger.logComment("Tapped on day:- "+departureDay);
                        }
                        if (iterations == 10){
                            break;
                        }
                        }
                    }else {
                        Logger.logError("Accurate Date is not displayed in the departure");
                    }
                }else{
                    scrollToAnElementByName(calendarView,departureMonthAndYear,false);
                    if (isElementDisplayedByName(departureMonthAndYear)){
                        if (isElementEnabledByName(departureDay)) {
                            while (iterations <=10){
                            WebElement  calenderView = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> departureDays = calenderView.findElements(By.name(departureDay));
                            int departureDaysSize = departureDays.size();
                            if (departureDaysSize >= 2){
                                Logger.logComment("More than one similar departure days are displayed in the calender view with same departure day: "+departureDay+"");
                                if (departureDaysSize >= 2){
                                    Logger.logWarning("More than one similar dates are displayed in the departure calender, so tapping on nearest possible date");
                                    for (int count =0;count<=departureDays.size()-1;count++){
                                        WebElement visibleDepartureDay = departureDays.get(count);
                                        if (visibleDepartureDay.getAttribute(Labels_Flights.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Flights.STATUS_TRUE)){
                                            visibleDepartureDay.click();
                                            Logger.logComment("Tapped on day:- "+departureDay);
                                            String departureMonthName = getTheDepartureMonthDisplayedInCalenderView();
                                            String departureDayValue = getTheDepartureDayDisplayedInCalenderView();
                                            if (departureMonthName.equalsIgnoreCase(Labels_Flights.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                                if (departureDayValue.equalsIgnoreCase(departureDay)){
                                                    Logger.logComment("Tapped on correct departure day:- "+departureDay);
                                                    iterations = 10;
                                                    break;
                                                }else {
                                                    Logger.logStep("Tapped on incorrect date. So re tapping on the departure date");
                                                }
                                            }else {
                                                if (iterations <= 10){
                                                    iterations++;
                                                    arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                                    arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView,"center");
                                                    driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],1000);
                                                }else {
                                                    Logger.logError("Tried "+iterations+" times didn't find the exact date");
                                                }
                                            }
                                        }else
                                        {
                                            continue;
                                        }
                                    }

                                }else {
                                    driver.findElementByName(departureDay).click();
                                    Logger.logComment("Tapped on day:- "+departureDay);
                                }
                            }else {
                                Logger.logComment("One departure day is displayed in the calender: "+departureDay+"");
                                driver.findElementByName(departureDay).click();
                                Logger.logComment("Tapped on day:- "+departureDay);
                            }
                            if (iterations == 10){
                                break;
                            }
                            }
                        }else {
                            Logger.logError("Accurate Date is not displayed in the departure");
                        }
                    }else{
                        if (iterations >2){
                            iterations++;
                            Logger.logWarning("Two accurate dates are displayed in the departure calender, so tapping on nearest possible date");
                            scrollToAnElementByName(calendarView,departureMonthAndYear,true);
                            if (isElementDisplayedByName(departureDay)) {
                                driver.findElementByName(departureDay).click();
                            }else {
                                Logger.logError("Accurate Date is not displayed in the departure");
                            }
                        }else {
                            Logger.logError("unable to tap on the selected departure date..,tried - " +iterations+" times scrolling");
                        }
                    }
                }
            }else{
                Logger.logError("Calendar view is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to select the date in the date modal");
        }
    }

    /**
     * Tap on return month cell in calendar view
     * @throws Exception
     */
    public static void tapOnReturnMonthCellInCalendarView() throws Exception{
        Logger.logAction("Tapping on return month cell in calendar view");
        try {
            boolean status = findElementByXPathAndClick(XPATH_OF_RETURN_BUTTON_IN_CALENDAR_VIEW);
            if (status == true){
                Logger.logComment("Tapped on return month cell in the calendar view");
            }else {
                Logger.logError("Didn't tapped on return cell in the calendar view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on return button in the calendar view");
        }
    }
    /**
     * Select the return date
     * @param returnMonthAndYear
     * @param returnDay
     */
    @Override
    public void selectReturnDate(String returnMonthAndYear, String returnDay) {
        Logger.logAction("Selecting the return date : Month & Year -" + returnMonthAndYear + ", Day - "+returnDay);
        int iterations = 0;
        int[] arrayListOfStartingPointLocationXAndY;
        int[] arrayListOfEndingPointLocationXAndY;
        try {
            tapOnReturnMonthCellInCalendarView();
            if (isElementDisplayedByXPath(CALENDER_MODAL_VIEW_XPATH)){
                WebElement calendarView = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                scrollToAnElementByName(calendarView,returnMonthAndYear,true);
                if (isElementDisplayedByName(returnMonthAndYear)){
                    if (isElementEnabledByName(returnDay)) {
                        while (iterations <=10) {
                            WebElement calenderView = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> returnDays = calenderView.findElements(By.name(returnDay));
                            int returnDaysSize = returnDays.size();
                            if (returnDaysSize >= 2) {
                                Logger.logComment("Two departure days are displayed in the calender view with same return day: " + returnDay + "");
                                if (returnDaysSize >= 2) {
                                    Logger.logWarning("Two accurate dates are displayed in the return calender, so tapping on nearest possible date");
                                    for (int count = 0; count <= returnDays.size() - 1; count++) {
                                        WebElement visibleReturnDay = returnDays.get(count);
                                        if (visibleReturnDay.getAttribute(Labels_Flights.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Flights.STATUS_TRUE)) {
                                            visibleReturnDay.click();
                                            Logger.logComment("Tapped on day:- " + visibleReturnDay);
                                            String departureMonthName = getTheReturnMonthDisplayedInCalenderView();
                                            String departureDayValue = getTheReturnDayDisplayedInCalenderView();
                                            if (departureMonthName.equalsIgnoreCase(Labels_Flights.DEPARTURE_MONTH_IN_CALENDAR_VIEW)) {
                                                if (departureDayValue.equalsIgnoreCase(returnDay)) {
                                                    Logger.logComment("Tapped on correct departure day:- " + returnDay);
                                                    iterations = 10;
                                                    break;
                                                } else {
                                                    Logger.logStep("Tapped on incorrect date. So re tapping on the departure date");
                                                }
                                            } else {
                                                if (iterations <= 10) {
                                                    iterations++;
                                                    arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                                    arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "center");
                                                    driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1], arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1], 1000);
                                                } else {
                                                    Logger.logError("Tried " + iterations + " times didn't find the exact date");
                                                }
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                } else {
                                    driver.findElementByName(returnDay).click();
                                    Logger.logComment("Tapped on day:- " + returnDay);
                                }
                            } else {
                                Logger.logComment("One return day is displayed in the return calender: " + returnDay + "");
                                driver.findElementByName(returnDay).click();
                            }
                            if (iterations == 10){
                                break;
                            }
                        }
                    }else {
                        Logger.logError("Accurate Date is not displayed in the departure");
                    }
                }else{
                    scrollToAnElementByName(calendarView,returnMonthAndYear,false);
                    if (isElementDisplayedByName(returnMonthAndYear)){
                        if (isElementEnabledByName(returnDay)) {
                            while (iterations <=10) {
                                WebElement  calenderView = driver.findElementByClassName(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> returnDays = calenderView.findElements(By.name(returnDay));
                            int returnDaysSize = returnDays.size();
                            if (returnDaysSize >= 2){
                                Logger.logComment("Two departure days are displayed in the calender view with same return day: "+returnDay+"");
                                if (returnDaysSize >= 2){
                                    Logger.logWarning("Two accurate dates are displayed in the return calender, so tapping on nearest possible date");
                                    for (int count =0;count<=returnDays.size()-1;count++){
                                        WebElement visibleReturnDay = returnDays.get(count);
                                        if (visibleReturnDay.getAttribute(Labels_Flights.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Flights.STATUS_TRUE)){
                                            visibleReturnDay.click();
                                            Logger.logComment("Tapped on day:- "+visibleReturnDay);
                                            String departureMonthName = getTheReturnMonthDisplayedInCalenderView();
                                            String departureDayValue = getTheReturnDayDisplayedInCalenderView();
                                            if (departureMonthName.equalsIgnoreCase(Labels_Flights.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                                if (departureDayValue.equalsIgnoreCase(returnDay)){
                                                    Logger.logComment("Tapped on correct departure day:- "+returnDay);
                                                    iterations = 10;
                                                    break;
                                                }else {
                                                    Logger.logStep("Tapped on incorrect date. So re tapping on the departure date");
                                                }
                                            }else {
                                                if (iterations <= 10){
                                                    iterations++;
                                                    arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                                    arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView,"center");
                                                    driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],1000);
                                                }else {
                                                    Logger.logError("Tried "+iterations+" times didn't find the exact date");
                                                }
                                            }
                                        }else
                                        {
                                            continue;
                                        }
                                    }
                                }else {
                                    driver.findElementByName(returnDay).click();
                                    Logger.logComment("Tapped on day:- "+returnDay);
                                }
                            }else {
                                Logger.logComment("One return day is displayed in the return calender: "+returnDay+"");
                                driver.findElementByName(returnDay).click();
                            }
                            if (iterations == 10){
                                break;
                            }
                            }
                        }else {
                            Logger.logError("Accurate Date is not displayed in the departure");
                        }
                    }
                    else{
                        if (iterations !=1){
                            Logger.logWarning("Two accurate dates are displayed in the return calender, so tapping on nearest possible date");
                            scrollToAnElementByName(calendarView,returnMonthAndYear,true);
                            if (isElementDisplayedByName(returnDay)) {
                                driver.findElementByName(returnDay).click();
                            }else {
                                Logger.logError("Accurate Date is not displayed in the return");
                            }
                        }else {
                            Logger.logError("unable to tap on the selected return date..,tried - " +iterations);
                        }
                    }
                }
            }else{
                Logger.logError("Calendar view is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to select the date in the date modal");
        }
    }

    /**
     * Finds the current month and return it.
     * @return the CURRENT MONTH.
     */
    public static String findCurrentMonth() {
        Calendar now = Calendar.getInstance();
        return new SimpleDateFormat("MMMM").format(now.getTime());
    }

    /**
     * Verify Calender view default current month
     * @throws Exception
     */
    public void verifyCalendarDefaultCurrentMonth() throws Exception {
        CURRENT_MONTH = findCurrentMonth();
        String CALENDAR_DEFAULT_DATE = driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Jul\"])[2]")).getAttribute("name");
        Logger.logAction("Verifying Calendar page default current month");
        Thread.sleep(7000);
        if(!CALENDAR_DEFAULT_DATE.toLowerCase().contains(CURRENT_MONTH.toLowerCase())){
            Logger.logWarning("Calendar view is not displayed with default current month.");
            Logger.logComment("Calendar view default Month is Current Month - i.e. -- " + CURRENT_MONTH);
        }else{
            Logger.logComment("Calendar view default Month is Current Month - i.e. -- " + CURRENT_MONTH);
        }
    }

    /**
     * Tap on Done button in calendar view
     */
    @Override
    public void tapOnDoneButton() {
        Logger.logAction("Tapping on Done button");
        try {
            if (isElementDisplayedByName(DONE_BUTTON_IN_CALENDAR_VIEW)){
                driver.findElementByName(DONE_BUTTON_IN_CALENDAR_VIEW).click();
                Logger.logStep("Tapped on Done button");
            }else {
                Logger.logError("Done button is not displayed in the calendar view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on Done button in calendar view");
        }
    }

    /**
     * Tap on search button in flights tab
     */
    @Override
    public void tapOnSearchButton() {
        Logger.logAction(" Tapping on Search button in flights tab");
        try {
            if (isElementDisplayedByName(SEARCH_BUTTON)){
                driver.findElementByName(SEARCH_BUTTON).click();
                Logger.logStep("Tapped on Search button");
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,1); //Todo:- Remove this line code after implementing the progress indicator in SRP page
            }else {
                scrollDown(); //Todo:- This line of code is implemented due to low screen resolution in iPhone 5S
                if (isElementDisplayedByName(SEARCH_BUTTON)){
                    driver.findElementByName(SEARCH_BUTTON).click();
                    Logger.logStep("Tapped on Search button");
                    waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,1); //Todo:- Remove this line code after implementing the progress indicator in SRP page
                }else {
                    Logger.logError("Search button is not displayed in flights tab");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on search button in flights tab");
        }
    }

    /**
     * Check the app localization in flights tab
     * @return
     */
    @Override
    public String checkAppLocalizationInFlightsTab(){
        Logger.logAction("Check the app localization in flights tab");
        try {
            if (isElementDisplayedByName(ONE_WAY_IN_ENGLISH_LANGUAGE)){
                return Labels_Flights.ENGLISH_LANGUAGE;
            }else if (isElementDisplayedByName(ONE_WAY_IN_ARABIC_LANGUAGE)){
                return Labels_Flights.ARABIC_LANGUAGE;
            }else {
                Logger.logError("The localization displayed in the app is neither English nor Arabic");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the flights tab localization");
        }
        return null;
    }

    /**
     * Check all the fields are visible in flights tab
     */
    @Override
    public void checkAllTheFieldsAreVisibleInFlightsTab(){
        Logger.logAction("Verify all the fields are visible in flights tab");
        try {
            for (int index=0;index<=listOfElementsInFlightsTab.length-1;index++){
                String elementName = listOfElementsInFlightsTab[index];
                if (isElementEnabledByName(elementName)){
                    Logger.logComment(elementName+" :- element is enabled in the flight tabs screen");
                }else {
                    Logger.logError(elementName+" :- element is not enabled in the flight tabs screen");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the fields are visible in flights tab");
        }
    }

    /**
     * Get the location of From airport name
     * @return
     */
    @Override
    public Integer[] getTheLocationOfFromAirPortName(String parsingFromFlightName){
        Logger.logAction("Getting the location of From airport name");
        try {
            WebElement locationOfFromAirportName = driver.findElementByName(parsingFromFlightName);
            Point table = locationOfFromAirportName.getLocation();
            int elementXAxisValue = table.getX();
            int elementYAxisValue = table.getY();
            Integer [] elementLocation = new Integer[] { elementXAxisValue,elementYAxisValue};
            return elementLocation;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the location from airport name");
        }
        return null;
    }

    /**
     * Get the location of To airport name
     * @return
     */
    @Override
    public Integer[] getTheLocationOfToAirPortName(String parsingToFlightName){
        Logger.logAction("Getting the location of To airport name");
        try {
            WebElement locationOfToAirportName = driver.findElementByName(parsingToFlightName);
            Point table = locationOfToAirportName.getLocation();
            int elementXAxisValue = table.getX();
            int elementYAxisValue = table.getY();
            Integer [] elementLocation = new Integer[] { elementXAxisValue,elementYAxisValue};
            return elementLocation;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the location from airport name");
        }
        return null;
    }

    /**
     * Tap on swap button
     * @return
     */
    @Override
    public void tapOnSwapButton(){
        Logger.logAction("Tapping on swap button");
        try {
            findElementByNameAndClick(SWAP_BUTTON);
            Logger.logComment("Tapped on swap button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the location from airport name");
        }
    }

 // The below two methods are dummy methods because of android app created the below two methods
    /**
     * Get the From airport name
     */
    @Override
    public String  getTheFromAirportName() {
        Logger.logAction("Getting the from airport name");
        try {
            String fromAirportName = findElementByIdAndReturnText(FROM_AIRPORT_NAME);
            Logger.logComment(fromAirportName+" - is the from airport name");
            if (!fromAirportName.isEmpty()){
                return fromAirportName;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the from airport name");
        }
        return null;
    }

    /**
     * Get the To airport name
     */
    @Override
    public String getTheToAirportName() {
        Logger.logAction("Getting the to airport name");
        try {
            String toAirportName = findElementByIdAndReturnText(TO_AIRPORT_NAME);
            Logger.logComment(toAirportName+" - is the from airport name");
            if (!toAirportName.isEmpty()){
                return toAirportName;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the from airport name");
        }
        return null;
    }

    /**
     * Get the departure month displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheDepartureMonthDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the month displayed in the calendar view");
        String departureMonth = findElementByAccessibilityIdAndReturnText(DEPARTURE_MONTH_ID_IN_CALENDAR_VIEW,Labels_Flights.VALUE_ATTRIBUTE);
        Logger.logComment("Selected month name in calendar view is :- "+departureMonth);
        return departureMonth;
    }

    /**
     * Get the departure day displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheDepartureDayDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the day displayed in the calendar view");
        String departureDay = findElementByAccessibilityIdAndReturnText(DEPARTURE_DAY_ID_IN_CALENDAR_VIEW,Labels_Flights.VALUE_ATTRIBUTE);
        Logger.logComment("Selected day value in calendar view is :- "+departureDay);
        return departureDay;
    }

    /**
     * Get the return month displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheReturnMonthDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the month displayed in the calendar view");
        String departureMonth = findElementByAccessibilityIdAndReturnText(RETURN_MONTH_ID_IN_CALENDAR_VIEW,Labels_Flights.VALUE_ATTRIBUTE);
        Logger.logComment("Selected month name in calendar view is :- "+departureMonth);
        return departureMonth;
    }

    /**
     * Get the return day displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheReturnDayDisplayedInCalenderView() throws Exception {
        Logger.logAction("Getting the day displayed in the calendar view");
        String departureDay = findElementByAccessibilityIdAndReturnText(RETURN_DAY_ID_IN_CALENDAR_VIEW,Labels_Flights.VALUE_ATTRIBUTE);
        Logger.logComment("Selected day value in calendar view is :- " + departureDay);
        return departureDay;
    }

    /**
     * Set the passengers count
     * @param parsingAdultsCount
     * @param parsingChildrenCount
     * @param parsingInfantsCount
     */
    @Override
    public void setThePassengersCountTo(Integer parsingAdultsCount, Integer parsingChildrenCount,Integer parsingInfantsCount){
        Logger.logAction("Setting the passengers count");
        try {
            tapOnPassengerLayoutInFlightsTab();
            setTheAdultPassengerCount(parsingAdultsCount);
            setTheChildrenPassengerCount(parsingChildrenCount);
            setTheInfantPassengerCount(parsingInfantsCount);
            Integer currentAdultPassengerCountBeforeTapping = getTheCurrentAdultPassengerCount();
            Integer currentChildrenPassengerCountBeforeTapping = getTheCurrentChildrenPassengerCount();
            Integer currentInfantPassengerCountBeforeTapping = getTheCurrentInfantsPassengerCount();
            if (currentAdultPassengerCountBeforeTapping == parsingAdultsCount && currentChildrenPassengerCountBeforeTapping == parsingChildrenCount && currentInfantPassengerCountBeforeTapping == parsingInfantsCount){
                Logger.logStep("Passengers list is set successfully");
                tapOnDoneButton();
            }else {
                Logger.logComment("Adults passengers count to be set is :-"+parsingAdultsCount);
                Logger.logComment("Adults passengers count displaying is :-"+currentAdultPassengerCountBeforeTapping);
                Logger.logComment("Children passengers count to be set is :-"+parsingChildrenCount);
                Logger.logComment("Children passengers count displaying is :-"+currentChildrenPassengerCountBeforeTapping);
                Logger.logComment("Infants passengers count to be set is :-"+parsingInfantsCount);
                Logger.logComment("Infants passengers count displaying is :-"+currentInfantPassengerCountBeforeTapping);
                Logger.logError("Passengers list is set improperly");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the passenger count");
        }
    }


    /**
     * Tap on passenger layout in flights tab
     */
    public void tapOnPassengerLayoutInFlightsTab() {
        Logger.logAction("Closing the passenger layout in flights tab");
        try {
            findElementByAccessibilityIdAndClick(PASSENGER_LAYOUT_ID);
            Logger.logStep("Tapped on passenger layout");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on passenger layout in flights tab");
        }
    }

    /**
     * Close the passenger layout view in flights tab
     */
    public void closeThePassengerLayoutView() {
        Logger.logAction("Tapping on down arrow button in passenger layout of flights tab");
        try {
            findElementByAccessibilityIdAndClick(DOWN_ARROW_BUTTON_ID_OF_PASSENGER_LAYOUT);
            Logger.logStep("Tapped on down arrow button");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on down arrow button in passenger layout of flights tab");
        }
    }
    /**
     * Set the adult passengers count
     * @param parsingAdultsCount
     */
    public static void setTheAdultPassengerCount(Integer parsingAdultsCount){
        Logger.logAction("Setting the adult passengers count");
        try {
            Integer iterations = 0;
            while (iterations < 10){
                Integer currentAdultPassengerCountBeforeTapping = getTheCurrentAdultPassengerCount();
                if (currentAdultPassengerCountBeforeTapping < parsingAdultsCount){
                    while (currentAdultPassengerCountBeforeTapping != parsingAdultsCount){
                        FlightsScreen.tapOnAdultPlusButton();
                        currentAdultPassengerCountBeforeTapping = getTheCurrentAdultPassengerCount();
                        iterations++;
                    }
                    Logger.logStep("Adult passenger count is set to :- "+currentAdultPassengerCountBeforeTapping);
                    break;
                }else if (currentAdultPassengerCountBeforeTapping > parsingAdultsCount){
                    while (currentAdultPassengerCountBeforeTapping != parsingAdultsCount){
                        FlightsScreen.tapOnAdultMinusButton();
                        currentAdultPassengerCountBeforeTapping = getTheCurrentAdultPassengerCount();
                        iterations++;
                    }
                    Logger.logStep("Adult passenger count is set to :- "+currentAdultPassengerCountBeforeTapping);
                    break;
                }else if (currentAdultPassengerCountBeforeTapping == parsingAdultsCount){
                    Logger.logStep("Adult passenger count is set to :- "+currentAdultPassengerCountBeforeTapping);
                    iterations++;
                    break;
                }else {
                    Logger.logError("Unable to compare the adults passenger counts :- "+currentAdultPassengerCountBeforeTapping+","+parsingAdultsCount);
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the passenger count");
        }
    }

    /**
     * Get the current adult passengers count
     * @return
     */
    public static Integer getTheCurrentAdultPassengerCount(){
        Logger.logAction("Getting the current adult passengers count");
        try {
            WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_ADULTS_COUNT);
            String adultsCount = element.getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
            Logger.logComment("Current adult passenger count is :- "+adultsCount);
                return Integer.parseInt(adultsCount);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the passenger count");
        }
        return null;
    }

    /**
     * Set the children passengers count
     * @param parsingChildrenCount
     */
    public static void setTheChildrenPassengerCount(Integer parsingChildrenCount){
        Logger.logAction("Setting the children passengers count");
        try {
            Integer iterations = 0;
            while (iterations < 10){
                Integer currentChildrenPassengerCountBeforeTapping = getTheCurrentChildrenPassengerCount();
                if (currentChildrenPassengerCountBeforeTapping < parsingChildrenCount){
                    while (currentChildrenPassengerCountBeforeTapping != parsingChildrenCount){
                        FlightsScreen.tapOnChildrenPlusButton();
                        currentChildrenPassengerCountBeforeTapping = getTheCurrentChildrenPassengerCount();
                        iterations++;
                    }
                    Logger.logStep("Children passenger count is set to :- "+currentChildrenPassengerCountBeforeTapping);
                    break;
                }else if (currentChildrenPassengerCountBeforeTapping > parsingChildrenCount){
                    while (currentChildrenPassengerCountBeforeTapping != parsingChildrenCount){
                        FlightsScreen.tapOnChildrenMinusButton();
                        currentChildrenPassengerCountBeforeTapping = getTheCurrentChildrenPassengerCount();
                        iterations++;
                    }
                    Logger.logStep("Children passenger count is set to :- "+currentChildrenPassengerCountBeforeTapping);
                    break;
                }else if (currentChildrenPassengerCountBeforeTapping == parsingChildrenCount){
                    Logger.logStep("Children passenger count is set to :- "+currentChildrenPassengerCountBeforeTapping);
                    iterations++;
                    break;
                }else {
                    Logger.logError("Unable to compare the children passenger counts :- "+currentChildrenPassengerCountBeforeTapping+","+parsingChildrenCount);
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the passenger count");
        }
    }

    /**
     * Get the current children passenger count
     * @return
     */
    public static Integer getTheCurrentChildrenPassengerCount(){
        Logger.logAction("Getting the current children passengers count");
        try {
            WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_CHILDREN_COUNT);
            String childrenCount = element.getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
            Logger.logComment("Current children passenger count is :- "+childrenCount);
                return Integer.parseInt(childrenCount);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the passenger count");
        }
        return null;
    }

    /**
     * Set the infant passengers count
     * @param parsingInfantsCount
     */
    public static void setTheInfantPassengerCount(Integer parsingInfantsCount){
        Logger.logAction("Setting the infant passengers count");
        try {
            Integer iterations = 0;
            while (iterations < 10){
                Integer currentInfantPassengerCountBeforeTapping = getTheCurrentInfantsPassengerCount();
                if (currentInfantPassengerCountBeforeTapping < parsingInfantsCount){
                    while (currentInfantPassengerCountBeforeTapping != parsingInfantsCount){
                        FlightsScreen.tapOnInfantsPlusButton();
                        currentInfantPassengerCountBeforeTapping = getTheCurrentInfantsPassengerCount();
                        iterations++;
                    }
                    Logger.logStep("Infant passenger count is set to :- "+currentInfantPassengerCountBeforeTapping);
                    break;
                }else if (currentInfantPassengerCountBeforeTapping > parsingInfantsCount){
                    while (currentInfantPassengerCountBeforeTapping != parsingInfantsCount){
                        FlightsScreen.tapOnInfantsMinusButton();
                        currentInfantPassengerCountBeforeTapping = getTheCurrentInfantsPassengerCount();
                        iterations++;
                    }
                    Logger.logStep("Infant passenger count is set to :- "+currentInfantPassengerCountBeforeTapping);
                    break;
                }else if (currentInfantPassengerCountBeforeTapping == parsingInfantsCount){
                    Logger.logStep("Infant passenger count is set to :- "+currentInfantPassengerCountBeforeTapping);
                    iterations++;
                    break;
                }else {
                    Logger.logError("Unable to compare the infants passenger counts :- "+currentInfantPassengerCountBeforeTapping+","+parsingInfantsCount);
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the passenger count");
        }
    }

    /**
     * Get the infants passengers count
     * @return
     */
    public static Integer getTheCurrentInfantsPassengerCount(){
        Logger.logAction("Getting the infants passengers count");
        try {
            WebElement element = driver.findElementByAccessibilityId(ACCESSIBILITY_ID_OF_INFANTS_COUNT);
            String infantsCount = element.getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
            Logger.logComment("Current infants passenger count is :- "+infantsCount);
            return Integer.parseInt(infantsCount);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the passenger count");
        }
        return null;
    }

    /**
     * Tap on adult plus button
     */
    @Override
    public void tapOnAdultPlusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByAccessibilityIdAndClick(ACCESSIBILITY_ID_OF_ADULTS_PLUS_BUTTON);
            Logger.logStep("Tapped on adult plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on adult plus button");
        }
    }

    /**
     * Tap on children plus button
     */
    @Override
    public void tapOnChildrenPlusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByAccessibilityIdAndClick(ACCESSIBILITY_ID_OF_CHILDREN_PLUS_BUTTON);
            Logger.logStep("Tapped on children plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on children plus button");
        }
    }

    /**
     * Tap on infants plus button
     */
    @Override
    public void tapOnInfantsPlusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByAccessibilityIdAndClick(ACCESSIBILITY_ID_OF_INFANTS_PLUS_BUTTON);
            Logger.logStep("Tapped on infants plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on infants plus button");
        }
    }

    /**
     * Tap on adult plus button
     */
    @Override
    public void tapOnAdultMinusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByAccessibilityIdAndClick(ACCESSIBILITY_ID_OF_ADULTS_MINUS_BUTTON);
            Logger.logStep("Tapped on adult plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on adult plus button");
        }
    }

    /**
     * Tap on children plus button
     */
    @Override
    public void tapOnChildrenMinusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByAccessibilityIdAndClick(ACCESSIBILITY_ID_OF_CHILDREN_MINUS_BUTTON);
            Logger.logStep("Tapped on children plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on children plus button");
        }
    }

    /**
     * Tap on infants plus button
     */
    @Override
    public void tapOnInfantsMinusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByAccessibilityIdAndClick(ACCESSIBILITY_ID_OF_INFANTS_MINUS_BUTTON);
            Logger.logStep("Tapped on infants plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on infants plus button");
        }
    }

    /**
     * Tap on notifications button
     */
    @Override
    public void tapOnNotificationsButton(){
        Logger.logAction("Tapping on notifications button");
        try {
            findElementByNameAndClick(NOTIFICATIONS_BUTTON);
            Logger.logStep("Tapped on notifications button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on notifications button");
        }
    }

    /**
     * Tap on karam tab
     */
    @Override
    public void tapOnKaramTab(){
        Logger.logAction("Tapped on karam");
        try {
            findElementByNameAndClick("Karam");
            Logger.logComment("Tapped on karam tab");
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to tap on karam tab ");
        }
    }


}
