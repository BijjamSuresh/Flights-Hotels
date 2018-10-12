package com.automation.rehlat.hotels.libCommon;

import com.automation.rehlat.hotels.Base;
import com.automation.rehlat.hotels.Labels_Hotels;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.automation.rehlat.flights.Labels_Flights.*;
import static com.automation.rehlat.flights.tests.BaseTest.*;

public class General extends Base {

    public static String FULL_PATH_OF_IOS_APP = "/Users/rehlat/Documents/SimulatorProject/Rehlat.app";
    public static String FULL_PATH_OF_ANDROID_APP = "/Users/rehlat/Documents/SimulatorProject//app_debug.apk";

    /**
     *  Creates array of words from string which contains multiple words using single white space as identifier to differentiate words
     *  @param sentence of type String which contains multiple words
     */
    public static String[] createArrayOfWordFromString(String sentence) {
        String[] arrayOfWords = new String[0];
        try {
            Logger.logAction("Convert the sentence to array of words");
            arrayOfWords = sentence.split("\\s+");
        }
        catch (Exception exceptionDetail)   {
            Logger.logWarning("Failed to convert sentence into array of words");
        }
        return arrayOfWords;
    }


    /**
     * Executes the terminal command and returns its output
     * @param terminalCommand the command which is to be ran in the terminal
     * @return String the output of the ran command
     */
    public static String executeTerminalCommandArray(String[] terminalCommand) {
        // Escape special characters
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(terminalCommand);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    /**
     * Executes the terminal command and returns its output
     * @param terminalCommand the command which is to be ran in the terminal
     * @return String the output of the ran command
     */
    public static String executeTerminalCommand(String terminalCommand) {
        // Escape special characters
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(terminalCommand);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    /**
     * Method to uninstall the app
     */
    public static void unInstallApp() {
        Logger.logAction("Uninstalling the App");
        if (platform.equalsIgnoreCase(Labels_Hotels.IOS)){
            try {
                if (isAppInstalled(IOS_BUNDLE_ID)){
                    Logger.logComment("App is installed, going to un-install the app");
                    driver.removeApp(IOS_BUNDLE_ID);
                    Logger.logComment("App is uninstalled");
                }else {
                    Logger.logComment("App is already uninstalled");
                }
            } catch (Exception exception) {
                Logger.logError("Unable to uninstall the app ");
            }
        }else if (platform.equalsIgnoreCase(Labels_Hotels.ANDROID)) {
            try {
                if (isAppInstalled(ANDROID_CAPABILITIES_PACKAGE_NAME)){
                    Logger.logComment("App is installed, going to un-install the app");
                    driver.removeApp(Labels_Hotels.ANDROID_CAPABILITIES_PACKAGE_NAME);
                    Logger.logComment("App is uninstalled");
                }else {
                    Logger.logComment("App is already uninstalled");
                }
            } catch (Exception exception) {
                Logger.logError("Unable to uninstall the app ");
            }
        }else {
            Logger.logError("Current testing device is neither android nor iOS");
        }
    }

    /**
     * Method to install the app
     */
    public static void installApp() {
        Logger.logAction("Installing the App");
        try {
            if (platform.equalsIgnoreCase(Labels_Hotels.IOS)){
                try {
                    if (!isAppInstalled(IOS_BUNDLE_ID)){
                        Logger.logComment("App is not installed, going to install the app");
                        driver.installApp(FULL_PATH_OF_IOS_APP);
                        Logger.logComment("App is installed");
                    }else {
                        Logger.logComment("App is already installed");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    Logger.logError("Unable to uninstall the app ");
                }
            }else if (platform.equalsIgnoreCase(Labels_Hotels.ANDROID)) {
                try {
                    if (!isAppInstalled(ANDROID_CAPABILITIES_PACKAGE_NAME)){
                        Logger.logComment("App is not installed, going to install the app");
                        driver.installApp(FULL_PATH_OF_ANDROID_APP);
                        Logger.logComment("App is installed");
                    }else {
                        Logger.logComment("App is already installed");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    Logger.logError("Unable to uninstall the app ");
                }
            }else {
                Logger.logError("Current testing device is neither android nor iOS");
            }
        } catch (Exception exception) {
            Logger.logError("Unable to install the app, Please find the below error");
        }
    }

    /**
     * Method to launch the app
     */
    public static void launchApp() {
        Logger.logAction("Launching  the App");
        try {
            driver.launchApp();
            Logger.logStep("App is launched");
        } catch (Exception exception) {
            Logger.logError("unable to Launch the app ");
        }
    }

    /**
     * Check whether the app is installed or not ? by using package name
     * @return
     */
    public static boolean isAppInstalled(String parsingPackageName) {
        Logger.logAction("Checking the app is installed or not ?");
        try{
            boolean status = driver.isAppInstalled(parsingPackageName);
            if (status == true){
                Logger.logStep("App is installed");
                return true;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the app is installed or not");
        }
        Logger.logWarning("App is not installed");
        return false;
    }

    /**
     * Accept the location access alert (if displayed)
     */
    public static void accpetTheLocationAccessAlert() {
        Logger.logAction("Accepting the location access alert (if displayed) ?");
        try{
            if (platform.equalsIgnoreCase(Labels_Hotels.IOS)){
                try {
                    acceptUserLocationAlertInIos();
                } catch (Exception exception) {
                    Logger.logError("Unable to accept the user location access alert");
                }
            }else if (platform.equalsIgnoreCase(Labels_Hotels.ANDROID)) {
                try {
                    acceptUserLocationAlertInAndroid();
                } catch (Exception exception) {
                    Logger.logError("Unable to accept the user location access alert");
                }
            }else {
                Logger.logError("Current testing device is neither android nor iOS");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to accept the user location access alert");
        }
    }
    /**
     * Accept the location access alert (if displayed)
     */
    public static void accpetThenotificationAccessAlert() {
        Logger.logAction("Accepting the notification access alert (if displayed) ?");
        try{
            if (platform.equalsIgnoreCase(Labels_Hotels.IOS)){
                try {
                    acceptNotificationAlertInIos();
                } catch (Exception exception) {
                    Logger.logError("Unable to accept the user location access alert");
                }
            }else if (platform.equalsIgnoreCase(Labels_Hotels.ANDROID)) {
                try {
                    acceptNotificationAlertInAndroid();
                } catch (Exception exception) {
                    Logger.logError("Unable to accept the user location access alert");
                }
            }else {
                Logger.logError("Current testing device is neither android nor iOS");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to accept the user location access alert");
        }
    }

    /**
     * Decline the location access alert (if displayed)
     */
    public static void declineTheLocationAccessAlert() {
        Logger.logAction("Declining the location access alert (if displayed) ?");
        try{
            if (platform.equalsIgnoreCase(Labels_Hotels.IOS)){
                try {
                    declineUserLocationAlertInIos();
                } catch (Exception exception) {
                    Logger.logError("Unable to decline the user notification access alert");
                }
            }else if (platform.equalsIgnoreCase(Labels_Hotels.ANDROID)) {
                try {
                    declineUserLocationAlertInAndroid();
                } catch (Exception exception) {
                    Logger.logError("Unable to decline the user notification access alert");
                }
            }else {
                Logger.logError("Current testing device is neither android nor iOS");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to accept the user location access alert");
        }
    }

    /**
     * Accept the location access alert (if displayed)
     */
    public static void acceptTheNotificationAccessAlert() {
        Logger.logAction("Accepting the notification access alert (if displayed) ?");
        try{
            if (platform.equalsIgnoreCase(Labels_Hotels.IOS)){
                try {
                    acceptNotificationAlertInIos();
                } catch (Exception exception) {
                    Logger.logError("Unable to accept the user location access alert");
                }
            }else if (platform.equalsIgnoreCase(Labels_Hotels.ANDROID)) {
                try {
                    acceptNotificationAlertInAndroid();
                } catch (Exception exception) {
                    Logger.logError("Unable to accept the user location access alert");
                }
            }else {
                Logger.logError("Current testing device is neither android nor iOS");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to accept the user location access alert");
        }
    }

}
