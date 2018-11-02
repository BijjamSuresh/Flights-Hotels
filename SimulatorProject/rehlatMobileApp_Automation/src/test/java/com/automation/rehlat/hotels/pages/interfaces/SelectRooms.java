package com.automation.rehlat.hotels.pages.interfaces;

public interface SelectRooms {

    /**
     * Check the select rooms screen is displayed
     */
    void checkSelectRoomScreenIsDisplayed();

    /**
     * Tap on select button in a particular room cell number
     * @param parsingRoomNumbersCount
     */
    void tapOnSelectButtonInRoomCellNumber(Integer parsingRoomNumbersCount, Integer roomNumberToSelect);

    /**
     * Compare the selected room price in the selected rooms screen and in the hotels profile screen
     * @param parsingRoomNumber
     */
    void compareSelectedRoomPriceInSelectRoomScreenAndHotelProfileScreen(Integer parsingRoomNumber);

    /**
     * Tap on continue button
     */
    void tapOnContinueButton();

    /**
     * Check the sold out error is displayed
     */
    boolean isHotelsSoldOutAlertIsDisplayed();

    /**
     * Tapped on ok button in the sold out alert
     */
    void tapOnChangeYourRoomTypeButtonInSoldOutAlert();

    /**
     * Tapped on change your dates button in the sold out alert
     */
    void tapOnSeeAvailablePropertiesButtonInSoldOutAlert();
}
