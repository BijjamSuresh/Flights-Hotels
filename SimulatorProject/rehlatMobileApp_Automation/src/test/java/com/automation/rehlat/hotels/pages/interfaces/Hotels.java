package com.automation.rehlat.hotels.pages.interfaces;

public interface Hotels {

    /**
     * check is hotels screen is displayed
     */
    void checkHotelScreenISDisplayed();

    /**
     * Tap on hotels tab
     */
    void tapOnHotelsTab();

    /**
     * Tap on search button
     */
    void tapOnSearchButton();

    /**
     * Tapping on menu button
     */
    void tapOnMenuButton();

    /**
     * Send keys to search text field
     */
    void sendKeysToSearchResultsScreen(String parsingValue);

    /**
     * Tap on first city name in search results
     */
    String  tapOnFirstCityNameInSearchResults(String nameOnFirstSearchResults);

    /**
     * Check the selected city is displayed in hotels search text field
     */
    void checkTheSearchTextFieldIsFilledWithSelectedNameOf(String  parsingValue);

    /**
     * Tap on check in button
     */
    void tapOnCheckOutButton();

    /**
     * Tap on check in button
     */
    void tapOnCheckInButton();

    /**
     * Select Departure date
     */
    void selectCheckInDate(String departureMonthAndYear, String departureDay);

    /**
     * Select Return date
     */
    void selectCheckOutDate(String departureMonthAndYear, String departureDay);

    /**
     * Tap on Done button in calendar view
     */
   void tapOnDoneButtonInCalendarView();

    /**
     * Tap on adult and child count layout
     */
    void tapOnAdultAndChildLayout();

    /**
     * select the guests count
     */
    void setTheGuestCountTo(Integer roomNumber, Integer adultCount, Integer childCount);

    /**
     * Tap on add room button
     */
    void tapOnAddRoomButton();

    /**
     * Tap on done button on room list view
     */
    void tapOnDoneButtonOnRoomListView();

    /**
     * Tap on check in option in calender view
     */
    void tapOnCheckInOptionInCalendarView();

    /**
     * Tap on check availability button
     */
    void tapOnCheckAvailabilityButton();

    /**
     * Reset the rooms count to default count .ie..1
     * @param roomsCount
     */
    void resetTheRoomsCountToDefaultCount(Integer roomsCount);
}
