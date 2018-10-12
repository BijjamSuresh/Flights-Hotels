package com.automation.rehlat.flights.pages.myProfile;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.WebElement;

public class MyProfileAndroid extends MyProfileBase {

    public static final String MY_PROFILE_TITLE = "com.app.rehlat:id/profileTopNavigationFragment";
    public static final String KARAM_POINTS_CELL = "com.app.rehlat:id/profileUserKaramPoints";
    public static final String TRIPS_COUNT_CELL = "com.app.rehlat:id/profileUserTrips";
    public static final String PROFILE_EDIT_ICON = "com.app.rehlat:id/edit_img";
    public static final String TRAVELLERS_LIST_OPTION = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]/android.widget.TextView";
    public static final String ADD_TRAVELLERS_ICON = "com.app.rehlat:id/add_traveller_llyt";
    public static final String ADD_PROFILE_SCREEN_TITLE = "com.app.rehlat:id/addProfileTextView";


    /**
     * Check my profile screen is displayed
     *
     */
    @Override
    public void checkMyProfileScreenIsDisplayed() {
        Logger.logAction("Checking my profile screen is displayed or not ?");
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR);
            if (isElementEnabledById(MY_PROFILE_TITLE)) {
                Logger.logStep("My Profile screen is displayed");
            } else {
                Logger.logError("My Profile screen is not displayed");
            }
        } catch (Exception Exception) {
            Logger.logError("Encountered error: Unable to check the profile screen is displayed or not?");
        }
    }

    /**
     * Get the karam points displayed in the karam and trips layout
     *
     */
    @Override
    public void getTheKaramPointsDisplayedInKaramPointsAndTripsLayout() {
        Logger.logAction("Get the karam points displayed in the karam points cell");
        try {
            if (isElementDisplayedById(KARAM_POINTS_CELL)) {
                WebElement karamPointsCell = driver.findElementById(KARAM_POINTS_CELL);
                String karamPointsWithCurrencyName = karamPointsCell.getText();
                    if (karamPointsWithCurrencyName.contains(Labels_Flights.CURRENT_USER_CURRENCY_TYPE)) {
                        Logger.logStep("Karam points cell is displayed");
                        String bookingCostExcludingCurrencyName = karamPointsWithCurrencyName.replace(Labels_Flights.CURRENT_USER_CURRENCY_TYPE, Labels_Flights.STRING_NULL).trim();
                        Double karamPoints = Double.valueOf(bookingCostExcludingCurrencyName);
                        Logger.logStep("Displayed karam points are :- " + karamPoints);
                    }
            } else {
                Logger.logError("Karam points cell is not displayed");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error:- Unable to get the karam points displayed in karam points cell");
        }
    }

    /**
     * Get the trips information displayed in the karam and trips layout
     */
    @Override
    public void getTheTripsCountDisplayedInKaramPointsAndTripsLayout() {
        Logger.logAction("Get the trips count displayed in the trips count cell");
        try {
            if (isElementDisplayedById(TRIPS_COUNT_CELL)) {
                WebElement tripsCountCell = driver.findElementById(TRIPS_COUNT_CELL);
                String tripsCountAsString = tripsCountCell.getText().trim();
                Double karamPointsAsDouble = Double.valueOf(tripsCountAsString);
                Logger.logStep("Displayed trips count is :- " + karamPointsAsDouble);
            } else {
                Logger.logError("Trips count cell is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to get the karam points displayed in trips count cell");
        }
    }

    /**
     * Tapping on profile edit icon
     */
    @Override
    public void tapOnProfileEditIcon() {
        Logger.logAction("Tapping on edit travellers information button");
        try {
            findElementByNameAndClick(PROFILE_EDIT_ICON);
            Logger.logComment("Tapped on profile edit icon");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on edit travellers button");
        }
    }

    /**
     * Tap on add travellers icon
     */
    @Override
    public void tapOnAddTravellersIcon() {
        Logger.logAction("Tapping on add travellers icon");
        try {
            scrollDown();
            findElementByIdAndClick(ADD_TRAVELLERS_ICON);
            Logger.logComment("Tapped on add travellers icon");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on add travellers icon");
        }
    }

    /**
     * Tap on travellers list option
     */
    @Override
    public void tapOnAddTravellersListOption() {
        Logger.logAction("Tapping on travellers list option");
        try {
            findElementByXPathAndClick(TRAVELLERS_LIST_OPTION);
            Logger.logComment("Tapped on travellers list option");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on travellers list option");
        }
    }

    /**
     * Check Add Travellers screen is displayed
     * @return
     */
    @Override
    public void checkAddTravellersScreenIsDisplayed() {
        Logger.logAction("Check add travellers screen is displayed");
        try {
            if (isElementDisplayedById(ADD_PROFILE_SCREEN_TITLE)){
                Logger.logStep("Add profile screen is displayed");
            }else {
                Logger.logError("Add profile screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Unable to check the current screen title");
        }
    }

}
