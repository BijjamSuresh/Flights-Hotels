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
     * @param isRefundableHotel
     */
    @Override
    public void getThePriceOfHotelAndTapOnItsCardView(boolean isRefundableHotel,boolean selectFirstHotel){
        Logger.logAction("Getting the price of hotel and tap on its card view");
        Integer hotelsCardsCount = 0;
        boolean firstAttemptCheck = true;
        Integer pageScrollAttempts = 0;
        try {
            //Todo:- Change this logic such that it should select the refundable or non refundable hotels in SRP itself based on the parsing boolean type
            waitForAnElementToDisappear_ById(LOADING_INDICATOR_OF_EACH_HOTEL_PRICE_ID);
            String hotelsCountLabel = driver.findElement(By.id("com.app.rehlat:id/avaliable_hotels_count")).getText();
            Integer hotelsCount = getTheCountOfTheHotels(hotelsCountLabel);
            while (pageScrollAttempts<hotelsCount) {
                WebElement hotelsListView = driver.findElement(By.id("com.app.rehlat:id/hotels_listview"));
                if (isRefundableHotel == true){
                    List<WebElement> listOfHotels = hotelsListView.findElements(By.id("com.app.rehlat:id/item_layout"));
                    for (int count = 0; listOfHotels.size() > count; count++) {
                        WebElement cardView = listOfHotels.get(count);
                        try {
                            cardView.findElement(By.id("com.app.rehlat:id/hotelSRPcancellationpolicy"));
                            if (selectFirstHotel == true) {
                                WebElement priceOfCardViewToTap = cardView.findElement(By.id(HOTEL_PRICE_ID));
                                String hotelPriceWithCurrencyCodeAndSpecialCharacters = priceOfCardViewToTap.getText();
                                String hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters = convertTheCurrencyWithoutCountryCodeAndSpecialCharacters(hotelPriceWithCurrencyCodeAndSpecialCharacters);
                                Logger.logStep("Selected hotel price is :- " + hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters);
                                Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters;
                                priceOfCardViewToTap.click();
                                pageScrollAttempts = hotelsCount;
                                break;
                            } else {
                                if (firstAttemptCheck == true) {
                                    scrollTheCalenderPageUpByAMonthGap_Android();
                                    firstAttemptCheck = false;
                                } else {
                                    WebElement priceOfCardViewToTap = cardView.findElement(By.id(HOTEL_PRICE_ID));
                                    String hotelPriceWithCurrencyCodeAndSpecialCharacters = priceOfCardViewToTap.getText();
                                    String hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters = convertTheCurrencyWithoutCountryCodeAndSpecialCharacters(hotelPriceWithCurrencyCodeAndSpecialCharacters);
                                    Logger.logStep("Selected hotel price is :- " + hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters);
                                    Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters;
                                    priceOfCardViewToTap.click();
                                    pageScrollAttempts = hotelsCount;
                                    break;
                                }
                            }
                        } catch (Exception exception) {
                            continue;
                        }
                    }
                    if (pageScrollAttempts >= hotelsCount){
                        break;
                    }else {
                        hotelsCardsCount = hotelsCardsCount + 1;
                        Logger.logComment("Free cancellation is not applicable for hotel number :- " + hotelsCardsCount);
                        scrollTheCalenderPageUpByAMonthGap_Android();
                        pageScrollAttempts = pageScrollAttempts+1;
                    }
                }else {
                    List<WebElement> listOfHotels = hotelsListView.findElements(By.id("com.app.rehlat:id/item_layout"));
                    for (int count=0; listOfHotels.size()>count;count++){
                        WebElement cardView = listOfHotels.get(count);
                        try
                        {
                            cardView.findElement(By.id("com.app.rehlat:id/hotelSRPcancellationpolicy"));
                        }catch (Exception exception){
                            if (selectFirstHotel == true){
                                WebElement priceOfCardViewToTap = cardView.findElement(By.id(HOTEL_PRICE_ID));
                                String hotelPriceWithCurrencyCodeAndSpecialCharacters = priceOfCardViewToTap.getText();
                                String hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters = convertTheCurrencyWithoutCountryCodeAndSpecialCharacters(hotelPriceWithCurrencyCodeAndSpecialCharacters);
                                Logger.logStep("Selected hotel price is :- " + hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters);
                                Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters;
                                pageScrollAttempts =hotelsCount;
                                priceOfCardViewToTap.click();
                                break;
                            }else {
                                if (firstAttemptCheck == true){
                                    scrollTheCalenderPageUpByAMonthGap_Android();
                                    firstAttemptCheck = false;
                                    pageScrollAttempts = pageScrollAttempts+1;
                                }else {
                                    WebElement priceOfCardViewToTap = cardView.findElement(By.id(HOTEL_PRICE_ID));
                                    String hotelPriceWithCurrencyCodeAndSpecialCharacters = priceOfCardViewToTap.getText();
                                    String hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters = convertTheCurrencyWithoutCountryCodeAndSpecialCharacters(hotelPriceWithCurrencyCodeAndSpecialCharacters);
                                    Logger.logStep("Selected hotel price is :- " + hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters);
                                    Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = hotelPriceWithoutCurrencyCodeAndWithoutSpecialCharacters;
                                    priceOfCardViewToTap.click();
                                    pageScrollAttempts =hotelsCount;
                                    break;
                                }
                            }
                        }
                        if (pageScrollAttempts >= hotelsCount){
                            break;
                        }else {
                            hotelsCardsCount = hotelsCardsCount+1;
                            Logger.logComment("Free cancellation is applicable for hotel number :- "+hotelsCardsCount);
                            scrollTheCalenderPageUpByAMonthGap_Android();
                            pageScrollAttempts = pageScrollAttempts+1;
                        }
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to get the price of hotel and tap on its card view");
        }
    }

    /**
     * Getting the hotels count in SRP results page
     * @param availableHotelsCountWithCityAndStaticText
     * @return
     */
    public static Integer getTheCountOfTheHotels(String availableHotelsCountWithCityAndStaticText){
        Logger.logAction("Getting the count of the hotels in SRP results page");
        try {
            String subStringsOfHotelsCount[] = availableHotelsCountWithCityAndStaticText.split(Labels_Hotels.ONE_CHARACTER_SPACE,3);
            String countOfHotels = subStringsOfHotelsCount[1];
            return Integer.parseInt(countOfHotels);
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to Get the count of the hotels in SRP results page");
        }
        return null;
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
