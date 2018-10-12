package com.automation.rehlat.flights.pages.referYourFriends;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.WebElement;

public class ReferYourFriendsAndroid extends ReferYourFriendsBase {

    public static String REFER_YOUR_FRIENDS_BACK_BUTTON_LABEL = "com.app.rehlat:id/refer_ern_back_btn";
    public static final String REFERRAL_CODE_TEXT_FIELD ="com.app.rehlat:id/refer_earn_unique_code";
    public static final String REFERRAL_CODE_EDIT_BUTTON = "com.app.rehlat:id/editReferalCode";
    public static final String REFERRAL_CODE_SAVE_BUTTON = "com.app.rehlat:id/saveReferalCode";

    /**
     * Check refer your friends screen id displayed or not?
     */
    @Override
    public void checkReferYourFriendsScreenIsDisplayed(){
        Logger.logAction("Refer your friends screen is displayed or not?");
        try{
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR);
            if(isElementDisplayedById(REFER_YOUR_FRIENDS_BACK_BUTTON_LABEL)){
                Logger.logStep("Refer your friends screen is displayed");
            }else{
                Logger.logError("Refer your friends screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen name");
        }
    }

    /**
     * Check refer your friends screen id displayed or not?
     */
    @Override
    public void checkReferralCodeIsDisplayed(){
        Logger.logAction("Refer your friends screen is displayed or not?");
        try{
            String referralCode = getTheReferralCode();
            if (!(referralCode==null)){
                Logger.logStep("Referral code is visible to the user and the displaying referral code is :- " +referralCode);
            }else {
                Logger.logError("Referral code is not visible to the user and the displaying referral code is :- " +referralCode);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen name");
        }
    }

    /**
     * Get the referral code
     * @return
     */
    public static String getTheReferralCode() {
        Logger.logAction("Getting the referral code displayed in the current active screen");
        try{
            if(isElementDisplayedById(REFERRAL_CODE_TEXT_FIELD)){
                Logger.logComment("Referral code cell is displayed");
                WebElement referralCodeCell = driver.findElementById(REFERRAL_CODE_TEXT_FIELD);
                String referralCodeValue = referralCodeCell.getText();
                if (!(referralCodeValue == null)){
                    Logger.logComment(referralCodeValue+" - Referral code is displayed");
                    return referralCodeValue;
                }
            }else{
                Logger.logError("Referral code cell is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the referral code");
        }
        return null;
    }

    /**
     * Get the referral code
     * @return
     */
    public static String updateTheReferralCode(String parsingReferralCode) {
        Logger.logAction("Updating the referral code by clearing the old one");
        try{
            if(isElementDisplayedById(REFERRAL_CODE_TEXT_FIELD)){
                Logger.logComment("Referral code cell is displayed");
                tapOnReferralEditButton();
                sendTextById(REFERRAL_CODE_TEXT_FIELD , parsingReferralCode);
                Logger.logComment("Parsed the referral code as :- "+parsingReferralCode);
                closeTheKeyboard_Android();
                tapOnReferralSaveButton();
                waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR);
            }else{
                Logger.logError("Referral code cell is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the referral code");
        }
        return null;
    }

    /**
     * Edit the referral code
     */
    @Override
    public void editTheReferralCode() {
        Logger.logAction("Editing the referral code by a random code");
        try{
            String currentReferralBeforeEditing = getTheReferralCode();
            updateTheReferralCode(Labels_Flights.NEW_REFERRAL_CODE);
            String latestReferralCodeAfterEditing = getTheReferralCode();
            if (!currentReferralBeforeEditing.equalsIgnoreCase(latestReferralCodeAfterEditing)){
                Logger.logStep("Referral code text field is edited");
                Logger.logComment(currentReferralBeforeEditing+ " :- is the previous referral code");
                Logger.logComment(latestReferralCodeAfterEditing+ " :- is the updated referral code");
            }else {
                Logger.logComment(currentReferralBeforeEditing+ " :- is the previous referral code");
                Logger.logComment(latestReferralCodeAfterEditing+ " :- is the updated referral code");
                Logger.logError("Referral code text field is not editable");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to edit the referral code");
        }
    }

    /**
     * Tap on referral edit button
     */
    public static void tapOnReferralEditButton() {
        Logger.logAction("Tapping on edit button");
        try{
            findElementByIdAndClick(REFERRAL_CODE_EDIT_BUTTON);
            Logger.logStep("Tapped on referral edit button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on edit button");
        }
    }

    /**
     * Tap on referral save button
     */
    public static void tapOnReferralSaveButton() {
        Logger.logAction("Tapping on save button");
        try{
            findElementByIdAndClick(REFERRAL_CODE_SAVE_BUTTON);
            Logger.logStep("Tapped on referral save button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on save button");
        }
    }
}
