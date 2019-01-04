package com.automation.rehlat.flights.pages.travellerDetails;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.General;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.automation.rehlat.flights.tests.BaseTest.INTERNATIONALS_TRAVELLERS_COUNTRY_NAME;

public class TravellerDetailsAndroid extends TravellerDetailsBase {
    public static final String TRAVELLERS_FIRST_NAME="com.app.rehlat:id/travellerFirstNameEditText";
    public static final String TRAVELLERS_MIDDLE_NAME="com.app.rehlat:id/travellerMiddleNameEditText";
    public static final String TRAVELLERS_LAST_NAME="com.app.rehlat:id/travellerLastNameEditText";
    public static final String TRAVELLERS_DATEOFBIRTH_NAME="com.app.rehlat:id/travellerDobDateEditText";
    public static final String TRAVELLERS_PASSPORT_TEXTFIELD="com.app.rehlat:id/travellerPassportNumberEditText";
    public static final String TRAVELLERS_PASSPORT_EXPIRY_TEXTFIELD="com.app.rehlat:id/travellerExpirtyDateEditText";
    public static final String TRAVELLERS_PASSPORT_ISSUING_COUNTRY="com.app.rehlat:id/issuecountry_textview";
    public static final String TRAVELLERS_NATIONALITY="com.app.rehlat:id/travellerNationalitytextview";
    public static final String TRAVELLERS_PRE_POPULATED_LAYOUT = "com.app.rehlat:id/traveller_prepopulated_list_layout";
    public static final String CLOSE_BUTTON_IN_TRAVELLERS_PRE_POPULATED_LAYOUT = "com.app.rehlat:id/traveller_prepopulated_close_dialog";
    public static final String FIRST_TRAVLLERS_NAME_IN_PREPOPULATED_LIST ="com.app.rehlat:id/item_traveller_prepopulated_travellerName";
    public static final String AUTO_TUTORIAL_DIALOG = "com.app.rehlat:id/tutorialDialog";
    public static final String SELECT_COUNTRY_MODAL="SELECT COUNTRY";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE_LAYOUT="com.app.rehlat:id/addTravellersLayoutHeadingView";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE="Traveller Details";
    public static final String SAVE_BUTTON="com.app.rehlat:id/addTravellerDone";
    public static final String SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL="com.app.rehlat:id/searchFlightEditText";
    public static final String HEADER_TITLE = "com.app.rehlat:id/joinHeaderTitle";
    public static final String CALENDAR_OK_BUTTON="android:id/button1";
    public static final String PREVIOUS_MONTH_BUTTON ="android:id/prev";
    public static final String FUTURE_MONTH_BUTTON ="android:id/next"; //check this element name in inspector.., all are set...,
    public static final String CALENDER_MONTH_VIEW_ANDROID ="android:id/month_view";
    public static final String TRAVELLERS_DETAILS_MODAL ="com.app.rehlat:id/travellers_details_viewpager";
    public static final String XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String XPATH_OF_SECOND_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String[] monthsList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final String FIRST_NAME_PLACE_HOLDER_LABEL = "FIRST NAME";
    public static final String MIDDLE_NAME_PLACE_HOLDER_LABEL = "MIDDLE NAME";
    public static final String LAST_NAME_PLACE_HOLDER_LABEL = "LAST NAME";
    public static final String TRAVELLERS_TITTLE = "com.app.rehlat:id/travelleritypetitle";

    /**
     * Check the travellers details screen is displayed
     */
    @Override
    public void checkTravellersDetailsScreenIsDisplayed() {
        Logger.logAction("Checking the travellers details screen is displayed or not ?");
        try {
            if (isElementDisplayedById(TRAVELLERS_DETAILS_SCREEN_TITLE_LAYOUT)){
                String screenTittle = driver.findElementById(TRAVELLERS_DETAILS_SCREEN_TITLE_LAYOUT).getText();
                if (screenTittle.matches(TRAVELLERS_DETAILS_SCREEN_TITLE)){
                    Logger.logStep("Travellers details screen is displayed");
                }else {
                    Logger.logComment("Screen name are :- "+TRAVELLERS_DETAILS_SCREEN_TITLE+" , "+screenTittle);
                    Logger.logError("Travellers details screen is not displayed");
                }
            } else {
                Logger.logError("Travellers details screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the current active screen name");
        }
    }

    /**
     * Decline the auto fill populate modal if displayed
     */
    @Override
    public boolean declineAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Declining the auto fill popup if displayed");
        try{
            if (isElementDisplayedById(TRAVELLERS_PRE_POPULATED_LAYOUT)){
                if (isElementDisplayedById(CLOSE_BUTTON_IN_TRAVELLERS_PRE_POPULATED_LAYOUT)){
                    WebElement closeButton = driver.findElementById(CLOSE_BUTTON_IN_TRAVELLERS_PRE_POPULATED_LAYOUT);
                    closeButton.click();
                    return true;
                    }else {
                    Logger.logError("Close button is not displayed in the pre populated list layout");
                }
            } else {
                Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
        return false;
    }

    /**
     * Accept the auto fill populate modal if displayed
     */
    @Override
    public boolean acceptAutoFillPopulateModalIfDisplayed(Integer parsingPassengersCount) {
        Logger.logAction("Accepting the auto fill popup if displayed");
        Integer count = 0;
        try {
//            while (count <= parsingPassengersCount) {
                if (isElementDisplayedById(TRAVELLERS_PRE_POPULATED_LAYOUT)) {
                    if (isElementDisplayedById(FIRST_TRAVLLERS_NAME_IN_PREPOPULATED_LIST)) {
                        WebElement closeButton = driver.findElementById(FIRST_TRAVLLERS_NAME_IN_PREPOPULATED_LIST);
                        closeButton.click();
//                        if (!(parsingPassengersCount == count+1)){
//                            tapOnNextButton();
//                        }
                        count++;
                    } else {
                        Logger.logError("Travellers data is not displayed in the pre populated list layout");
                    }
                } else {
                    Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
                    return false;
                }
//            }
            return true;
        }catch(Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
        return false;
    }


    /**
     * Enter travellers details for passengers
     * @param parsingPassengerCount
     */
    @Override
    public void EnterTravellersDetailsForPassengers(Integer parsingPassengerCount){
        Logger.logAction("Entering the travelling details of passengers :-"+parsingPassengerCount);
//        boolean autoAcceptAlertStatus = false;
        try {
            Integer enteringTravellersDetailsCount = 0;
            Integer passengerCount;
            Labels_Flights.TRAVELLERS_TYPE = "Traveller1(Adult)";
            while (enteringTravellersDetailsCount < parsingPassengerCount){
                for (passengerCount=0;passengerCount<parsingPassengerCount;passengerCount++){
                    TravellerDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
                    String travellersType = getTheSelectedTravellerType(TRAVELLERS_TITTLE);
                    Labels_Flights.TRAVELLERS_TYPE = travellersType;
                    Logger.logStep("Entering the travellers details of :- "+travellersType);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                    enterTravellersDetails(INTERNATIONALS_TRAVELLERS_COUNTRY_NAME);
                    if (passengerCount!=(parsingPassengerCount-1)){
                        TravellerDetailsScreen.tapOnSaveButton();
                        enteringTravellersDetailsCount++;
                    }else {
                        enteringTravellersDetailsCount++;
                        Logger.logStep("Last travellers details are entered");
                        continue;
                    }

//                    if (!Labels_Flights.TRAVELLERS_TYPE.contains("Traveller"+parsingPassengerCount)){
//                        Labels_Flights.TRAVELLERS_TYPE = travellersType;
//                        Logger.logStep("Entering the travellers details of :- "+travellersType);
//                        if (!Labels_Flights.TRAVELLERS_TYPE.contains("Travellers"+parsingPassengerCount)){
//                            TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
//                            enterTravellersDetails(INTERNATIONALS_TRAVELLERS_COUNTRY_NAME);
//                            if (passengerCount!=(parsingPassengerCount-1)){
//                                TravellerDetailsScreen.tapOnSaveButton();
//                                enteringTravellersDetailsCount++;
////                                passengerCount++;
//                            }else {
//                                continue;
//                            }
//                        }else if (Labels_Flights.TRAVELLERS_TYPE.contains("Travellers"+parsingPassengerCount)) {
//                            Logger.logStep("All the travellers details are entered");
//                            enteringTravellersDetailsCount = parsingPassengerCount++;
//                        }else {
//                            Logger.logError("In correct travellers name is displayed");
//                        }
//                    }else {
//                        Logger.logStep("Last travellers details are entered");
//                        break;
//                    }
//                    }else {
//                        continue;
//                    }
            }
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to enter the travellers details of passengers :- "+parsingPassengerCount);
        }
    }

    /**
     * Return the travellers type
     * @return
     */
    public static String getTheSelectedTravellerType(String xpathOfTravellersTypeWithIndex){
        Logger.logAction("Getting the travellers type");
        try {
            String travellerType = findElementByIdAndReturnText(xpathOfTravellersTypeWithIndex);
            return travellerType;
        }catch (Exception exception){
            Logger.logError("Unable to get the travellers type");
        }
        return null;
    }

    /**
     * Enter adult travellers details
     */
    @Override
    public void enterAdultTravellersDetails(String travellersCountry) {
        Logger.logAction("Entering the adult travellers details");
        try{
            if (isElementDisplayedById(TRAVELLERS_DETAILS_MODAL)){
                Logger.logStep("Travellers details modal is displayed and moving to next step");
                enterTravellersDetails(travellersCountry);
            }else {
                Logger.logError("Travellers details modal is not displayed or interactions are not available for the current active screen");
            }
        } catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the adult travellers details in the current active screen");
        }
    }

    /**
     * Enter the travellers details
     */
    public static void enterTravellersDetails(String travellersCountry) {
        Logger.logAction("Entering travellers details");
        try{
            enterTravellersFirstName();
            enterTravellersMiddleName();
            enterTravellersLastName();
//            if (Labels_Hotels.FLIGHT_BOOKING_TYPE.equals(Labels_Hotels.INTERNATIONAL_FLIGHT_BOOKING)){
//                enterTravellersDateOfBirth();
//                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
//                selectTravellersNationality(travellersCountry);
//                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
//                enterTravellersPassportNumber();
////                scrollTheScreenUpwards();
//                selectPassportIssuingCountry(travellersCountry);
//                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
//                selectTravellersPassportExpiryDate();
//                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
//            }else if (Labels_Hotels.FLIGHT_BOOKING_TYPE.equals(Labels_Hotels.DOMESTIC_FLIGHT_BOOKING)){
            Logger.logStep("For domestic flights DOB, Passport and its expiry date and passport issuing country are might or might not necessary.., So filling the necessary information for the current flight ...,");
            if (isElementDisplayedById(TRAVELLERS_DATEOFBIRTH_NAME)){
                enterTravellersDateOfBirth();
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            }if (isElementDisplayedById(TRAVELLERS_NATIONALITY)){
                selectTravellersNationality(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                enterTravellersPassportNumber();
                selectPassportIssuingCountry(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                selectTravellersPassportExpiryDate();
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            }else {
                Logger.logStep("Airlines doesn't need the passport expiry details, passport issuing country, travellers nationality. So not checking these details");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to enter the travellers details");
        }
    }

    /**
     * Enter the travellers first name
     */
    public static void enterTravellersFirstName() {
        Logger.logStep("Entering travellers first name");
        try{
            if (isElementDisplayedById(TRAVELLERS_FIRST_NAME)){
                String firstNameLabel = driver.findElementById(TRAVELLERS_FIRST_NAME).getText();
                String firstName = General.getTheTestDataOfField("First_Name");
                if (firstNameLabel.equals(Labels_Flights.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_FIRST_NAME).sendKeys(firstName);
                    Logger.logComment(firstName+" :- element name is entered as first name");
                    closeTheKeyboard_Android();
                }else if (firstNameLabel.equals(FIRST_NAME_PLACE_HOLDER_LABEL)){
                    driver.findElementById(TRAVELLERS_FIRST_NAME).sendKeys(firstName);
                    Logger.logComment(firstName+" :- element name is entered as first name");
                    closeTheKeyboard_Android();
                }else {
//                    driver.findElementById(TRAVELLERS_FIRST_NAME).click();
                    clearKeysByUsingKeycode(TRAVELLERS_FIRST_NAME,firstNameLabel.length());
                    driver.findElementById(TRAVELLERS_FIRST_NAME).sendKeys(firstName);
                    Logger.logComment(firstName+" :- element name is entered as first name");
                    closeTheKeyboard_Android();
                }
            }else {
                Logger.logError("Travellers first name field is not displayed in the current active screen");
            }

        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to enter the travellers first name");
        }
    }

    /**
     * Enter the travellers middle name
     */
    public static void enterTravellersMiddleName() {
        Logger.logStep("Entering travellers middle name");
        try{
            if (isElementDisplayedById(TRAVELLERS_MIDDLE_NAME)){
                String middleNameLabel = driver.findElementById(TRAVELLERS_MIDDLE_NAME).getText();
                String middleName = General.getTheTestDataOfField("Middle_Name");
                if (middleNameLabel.equals(Labels_Flights.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_MIDDLE_NAME).sendKeys(middleName);
                    Logger.logComment(middleName+" :- element name is entered as middle name");
                    closeTheKeyboard_Android();
                }else if (middleNameLabel.equals(MIDDLE_NAME_PLACE_HOLDER_LABEL)){
                    driver.findElementById(TRAVELLERS_MIDDLE_NAME).sendKeys(middleName);
                    Logger.logComment(middleName+" :- element name is already entered as middle name");
                    closeTheKeyboard_Android();
                }
                else {
                    driver.findElementById(TRAVELLERS_MIDDLE_NAME).click();
                    clearKeysByUsingKeycode(TRAVELLERS_MIDDLE_NAME,middleNameLabel.length());
                    driver.findElementById(TRAVELLERS_MIDDLE_NAME).sendKeys(middleName);
                    Logger.logComment(middleName+" :- element name is already entered as middle name");
                    closeTheKeyboard_Android();
                }
            }else {
                Logger.logError("Travellers middle name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers middle name");
        }
    }

    /**
     * Enter the travellers last name
     */
    public static void enterTravellersLastName() {
        Logger.logStep("Entering travellers last name");
        try{
            if (isElementDisplayedById(TRAVELLERS_LAST_NAME)){
                String lastNameLabel = driver.findElementById(TRAVELLERS_LAST_NAME).getText();
                String lastName = General.getTheTestDataOfField("Last_Name");
                if (lastNameLabel.equals(Labels_Flights.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_LAST_NAME).sendKeys(lastName);
                    Logger.logComment(lastName+" :- element name is entered as middle name");
                    closeTheKeyboard_Android();
                } else if (lastNameLabel.equals(LAST_NAME_PLACE_HOLDER_LABEL)){
                    driver.findElementById(TRAVELLERS_LAST_NAME).sendKeys(lastName);
                    Logger.logComment(lastName+" :- element name is entered as middle name");
                    closeTheKeyboard_Android();
                }
                else {
//                    driver.findElementById(TRAVELLERS_LAST_NAME).click();
                    clearKeysByUsingKeycode(TRAVELLERS_LAST_NAME,lastNameLabel.length());
                    driver.findElementById(TRAVELLERS_LAST_NAME).sendKeys(lastName);
                    Logger.logComment(lastName+" :- element name is entered as middle name");
                    closeTheKeyboard_Android();
                }
            }else {
                Logger.logError("Travellers last name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers last name");
        }
    }

    /**
     * Enter the travellers Date of Birth
     */
    public static void enterTravellersDateOfBirth() {
        Logger.logStep("Entering travellers Date of Birth");
        try{
            if (Labels_Flights.TRAVELLERS_TYPE.contains("Child") || Labels_Flights.TRAVELLERS_TYPE.contains("Infant")){
                if (isElementDisplayedById(TRAVELLERS_DATEOFBIRTH_NAME)){
                    driver.findElementById(TRAVELLERS_DATEOFBIRTH_NAME).click();
                    closeAutoTutorialDialog();
                    if (isDatePickerDisplayed()){
//                        swipeTheCalendarViewToDate(Labels_Hotels.DATEOFBIRTH_CALENDAR,Labels_Hotels.TRAVELLERS_DATEOFBIRTH_ANDROID);
//                        if (isElementDisplayedById(Labels_Hotels.TRAVELLERS_DATEOFBIRTH_ANDROID)){
//                            driver.findElementById(Labels_Hotels.TRAVELLERS_DATEOFBIRTH_ANDROID).click();
//                            Logger.logComment(Labels_Hotels.TRAVELLERS_LAST_NAME+" :- element name is selected as date of birth");
                            closeTheCalendarView();
//                        }else {
//                            driver.findElementById(CALENDER_MONTH_VIEW_ANDROID).click();
//                            closeTheCalendarView();
//                        }
                    }else {
                        Logger.logError("Date picker is not displayed");
                    }
                }else {
                    Logger.logError("Travellers date of birth field is not displayed in the current active screen");
                }
            }else if (Labels_Flights.TRAVELLERS_TYPE.contains("Adult")){
                if (isElementDisplayedById(TRAVELLERS_DATEOFBIRTH_NAME)){
                    driver.findElementById(TRAVELLERS_DATEOFBIRTH_NAME).click();
                    closeAutoTutorialDialog();
                    if (isDatePickerDisplayed()){
                        swipeTheCalendarViewToDate(Labels_Flights.DATEOFBIRTH_CALENDAR, Labels_Flights.TRAVELLERS_DATEOFBIRTH_ANDROID);
                        if (isElementDisplayedById(Labels_Flights.TRAVELLERS_DATEOFBIRTH_ANDROID)){
                            driver.findElementById(Labels_Flights.TRAVELLERS_DATEOFBIRTH_ANDROID).click();
                            Logger.logComment(Labels_Flights.TRAVELLERS_DATEOFBIRTH_ANDROID+" :- element name is selected as date of birth");
                            closeTheCalendarView();
                        }else {
                            driver.findElementById(CALENDER_MONTH_VIEW_ANDROID).click();
                            closeTheCalendarView();
                        }
                    }else {
                        Logger.logError("Date picker is not displayed");
                    }
                }else {
                    Logger.logError("Travellers date of birth field is not displayed in the current active screen");
                }
            }else {
                Logger.logError("Current travellers type is not an ADULT or CHILD or INFANT");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers date of birth");
        }
    }

    /**
     * Swipe the calender view to a particular date based on calendar type
     * @param parsingDate
     */
     public static void swipeTheCalendarViewToDate(String dateType, String parsingDate) {
        Logger.logAction("Swiping the calendar view to date:- "+parsingDate);
        try {
            if (dateType.equals(Labels_Flights.DATEOFBIRTH_CALENDAR)){
                swipeDateOfBirthCalendar(parsingDate);
            }
            else if (dateType.equals(Labels_Flights.PASSPORT_EXPIRY_CALENDAR)){
                swipePassportExpiryCalendar(parsingDate);
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the travellers date of birth");
        }
    }

    /**
     * Swipe the date of birth calendar // For now only adult Date of birth logic is implemented, yet to implement for infant and child type also
     */
    public static void swipeDateOfBirthCalendar(String parsingDate) {
        Logger.logAction("Swiping to the date of birth calendar date :- "+parsingDate);
        int monthValueOfParsingYear = 0;
        int currentMonthValueInThePreviousYearOfParsingYear = 0;
        int totalTapsOnForwardButtonInPreviousYearOfParsingYear = 0;
        try {
//            String time = new SimpleDateFormat("yyyy").format(new Date());
            Integer currentCalendarYear = Integer.valueOf(Labels_Flights.JOURNEY_YEAR);
            Integer displayedAdultCalendar = currentCalendarYear-12;
            Integer parsingCalenderYear = Integer.valueOf(Labels_Flights.YEAR_IN_TRAVELLERS_DATEOFBIRTH_ANDROID);
            if (displayedAdultCalendar >= parsingCalenderYear){
                Integer numberOfTapsTobeDoneOnPastMonthButtonTillToOneYearBeforeToParsingYear = ((displayedAdultCalendar-parsingCalenderYear-1)*(12));
                if (isElementDisplayedById(PREVIOUS_MONTH_BUTTON)){
                    // Logic to go to one year before to parsing date year
                    // No need to add "1" tap extra which we did it in future parsing calender because we are using the departure date to swipe to the parsing calendar
                    for (int tapCount = 0; tapCount <numberOfTapsTobeDoneOnPastMonthButtonTillToOneYearBeforeToParsingYear;tapCount++) {
                        driver.findElementById(PREVIOUS_MONTH_BUTTON).click();
                    }
                    // Logic to go to exact parsing month from one year before to the parsing date year
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (parsingDate.contains(monthName)){
                            index = 11-index;
                            monthValueOfParsingYear = index;
                            break;
                        }
                    }
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (monthName.equals(Labels_Flights.MONTH_IN_TRAVELLERS_DEPARTURE_DATE_FOR_ANDROID)){
                            currentMonthValueInThePreviousYearOfParsingYear = index;
                            break;
                        }
                    }
                    totalTapsOnForwardButtonInPreviousYearOfParsingYear = monthValueOfParsingYear+currentMonthValueInThePreviousYearOfParsingYear;
                    for (int tapMonthCount = 0; tapMonthCount <=totalTapsOnForwardButtonInPreviousYearOfParsingYear;tapMonthCount++){
                        driver.findElementById(PREVIOUS_MONTH_BUTTON).click();
                    }
                    // Checking the parsing date is displayed according to the logic
                    if (isElementDisplayedByIdWithOneTimeChecking(parsingDate)){
                        Logger.logComment("Swiped the calendar view to date:- "+parsingDate);
                    }else {
                        Logger.logError(parsingDate+" - element id is not displayed in the current active screen");
                    }
                }else {
                    Logger.logError("Previous Month button is not displayed in the current calender view");
                }
            }else {
                Logger.logComment("Current Year & adult date of birth year dates are :- "+currentCalendarYear+","+ Labels_Flights.YEAR_IN_TRAVELLERS_DATEOFBIRTH_ANDROID);
                Logger.logError("Adult date of birth should be less than 12 years to the current Year");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to swipe the calendar view");
        }
    }

    /**
     * Swipe the date of birth calendar // For now only adult Date of birth logic is implemented, yet to implement for infant and child type also
     */
    public static void swipePassportExpiryCalendar(String parsingDate) {
        Logger.logAction("Swiping to the passport expiry calendar date :- "+parsingDate);
        int monthValueOfParsingYear = 0;
        int currentMonthValueInThePreviousYearOfParsingYear = 0;
        int totalTapsOnForwardButtonInPreviousYearOfParsingYear = 0;
        try {
            String time = new SimpleDateFormat("yyyy").format(new Date());
            Integer currentCalendarYear = Integer.valueOf(time);
            Integer displayedAdultCalendar = currentCalendarYear;
            Integer parsingCalenderYear = Integer.valueOf(Labels_Flights.YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID);
            if (displayedAdultCalendar <= parsingCalenderYear){
                Integer numberOfTapsTobeDoneOnNextMonthButtonTillToOneYearBeforeToParsingYear = ((parsingCalenderYear-displayedAdultCalendar-1)*(12));
                if (isElementDisplayedById(FUTURE_MONTH_BUTTON)){
                    // Logic to go to one year before to parsing date year
                    for (int tapCount = 0; tapCount <=numberOfTapsTobeDoneOnNextMonthButtonTillToOneYearBeforeToParsingYear;tapCount++){
                        driver.findElementById(FUTURE_MONTH_BUTTON).click();
                    }
                    // Logic to go to exact parsing month from one year before to the parsing date year
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (parsingDate.contains(monthName)){
                            monthValueOfParsingYear = index;
                            break;
                        }
                    }
                    String currentMonth = new SimpleDateFormat("MMMMM").format(new Date());
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (monthName.equals(currentMonth)){
                            index = 11 - index -1; // "1" tap is added extra because to see the future month we are using the current month name (Which we didn't use extra tap in past calendar swiping)
                            currentMonthValueInThePreviousYearOfParsingYear = index;
                            break;
                        }
                    }
                    totalTapsOnForwardButtonInPreviousYearOfParsingYear = monthValueOfParsingYear+currentMonthValueInThePreviousYearOfParsingYear;
                    for (int tapMonthCount = 0; tapMonthCount <=totalTapsOnForwardButtonInPreviousYearOfParsingYear;tapMonthCount++){
                        driver.findElementById(FUTURE_MONTH_BUTTON).click();
                    }
                    // Checking the parsing date is displayed according to the logic
                    if (isElementDisplayedByIdWithOneTimeChecking(parsingDate)){
                        Logger.logComment("Swiped the calendar view to date:- "+parsingDate);
                    }else {
                        Logger.logError(parsingDate+" - element id is not displayed in the current active screen");
                    }
                }else {
                    Logger.logError("Future Month button is not displayed in the current calender view");
                }
            }else {
                Logger.logComment("Current Year & adult passport expiry year dates are :- "+currentCalendarYear+","+ Labels_Flights.YEAR_IN_TRAVELLERS_DATEOFBIRTH_ANDROID);
                Logger.logError("Adult passport expiry year date should be greater than the current Year");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to swipe the calendar view");
        }
    }

    /**
     * Close the date picker for Android Platform
     */
    public static void closeTheCalendarView() {
        Logger.logAction("Closing the calender view");
        try{
            if (isElementDisplayedById(CALENDAR_OK_BUTTON)){
                driver.findElementById(CALENDAR_OK_BUTTON).click();
                Logger.logStep("Tapped on ok button in calendar view");
            }else{
                Logger.logStep("Date picker is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to close the keyboard");
        }
    }

    /**
     * Close the auto tutorial dialog of calendar
     */
    public static void closeAutoTutorialDialog() {
        Logger.logAction("Closing the auto tutorial dialog");
        try{
            if (isElementDisplayedById(AUTO_TUTORIAL_DIALOG)){
                Logger.logComment("Tutorial is displayed and going to close it by tapping on it");
                driver.findElementById(AUTO_TUTORIAL_DIALOG).click();
            }else {
                Logger.logComment("No tutorials are displayed and moving forward to next step");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the auto swipe suggestion");
        }
    }

    /**
     * Enter the travellers passport number
     */
    public static void enterTravellersPassportNumber() {
        Logger.logStep("Entering travellers passport number");
        try{
            if (isElementDisplayedById(TRAVELLERS_PASSPORT_TEXTFIELD)){
                String passportName = driver.findElementById(TRAVELLERS_PASSPORT_TEXTFIELD).getText();
                String passportNumber = General.getTheTestDataOfField("Passport_Number");
                if (passportName.equals(Labels_Flights.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_PASSPORT_TEXTFIELD).sendKeys(passportNumber);
                    Logger.logComment(passportNumber+" :- element name is parsed as passport number");
                    closeTheKeyboard_Android();
                }else {
                    clearKeysByUsingKeycode(TRAVELLERS_PASSPORT_TEXTFIELD,passportName.length());
                    driver.findElementById(TRAVELLERS_PASSPORT_TEXTFIELD).sendKeys(passportNumber);
                    Logger.logComment(passportNumber+" :- element name is parsed as passport number");
                    closeTheKeyboard_Android();
                }
            }else {
                Logger.logError("Travellers passport field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers passport number");
        }
    }

    /**
     * Enter the travellers passport expiry date
     */
    public static void selectTravellersPassportExpiryDate() {
        Logger.logStep("Selecting travellers passport expiry date");
        try{
            if (isElementDisplayedById(TRAVELLERS_PASSPORT_EXPIRY_TEXTFIELD)){
                driver.findElementById(TRAVELLERS_PASSPORT_EXPIRY_TEXTFIELD).click();
                closeAutoTutorialDialog();
                if (isDatePickerDisplayed()){
                    swipeTheCalendarViewToDate(Labels_Flights.PASSPORT_EXPIRY_CALENDAR, Labels_Flights.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID);
                    if (isElementDisplayedById(Labels_Flights.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID)){
                        driver.findElementById(Labels_Flights.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID).click();
                        Logger.logComment(Labels_Flights.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID+" :- element name is selected as passport expiry date");
                        closeTheCalendarView();
                    }else {
                        driver.findElementById(CALENDER_MONTH_VIEW_ANDROID).click();
                        Logger.logComment(Labels_Flights.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID+" :- element name is selected as passport expiry date");
                        closeTheCalendarView();
                    }
                }else {
                    Logger.logError("Date picker is not displayed");
                }
            }else {
                Logger.logError("Travellers date of birth field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers passport expiry field");
        }
    }

    /**
     * Select passport issuing country name
     */
    public static void selectPassportIssuingCountry(String passportIssuingCountryName) {
        Logger.logAction("Selecting the passport issuing country");
        try{
            if (isElementDisplayedById(TRAVELLERS_PASSPORT_ISSUING_COUNTRY)){
                Logger.logStep("Tapping on Issuing country field");
                driver.findElementById(TRAVELLERS_PASSPORT_ISSUING_COUNTRY).click();
                if (isElementDisplayedById(HEADER_TITLE)) {
                    String headerTitle = driver.findElement(By.id(HEADER_TITLE)).getText();
                    if (headerTitle.matches(SELECT_COUNTRY_MODAL)){
                        selectCountry(passportIssuingCountryName);
                    }
                }else{
                    Logger.logError("Choose country modal is not displayed in the current active screen");
                }
            }else{
                Logger.logError("Passport Issuing country field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the passport issuing country");
        }
    }

    /**
     * Select traveller nationality
     */
    public static void selectTravellersNationality(String travellersNationality) {
        Logger.logAction("Selecting the travellers nationality");
        try{
            if (isElementDisplayedById(TRAVELLERS_NATIONALITY)){
                Logger.logStep("Tapping on Issuing country field");
                driver.findElementById(TRAVELLERS_NATIONALITY).click();
                if (isElementDisplayedById(HEADER_TITLE)) {
                    String headerTitle = driver.findElement(By.id(HEADER_TITLE)).getText();
                    if (headerTitle.matches(SELECT_COUNTRY_MODAL)){
                        selectCountry(travellersNationality);
                    }
                }else{
                    Logger.logError("Choose country modal is not displayed in the current active screen");
                }
            }else{
                Logger.logError("Nationality field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the Nationality field");
        }
    }

    /**
     * Select the country name from choose country modal
     * @param countryName
     */
    // To do: Implement a method such that automatically select the country name (if country name is not on visible list scroll to that element and click on it)
    public static void selectCountry(String countryName) {
        Logger.logAction("Selecting the country :- "+countryName);
        try{
            if (isElementDisplayedById(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL)){
                driver.findElementById(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL).sendKeys(countryName);
                if (isElementDisplayedByXPath(XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN)){
                    WebElement firstSearchResult = driver.findElementByXPath(XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN);
                    if (firstSearchResult.getText().equals(countryName)){
                        firstSearchResult.click();
                        Logger.logComment(firstSearchResult.getText()+" :- element name is selected as country");
                    }else {
                        WebElement secondSearchResult = driver.findElementByXPath(XPATH_OF_SECOND_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN);
                        if (secondSearchResult.getText().equals(countryName)){
                            secondSearchResult.click();
                            Logger.logComment(firstSearchResult.getText()+" :- element name is selected as country");
                        }else {
                            Logger.logError(countryName+" - is not matched with the displayed country name in second search cell :- "+firstSearchResult.getText());
                        }
                    }
                }else {
                    Logger.logError(countryName+" is not displaying in the current active screen");
                }
            }else {
                Logger.logError(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL+ " - is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to choose the country name");
        }
    }

    /**
     * Tap on save button
     */
    @Override
    public void tapOnSaveButton() {
        Logger.logAction("Tapping on save button in the travellers details screen");
        try{
            boolean status = findElementByIdAndClick(SAVE_BUTTON);
            if (status == true){
                Logger.logComment(SAVE_BUTTON+" :- element name is tapped");
            }else {
                Logger.logError("Didn't tapped on Save button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the save button in the current active screen");
        }
    }

    /**
     * Tap on Next button
     */
    @Override
    public void tapOnNextButton() {
        Logger.logAction("Tapping on next button in the travellers details screen");
        try{
            boolean status = findElementByIdAndClick(SAVE_BUTTON);
            if (status == true){
                Logger.logComment(SAVE_BUTTON+" :- element name is selected");
            }else {
                Logger.logError("Didn't tapped on next button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the next button in the current active screen");
        }
    }

}
