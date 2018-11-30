package com.automation.rehlat.hotels.pages.hotelProfile;


import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;

public class HotelsProfileAndroid extends HotelsProfileBase {

    public static final String ABOUT_HOTEL_LABEL_ID = "com.app.rehlat:id/abouthotel_text";
    public static final String HOTEL_POLICY_LABEL_ID = "com.app.rehlat:id/hotel_policy_details";
    public static final String REVIEWS_LABEL_ID = "com.app.rehlat:id/review_title_hotel_details";
    public static final String SELECT_ROOM_BUTTON_ID = "com.app.rehlat:id/select_room_text";
    public static final String LOADING_INDICATOR_ID_ON_SELECT_ROOM_BUTTON = "com.app.rehlat:id/select_room_text_progressbar";
    public static final String CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE  = "com.app.rehlat:id/noHotelFareDifference";
    public static final String SEE_AVAILABLE_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE  = "com.app.rehlat:id/yesHotelFareDifference";
    public static final String CHANGE_YOUR_DATES_BUTTON_LABEL  = "Change your Dates";
    public static final String OK_BUTTON_IN_ROOM_SOLD_OUT_ALERT_ID  = "com.app.rehlat:id/noHotelFareDifference";
    public static final String PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW = "com.app.rehlat:id/hotelDetailsfooter_total_fare_textview";

    /**
     * Check the hotel profile screen is displayed
     */
    @Override
    public void checkTheHotelProfileScreenIsDisplayed(){
        Logger.logAction("Checking the hotel screen is displayed or not ?");
        try {
            if ((isElementDisplayedById(ABOUT_HOTEL_LABEL_ID)) || isElementDisplayedById(HOTEL_POLICY_LABEL_ID) || isElementDisplayedById(REVIEWS_LABEL_ID)){
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
            Double hotelPriceInHotelProfilePage = getThePriceDisplayedInTheHotelsProfileFooterView();
            Double selectedHotelPriceInSRP = Double.parseDouble(Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP);
            if ((hotelPriceInHotelProfilePage == selectedHotelPriceInSRP) || (hotelPriceInHotelProfilePage .equals(selectedHotelPriceInSRP))){
                Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN = String.valueOf(hotelPriceInHotelProfilePage);
                Logger.logStep("Selected hotel price in SRP and Hotel profile screen are same");
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
     * Get the price displayed in the hotels profile footer view
     * @return
     */
    public static Double getThePriceDisplayedInTheHotelsProfileFooterView(){
        Logger.logAction("Getting the price displayed in the hotels profile footer view");
        try {
            String hotelPriceInFooterViewWithCurrency = findElementByIdAndReturnText(PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW);
            String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
            return Double.parseDouble(hotelPriceWithoutCurrency);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the price displayed in the hotels profile footer view");
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
            findElementByIdAndClick(SELECT_ROOM_BUTTON_ID);
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
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(LOADING_INDICATOR_ID_ON_SELECT_ROOM_BUTTON,2);
            if (isElementEnabledById(CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE)){
                String alertMessageName = findElementByIdAndReturnText(CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE);
                if (alertMessageName.equalsIgnoreCase(CHANGE_YOUR_DATES_BUTTON_LABEL)){
                    Logger.logStep("SoldOut alert is displayed");
                    return true;
                }else {
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
            boolean status = findElementByIdAndClick(CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE);
            if (status == true){
                Logger.logComment("Tapped on change your dates button in the sold out alert");
            }else {
                Logger.logError("Didnn't tapped on change your dates button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in sold out alert");
        }
    }

    /**
     * Tapped on see available properties button in the sold out alert
     */
    @Override
    public void tapOnSeeAvailablePropertiesButtonInSoldOutAlert(){
        Logger.logAction("Tapping on see available properties button in the sold out alert");
        try{
            boolean status = findElementByIdAndClick(SEE_AVAILABLE_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE);
            if (status == true){
                Logger.logComment("Tapped on see available properties button in the sold out alert");
            }else {
                Logger.logError("Didn't tapped on see available properties button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on see available properties button in sold out alert");
        }
    }

}
