package com.automation.rehlat.flights.pages.myProfile;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyProfileIos extends MyProfileBase {

    public static final String MY_PROFILE_TITLE = "My Profile";
    public static final String XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther";
    public static final String PROFILE_EDIT_ICON = "profile edit icon";
    public static final String LIST_DOWN_ARROW = "listDownArrow arrow";
    public static final String TRAVELLERS_LIST_OPTION = "Travellers List";
    public static final String ADD_TRAVELLERS_ICON = "+";
    public static final String ADD_PROFILE_SCREEN_TITLE ="Add Profile";
    public static final String XPATH_OF_FIRST_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField";
    public static final String XPATH_OF_MIDDLE_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField";
    public static final String XPATH_OF_LAST_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeTextField";
    public static final String XPATH_OF_DATE_OF_BIRTH = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeTextField";
    public static final String XPATH_OF_PASSPORT_NUMBER = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[8]/XCUIElementTypeTextField";
    public static final String XPATH_OF_PASSPORT_EXPIRY_DATE = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[10]/XCUIElementTypeTextField";
    public static final String XPATH_OF_ISSUING_COUNTRY = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[9]/XCUIElementTypeTextField";
    public static final String XPATH_OF_NATIONALITY = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[7]/XCUIElementTypeTextField";
    public static final String XPATH_OF_PHONE_NUMBER_TEXT_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeTextField";
    /**
     * Check my profile screen is displayed
     */
    @Override
    public void checkMyProfileScreenIsDisplayed() {
        Logger.logAction("Checking my profile screen is displayed or not ?");
        try{
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels_Flights.IOS_ACTIVITY_INDICATOR,1);
            if (isElementDisplayedByName(MY_PROFILE_TITLE)){
                Logger.logStep("My Profile screen is displayed");
            }else {
                Logger.logError("My Profile screen is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the profile screen is displayed or not?");
        }
    }

    /**
     * Get the karam points displayed in the karam and trips layout
     */
    @Override
    public void getTheKaramPointsDisplayedInKaramPointsAndTripsLayout() {
        Logger.logAction("Get the karam points displayed in the karam and trips layout");
        try {
            if (isElementEnabledByXpath(XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT)){
                WebElement karamPointsAndTripsLayout = driver.findElementByXPath(XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT);
                List<WebElement> staticTextLists  = karamPointsAndTripsLayout.findElements(By.className(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT));
                for (int count =0 ;count <= staticTextLists.size();count++){
                    String eachStaticTextValue = staticTextLists.get(count).getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                    if (eachStaticTextValue.contains(Labels_Flights.DOT_STRING)){
                        Logger.logStep("Karam points cell is displayed");
                        Double karamPoints = Double.valueOf(eachStaticTextValue);
                        Logger.logStep("Displayed karam points are :- "+karamPoints);
                        break;
                    }
                }
            }else {
                Logger.logError("Karam points and trips layout cell is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the karam points displayed in karam points and trips layout");
        }
    }

    /**
     * Get the trips information displayed in the karam and trips layout
     */
    @Override
    public void getTheTripsCountDisplayedInKaramPointsAndTripsLayout() {
        Logger.logAction("Get the trips count displayed in the karam and trips layout");
        try {
            if (isElementEnabledByXpath(XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT)){
                WebElement karamPointsAndTripsLayout = driver.findElementByXPath(XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT);
                List<WebElement> staticTextLists  = karamPointsAndTripsLayout.findElements(By.className(Labels_Flights.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT));
                for (int count =0 ;count <= staticTextLists.size();count++){
                    String eachStaticTextValue = staticTextLists.get(count).getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                    if (eachStaticTextValue.contains(Labels_Flights.DOT_STRING)){
                        count = count +1;
                        Logger.logStep("Trips Count cell is displayed");
                        String tripsCount = staticTextLists.get(count).getAttribute(Labels_Flights.VALUE_ATTRIBUTE);
                        Double displayingTripsCount = Double.valueOf(tripsCount);
                        Logger.logStep("Displayed trips count is :- "+displayingTripsCount);
                        break;
                    }
                }
            }else {
                Logger.logError("Karam points and trips layout cell is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the karam points displayed in karam points and trips layout");
        }
    }

    /**
     * Tap on profile edit icon
     */
    @Override
    public void tapOnProfileEditIcon() {
        Logger.logAction("Tapping on edit travellers information button");
        try {
            findElementByNameAndClick(PROFILE_EDIT_ICON);
            Logger.logComment("Tapped on profile edit icon");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on edit travellers button");
        }
    }

    /**
     * Tap on add travellers icon
     */
    @Override
    public void tapOnAddTravellersIcon() {
        Logger.logAction("Tapping on add travellers icon");
        try {
            scrollDown();
            findElementByNameAndClick(ADD_TRAVELLERS_ICON);
            Logger.logComment("Tapped on add travellers icon");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on add travellers icon");
        }
    }

    /**
     * Tap on travellers list option
     */
    @Override
    public void tapOnAddTravellersListOption() {
        Logger.logAction("Tapping on travellers list option");
        try {
            findElementByNameAndClick(TRAVELLERS_LIST_OPTION);
            Logger.logComment("Tapped on travellers list option");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on travellers list option");
        }
    }

    /**
     * Check Add Travellers screen is displayed
     */
    @Override
    public void checkAddTravellersScreenIsDisplayed() {
        Logger.logAction("Check add travellers screen is displayed");
        try {
            if (isElementDisplayedByName(ADD_PROFILE_SCREEN_TITLE)){
                Logger.logStep("Add profile screen is displayed");
            }else {
             Logger.logError("Add profile screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Unable to check the current screen title");
        }
    }

    //Todo:- Once the TFS Id #: "Keyboard is not triggered after tapping on the label name [Eg: 'First Name'] when the text field is filled with some text" is fixed need to update the below commented methods
//
//    /**
//     * Update the travellers first name
//     * @param parsingTravellersFirstName
//     * @return
//     */
//    public static String  updateTravellersFirstNameAs(String parsingTravellersFirstName){
//        Logger.logAction("Update the travellers first name as :- "+parsingTravellersFirstName);
//        try {
//            String travellersFirstName = findElementByXpathAndReturnItsAttributeName(XPATH_OF_FIRST_NAME);
//            if (travellersFirstName == null){
//                Logger.logComment("Travellers first name is :- "+null+" ,going to enter the name as :- "+parsingTravellersFirstName);
//                TravellerDetailsIos.enterTravellersFirstName();
//                return parsingTravellersFirstName;
//            }else if (travellersFirstName != parsingTravellersFirstName){
//                Logger.logComment("Travellers first name is :- "+travellersFirstName+" ,going to re-enter the name as :- "+parsingTravellersFirstName);
//                sendTextByXpath(XPATH_OF_FIRST_NAME,parsingTravellersFirstName);
//                return travellersFirstName;
//            }else if (travellersFirstName == parsingTravellersFirstName){
//                Logger.logComment("Travellers first name is already entered as :- "+parsingTravellersFirstName);
//            }else {
//                Logger.logError("Encountered error: Unable to update the travelers first name as :- "+parsingTravellersFirstName);
//            }
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to update the travelers first name");
//        }
//        return null;
//    }
//
//    /**
//     * Update the travellers first name
//     * @param parsingTravellersMiddleName
//     * @return
//     */
//    public static String  updateTravellersMiddleNameAs(String parsingTravellersMiddleName){
//        Logger.logAction("Update the travellers middle name as :- "+parsingTravellersMiddleName);
//        try {
//            String travellersMiddleName = findElementByXpathAndReturnItsAttributeName(XPATH_OF_MIDDLE_NAME);
//            if (travellersMiddleName == null){
//                Logger.logComment("Travellers middle name is :- "+null+" ,going to enter the name as :- "+parsingTravellersMiddleName);
//                TravellerDetailsIos.enterTravellersFirstName();
//                return parsingTravellersMiddleName;
//            }else if (travellersMiddleName != parsingTravellersMiddleName){
//                Logger.logComment("Travellers middle name is :- "+travellersMiddleName+" ,going to re-enter the name as :- "+parsingTravellersMiddleName);
//                sendTextByXpath(XPATH_OF_MIDDLE_NAME,parsingTravellersMiddleName);
//                return travellersMiddleName;
//            }else if (travellersMiddleName == parsingTravellersMiddleName){
//                Logger.logComment("Travellers first name is already entered as :- "+parsingTravellersMiddleName);
//            }else {
//                Logger.logError("Encountered error: Unable to update the travelers middle name as :- "+parsingTravellersMiddleName);
//            }
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to update the travelers middle name");
//        }
//        return null;
//    }
//
//    /**
//     * Update the travellers first name
//     * @param parsingTravellersLastName
//     * @return
//     */
//    public static String  updateTravellersLasttNameAs(String parsingTravellersLastName){
//        Logger.logAction("Update the travellers last name as :- "+parsingTravellersLastName);
//        try {
//            String travellersLastName = findElementByXpathAndReturnItsAttributeName(XPATH_OF_LAST_NAME);
//            if (travellersLastName == null){
//                Logger.logComment("Travellers last name is :- "+null+" ,going to enter the name as :- "+parsingTravellersLastName);
//                TravellerDetailsIos.enterTravellersFirstName();
//                return parsingTravellersLastName;
//            }else if (parsingTravellersLastName != travellersLastName){
//                Logger.logComment("Travellers last name is :- "+travellersLastName+" ,going to re-enter the name as :- "+parsingTravellersLastName);
//                sendTextByXpath(XPATH_OF_LAST_NAME,parsingTravellersLastName);
//                return travellersLastName;
//            }else if (parsingTravellersLastName == travellersLastName){
//                Logger.logComment("Travellers last name is already entered as :- "+parsingTravellersLastName);
//            }else {
//                Logger.logError("Encountered error: Unable to update the travelers last name as :- "+parsingTravellersLastName);
//            }
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to update the travelers last name");
//        }
//        return null;
//    }
//
//    /**
//     * Set the contact country code
//     */
//    public static void setTheContactConutryCode(String parsingCountryCode){
//        Logger.logAction("Setting the country code");
//        try {
//            tapOnCountryCodeListDownArrowButton();
//            TravellerDetailsIos.chooseCountry(parsingCountryCode);
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to set the country code");
//        }
//    }
//
//    /**
//     * Tap on country code list down arrow button
//     */
//    public static void tapOnCountryCodeListDownArrowButton(){
//        Logger.logAction("Tapping on country code list down arrow button");
//        try {
//            findElementByNameAndClick(LIST_DOWN_ARROW);
//            Logger.logComment("Tapped on list down country code button");
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to tap on the country code list down arrow button");
//        }
//    }
//
//
//    /**
//     * Update the phone number
//     */
//    public static String updateThePhoneNumber(String parsingContactNumber){
//        Logger.logAction("Updating the contact phone number");
//        try {
//            String travellersPhoneNumber = findElementByXpathAndReturnItsAttributeName(XPATH_OF_PHONE_NUMBER_TEXT_FIELD);
//            if (travellersPhoneNumber == null){
//                Logger.logComment("Travellers phone number is :- "+null+" ,going to enter the number as :- "+parsingContactNumber);
//                TravellerDetailsIos.enterTravellersDateOfBirth();
//                return parsingContactNumber;
//            }else {
//                Logger.logComment("Travellers phone number is :- "+travellersPhoneNumber+" ,going to re-enter the number as :- "+parsingContactNumber);
//                sendTextByXpath(XPATH_OF_LAST_NAME,parsingContactNumber);
//                return travellersPhoneNumber;
//            }
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to tap on the country code list down arrow button");
//        }
//        return null;
//    }
//
//    /**
//     * Update the date of birth
//     */
//    public static String updateTheDateOfBirth(String parsingDateOfBirth){
//        Logger.logAction("Updating the date of birth");
//        try {
//            String travellersPhoneNumber = findElementByXpathAndReturnItsAttributeName(XPATH_OF_DATE_OF_BIRTH);
//            if (travellersPhoneNumber == null){
//                Logger.logComment("Travellers phone number is :- "+null+" ,going to enter the number as :- "+parsingDateOfBirth);
//                TravellerDetailsIos.enterTravellersDateOfBirth();
//                return parsingDateOfBirth;
//            }else {
//                Logger.logComment("Travellers phone number is :- "+travellersPhoneNumber+" ,going to re-enter the number as :- "+parsingDateOfBirth);
//                TravellerDetailsIos.enterTravellersDateOfBirth();
//                return travellersPhoneNumber;
//            }
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to tap on the country code list down arrow button");
//        }
//        return null;
//    }
    //Todo:- Once the TFS Id #: "Keyboard is not triggered after tapping on the label name [Eg: 'First Name'] when the text field is filled with some text" is fixed need to update the above commented methods


}
