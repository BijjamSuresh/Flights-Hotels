package com.automation.rehlat.hotels.pages.interfaces;

public interface HotelsProfile {

    /**
     * Check the hotel profile screen is displayed
     */
    void checkTheHotelProfileScreenIsDisplayed();

    /**
     * Compare the selected hotel price in SRP and in hotel profile screens
     */
    void compareSelectedHotelPriceInSRPAndInHotelProfileScreens();

    /**
     * Tap on select room button
     */
    void tapOnSelectRoomButton();

    /**
     * Check the sold out error is displayed
     */
    boolean isSoldOutAlertIsDisplayed();

    /**
     * Tapped on ok button in the sold out alert
     */
    void tapOnChangeYourDatesButtonInSoldOutAlert();
}
