package com.automation.rehlat.hotels.pages.hotels;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HotelsIos extends HotelsBase{

    public static final String XPATH_OF_HOTELS_TAB = "//XCUIElementTypeButton[@name=\"Hotels\"]";
    public static final String XPATH_OF_SEARCH_TEXT_FIELD_IN_HOTELS_TAB = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField";
    public static final String XPATH_OF_SEARCH_TEXT_FIELD_IN_SEARCH_PLACE_SCREEN = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
    public static final String XPATH_OF_CHECK_IN_AND_CHECK_OUT_LAYOUT = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]";
    public static final String XPATH_OF_ROOMS_AND_GUEST_COUNT_LAYOUT = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]";
    public static final String CALENDER_MODAL_VIEW_XPATH = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView";
    public static final String XPATH_OF_DEPARTURE_DAY_IN_CALENDAR_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]";
    public static final String XPATH_OF_DEPARTURE_MONTH_IN_CALENDAR_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]";
    public static final String XPATH_OF_RETURN_DAY_IN_CALENDAR_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[2]";
    public static final String XPATH_OF_RETURN_MONTH_IN_CALENDAR_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]";
    public static final String DONE_BUTTON_IN_CALENDAR_VIEW = "Done";
    public static final String MENU_BUTTON = "careemMenu";
    public static final String CHECK_IN_BUTTON_ACCESSIBILITY_ID_IN_HOTELS_HOME_SCREEN = "Check-In";
    public static final String CHECK_OUT_BUTTON_ACCESSIBILITY_ID_IN_HOTELS_HOME_SCREEN = "Check-Out";
    public static final String XPATH_OF_CHECK_IN_BUTTON_IN_CALENDER_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]";
    public static final String ADULT_COUNT_ID_IN_HOTELS_SCREEN = "com.app.rehlat:id/adultscount_txt";
    public static final String CHILD_COUNT_ID_IN_HOTELS_SCREEN = "com.app.rehlat:id/childrencount_txt";
    public static final String XPATH_OF_ROOMS_COUNT_IN_HOTELS_SCREEN = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeStaticText[3]";
    public static final String ADULTS_AND_CHILD_COUNT_LAYOUT_ACCESSIBILITY_ID = "Guests";
    public static final String ROOMS_LIST_VIEW_SCREEN_ACCESSIBILITY_ID = "ROOMS";
    public static final String ROOMS_STRING = "ROOMS";
    public static final String ADD_ROOM_BUTTON = "ADD ROOM";
    public static final String DONE_BUTTON_IN_ROOM_LIST_VIEW = "Done";
    public static final String XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[";
    public static final String XPATH_OF_ADULT_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH = "(//XCUIElementTypeStaticText[@name=\"1\"])[";
    public static final String XPATH_OF_ADULT_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "(//XCUIElementTypeButton[@name=\"+\"])[";
    public static final String XPATH_OF_ADULT_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "(//XCUIElementTypeButton[@name=\"-\"])[";
    public static final String XPATH_OF_CHILD_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH = "//XCUIElementTypeStaticText[@name=\"0\"])[";
    public static final String XPATH_OF_CHILD_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "\t(//XCUIElementTypeButton[@name=\"+\"])[";
    public static final String XPATH_OF_CHILD_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "(//XCUIElementTypeButton[@name=\"-\"])[";
    public static final String XPATH_OF_CHILD_AGE_CELL_NUMBER_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";
    public static final String XPATH_OF_CLOSE_BUTTON_OF_ROOM_LAYOUT_WITHOUT_ROOM_INDEX = "(//XCUIElementTypeButton[@name=\"X\"])[";
    public static final String CHECK_AVAILABILITY_BUTTON_ID = "Check Availability";
    public static Integer ROOMS_COUNT_IN_HOTELS_SCREEN;
    public static Integer ROOMS_COUNT_IN_ROOM_LIST_VIEW;
    /**
     * check is hotels screen is displayed
     */
    @Override
    public void checkHotelScreenISDisplayed(){
        Logger.logAction("Check hotel screen is displayed");
        try {
            String isValueAttribute = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_HOTELS_TAB);
            if (isValueAttribute.equalsIgnoreCase(Labels_Hotels.VALUE_ONE)){
                Logger.logStep("Hotels screen is displayed");
            }else {
                Logger.logError("Hotels screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the hotel screen is displayed or not?");
        }
    }

    /**
     * Tap on hotels tab
     */
    @Override
    public void tapOnHotelsTab(){
        Logger.logStep("Tapping on hotels tab");
        try {
            String isValueAttribute = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_HOTELS_TAB);
            if (isValueAttribute == null){
                findElementByXPathAndClick(XPATH_OF_HOTELS_TAB);
                Logger.logStep("Hotels tab is displayed");
            }else if (isValueAttribute.equalsIgnoreCase(Labels_Hotels.VALUE_ONE)){
                Logger.logStep("Hotels tab is already displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on hotels tab");
        }
    }

    /**
     * Tapping on menu button
     */
    @Override
    public void tapOnMenuButton() {
        Logger.logAction("Tapping on menu button");
        try {
            if (isElementDisplayedByName(MENU_BUTTON)){
                driver.findElementByName(MENU_BUTTON).click();
                Logger.logStep("Tapped on Menu button");
            }else{
                Logger.logError("Menu button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the flights screen name");
        }
    }

    /**
     * Tap on search button
     */
    @Override
    public void tapOnSearchButton(){
        Logger.logAction("Tapping on search button");
        try {
            findElementByXPathAndClick(XPATH_OF_SEARCH_TEXT_FIELD_IN_HOTELS_TAB);
            Logger.logStep("Tapped on search text field");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on hotels search button");
        }
    }

    /**
     * Send keys to search text field
     */
    @Override
    public void sendKeysToSearchResultsScreen(String parsingValue){
        Logger.logAction("Sending keys to search results screen"+parsingValue);
        try {
            sendTextByXpath(XPATH_OF_SEARCH_TEXT_FIELD_IN_SEARCH_PLACE_SCREEN,parsingValue);
            Logger.logStep("Parsed the keys as :- "+parsingValue);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to send keys to search text field");
        }
    }

    /**
     * Tap on first city name in search results
     */
    @Override
    public String tapOnFirstCityNameInSearchResults(String nameOnFirstSearchResults){
        Logger.logAction("Tapping on first city name in search results");
        try {
//            closeTheKeyboard_iOS(); //Todo:- This line of code is to enabled after implementing the close keyboard action only (currently tapping on Done button closes the search view) after tapping on Done button
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Hotels.IOS_ACTIVITY_INDICATOR,1);
            findElementByAccessibilityIdAndClick(nameOnFirstSearchResults);
            Logger.logStep("Tapped on search text field");
            return nameOnFirstSearchResults;
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on first city name in search results");
        }
        return null;
    }

    /**
     * Check the selected city is displayed in hotels search text field
     */
    @Override
    public void checkTheSearchTextFieldIsFilledWithSelectedNameOf(String  parsingValue){
        Logger.logAction("Checking the search text field is filled with the selected name :- "+parsingValue);
        try {
            String nameOnSearchTextField = findElementByXpathAndReturnItsAttributeText(XPATH_OF_SEARCH_TEXT_FIELD_IN_HOTELS_TAB);
            if (nameOnSearchTextField.equalsIgnoreCase(parsingValue)){
                Logger.logStep("Selected country name is displayed in the search text field");
            }else {
                Logger.logComment("Displaying country name in search text field is :- "+nameOnSearchTextField);
                Logger.logComment("Selected country name in search results screen is :- "+parsingValue);
                Logger.logError("Selected country name is not displayed in the search text field");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the value in the search text field of hotels screen");
        }
    }

    /**
     * Tap on check in button
     */
    @Override
    public void tapOnCheckInButton(){
        Logger.logAction("Tapping on check in button");
        try {
            findElementByXPathAndClick(XPATH_OF_CHECK_IN_AND_CHECK_OUT_LAYOUT); //Todo:- Tapping on check in layout as calender view is triggered only by tapping on the layout and not on check in button
            Logger.logStep("Tapped on check in button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on check in button");
        }
    }

    /**
     * Tap on check in button
     */
    @Override
    public void tapOnCheckOutButton(){
        Logger.logAction("Tapping on check out button");
        try {
            findElementByXPathAndClick(XPATH_OF_CHECK_IN_AND_CHECK_OUT_LAYOUT); //Todo:- Tapping on check in layout as calender view is triggered only by tapping on the layout and not on check out button
            Logger.logStep("Tapped on check out button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on check out button");
        }
    }

    /**
     * Tap on check in option in calender view
     */
    @Override
    public void tapOnCheckInOptionInCalendarView(){
        Logger.logAction("Tapping on check in option in calender view");
        try {
            findElementByXPathAndClick(XPATH_OF_CHECK_IN_BUTTON_IN_CALENDER_VIEW);
            Logger.logComment("Tapped on check in option calender view");

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on check in calender view");
        }
    }

    /**
     * Select the departure date
     * @param checkInMonthAndYear
     * @param checkInDay
     */
    @Override
    public void selectCheckInDate(String checkInMonthAndYear, String checkInDay) {
        Logger.logAction("Selecting the check in  date : Month & Year -" + checkInMonthAndYear + ", Day - "+checkInDay);
        int iterations = 0;
        int[] arrayListOfStartingPointLocationXAndY;
        int[] arrayListOfEndingPointLocationXAndY;
        try {
            if (isElementDisplayedByXPath(CALENDER_MODAL_VIEW_XPATH)){
                WebElement calendarView = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                scrollToAnElementByName(calendarView,checkInMonthAndYear,true);
                if (isElementDisplayedByName(checkInMonthAndYear)){
                    if (isElementEnabledByName(checkInDay)) {
                        WebElement calenderView = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                        List<WebElement> checkInDays = calenderView.findElements(By.name(checkInDay));
                        int checkInDaysSize = checkInDays.size();
                        if (checkInDaysSize >= 2){
                            Logger.logComment("More than one similar departure days are displayed in the calender view with same check in day: "+checkInDay+"");
                            if (checkInDaysSize >= 2){
                                Logger.logWarning("More than one similar dates are displayed in the check in calender, so tapping on nearest possible date");
                                for (int count =0;count<=checkInDays.size()-1;count++){
                                    WebElement visibleCheckInDay = checkInDays.get(count);
                                    if (visibleCheckInDay.getAttribute(Labels_Hotels.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Hotels.STATUS_TRUE)){
                                        visibleCheckInDay.click();
                                        Logger.logComment("Tapped on day:- "+checkInDay);
                                    }else
                                    {
                                        continue;
                                    }
                                }
                                String departureMonthName = getTheCheckInMonthDisplayedInCalenderView();
                                String departureDayValue = getTheCheckInDayDisplayedInCalenderView();
                                if (departureMonthName.equalsIgnoreCase(Labels_Hotels.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                    if (departureDayValue.equalsIgnoreCase(checkInDay)){
                                        Logger.logComment("Tapped on correct departure day:- "+checkInDay);
                                    }else {
                                        Logger.logStep("Tapped on incorrect date. So re tapping on the correct check in date");
                                    }
                                }else {
                                    Logger.logStep("Tapped on incorrect date. So re tapping on the correct check in date");
                                    if (iterations <= 3){
                                        iterations++;
                                        arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                        arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView,"center");
                                        driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],1000);
                                        selectCheckInDate(checkInMonthAndYear, checkInDay);
                                    }else {
                                        Logger.logError("Tried "+iterations+" times didn't find the exact date");
                                    }
                                }
                            }else {
                                driver.findElementByName(checkInDay).click();
                                Logger.logComment("Tapped on day:- "+checkInDay);
                            }
                        }else {
                            Logger.logComment("One check in day is displayed in the calender: "+checkInDay+"");
                            driver.findElementByName(checkInDay).click();
                            Logger.logComment("Tapped on day:- "+checkInDay);
                        }
                    }else {
                        Logger.logError("Accurate Date is not displayed in the check in calendar date view");
                    }
                }else{
                    scrollToAnElementByName(calendarView,checkInMonthAndYear,false);
                    if (isElementDisplayedByName(checkInMonthAndYear)){
                        if (isElementEnabledByName(checkInDay)) {
                            WebElement  calenderView = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> checkInDays = calenderView.findElements(By.name(checkInDay));
                            int departureDaysSize = checkInDays.size();
                            if (departureDaysSize >= 2){
                                Logger.logComment("More than one similar check in days are displayed in the calender view with same check in day: "+checkInDay+"");
                                if (departureDaysSize >= 2){
                                    Logger.logWarning("More than one similar check in dates are displayed in the check in calender view, so tapping on nearest possible date");
                                    for (int count =0;count<=checkInDays.size()-1;count++){
                                        WebElement visibleDepartureDay = checkInDays.get(count);
                                        if (visibleDepartureDay.getAttribute(Labels_Hotels.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Hotels.STATUS_TRUE)){
                                            visibleDepartureDay.click();
                                            Logger.logComment("Tapped on day:- "+checkInDay);
                                        }else
                                        {
                                            continue;
                                        }
                                    }
                                    String checkInMonthName = getTheCheckInMonthDisplayedInCalenderView();
                                    String checkInDayValue = getTheCheckInDayDisplayedInCalenderView();
                                    if (checkInMonthName.equalsIgnoreCase(Labels_Hotels.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                        if (checkInDayValue.equalsIgnoreCase(checkInDay)){
                                            Logger.logComment("Tapped on correct check in day:- "+checkInDay);
                                        }else {
                                            Logger.logStep("Tapped on incorrect date. So re tapping on the check in date");
                                        }
                                    }else {
                                        if (iterations <= 3){
                                            iterations++;
                                            arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                            arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView,"center");
                                            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],1000);
                                            selectCheckInDate(checkInMonthAndYear, checkInDay);
                                        }else {
                                            Logger.logError("Tried "+iterations+" times didn't find the exact date");
                                        }
                                    }
                                }else {
                                    driver.findElementByName(checkInDay).click();
                                    Logger.logComment("Tapped on day:- "+checkInDay);
                                }
                            }else {
                                Logger.logComment("One check in day is displayed in the calender: "+checkInDay+"");
                                driver.findElementByName(checkInDay).click();
                                Logger.logComment("Tapped on day:- "+checkInDay);
                            }
                        }else {
                            Logger.logError("Accurate Date is not displayed in the check in calender view");
                        }
                    }else{
                        if (iterations >2){
                            iterations++;
                            Logger.logWarning("Two accurate dates are displayed in the check in calender view , so tapping on nearest possible date");
                            scrollToAnElementByName(calendarView,checkInMonthAndYear,true);
                            if (isElementDisplayedByName(checkInDay)) {
                                driver.findElementByName(checkInDay).click();
                            }else {
                                Logger.logError("Accurate check in date is not displayed in the check in calender view");
                            }
                        }else {
                            Logger.logError("unable to tap on the selected check in date..,tried - " +iterations+" times scrolling");
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
     * Select the return date
     * @param checkOutMonthAndYear
     * @param checkOutDay
     */
    @Override
    public void selectCheckOutDate(String checkOutMonthAndYear, String checkOutDay) {
        Logger.logAction("Selecting the check out date : Month & Year -" + checkOutMonthAndYear + ", Day - "+checkOutDay);
        int iterations = 0;
        int[] arrayListOfStartingPointLocationXAndY;
        int[] arrayListOfEndingPointLocationXAndY;
        try {
            if (isElementDisplayedByXPath(CALENDER_MODAL_VIEW_XPATH)){
                WebElement calendarView = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                scrollToAnElementByName(calendarView,checkOutMonthAndYear,true);
                if (isElementDisplayedByName(checkOutMonthAndYear)){
                    if (isElementEnabledByName(checkOutDay)) {
                        WebElement  calenderView = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                        List<WebElement> checkOutDays = calenderView.findElements(By.name(checkOutDay));
                        int checkOutDaysSize = checkOutDays.size();
                        if (checkOutDaysSize >= 2){
                            Logger.logComment("Two departure days are displayed in the calender view with same check out day: "+checkOutDay+"");
                            if (checkOutDaysSize >= 2){
                                Logger.logWarning("Two accurate dates are displayed in the check out calender view, so tapping on nearest possible check out date");
                                for (int count =0;count<=checkOutDays.size()-1;count++){
                                    WebElement visibleCheckOutDay = checkOutDays.get(count);
                                    if (visibleCheckOutDay.getAttribute(Labels_Hotels.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Hotels.STATUS_TRUE)){
                                        visibleCheckOutDay.click();
                                        Logger.logComment("Tapped on day:- "+visibleCheckOutDay);
                                    }else
                                    {
                                        continue;
                                    }
                                }
                                String checkOutMonthName = getTheCheckOutMonthDisplayedInCalenderView();
                                String checkOutDayValue = getTheCheckOutDayDisplayedInCalenderView();
                                if (checkOutMonthName.equalsIgnoreCase(Labels_Hotels.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                    if (checkOutDayValue.equalsIgnoreCase(checkOutDay)){
                                        Logger.logComment("Tapped on correct check out day:- "+checkOutDay);
                                    }else {
                                        Logger.logStep("Tapped on incorrect check out date. So re tapping on the correct check out date");
                                    }
                                }else {
                                    if (iterations <= 3){
                                        iterations++;
                                        arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                        arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView,"center");
                                        driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],1000);
                                        selectCheckOutDate(checkOutMonthAndYear, checkOutDay);
                                    }else {
                                        Logger.logError("Tried "+iterations+" times didn't find the exact check out date");
                                    }
                                }
                            }else {
                                driver.findElementByName(checkOutDay).click();
                                Logger.logComment("Tapped on day:- "+checkOutDay);
                            }
                        }else {
                            Logger.logComment("One check out day is displayed in the return calender: "+checkOutDay+"");
                            driver.findElementByName(checkOutDay).click();
                        }
                    }else {
                        Logger.logError("Accurate Date is not displayed in the check out calender view");
                    }
                }else{
                    scrollToAnElementByName(calendarView,checkOutMonthAndYear,false);
                    if (isElementDisplayedByName(checkOutMonthAndYear)){
                        if (isElementEnabledByName(checkOutDay)) {
                            WebElement  calenderView = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> checkOutDays = calenderView.findElements(By.name(checkOutDay));
                            int checkOutDaysSize = checkOutDays.size();
                            if (checkOutDaysSize >= 2){
                                Logger.logComment("Two check out days are displayed in the calender view with same return day: "+checkOutDay+"");
                                if (checkOutDaysSize >= 2){
                                    Logger.logWarning("Two accurate dates are displayed in the check out calender view, so tapping on nearest possible date");
                                    for (int count =0;count<=checkOutDays.size()-1;count++){
                                        WebElement visibleReturnDay = checkOutDays.get(count);
                                        if (visibleReturnDay.getAttribute(Labels_Hotels.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Hotels.STATUS_TRUE)){
                                            visibleReturnDay.click();
                                            Logger.logComment("Tapped on day:- "+visibleReturnDay);
                                        }else
                                        {
                                            continue;
                                        }
                                    }
                                    String checkOutMonthName = getTheCheckOutMonthDisplayedInCalenderView();
                                    String checkOutDayValue = getTheCheckOutDayDisplayedInCalenderView();
                                    if (checkOutMonthName.equalsIgnoreCase(Labels_Hotels.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                        if (checkOutDayValue.equalsIgnoreCase(checkOutDay)){
                                            Logger.logComment("Tapped on correct departure day:- "+checkOutDay);
                                        }else {
                                            Logger.logStep("Tapped on incorrect date. So re tapping on the check out date");
                                        }
                                    }else {
                                        if (iterations <= 3){
                                            iterations++;
                                            arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView, "centerRight");
                                            arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(calenderView,"center");
                                            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],1000);
                                            selectCheckOutDate(checkOutMonthAndYear, checkOutDay);
                                        }else {
                                            Logger.logError("Tried "+iterations+" times didn't find the exact date");
                                        }
                                    }
                                }else {
                                    driver.findElementByName(checkOutDay).click();
                                    Logger.logComment("Tapped on day:- "+checkOutDay);
                                }
                            }else {
                                Logger.logComment("One check out day is displayed in the return calender: "+checkOutDay+"");
                                driver.findElementByName(checkOutDay).click();
                            }
                        }else {
                            Logger.logError("Accurate Date is not displayed in the check out calender view");
                        }
                    }
                    else{
                        if (iterations !=1){
                            Logger.logWarning("Two accurate dates are displayed in the check out calender view, so tapping on nearest possible date");
                            scrollToAnElementByName(calendarView,checkOutMonthAndYear,true);
                            if (isElementDisplayedByName(checkOutDay)) {
                                driver.findElementByName(checkOutDay).click();
                            }else {
                                Logger.logError("Accurate Date is not displayed in the check out calender view");
                            }
                        }else {
                            Logger.logError("unable to tap on the selected check out date..,tried - " +iterations);
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
     * Get the departure month displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheCheckInMonthDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the month displayed in the calendar view");
        String departureMonth = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_DEPARTURE_MONTH_IN_CALENDAR_VIEW);
        Logger.logComment("Selected month name in calendar view is :- "+departureMonth);
        return departureMonth;
    }

    /**
     * Get the departure day displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheCheckInDayDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the day displayed in the calendar view");
        String departureDay = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_DEPARTURE_DAY_IN_CALENDAR_VIEW);
        Logger.logComment("Selected day value in calendar view is :- "+departureDay);
        return departureDay;
    }

    /**
     * Get the return month displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheCheckOutMonthDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the month displayed in the calendar view");
        String departureMonth = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_RETURN_MONTH_IN_CALENDAR_VIEW);
        Logger.logComment("Selected month name in calendar view is :- "+departureMonth);
        return departureMonth;
    }

    /**
     * Get the return day displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheCheckOutDayDisplayedInCalenderView() throws Exception {
        Logger.logAction("Getting the day displayed in the calendar view");
        String departureDay = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_RETURN_DAY_IN_CALENDAR_VIEW);
        Logger.logComment("Selected day value in calendar view is :- " + departureDay);
        return departureDay;
    }

    /**
     * Tap on Done button in calendar view
     */
    @Override
    public void tapOnDoneButtonInCalendarView() {
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
     * Tap on adult and child count layout
     */
    @Override
    public void tapOnAdultAndChildLayout(){
        Logger.logAction("Tapping on adult and child count layout");
        try {
            getTheRoomsCountInHotelsHomePage();
            findElementByXPathAndClick(XPATH_OF_ROOMS_AND_GUEST_COUNT_LAYOUT); //Todo:- As interaction is not set for child count layout so tapping on the full layout view of Rooms and guests count
            Logger.logStep("Tapped on adult and child count layout");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on adult and child layout");
        }
    }

    /**
     * Check the rooms list view screen is displayed or not ?
     */
    public boolean isRoomsListViewIsDisplayed(){
        Logger.logAction("Checking the rooms list is displayed");
        try {
            if (isElementDisplayedByAccessibilityId(ROOMS_LIST_VIEW_SCREEN_ACCESSIBILITY_ID)){
                Logger.logComment("Rooms list view screen is displayed");
                return true;
            }else {
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the room list view is displayed or not?");
        }
        return false;
    }

    /**
     * Getting the rooms count in rooms list view
     */
    public Integer getTheRoomsCountInRoomsListView(){
        Logger.logAction("Getting the rooms count in rooms lit view");
        try {
            if (isElementDisplayedByAccessibilityId(ROOMS_STRING)){
                try {
                    for (int count =0; count <5 ; count++){
                        if (isElementDisplayedByXPath(XPATH_OF_CLOSE_BUTTON_OF_ROOM_LAYOUT_WITHOUT_ROOM_INDEX + ROOMS_COUNT_IN_HOTELS_SCREEN + "]")) {
                            ROOMS_COUNT_IN_HOTELS_SCREEN = ROOMS_COUNT_IN_HOTELS_SCREEN+1;
                            ROOMS_COUNT_IN_ROOM_LIST_VIEW = ROOMS_COUNT_IN_ROOM_LIST_VIEW+1;
                        }else {
                            if (count == 0){
                                ROOMS_COUNT_IN_ROOM_LIST_VIEW = 1;
                            }
                            return ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                        }
                    }
                }catch (Exception exception){
                    Logger.logStep("Rooms list view is displaying with count :- "+ROOMS_COUNT_IN_ROOM_LIST_VIEW);
                    return ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the rooms count in rooms list view");
        }
        return null;
    }
    /**
     * Getting the rooms count in hotels home screen
     */
    public Integer getTheRoomsCountInHotelsHomePage(){
        Logger.logAction("Getting the child count in home page");
        try {
            String roomsCount = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_ROOMS_COUNT_IN_HOTELS_SCREEN);
            if (roomsCount.contains(ROOMS_STRING)){
                String roomsCountWithOnlyDecimal = roomsCount.replace(ROOMS_STRING, Labels_Hotels.STRING_NULL).trim();
                ROOMS_COUNT_IN_HOTELS_SCREEN = Integer.valueOf(roomsCountWithOnlyDecimal);
                return ROOMS_COUNT_IN_HOTELS_SCREEN;
            }else {
                Logger.logError("Xpath of the rooms count is wrong, value of the parsed xpath is :- "+roomsCount);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error:- Unable to get the rooms count in home page");
        }
        return null;
    }

    /**
     * Reset the rooms count to default count .ie..1
     * @param roomsCount
     */
    @Override
    public void resetTheRoomsCountToDefaultCount(Integer roomsCount){
        try {
            findElementByXPathAndClick(XPATH_OF_CHECK_IN_AND_CHECK_OUT_LAYOUT);
            for (int count=0; count <= roomsCount;count++){
                Integer roomNumber = count+1;
                String xpathOfCloseButtonOfRoomLayout = XPATH_OF_CLOSE_BUTTON_OF_ROOM_LAYOUT_WITHOUT_ROOM_INDEX+roomNumber+"]";
                findElementByXPathAndClick(xpathOfCloseButtonOfRoomLayout);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to reset the rooms count to default count");
        }
    }

    /**
     * Getting the adult count in hotels home screen
     */
    public Integer getTheAdultCountInHomePage(){
        Logger.logAction("Getting the adult count in home page");
        try {
            String adultCount = findElementByIdAndReturnText(ADULT_COUNT_ID_IN_HOTELS_SCREEN);
            return Integer.parseInt(adultCount);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the adult count in home page");
        }
        return null;
    }

    /**
     * Getting the child count in hotels home screen
     */
    public Integer getTheChildCountInHomePage(){
        Logger.logAction("Getting the child count in home page");
        try {
            String childCount = findElementByIdAndReturnText(CHILD_COUNT_ID_IN_HOTELS_SCREEN);
            return Integer.parseInt(childCount);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the child count in home page");
        }
        return null;
    }

    /**
     * select the guests count
     */
    @Override
    public void setTheGuestCountTo(Integer roomNumber, Integer adultCount, Integer childCount){
        Logger.logAction("Setting the guest count to :- "+roomNumber+","+adultCount+","+childCount);
        try {
            if (isRoomsListViewIsDisplayed()){
                Integer roomsCountInRoomsListView = getTheRoomsCountInRoomsListView();
                if (ROOMS_COUNT_IN_HOTELS_SCREEN == roomsCountInRoomsListView){
                    setTheAdultCountTo(roomNumber, adultCount);
                    setTheChildCountTo(roomNumber,childCount);
                    setTheChildAge(roomNumber,childCount); // Todo:- In this method child age is an random number
                }else {
                    Logger.logError("Rooms count in hotels screen and in rooms list view screen are not same :- "+ROOMS_COUNT_IN_HOTELS_SCREEN);
                }
            }else {
                Logger.logError("Rooms list view screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to set the guests count as :- "+roomNumber+","+adultCount+","+childCount);
        }
    }

    /**
     * Set te adult count in rooms list view
     * @param roomNumber
     * @param adultCount
     */
    public void setTheAdultCountTo(Integer roomNumber, Integer adultCount){
        Logger.logAction("Setting the adult count to :- "+adultCount);
        try {
            Integer countDisplayingWithoutIncrementOrDecrement = getTheAdultCountInTheRoomNumberOf(roomNumber);
            if (countDisplayingWithoutIncrementOrDecrement <= adultCount){
                Integer tapsOnIncrementalButton = adultCount - countDisplayingWithoutIncrementOrDecrement;
                String xpathOfPlusButtonOfParsingRoom = XPATH_OF_ADULT_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH+roomNumber+"]";
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfPlusButtonOfParsingRoom);
                }
                Logger.logStep("For room number "+roomNumber+" adult count is set as :- "+adultCount);
            }else {
                Integer tapsOnIncrementalButton = countDisplayingWithoutIncrementOrDecrement - adultCount;
                String xpathOfMinusButtonOfParsingRoom = XPATH_OF_ADULT_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH+roomNumber+"]";
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfMinusButtonOfParsingRoom);
                }
                Logger.logStep("For room number "+roomNumber+" adult count is set as :- "+adultCount);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to set the adult count as :- "+adultCount);
        }
    }

    /**
     * Getting the adult count in rooms list view
     */
    public Integer getTheAdultCountInTheRoomNumberOf(Integer roomNumber){
        Logger.logAction("Getting the adult count in home page");
        try {
            String xpathOfAdultsCountOfParsingRoomNumber = XPATH_OF_ADULT_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH+roomNumber+"]";
            String adultCountDisplaying = findElementByXpathAndReturnItsAttributeValue(xpathOfAdultsCountOfParsingRoomNumber);
            return Integer.parseInt(adultCountDisplaying);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the adult count in home page");
        }
        return null;
    }

    /**
     * Set te child count in rooms list view
     * @param roomNumber
     * @param childCount
     */
    public void setTheChildCountTo(Integer roomNumber, Integer childCount){
        Logger.logAction("Setting the child count to :- "+childCount);
        try {
            Integer countDisplayingWithoutIncrementOrDecrement = getTheChildCountInTheRoomNumberOf(roomNumber);
            if (countDisplayingWithoutIncrementOrDecrement <= childCount){
                Integer tapsOnIncrementalButton = childCount - countDisplayingWithoutIncrementOrDecrement;
                String xpathOfPlusButtonOfParsingRoom = XPATH_OF_CHILD_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH+roomNumber+"]";
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfPlusButtonOfParsingRoom);
                }
                Logger.logStep("For room number "+roomNumber+" child count is set as :- "+childCount);
            }else {
                Integer tapsOnIncrementalButton = countDisplayingWithoutIncrementOrDecrement - childCount;
                String xpathOfMinusButtonOfParsingRoom = XPATH_OF_CHILD_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH+roomNumber+"]";
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfMinusButtonOfParsingRoom);
                }
                Logger.logStep("For room number "+roomNumber+" child count is set as :- "+childCount);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to set the child count as :- "+childCount);
        }
    }

    /**
     * Getting the child count in rooms list view
     */
    public Integer getTheChildCountInTheRoomNumberOf(Integer roomNumber){
        Logger.logAction("Getting the child count in home page");
        try {
            String xpathOfChildCountOfParsingRoomNumber = XPATH_OF_CHILD_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH+roomNumber+"]";
            String adultCountDisplaying = findElementByXpathAndReturnItsAttributeValue(xpathOfChildCountOfParsingRoomNumber);
            return Integer.parseInt(adultCountDisplaying);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the child count in home page");
        }
        return null;
    }

    /**
     * Set te child count in rooms list view
     * @param childCount
     */
    public void setTheChildAge(Integer roomNumber, Integer childCount){
        Logger.logAction("Setting the child count to :- "+childCount);
        try {
            for (int count=0 ; childCount<childCount; count++){
                Integer randomNumber = getTheRandomValue(7);
                String xpathOfChildAge = XPATH_OF_CHILD_AGE_CELL_NUMBER_WITHOUT_ROOM_CELL_NUMBER_XPATH+randomNumber+"]";
                    findElementByXPathAndClick(xpathOfChildAge);
                Logger.logStep("For room number "+roomNumber+", tapped on child age of :- "+randomNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to set the child count as :- "+childCount);
        }
    }

    /**
     * Tap on add room button
     */
    @Override
    public void tapOnAddRoomButton(){
        Logger.logAction("Tapping on add room button");
        try {
            findElementByAccessibilityIdAndClick(ADD_ROOM_BUTTON);
            Logger.logStep("Tapped on add room button");
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to tap on add room button");
        }
    }
    /**
     * Tap on done button on room list view
     */
    @Override
    public void tapOnDoneButtonOnRoomListView(){
        Logger.logAction("Tap on done button");
        try {
            findElementByAccessibilityIdAndClick(DONE_BUTTON_IN_ROOM_LIST_VIEW);
            Logger.logStep("Tapped on done button");
        }catch (Exception exception){
            Logger.logError("Encountered error:- unable to tap on done button");
        }
    }

    /**
     * Tap on check availability button
     */
    @Override
    public void tapOnCheckAvailabilityButton(){
        Logger.logAction("Tapping on check availability button ");
        try {
            findElementByAccessibilityIdAndClick(CHECK_AVAILABILITY_BUTTON_ID);
            Logger.logStep("Tapped on check availability button");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on check availability button");
        }
    }


}
