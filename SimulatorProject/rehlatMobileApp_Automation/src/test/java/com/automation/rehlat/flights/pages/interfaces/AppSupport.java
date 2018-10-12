package com.automation.rehlat.flights.pages.interfaces;

public interface AppSupport {

    /**
     * Check the support screen is displayed
     */
    void checkSupportScreenIsDisplayed();

    /**
     * Tap on mail us button
     */
    void tapOnMailUsButton();

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
     * Tap on FAQ’S button
     */
   void tapOnFAQSButton();

    /**
     * Check  FAQ’S screen is displayed
     */
    void checkFAQSScreenIsDisplayed();

    /**
     * Tap on FAQ’S close button
     */
    void tapOnFAQSCloseButton();

    /**
     * Tap on call support button
     */
   void tapOnCallCenterButton();

    /**
     * Check  FAQ’S screen is displayed
     */
    void checkCallCenterModalViewIsDisplayed();

    /**
     * Tap on FAQ’S close button
     */
    void tapOnCallCenterModalViewCloseButton();

    /**
     * Check is new email window is displayed
     * @return
     */
    boolean isNewEmailWindowIsDisplayed();
}
