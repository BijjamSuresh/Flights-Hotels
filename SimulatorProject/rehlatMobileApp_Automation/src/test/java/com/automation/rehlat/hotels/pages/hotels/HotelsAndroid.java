package com.automation.rehlat.hotels.pages.hotels;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.awt.event.KeyEvent;
import java.util.List;

import static com.automation.rehlat.hotels.Labels_Hotels.*;


public class HotelsAndroid extends HotelsBase {

    public static final String TAB_VIEW_ID = "com.app.rehlat:id/tab";
    public static final String HOTELS_TAB_ID ="Hotels";
    public static final String SEARCH_TEXT_FIELD_ID_IN_HOTELS_HOME_SCREEN = "com.app.rehlat:id/search_edit_text";
    public static final String SEARCH_TEXT_FIELD_ID_IN_HOTELS_SEARCH_SCREEN = "com.app.rehlat:id/searchFlightEditText";
    public static final String XPATH_OF_FIRST_CITY_NAME_IN_SEARCH_RESULTS = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
    public static final String CHECK_IN_BUTTON_ID_IN_HOTELS_HOME_SCREEN = "com.app.rehlat:id/hotelCheckInLayout";
    public static final String CHECK_OUT_BUTTON_ID_IN_HOTELS_HOME_SCREEN = "com.app.rehlat:id/hotelCheckoutlayout";
    public static final String CHECK_IN_BUTTON_ID_IN_CALENDER_VIEW = "com.app.rehlat:id/onwardJrnDialogLayout";
    public static final String CHECK_OUT_BUTTON_ID_IN_CALENDER_VIEW = "com.app.rehlat:id/returnJrnDialogLayout";
    public static final String CALENDER_MODAL_VIEW = "com.app.rehlat:id/calendar_view";
    public static final String MENU_BUTTON = "com.app.rehlat:id/hotel_menuclick";
    public static final String CALENDER_VIEW_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ListView/";
    public static final String DONE_BUTTON_IN_CALENDAR_VIEW = "com.app.rehlat:id/hotel_calender_done";
    public static final String ADULT_COUNT_ID_IN_HOTELS_SCREEN = "com.app.rehlat:id/adultscount_txt";
    public static final String CHILD_COUNT_ID_IN_HOTELS_SCREEN = "com.app.rehlat:id/childrencount_txt";
    public static final String ROOMS_COUNT_ID_IN_HOTELS_SCREEN = "com.app.rehlat:id/roomscount_txt";
    public static final String ADULTS_AND_CHILD_COUNT_LAYOUT_ID = "com.app.rehlat:id/adults_and_child_layout";
    public static final String ROOMS_LIST_VIEW_SCREEN_ID = "com.app.rehlat:id/add_room_rlyt";
    public static final String ADD_ROOM_BUTTON = "com.app.rehlat:id/add_room_btn";
    public static final String DONE_BUTTON_IN_ROOM_LIST_VIEW = "com.app.rehlat:id/done_btn";
    public static final String MINUS_BUTTON_ID_OF_CHILDREN = "com.app.rehlat:id/child_removing";
    public static final String PLUS_BUTTON_ID_OF_CHILDREN = "com.app.rehlat:id/child_adding";
    public static final String XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[";
    public static final String XPATH_OF_CHILD_AGE_FRAME_NUMBER_LABEL_WITHOUT_ROOM_INDEX_AND_WITHOUT_AGE_NUMBER = "]/android.widget.FrameLayout[";
    public static final String XPATH_OF_ADULT_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]";
    public static final String XPATH_OF_ADULT_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[3]";
    public static final String XPATH_OF_ADULT_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String XPATH_OF_CHILD_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]";
    public static final String XPATH_OF_CHILD_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[3]";
    public static final String XPATH_OF_CHILD_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH = "/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String XPATH_OF_CHILD_AGE_FIRST_CELL_NUMBER_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";
    public static final String XPATH_OF_CHILD_AGE_CELL_NUMBER_EXCEPT_FIRST_CHILD_AGE_CELL_WITHOUT_ROOM_CELL_NUMBER_XPATH = "]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";
    public static final String CHECK_AVAILABILITY_BUTTON_ID = "com.app.rehlat:id/checkavailability_btn";
    public static final String XPATH_OF_CLOSE_BUTTON_OF_ROOM_LAYOUT_WITHOUT_ROOM_INDEX = "]/android.widget.RelativeLayout/android.widget.ImageView";
    public static final String XPATH_OF_COUNTRY_NAME = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[";
    public static final String DOMAIN_LIST_VIEW = "com.app.rehlat:id/domainListView";
    public static final String OTHER_COUNTRY_OPTION ="Other";
    public static final String BOOK_NOW_BUTTON_IN_PROMOTIONAL_DIALOG = "com.app.rehlat:id/promotionalMessageBookNowTextView";
    public static final String DEPARTURE_DAY_IN_CALENDAR_VIEW = "com.app.rehlat:id/onwardDayDialogTextView";
    public static final String DEPARTURE_MONTH_IN_CALENDAR_VIEW = "com.app.rehlat:id/onwardMonthDialogTextView";
    public static final String RETURN_DAY_IN_CALENDAR_VIEW = "com.app.rehlat:id/returnDayDialogTextView";
    public static final String RETURN_MONTH_IN_CALENDAR_VIEW = "com.app.rehlat:id/returnMonthDialogTextView";
    public Integer ROOMS_COUNT_IN_HOTELS_SCREEN;
    public Integer ROOMS_COUNT_IN_ROOM_LIST_VIEW = 1;
    public Integer TOTAL_VISIBLE_ROOM_CELLS_COUNT;
    public Integer GUEST_SETTING_ROOM_CELL_NUMBER;

    /**
     * check is hotels screen is displayed
     */
    @Override
    public void checkHotelScreenISDisplayed(){
        Logger.logAction("Check hotel screen is displayed");
        try {
            runAppInBackground(1);
            Thread.sleep(3000);
            closeThePromotionalDialogIfDisplayed();
            if (isElementDisplayedById(CHECK_IN_BUTTON_ID_IN_HOTELS_HOME_SCREEN) && isElementDisplayedById(CHECK_OUT_BUTTON_ID_IN_HOTELS_HOME_SCREEN)){
                Logger.logStep("Hotels screen is displayed");
            }else {
                Logger.logError("Hotels screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the hotel screen is displayed or not?");
        }
    }

    /**
     * Close the promotional dialog
     */
    public static void closeThePromotionalDialogIfDisplayed(){
        Logger.logAction("Closing the promotional dialog if displayed");
        try {
            boolean status = findElementByIdAndClick(BOOK_NOW_BUTTON_IN_PROMOTIONAL_DIALOG);
            if (status == true){
                Logger.logStep("Promotional dialog is displayed and closed it by tapping on book now button");
            }else {
                Logger.logComment("Promotional dialog is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error:- Unable to close the promotional dialog");
        }
    }

    /**
     * Tap on hotels tab
     */
    @Override
    public void tapOnHotelsTab(){
        Logger.logAction("Tapping on hotels tab");
        try {
            runAppInBackground(1);
            Thread.sleep(3000);
            List<WebElement> tabsList = driver.findElementsById(TAB_VIEW_ID);
            for (int count=0;count<=tabsList.size()-1;count++){
                String tabName = tabsList.get(count).getText();
                if (tabName.equalsIgnoreCase(HOTELS_TAB_ID)){
                    tabsList.get(count).click();
                    Logger.logStep("Hotels tab is selected");
                    break;
                }
                if (count == tabsList.size()-1){
                    Logger.logError("Hotels tab is not displayed in the tabs list");
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
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
            if (isElementDisplayedById(MENU_BUTTON)){
                driver.findElement(By.id(MENU_BUTTON)).click();
                Logger.logStep("Menu button is tapped");
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
            findElementByIdAndClick(SEARCH_TEXT_FIELD_ID_IN_HOTELS_HOME_SCREEN);
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
        Logger.logAction("Sending keys to search results screen - "+parsingValue);
        try {
            sendTextById(SEARCH_TEXT_FIELD_ID_IN_HOTELS_SEARCH_SCREEN,parsingValue);
            Logger.logStep("Parsed the keys as :- "+parsingValue);
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Hotels.ANDROID_ACTIVITY_INDICATOR,1);
            closeTheKeyboard_Android();
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
            String firstCountryNameInSearchResults = findElementByXpathAndReturnItsAttributeText(XPATH_OF_FIRST_CITY_NAME_IN_SEARCH_RESULTS);
            if (firstCountryNameInSearchResults.matches(nameOnFirstSearchResults)){
                findElementByXPathAndClick(XPATH_OF_FIRST_CITY_NAME_IN_SEARCH_RESULTS);
                Logger.logStep("Tapped on search text field");
                return firstCountryNameInSearchResults;
            }else {
                Logger.logError("First result name is not matching with the parsing country name :- "+firstCountryNameInSearchResults+" ---- "+nameOnFirstSearchResults);
            }
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
            runAppInBackground(1);
            scrollToAnElementById_ANDROID(SEARCH_TEXT_FIELD_ID_IN_HOTELS_HOME_SCREEN,false,8);// This method needs to be removed after fixing the hotels layout issue on selecting the hotel from search view.ie.., Hotels Screen goes up after selecting the hotels search
            String nameOnSearchTextField = findElementByIdAndReturnText(SEARCH_TEXT_FIELD_ID_IN_HOTELS_HOME_SCREEN);
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
            findElementByIdAndClick(CHECK_IN_BUTTON_ID_IN_HOTELS_HOME_SCREEN);
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
            findElementByIdAndClick(CHECK_OUT_BUTTON_ID_IN_HOTELS_HOME_SCREEN);
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
        Logger.logAction("Tapping on check in option in the calender view");
        try {
            boolean status = findElementByIdAndClick(CHECK_IN_BUTTON_ID_IN_CALENDER_VIEW);
            if (status == true){
                Logger.logComment("Tapped on check in option in the calender view");
            }else {
                Logger.logError("Didn't tapped on check in option in the calender view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on check in option in the calender view");
        }
    }

    /**
     * Tap on check out option in calender view
     */
    @Override
    public void tapOnCheckOutOptionInCalendarView(){
        Logger.logAction("Tapping on check out option in the calender view");
        try {
            boolean status = findElementByIdAndClick(CHECK_OUT_BUTTON_ID_IN_CALENDER_VIEW);
            if (status == true){
                Logger.logComment("Tapped on check out option in the calender view");
            }else {
                Logger.logError("Didn't tapped on check out option in the calender view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on check out option in the calender view");
        }
    }

    /**
     * Select Departure date
     */
    @Override
    public void selectCheckInDate(String checkInMonthAndYear, String checkInDay) {
        Logger.logAction("Selecting the departure date : Month & Year - " + checkInMonthAndYear + ", Day - "+checkInDay);
        try {
            if (isElementDisplayedById(CALENDER_MODAL_VIEW)){
                tapOnCheckInOptionInCalendarView();
                if (!isParsingCalenderMonthIsDisplayed(checkInMonthAndYear)){ // Todo:- This if condition code is to reset the calender view to current running date when the displaying date is not an required selecting date
                    scrollToTheParsingCalendarMonthAndYear(CURRENT_RUNNING_MONTH,false);
                }
                scrollToTheParsingCalendarMonthAndYear(checkInMonthAndYear,true);
                if (isParsingCalenderMonthIsDisplayed(checkInMonthAndYear)){
                    tapOnDayInTheCalender("ONWARD", checkInMonthAndYear, checkInDay);
                }else {
                    scrollToTheParsingCalendarMonthAndYear(checkInMonthAndYear,false);
                    if (isParsingCalenderMonthIsDisplayed(checkInMonthAndYear)){
                        tapOnDayInTheCalender("ONWARD", checkInMonthAndYear, checkInDay);
                    }else {
                        Logger.logWarning("Unable to select the accurate departure date :- " +checkInDay+ "," + checkInMonthAndYear+"..., Going with the random selected date after scrolling the calender view");
                        scrollTheCalenderPageDownAMonthGap_Android();
                        tapOnDayInTheCalender("ONWARD", checkInMonthAndYear, checkInDay);
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
     * Select Return date
     */
    @Override
    public void selectCheckOutDate(String checkOutMonthAndYear, String checkOutDay) {
        Logger.logAction("Selecting the departure date : Month & Year - " + checkOutMonthAndYear + ", Day - "+checkOutDay);
        try {
            if (isElementDisplayedById(CALENDER_MODAL_VIEW)){
                tapOnCheckOutOptionInCalendarView();
                scrollToTheParsingCalendarMonthAndYear(checkOutMonthAndYear,true);
                if (isParsingCalenderMonthIsDisplayed(checkOutMonthAndYear)){
                    tapOnDayInTheCalender("RETURN", checkOutMonthAndYear, checkOutDay);
                }else {
                    scrollToTheParsingCalendarMonthAndYear(checkOutMonthAndYear,false);
                    if (isParsingCalenderMonthIsDisplayed(checkOutMonthAndYear)){
                        tapOnDayInTheCalender("RETURN", checkOutMonthAndYear, checkOutDay);
                    }else {
                        Logger.logWarning("Unable to select the accurate return date :- " +checkOutDay+ "," + checkOutMonthAndYear+"..., Going with the default selected date");
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
     * Tap on the parsing day in the displayed calender
     * @param parsingMonthAndYear
     * @param parsingDay
     */
    public static void tapOnDayInTheCalender(String journeyType, String parsingMonthAndYear, String parsingDay) {
        Logger.logAction("Trying to tap on the day "+parsingDay+" in the calender view");
        int iterations = 0;
        boolean parsingDateSelectionStatus = false;
        String departureMonthName = Labels_Hotels.STRING_NULL;
        String departureDayValue = Labels_Hotels.STRING_NULL;
        try{
            WebElement calenderView = driver.findElementById(CALENDER_MODAL_VIEW);
            try {
                List<WebElement> monthTitle = calenderView.findElements(By.className(ANDROID_LINEAR_LAYOUT));
                while (iterations < 7)
                {
                    if (!(iterations == 0)){
                        scrollTheCalenderPageUpByDaysGap_Android();
                    }
                    for (int index = 0; index <= monthTitle.size()-1; index++)
                    {
                        try{
                            WebElement monthCalenderLayout = monthTitle.get(index);
                            WebElement monthCalenderTitleLayout = monthCalenderLayout.findElement(By.className(Labels_Hotels.ANDROID_TEXT_VIEW));
                            String monthCalenderTitleValue = monthCalenderTitleLayout.getText();
                            if (monthCalenderTitleValue.equals(parsingMonthAndYear)){
                                WebElement daysCalenderLayout = monthCalenderLayout.findElement(By.className(ANDROID_VIEW_GROUP));
                                List<WebElement> groupViewOfDaysIncludingRows = daysCalenderLayout.findElements(By.className(ANDROID_VIEW_GROUP));
                                for (int row = 0; row <= groupViewOfDaysIncludingRows.size()-1; row++) {
                                    WebElement eachRowInaGroupView = groupViewOfDaysIncludingRows.get(row);
                                    List<WebElement> listOfRowsInMonthCalender = eachRowInaGroupView.findElements(By.className(Labels_Hotels.ANDROID_TEXT_VIEW));
                                    for (int text = 0; text <= listOfRowsInMonthCalender.size()-1; text++) {
                                        String valueOfEachDay = listOfRowsInMonthCalender.get(text).getText();
                                        if (valueOfEachDay.equals(parsingDay)){
                                            index = index+1;
                                            row = row+1;
                                            text = text+1;
                                            String xpathOfDay = CALENDER_VIEW_XPATH+"android.widget.LinearLayout["+index+"]/"+"android.view.ViewGroup/android.view.ViewGroup["+row+"]/"+"android.widget.TextView["+text+"]";
                                            WebElement locationOfDay = driver.findElement(By.xpath(xpathOfDay));
                                            Point table = locationOfDay.getLocation();
                                            int elementYAxisValue = table.getY();
                                            if (Labels_Hotels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_80_PERCENT >= elementYAxisValue)
                                            {
                                                locationOfDay.click();
                                            }else {
                                                for (int count =0 ; count <=5; count++){
                                                    scrollTheCalenderPageUpByDaysGap_Android();
                                                    WebElement locationOfDayAfterScrolling = driver.findElement(By.xpath(xpathOfDay));
                                                    Point tableAfterScrolling = locationOfDayAfterScrolling.getLocation();
                                                    int elementYAxisValueAfterScrolling = tableAfterScrolling.getY();
                                                    if (Labels_Hotels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_80_PERCENT >= elementYAxisValueAfterScrolling)
                                                    {
                                                        locationOfDayAfterScrolling.click();
                                                        break;
                                                    }
                                                }
                                            }
                                            if (journeyType == "ONWARD"){
                                                departureMonthName = getTheDepartureMonthDisplayedInCalenderView().trim();
                                                departureDayValue = getTheDepartureDayDisplayedInCalenderView().trim();
                                            }else if (journeyType == "RETURN"){
                                                departureMonthName = getTheReturnMonthDisplayedInCalenderView().trim();
                                                departureDayValue = getTheReturnDayDisplayedInCalenderView().trim();
                                            }else {
                                                Logger.logError("Parsing journey type is neither onward nor return");
                                            }
                                            if (departureMonthName.equalsIgnoreCase(Labels_Hotels.DEPARTURE_MONTH_IN_CALENDAR_VIEW)){
                                                if (Integer.valueOf(departureDayValue) == Integer.valueOf(parsingDay)){
                                                    Logger.logComment("Tapped on correct departure day:- "+parsingDay);
                                                    parsingDateSelectionStatus = true;
                                                    break;
                                                }else {
                                                    Logger.logStep("Tapped on incorrect date. So re tapping on the departure date");
                                                }
                                            }else {
                                                Logger.logStep("Tapped on incorrect date. So re tapping on the departure date");
                                                if (iterations <= 6){
                                                }else {
                                                    Logger.logError("Tried "+iterations+" times didn't find the exact date");
                                                }
                                            }
                                        }else {
                                            continue;
                                        }
                                    }
                                    if (parsingDateSelectionStatus == true){
                                        iterations = 7;
                                        break;
                                    }
                                }
                            }else {
                                continue;
                            }
                            if (parsingDateSelectionStatus == true){
                                iterations = 7;
                            }

                        }catch (Exception exception){
                            if (parsingDateSelectionStatus == true){
                                iterations = 7;
                            }
                        }
                    }
                    if (parsingDateSelectionStatus == true){
                        iterations = 7;
                        break;
                    }
                    else {
                        iterations ++;
                    }
                }
            }catch (Exception exception){
                if (parsingDateSelectionStatus == true){
                    iterations = 7;
                }
                else {
                    iterations ++;
                }
            }
            if (parsingDateSelectionStatus == true){
                Logger.logComment("Tapped on correct date and going for next action");
            }else {
                Logger.logError("Tapped on in-correct date");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the calender day");
        }
    }

    /**
     * Checking the parsing flight booking month and year is displayed or not
     * @param flightBookingMonthAndYear
     * @return
     */
    public static boolean isParsingCalenderMonthIsDisplayed(String flightBookingMonthAndYear) {
        Logger.logAction("Checking the parsing calender month "+flightBookingMonthAndYear+" is displayed or not ?");
        try {
            Thread.sleep(WAIT_TIME_MIN);
            WebElement calenderView = driver.findElementById(CALENDER_MODAL_VIEW);
            try{
                List<WebElement> linearLayout = calenderView.findElements(By.className(ANDROID_LINEAR_LAYOUT));
                for (int index =0; index <= linearLayout.size()-1;index++){
                    if (linearLayout.get(index).findElement(By.className(Labels_Hotels.ANDROID_TEXT_VIEW)).isDisplayed()){
                        WebElement calenderMonth = linearLayout.get(index).findElement(By.className(Labels_Hotels.ANDROID_TEXT_VIEW));
                        String nameOfEachTextView = calenderMonth.getText();
                        if (nameOfEachTextView.equals(flightBookingMonthAndYear)){
                            Logger.logComment(flightBookingMonthAndYear+" - calender month is displayed");
                            return true;
                        }else {
                            Logger.logComment(flightBookingMonthAndYear+" - calender month is not matching with -"+nameOfEachTextView);
                        }
                    }else {
                        continue;
                    }
                }
            }catch (Exception exception){
                scrollTheCalenderPageUpByDaysGap_Android();
                isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the month :- " +flightBookingMonthAndYear);
        }
        return false;
    }

    /**
     * Scrolling to the parsing flight booking month and year
     * @param flightBookingMonthAndYear
     * @param down
     */
    public static void scrollToTheParsingCalendarMonthAndYear(String flightBookingMonthAndYear, boolean down ) {
        Logger.logAction("Scrolling the calender view to the parsing flight booking month and year :- " +flightBookingMonthAndYear);
        try {
            if(!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                int counter = 0;
                if (down) {
                    while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling down ");
                        scrollTheCalenderPageUpByAMonthGap_Android();
                        counter++;
                        if (counter > 10) {
                            break;
                        }
                    }
                    if (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                            Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling up ");
                            scrollTheCalenderPageDownAMonthGap_Android();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                } else {
                    while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling up ");
                        scrollTheCalenderPageDownAMonthGap_Android();
                        counter++;
                        if (counter > 10) {
                            break;
                        }
                    }
                    if (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling down ");
                        while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                            scrollTheCalenderPageUpByAMonthGap_Android();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                }
            }else {
                Logger.logComment(flightBookingMonthAndYear+ " - Parsing  flight booking month is displayed in the current calender view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the parsing calendar month and year of :- " +flightBookingMonthAndYear);
        }
    }

    /**
     * Tap on Done button in calendar view
     */
    @Override
    public void tapOnDoneButtonInCalendarView() {
        Logger.logAction("Tapping on Done button");
        try {
            if (isElementDisplayedById(DONE_BUTTON_IN_CALENDAR_VIEW)){
                driver.findElementById(DONE_BUTTON_IN_CALENDAR_VIEW).click();
                Logger.logStep("Tapped on Done button");
                runAppInBackground(1);
                Thread.sleep(3000);
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
            findElementByIdAndClick(ADULTS_AND_CHILD_COUNT_LAYOUT_ID);
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
            if (isElementDisplayedById(ROOMS_LIST_VIEW_SCREEN_ID)){
                Logger.logStep("Rooms list view screen is displayed");
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
            ROOMS_COUNT_IN_HOTELS_SCREEN = 1;
            ROOMS_COUNT_IN_ROOM_LIST_VIEW = 1;
            if (isElementDisplayedByXPath(XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+ROOMS_COUNT_IN_HOTELS_SCREEN+"]")){
                try {
                    for (int count =0; count <5 ; count++){
                        if (isElementDisplayedByXPath(XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX + ROOMS_COUNT_IN_HOTELS_SCREEN + "]")) {
                            ROOMS_COUNT_IN_HOTELS_SCREEN++;
                            ROOMS_COUNT_IN_ROOM_LIST_VIEW++;
                        }else {
                            ROOMS_COUNT_IN_HOTELS_SCREEN--;
                            ROOMS_COUNT_IN_ROOM_LIST_VIEW--;
                            TOTAL_VISIBLE_ROOM_CELLS_COUNT = ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                            return ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                        }
                    }
                    ROOMS_COUNT_IN_HOTELS_SCREEN--;
                    ROOMS_COUNT_IN_ROOM_LIST_VIEW--;
                    TOTAL_VISIBLE_ROOM_CELLS_COUNT = ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                    return ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                }catch (Exception exception){
                    Logger.logStep("Rooms list view is displaying with count :- "+ROOMS_COUNT_IN_ROOM_LIST_VIEW);
                    ROOMS_COUNT_IN_HOTELS_SCREEN--;
                    ROOMS_COUNT_IN_ROOM_LIST_VIEW--;
                    TOTAL_VISIBLE_ROOM_CELLS_COUNT = ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                    return ROOMS_COUNT_IN_ROOM_LIST_VIEW;
                }
            }else {
                Logger.logError("Rooms list view is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the rooms count in rooms list view");
        }
        return null;
    }
    /**
     * Getting the rooms count in hotels home screen and setting to
     */
    public Integer setTheRoomsCountToDefault(){
        Logger.logAction("Setting the child count in home page to default .i.e.., one room");
        try {
            HotelsScreen.tapOnDoneButtonOnRoomListView();
            String roomsCount = findElementByIdAndReturnText(ROOMS_COUNT_ID_IN_HOTELS_SCREEN);
            ROOMS_COUNT_IN_HOTELS_SCREEN = Integer.parseInt(roomsCount);
            if (ROOMS_COUNT_IN_HOTELS_SCREEN >1){
                resetTheRoomsCountToDefaultCount(Integer.valueOf(roomsCount));
//                roomsCount = "1";
            }else if (ROOMS_COUNT_IN_HOTELS_SCREEN == 1 ){
                Logger.logComment("Rooms count in hotels home page is default");
                roomsCount = "1";
            }else {
                Logger.logError("Rooms count is neither one nor greater than one");
            }
            return Integer.parseInt(roomsCount);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the rooms count in home page");
        }
        return null;
    }


    /**
     * Reset the rooms count to default count .ie..1 room
     * @param roomsCount
     */
    @Override
    public void resetTheRoomsCountToDefaultCount(Integer roomsCount){
        Logger.logAction("Resetting the rooms count to default");
        try {
            findElementByIdAndClick(ADULTS_AND_CHILD_COUNT_LAYOUT_ID);
            for (int count=roomsCount; count <= roomsCount;count--){
//                Integer roomNumber = count;
                if (count == 1){
                    Logger.logComment("Re-set the rooms count to default. ie.., one room");
                    break;
                }else {
                    String xpathOfCloseButtonOfRoomLayout = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+2+XPATH_OF_CLOSE_BUTTON_OF_ROOM_LAYOUT_WITHOUT_ROOM_INDEX;
                    findElementByXPathAndClick(xpathOfCloseButtonOfRoomLayout);
                }
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
        Logger.logAction("Setting the guest count to :- " +roomNumber+","+adultCount+","+childCount);
        try {
            Integer roomsCountInRoomsListView = 1;
            if (isRoomsListViewIsDisplayed()){
                roomsCountInRoomsListView = getTheRoomsCountInRoomsListView();
                if (roomNumber == 1){
                    if (roomsCountInRoomsListView ==1 ){
                        Logger.logComment("Rooms count is set to default ie.., One room");
                    }else {
                        setTheRoomsCountToDefault();
                    }
                }
                GUEST_SETTING_ROOM_CELL_NUMBER = roomNumber ;
                if (TOTAL_VISIBLE_ROOM_CELLS_COUNT < roomNumber){
                    roomNumber = TOTAL_VISIBLE_ROOM_CELLS_COUNT;
                }
                    setTheAdultCountTo(roomNumber, adultCount);
                    setTheChildCountTo(roomNumber,childCount);
                    setTheChildAge(roomNumber,childCount); // Todo:- In this method child age is an random number
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
        String xpathOfPlusButtonOfParsingRoom;
        try {
            Integer countDisplayingWithoutIncrementOrDecrement =  getTheAdultCountInTheRoomNumberOf(roomNumber);
            if (countDisplayingWithoutIncrementOrDecrement <= adultCount){
                Integer tapsOnIncrementalButton = adultCount - countDisplayingWithoutIncrementOrDecrement;
                xpathOfPlusButtonOfParsingRoom = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_ADULT_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH;
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfPlusButtonOfParsingRoom);
                    Logger.logStep("For room number "+GUEST_SETTING_ROOM_CELL_NUMBER+" adult count is set as :- "+adultCount);
                }
            }else {
                //Todo:- Write a method to tap on minus button of fourth and fifth rooms also
                Integer tapsOnIncrementalButton = countDisplayingWithoutIncrementOrDecrement - adultCount;
                String xpathOfMinusButtonOfParsingRoom = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_ADULT_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH;
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfMinusButtonOfParsingRoom);
                }
                Logger.logStep("For room number "+GUEST_SETTING_ROOM_CELL_NUMBER+" adult count is set as :- "+adultCount);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to set the adult count as :- "+adultCount);
        }
    }

    /**
     * Getting the adult count in rooms list view 
     */
    public Integer getTheAdultCountInTheRoomNumberOf(Integer roomNumber){
        Logger.logAction("Getting the adult count in room list");
        String xpathOfAdultsCountOfParsingRoomNumber;
        try {
            xpathOfAdultsCountOfParsingRoomNumber = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_ADULT_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH;
            String adultCountDisplaying = findElementByXpathAndReturnItsAttributeText(xpathOfAdultsCountOfParsingRoomNumber);
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
        String xpathOfPlusButtonOfParsingRoom;
        try {
            Integer countDisplayingWithoutIncrementOrDecrement = getTheChildCountInTheRoomNumberOf(roomNumber);
            if (roomNumber ==1){
                for (int tapCount = 0; tapCount < countDisplayingWithoutIncrementOrDecrement; tapCount++){
                    findElementByIdAndClick(MINUS_BUTTON_ID_OF_CHILDREN);
                }
                for (int tapCount = 0; tapCount < childCount; tapCount++){
                    findElementByIdAndClick(PLUS_BUTTON_ID_OF_CHILDREN);
                }
            }else
            {
                //Todo:- Above if condition can be removed when the below logic works by the selected age element attribute is set as true, until then the child count is resetting to zero
            if (countDisplayingWithoutIncrementOrDecrement <= childCount){
                Integer tapsOnIncrementalButton = childCount - countDisplayingWithoutIncrementOrDecrement;
                xpathOfPlusButtonOfParsingRoom = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_CHILD_PLUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH;
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfPlusButtonOfParsingRoom);
                    Logger.logStep("For room number "+GUEST_SETTING_ROOM_CELL_NUMBER+" child count is set as :- "+childCount);
                }
            }else {
                //Todo:- Write a method to tap on minus button of fourth and fifth rooms also
                Integer tapsOnIncrementalButton = countDisplayingWithoutIncrementOrDecrement - childCount;
                String xpathOfMinusButtonOfParsingRoom = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_CHILD_MINUS_BUTTON_WITHOUT_ROOM_CELL_NUMBER_XPATH;
                for (int tapCount = 0; tapCount < tapsOnIncrementalButton; tapCount++){
                    findElementByXPathAndClick(xpathOfMinusButtonOfParsingRoom);
                }
                Logger.logStep("For room number "+GUEST_SETTING_ROOM_CELL_NUMBER+" child count is set as :- "+childCount);
            }
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
        String xpathOfChildCountOfParsingRoomNumber;
        try {
            xpathOfChildCountOfParsingRoomNumber = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_CHILD_COUNT_WITHOUT_ROOM_CELL_NUMBER_XPATH;
            String adultCountDisplaying = findElementByXpathAndReturnItsAttributeText(xpathOfChildCountOfParsingRoomNumber);
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
            String xpathOfChildAge;
            for (int count=0 ; count<childCount; count++){
                Integer randomNumber = getTheRandomValue(7); // Todo:- Implemented random number in 7 only because child age forward button is not labeled from second room view onwards
                if (randomNumber ==0){
                    randomNumber = 2;
                }
                Integer childAgeFrameCount = count+1;
                if (childAgeFrameCount == 1){
                    xpathOfChildAge = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_CHILD_AGE_FRAME_NUMBER_LABEL_WITHOUT_ROOM_INDEX_AND_WITHOUT_AGE_NUMBER+childAgeFrameCount+XPATH_OF_CHILD_AGE_FIRST_CELL_NUMBER_WITHOUT_ROOM_CELL_NUMBER_XPATH+randomNumber+"]";
                }else {
                    xpathOfChildAge = XPATH_OF_ROOM_NUMBER_LABEL_WITHOUT_INDEX+roomNumber+XPATH_OF_CHILD_AGE_FRAME_NUMBER_LABEL_WITHOUT_ROOM_INDEX_AND_WITHOUT_AGE_NUMBER+childAgeFrameCount+XPATH_OF_CHILD_AGE_CELL_NUMBER_EXCEPT_FIRST_CHILD_AGE_CELL_WITHOUT_ROOM_CELL_NUMBER_XPATH+randomNumber+"]";
                }
                findElementByXPathAndClick(xpathOfChildAge);
                Logger.logStep("For room number "+GUEST_SETTING_ROOM_CELL_NUMBER+" and child number "+childAgeFrameCount+", tapped on child age of :- "+randomNumber);
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
            Thread.sleep(2000);
            findElementByIdAndClick(ADD_ROOM_BUTTON);
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
        Logger.logAction("Tap on done button in the room list view");
        try {
            findElementByIdAndClick(DONE_BUTTON_IN_ROOM_LIST_VIEW);
            runAppInBackground(1);
            Logger.logStep("Tapped on done button in the room list view");
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
            findElementByIdAndClick(CHECK_AVAILABILITY_BUTTON_ID);
            Logger.logStep("Tapped on check availability button");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on check availability button");
        }
    }

    /**
     * Set the domain as per the parsing domain
     * @param parsingDomain
     */
    @Override
    public void setTheDomainAs(String parsingDomain){
        Logger.logAction("Setting the domain as :- "+parsingDomain);
        try {
            HotelsScreen.tapOnMenuButton();
            MenuScreen.tapOnSettingsButton();
            SettingsScreen.tapOnChangeCountryOption();
            SettingsScreen.selectTheDomain(parsingDomain);
            SettingsScreen.tapOnContinueButton();
            driver.navigate().back();
        }catch (Exception exception){
            Logger.logError("Unable to set the domain as :- "+parsingDomain);
        }
    }

    /**
     * Selects the country name of the user
     * @param userCountryName
     */
    public static void selectCountryOfUser(String userCountryName) {
        Logger.logAction("selecting the country of user");
        try{
            runAppInBackground(1);
            if (isElementDisplayedById(DOMAIN_LIST_VIEW)) {
                WebElement displayedCountriesListView = driver.findElementById(DOMAIN_LIST_VIEW);
                if (userCountryName.equalsIgnoreCase(Labels_Hotels.INDIA_LANGUAGE_COUNTRY_LABEL)) {
                    List<WebElement> displayedCountriesList = displayedCountriesListView.findElements(By.className(Labels_Hotels.ANDROID_TEXT_VIEW));
                    for (int index = 0; index <= displayedCountriesList.size(); index++) {
                        WebElement countryNameTextView = displayedCountriesList.get(index);
                        String countryNameLabel = countryNameTextView.getText();
                        if (countryNameLabel.equalsIgnoreCase(userCountryName) || countryNameLabel.equalsIgnoreCase(OTHER_COUNTRY_OPTION)) {
                            Logger.logComment("Tapping on element - " + userCountryName);
                            index = index + 1;
                            driver.findElement(By.xpath(XPATH_OF_COUNTRY_NAME + index + "]")).click();
                            Logger.logStep("Tapped on element - "+userCountryName);
                            break;
                        } else {
                            continue;
                        }
                    }
                } else {
                    List<WebElement> displayedCountriesList = displayedCountriesListView.findElements(By.className(Labels_Hotels.ANDROID_TEXT_VIEW));
                    for (int index = 0; index <= displayedCountriesList.size(); index++) {
                        WebElement countryNameTextView = displayedCountriesList.get(index);
                        String countryNameLabel = countryNameTextView.getText();
                        if (countryNameLabel.equalsIgnoreCase(userCountryName)) {
                            Logger.logComment("Tapping on element - " + userCountryName);
                            index = index + 1;
                            driver.findElement(By.xpath(XPATH_OF_COUNTRY_NAME + index + "]")).click();
                            Logger.logStep("Tapped on element - "+userCountryName);
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }else {
                Logger.logError(DOMAIN_LIST_VIEW+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Error in selecting the user country from select country modal");
        }
    }


    /**
     * Get the departure month displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheDepartureMonthDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the onward month displayed in the calendar view");
        String departureMonth = findElementByIdAndReturnText(DEPARTURE_MONTH_IN_CALENDAR_VIEW);
        Logger.logComment("Selected month name in calendar view is :- "+departureMonth);
        return departureMonth;
    }

    /**
     * Get the departure day displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheDepartureDayDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the onward day displayed in the calendar view");
        String departureDay = findElementByIdAndReturnText(DEPARTURE_DAY_IN_CALENDAR_VIEW);
        Logger.logComment("Selected day value in calendar view is :- "+departureDay);
        return departureDay;
    }



    /**
     * Get the return month displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheReturnMonthDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the return month displayed in the calendar view");
        String departureMonth = findElementByIdAndReturnText(RETURN_MONTH_IN_CALENDAR_VIEW);
        Logger.logComment("Selected month name in calendar view is :- "+departureMonth);
        return departureMonth;
    }

    /**
     * Get the return day displayed in the calendar view
     * @return
     * @throws Exception
     */
    public static String getTheReturnDayDisplayedInCalenderView() throws Exception{
        Logger.logAction("Getting the return day displayed in the calendar view");
        String departureDay = findElementByIdAndReturnText(RETURN_DAY_IN_CALENDAR_VIEW);
        Logger.logComment("Selected day value in calendar view is :- "+departureDay);
        return departureDay;
    }
}
