package com.automation.rehlat.flights.pages.menu;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation.rehlat.flights.pages.menu.MenuIos.REFER_AND_EARN_SUB_MENU_ICON;

public class MenuAndroid extends MenuBase {

    public static final String NAVIGATION_MENU_VIEW = "com.app.rehlat:id/nav_view";
    public static final String SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN = "com.app.rehlat:id/userEmailAddress";
    public static final String SETTINGS_OPTION = "com.app.rehlat:id/sidemenu_settingllyt";
    public static final String LANGUAGE_ICON = "language_icon";
    public static final String TRIPS_OPTION = "My Trips";
    public static final String SIGN_IN_OR_SIGN_UP_BUTTON = "com.app.rehlat:id/menu_signup";
    public static final String FULL_SCREEN_LAYOUT = "com.app.rehlat:id/drawer_layout";
    public static final String LOGOUT_BUTTON = "com.app.rehlat:id/logoutLayout";
    public static final String XPATH_OF_SCROLL_VIEW_IN_MENU_SCREEN = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView";
    public static final String TWENTY_FOUR_BAR_SEVEN_SUPPORT_OPTION = "com.app.rehlat:id/sidemenu_supportllyt";
    public static final String REFER_AND_EARN_SUB_MENU_BUTTON = "com.app.rehlat:id/sidemenu_referllyt";
    public static final String PRIVACY_POLICY_OPTION = "com.app.rehlat:id/sidemenu_policyllyt";
    public static final String PROFILE_EDIT_ICON = "com.app.rehlat:id/edit_button";
    public static final String XPATH_OF_SETTINGS_SCREEN_TITTLE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
    public static final String[] listOfSubMenuOptions= {"com.app.rehlat:id/sidemenu_referllyt","com.app.rehlat:id/sidemenu_inspllyt","com.app.rehlat:id/sidemenu_dealsllyt","com.app.rehlat:id/sidemenu_supportllyt","com.app.rehlat:id/sidemenu_langllyt"};
    public static final String LANGUAGE_TITLE = "com.app.rehlat:id/lang_title";
    public static final String LANGUAGE_TYPE = "com.app.rehlat:id/lang_type";
    public static final String MAIN_TAB_BAR = "com.app.rehlat:id/types_tab";
    public static final String RATE_US_TITLE = "Rate Us";
    public static final String XPATH_OF_RATE_US_TITLE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
    public static final String HELP_US_IMPROVE_BUTTON = "com.app.rehlat:id/helpus_improve";
    public static final String HELP_US_IMPROVE_LABEL = "Help us Improve?";
//    public static final String RATE_US_ON_PLAY_STORE = "com.app.rehlat:id/helpus_improve";
    public static final String RATE_US_ON_PLAY_STORE_LABEL = "Help us Improve?";
    public static final String XPATH_OF_DISCARD_BUTTON_IN_NEW_EMAIL_WINDOW = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
    /**
     * Check menu screen is displayed
     */
    @Override
    public void checkMenuScreenIsDisplayed() {
        Logger.logAction("Checking menu screen is displayed or not ?");
        try {
            if (isElementDisplayedById(NAVIGATION_MENU_VIEW)){
                scrollTheMenuViewDown(XPATH_OF_SCROLL_VIEW_IN_MENU_SCREEN);
                Logger.logStep("Menu screen is displayed");
            }
            else {
                Logger.logError("Menu screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Tap on sign in or sing up button
     */
    @Override
    public void tapOnSignUpOrSignInButton() {
        Logger.logComment("Tapping on sign up or sign in button");
        try {
            if (isElementDisplayedById(SIGN_IN_OR_SIGN_UP_BUTTON)){
                driver.findElement(By.id(SIGN_IN_OR_SIGN_UP_BUTTON)).click();
                Logger.logComment("Tapped on sign in / sign up button");
            }else {
                Logger.logError("Sign in or sign up button is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on sign up or sign in button");
        }
    }

    /**
     * Check user is signed up (in menu screen) with correct parsing credentials (in signed up screen )
     */
    @Override
    public void checkUserIsSignedUpSignedInWithCorrectParsingCredentials(String emailEnteredInSignUpScreen) {
        Logger.logAction("Check app is signed up or signed in with user parsing signUp credentials");
        try {
            if (isElementDisplayedById(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN)){
                String signedInEmailId = driver.findElementById(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN).getText();
                {
                    if (signedInEmailId.matches(emailEnteredInSignUpScreen)){
                        Logger.logStep("App is signed up with correct user parsed signed up credentials");
                    }else {
                        Logger.logError("App is not signed up with correct user parsed signed up credentials");
                    }
                }
            }else {
                Logger.logError(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN+"- element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the user signed up status");
        }
    }

    /**
     * Navigate to the flights tab
     */
    @Override
    public void navigateToFlightsTab() {
        Logger.logAction("Navigating to flights tab");
        try {
            if (isElementDisplayedById(FULL_SCREEN_LAYOUT)){
                WebElement fullScreenLayout = driver.findElementById(FULL_SCREEN_LAYOUT);
                tapOnElementBasedOnLocation(fullScreenLayout,"bottomRight");
            }else {
                Logger.logError("Menu screen xpath is incorrect :-"+FULL_SCREEN_LAYOUT);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to navigate to flights tab");
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
            if (isElementEnabledById(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN) && !isElementEnabledById(SIGN_IN_OR_SIGN_UP_BUTTON)){
//                List<WebElement> checkedTextViews = driver.findElementsByClassName(CHECKED_TEXT_VIEW);
//                for (int index=0; index<=checkedTextViews.size()-1;index++){
//                    String checkedTextViewName = checkedTextViews.get(index).getText();
//                    if (checkedTextViewName.equals(LOGOUT_BUTTON)){
                        Logger.logStep("User is signed in");
                        return true;
//                    }else {
//                        continue;
//                    }
//                }
            }else {
                Logger.logStep("User is not signed in");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("encountered error: Unable to check the user signed in status");
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
//            if (isElementDisplayedByClassName(SCROLL_VIEW_IN_MENU_SCREEN)){
                if (isElementDisplayedById(SETTINGS_OPTION)){
                    driver.findElementById(SETTINGS_OPTION).click();
                    Logger.logComment("Tapped on Settings button");
                }else {
                    scrollTheMenuViewUp(XPATH_OF_SCROLL_VIEW_IN_MENU_SCREEN);
                    if (isElementDisplayedById(SETTINGS_OPTION)) {
                        driver.findElementById(SETTINGS_OPTION).click();
                        Logger.logComment("Tapped on Settings button");
                    }else {
                        Logger.logError(SETTINGS_OPTION+" :- element name is not displayed in the current active screen");
                    }
                }
//            }else {
//                Logger.logError(SCROLL_VIEW_IN_MENU_SCREEN+" :- element id is not displayed in the current active screen");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }

    /**
     * Tap on logout button
     */
    @Override
    public void tapOnLogoutButton() {
        Logger.logAction("Tapping on logout button");
        try {
            tapOnSettingsButton();
//            Thread.sleep(4000);
            if (isSettingsScreenIsDisplayed()){
                if (isElementDisplayedById(LOGOUT_BUTTON)){
                    driver.findElementById(LOGOUT_BUTTON).click();
                    Logger.logComment("Tapped on logout button");
                }else {
                    Logger.logError(LOGOUT_BUTTON+" :- element name is not displayed in the current active screen");
                }
            }else {
                Logger.logError("Settigns screen is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }

    /**
     * Checking the Settings screen is displayed or not ?
     * @return
     */
    public static boolean isSettingsScreenIsDisplayed() {
        Logger.logAction("Checking the Settings screen is displayed");
        String valueOfSettingsScreenTitle;
        try{
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels_Flights.ANDROID_ACTIVITY_INDICATOR);
            if (isElementDisplayedByXPath(XPATH_OF_SETTINGS_SCREEN_TITTLE)){
                valueOfSettingsScreenTitle = driver.findElementByXPath(XPATH_OF_SETTINGS_SCREEN_TITTLE).getText();
                if (valueOfSettingsScreenTitle.equals("Settings")){
                    return true;
                }else {
                    Logger.logError(" Settings screen is not displayed in the current active screen");
                }
            }else {
                Logger.logError(XPATH_OF_SETTINGS_SCREEN_TITTLE+" :- element xpath is not visible in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
        return false;
    }

    /**
     * Scroll the menu screen to upwards
     */
    public static void scrollTheMenuViewUp(String viewType) {
        Logger.logAction("Scrolling the menu view upwards");
        try{
            if (isElementDisplayedByXPath(viewType)){
                WebElement menuView = driver.findElementByXPath(viewType);
                swipeOnElementBasedOnLocation(menuView,"bottomCenter","bottomLeft");
//                scrollTheScreenUpwards();
            }else {
                Logger.logError(viewType+" :- element id is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the menu view to upwards");
        }
    }

    /**
     * Scroll the menu screen to upwards
     */
    public static void scrollTheMenuViewDown(String viewType) {
        Logger.logAction("Scrolling the menu view downwards");
        try{
            if (isElementDisplayedByXPath(viewType)){
                Thread.sleep(1000);
                WebElement menuView = driver.findElement(By.xpath(viewType));
                swipeOnElementBasedOnLocation(menuView,"centerRight","center");
//                scrollTheScreenUpwards();
            }else {
                Logger.logError(viewType+" :- element id is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the menu view to upwards");
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
                if (isElementEnabledById(elementName)){
                    Logger.logComment(elementName+" :- sub menu element is enabled");
                }else {
                    Logger.logError(elementName+" sub menu element is not enabled");
                }
            }
            scrollTheMenuViewUp(XPATH_OF_SCROLL_VIEW_IN_MENU_SCREEN);
            if (isElementEnabledById(PRIVACY_POLICY_OPTION)){
                Logger.logComment(PRIVACY_POLICY_OPTION+" :- sub menu element is enabled");
            }else {
                Logger.logError(PRIVACY_POLICY_OPTION+" :- sub menu element is not enabled");
            }if (isElementEnabledById(SETTINGS_OPTION)){
                Logger.logComment(SETTINGS_OPTION+" :- sub menu element is enabled");
            }else {
                Logger.logError(SETTINGS_OPTION+" :- sub menu element is not enabled");
            }
            if (isUserSignedIn()){
                Logger.logComment("User is signed in. So no logout button is displayed in the sub menu screen");
//                MenuScreen.tapOnSettingsButton();
//                Se
//                if (isElementEnabledById(LOGOUT_BUTTON)){
//                    Logger.logComment(LOGOUT_BUTTON+" :- sub menu element id is enabled");
//                }else {
//                    Logger.logError(LOGOUT_BUTTON+" :- sub menu element id is not enabled");
//                }
            }else {
                Logger.logComment("User is not signed in. So no logout button is displayed in the sub menu screen, going to check the sign up email id button is displayed");
                if (isElementEnabledById(SIGN_IN_OR_SIGN_UP_BUTTON)){
                    Logger.logComment("Sign up email id is displayed");
                }else {
                    Logger.logError("Sign p email id is not displayed in the current active screen");
                }
            }
            // Below five methods are to set the menu bar in default state
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
            scrollTheMenuViewDown(XPATH_OF_SCROLL_VIEW_IN_MENU_SCREEN);
            MenuScreen.navigateToFlightsTab();
            //
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check all the sub menu options are displayed");
        }
    }

    /**
     * Tap on profile edit icon
     */
    @Override
    public void tapOnProfileEditIcon() {
        Logger.logAction("Tapping on profile edit icon");
        try{
            if (isElementDisplayedById(PROFILE_EDIT_ICON)){
                driver.findElementById(PROFILE_EDIT_ICON).click();
                Logger.logComment("Tapped on profile edit button");
            }else {
                Logger.logError(PROFILE_EDIT_ICON+" ;- element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on profile edit icon");
        }
    }

    /**
     * Tap on Refer and earn icon in the menu screen
     */
    @Override
    public void tapOnReferAndEarnIcon(){
        Logger.logAction("Tapping on refer and earn icon in the menu screen");
        try{
            if (isElementEnabledById(REFER_AND_EARN_SUB_MENU_ICON)){
                Logger.logComment(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is enabled");
                driver.findElementById(REFER_AND_EARN_SUB_MENU_ICON).click();
                Logger.logStep("Tapped on refer and earn button");
            }else {
                Logger.logError(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is not enabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on refer and earn icon");
        }
    }

    /**
     * Tap on trips sub menu option
     */
    @Override
    public void tapOnMyTripsSubMenuButton(){
        Logger.logAction("Tapping on My Trips option in menu list");
        try{
            //Todo: This method need to be rechecked after implementation of new UI in iOS because MyTrips is displaying in menu screen in iOS and in main tab bar in Android app
            MenuScreen.navigateToFlightsTab();
            FlightsScreen.checkFlightsTabIsDisplayed();
            if (isElementEnabledById(MAIN_TAB_BAR)){
                List<WebElement> listOfTabs = driver.findElementById(MAIN_TAB_BAR).findElements(By.className(Labels_Flights.ANDROID_TAB_BAR));
                WebElement textView = listOfTabs.get(2).findElement(By.className(Labels_Flights.ANDROID_TEXT_VIEW));
                String tripsTabName = textView.getText();
                if (tripsTabName.equalsIgnoreCase(TRIPS_OPTION)){
                    listOfTabs.get(2).click();
                    Logger.logStep("Tapped on trips option");
                }else {
                    Logger.logError("Trips option is not displayed");
            }
            }else {
                Logger.logError("Tab bar is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }

    /**
     * Tap on Arabic option in sub menu button
     */
    @Override
    public void tapOnArabicInSubMenuButton(){
        Logger.logAction("Tapping on Arabic option in menu list");
        try{
            if (isElementEnabledById(LANGUAGE_TITLE)){
                WebElement languageTitle = driver.findElementById(LANGUAGE_TITLE);
                String languageTitleName = languageTitle.getText();
                if (languageTitleName.equalsIgnoreCase(Labels_Flights.ARABIC_LANGUAGE)){
                    Logger.logComment(Labels_Flights.ARABIC_LANGUAGE+" :- sub menu element is displayed");
                    languageTitle.click();
                    Logger.logStep("Arabic option is tapped");
                }
            }else {
                Logger.logError(Labels_Flights.ARABIC_LANGUAGE+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on arabic sub menu button");
        }
    }

    /**
     * Tap on English option in sub menu button
     */
    @Override
    public void tapOnEnglishInSubMenuButton(){
        Logger.logAction("Tapping on Arabic option in menu list");
        try{
            if (isElementEnabledById(LANGUAGE_TYPE)){
                WebElement languageTitle = driver.findElementById(LANGUAGE_TYPE);
                String languageTitleName = languageTitle.getText();
                if (languageTitleName.equalsIgnoreCase(Labels_Flights.ENGLISH_LANGUAGE)){
                    Logger.logComment(Labels_Flights.ENGLISH_LANGUAGE+" :- sub menu element is displayed");
                    languageTitle.click();
                    Logger.logStep("English option is tapped");
                }
            }else {
                Logger.logError(Labels_Flights.ENGLISH_LANGUAGE+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on english sub menu button");
        }
    }

    /**
     * Tap on 24/7 option in sub menu button
     */
    @Override
    public void tapOnTwentyFourBarSevenOptionInSubMenuList(){
        Logger.logAction("Tapping on 24/7 option in menu list");
        try{
            findElementByIdAndClick(TWENTY_FOUR_BAR_SEVEN_SUPPORT_OPTION);
            Logger.logStep("Tapped on 24/7 menu option");
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
            scrollTheMenuViewUp(XPATH_OF_SCROLL_VIEW_IN_MENU_SCREEN);
            findElementByIdAndClick(PRIVACY_POLICY_OPTION);
            Logger.logStep("Tapped on Privacy policy screen");
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
            String elementName = findElementByXpathAndReturnItsAttributeText(XPATH_OF_RATE_US_TITLE);
            if (elementName.equalsIgnoreCase(RATE_US_TITLE)){
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
            Logger.logError("Star rating elements all are labeled as one element. so not possible to tap on particular star"); // Todo:- Remove this line of code after making the star label as unique for each star
//            String xpathOfSelectingStartNumber = XPATH_OF_STAR_NUMBER_WITHOUT_INDEX+parsingInteger+"]";
//            findElementByXPathAndClick(xpathOfSelectingStartNumber);
//            Logger.logComment("Tapped on star number :- "+parsingInteger);
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
//            String starRatingNameDisplayingInApp = getTheStarRatingNameDisplaying();
//            String startRatingNameShouldBeDisplayed = listOfStarRatingNames[selectedStarNumber-1];
//            if (starRatingNameDisplayingInApp.equalsIgnoreCase(startRatingNameShouldBeDisplayed)){
//            Logger.logStep("Correct star rating name is displayed for selected star :- "+selectedStarNumber+" as - "+starRatingNameDisplayingInApp);
//            }else {
//                Logger.logComment("Star rating selected is :- "+selectedStarNumber);
//                Logger.logComment("Star rating name displaying is :- "+starRatingNameDisplayingInApp);
//                Logger.logComment("Star rating name to be displayed is :- "+startRatingNameShouldBeDisplayed);
//                Logger.logError("Incorrect star ratings name is displayed");
//            }
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
//            String helpUsImproveButtonLabelName = getTheHelpUsImproveButtonLabelName();
//            if (selectedStarNumber>3){
//                if (helpUsImproveButtonLabelName.equalsIgnoreCase(RATE_US_ON_APP_STORE)){
//                    Logger.logStep("Help us improve button label is displayed for the selected star number :- "+selectedStarNumber);
//                }else {
//                    Logger.logComment("Star rating selected is :- "+selectedStarNumber);
//                    Logger.logComment("Star rating name displaying is :- "+helpUsImproveButtonLabelName);
//                    Logger.logComment("Star rating name to be displayed is :- "+RATE_US_ON_APP_STORE);
//                    Logger.logError("Help us button label is changed in correctly for selected star number :- "+selectedStarNumber);
//                }
//            }else if (selectedStarNumber<=3){
//                if (helpUsImproveButtonLabelName.equalsIgnoreCase(HELP_US_IMPROVE)){
//                    Logger.logStep("Rate us on app store button label is displayed for the selected star number :- "+selectedStarNumber);
//                }else {
//                    Logger.logComment("Star rating selected is :- "+selectedStarNumber);
//                    Logger.logComment("Star rating name displaying is :- "+helpUsImproveButtonLabelName);
//                    Logger.logComment("Star rating name to be displayed is :- "+HELP_US_IMPROVE);
//                    Logger.logError("Help us button label is changed in correctly for selected star number :- "+selectedStarNumber);
//                }
//            }else {
//                Logger.logError("Selected star number value is greater than 5 .i.e.., "+selectedStarNumber);
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the help us button label is changed correctly as per selected star number");
        }
    }

    /**
     * Get The star rating name displaying
     * @return
     */
    @Override
    public String  getTheStarRatingNameDisplaying(){
        Logger.logAction("Getting the star rating name");
        try {
//            String starRatingName = findElementByXpathAndReturnItsAttributeText(XPATH_OF_STAR_RATING_NAME);
//            return starRatingName;
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
//            String helpUsImproveButtonLabel = findElementByXpathAndReturnItsAttributeText(XPATH_OF_HELP_US_IMPROVE_BUTTON);
//            return helpUsImproveButtonLabel;
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
            String buttonName = findElementByIdAndReturnText(HELP_US_IMPROVE_BUTTON);
            if (buttonName.equalsIgnoreCase(HELP_US_IMPROVE_LABEL)){
                findElementByIdAndClick(HELP_US_IMPROVE_BUTTON);
                Logger.logStep("Tapped on hep us improve button");
            }else {
                Logger.logComment("Displaying button name is :- "+buttonName);
                Logger.logComment("Display button name should be :- "+HELP_US_IMPROVE_LABEL);
                Logger.logError("Incorrect button name is displayed");
            }
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
            String buttonName = findElementByIdAndReturnText(HELP_US_IMPROVE_BUTTON);
            if (buttonName.equalsIgnoreCase(RATE_US_ON_PLAY_STORE_LABEL)){
                findElementByIdAndClick(HELP_US_IMPROVE_BUTTON);
                Logger.logStep("Tapped on rate us on app store button");
            }else {
                Logger.logComment("Displaying button name is :- "+buttonName);
                Logger.logComment("Display button name should be :- "+HELP_US_IMPROVE_LABEL);
                Logger.logError("Incorrect button name is displayed");
            }
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
            if (isWelcomeEmailScreenIsDisplayed()){
                Logger.logStep("Email set up is not done in the device");
                return false;
            }else if (isElementDisplayedById("android:id/button_always") && isElementDisplayedById("android:id/button_once"))
            {
                Logger.logComment("New email suggestion email modal view is displayed");
                findElementByIdAndClick("android:id/button_once");
                if(isElementDisplayedByAccessibilityId("More options") && isElementDisplayedById("com.google.android.gm:id/send") && isElementDisplayedByAccessibilityId("From")){
                    Logger.logStep("New email window is displayed");
                    return true;
                }
            }else {
                Logger.logError("Could not check the displayed alert type");
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
            if (isNewEmailWindowIsDisplayed()){
                findElementByIdAndClick("com.google.android.gm:id/send");
                Logger.logComment("Tapped on email send button");
                if (isElementDisplayedByName("com.google.android.gm:id/send")){
                    Logger.logError("Email is not sent");
                }else {
                    Logger.logStep("Email is sent");
                }
            }else {
                Logger.logError("New email window is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the email");
        }
    }

    /**
     * Check the could not send email alert is displayed
     */
    public static boolean isWelcomeEmailScreenIsDisplayed(){
        Logger.logAction("Checking Could not send email alert is displayed or not ?");
        try {
            if (isElementDisplayedById("com.google.android.gm:id/welcome_tour_pager")){
                Logger.logComment("Welcome email window is displayed");
                return true;
            }else {
                Logger.logWarning("Welcome email window is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the screen title");
        }
        return false;
    }

    /**
     * Tap on cancel button in new email window
     */
    @Override
    public void tapOnCancelButtonInNewEmailWindow(){
        Logger.logAction("Tapping on cancel button in new email window");
        try {
            if (isNewEmailWindowIsDisplayed()){
                findElementByXPathAndClick("//android.widget.ImageView[@content-desc=\"More options\"]");
                Logger.logComment("Tapped on More options button");
            }else {
                Logger.logError("New email window is not displayed");
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
            String elementName = findElementByXpathAndReturnItsAttributeName(XPATH_OF_DISCARD_BUTTON_IN_NEW_EMAIL_WINDOW);
            if (elementName.equalsIgnoreCase("Discard"))
                findElementByXPathAndClick(XPATH_OF_DISCARD_BUTTON_IN_NEW_EMAIL_WINDOW);
            Logger.logComment("Tapped on delete draft button");
        }catch (Exception exception){
            Logger.logError("Encountered error :- Unable to tap on delete draft button in new email window ");
        }
    }




}
