package com.automation.rehlat.flights.pages.interfaces;

public interface TravellersDetails {

    /**
     * Check the travellers details screen is displayed
     * @throws Exception
     */
    void checkTravellersDetailsScreenIsDisplayed() throws Exception;

    /**
     * Decline the auto fill populate modal if displayed
     * @throws Exception
     */
    boolean declineAutoFillPopulateModalIfDisplayed() throws Exception;

    /**
     * Accept the auto fill populate modal if displayed
     */
    boolean acceptAutoFillPopulateModalIfDisplayed(Integer parsingPassengersCount);

    /**
     * Enter adult travellers details
     * @throws Exception
     */
    void enterAdultTravellersDetails(String travellersCountryName) throws Exception;

    /**
     * Tap on save button
     * @throws Exception
     */
    void tapOnSaveButton() throws Exception;

    /**
     * Enter travellers details for passengers
     * @param parsingPassengerCount
     */
    void EnterTravellersDetailsForPassengers(Integer parsingPassengerCount);

    /**
     * Tap on Next button
     */
    void tapOnNextButton();
}
