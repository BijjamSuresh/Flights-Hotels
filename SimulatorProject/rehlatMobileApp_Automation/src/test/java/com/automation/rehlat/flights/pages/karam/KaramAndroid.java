package com.automation.rehlat.flights.pages.karam;

import com.automation.rehlat.flights.libCommon.Logger;

public class KaramAndroid extends KaramBase {


    public static final String KARAM_SCREEN_VIEW = "com.app.rehlat:id/wallet_views_llyt";
    public static final String KARAM_BALANCE = "com.app.rehlat:id/promo_wallet_points";
    public static final String KARAM_PLUS_BALANCE = "com.app.rehlat:id/nonpromo_wallet_points";
    public static final String TOTAL_KARAM_BALANCE = "com.app.rehlat:id/total_wallet_pts_textview";
    public static final String REFER_AND_EARN = "com.app.rehlat:id/wallet_refer_earn_textview";



    /**
     * Check karam screen is displayed
     */
    @Override
    public void checkKaramScreenIsDisplayed() {
        Logger.logAction("Checking Karam screen is displayed or not ? ");
        try {
            if (isElementDisplayedById(KARAM_SCREEN_VIEW)) {
                Logger.logAction("Karam screen view is displayed");
            } else {
                Logger.logError("karam screen view is not displayed");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to check the current screen title");
        }
    }

    /**
     * Check karam screen is displayed
     */
    @Override
    public void checkTheKaramValueIsDisplayed(){
        Logger.logAction("Checking karam value is displayed");
        try {
            String karamBalance = findElementByIdAndReturnText(KARAM_BALANCE);
            if (karamBalance != null){
                Logger.logStep("Karam points are displayed as :- "+karamBalance);
            }else {
                Logger.logError("Karam points are not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the karam value is displayed");
        }
    }

    /**
     * Check karam+ screen is displayed
     */
    @Override
    public void checkTheKaramPlusValueIsDisplayed(){
        Logger.logAction("Checking karam plus value is displayed");
        try {
            String karamPlusBalance = findElementByIdAndReturnText(KARAM_PLUS_BALANCE);
            if (karamPlusBalance != null){
                Logger.logStep("Karam plus points are displayed as :- "+karamPlusBalance);
            }else {
                Logger.logError("Karam plus points are not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the karam plus value is displayed");
        }
    }

    /**
     * Check karam screen is displayed
     */
    @Override
    public void checkTheTotalKaramBalanceIsDisplayed(){
        Logger.logAction("Checking total karam balance screen is displayed");
        try {
            String totalKaramBalance = findElementByIdAndReturnText(TOTAL_KARAM_BALANCE);
            if (totalKaramBalance != null){
                Logger.logStep("Total Karam balance is displayed as :- "+totalKaramBalance);
            }else {
                Logger.logError("Total Karam balance is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the total karam balance value is displayed");
        }
    }

    /**
     * Tap on refer and earn button
     */
    @Override
    public void tapOnReferAndEarnButton(){
        Logger.logAction("tapping on refer and earn button");
        try {
            findElementByIdAndClick(REFER_AND_EARN);
            Logger.logStep("Tapped on refer and earn button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on refer and earn button");
        }
    }
}
