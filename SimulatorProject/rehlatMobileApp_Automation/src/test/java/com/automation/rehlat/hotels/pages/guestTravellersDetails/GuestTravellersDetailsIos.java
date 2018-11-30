package com.automation.rehlat.hotels.pages.guestTravellersDetails;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.General;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GuestTravellersDetailsIos extends GuestTravellersDetailsBase{


    public static final String TRAVELLERS_FIRST_NAME="First Name";
    public static final String TRAVELLERS_LAST_NAME="Last Name";
    public static final String CONTINUE_BUTTON="Continue";
    public static final String NEXT_BUTTON="Next";
    public static final String CLOSE_BUTTON_OF_TRAVELLERS_DETAILS_SCREEN ="crossButton";
    public static final String TRAVELLERS_PRE_POPULATE_MODAL_VIEW = "Populate the fields with your previous inputs?";
    public static final String ID_OF_TRAVELLERS_LAST_NAME = "LastName_TF";
    public static final String ID_OF_TRAVELLERS_FIRST_NAME = "FirstName_TF";
    public static final String XPATH_OF_TRAVELLERS_CARD_ROOM_NUMBER_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout[";
    public static final String XPATH_OF_TRAVELLERS_FIRST_NAME_WHEN_MORE_THAN_ONE_GUEST_WITHOUT_INDEX = "(//XCUIElementTypeTextField[@name=\"FirstName_TF\"])[";
    public static final String XPATH_OF_TRAVELLERS_LAST_NAME_WHEN_ONE_GUEST_WITHOUT_INDEX  = "(//XCUIElementTypeTextField[@name=\"LastName_TF\"])[";


    /**
     * Check the travellers details screen is displayed
     */
    @Override
    public void checkTravellersDetailsScreenIsDisplayed() {
        Logger.logAction("Checking the travellers details screen is displayed or not ?");
        try {
            Thread.sleep(2000);
            if (isElementDisplayedByAccessibilityId(CONTINUE_BUTTON) & isElementDisplayedByAccessibilityId(CLOSE_BUTTON_OF_TRAVELLERS_DETAILS_SCREEN)){
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
            GuestTravellersDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
            GuestTravellersDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            enterAdultTravellersDetails("Adult",1); // Todo:- Adult number is hardcoded to 1 as one adult details are enough for hotel booking
            //Todo:- Below logic is to be enabled when all the selected adults and the child details are needed to add
//            Integer enteringTravellersAdultCount = 1;
//            Integer enteringTravellersChildCount = 1;
//            Integer childCardViewNumber;
//            GuestTravellersDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
//            GuestTravellersDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
//            while (enteringTravellersAdultCount < parsingGuestTravellersAdultCount){
//                enterAdultTravellersDetails("Adult",enteringTravellersAdultCount);
//                enteringTravellersAdultCount++;
//            }
//            while (enteringTravellersChildCount < parsingGuestTravellersChildCount){
//                childCardViewNumber = parsingGuestTravellersAdultCount+enteringTravellersChildCount;
//                enterChildTravellersDetails("Child",childCardViewNumber);
//                enteringTravellersChildCount++;
//            }
            //Todo:- Below logic is to be enabled when all the selected adults and the child details are needed to add
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to enter the travellers details of passengers :- "+parsingRoomNumber);
        }
    }

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
//            String xpathOfParsingTravellersFirstName;
            String firstName = General.getTheTestDataOfField("First_Name");
//            if (parsingTravellersNumber >1){
//                xpathOfParsingTravellersFirstName = XPATH_OF_TRAVELLERS_FIRST_NAME_WHEN_MORE_THAN_ONE_GUEST_WITHOUT_INDEX+parsingTravellersNumber+ "]";
//            }else {
//                xpathOfParsingTravellersFirstName = TRAVELLERS_FIRST_NAME_WHEN_ONE_GUEST_WITHOUT_INDEX+parsingTravellersNumber+"]";
//            }
//            if (travellersType.equalsIgnoreCase("Adult")){
            sendTextById(ID_OF_TRAVELLERS_FIRST_NAME,firstName);
            closeTheKeyboard_iOS();
//                sendTextByXpath(TRAVELLERS_FIRST_NAME_WHEN_ONE_GUEST_WITHOUT_INDEX, firstName);
//            }else if (travellersType.equalsIgnoreCase("Child")){
//                sendTextByXpath(xpathOfParsingTravellersFirstName, firstName);
//            }else {
//                Logger.logError("Incorrect travellers type is parsed");
//            }
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
            String lastName = General.getTheTestDataOfField("Last_Name");
//            String xpathOfParsingTravellersFirstName = XPATH_OF_TRAVELLERS_Last_NAME_WHEN_ONE_GUEST_WITHOUT_INDEX+parsingTravellersNumber+"]";
//            if (travellersType.equalsIgnoreCase("Adult")){
            sendTextById(ID_OF_TRAVELLERS_LAST_NAME,lastName);
            closeTheKeyboard_iOS();
//            }else if (travellersType.equalsIgnoreCase("Child")){
//                sendTextByXpath(xpathOfParsingTravellersFirstName, lastName);
//            }else {
//                Logger.logError("Incorrect travellers type is parsed");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers last name");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnSaveButton() {
        Logger.logAction("Tapping on continue travellers details button");
        try{
            boolean status = findElementByAccessibilityIdAndClick(CONTINUE_BUTTON);
            if (status == true){
                Logger.logComment(CONTINUE_BUTTON+" :- element name is clicked");
            }else {
                Logger.logError(CONTINUE_BUTTON+" :- element name is not clicked");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the continue button in the current active screen");
        }
    }


}

