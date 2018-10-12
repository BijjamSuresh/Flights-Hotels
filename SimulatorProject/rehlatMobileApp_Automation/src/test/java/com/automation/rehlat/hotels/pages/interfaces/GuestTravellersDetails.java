package com.automation.rehlat.hotels.pages.interfaces;

public interface GuestTravellersDetails {

    /**
     * Check the travellers details screen is displayed
     */
    void checkTravellersDetailsScreenIsDisplayed();

    /**
     * Decline the auto fill populate modal if displayed
     */
    boolean declineAutoFillPopulateModalIfDisplayed();

    /**
     * Accept the auto fill populate modal if displayed
     */
    boolean acceptAutoFillPopulateModalIfDisplayed();

    /**
     * Enter travellers details for passengers
     * @param parsingRoomNumber,parsingGuestTravellersAdultCount,parsingGuestTravellersChildCount
     */
    void enterTravellersDetailsForPassengers(Integer parsingRoomNumber, Integer parsingGuestTravellersAdultCount, Integer parsingGuestTravellersChildCount);

    /**
     * Tap on save button
     */
    void tapOnSaveButton();
}
