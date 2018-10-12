package com.automation.rehlat.flights.pages.notificatios;

import com.automation.rehlat.flights.libCommon.Logger;

public class NotificationsAndroid extends NotificationsBase {

    public static final String NOTIFICATIONS_TITLE = "com.app.rehlat:id/notification_alert";
    public static final String NOTIFICATIONS_BACK_BUTTON = "com.app.rehlat:id/notification_back_btn";


    /**
     * Check the notifications screen is displayed
     */
    @Override
    public void checkNotificationsScreenIsDisplayed(){
        Logger.logAction("Checking the notifications screen is displayed");
        try {
            if (isElementDisplayedById(NOTIFICATIONS_TITLE)){
                Logger.logComment("Notifications screen is displayed");
            }else {
                Logger.logError("Notifications screen is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the current screen status");
        }
    }

    /**
     * Taping on back button
     */
    @Override
    public void tapOnBackButton(){
        Logger.logAction("Tapping on back button");
        try {
            findElementByIdAndClick(NOTIFICATIONS_BACK_BUTTON);
            Logger.logComment("Tapped on notifications back button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on back button");
        }
    }
}
