package com.automation.rehlat.hotels.pages.hotelProfile;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;

public class HotelsProfileIos extends HotelsProfileBase {

    public static final String ABOUT_HOTEL_LABEL_ID = "com.app.rehlat:id/abouthotel_text";
    public static final String HOTEL_POLICY_LABEL_ID = "com.app.rehlat:id/hotel_policy_details";
    public static final String REVIEWS_LABEL_ID = "com.app.rehlat:id/review_title_hotel_details";
    public static final String PRICE_ID_IN_FOOTER_VIEW_OF_HOTEL_PROFILE_PAGE = "com.app.rehlat:id/footer_total_fare_textview";
    public static final String SELECT_ROOM_BUTTON_ID = "com.app.rehlat:id/select_room_text";
    public static final String SOLD_OUT_ALERT_ID  = "com.app.rehlat:id/networkErrormsgTextview";
    public static final String SOLD_OUT_ALERT_ID_MESSAGE  = "Sorry, seems the Hotel has been sold out. Please search for another hotel for booking.";
    public static final String OK_BUTTON_IN_SOLD_OUT_ALERT_ID  = "com.app.rehlat:id/okBtn";

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
            Double hotelPriceInHotelProfilePage = getTheBookingPriceDisplayedInFooterView();
            Double selectedHotelPriceInSRP = Double.parseDouble(Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP);
            if (hotelPriceInHotelProfilePage == selectedHotelPriceInSRP){
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
            String hotelPriceInFooterViewWithCurrency = findElementByIdAndReturnText(PRICE_ID_IN_FOOTER_VIEW_OF_HOTEL_PROFILE_PAGE);
            String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
            return Double.parseDouble(hotelPriceWithoutCurrency);
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
            String alertMessageName = findElementByIdAndReturnText(SOLD_OUT_ALERT_ID);
            if (alertMessageName.equalsIgnoreCase(SOLD_OUT_ALERT_ID_MESSAGE)){
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
            findElementByIdAndClick(OK_BUTTON_IN_SOLD_OUT_ALERT_ID);
            Logger.logComment("Tapped on change your dates button in the sold out alert");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in sold out alert");
        }
    }
}
