package com.automation.rehlat.hotels.pages.selectRooms;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.pages.BasePage;

public class SelectRoomsIos extends SelectRoomsBase {

    public static final String SELECT_ROOM_SCREEN_TITLE_LABEL = "com.app.rehlat:id/roomSelectLayoutHeadingView";
    public static final String XPATH_OF_ROOM_CELL_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";
    public static final String XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX = "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]";
    public static final String CONTINUE_BUTTON_ID = "com.app.rehlat:id/continue_room_pro_text";
    public static final String SOLD_OUT_ALERT_ID  = "com.app.rehlat:id/networkErrormsgTextview";
    public static final String SOLD_OUT_ALERT_ID_MESSAGE  = "Sorry, seems the Hotel has been sold out. Please search for another hotel for booking.";
    public static final String OK_BUTTON_IN_SOLD_OUT_ALERT_ID  = "com.app.rehlat:id/okBtn";

    /**
     * Check the select rooms screen is displayed
     */
    @Override
    public void checkSelectRoomScreenIsDisplayed() {
        Logger.logAction("Checking select rom screen is displayed or not ?");
        try {
            if (isElementDisplayedById(SELECT_ROOM_SCREEN_TITLE_LABEL)){
                Logger.logStep("Select room screen is displayed");
            }else {
                Logger.logError("Select room screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the select room screen is displayed or not ?");
        }
    }

    /**
     * Tap on select button in a particular room cell number
     * @param parsingRoomCellNumber
     */
    @Override
    public void tapOnSelectButtonInRoomCellNumber(Integer parsingRoomCellNumber, Integer roomNumberToSelect){
        Logger.logAction("Tapping on select button in room cell number :- "+parsingRoomCellNumber);
        try {
            String xpathOfSelectButtonOfParsingCellNumber = XPATH_OF_ROOM_CELL_WITHOUT_INDEX+parsingRoomCellNumber+XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX;
            findElementByXPathAndClick(xpathOfSelectButtonOfParsingCellNumber);
            Logger.logStep("Tapped on select button in the room cell number :- "+parsingRoomCellNumber);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the select button of room cell number :-" +parsingRoomCellNumber);
        }
    }

    /**
     * Get the price of the selected Room number
     * @param parsingRoomCellNumber
     * @return
     */
    public static Double getThePriceOfTheSelectedRoomNumber(Integer parsingRoomCellNumber){
        Logger.logAction("Getting the price of an selected room");
        try {
            String xpathOfRoomPriceInParsingCellNumber = XPATH_OF_ROOM_CELL_WITHOUT_INDEX+parsingRoomCellNumber+XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX;
            String roomPriceInParsingCellNumber = findElementByXpathAndReturnItsAttributeText(xpathOfRoomPriceInParsingCellNumber);
            return Double.parseDouble(roomPriceInParsingCellNumber);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the price of an selected room :- "+parsingRoomCellNumber);
        }
        return null;
    }

    /**
     * Compare the selected room price in the selected rooms screen and in the hotels profile screen
     * @param parsingRoomNumber
     */
    @Override
    public void compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(Integer parsingRoomNumber){
        try {
            Double priceFromHotelProfileScreen = Double.parseDouble(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN);
            Double priceInTheSelectedRoomCellView = getThePriceOfTheSelectedRoomNumber(parsingRoomNumber);
            Double priceInSelectRoomFooterView = BasePage.getTheBookingPriceDisplayedInFooterView();
            if (priceFromHotelProfileScreen == priceInTheSelectedRoomCellView){
                if (priceFromHotelProfileScreen == priceInSelectRoomFooterView){
                    Logger.logStep("Price in the hotel profile screen,selected room cell view and in the select room footer view are not matching");
                }else {
                    Logger.logComment("Price in the hotel profile screen is :- "+priceFromHotelProfileScreen);
                    Logger.logComment("Price in the select room footer view is :- "+priceInTheSelectedRoomCellView);
                    Logger.logError("Price in the hotel profile screen and in the select room footer view are not matching");
                }
            }else {
                Logger.logComment("Price in the hotel profile screen is :- "+priceFromHotelProfileScreen);
                Logger.logComment("Price in the selected room cell view is :- "+priceInTheSelectedRoomCellView);
                Logger.logError("Price in the hotel profile screen and in the selected room cell view are not matching");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to compare the selected room price selected rooms screen and hotels profile screen");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton(){
        try {
            findElementByIdAndClick(CONTINUE_BUTTON_ID);
            Logger.logStep("Tapped on continue button");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on continue button");
        }
    }

    /**
     * Check the sold out error is displayed
     */
    @Override
    public boolean isHotelsSoldOutAlertIsDisplayed(){
        Logger.logAction("Checking the sold out error is displayed or not ?");
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
     * Tapped on ok button in the sold out alert
     */
    @Override
    public void tapOnChangeYourRoomTypeButtonInSoldOutAlert(){
        Logger.logAction("Tapping on ok button in the sold out alert");
        try{
            findElementByIdAndClick(OK_BUTTON_IN_SOLD_OUT_ALERT_ID);
            Logger.logComment("Tapped on on button in the sold out alert");
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in sold out alert");
        }
    }

}
