package com.automation.rehlat.hotels.pages.guestTravellersDetails;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GuestTravellersDetailsIos extends GuestTravellersDetailsBase{


    public static final String TRAVELLERS_FIRST_NAME="First Name";
    public static final String TRAVELLERS_LAST_NAME="Last Name";
    public static final String SAVE_BUTTON="Save";
    public static final String NEXT_BUTTON="Next";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE ="Traveller Details";
    public static final String TRAVELLERS_PRE_POPULATE_MODAL_VIEW = "Populate the fields with your previous inputs?";
    public static final String XPATH_OF_ROOM_NUMBER_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[";
    public static final String XPATH_OF_ROOM_NUMBER_NAME_WITHOUT_ROOM_NUMBER_XPATH = "]/android.widget.TextView";
    public static final String XPATH_OF_TRAVELLERS_CARD_VIEW_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout[";
    public static final String XPATH_OF_TRAVELLERS_FIRST_NAME_WITHOUT_XPATH_OF_CARD_NUMBER = "]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText";
    public static final String XPATH_OF_TRAVELLERS_Last_NAME_WITHOUT_XPATH_OF_CARD_NUMBER = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout[";


    /**
     * Check the travellers details screen is displayed
     */
    @Override
    public void checkTravellersDetailsScreenIsDisplayed() {
        Logger.logAction("Checking the travellers details screen is displayed or not ?");
        try {
            Thread.sleep(2000);
            if (isElementEnabledByName(TRAVELLERS_DETAILS_SCREEN_TITLE)){
                Logger.logStep("Travellers details screen is displayed");
            } else {
                Logger.logError("Travellers details screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the current active screen name");
        }
    }

    /**
     * Accept the auto fill populate modal if displayed
     */
    @Override
    public boolean acceptAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Accepting the auto fill popup if displayed");
        try{
            if (isElementDisplayedByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_SHEET)){
                WebElement popUpModal = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_SHEET);
                String popUpModalTitle = popUpModal.findElement(By.className(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels_Hotels.NAME_ATTRIBUTE);
                if (popUpModalTitle.equals(TRAVELLERS_PRE_POPULATE_MODAL_VIEW)){
                    Logger.logStep("Auto fill popup modal is displayed and going to accept it");
                    if (isElementDisplayedByName(YES_BUTTON)){
                        driver.findElementByName(YES_BUTTON).click();
                        Logger.logComment("Tapped on yes button");
                        return true;
                    }else{
                        Logger.logError("Button with - Yes - name is not displayed in the popup");
                    }
                }else{
                    Logger.logError("Auto fill PopUp is not displayed but a popup is displayed with different title");
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
     * Decline the auto fill populate modal if displayed
     */
    @Override
    public boolean declineAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Declining the auto fill popup if displayed");
        try{
            if (isElementDisplayedByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_SHEET)){
                WebElement popUpModal = driver.findElementByClassName(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_SHEET);
                String popUpModalTitle = popUpModal.findElement(By.className(Labels_Hotels.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels_Hotels.NAME_ATTRIBUTE);
                if (popUpModalTitle.equals(TRAVELLERS_PRE_POPULATE_MODAL_VIEW)){
                    Logger.logStep("Auto fill popup modal is displayed and going to decline it");
                    if (isElementDisplayedByName(NO_BUTTON)){
                        driver.findElementByName(NO_BUTTON).click();
                        Logger.logComment("Tapped on no button");
                        return true;
                    }else{
                        Logger.logError("Button with - No - name is not displayed in the popup");
                    }
                }else{
                    Logger.logError("Auto fill PopUp is not displayed but a popup is displayed with different title");
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
     * Enter travellers details for passengers
     * @param parsingRoomNumber,parsingGuestTravellersAdultCount,parsingGuestTravellersChildCount
     */
    @Override
    public void enterTravellersDetailsForPassengers(Integer parsingRoomNumber, Integer parsingGuestTravellersAdultCount, Integer parsingGuestTravellersChildCount){
        Logger.logAction("Entering the travelling details of passengers :-"+parsingRoomNumber);
        try {
            Integer enteringTravellersAdultCount = 1;
            Integer enteringTravellersChildCount = 1;
            Integer childCardViewNumber;
            GuestTravellersDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
            GuestTravellersDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            if(isTheSelectedTravellerTypeof(parsingRoomNumber)){
                while (enteringTravellersAdultCount < parsingGuestTravellersAdultCount){
                    enterAdultTravellersDetails("Adult",enteringTravellersAdultCount);
                    enteringTravellersAdultCount++;
                }
                while (enteringTravellersChildCount < parsingGuestTravellersChildCount){
                    childCardViewNumber = parsingGuestTravellersAdultCount+enteringTravellersChildCount;
                    enterChildTravellersDetails("Child",childCardViewNumber);
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
    public static boolean isTheSelectedTravellerTypeof(Integer roomNumber){
        Logger.logAction("Getting the travellers type");
        try {
            String xpathOfRoomNumberName = XPATH_OF_ROOM_NUMBER_NAME_WITHOUT_ROOM_NUMBER_XPATH+roomNumber+XPATH_OF_ROOM_NUMBER_WITHOUT_INDEX;
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
    public static void enterAdultTravellersDetails(String travellersType, Integer parsingAdultNumber) {
        Logger.logAction("Entering adult travellers details");
        try{
            enterTravellersFirstName(travellersType,parsingAdultNumber);
            enterTravellersLastName(travellersType,parsingAdultNumber);
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to enter the adult travellers details");
        }
    }

    /**
     * Enter the child travellers details
     */
    public static void enterChildTravellersDetails(String travellersType, Integer parsingChildNumber) {
        Logger.logAction("Entering child travellers details");
        try{
            enterTravellersFirstName(travellersType,parsingChildNumber);
            enterTravellersLastName(travellersType,parsingChildNumber);
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to enter the child travellers details");
        }
    }

    /**
     * Enter the travellers first name
     */
    public static void enterTravellersFirstName(String travellersType, Integer parsingTravellersNumber) {
        Logger.logStep("Entering travellers first name");
        try{
            String xpathOfParsingTravellersFirstName = XPATH_OF_TRAVELLERS_CARD_VIEW_WITHOUT_INDEX+parsingTravellersNumber+XPATH_OF_TRAVELLERS_FIRST_NAME_WITHOUT_XPATH_OF_CARD_NUMBER;
            if (travellersType.equalsIgnoreCase("Adult")){
                sendTextByXpath(xpathOfParsingTravellersFirstName, Labels_Hotels.ADULT_TRAVELLERS_FIRST_NAME);
            }else if (travellersType.equalsIgnoreCase("Child")){
                sendTextByXpath(xpathOfParsingTravellersFirstName, Labels_Hotels.CHILD_TRAVELLERS_FIRST_NAME);
            }else {
                Logger.logError("Incorrect travellers type is parsed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers first name");
        }
    }

    /**
     * Enter the travellers last name
     */
    public static void enterTravellersLastName(String travellersType, Integer parsingTravellersNumber) {
        Logger.logStep("Entering travellers last name");
        try{
            String xpathOfParsingTravellersFirstName = XPATH_OF_TRAVELLERS_CARD_VIEW_WITHOUT_INDEX+parsingTravellersNumber+XPATH_OF_TRAVELLERS_Last_NAME_WITHOUT_XPATH_OF_CARD_NUMBER;
            if (travellersType.equalsIgnoreCase("Adult")){
                sendTextByXpath(xpathOfParsingTravellersFirstName, Labels_Hotels.ADULT_TRAVELLERS_LAST_NAME);
            }else if (travellersType.equalsIgnoreCase("Child")){
                sendTextByXpath(xpathOfParsingTravellersFirstName, Labels_Hotels.CHILD_TRAVELLERS_FIRST_NAME);
            }else {
                Logger.logError("Incorrect travellers type is parsed");
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

