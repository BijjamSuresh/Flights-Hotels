package com.automation.rehlat.hotels.pages.interfaces;

public interface Menu {

    /**
     * Check menu screen is displayed
     * @throws Exception
     */
    void checkMenuScreenIsDisplayed() throws Exception;

    /**
     * Tap on sign in or sing up button
     * @throws Exception
     */
    void tapOnSignUpOrSignInButton() throws Exception;

    /**
     * Check user is signed up (in menu screen) with correct parsing credentials (in signed up screen )
     * @throws Exception
     */
    void checkUserIsSignedUpSignedInWithCorrectParsingCredentials(String emailEnteredInSignUpScreen) throws Exception;

    /**
     * Navigate to the flights tab
     * @throws Exception
     */
    void navigateToFlightsTab() throws Exception;

    /**
     * Check whether user is signed in in the app
     * @return
     * @throws Exception
     */
    boolean isUserSignedIn() throws Exception;

    /**
     * Tap on Settings button
     */
    void tapOnSettingsButton() throws Exception;

    /**
     * Tap on logout button
     * @throws Exception
     */
    void tapOnLogoutButton() throws Exception;

    /**
     * Check all the sub menu options are displayed in menu screen
     * @throws Exception
     */
    void checkAllTheSubMenuOptionsAreDisplayed() throws Exception;

    /**
     * Tap on profile edit icon
     * @throws Exception
     */
    void tapOnProfileEditIcon() throws Exception;

    /**
     * Tap on Refer and earn icon in the menu screen
     */
    void tapOnReferAndEarnIcon();

    /**
     * Tap on trips sub menu button
     */
    void tapOnMyTripsSubMenuButton();

    /**
     * Tap on Arabic option in sub menu button
     */
    void tapOnArabicInSubMenuButton();

    /**
     * Tap on English option in sub menu button
     */
    void tapOnEnglishInSubMenuButton();

    /**
     * Tap on 24/7 option in sub menu button
     */
    void tapOnTwentyFourBarSevenOptionInSubMenuList();

    /**
     * Tap on privacy policy option in menu
     */
    void tapOnPrivacyPolicyOption();

    /**
     * Check rate us layout is displayed
     */
    void checkRateUsLayoutIsDisplayed();

    /**
     * Tap on a particular star Number by parsing its value
     * @param parsingInteger
     */
    void tapOnStarNumber(Integer parsingInteger);

    /**
     * Check the tapped star number is selected correctly
     * @param selectedStarNumber
     */
    void checkTheSelectedStarNumberNameIsCorrectlyDisplayed(Integer selectedStarNumber);

    /**
     * Check the help us button label is changed correctly as per selected star number
     * @param selectedStarNumber
     */
    void checkTheHelpUsButtonLabelIsChangedCorrectlyAsPerSelectedStarNumber(Integer selectedStarNumber);

    /**
     * Get The star rating name displaying
     * @return
     */
    String  getTheStarRatingNameDisplaying();

    /**
     * Get The help us improve button label name
     * @return
     */
    String getTheHelpUsImproveButtonLabelName();

    /**
     * Tap on help us improve button
     * @return
     */
    void tapOnHelpUsImproveButton();

    /**
     * Tap on Rate us in store button
     * @return
     */
    void tapOnRateUsInStoreButton();

    /**
     * Send the email by tapping on send button
     */
    void sendEmail();

    /**
     * Tap on cancel button in new email window
     */
    void tapOnCancelButtonInNewEmailWindow();

    /**
     * Tap on delete draft button in new email window
     */
    void tapOnDeleteDraftButtonInNewEmailWindow();

    /**
     * Check is new email window is displayed
     * @return
     */
    boolean isNewEmailWindowIsDisplayed();


}
