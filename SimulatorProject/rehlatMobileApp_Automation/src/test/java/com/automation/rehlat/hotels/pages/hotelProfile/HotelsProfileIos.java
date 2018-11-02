package com.automation.rehlat.hotels.pages.hotelProfile;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;

public class HotelsProfileIos extends HotelsProfileBase {

    public static final String ABOUT_HOTEL_LABEL_ID = "About Hotel";
    public static final String HOTEL_POLICY_LABEL_ID = "Read More";
    public static final String AMENITIES_LABEL_ID = "Amenities";
    public static final String PRICE_ID_IN_FOOTER_VIEW_OF_HOTEL_PROFILE_PAGE = "//XCUIElementTypeStaticText[@name=\"ProfilePriceInFooter\"]";
    public static final String SELECT_ROOM_BUTTON_ID = "Select Room";
    public static final String XPATH_OF_SOLD_OUT_ALERT  = "//XCUIElementTypeImage[@name=\"hotel_sold_out\"]";
    public static final String SOLD_OUT_ALERT_ID_MESSAGE  = "hotel_sold_out";
    public static final String CHANGE_DATES_BUTTON_IN_SOLD_OUT_ALERT_ID  = "Change your Dates";
    public static final String SEE_AVAILABLE_PROPERTIES_BUTTON_IN_SOLD_OUT_ALERT_ID  = "See Available Properties";


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
            Logger.logComment("Selected Hotel price in the SRP is :- "+hotelPriceInHotelProfilePage);
            if ((hotelPriceInHotelProfilePage == selectedHotelPriceInSRP) || (hotelPriceInHotelProfilePage.equals(selectedHotelPriceInSRP))){
                Logger.logStep("Selected hotel price in SRP and hotel profile screen are same");
            }else {
                Logger.logError("Selected hotel price in SRP and hotel profile screen are not same");
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
            if (isElementDisplayedByXPath(XPATH_OF_SOLD_OUT_ALERT)) {
                String alertMessageName = findElementByXpathAndReturnItsAttributeName(XPATH_OF_SOLD_OUT_ALERT);
                if (alertMessageName.equalsIgnoreCase(SOLD_OUT_ALERT_ID_MESSAGE)) {
                    Logger.logStep("SoldOut alert is displayed");
                    return true;
                } else {
                    Logger.logComment("Sold out alert is not displayed");
                }
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
            boolean status = findElementByAccessibilityIdAndClick(CHANGE_DATES_BUTTON_IN_SOLD_OUT_ALERT_ID);
            if (status==true){
                Logger.logComment("Tapped on change your dates button in the sold out alert");
            }else {
                Logger.logError("Unable to tap on change your dates button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in sold out alert");
        }
    }

    /**
     * Tapped on change your dates button in the sold out alert
     */
    @Override
    public void tapOnSeeAvailablePropertiesButtonInSoldOutAlert(){
        Logger.logAction("Tapping on change your dates button in the sold out alert");
        try{
            boolean status = findElementByAccessibilityIdAndClick(SEE_AVAILABLE_PROPERTIES_BUTTON_IN_SOLD_OUT_ALERT_ID);
            if (status==true){
                Logger.logComment("Tapped on change your dates button in the sold out alert");
            }else {
                Logger.logError("Unable to tap on change your dates button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in sold out alert");
        }
    }
}
