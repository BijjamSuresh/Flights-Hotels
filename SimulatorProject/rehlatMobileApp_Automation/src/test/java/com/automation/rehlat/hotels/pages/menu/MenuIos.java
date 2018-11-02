package com.automation.rehlat.hotels.pages.menu;

import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.Labels_Hotels;
import org.openqa.selenium.WebElement;


public class MenuIos extends MenuBase {

    public static final String SETTINGS_OPTION = "Settings";
    public static final String TRIPS_OPTION = "My Trips";
    public static final String TWENTY_FOUR_BAR_SEVEN_SUPPORT_OPTION = "Rehlat 24X 7 Support";
    public static final String SIGN_IN_OR_SIGN_UP_BUTTON = "signupButton";
    public static final String USER_NAME_FIELD_IN_SIDE_MENU = "userName";
    public static final String SIDE_MENU_IMAGE = "sideMenuImage";
    public static final String NEW_SIGNUP_ICON = "new_signup_icon";
    public static final String REFER_AND_EARN_SUB_MENU_OPTION = "referAndEarn";
    public static final String LOGOUT_BUTTON = "Logout";
    public static final String ARABIC_OPTION = "العربية";
    public static final String ENGLISH_OPTION = "English";
    public static final String PROFILE_EDIT_BUTTON = "signupButton";
    public static final String PRIVACY_POLICY_OPTION = "Privacy Policy";
    public static final String RATE_US_TITLE = "Rate Us";
    public static final String HELP_US_IMPROVE = "Help us Improve?";
    public static final String RATE_US_ON_APP_STORE = "Rate Us On Appstore";
    public static final String XPATH_OF_MENU_SCREEN = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]";
    public static final String[] listOfSubMenuOptions= {"Sign In/Sign Up","Inspiration - Travel Blog","My Trips","Rehlat 24X 7 Support","Arabic","Settings","Privacy Policy"};
    public static final String[] listOfStarRatingNames= {"Poor","Bad","Good","Very Good","Excellent"};
    public static final String XPATH_OF_STAR_NUMBER_WITHOUT_INDEX = "(//XCUIElementTypeButton[@name=\"star\"])[";
    public static final String XPATH_OF_STAR_RATING_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[2]";
    public static final String XPATH_OF_HELP_US_IMPROVE_BUTTON = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton";
    public static final String NEW_MESSAGE_ID_IN_EMAIL = "New Message";
    public static final String SEND_BUTTON_ID_IN_EMAIL = "Send";
    public static final String TO_TEXT_FIELD_ID_IN_EMAIL = "To:";
    public static final String EMPTY_SUBJECT_ID_IN_EMAIL = "Empty Subject";
    public static final String COULD_NOT_SENT_MESSAGE_ID_IN_EMAIL = "Could Not Send Email";
    public static final String OK_BUTTON_ID_IN_EMAIL = "OK";
    public static final String NO_MAIL_ACCOUNTS_ID_IN_EMAIL = "No Mail Accounts";
    public static final String CANCEL_BUTTON_ID_IN_EMAIL = "Cancel";
    public static final String DELETE_DRAFT_ID_IN_EMAIL = "Delete Draft";
    public static final String NEW_SIGNUP_LABEL = "Sign In/Sign Up";



    /**
     * Check menu screen is displayed
     */
    @Override
    public void checkMenuScreenIsDisplayed() {
        Logger.logAction("Checking menu screen is displayed or not ?");
        try {
            if (isElementEnabledById(SIDE_MENU_IMAGE)){
                com.automation.rehlat.flights.libCommon.Logger.logStep("Menu screen is displayed");
            }
            else {
                com.automation.rehlat.flights.libCommon.Logger.logError("Menu screen is not displayed");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Tap on sign in or sing up button
     */
    @Override
    public void tapOnSignUpOrSignInButton() {
        Logger.logAction("Tapping on sign up or sign in button");
        try {
            if (isElementDisplayedByAccessibilityId(SIGN_IN_OR_SIGN_UP_BUTTON)){
                findElementByAccessibilityIdAndClick(SIGN_IN_OR_SIGN_UP_BUTTON);
                Logger.logComment("Tapped on sign in or sign up button");
            }else {
                Logger.logError("Sign in or sign up button is not displayed");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to tap on sign up or sign in button");
        }
    }

    /**
     * Check user is signed up (in menu screen) with correct parsing credentials (in signed up screen )
     */
    @Override
    public void checkUserIsSignedUpSignedInWithCorrectParsingCredentials(String emailEnteredInSignUpScreen) {
        Logger.logAction("Check app is signed up with user parsing signUp credentials");
        try {
            if (isElementDisplayedById(emailEnteredInSignUpScreen)){
                Logger.logStep("App is signed up with correct user parsed signed up credentials");
            }else {
                Logger.logError("App is not signed up with correct user parsed signed up credentials");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to check the user signed up status");
        }
    }

    /**
     * Navigate to the flights tab
     */
    @Override
    public void navigateToFlightsTab() {
        Logger.logAction("Navigating to flights tab");
        try {
//            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            if (isElementDisplayedByXPath(XPATH_OF_MENU_SCREEN)){
                WebElement xpathOfMenuScreen = driver.findElementByXPath(XPATH_OF_MENU_SCREEN);
                tapOnElementBasedOnLocation(xpathOfMenuScreen,"bottomRight");
                Logger.logComment("Navigated from menu screen");
                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError("Menu screen xpath is incorrect :-"+XPATH_OF_MENU_SCREEN);
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to navigate to flights tab");
        }
    }

    /**
     * Check whether user is signed in in the app
     * @return
     */
    @Override
    public boolean isUserSignedIn() {
        Logger.logAction("Checking user is signed in or not ?");
        try {
            WebElement element = driver.findElementByAccessibilityId(USER_NAME_FIELD_IN_SIDE_MENU);
            String elementName = element.getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
            if (elementName.equalsIgnoreCase(NEW_SIGNUP_LABEL)){
                com.automation.rehlat.flights.libCommon.Logger.logStep("User is not signed in");
                return false;
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logStep("User is signed in");
                return true;
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("encountered error: Unable to check the user signed in status");
        }
        return false;
    }

    /**
     * Tap on Settings button
     */
    @Override
    public void tapOnSettingsButton() {
        Logger.logAction("Tapping on Settings button");
        try {
            if (isElementDisplayedByAccessibilityId(SETTINGS_OPTION)){
                driver.findElementByAccessibilityId(SETTINGS_OPTION).click();
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError(SETTINGS_OPTION+" :- element name is not displayed in the current active screen");
            }
        } catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }

    /**
     * Tap on logout button
     */
    @Override
    public void tapOnLogoutButton() {
        Logger.logAction("Tapping on logout button");
        try {
            if (isElementDisplayedByAccessibilityId(LOGOUT_BUTTON)){
                driver.findElementByAccessibilityId(LOGOUT_BUTTON).click();
                Logger.logComment("Tapped on logout button");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError("Logout button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }

    /**
     * Check all the sub menu options are displayed in menu screen
     */
    @Override
    public void checkAllTheSubMenuOptionsAreDisplayed() {
        Logger.logAction("Checking all the sub menu options are displayed");
        try{
            for (int count = 0 ; count<= listOfSubMenuOptions.length-1;count++){
                String elementName = listOfSubMenuOptions[count];
                if (count==0){
                    if (isUserSignedIn()){
                        Logger.logComment("User is signed in.So, no sign in or sign up button");
                    }else
                    {
                        if (isElementDisplayedByAccessibilityId(elementName)){
                            Logger.logComment(elementName+" :- sub menu element is displayed");
                        }else {
                            com.automation.rehlat.flights.libCommon.Logger.logError(elementName+" sub menu element is not displayed");
                        }
                    }
                }else {
                    if (isElementDisplayedByAccessibilityId(elementName)){
                        Logger.logComment(elementName+" :- sub menu element is displayed");
                    }else {
                        com.automation.rehlat.flights.libCommon.Logger.logError(elementName+" sub menu element is not displayed");
                    }
                }
            }if (isElementDisplayedByAccessibilityId(REFER_AND_EARN_SUB_MENU_OPTION)){
                Logger.logComment(REFER_AND_EARN_SUB_MENU_OPTION+" :- sub menu element is enabled");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError(REFER_AND_EARN_SUB_MENU_OPTION+" :- sub menu element is not enabled");
            }
            if (isUserSignedIn()){
                if (isElementDisplayedByAccessibilityId(LOGOUT_BUTTON)){
                    Logger.logComment(LOGOUT_BUTTON+" :- sub menu element id is displayed");
                }else {
                    com.automation.rehlat.flights.libCommon.Logger.logError(LOGOUT_BUTTON+" :- sub menu element id is not displayed");
                }
            }else {
                Logger.logComment("User is not signed in. So no logout button is displayed in the sub menu screen");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to check all the sub menu options are displayed");
        }
    }

    /**
     * Tap on profile edit icon
     */
    @Override
    public void tapOnProfileEditIcon() {
        Logger.logAction("Tapping on profile edit icon");
        try{
            if (isElementDisplayedByAccessibilityId(PROFILE_EDIT_BUTTON)){
                driver.findElementByAccessibilityId(PROFILE_EDIT_BUTTON).click();
                Logger.logComment("Tapped on profile edit button");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError(PROFILE_EDIT_BUTTON+" ;- element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error:- Unable to tap on profile edit icon");
        }
    }

    /**
     * Tap on Refer and earn icon in the menu screen
     */
    @Override
    public void tapOnReferAndEarnIcon(){
        Logger.logAction("Tapping on refer and earn icon in the menu screen");
        try{
            if (isElementDisplayedByAccessibilityId(REFER_AND_EARN_SUB_MENU_OPTION)){
                Logger.logComment(REFER_AND_EARN_SUB_MENU_OPTION+" :- sub menu element is enabled");
                driver.findElementByAccessibilityId(REFER_AND_EARN_SUB_MENU_OPTION).click();
                com.automation.rehlat.flights.libCommon.Logger.logStep("Tapped on refer and earn button");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError(REFER_AND_EARN_SUB_MENU_OPTION+" :- sub menu element is not enabled");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to tap on refer and earn icon");
        }
    }

    /**
     * Tap on my trips sub menu option
     */
    @Override
    public void tapOnMyTripsSubMenuButton(){
        Logger.logAction("Tapping on My Trips option in menu list");
        try{
            if (isElementDisplayedByAccessibilityId(TRIPS_OPTION)){
                Logger.logComment(TRIPS_OPTION+" :- sub menu element is displayed");
                driver.findElementByAccessibilityId(TRIPS_OPTION).click();
                com.automation.rehlat.flights.libCommon.Logger.logStep("Trips option is tapped");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError(TRIPS_OPTION+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }

    /**
     * Tap on Arabic option in sub menu button
     */
    @Override
    public void tapOnArabicInSubMenuButton(){
        Logger.logAction("Tapping on Arabic option in menu list");
        try{
            if (isElementDisplayedByAccessibilityId(ARABIC_OPTION)){
                Logger.logComment(ARABIC_OPTION+" :- sub menu element is displayed");
                driver.findElementByAccessibilityId(ARABIC_OPTION).click();
                com.automation.rehlat.flights.libCommon.Logger.logStep("Arabic option is tapped");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError(ARABIC_OPTION+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }

    /**
     * Tap on English option in sub menu button
     */
    @Override
    public void tapOnEnglishInSubMenuButton(){
        Logger.logAction("Tapping on Arabic option in menu list");
        try{
            if (isElementDisplayedByAccessibilityId(ENGLISH_OPTION)){
                Logger.logComment(ENGLISH_OPTION+" :- sub menu element is displayed");
                driver.findElementByAccessibilityId(ENGLISH_OPTION).click();
                com.automation.rehlat.flights.libCommon.Logger.logStep("English option is tapped");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logError(ENGLISH_OPTION+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            com.automation.rehlat.flights.libCommon.Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }

    /**
     * Tap on 24/7 option in sub menu button
     */
    @Override
    public void tapOnTwentyFourBarSevenOptionInSubMenuList(){
        Logger.logAction("Tapping on 24/7 option in menu list");
        try{
            findElementByAccessibilityIdAndClick(TWENTY_FOUR_BAR_SEVEN_SUPPORT_OPTION);
            com.automation.rehlat.flights.libCommon.Logger.logStep("Tapped on 24/7 menu option");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on 24/7 sub menu button");
        }
    }

    /**
     * Tap on privacy policy option in menu
     */
    @Override
    public void tapOnPrivacyPolicyOption(){
        Logger.logAction("Tapping on privacy policy");
        try {
            findElementByAccessibilityIdAndClick(PRIVACY_POLICY_OPTION);
            com.automation.rehlat.flights.libCommon.Logger.logStep("Tapped on Privacy policy screen");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the privacy policy");
        }
    }

    /**
     * Check rate us layout is displayed
     */
    @Override
    public void checkRateUsLayoutIsDisplayed(){
        Logger.logAction("Checking the rate us layout is displayed or not");
        try {
            if (isElementDisplayedByAccessibilityId(RATE_US_TITLE)){
                Logger.logComment("Rate us layout is displayed");
            }else {
                Logger.logError("Rate us layout is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the rate us layout is displayed or not ?");
        }
    }

    /**
     * Tap on a particular star Number by parsing its value
     * @param parsingInteger
     */
    @Override
    public void tapOnStarNumber(Integer parsingInteger){
        Logger.logAction("Tapping on star number :- "+parsingInteger);
        try {
            String xpathOfSelectingStartNumber = XPATH_OF_STAR_NUMBER_WITHOUT_INDEX+parsingInteger+"]";
            findElementByXPathAndClick(xpathOfSelectingStartNumber);
            Logger.logComment("Tapped on star number :- "+parsingInteger);
        }catch (Exception exception){
            Logger.logError("Unable to tap on star number");
        }
    }

    /**
     * Check the tapped star number is selected correctly
     * @param selectedStarNumber
     */
    @Override
    public void checkTheSelectedStarNumberNameIsCorrectlyDisplayed(Integer selectedStarNumber){
        Logger.logAction("Checking the star number is selected correctly or not ?");
        try {
            String starRatingNameDisplayingInApp = getTheStarRatingNameDisplaying();
            String startRatingNameShouldBeDisplayed = listOfStarRatingNames[selectedStarNumber-1];
            if (starRatingNameDisplayingInApp.equalsIgnoreCase(startRatingNameShouldBeDisplayed)){
                com.automation.rehlat.flights.libCommon.Logger.logStep("Correct star rating name is displayed for selected star :- "+selectedStarNumber+" as - "+starRatingNameDisplayingInApp);
            }else {
                Logger.logComment("Star rating selected is :- "+selectedStarNumber);
                Logger.logComment("Star rating name displaying is :- "+starRatingNameDisplayingInApp);
                Logger.logComment("Star rating name to be displayed is :- "+startRatingNameShouldBeDisplayed);
                Logger.logError("Incorrect star ratings name is displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the tapped star number is selected correctly or not?");
        }
    }

    /**
     * Check the help us button label is changed correctly as per selected star number
     * @param selectedStarNumber
     */
    @Override
    public void checkTheHelpUsButtonLabelIsChangedCorrectlyAsPerSelectedStarNumber(Integer selectedStarNumber){
        Logger.logAction("Checking the help us button label is changed correctly as per selected star number");
        try {
            String helpUsImproveButtonLabelName = getTheHelpUsImproveButtonLabelName();
            if (selectedStarNumber>3){
                if (helpUsImproveButtonLabelName.equalsIgnoreCase(RATE_US_ON_APP_STORE)){
                    com.automation.rehlat.flights.libCommon.Logger.logStep("Rate us on app store button label is displayed for the selected star number :- "+selectedStarNumber);
                }else {
                    Logger.logComment("Star rating selected is :- "+selectedStarNumber);
                    Logger.logComment("Star rating name displaying is :- "+helpUsImproveButtonLabelName);
                    Logger.logComment("Star rating name to be displayed is :- "+RATE_US_ON_APP_STORE);
                    Logger.logError("Help us button label is changed in correctly for selected star number :- "+selectedStarNumber);
                }
            }else if (selectedStarNumber<=3){
                if (helpUsImproveButtonLabelName.equalsIgnoreCase(HELP_US_IMPROVE)){
                    com.automation.rehlat.flights.libCommon.Logger.logStep("Help us improve button label is displayed for the selected star number :- "+selectedStarNumber);
                }else {
                    Logger.logComment("Star rating selected is :- "+selectedStarNumber);
                    Logger.logComment("Star rating name displaying is :- "+helpUsImproveButtonLabelName);
                    Logger.logComment("Star rating name to be displayed is :- "+HELP_US_IMPROVE);
                    Logger.logError("Help us button label is changed in correctly for selected star number :- "+selectedStarNumber);
                }
            }else {
                Logger.logError("Selected star number value is greater than 5 .i.e.., "+selectedStarNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the help us button label is changed correctly as per selected star number");
        }
    }

    /**
     * Get The star rating name displaying
     * @return
     */
    @Override
    public String getTheStarRatingNameDisplaying(){
        Logger.logAction("Getting the star rating name");
        try {
            String starRatingName = findElementByXpathAndReturnItsAttributeText(XPATH_OF_STAR_RATING_NAME);
            return starRatingName;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the selected star rating displaying name");
        }
        return null;
    }

    /**
     * Get The help us improve button label name
     * @return
     */
    @Override
    public String getTheHelpUsImproveButtonLabelName(){
        Logger.logAction("Getting the star rating name");
        try {
            String helpUsImproveButtonLabel = findElementByXpathAndReturnItsAttributeText(XPATH_OF_HELP_US_IMPROVE_BUTTON);
            return helpUsImproveButtonLabel;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the help us improve button label name");
        }
        return null;
    }

    /**
     * Tap on help us improve button
     * @return
     */
    @Override
    public void tapOnHelpUsImproveButton(){
        Logger.logAction("Tapping on help us improve button");
        try {
            findElementByNameAndClick(HELP_US_IMPROVE);
            com.automation.rehlat.flights.libCommon.Logger.logStep("Tapped on hep us improve button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on help us improve button");
        }
    }

    /**
     * Tap on Rate us in store button
     * @return
     */
    @Override
    public void tapOnRateUsInStoreButton(){
        Logger.logAction("Tapping on rate us on app store button");
        try {
            findElementByNameAndClick(RATE_US_ON_APP_STORE);
            com.automation.rehlat.flights.libCommon.Logger.logStep("Tapped on rate us on app store button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on rate us on app store");
        }
    }

    /**
     * Check is new email window is displayed
     * @return
     */
    @Override
    public boolean isNewEmailWindowIsDisplayed(){
        Logger.logAction("Checking the new email window is displayed or not ?");
        try {
            if (isCouldNotSendEmailAlertIsDisplayed()){
                Logger.logComment("Email set up is not done in the device");
                closeCouldNotSendEmailAlert();
                if (isNoMailAccountsAlertIsDisplayed()){
                    closeNoMailAccountsAlert();
                    return false;
                }else {
                    com.automation.rehlat.flights.libCommon.Logger.logWarning("No mails account alert is not displayed");
                }
            }else if (isElementDisplayedByName(NEW_MESSAGE_ID_IN_EMAIL) && isElementDisplayedByName(SEND_BUTTON_ID_IN_EMAIL) && isElementEnabledByName(TO_TEXT_FIELD_ID_IN_EMAIL))
            {
                com.automation.rehlat.flights.libCommon.Logger.logStep("New email window is displayed");
                return true;
            }else {
                Logger.logError("Could not check the displayed screen type");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the email window is displayed or not?");
        }
        return false;
    }

    /**
     * Send the email by tapping on send button
     */
    @Override
    public void sendEmail(){
        Logger.logAction("Sending the email");
        try {
            findElementByNameAndClick(SEND_BUTTON_ID_IN_EMAIL);
            Logger.logComment("Tapped on email send button");
            if (isElementDisplayedByName(SEND_BUTTON_ID_IN_EMAIL) || isElementDisplayedByName(EMPTY_SUBJECT_ID_IN_EMAIL)){
                Logger.logError("Email is not sent");
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logStep("Email is sent");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the email");
        }
    }

    /**
     * Check the could not send email alert is displayed
     */
    public static boolean isCouldNotSendEmailAlertIsDisplayed(){
        Logger.logAction("Checking Could not send email alert is displayed or not ?");
        try {
            if (isElementDisplayedByName(COULD_NOT_SENT_MESSAGE_ID_IN_EMAIL)){
                Logger.logComment("Could not send email alert is displayed");
                return true;
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logWarning("Could not send email alert is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the alert is displayed or not");
        }
        return false;
    }


    /**
     * Close could not send email alert by tapping on OK button
     */
    public static void closeCouldNotSendEmailAlert(){
        Logger.logAction("Closing Could not send email alert ");
        try {
            findElementByNameAndClick(OK_BUTTON_ID_IN_EMAIL);
            Logger.logComment("Closed the alert by tapping on OK button in the alert");
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to close the alert");
        }
    }

    /**
     * Check the no mail alert is displayed
     */
    public static boolean isNoMailAccountsAlertIsDisplayed(){
        Logger.logAction("Checking no mail alert is displayed or not ?");
        try {
            if (isElementDisplayedByName(NO_MAIL_ACCOUNTS_ID_IN_EMAIL)){
                Logger.logComment("No email alert is displayed");
                return true;
            }else {
                com.automation.rehlat.flights.libCommon.Logger.logWarning("No mail alert is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the alert is displayed or not");
        }
        return false;
    }


    /**
     * Close no mail alert by tapping on OK button
     */
    public static void closeNoMailAccountsAlert(){
        Logger.logAction("Closing no mail alert");
        try {
            findElementByNameAndClick(OK_BUTTON_ID_IN_EMAIL);
            Logger.logComment("Closed the alert by tapping on OK button in the alert");
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to close the alert");
        }
    }

    /**
     * Tap on cancel button in new email window
     */
    @Override
    public void tapOnCancelButtonInNewEmailWindow(){
        Logger.logAction("Tapping on cancel button in new email window");
        try {
            if (isNewEmailWindowIsDisplayed()){
                findElementByNameAndClick(CANCEL_BUTTON_ID_IN_EMAIL);
                Logger.logComment("Tapped on cancel button");
            }else {
                Logger.logError("New Email window is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to tap on new email window cancel button");
        }
    }

    /**
     * Tap on delete draft button in new email window
     */
    @Override
    public void tapOnDeleteDraftButtonInNewEmailWindow(){
        Logger.logAction("Tapped on delete draft button");
        try {
            findElementByNameAndClick(DELETE_DRAFT_ID_IN_EMAIL);
            Logger.logComment("Tapped on delete draft button");
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to tap on delete draft button in new email window ");
        }
    }


}
