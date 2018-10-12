package com.automation.rehlat.flights.pages.karam;

import com.automation.rehlat.flights.libCommon.Logger;

public class KaramIos extends KaramBase {


    public static final String KARAMTITLE = "My Wallet";
    public static final String XPATH_OF_KARAM_BALANCE = "(//XCUIElementTypeStaticText[@name=\"0 KWD\"])[11]";
    public static final String XPATH_OF_KARAM_PLUS_BALANCE = "(//XCUIElementTypeStaticText[@name=\"0 KWD\"])[12]";
    public static final String XPATH_OF_TOTAL_KARAM_BALANCE = "(//XCUIElementTypeStaticText[@name=\"0 KWD\"])[10]";
    public static final String REFER_AND_EARN = "REFER & EARN KWD 8";

    /**
     * Check karam screen is displayed
     */
    @Override
    public void checkKaramScreenIsDisplayed(){
        Logger.logAction("Checking Karam screen is displayed or not ? ");
        try {
            if (isElementDisplayedByName(KARAMTITLE)){
                Logger.logStep("Karam screen is displayed");
            }else {
                Logger.logError("Karam screen is not displayed");
            }
        }catch (Exception exception){
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
            String karamBalance = findElementByXpathAndReturnItsAttributeText(XPATH_OF_KARAM_BALANCE);
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
            String karamPlusBalance = findElementByXpathAndReturnItsAttributeText(XPATH_OF_KARAM_PLUS_BALANCE);
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
            String totalKaramBalance = findElementByXpathAndReturnItsAttributeText(XPATH_OF_TOTAL_KARAM_BALANCE);
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
            findElementByNameAndClick(REFER_AND_EARN);
            Logger.logStep("Tapped on refer and earn button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on refer and earn button");
        }
    }

}
