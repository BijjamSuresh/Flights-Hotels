package com.automation.rehlat.hotels.pages.hotelProfile;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;

public class HotelsProfileIos extends HotelsProfileBase {

    public static final String ABOUT_HOTEL_LABEL_ID = "About Hotel";
    public static final String HOTEL_POLICY_LABEL_ID = "Read More";
    public static final String AMENITIES_LABEL_ID = "Amenities";
    public static final String PRICE_ID_IN_FOOTER_VIEW_OF_HOTEL_PROFILE_PAGE = "//XCUIElementTypeStaticText[@name=\"ProfilePriceInFooter\"]";
    public static final String SELECT_ROOM_BUTTON_ID = "Select Room";
    public static final String SOLD_OUT_ALERT_ID  = "hotel_sold_out";
    public static final String CHANGE_YOUR_DATES_LABEL  = "Change your Dates";
    public static final String SEE_AVAILABILITY_PROPERTIES_LABEL = "See Available Properties";
    public static final String CHANGE_YOUR_DATES_BUTTON_ID  = "CustomAlert_Blue_Button";
    public static final String SEE_AVAILABILITY_PROPERTIES_BUTTON_ID  = "CustomAlert_Red_Button";
    public static final String XPATH_OF_CHANGE_DATES_LABEL_IN_SOLD_OUT_ALERT  = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
    public static final String XPATH_OF_SEE_AVAILABLE_PROPERTIES_LABEL_IN_SOLD_OUT_ALERT  = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";


    /**
     * Check the hotel profile screen is displayed
     */
    @Override
    public void checkTheHotelProfileScreenIsDisplayed(){
        Logger.logAction("Checking the hotel screen is displayed or not ?");
        try {
            if ((isElementDisplayedByAccessibilityId(ABOUT_HOTEL_LABEL_ID)) || isElementDisplayedByAccessibilityId(HOTEL_POLICY_LABEL_ID) || isElementDisplayedByAccessibilityId(AMENITIES_LABEL_ID)){
                Logger.logStep("Hotel Profile page is displayed");
            }else {
                Logger.logError("Hotel profile screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the hotel profile screen is displayed or not ?");
        }
    }

    /**
     * Compare the selected hotel price in SRP and in hotel profile screens
     */
    @Override
    public void compareSelectedHotelPriceInSRPAndInHotelProfileScreens(){
        try {
            Double hotelPriceInHotelProfilePage = getTheBookingPriceDisplayedInFooterView();
            Logger.logComment("Hotel price in the footer view of profile screen is :- "+hotelPriceInHotelProfilePage);
            Double selectedHotelPriceInSRP = Double.valueOf(Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP);
            Logger.logComment("Selected Hotel price in the SRP is :- "+selectedHotelPriceInSRP);
            if ((hotelPriceInHotelProfilePage == selectedHotelPriceInSRP) || (hotelPriceInHotelProfilePage.equals(selectedHotelPriceInSRP))){
                Logger.logStep("Selected hotel price in SRP and hotel profile screen are same");
                Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN = String.valueOf(hotelPriceInHotelProfilePage);
            }else {
                Logger.logComment("Selected hotel price in SRP screen is :- "+selectedHotelPriceInSRP);
                Logger.logComment("Selected hotel price in hotel profile page :- "+hotelPriceInHotelProfilePage);
                Logger.logStep("Selected hotel price in SRP and Hotel profile screen are not same but continuing with the latest hotel price as :- "+hotelPriceInHotelProfilePage);
                Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN = String.valueOf(hotelPriceInHotelProfilePage);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- unable to compare the selected hotel price in srp and hotel profile screen");
        }
    }

    /**
     * Get the booking price displayed in the footer view layout
     * @return
     */
    public static Double getTheBookingPriceDisplayedInFooterView(){
        Logger.logAction("Getting the booking price displayed in footer view");
        try{
            String hotelPriceInFooterViewWithCurrency = findElementByXpathAndReturnItsAttributeValue(PRICE_ID_IN_FOOTER_VIEW_OF_HOTEL_PROFILE_PAGE);
            String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL);
            if (hotelPriceWithoutCurrency.contains(Labels_Hotels.STRING_COMMA)) {
                String hotelPriceWithoutComma = hotelPriceWithoutCurrency.replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
                return Double.parseDouble(hotelPriceWithoutComma);
            }else {
                return Double.parseDouble(hotelPriceWithoutCurrency);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking price displayed in footer view");
        }
        return null;
    }

    /**
     * Tap on select room button
     */
    @Override
    public void tapOnSelectRoomButton(){
        Logger.logAction("Tapping on select room button");
        try {
            findElementByAccessibilityIdAndClick(SELECT_ROOM_BUTTON_ID);
            Logger.logStep("Tapped on select room button");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on the select rooms button");
        }
    }


    /**
     * Check the sold out error is displayed
     */
    @Override
    public boolean isSoldOutAlertIsDisplayed(){
        Logger.logAction("Checking the sold out alert is displayed or not ?");
        try {
            if (isElementDisplayedByAccessibilityId(SOLD_OUT_ALERT_ID)) {
                Logger.logStep("SoldOut alert is displayed");
                return true;
            }else {
                Logger.logComment("Sold out alert is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the alert status");
        }
        return false;
    }

    /**
     * Tapped on change your dates button in the sold out alert
     */
    @Override
    public void tapOnChangeYourDatesButtonInSoldOutAlert(){
        Logger.logAction("Tapping on change your dates button in the sold out alert");
        try{
            String nameString = findElementByXpathAndReturnItsAttributeName(XPATH_OF_CHANGE_DATES_LABEL_IN_SOLD_OUT_ALERT);
            if (nameString.equalsIgnoreCase(CHANGE_YOUR_DATES_LABEL)){
                boolean status = findElementByAccessibilityIdAndClick(CHANGE_YOUR_DATES_BUTTON_ID);
                if (status == true){
                    Logger.logComment("Tapped on change your dates button in the sold out alert");
                }else {
                    Logger.logError("Didn't tapped on change your dates button in the sold out alert");
                }
            }else {
                Logger.logError("Unable to tap on change your dates button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on change dates button in sold out alert");
        }
    }

    /**
     * Tapped on see available properties button in the sold out alert
     */
    @Override
    public void tapOnSeeAvailablePropertiesButtonInSoldOutAlert(){
        Logger.logAction("Tapping on see available properties button in the sold out alert");
        try{
            String nameString = findElementByXpathAndReturnItsAttributeName(XPATH_OF_SEE_AVAILABLE_PROPERTIES_LABEL_IN_SOLD_OUT_ALERT);
            if (nameString.equalsIgnoreCase(SEE_AVAILABILITY_PROPERTIES_LABEL)){
                boolean status = findElementByAccessibilityIdAndClick(SEE_AVAILABILITY_PROPERTIES_BUTTON_ID);
                if (status==true){
                    Logger.logComment("Tapped on see available properties button in the sold out alert");
                }else {
                    Logger.logError("Didn't tapped on see available properties button in the sold out alert");
                }
            }else {
                Logger.logError("Unable to tap on see available properties button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on see available properties button in sold out alert");
        }
    }
}
