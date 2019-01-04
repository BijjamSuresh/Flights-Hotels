package com.automation.rehlat.hotels.pages.hotelsSearchResults;

import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HotelsSearchResultsIos extends HotelsSearchResultsBase{

    public static final String SRP_SEARCH_LOADER_CELL_ID = "HotelLoaderCell";
    public static final String SRP_SEARCH_TEXT_FIELD_ID = "Search Anything Ex : 4 Star Hotel";
    public static final String SHOW_INFO_PROGRESS_ID = "showInfo";
    public static final String SRP_SCREEN_TITLE_ID = "SRPScreen";
    public static final String EMPTY_LIST_ID = "Empty list";
    public static final String PRICE_ID = "priceLabel";
    public static final String XPATH_OF_HOTEL_CARD_VIEW_LAYOUT_WITHOUT_INDEX = "(//XCUIElementTypeCell[@name=\"HotelList\"])[";
    public static final String XPATH_HOTEL_PRICE_WITHOUT_CARD_VIEW_XPATH = "(//XCUIElementTypeStaticText[@name=\"SRPFinalPrice\"])[";
    public static final String SOLD_OUT_STRING = "Sold Out";
    public static final String NAVIGATE_BACK_BUTTON_IN_SRP = "SRP_Back_Button";

    /**
     * Check the hotel srp is displayed
     */
    @Override
    public void checkTheHotelsSRPScreenIsDisplayed() {
        Logger.logAction("Checking hotels search results screen is displayed or not ?");
        try {
//           waitTillTheProgressIndicatorIsInvisibleById_ANDROID(SRP_SEARCH_LOADER_CELL_ID,2);
            waitForAnElementToDisappear_ByName(SRP_SEARCH_LOADER_CELL_ID,2);
            runAppInBackground(2);
            if (isElementDisplayedByAccessibilityId(NAVIGATE_BACK_BUTTON_IN_SRP)){ //Todo:- Replace this with "SRP_SCREEN_TITLE_ID" title
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
        try {
            if (isElementDisplayedByAccessibilityId(EMPTY_LIST_ID)){
                Logger.logError("SRP list is empty");
            }
            List<WebElement> listOfHotels = driver.findElements(By.name("HotelList"));
            for (int count=0;listOfHotels.size()-1>count;count++){
                WebElement currentHotelVisibility = listOfHotels.get(count);
                scrollToAnElementByXPath(XPATH_OF_HOTEL_CARD_VIEW_LAYOUT_WITHOUT_INDEX+(count+1)+"]",true);
                if (currentHotelVisibility.getAttribute(Labels_Hotels.VISIBLE_ATTRIBUTE).equalsIgnoreCase(Labels_Hotels.STATUS_TRUE)){
                    String freeCancellationStatus = currentHotelVisibility.getAttribute(Labels_Hotels.VISIBLE_ATTRIBUTE);
                    if (isRefundableHotel == false){
                        if (freeCancellationStatus.equalsIgnoreCase(Labels_Hotels.STATUS_FALSE)){
                            Logger.logComment((count+1)+" - Hotel is having no free cancellation, so selecting it");
                            String priceOfSelectingHotel = currentHotelVisibility.findElement(By.name("SRPFinalPrice")).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                            if (priceOfSelectingHotel.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
                                if (priceOfSelectingHotel.contains(Labels_Hotels.STRING_COMMA)){
                                    String selectedHotelPriceWithoutComma = priceOfSelectingHotel.replace(Labels_Hotels.STRING_COMMA,Labels_Hotels.STRING_NULL).trim();
                                    Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = selectedHotelPriceWithoutComma;
                                }
                                else {
                                    Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = priceOfSelectingHotel;
                                }
                            }else {
                                Logger.logError("Parsing currency is not an :- "+ Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+", it is showing as :- "+priceOfSelectingHotel);
                            }
                            currentHotelVisibility.click();
                        }else {
                            if (count==listOfHotels.size()-1){
                                Logger.logError("All Hotels are having free cancellation");
                            }else {
                                Logger.logComment((count+1)+" - Hotel is having having free cancellation");
                            }
                        }
                    }else{
                        if (freeCancellationStatus.equalsIgnoreCase(Labels_Hotels.STATUS_TRUE)){
                            Logger.logComment((count+1)+" - Hotel is having free cancellation, so selecting it");
                            String priceOfSelectingHotel = currentHotelVisibility.findElement(By.name("SRPFinalPrice")).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                            if (priceOfSelectingHotel.contains(Labels_Hotels.CURRENT_USER_CURRENCY_TYPE)){
                                if (priceOfSelectingHotel.contains(Labels_Hotels.STRING_COMMA)){
                                    String selectedHotelPriceWithoutComma = priceOfSelectingHotel.replace(Labels_Hotels.STRING_COMMA,Labels_Hotels.STRING_NULL).trim();
                                    Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = selectedHotelPriceWithoutComma;
                                }
                                else {
                                    Labels_Hotels.SELECTED_HOTEL_BOOKING_COST_IN_SRP = priceOfSelectingHotel;
                                }
                            }else {
                                Logger.logError("Parsing currency is not an :- "+ Labels_Hotels.CURRENT_USER_CURRENCY_TYPE+", it is showing as :- "+priceOfSelectingHotel);
                            }
                            currentHotelVisibility.click();
                        }else {
                            if (count==listOfHotels.size()-1){
                                Logger.logError("All Hotels are having non free cancellation");
                            }else {
                                Logger.logComment((count+1)+" - Hotel is having having non free cancellation");
                            }
                        }
                    }
                }else {
                    Logger.logError("Hotel number "+(count+1)+"is non visible even after scrolling the page upwards");
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error :- Unable to get the price of hotel and tap on its card view");
        }
    }

    /**
     * Wait till the hotels are loaded with the price
     */
    public static void waitTillTheHotelsAreLoadedWithPrice(){
        Logger.logAction("Waiting till the hotels are loaded with the price labels");
        try {
//            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PRICE_ID))); //Todo:- This line of code needs to be enabled after dev set the price identifier for each hotel in stage
        }catch (Exception exception){
            Logger.logError("waited 30 seconds..,Hotel with the price labels is not displayed");
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
            waitForAnElementToDisappear_ByName(SRP_SEARCH_LOADER_CELL_ID,1);
            String priceValueOfFirstCell = findElementByXpathAndReturnItsAttributeValue(XPATH_HOTEL_PRICE_WITHOUT_CARD_VIEW_XPATH+"1]");
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
            boolean status = findElementByAccessibilityIdAndClick(NAVIGATE_BACK_BUTTON_IN_SRP);
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
