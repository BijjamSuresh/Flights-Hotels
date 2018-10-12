package com.automation.rehlat.flights.pages.myTrips;

import com.automation.rehlat.flights.libCommon.Logger;

public class MyTripsAndroid extends MyTripsBase {

    public static final String MY_TRIPS_SCREEN_TITLE = "com.app.rehlat:id/tripsHeaderTitle";
    public static final String XPATH_OF_FLIGHTS_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]";
    public static final String XPATH_OF_HOTELS_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]";
    public static final String XPATH_OF_UPCOMING_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]/android.widget.TextView";
    public static final String XPATH_OF_COMPLETED_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]/android.widget.TextView";
    public static final String NO_TRIPS_LAYOUT= "com.app.rehlat:id/noTripsLayout";
    public static final String AVAILABLE_TRIPS_LAYOUT = "com.app.rehlat:id/availableTripsLayout";
    public static final String PROGRESS_BAR_OF_MY_TRIPS = "com.app.rehlat:id/progressBar";

    /**
     * Check my trips screen is displayed
     */
    @Override
    public void checkMyTripsScreenIsDisplayed() {
        Logger.logAction("Checking my profile screen is displayed or not ?");
        try{
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(PROGRESS_BAR_OF_MY_TRIPS);
            if (isElementEnabledById(MY_TRIPS_SCREEN_TITLE)){
                Logger.logStep("My Trips screen is displayed");
            }else {
                Logger.logError("My Trips screen is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the profile screen is displayed or not?");
        }
    }

    /**
     * Tap on flights button
     */
    @Override
    public void tapOnFlightsButton(){
        Logger.logAction("Tapping on flights button");
        try{
            findElementByXPathAndClick(XPATH_OF_FLIGHTS_BUTTON);
            Logger.logStep("Tapped on flights button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the flights tab");
        }
    }

    /**
     * Tap on upcoming button
     */
    @Override
    public void tapOnUpcomingButton(){
        Logger.logAction("Tapping on upcoming button");
        try{
            findElementByXPathAndClick(XPATH_OF_UPCOMING_BUTTON);
            Logger.logStep("Tapped on upcoming button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the upcoming button");
        }
    }

    /**
     * Tap on completed button
     */
    @Override
    public void tapOnCompletedButton(){
        Logger.logAction("Tapping on completed button");
        try{
            findElementByXPathAndClick(XPATH_OF_COMPLETED_BUTTON);
            Logger.logStep("Tapped on completed button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the completed button");
        }
    }

    /**
     * Check upcoming flights travel information is displayed
     */
    @Override
    public void checkUpcomingFlightsTravelInformationIsDisplayed(){
        Logger.logAction("Checking upcoming flights information is displayed");
        try {
            checkBookedFlightsInformationIsDisplayed("UpcomingFlightType");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the upcoming flights travel information is displayed");
        }
    }

    /**
     * Check completed flights travel information is displayed
     */
    @Override
    public void checkCompletedFlightsTravelInformationIsDisplayed(){
        Logger.logAction("Checking completed flights information is displayed");
        try {
            checkBookedFlightsInformationIsDisplayed("CompletedFlightType");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the completed flights travel information is displayed");
        }
    }

    /**
     * Check the booked flights information is displayed or not ?
     */
    public static void checkBookedFlightsInformationIsDisplayed(String parsingFlightType){
        Logger.logAction("Checking the booked flights information is displayed");
        try {
            if (isElementEnabledById(AVAILABLE_TRIPS_LAYOUT)){
                Logger.logComment(AVAILABLE_TRIPS_LAYOUT+" :- element name is displayed.. So flight bookings are displayed for "+parsingFlightType+" days");
            }else if (isElementEnabledById(NO_TRIPS_LAYOUT)){
                Logger.logComment(NO_TRIPS_LAYOUT+" :- element name is displayed.. So no flight bookings for "+parsingFlightType+" days");
            }
            else {
                Logger.logError("Flights travelling details table is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the booked flights information");
        }
    }

}
