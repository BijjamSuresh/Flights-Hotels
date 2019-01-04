package com.automation.rehlat.hotels.pages.selectRooms;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectRoomsAndroid extends SelectRoomsBase {
    public static final String SELECT_ROOM_SCREEN_TITLE_LABEL = "com.app.rehlat:id/roomSelectLayoutHeadingView";
    public static final String XPATH_OF_ROOM_CELL_WITHOUT_INDEX_PROS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";
    public static final String XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX_PROS = "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]";
    public static final String XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_ROOM_CELL_INDEX_PROS = "]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static final String XPATH_OF_ROOM_CELL_WITHOUT_INDEX_BEDS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[";
    public static final String XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX_BEDS = "]/android.widget.LinearLayout/android.widget.TextView[3]";
    public static final String XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_ROOM_CELL_INDEX_BEDS = "]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
    public static final String XPATH_OF_ROOM_NUMBER_TAB_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[";
    public static final String CONTINUE_BUTTON_ID_PROS = "com.app.rehlat:id/continue_room_pro_text";
    public static final String CONTINUE_BUTTON_ID_BEDS = "com.app.rehlat:id/continue_room_text";
    public static final String LOADING_INDICATOR_ID_IN_FOOTER_VIEW = "com.app.rehlat:id/continue_room_pro_progressbar";
    public static final String LOADING_INDICATOR_ID_OF_VIEW_CHANGE = "com.app.rehlat:id/flight_search_progressbar";
    public static final String SELECT_ROOM_TABS = "com.app.rehlat:id/roomselect_tabs";
    public static final String HOTELS_PRO_LIST_ID_OF_SELECT_ROOM = "com.app.rehlat:id/hotel_selectroom_pro_list";
    public static final String PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_PRO = "com.app.rehlat:id/hotels_pro_footer_total_fare_textview";
    public static final String PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_BEDS = "com.app.rehlat:id/hotel_bedsfooter_total_fare_textview";
    public static final String CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE  = "com.app.rehlat:id/noHotelFareDifference";
    public static final String OK_BUTTON_IN_ROOM_SOLD_OUT_ALERT_ID  = "com.app.rehlat:id/okBtn";
    public static final String SEE_AVAILABLE_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE  = "com.app.rehlat:id/yesHotelFareDifference";
    public static final String CHANGE_YOUR_DATES_BUTTON_LABEL  = "Change your Room type";
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
                if (isElementDisplayedById(SELECT_ROOM_TABS)){
                    Logger.logStep("Hotel Bed Api response is displayed");
                    API_RESPONSE_TYPE_IN_SELECT_ROOMS = HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS;
                }else if (isElementDisplayedById(HOTELS_PRO_LIST_ID_OF_SELECT_ROOM)){
                    API_RESPONSE_TYPE_IN_SELECT_ROOMS = HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS;
                    Logger.logStep("Hotel pro Api response is displayed");
                }else {
                    Logger.logError("Incorrect API response is showing");
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
        try {
            if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                Integer parsingRoomNumberToSelect = roomNumberToSelect;
                String xpathOfSelectButtonOfParsingCellNumber = XPATH_OF_ROOM_CELL_WITHOUT_INDEX_PROS+parsingRoomNumberToSelect+XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX_PROS;
                findElementByXPathAndClick(xpathOfSelectButtonOfParsingCellNumber);
                Logger.logStep("Tapped on select button in the room cell number :- "+roomNumberToSelect);
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                xpathOfRoomNumberTab = XPATH_OF_ROOM_NUMBER_TAB_WITHOUT_INDEX+1+"]";
                findElementByXPathAndClick(xpathOfRoomNumberTab);
                for (int count =0; count < totalRooms; count++){
                    Integer parsingRoomNumberToSelect =roomNumberToSelect;
                    Thread.sleep(1000);
                    String xpathOfSelectButtonOfParsingCellNumber = XPATH_OF_ROOM_CELL_WITHOUT_INDEX_BEDS+parsingRoomNumberToSelect+XPATH_OF_SELECT_BUTTON_OPTION_WITHOUT_ROOM_CELL_INDEX_BEDS;
                    findElementByXPathAndClick(xpathOfSelectButtonOfParsingCellNumber);
//                    if (IS_SELECTED_BED_ROOM_IS_NON_REFUNDABLE_ROOM == false){ //Todo:- This method needs to be enabled when the sanity TC are implemented, right knew directly checking NON REFUNDABLE label in the booking page under hotel details section.
//                        getTheSelectedBedRoomPolicy(roomNumberToSelect);
//                    }
                    Logger.logStep("Tapped on select button in the room cell number :- "+parsingRoomNumberToSelect);
                    if (count >= (totalRooms-1)){
                        break;
                    }else {
                        Integer roomNumberCountInScrollView = count+2;
                        roomNumber = roomNumberCountInScrollView-2;
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
                String xpathOfRoomPriceInParsingCellNumber = XPATH_OF_ROOM_CELL_WITHOUT_INDEX_PROS+parsingRoomCellNumber+XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_ROOM_CELL_INDEX_PROS;
                String roomPriceInParsingCellNumber = findElementByXpathAndReturnItsAttributeText(xpathOfRoomPriceInParsingCellNumber).replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                getTheSelectedProRoomPolicy(parsingRoomCellNumber);
                return Double.parseDouble(roomPriceInParsingCellNumber);
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                String xpathOfRoomPriceInParsingCellNumber = XPATH_OF_ROOM_CELL_WITHOUT_INDEX_BEDS+parsingRoomCellNumber+XPATH_OF_SELECTED_ROOM_PRICE_WITHOUT_ROOM_CELL_INDEX_BEDS;
                String roomPriceInParsingCellNumber = findElementByXpathAndReturnItsAttributeText(xpathOfRoomPriceInParsingCellNumber).replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                return Double.parseDouble(roomPriceInParsingCellNumber);
            }else {
                Logger.logError("API response is neither PRO nor BEDS");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the price of an selected room :- "+parsingRoomCellNumber);
        }
        return null;
    }


    /**
     * Get the parsing bed room number policy
     */
    public static void getTheSelectedProRoomPolicy(Integer parsingRoomCellNumber){
        Logger.logComment("Getting the selected pro room policy");
        try {
            List<WebElement> listOfPolicies = driver.findElements(By.id("com.app.rehlat:id/hotelsProrateclass_txt"));
            String policyValue = listOfPolicies.get(parsingRoomCellNumber).getText();
            if (policyValue.equalsIgnoreCase("Non-refundable")){
//                BasePage.IS_SELECTED_PRO_ROOM_IS_NON_REFUNDABLE_ROOM = true; Todo:- This method needs to be enabled when the sanity TC are implemented, right knew directly checking NON REFUNDABLE label in the booking page under hotel details section.
            }else {
//                BasePage.IS_SELECTED_PRO_ROOM_IS_NON_REFUNDABLE_ROOM = false; Todo:- This method needs to be enabled when the sanity TC are implemented, right knew directly checking NON REFUNDABLE label in the booking page under hotel details section.
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to get the selected room policy");
        }
    }

    /**
     * Get the parsing bed room number policy
     */
    public static void getTheSelectedBedRoomPolicy(Integer parsingRoomCellNumber){
        Logger.logComment("Getting the selected bed room policy");
        try {
            List<WebElement> listOfPolicies = driver.findElements(By.id("com.app.rehlat:id/rateclass_txt"));
            String policyValue = listOfPolicies.get(parsingRoomCellNumber+1).getText();
            if (policyValue.equalsIgnoreCase("Non-refundable")){
//                BasePage.IS_SELECTED_BED_ROOM_IS_NON_REFUNDABLE_ROOM = true; Todo:- This method needs to be enabled when the sanity TC are implemented, right knew directly checking NON REFUNDABLE label in the booking page under hotel details section.
                Logger.logStep("Selected room is an non-refundable. So roomer flex must be applicable");
            }else {
//                BasePage.IS_SELECTED_BED_ROOM_IS_NON_REFUNDABLE_ROOM = false; Todo:- This method needs to be enabled when the sanity TC are implemented, right knew directly checking NON REFUNDABLE label in the booking page under hotel details section.
                Logger.logStep("Selected room is an refundable. So roomer flex must not be applicable");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the selected room policy");
        }
    }

    /**
     * Compare the selected room price in the selected rooms screen and in the hotels profile screen
     * @param parsingRoomNumber
     */
    @Override
    public void compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(Integer parsingRoomNumber){
        Logger.logComment("Comparing the selected room price in select rooms screen and hotel profile screen");
        try {
            if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                Double priceFromHotelProfileScreen = Double.parseDouble(Labels_Hotels.BOOKING_HOTEL_COST_DISPLAYING_IN_HOTEL_PROFILE_SCREEN);
                Double priceInTheSelectedRoomCellView = getThePriceOfTheSelectedRoomNumber(parsingRoomNumber);
                Double priceInSelectRoomFooterView = getThePriceDisplayedInTheSelectHotelsScreenFooterView();
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
                String hotelPriceInFooterViewWithCurrency = findElementByIdAndReturnText(PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_PRO);
                String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
                return Double.parseDouble(hotelPriceWithoutCurrency);
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                String hotelPriceInFooterViewWithCurrency = findElementByIdAndReturnText(PRICE_ID_IN_HOTELS_PROFILE_SCREEN_FOOTER_VIEW_BEDS);
                String hotelPriceWithoutCurrency = hotelPriceInFooterViewWithCurrency.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).replace(Labels_Hotels.STRING_COMMA, Labels_Hotels.STRING_NULL).trim();
                return Double.parseDouble(hotelPriceWithoutCurrency);
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
            if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_PROS_API_RESPONSE_TYPE_IN_SELECT_ROOMS){
                findElementByIdAndClick(CONTINUE_BUTTON_ID_PROS);
                Logger.logStep("Tapped on continue button");
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(LOADING_INDICATOR_ID_IN_FOOTER_VIEW,1);
            }else if (API_RESPONSE_TYPE_IN_SELECT_ROOMS == HOTEL_BEDS_API_RESPONSE_TYPE_IN_SELECT_ROOMS) {
                findElementByIdAndClick(CONTINUE_BUTTON_ID_BEDS);
                Logger.logStep("Tapped on continue button");
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(LOADING_INDICATOR_ID_IN_FOOTER_VIEW,1);
            }else {
                Logger.logError("API response is neither PRO nor BEDS type..,");
            }
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
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(LOADING_INDICATOR_ID_IN_FOOTER_VIEW ,1); //Todo:- This method is for to wait till the sold out alert is displayed
            if (isElementEnabledById("com.app.rehlat:id/hotelinformation_fare_differ")){
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
            Logger.logError("Encountered error: Unable to check the hotel sold out alert is displayed");
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
            if (isElementEnabledById(CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE)){
                driver.findElementById(CHANGE_YOUR_DATES_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE).click();
                Logger.logComment("Tapped on on button in the sold out alert");
                runAppInBackground(2);
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
            if (isElementEnabledById(SEE_AVAILABLE_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE)){
                driver.findElementById(SEE_AVAILABLE_BUTTON_IN_SOLD_OUT_ALERT_MESSAGE).click();
                Logger.logComment("Tapped on change your dates button in the sold out alert");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on OK button in sold out alert");
        }
    }

}
