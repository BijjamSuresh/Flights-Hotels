package com.automation.rehlat.hotels.pages.guestTravellersDetails;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.WebElement;

public class GuestTravellersDetailsAndroid extends GuestTravellersDetailsBase {

    public static final String TRAVELLERS_FIRST_NAME="com.app.rehlat:id/travellerFirstNameEditText";
    public static final String TRAVELLERS_LAST_NAME="com.app.rehlat:id/travellerLastNameEditText";
    public static final String TRAVELLERS_PRE_POPULATED_LAYOUT = "com.app.rehlat:id/traveller_prepopulated_list_layout";
    public static final String CLOSE_BUTTON_IN_TRAVELLERS_PRE_POPULATED_LAYOUT = "com.app.rehlat:id/traveller_prepopulated_close_dialog";
    public static final String FIRST_TRAVELLERS_NAME_IN_PRE_POPULATED_LIST ="com.app.rehlat:id/item_traveller_prepopulated_travellerName";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE_LAYOUT="com.app.rehlat:id/addTravellersLayoutHeadingView";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE="Traveller Details";
    public static final String SAVE_BUTTON="com.app.rehlat:id/hoteladdTravellerDone";
    public static final String TRAVELLERS_TITTLE = "com.app.rehlat:id/traveller_type_textview";
    public static final String XPATH_OF_ROOM_NUMBER_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[";
    public static final String XPATH_OF_ROOM_NUMBER_NAME_WITHOUT_ROOM_NUMBER_XPATH = "]/android.widget.TextView";
    public static final String XPATH_OF_TRAVELLERS_CARD_VIEW_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";
    public static final String XPATH_OF_TRAVELLERS_FIRST_NAME_WITHOUT_XPATH_OF_CARD_NUMBER = "]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText";
    public static final String XPATH_OF_TRAVELLERS_Last_NAME_WITHOUT_XPATH_OF_CARD_NUMBER = "]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText";

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
    public boolean acceptAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Accepting the auto fill popup if displayed");
        try{
            if (isElementDisplayedById(TRAVELLERS_PRE_POPULATED_LAYOUT)){
                if (isElementDisplayedById(FIRST_TRAVELLERS_NAME_IN_PRE_POPULATED_LIST)){
                    WebElement closeButton = driver.findElementById(FIRST_TRAVELLERS_NAME_IN_PRE_POPULATED_LIST);
                    closeButton.click();
                    return true;
                }else {
                    Logger.logError("Travellers data is not displayed in the pre populated list layout");
                }
            } else {
                Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
        return false;
    }

       /**
     * Enter travellers details for passengers
     * @param parsingRoomNumber,parsingGuestTravellersAdultCount,parsingGuestTravellersChildCount
     */
    @Override
    public void enterTravellersDetailsForPassengers(Integer parsingRoomNumber, Integer parsingGuestTravellersAdultCount, Integer parsingGuestTravellersChildCount){
        Logger.logStep("Entering the travelling details of passengers in room number :-"+parsingRoomNumber);
        try {
            Integer enteringTravellersAdultCount = 0;
            Integer enteringTravellersChildCount = 0;
            Integer childCardViewNumber;
            Integer adultCardViewNumber;
            declineAutoFillPopulateModalIfDisplayed();
            if(GetTheSelectedTravellerTypeof(parsingRoomNumber)){
                while (enteringTravellersAdultCount < parsingGuestTravellersAdultCount){
                    adultCardViewNumber =enteringTravellersAdultCount+1;
                    enterAdultTravellersDetails(parsingRoomNumber,"Adult",adultCardViewNumber);
                    enteringTravellersAdultCount++;
                }
                while (enteringTravellersChildCount < parsingGuestTravellersChildCount){
                    Integer cellNumber = enteringTravellersChildCount+parsingGuestTravellersAdultCount+1;
                    childCardViewNumber = cellNumber;
                    enterChildTravellersDetails(parsingRoomNumber,"Child",childCardViewNumber);
                    enteringTravellersChildCount++;
                }
            }else {
                Logger.logError("Current selected paring room number is incorrect. i.e.., parsing room number:- "+parsingRoomNumber);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to enter the travellers details of passengers :- "+parsingRoomNumber);
        }
    }

    /**
     * Return the travellers type
     * @return
     */
    public static boolean GetTheSelectedTravellerTypeof(Integer roomNumber){
        Logger.logAction("Getting the travellers type");
        try {
            String xpathOfRoomNumberName = XPATH_OF_ROOM_NUMBER_WITHOUT_INDEX+roomNumber+XPATH_OF_ROOM_NUMBER_NAME_WITHOUT_ROOM_NUMBER_XPATH;
            String parsingRoomNumberStatus = findElementByXpathAndReturnItsAttributeSelected(xpathOfRoomNumberName);
            if (parsingRoomNumberStatus.equalsIgnoreCase(Labels_Hotels.STATUS_TRUE)){
                return true;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to get the travellers type");
        }
        return false;
    }

//    /**
//     * Enter adult travellers details
//     */
//    @Override
//    public void enterAdultTravellersDetails(String travellersCountry) {
//        Logger.logAction("Entering the adult travellers details");
//        try{
//            if (isElementDisplayedById(TRAVELLERS_DETAILS_MODAL)){
//                Logger.logStep("Travellers details modal is displayed and moving to next step");
//                enterTravellersDetails();
//            }else {
//                Logger.logError("Travellers details modal is not displayed or interactions are not available for the current active screen");
//            }
//        } catch (Exception exception){
//            Logger.logError("Encountered error: Unable to enter the adult travellers details in the current active screen");
//        }
//    }

    /**
     * Enter the adult travellers details
     */
    public static void enterAdultTravellersDetails(Integer roomNumber, String travellersType, Integer parsingAdultNumber) {
        Logger.logAction("Entering adult travellers details");
        try{
            enterTravellersFirstName(roomNumber,travellersType,parsingAdultNumber);
            enterTravellersLastName(roomNumber,travellersType,parsingAdultNumber);
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to enter the adult travellers details");
        }
    }

    /**
     * Enter the child travellers details
     */
    public static void enterChildTravellersDetails(Integer roomNumber, String travellersType, Integer parsingChildNumber) {
        Logger.logAction("Entering child travellers details");
        try{
            enterTravellersFirstName(roomNumber,travellersType,parsingChildNumber);
            enterTravellersLastName(roomNumber,travellersType,parsingChildNumber);
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to enter the child travellers details");
        }
    }

    /**
     * Enter the travellers first name
     */
    public static void enterTravellersFirstName(Integer roomNumber, String travellersType, Integer parsingTravellersNumber) {
        Logger.logStep("Entering Room - "+roomNumber+", Passenger - "+parsingTravellersNumber+" travellers first name");
        try{
            String xpathOfParsingTravellersFirstName = XPATH_OF_TRAVELLERS_CARD_VIEW_WITHOUT_INDEX+parsingTravellersNumber+XPATH_OF_TRAVELLERS_FIRST_NAME_WITHOUT_XPATH_OF_CARD_NUMBER;
            if (parsingTravellersNumber == 1){
                if (travellersType.equalsIgnoreCase("Adult")){
                    sendTextById(TRAVELLERS_FIRST_NAME, Labels_Hotels.ADULT_TRAVELLERS_FIRST_NAME);
                    closeTheKeyboard_Android();
                }else if (travellersType.equalsIgnoreCase("Child")){
                    sendTextById(TRAVELLERS_FIRST_NAME, Labels_Hotels.CHILD_TRAVELLERS_FIRST_NAME);
                    closeTheKeyboard_Android();
                }else {
                    Logger.logError("Incorrect travellers type is parsed");
                }
            }else if (parsingTravellersNumber < 4){
            if (travellersType.equalsIgnoreCase("Adult")){
                findElementByXPathAndClick(xpathOfParsingTravellersFirstName);
                sendTextById(TRAVELLERS_FIRST_NAME, Labels_Hotels.ADULT_TRAVELLERS_FIRST_NAME);
                closeTheKeyboard_Android();
            }else if (travellersType.equalsIgnoreCase("Child")){
                findElementByXPathAndClick(xpathOfParsingTravellersFirstName);
                sendTextById(TRAVELLERS_FIRST_NAME, Labels_Hotels.ADULT_TRAVELLERS_FIRST_NAME);
                closeTheKeyboard_Android();
            }else {
                Logger.logError("Incorrect travellers type is parsed");
            }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers first name");
        }
    }

    /**
     * Enter the travellers last name
     */
    public static void enterTravellersLastName(Integer roomNumber, String travellersType, Integer parsingTravellersNumber) {
        Logger.logStep("Entering Room - "+roomNumber+", Passenger - "+parsingTravellersNumber+" travellers last name");
        try{
            String xpathOfParsingTravellersLastName = XPATH_OF_TRAVELLERS_CARD_VIEW_WITHOUT_INDEX+parsingTravellersNumber+XPATH_OF_TRAVELLERS_Last_NAME_WITHOUT_XPATH_OF_CARD_NUMBER;
            if (parsingTravellersNumber == 1){
                if (travellersType.equalsIgnoreCase("Adult")){
                    sendTextById(TRAVELLERS_LAST_NAME, Labels_Hotels.ADULT_TRAVELLERS_LAST_NAME);
                    closeTheKeyboard_Android();
                }else if (travellersType.equalsIgnoreCase("Child")){
                    sendTextById(TRAVELLERS_LAST_NAME, Labels_Hotels.CHILD_TRAVELLERS_LAST_NAME);
                    closeTheKeyboard_Android();
                }else {
                    Logger.logError("Incorrect travellers type is parsed");
                }
            }else if (parsingTravellersNumber < 4){
            if (travellersType.equalsIgnoreCase("Adult")){
                findElementByXPathAndClick(xpathOfParsingTravellersLastName);
                sendTextById(TRAVELLERS_LAST_NAME, Labels_Hotels.ADULT_TRAVELLERS_LAST_NAME);
                closeTheKeyboard_Android();
            }else if (travellersType.equalsIgnoreCase("Child")){
                findElementByXPathAndClick(xpathOfParsingTravellersLastName);
                sendTextById(TRAVELLERS_LAST_NAME, Labels_Hotels.CHILD_TRAVELLERS_LAST_NAME);
                closeTheKeyboard_Android();
            }else {
                Logger.logError("Incorrect travellers type is parsed");
            }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers last name");
        }
    }

    /**
     * Tap on save button
     */
    @Override
    public void tapOnSaveButton() {
        Logger.logAction("Tapping on save travellers details button");
        try{
            if (isElementDisplayedById(SAVE_BUTTON)){
                driver.findElementById(SAVE_BUTTON).click();
                Logger.logComment(SAVE_BUTTON+" :- element name is selected");
            }else {
//                if (isElementDisplayedByName("Next")) // Implement a method such that should verify multiple travellers info (Verify the save button name if it is NEXT, return false and call a method that enters the other travellers info), this process needs to be continued till save button is displayed.
                Logger.logError("Save button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the save button in the current active screen");
        }
    }

}
