package com.automation.rehlat.flights.pages.home;

import com.automation.rehlat.flights.libCommon.Logger;

public class HomeIos extends HomeBase {
    /**
     * Checking is on boarding screen is displayed or not
     * @return
     * @throws Exception
     */
    public static boolean isOnBoardingScreenIsDisplayed() throws Exception{
        Logger.logAction("Checking the on-boarding screen is displayed or not?");
        if (isElementDisplayedById("com.app.rehlat:id/pager")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Checking on boarding screen is displayed
     */
    @Override
    public void checkOnBoardingScreenIsDisplayed(){
        Logger.logAction("Checking the on-boarding screen is displayed or not?");
        try {
            if (isOnBoardingScreenIsDisplayed()){
                Logger.logComment("On boarding screen is displayed");
            }else{
                Logger.logError("On boarding screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the on-boarding screen is displayed or not");
        }
    }

    /**
     * Tap on search destination button
     */
    @Override
    public void tapOnSearchDestinationButton(){
        Logger.logAction("Tapping on search destination button");
        try {
            boolean status = findElementByIdAndClick("com.app.rehlat:id/searchdestinationbutton");
            if (status == true){
                Logger.logComment("Tapped on search destination button in the on-boarding screen");
            }else{
                Logger.logError("Didn't tapped on search destination button in the on-boarding screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the on-boarding screen is displayed or not");
        }
    }
}
