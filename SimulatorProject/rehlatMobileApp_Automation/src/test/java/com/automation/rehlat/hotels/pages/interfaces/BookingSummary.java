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
     * Check booking page screen is displayed
     * @throws Exception
     */
    boolean isUserIsSignedIn() throws Exception;

    /**
     * Check the final fare calculations are correct
     * @throws Exception
     */
    void checkFinalFareCalculationIsCorrect() throws Exception;

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
}
