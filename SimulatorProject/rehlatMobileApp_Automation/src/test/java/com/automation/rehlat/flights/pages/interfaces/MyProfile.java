package com.automation.rehlat.flights.pages.interfaces;

public interface MyProfile {

    /**
     * Check my profile screen is displayed
     * @throws Exception
     */
    void checkMyProfileScreenIsDisplayed() throws Exception;

    /**
     * Get the karam points displayed in the karam and trips layout
     * @throws Exception
     */
    void getTheKaramPointsDisplayedInKaramPointsAndTripsLayout() throws Exception;

    /**
     * Get the trips information displayed in the karam and trips layout
     * @throws Exception
     */
    void getTheTripsCountDisplayedInKaramPointsAndTripsLayout() throws Exception;

    /**
     * Tapping on profile edit icon
     * @throws Exception
     */
    void tapOnProfileEditIcon() throws Exception;

    /**
     * Tap on add travellers icon
     * @throws Exception
     */
    void tapOnAddTravellersIcon() throws Exception;

    /**
     * Tap on travellers list option
     * @throws Exception
     */
    void tapOnAddTravellersListOption() throws Exception;

    /**
     * Check Add Travellers screen is displayed
     * @return
     * @throws Exception
     */
    void checkAddTravellersScreenIsDisplayed() throws Exception;
}
