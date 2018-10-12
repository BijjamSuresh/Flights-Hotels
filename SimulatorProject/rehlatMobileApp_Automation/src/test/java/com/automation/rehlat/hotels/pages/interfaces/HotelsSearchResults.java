package com.automation.rehlat.hotels.pages.interfaces;

public interface HotelsSearchResults {

    /**
     * Check the hotel srp is displayed
     */
    void checkTheHotelsSRPScreenIsDisplayed();

    /**
     * Get the price of an hotel and tap on its card view
     * @param parsingCardNumber
     */
    void getThePriceOfHotelAndTapOnItsCardView(Integer parsingCardNumber);
}
