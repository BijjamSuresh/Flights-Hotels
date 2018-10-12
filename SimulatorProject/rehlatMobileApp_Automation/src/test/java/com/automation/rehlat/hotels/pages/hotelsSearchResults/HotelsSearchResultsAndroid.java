package com.automation.rehlat.hotels.pages.hotelsSearchResults;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;

public class HotelsSearchResultsAndroid extends HotelsSearchResultsBase {

    public static final String SRP_SEARCH_PROGRESS_ID = "com.app.rehlat:id/search_result_progrss";
    public static final String SRP_SEARCH_TEXT_FIELD_ID = "com.app.rehlat:id/filter_search_edit_text";
    public static final String LOADING_INDICATOR_OF_EACH_HOTEL_PRICE_ID = "com.app.rehlat:id/brb_progressbar";
    public static final String XPATH_OF_HOTEL_CARD_VIEW_LAYOUT_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[";
    public static final String XPATH_HOTEL_PRICE_WITHOUT_CARD_VIEW_XPATH = "]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView";

    /**
     * Check the hotel srp is displayed
     */
    @Override
    public void checkTheHotelsSRPScreenIsDisplayed() {
        Logger.logAction("Checking hotels search results screen is displayed or not ?");
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(SRP_SEARCH_PROGRESS_ID,1);
            if (isElementDisplayedById(SRP_SEARCH_TEXT_FIELD_ID)){
                Logger.logStep("Hotels SRP is displayed");
            }else {
                Logger.logError("Hotels SRP is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the hotels search screen is displayed");
        }
    }

    /**
     * Get the price of an hotel and tap on its card view
     * @param parsingCardNumber
     */
    @Override
    public void getThePriceOfHotelAndTapOnItsCardView(Integer parsingCardNumber){
        Logger.logAction("Getting the price of hotel and tap on its card view");
        try {
            waitForAnElementToDisappear_ById(LOADING_INDICATOR_OF_EACH_HOTEL_PRICE_ID);
            String xpathOfParsingCellNumber = XPATH_OF_HOTEL_CARD_VIEW_LAYOUT_WITHOUT_INDEX+parsingCardNumber+XPATH_HOTEL_PRICE_WITHOUT_CARD_VIEW_XPATH;
            String priceOfParsingCellNumber = findElementByXpathAndReturnItsAttributeText(xpathOfParsingCellNumber);
            if (priceOfParsingCellNumber.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
                String priceOfSelectingHotel = priceOfParsingCellNumber.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                Logger.logStep("Selected hotel price is :- "+priceOfSelectingHotel);
                findElementByXPathAndClick(xpathOfParsingCellNumber);
                Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = priceOfSelectingHotel;
            }else {
                Logger.logError("Parsing currency is not an :- "+ Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+", it is showing as :- "+priceOfParsingCellNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to get the price of hotel and tap on its card view");
        }
    }


}
