package com.automation.rehlat.hotels.pages.selectRooms;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;

public class SelectRoomsIos extends SelectRoomsBase {

    public static final String SELECT_ROOM_SCREEN_TITLE_LABEL = "Select Rooms";
    public static final String XPATH_OF_ROOM_CELL_WITHOUT_INDEX_PROS = "(//XCUIElementTypeButton[@name=\"Select\"])[";
    public static final String XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_INDEX_PROS = "(//XCUIElementTypeButton[@name=\"Select\"])[";
    public static final String XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_INDEX_PROS = "(//XCUIElementTypeStaticText[@name=\"HotelSelectProPrice\"])[";
    public static final String XPATH_OF_ROOM_CELL_WITHOUT_INDEX_BEDS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[";
    public static final String XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX_BEDS = "(//XCUIElementTypeButton[@name=\"Select\"])[";
    public static final String XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_INDEX_BEDS = "(//XCUIElementTypeStaticText[@name=\"HotelSelectBedsPrice\"])[";
    public static final String XPATH_OF_ROOM_NUMBER_TAB_WITHOUT_INDEX = "(//XCUIElementTypeOther[@name=\"Room\"])[";
    public static final String CONTINUE_BUTTON_ID_SELECT_ROOM_FOOTER_VIEW = "CONTINUE";
    public static final String LOADING_INDICATOR_ID_IN_FOOTER_VIEW = "com.app.rehlat:id/continue_room_pro_progressbar";
    public static final String LOADING_INDICATOR_ID_OF_VIEW_CHANGE = "com.app.rehlat:id/flight_search_progressbar";
    public static final String SELECT_ROOM_TABS = "com.app.rehlat:id/roomselect_tabs";
    public static final String HOTELS_PRO_LIST_ID_OF_SELECT_ROOM = "com.app.rehlat:id/hotel_selectroom_pro_list";
    public static final String PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_PRO = "//XCUIElementTypeStaticText[@name=\"SelectRoomProFooter\"]";
    public static final String PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_BEDS = "//XCUIElementTypeStaticText[@name=\"SelectRoomBedsFooter\"]";
    public static final String CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE  = "Change your Dates";
    public static final String HOTELS_BEDS_PRICE_LABEL= "HotelSelectBedsPrice";
    public static final String HOTELS_BEDS_SELECTED_ROOM_LAYOUT_LABEL = "SelectedRoomBeds";
    public static final String HOTEL_SOLD_OUT_ALERT_ID  = "hotel_sold_out";
    public static final String CHANGE_YOUR_ROOM_TYPE_LABEL  = "Change your Room type";
    public static final String SEE_AVAILABILITY_PROPERTIES_LABEL = "See Available Properties";
    public static final String CHANGE_YOUR_ROOM_TYPE_BUTTON_ID  = "CustomAlert_Blue_Button";
    public static final String SEE_AVAILABILITY_PROPERTIES_BUTTON_ID  = "CustomAlert_Red_Button";
    public static final String XPATH_OF_CHANGE_ROOM_TYPE_LABEL_IN_SOLD_OUT_ALERT  = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
    public static final String XPATH_OF_SEE_AVAILABLE_PROPERTIES_LABEL_IN_SOLD_OUT_ALERT  = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeStaticText";
    private static String API_RESPONSE_TYPE_IN_SELECT_ROOMS;

    /**
     * Check the select rooms screen is displayed
     */
    @Override
    public void checkSelectRoomScreenIsDisplayed() {
        Logger.logAction("Checking select rom screen is displayed or not ?");
        try {
            if (isElementDisplayedById(SELECT_ROOM_SCREEN_TITLE_LABEL)){
                Logger.logStep("Select room screen is displayed");
                if (isElementDisplayedByAccessibilityId(HOTELS_BEDS_PRICE_LABEL) || isElementDisplayedByAccessibilityId(HOTELS_BEDS_SELECTED_ROOM_LAYOUT_LABEL)){
                    Logger.logStep("Hotel Bed Api response is displayed");
                    API_RESPONSE_TYPE_IN_SELECT_ROOMS = HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS;
                }else{
                    API_RESPONSE_TYPE_IN_SELECT_ROOMS = HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS;
                    Logger.logStep("Hotel pro Api response is displayed");
                }
            }else {
                Logger.logError("Select room screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the select room screen is displayed or not ?");
        }
    }

    /**
     * Tap on select button in a particular room cell number
     * @param totalRooms
     */
    @Override
    public void tapOnSelectButtonInRoomCellNumber(Integer totalRooms, Integer roomNumberToSelect){
        Logger.logAction("Tapping on select button in room cell number :- "+totalRooms);
        Integer roomNumber = 2 ;
        String xpathOfRoomNumberTab;
        Integer roomNumberCountInScrollView;
        try {
            if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                Integer parsingRoomNumberToSelect = roomNumberToSelect;
                String xpathOfSelectButtonOfParsingCellNumber = XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_INDEX_PROS+parsingRoomNumberToSelect+"]";
                findElementByXPathAndClick(xpathOfSelectButtonOfParsingCellNumber);
                Logger.logStep("Tapped on select button in the room cell number :- "+roomNumberToSelect);
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                xpathOfRoomNumberTab = XPATH_OF_ROOM_NUMBER_TAB_WITHOUT_INDEX+1+"]";
                findElementByXPathAndClick(xpathOfRoomNumberTab);
                for (int count =0; count < totalRooms; count++){
                    Integer parsingRoomNumberToSelect =roomNumberToSelect;
                    Thread.sleep(1000);
                    String xpathOfSelectButtonOfParsingCellNumber = XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX_BEDS+parsingRoomNumberToSelect+"]";
                    findElementByXPathAndClick(xpathOfSelectButtonOfParsingCellNumber);
                    Logger.logStep("Tapped on select button in the room cell number :- "+parsingRoomNumberToSelect);
                    if (count >= (totalRooms-1)){
                        break;
                    }else {
                        if (count == 0 ){
                            roomNumberCountInScrollView = count+2;
                        }else {
                            roomNumberCountInScrollView = count+2;
                        }
//                        roomNumber = roomNumberCountInScrollView-2;
                        xpathOfRoomNumberTab = XPATH_OF_ROOM_NUMBER_TAB_WITHOUT_INDEX+roomNumberCountInScrollView+"]";
                        findElementByXPathAndClick(xpathOfRoomNumberTab);
                        Logger.logStep("Tapped on select button in the room cell number :- "+roomNumberCountInScrollView);
                    }
                }
            }else {
                Logger.logError("API response is neither PRO nor BEDS");
            }
        }catch (Exception exception){
            if (roomNumberToSelect >1){
                Logger.logError(roomNumberToSelect+" room type is not displayed in the room number - "+roomNumber);
            }
            Logger.logError("Encountered error: Unable to tap on the select button for room cell numbers :-" +totalRooms);
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
            if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                String xpathOfRoomPriceInParsingCellNumber = XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_INDEX_PROS+parsingRoomCellNumber+"]";
                String roomPriceInParsingCellNumber = findElementByXpathAndReturnItsAttributeText(xpathOfRoomPriceInParsingCellNumber).replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                if (roomPriceInParsingCellNumber.contains(Labels_Hotels.STRING_COMMA)){
                    String roomPriceWithoutComma = roomPriceInParsingCellNumber.replace(Labels_Hotels.STRING_COMMA,Labels_Hotels.STRING_NULL);
                    return Double.parseDouble(roomPriceWithoutComma);
                }else {
                    return Double.parseDouble(roomPriceInParsingCellNumber);
                }
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                String xpathOfRoomPriceInParsingCellNumber = XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_INDEX_BEDS+parsingRoomCellNumber+"]";
                String roomPriceInParsingCellNumber = findElementByXpathAndReturnItsAttributeText(xpathOfRoomPriceInParsingCellNumber).replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                if (roomPriceInParsingCellNumber.contains(Labels_Hotels.STRING_COMMA)){
                    String roomPriceWithoutComma = roomPriceInParsingCellNumber.replace(Labels_Hotels.STRING_COMMA,Labels_Hotels.STRING_NULL);
                    return Double.parseDouble(roomPriceWithoutComma);
                }else {
                    return Double.parseDouble(roomPriceInParsingCellNumber);
                }
            }else {
                Logger.logError("API response is neither PRO nor BEDS");
            }
        }catch (Exception exception){
            exception.printStackTrace();
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
        Logger.logAction("Comparing the selected Room in Select Room screen and the price of hotel profile screen");
        try {
            if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                Double priceFromHotelProfileScreen = Double.valueOf(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN);
                Logger.logComment("Price in the hotel profile screen is :- "+priceFromHotelProfileScreen);
                Double priceInTheSelectedRoomCellView = getThePriceOfTheSelectedRoomNumber(parsingRoomNumber);
                Logger.logComment("Price in the select room is :- "+priceInTheSelectedRoomCellView);
                Double priceInSelectRoomFooterView = getThePriceDisplayedInTheSelectHotelsScreenFooterView();
                Logger.logComment("Price in the footer view is :- "+priceInSelectRoomFooterView);
                if ((priceFromHotelProfileScreen == priceInTheSelectedRoomCellView) || (priceFromHotelProfileScreen.equals(priceInTheSelectedRoomCellView))){
                    if ((priceFromHotelProfileScreen == priceInSelectRoomFooterView) || (priceFromHotelProfileScreen.equals(priceInSelectRoomFooterView))){
                        Logger.logStep("Price in the hotel profile screen,selected room cell view and in the select room footer view are matching");
                        Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_SELECT_ROOM_SCREEN = String.valueOf(priceInSelectRoomFooterView);
                    }else {
                        Logger.logComment("Price in the hotel profile screen is :- "+priceFromHotelProfileScreen);
                        Logger.logComment("Price in the select room footer view is :- "+priceInSelectRoomFooterView);
                        Logger.logError("Price in the hotel profile screen and in the select room footer view are not matching");
                    }
                }else {
                    Logger.logComment("Price in the hotel profile screen is :- "+priceFromHotelProfileScreen);
                    Logger.logComment("Price in the selected room cell view is :- "+priceInTheSelectedRoomCellView);
                    Logger.logError("Price in the hotel profile screen and in the selected room cell view are not matching");
                }
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                Double priceInSelectRoomFooterView = getThePriceDisplayedInTheSelectHotelsScreenFooterView();
                Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_SELECT_ROOM_SCREEN = String.valueOf(priceInSelectRoomFooterView);
                Logger.logStep("Yet to implement the line of code for to compare the select room prices for multiple rooms in HOTELS BEDS API response");
            }else {
                Logger.logError("Encountered error:- Select rooms API response is neither PRO nor BEDS ..,");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error:- Unable to compare the selected room price selected rooms screen and hotels profile screen");
        }
    }

    /**
     * Get the price displayed in the select hotels screen footer view
     * @return
     */
    public static Double getThePriceDisplayedInTheSelectHotelsScreenFooterView(){
        Logger.logAction("Getting the price displayed in the select rooms footer view");
        try {
            if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                String hotelPriceInFooterViewWithCurrency = findElementByXpathAndReturnItsAttributeValue(PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_PRO);
                String hotelPriceWithoutCurrencyType = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL);
                if(hotelPriceWithoutCurrencyType.contains(Labels_Hotels.STRING_COMMA)){
                    String hotelPriceWithoutComma = hotelPriceWithoutCurrencyType.replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
                    return Double.parseDouble(hotelPriceWithoutComma);
                }else {
                    return Double.parseDouble(hotelPriceWithoutCurrencyType);
                }
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                String hotelPriceInFooterViewWithCurrency = findElementByXpathAndReturnItsAttributeValue(PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_BEDS);
                String hotelPriceWithoutCurrencyType = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL);
                if(hotelPriceWithoutCurrencyType.contains(Labels_Hotels.STRING_COMMA)){
                    String hotelPriceWithoutComma = hotelPriceWithoutCurrencyType.replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
                    return Double.parseDouble(hotelPriceWithoutComma);
                }else {
                    return Double.parseDouble(hotelPriceWithoutCurrencyType);
                }
            }else {
                Logger.logError("API response is neither PRO nor BEDS type..,");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the price displayed in the select rooms footer view");
        }
        return null;
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton(){
        try {
            findElementByIdAndClick(CONTINUE_BUTTON_ID_SELECT_ROOM_FOOTER_VIEW);
            Logger.logStep("Tapped on continue button");
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(LOADING_INDICATOR_ID_IN_FOOTER_VIEW,1);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on continue button");
        }
    }

    /**
     * Check the selected hotel sold out alert is displayed
     */
    @Override
    public boolean isHotelsSoldOutAlertIsDisplayed(){
        Logger.logAction("Checking the hotels sold out alert is displayed or not");
        try {
            Thread.sleep(4000);
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(LOADING_INDICATOR_ID_IN_FOOTER_VIEW ,1); //Todo:- This method is for to wait till the sold out alert is displayed
            if (isElementDisplayedByAccessibilityId(HOTEL_SOLD_OUT_ALERT_ID)){
                Logger.logStep("SoldOut alert is displayed");
                return true;
            }else {
                Logger.logComment("Sold out alert is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the hotel sold out alert is displayed");
        }
        return false;
    }

    /**
     * Tapped on change your room type button in the sold out alert
     */
    @Override
    public void tapOnChangeYourRoomTypeButtonInSoldOutAlert(){
        Logger.logAction("Tapping on change your room type button in the sold out alert");
        try{
            String nameString = findElementByXpathAndReturnItsAttributeName(XPATH_OF_CHANGE_ROOM_TYPE_LABEL_IN_SOLD_OUT_ALERT);
            if (nameString.equalsIgnoreCase(CHANGE_YOUR_ROOM_TYPE_LABEL)){
                boolean status = findElementByAccessibilityIdAndClick(CHANGE_YOUR_ROOM_TYPE_BUTTON_ID);
                if (status == true){
                    Logger.logComment("Tapped on change your room type button in the sold out alert");
                }else {
                    Logger.logError("Din't tapped on change your room type button in the sold out alert");
                }
            }else {
                Logger.logComment("Unable to tap on change your room type button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on change your room type button in sold out alert");
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
