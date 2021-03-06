package com.automation.rehlat.flights.pages.interfaces;

public interface Flights {
    /**
     * Check select language modal is displayed
     */
    boolean isSelectLanguageModalIsDisplayed() throws Exception;

    /**
     * Get the position of current active user location country name
     * @return
     */
    String getTheLastPositionCountryNameInSelectCountryLayout();

    /**
     * Check the flights tab is displayed
     * @throws Exception
     */
    void checkFlightsTabIsDisplayed() throws Exception;

    /**
     * Tapping on menu button
     */
    void tapOnMenuButton() throws Exception;
    /**
     * Selects the country name of the user
     * @param userCountryName
     * @throws Exception
     */
    void selectCountryOfUser(String userCountryName) throws Exception;

    /**
     * Tap on Continue button
     * @throws Exception
     */
     void tapOnContinueButton() throws Exception;

    /**
     * Select the country name and move to flights tab
     * @throws Exception
     */
     void selectCountryNameInSelectLanguageModal(String countryName) throws Exception;

    /**
     * Tap on From text field in flights tab
     * @throws Exception
     */
     void tapOnFromTextField() throws Exception;

    /**
     * Tap on TO text field in flights tab
     * @throws Exception
     */
     void tapOnToTextField() throws Exception;

    /**
     * Check keyboard is triggered or not
     * @throws Exception
     */
     void checkKeyboardIsDisplayed() throws Exception;

    /**
     * Check the search view screen is displayed or not
     * @throws Exception
     */
    void checkSearchViewScreenIsDisplayed() throws Exception;

    /**
     * Enter From place in search view
     * @throws Exception
     */
     void enterAirportName(String fromPlace) throws Exception;

    /**
     * Select the place name from search results of search view
     * @param placeName
     * @throws Exception
     */
     void selectAirportCodeFromSearchResults(String placeName) throws Exception;

    /**
     * Tap on Departure button in flights tab
     * @throws Exception
     */
     void tapOnDepartureDateBookingButton() throws Exception;

     /**
     * Tap on return booking button in flights tab
     */
    void tapOnReturnDateBookingButton() throws Exception;

    /**
     * selectDeparture date
     * @throws Exception
     */
     void selectDepartureDate(String departureMonthAndYear, String departureDay) throws Exception;

    /**
     * Select Return date
     */
    void selectReturnDate(String departureMonthAndYear, String departureDay);

    /**
     * Tap on Done button in calendar view
     * @throws Exception
     */
     void tapOnDoneButton() throws Exception;

    /**
     * Tap on search button in flights tab
     * @throws Exception
     */
     void tapOnSearchButton() throws Exception;

    /**
     * Check the app localization in flights tab
     * @return
     */
    String checkAppLocalizationInFlightsTab();

    /**
     * Check all the fields are visible in flights tab
     */
    void checkAllTheFieldsAreVisibleInFlightsTab();

    /**
     * Tap on adult plus button
     */
    void tapOnAdultPlusButton();

    /**
     * Tap on children plus button
     */
    void tapOnChildrenPlusButton();

    /**
     * Tap on infants plus button
     */
    void tapOnInfantsPlusButton();

    /**
     * Get the location of From airport name
     * @return
     */
    Integer[] getTheLocationOfFromAirPortName(String parsingFromFlightName);

    /**
     * Get the location of To airport name
     * @return
     */
    Integer[] getTheLocationOfToAirPortName(String parsingToFlightName);

    /**
     * Tap on swap button
     * @return
     */
    void tapOnSwapButton();

    /**
     * Get the From airport name
     */
    String  getTheFromAirportName();

    /**
     * Get the To airport name
     */
    String getTheToAirportName();

    /**
     * Set the passengers count
     * @param parsingAdultsCount
     * @param parsingChildrenCount
     * @param parsingInfantsCount
     */
    void setThePassengersCountTo(Integer parsingAdultsCount, Integer parsingChildrenCount,Integer parsingInfantsCount);

    /**
     * Tap on adult plus button
     */
    void tapOnAdultMinusButton();

    /**
     * Tap on children plus button
     */
    void tapOnChildrenMinusButton();

    /**
     * Tap on infants plus button
     */
    void tapOnInfantsMinusButton();

    /**
     * Tap on notifications button
     */
    void tapOnNotificationsButton();

    /**
     * Tap on karam tab
     */
    void tapOnKaramTab();
}
