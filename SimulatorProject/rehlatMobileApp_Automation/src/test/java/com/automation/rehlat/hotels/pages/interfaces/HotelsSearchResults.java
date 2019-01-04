package com.automation.rehlat.hotels.pages.interfaces;

public interface HotelsSearchResults {

    /**
     * Check the hotel srp is displayed
     */
    void checkTheHotelsSRPScreenIsDisplayed();

    /**
     * Get the price of an hotel and tap on its card view
     * @param isRefundableHotel
     */
    void getThePriceOfHotelAndTapOnItsCardView(boolean isRefundableHotel, boolean selectFirstHotel);

    /**
     * Check the sold outs are displayed in SRP
     * @return
     */
    boolean isSoldOutsAreDisplayedInSRP();

    /**
     * Tap on navigate back button in SRP
     */
    void tapOnNavigateBackButtonInSRP();
}
