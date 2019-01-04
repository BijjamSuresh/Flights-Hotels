package com.automation.rehlat.hotels.pages.interfaces;

public interface BookingSummary {

    /**
     * Check booking page screen is displayed
     * @throws Exception
     */
    void checkBookingPageScreenIsDisplayed() throws Exception;

    /**
     * Enter user booking information
     * @throws Exception
     */
    void enterUserBookingInfo() throws Exception;

    /**
     * Tap on continue button
     * @throws Exception
     */
    void tapOnContinueButton()throws Exception;

    /**
     * Tap on add travellers details button
     * @throws Exception
     */
    void tapOnAddGuestTravellersDetailsButton()throws Exception;


    /**
     * Tap on login in to use karam cash button
     * @throws Exception
     */
    void tapOnLoginToUseKaramCashButton() throws Exception;

    /**
     * Enable the karam points toggle
     * @return
     */
    void enableKaramPointsToggleSwitch();

    /**
     * Disable the karam points toggle
     * @return
     */
    void disableKaramPointsToggleSwitch();

    /**
     * Check booking page screen is displayed
     * @throws Exception
     */
    boolean isUserIsSignedIn() throws Exception;

    /**
     * Check the final fare calculations are correct
     * @throws Exception
     */
    void checkFinalFareCalculationIsCorrect(boolean isRoomerFlexApplied, boolean isRoomerFlexEnabled) throws Exception;

    /**
     * Apply coupon code
     * @throws Exception
     */
    void applyTheCouponCode() throws Exception;

    /**
     * Enter the text in phone number text field
     */
    void enterTextInPhoneNumberTextField();

    /**
     * Enter the text in email text field
     */
    void enterTextInEmailTextField();

    /**
     * Select the country code by country name
     * @param parsingCountryName
     */
    void selectTheCountryCodeByCountryName(String parsingCountryName);

    /**
     * Tapped on change your dates button in the sold out alert
     */
    void tapOnChooseDifferentRoomButtonInFareJumpAlert();

    /**
     * Check the sold out error is displayed
     */
    boolean isFareJumpAlertIsDisplayed();

    /**
     * Tapped on change your dates button in the sold out alert
     */
    void tapOnProceedButtonInFareJumpAlert();

    /**
     * Enable the roomer flex toggle
     */
    void enableRoomerFlexToggle();

    /**
     * Disable the roomer flex toggle
     */
    void disableRoomerFlexToggle();

    /**
     * Check roomer flex amount is added correctly to final amount
     */
    void checkRoomerFlexAmountIsAddedCorrectlyToFinalAmount();

    /**
     * Check roomer flex amount is removed correctly from final amount
     */
    void checkRoomerFlexAmountIsRemovedCorrectlyFromFinalAmount();

}
