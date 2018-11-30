package com.automation.rehlat.hotels.pages.hotelsSearchResults;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HotelsSearchResultsAndroid extends HotelsSearchResultsBase {

    public static final String SRP_SEARCH_PROGRESS_ID = "com.app.rehlat:id/search_result_progrss";
    public static final String SRP_SEARCH_TEXT_FIELD_ID = "com.app.rehlat:id/filter_search_edit_text";
    public static final String LOADING_INDICATOR_OF_EACH_HOTEL_PRICE_ID = "com.app.rehlat:id/brb_progressbar";
    public static final String XPATH_OF_HOTEL_CARD_VIEW_LAYOUT_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[";
    public static final String XPATH_HOTEL_PRICE_WITHOUT_CARD_VIEW_XPATH = "]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView";
    public static final String HOTEL_PRICE_ID = "com.app.rehlat:id/finalprice_textview";
    public static final String SOLD_OUT_STRING = "Sold Out";
    public static final String NAVIGATE_BACK_BUTTON_IN_SRP = "com.app.rehlat:id/back_imageview";
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
            List<WebElement> listOfPrices = driver.findElements(By.id(HOTEL_PRICE_ID));
            WebElement hotelNumberToSelect =  listOfPrices.get(parsingCardNumber-1);
            String hotelNumberValue =hotelNumberToSelect.getText();
            // The below line of code is commented as per new UI implemented in 7.1.2 build
//            String xpathOfParsingCellNumber = XPATH_OF_HOTEL_CARD_VIEW_LAYOUT_WITHOUT_INDEX+parsingCardNumber+XPATH_HOTEL_PRICE_WITHOUT_CARD_VIEW_XPATH;
//            String priceOfParsingCellNumber = findElementByXpathAndReturnItsAttributeText(xpathOfParsingCellNumber);
            if (hotelNumberValue.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
                String priceOfSelectingHotel = hotelNumberValue.replace(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE, Labels_Hotels.STRING_NULL).trim();
                Logger.logStep("Selected hotel price is :- "+priceOfSelectingHotel);
                hotelNumberToSelect.click();
                Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = priceOfSelectingHotel;
            }else {
                Logger.logError("Parsing currency is not an :- "+ Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+", it is showing as :- "+hotelNumberValue);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to get the price of hotel and tap on its card view");
        }
    }

    /**
     * Check the sold outs are displayed in SRP
     * @return
     */
    @Override
    public boolean isSoldOutsAreDisplayedInSRP(){
        Logger.logAction("Checking the sold outs are displayed in SRP results");
        try {
            waitForAnElementToDisappear_ById(LOADING_INDICATOR_OF_EACH_HOTEL_PRICE_ID);
            String  priceValueOfFirstCell = findElementByIdAndReturnText(HOTEL_PRICE_ID);
            if (priceValueOfFirstCell.equalsIgnoreCase(SOLD_OUT_STRING)){
                return true;
            }else {
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the SRP results are displayed as sold outs or not ?");
        }
        return false;
    }

    /**
     * Tap on navigate back button in SRP
     */
    @Override
    public void tapOnNavigateBackButtonInSRP(){
        Logger.logAction("Tapping on navigate back button in SRP");
        try {
            boolean status = findElementByIdAndClick(NAVIGATE_BACK_BUTTON_IN_SRP);
            if (status == true){
                Logger.logStep("Tapped on navigate back button in SRP screen");
            }else {
                Logger.logError("Didn't tapped on navigate back button in SRP screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on navigate back button in SRP");
        }
    }


}
