package com.automation.rehlat.hotels;


import com.automation.rehlat.hotels.libCommon.General;
import com.automation.rehlat.hotels.libCommon.Logger;
import com.automation.rehlat.hotels.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.automation.rehlat.hotels.Labels_Hotels.*;
import static com.automation.rehlat.hotels.libCommon.General.installApp;
import static com.automation.rehlat.hotels.libCommon.General.unInstallApp;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Base {
    public static DesiredCapabilities capabilities;
    public static AppiumDriver<WebElement> driver;
    public static WebDriverWait driverWait;
    /**
     * Reference: <a href="http://appium.io/slate/en/master/?ruby#appium-server-capabilities">http://appium.io/slate/en/master/?ruby#appium-server-capabilities</a>
     * This method sets required appium capabilities using the object of DesiredCapabilities class
     * setting device capability by calling setCapability method with first parameter as property name and second parameter is property value
     * @throws Exception
     */
    @BeforeClass
    public static void setUp() throws Exception {
        File app;
        String appPAthPathCapability;
        if (Labels_Hotels.platform.equals(Labels_Hotels.IOS)) {
            new DesiredCapabilities();
            capabilities = DesiredCapabilities.iphone();
            capabilities.setCapability("appium-version", Labels_Hotels.IOS_CAPABILITIES_APPIUM_VERSION);
            capabilities.setCapability("deviceName", Labels_Hotels.IOS_CAPABILITIES_DEVICE_NAME);
            capabilities.setCapability("platformName", Labels_Hotels.IOS);
            capabilities.setCapability("platformVersion", Labels_Hotels.IOS_CAPABILITIES_PLATFORM_VERSION_IPHONE7PLUS);
            capabilities.setCapability("udid", Labels_Hotels.udid);
            capabilities.setCapability("app", Labels_Hotels.IOS_BUNDLE_ID);
            capabilities.setCapability("waitForAppScript", true);
//            capabilities.setCapability("autoGrantPermissions",true );
//            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("showXcodeLog", true);
            app = new File(Labels_Hotels.IOS_CAPABILITIES_APP_PATH);
            appPAthPathCapability = app.getAbsolutePath();
            capabilities.setCapability("app", appPAthPathCapability);
            capabilities.setCapability("newCommandTimeout", "500");
            capabilities.setCapability("orientation", PORTRAIT_ORIENTATION);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("wdaLocalPort", WDA_LOCAL_PORT);
            capabilities.setCapability("waitForAppScript", "true");
            driver = new IOSDriver(new URL(Labels_Hotels.IOS_CAPABILITIES_URL), capabilities);
        } else if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
            new DesiredCapabilities();
            capabilities = DesiredCapabilities.android();
            capabilities.setCapability("deviceName", Labels_Hotels.DEVICE_NAME);
            capabilities.setCapability("appium-version", Labels_Hotels.ANDROID_CAPABILITIES_APPIUM_VERSION);
            capabilities.setCapability("platformName", Labels_Hotels.ANDROID);
            capabilities.setCapability("deviceId", Labels_Hotels.ANDROID_CAPABILITIES_DEVICE_ID);
            capabilities.setCapability("platformVersion", Labels_Hotels.ANDROID_CAPABILITIES_PLATFORM_VERSION);
//            capabilities.setCapability("appPackage", Labels_Hotels.ANDROID_CAPABILITIES_PACKAGE_NAME);
//            capabilities.setCapability("autoAcceptAlerts", true);
            app = new File(Labels_Hotels.ANDROID_CAPABILITIES_APP_PATH);
            appPAthPathCapability = app.getAbsolutePath();
            capabilities.setCapability("app", appPAthPathCapability);
            capabilities.setCapability("orientation", PORTRAIT_ORIENTATION);
            capabilities.setCapability("appWaitActivity", "com.app.rehlat.SplashActivity");
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("newCommandTimeout", "8000");
            driver = new AndroidDriver(new URL(Labels_Hotels.ANDROID_CAPABILITIES_URL), capabilities);
        } else {
            Logger.logError("The platform mentioned for the test script is neither iOS or Android");
        }
        driverWait = new WebDriverWait(driver, Labels_Hotels.DEFAULT_WAITING_TIME);
    }

    /**
     * Quits app after executing test scripts.
     */
    @AfterClass
    public static void tearDown() {
        Logger.logComment("Sign Up email id used till yet :- "+ Labels_Hotels.EMAIL_ID_SIGN_UP);
        BasePage.IS_SELECTED_PRO_ROOM_IS_NON_REFUNDABLE_ROOM = false;
        BasePage.IS_SELECTED_BED_ROOM_IS_NON_REFUNDABLE_ROOM = false;
        BasePage.HOTELS_SIGN_IN_STATUS_IOS = false;
        BasePage.HOTELS_SIGN_IN_STATUS_ANDROID = false;
        driver.quit();
    }

    /**
     *  Watches the script failure while running on app in the testing device
     */
    @Rule
    public TestWatcher watch = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            if (platform.equalsIgnoreCase(Labels_Hotels.ANDROID)){
                driver.runAppInBackground(1);
                BasePage.closeTheKeyboard_Android();
            }
            takeScreenshot();
            super.failed(e, description);
        }
    };

    /**
     * Send the email id
     */
    public static void sendEmail(String reportInHtml){
        Logger.logAction("Sending the email..,");
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(555);
            email.setAuthenticator(new DefaultAuthenticator("suresh.bijjam@rehlat.com","L>88G97dd"));
            email.setSSLOnConnect(true);
            email.setFrom("suresh.bijjam@rehlat.com");
            email.setSubject(Labels_Hotels.DEFAULT_PLATFORM+":"+Labels_Hotels.DEVICE_NAME+":"+Labels_Hotels.DEVICE_OS+" Execution Results");
            email.setMsg("Please find the below html report for in-details \n");
            email.addTo("suresh.bijjam@rehlat.com");
            email.setHtmlMsg(reportInHtml);
            email.send();
            Logger.logComment("Email is sent");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the email");
        }
    }

    /**
     * Used to take a screen shot of the screen when ever test script fails or error appears on screen.
     * @return void
     */
    public static void takeScreenshot() {
        Logger.logComment(" Failure in the script, so taking the screenshot");
        try {
            String nameOfTestCase = getTestCaseName();
            String pathOfScreenshot = "Screenshots/NexusEmulator/"+ nameOfTestCase + "_" + getPlatform();
            Thread.sleep(1000);
//            BasePage.closeTheKeyboard_Android();
//            String pathOfScreenshot = "Screenshots/"+ nameOfTestCase + "_" + getPlatform();
            if (platform.equalsIgnoreCase(IOS)){
               pathOfScreenshot = "Screenshots/iOS/"+ nameOfTestCase + "_" + getPlatform();
            }else if (platform.equalsIgnoreCase(ANDROID)){
                pathOfScreenshot = "Screenshots/Android/"+ nameOfTestCase + "_" + getPlatform();
            }
            String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            System.out.println(new File(pathOfScreenshot + "_" + time + ".jpg"));
            File screenshot = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(pathOfScreenshot + "_" + time + ".jpg"));
        } catch (Exception exception) {
            exception.printStackTrace();
            Logger.logWarning(" couldn't take screenshot");
        }
    }

    /**
     * Used to get current running test script.
     * @return void
     */
    public static String getTestCaseName() {
        return Labels_Hotels.testCaseName;
    }

    /**
     * Get the platform from labels
     * @return
     */
    public static String getPlatform() {
        return Labels_Hotels.platform;
    }

    /**
     * Used to set current running test script to a variable.
     * @return void
     */
    public static void setTestCaseName(String name) {
        Labels_Hotels.testCaseName = name;
    }

    /**
     * This is to wait for an element to disappear, the wait goes on for 60 seconds
     * @param elementLocator
     * @throws Exception
     */
    public static void waitForElementToDisappear(String elementLocator) throws Exception {
        Logger.logAction("Waiting for " + elementLocator + " to disappear");
        for (int i = 1; i <= 60; i++) {
            if (elementExists(elementLocator, 0)) {
                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            } else {
                break;
            }
        }
    }

    /**
     * This is to create a waiting loop that will last an arbitrary amount of time in seconds
     * The method resets driverWait to the default waiting time for future use.
     * @param elementLocator element to wait for
     * @param seconds        max time to wait for
     * @return true if the element is there, false otherwise.
     */
    public static boolean elementExists(String elementLocator, int seconds) {
        long timeToWait = (seconds == 0) ? 1 : (seconds * Labels_Hotels.TAP_DURATION_MIN);
        boolean found;
        try {
            driverWait.withTimeout(timeToWait, TimeUnit.MILLISECONDS).until(ExpectedConditions.elementToBeClickable(driver.findElementByName(elementLocator)));
            Logger.logAction(elementLocator + " Found!");
            found = true;
        } catch (Exception exception) {
            Logger.logAction(elementLocator + " Not found!");
            found = false;
        }
        driverWait.withTimeout(Labels_Hotels.WAIT_TIME_DEFAULT, TimeUnit.SECONDS);
        return found;
    }

    /**
     * Gets the os version on which the script is run for iOS
     * @return String version of the ios device
     */
    public static String getOsVersionIosOnly() {
        try{
            String commandArrayToListIosDevices[] = General.createArrayOfWordFromString(Labels_Hotels.TERMINAL_COMMAND_LISTING_CONNECTED_IOS_DEVICES);
            String terminalOutput = General.executeTerminalCommandArray(commandArrayToListIosDevices);
            String[] stringArray;
            stringArray = terminalOutput.split("\n");
            for (String element : stringArray) {
                if (element.contains((CharSequence) capabilities.getCapability("udid"))) {
                    String version = getIosVersion(element);
                    if (version != null)
                    {
                        return version;

                    }
                }
            }
            fail("The given device is not connected");
            return null;
        } catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the OS version of the connected device");
        }
        return null;
    }

    /**
     * Used to get iOS version using regular expression.
     * @return void
     */
    public static String getIosVersion(String parsingText) {
        String version = null;
        Pattern pattern = Pattern.compile("^(\\*|\\d+(\\.\\d+){0,2}(\\.\\*)?)$");
        Matcher matchingText = pattern.matcher(parsingText);
        while (matchingText.find()) {
            version = matchingText.group();
            version = version.replaceAll("[()]", "");
            return version;
        }
        return version;
    }

    /**
     * Verify element is displayed in screen using element name for ios and text attribute for android.
     * @param elementName element name for ios and element text for android.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isElementDisplayedByName(String elementName) throws Exception {
        Logger.logAction("Checking - "+ elementName+" - element name is displayed");
        int counter = 0;
        WebElement element;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementByName(elementName);
                if (element.isDisplayed()) {
                    Logger.logComment(elementName + " - element name is displayed and moving forward to next step");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter +" time trying to find the element name of - " + elementName);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            counter++;
        }
        Logger.logComment(elementName + " - element name is not displayed in the current active screen");
        return false;
    }

    /**
     * Verify element is displayed in screen using element id for ios and android.
     * @param elementId element name for ios and element text for android.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isElementDisplayedById(String elementId) throws Exception {
        Logger.logAction("Checking - "+ elementId+" - element id is displayed");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementById(elementId);
                if (element.isDisplayed()) {
                    Logger.logComment(elementId + " - element id is displayed and moving forward to next step");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter +" time trying to find the element id of - " + elementId);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            counter++;
        }
        Logger.logWarning(elementId + " - element id is not displayed in the current active screen");
        return false;
    }


    /**
     * Verify element is displayed in screen using element id for ios and android.
     * @param elementId element name for ios and element text for android.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isElementDisplayedByAccessibilityId(String elementId) throws Exception {
        Logger.logAction("Checking - "+ elementId+" - element id is displayed");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementByAccessibilityId(elementId);
                if (element.isDisplayed() || element.isEnabled()) {
                    Logger.logComment(elementId + " - element id is displayed and moving forward to next step");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find the element id of - " + elementId);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            counter++;
        }
        Logger.logWarning(elementId + " - element accessibility id is not displayed in the current active screen");
        return false;
    }

    /**
     * Verify element is displayed in screen using element id for ios and android.
     * @param elementId element name for ios and element text for android.
     * @return status returns true if element displayed else false.
     */
    public static boolean isElementDisplayedByIdWithOneTimeChecking(String elementId) {
        Logger.logAction("Checking - "+ elementId+" - element id is displayed");
        try {
            WebElement element = driver.findElementById(elementId);
            if (element.isDisplayed()) {
                Logger.logComment(elementId + " - element id is displayed and moving forward to next step");
                return true;
            }
        } catch (Exception e) {
            Logger.logComment( " One time trying to find the element id of - " + elementId);
        }
        Logger.logWarning(elementId + " - element id is not displayed in the current active screen");
        return false;
    }

    /**
     * Verify element is displayed in screen using element class name as parameter.
     * @param elementName
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isElementDisplayedByClassName(String elementName) throws Exception {
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementByClassName(elementName);
                if (element.isDisplayed()) {
                    Logger.logComment(elementName + " - element class name is displayed and moving forward to next step");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find the element name :- " + elementName);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            counter++;
        }
        Logger.logComment(elementName + " - element name is not displayed in the current active screen ");
        return false;
    }

    /**
     * Verify element is enabled in screen using element name for ios and text attribute for android.
     * @param elementName element name for ios and element text for android.
     * @return status returns true if element enabled else false.
     * @throws Exception
     */
    public static boolean isElementEnabledByName(String elementName) throws Exception {
        Logger.logAction("Checking "+ elementName+" is enabled or not ?");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementByName(elementName);
                if (element.isEnabled()) {
                    Logger.logComment( elementName+" is enabled and moving forward to next action");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        Logger.logComment(elementName + " - is not displayed in the current active screen");
        return false;
    }

    /**
     * Verify element is enabled in screen using element name for ios and text attribute for android.
     * @param elementName element name for ios and element text for android.
     * @return status returns true if element enabled else false.
     * @throws Exception
     */
    public static boolean isElementEnabledById(String elementName) throws Exception {
        Logger.logAction("Checking - "+ elementName+" - element name is enabled");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementById(elementName);
                if (element.isEnabled()) {
                    Logger.logComment(elementName + " - element is enabled and moving forward to next action");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            counter++;
        }
        Logger.logWarning( elementName+" is not enabled");
        return false;
    }

    /**
     * Verify sub element is enabled in screen using element name as parameter.
     * @param elementName element name.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isSubElementEnabledByName(String elementName, WebElement webElementName) throws Exception {
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
                    element = ((AndroidElement) webElementName).findElementByAndroidUIAutomator("new UiSelector().text(\"" + elementName + "\")");
                } else {
                    element = webElementName.findElement(By.name(elementName));
                    Logger.logComment(elementName + " - is displayed and moving forward to next action");
                }
                if (element.isEnabled()) {
                    Logger.logComment(elementName + " - is enabled and moving forward to next action");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Verify element is enabled in screen using element ClassName for ios and text attribute for android.
     * @param className element name for ios and element text for android.
     * @return status returns true if element enabled else false.
     * @throws Exception
     */
    public static boolean isElementEnabledByClassName(String className) throws Exception {
        Logger.logAction("Check "+ className+" is enabled");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
                    element = ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + className + "\")");
                } else {
                    element = driver.findElementByClassName(className);
                    Logger.logComment(className + " - is displayed and moving forward to next action");
                }
                if (element.isEnabled()) {
                    Logger.logComment( className+" is enabled");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + className);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Verify element is disabled in screen using element name for ios and text attribute for android.
     * @param elementName element name for ios and element text for android.
     * @return status returns true if element enabled else false.
     * @throws Exception
     */
    public static boolean isElementDisabledByName(String elementName) throws Exception {
        Logger.logAction("Check "+ elementName+" is disabled");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                System.out.println(counter + " time trying to find " + elementName);
                if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
                    element = ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + elementName + "\")");
                } else {
                    try{
                        element = driver.findElementByName(elementName);
                        Logger.logComment(elementName + " - is displayed and moving forward to next action");
                    }catch (Exception e){
                        System.out.println(counter + " time trying to find " + elementName);
                    }
                }
                if (!element.isEnabled()) {
                    Logger.logComment( elementName+" is disabled");
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + elementName);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Verify element is disabled in screen using element name for ios and text attribute for android.
     * @param xpath element name for ios and element text for android.
     * @return status returns true if element enabled else false.
     * @throws Exception
     */
    public static boolean isElementEnabledByXpath(String xpath) throws Exception {
        Logger.logAction("Checking "+ xpath+" is enabled");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
//                if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
//                    element = ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + xpath + "\")");
//                } else {
                element = driver.findElement(By.xpath(xpath));
//                }
                if (element.isEnabled()) {
                    Logger.logComment(xpath + " - is displayed and moving forward to next action");
//                    Logger.logComment( xpath+" is enabled");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + xpath);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        Logger.logComment( xpath+" is not enabled in the current active screen");
        return false;
    }

    /**
     * Verify element is displayed in screen using element xpath as parameter.
     * @param elementPath element name.
     * @return status returns true if element displayed else false.
     * @throws Exception
     */
    public static boolean isElementDisplayedByXPath(String elementPath) throws Exception {
        Logger.logAction("Checking the element xpath is displayed or not ? , XPATH :- "+elementPath);
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                WebElement status = driver.findElementByXPath(elementPath);
                if (status.isDisplayed() || status.isEnabled()) {
                    Logger.logComment("Element is displayed and moving to next action");
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementPath);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
            counter++;
        }
        Logger.logComment("Element is not displayed in the current active screen");
        return false;
    }

    /**
     * * This method generates and returns a random number
     * @return int
     */
    public static int generateARandomNumber(int min, int max) {
        Random generator = new Random();
        int randomNumber = generator.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    /**
     * Getting random value from the element size
     * @param size
     * @return
     */
    public static int getTheRandomValue(int size) {
        int randomValue= new Random().nextInt(size);

        return randomValue;
    }

    /**
     * Scrolls  by executing the script using  mobile scroll action.
     * @param elementName Name of the element to scroll to
     */
    public static void scrollTo(String elementName) {

        try {
            Logger.logAction("Scrolling to " + elementName);
            WebElement element = driver.findElementByName(elementName);
            HashMap<String, String> arguments = new HashMap<String, String>();
            arguments.put("name", element.getText());
            driver.executeScript("mobile: scroll", arguments);
        } catch (Exception elementNotFound) {
            fail("Could not find the element " + elementName);
        }
    }

    /**
     * Helper method to scroll up or down to an element.
     * @param id The id of the element.
     * @param up   True if movement of 'finger' is upwards.
     */
    public static void scrollToElementById(String id, boolean up) {
        // large and small steps are values of scrolling length
        double largeStep = 0.325;
        double smallStep = 0.125;
        boolean found = loopScrollToElementById(id, up, largeStep);
        if (!found) {
            found = loopScrollToElementById(id, !up, largeStep);
            if (!found) {
                found = loopScrollToElementById(id, up, smallStep);
                if (!found) {
                    fail("Couldn't scroll " + (up ? "up" : "down") + " to element named " + id);
                }
            }
        }
    }

    /**
     * Helper method to scroll up or down to an element By id, with a particular step size.
     * @param id     The id of the element.
     * @param up       True if movement of 'finger' is upwards.
     * @param stepSize Distance from top and bottom of screen where the gesture will begin/end (percentage of screen)
     * @return True if found.
     */
    private static boolean loopScrollToElementById(String id, boolean up, double stepSize) {
        int counter = 0;
        double topY = stepSize;
        double bottomY = 1 - stepSize;
        String lastPageSource = "";
        String currentPageSource = "";
        while (counter < DEFAULT_SCROLL_ATTEMPTS)
        {
            try {

                if (isElementDisplayedFindById(id)) {
                    return true;
                }

                if (getPlatform().equals(ANDROID_PLATFORM)) {
                    Double startY = up ? topY : bottomY;
                    Double endY = up ? bottomY : topY;
                    swipe(0.5, startY, 0.5, endY, 1.0);
                } else {
                    if (up) {
                        swipeOnElementByClassName("XCUIElementTypeWindow", Labels_Hotels.SwipeDirection.DIRECTION_UP);
                    } else {
                        swipeOnElementByClassName("XCUIElementTypeWindow", Labels_Hotels.SwipeDirection.DIRECTION_DOWN);
                    }
                }

                currentPageSource = driver.getPageSource();
                if (lastPageSource.equals(currentPageSource)) {
                    return false;
                } else {
                    lastPageSource = currentPageSource;
                }

            } catch (Exception e) {
                System.out.println(counter + " time trying to scroll " + (up ? "up" : "down") + " to " + id);
            }
            counter++;
        }

        return false;
    }

    /**
     * Swipe on a element by its class name
     * @param className
     * @param direction
     */
    public static void swipeOnElementByClassName(String className, Labels_Hotels.SwipeDirection direction) {
        try {
            WebElement element = driver.findElementByClassName(className);
            swipeOnElement(element, direction);
        } catch (Exception e) {
            fail("Unable to find element to swipe on: " + className);
        }
    }

    /**
     * Swipe on a element by its name
     * @param elementName
     * @param direction
     */
    public static void swipeOnElementByName(String elementName, Labels_Hotels.SwipeDirection direction) {
        try {
            WebElement element = driver.findElement(By.name(elementName));
            swipeOnElement(element, direction);
        } catch (Exception e) {
            fail("Unable to find element to swipe on: " + elementName);
        }
    }

    /**
     * Helper method to detect if an element is displayed.
     * @param id The id of the element.
     * @return True if displayed.  False if not found.
     */
    public static boolean isElementDisplayedFindById(String id) {
        try {
            List<WebElement> element = driver.findElementsByAccessibilityId(id);
            for(int i=0; i<element.size(); i++) {
                if(element.get(i).isDisplayed()) {
                    return element.get(i).isDisplayed();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Helper method to send a swipe gesture to the screen in appium mode.
     *  @param startX   Starting x-coordinate as a fraction of the total width.
     * @param startY   Starting y-coordinate as a fraction of the total height.
     * @param endX     Ending x-coordinate as a fraction of the total width.
     * @param endY     Ending y-coordinate as a fraction of the total height.
     * @param duration The number of seconds the swipe should take.
     */
    public static void swipe(Double startX, Double startY, Double endX, Double endY, Double duration) {
        // The following was introduced when we switched to use Appium 1.3.3 for Android.
        // To ensure that our "swipe" method is backwards compatible, we are doing some math to translate % into coordinates
        // If the startX is < 1, we assume that we got a screen-percentage which needs to be transformed in to screen-pixels before we can use it
        if (getPlatform().equals(ANDROID_PLATFORM)) {
            if (startX < 1) {
                int screenWidth = driver.manage().window().getSize().getWidth();
                int screenHeight = driver.manage().window().getSize().getHeight();

                startX = startX * screenWidth;
                startY = startY * screenHeight;
                endX = endX * screenWidth;
                endY = endY * screenHeight;
            }
            if (duration <= 1.0) {
                duration = DEFAULT_SWIPE_DURATION_ANDROID;
            }
        }

        driver.swipe(startX.intValue(), startY.intValue(), endX.intValue(), endY.intValue(), duration.intValue());
    }

    /**
     * Method that actually does the swipe/scroll gesture in a given direction
     * It takes the boundaries of the element and 'safe' areas to calculate the coordinates for the gesture
     * relative to the screen. Gesture happens within the element boundaries.
     * @param element     Element that will receive the gesture
     * @param direction   Direction of the swipe, use AutomationLabels.UP/DOWN/LEFT/RIGHT
     * @param marginRatio This is use to calculate the boundaries for the swipe. 0.325 --> end points for gesuture will be (+/-)0.325*WIDTH & (+/1)0.325*HEIGHT of the element specified
     */
    public static void swipeOnElementBy(WebElement element, Labels_Hotels.SwipeDirection direction, double marginRatio) {
        double lowerBoundary = marginRatio;
        double upperBoundary = 1 - lowerBoundary;
        double middleBoundary = 0.5;
        int windowWidth=driver.manage().window().getSize().getWidth();
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();
        int elementOriginX = element.getLocation().getX();
        int elementOriginY = element.getLocation().getY();

        int screenWidth = 1;
        int screenHeight = 1;
        double DEFAULT_SWIPE_DURATION = DEFAULT_SWIPE_DURATION_iOS;

        if (getPlatform().equals(ANDROID_PLATFORM)) {
            DEFAULT_SWIPE_DURATION = DEFAULT_SWIPE_DURATION_ANDROID;
        }

        double startX, startY, endX, endY;

        if (direction == null) {
            startX = startY = endX = endY = 0;
        }
        else {
            switch (direction) {
                case DIRECTION_UP:
                    startX = (elementOriginX + (elementWidth * middleBoundary)) / screenWidth;
                    startY = (elementOriginY + (elementHeight * lowerBoundary)) / screenHeight;
                    endX = startX;
                    endY = (elementOriginY + (elementHeight * upperBoundary)) / screenHeight;
                    break;
                case DIRECTION_DOWN:
                    startX = (elementOriginX + (elementWidth * middleBoundary)) / screenWidth;
                    startY = (elementOriginY + (elementHeight * upperBoundary)) / screenHeight;
                    endX = startX;
                    endY = (elementOriginY + (elementHeight * lowerBoundary)) / screenHeight;
                    break;
                case DIRECTION_LEFT:
                    startX = (elementOriginX + (elementWidth * upperBoundary)) / screenWidth;
                    startY = (elementOriginY + (elementHeight * middleBoundary)) / screenHeight;
                    endX = (elementOriginX + (elementWidth * lowerBoundary)) / screenWidth;
                    endY = startY;
                    break;
                case DIRECTION_RIGHT:
                    startX = (elementOriginX + (elementWidth * lowerBoundary)) / screenWidth;
                    startY = (elementOriginY + (elementHeight * middleBoundary)) / screenHeight;
                    endX = (elementOriginX + (elementWidth * upperBoundary)) / screenWidth;
                    endY = startY;
                    break;
                default:
                    startX = startY = endX = endY = 0;
                    break;

            }

            swipe(startX, startY, endX, endY, DEFAULT_SWIPE_DURATION);
        }


    }

    /**
     * Swipe on element by using element name & direction
     * @param element
     * @param direction
     */
    public static void swipeOnElement(WebElement element, Labels_Hotels.SwipeDirection direction) {
        swipeOnElementBy(element, direction, DEFAULT_SWIPE_MARGIN);
    }

    /**
     * Scroll down the screen by using java script
     */
    public static void scrollDown() {
        Logger.logAction("Scrolling down action is started");
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> arguments = new HashMap<String, String>();
            arguments.put("direction", "down");
            js.executeScript("mobile: scroll", arguments);
        } catch (Exception elementNotFound) {
            fail("Could not scroll down, error is :" +elementNotFound);
        }
    }

    /**
     * Scroll up the screen by using java script
     */
    public static void scrollUp() {
        Logger.logAction("Scrolling up action is started");
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> arguments = new HashMap<String, String>();
            arguments.put("direction", "up");
            js.executeScript("mobile: scroll", arguments);
        } catch (Exception elementNotFound) {
            fail("Could not scroll down, error is :" +elementNotFound);
        }
    }

    /**
     * Scroll to an element by its name
     * @param elementName
     */
    public static  void scrollToAnElement(String elementName) {
        try
        {
            IOSElement element= (IOSElement) driver.findElementByName(elementName);
            new TouchAction(driver).longPress(element).perform();
        }catch (org.openqa.selenium.NoSuchElementException exception){
            Logger.logWarning(elementName+" element not found in the screen");
        }

        if(!withOutIterationCheckIsElementDisplayedByName(elementName)){
            driver.swipe(142,90,145,156,100);
        }
    }

    // TODO: Try to see if the logic can be improved
    // TODO: Check if the element is enabled  in the screen before scrolling
    // Scroll to element by name and direction and verify the elemnet through out the screen
    public static void scrollToAnElementByName(WebElement layoutName, String elementName,boolean down) {
        scrollToAnElement(elementName);
        if(!withOutIterationCheckIsElementDisplayedByName(elementName)) {
            int counter = 0;
            if (down) {
                while (!withOutIterationCheckIsElementDisplayedByName(elementName)) {
                    Logger.logComment(counter + "  time trying to find the element name - " + elementName +" - by scrolling down ");
                    swipeOnElementBasedOnLocation(layoutName,"centerRight","center");
//                    scrollDown();
                    counter++;
                    if (counter > 15) {
                        break;
                    }
                }
                if (!withOutIterationCheckIsElementDisplayedByName(elementName)) {
                    while (!withOutIterationCheckIsElementDisplayedByName(elementName)) {
                        Logger.logComment(counter + "  time trying to find the element name - " + elementName +" - by scrolling up ");
                        swipeOnElementBasedOnLocation(layoutName,"bottomCenter","bottomLeft");
//                        scrollUp();
                        counter++;
                        if (counter > 17) {
                            break;
                        }
                    }
                }
            } else {
                while (!withOutIterationCheckIsElementDisplayedByName(elementName)) {
                    Logger.logComment(counter + "  time trying to find the element name - " + elementName +" - by scrolling up ");
//                    scrollUp();
                    swipeOnElementBasedOnLocation(layoutName,"bottomCenter","bottomLeft");
                    counter++;
                    if (counter > 10) {
                        break;
                    }
                }
                if (!withOutIterationCheckIsElementDisplayedByName(elementName)) {
                    Logger.logComment(counter + "  time trying to find the element name - " + elementName +" - by scrolling up ");
                    while (!withOutIterationCheckIsElementDisplayedByName(elementName)) {
//                        scrollDown();
                        swipeOnElementBasedOnLocation(layoutName,"centerRight","center");
                        counter++;
                        if (counter > 17) {
                            break;
                        }
                    }
                }
            }
        }
    }

    // TODO: Try to see if the logic can be improved
    // TODO: Check if the element is enabled  in the screen before scrolling
    // Scroll to element by name and direction and verify the element through out the screen
    public static void scrollToAnElementByXPath(String xPath,boolean down) {
        Logger.logAction("Scrolling to the xpath :- " +xPath);
//        scrollToAnElement(xPath,down);
        if(!withOutIterationCheckIsElementVisibleByXpath(xPath)) {
            int counter = 0;
            if (down) {
                while (!withOutIterationCheckIsElementVisibleByXpath(xPath)) {
                    Logger.logComment(counter + "  time trying to find the XPath - " + xPath +" - by scrolling down ");
                    scrollDown();
                    counter++;
                    if (counter > 5) {
                        break;
                    }
                }
                if (!withOutIterationCheckIsElementVisibleByXpath(xPath)) {
                    while (!withOutIterationCheckIsElementVisibleByXpath(xPath)) {
                        Logger.logComment(counter + "  time trying to find the XPath - " + xPath +" - by scrolling up ");
                        scrollUp();
                        counter++;
                        if (counter > 10) {
                            break;
                        }
                    }
                }
            } else {
                while (!withOutIterationCheckIsElementVisibleByXpath(xPath)) {
                    Logger.logComment(counter + "  time trying to find the XPath - " + xPath +" - by scrolling up ");
                    scrollUp();
                    counter++;
                    if (counter > 5) {
                        break;
                    }
                }
                if (!withOutIterationCheckIsElementVisibleByXpath(xPath)) {
                    Logger.logComment(counter + "  time trying to find the XPath - " + xPath +" - by scrolling down ");
                    while (!withOutIterationCheckIsElementVisibleByXpath(xPath)) {
                        scrollDown();
                        counter++;
                        if (counter > 10) {
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets the element value by taking its xpath as a parameter
     * @param elementXpath Xpath of the element
     * @return String elementValue
     * @throws Exception
     */
    public static String getElementValueByXpath(String elementXpath) throws Exception {
        String elementValue = null;
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            counter++;
            try {
                elementValue = driver.findElement(By.xpath(elementXpath)).getAttribute("value");
                break;
            } catch (Exception exceptionDetail) {
                Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            }
        }
        if(counter>= Labels_Hotels.MIN_ATTEMPTS){
            fail("Element could not be found, xpath is not present or invalid");
        }
        return elementValue;
    }

    /**
     * Scroll on element by Xpath
     * @param xpath
     * @param direction
     */
    public void scrollOnElementByXpath(String xpath, String direction){
        JavascriptExecutor js = driver;
        WebElement element = new IOSElement();
        try {
            element = driver.findElementByXPath(xpath);
        }catch (org.openqa.selenium.NoSuchElementException exception){
        }
        HashMap<String, String> scrollMap = new HashMap<String, String>();
        scrollMap.put("element", ((RemoteWebElement) element).getId());
        scrollMap.put("direction", direction);
        js.executeScript("mobile: scroll", scrollMap);
    }

    /**
     * Used to send text to the element
     * @param element element on to which the text field is sent to
     * @param message      text which has to enter in text field
     * @return boolean true if entered successfully
     * @throws Exception
     */
    public static boolean sendTextToElement(WebElement element, String message) throws Exception {
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                boolean status = element.isDisplayed();
                if (status) {
                    element.clear();
                    element.sendKeys(message);
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find the element to enter text" );
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Tap on Element Based on coordinates of the element
     * @param Element
     * @param staringPoint here we assume topLeft,centerLeft,bottomLeft,topCenter,center,BottomCenter,topRight,centerRight,bottomRight are the staring points to swipe
     * @param endingPoint here we assume topLeft,centerLeft,bottomLeft,topCenter,center,BottomCenter,topRight,centerRight,bottomRight are the staring points to swipe
     */
    public static void swipeOnElementBasedOnLocation(WebElement Element, final String staringPoint, final String endingPoint) {
        Logger.logAction("Scrolling to an element based on its location");
        int[] arrayListOfStartingPointLocationXAndY;
        int[] arrayListOfEndingPointLocationXAndY;

        try {
            arrayListOfStartingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(Element, staringPoint);
            arrayListOfEndingPointLocationXAndY = getCoOrdinatesForPreciseTapOnElement(Element, endingPoint);
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],Labels_Hotels.TAP_DURATION_MAX);
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],500);
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],600);
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],700);
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],800);
            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1], Labels_Hotels.CALENDAR_SWIPE_DURATION); // fine in iPhone 5S
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],300); // fine in iPhone 7
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],200); // fine in iPhone X
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],100);
//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],900);

//            driver.swipe(arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1],arrayListOfEndingPointLocationXAndY[0], arrayListOfEndingPointLocationXAndY[1],Labels_Hotels.TAP_DURATION_MIN);

//            driver.tap(Labels_Hotels.DEFAULT_FINGER_FOR_TAP, arrayListOfStartingPointLocationXAndY[0], arrayListOfStartingPointLocationXAndY[1], Labels_Hotels.DEFAULT_TAP_DURATION);
        } catch (Exception e) {
            fail("Couldn't find element with name " + Element);
        }
    }

    /**
     * Tap on Element Based on coordinates of the element
     * @param Element
     * @param Direction here we assume topLeft,centerLeft,bottomLeft,topCenter,center,BottomCenter,topRight,centerRight,bottomRight are the directions
     */
    public static void tapOnElementBasedOnLocation(WebElement Element, final String Direction) {
        int[] arrayListLocationXAndY;
        try {
            arrayListLocationXAndY = getCoOrdinatesForPreciseTapOnElement(Element, Direction);
            driver.tap(Labels_Hotels.DEFAULT_FINGER_FOR_TAP, arrayListLocationXAndY[0], arrayListLocationXAndY[1], Labels_Hotels.DEFAULT_TAP_DURATION);
        } catch (Exception e) {
            fail("Couldn't find element with name " + Element);
        }
    }

    /**
     * Generic method gets the coordinate for the precise tap on the element (When Device Orientation Is In Landscape Mode)
     * @param Element   the element to be tapped on using the coordinates
     * @param Direction here we assume topLeft,centerLeft,bottomLeft,topCenter,center,BottomCenter,topRight,centerRight,bottomRight are the directions
     * @return The co_ordinates of the element is returnedWebElement Element, final String Direction
     */
    public static int[] getCoOrdinatesForPreciseTapOnElement(WebElement Element, final String Direction) {
        Point table = Element.getLocation();
        int xAxisValue = table.getX();
        int yAxisValue = table.getY();
        Dimension table_size = Element.getSize();
        int xAxisSize = table_size.getWidth();
        int yAxisSize = table_size.getHeight();
        final int arrayOfCo_Ordinates[] = new int[2];
        switch (Direction) {
            case "topLeft":
                int LeftTopXValue = (int) ((xAxisSize * 0.3) + xAxisValue);
                int LeftTopYValue = (int) ((yAxisSize * 0.3) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + LeftTopXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + LeftTopYValue) / 2;
                break;
            case "centerLeft":
                int LeftCenterXValue = (int) ((xAxisSize * 0.5) + xAxisValue);
                int LeftCenterYValue = (int) ((yAxisSize * 0.3) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + LeftCenterXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + LeftCenterYValue) / 2;
                break;
            case "bottomLeft":
                int LeftBottomXValue = (int) ((xAxisSize * 0.2) + xAxisValue);
                int LeftBottomYValue = (int) ((yAxisSize * 1.8) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + LeftBottomXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + LeftBottomYValue) / 2;
                break;
            case "topCenter":
                int CenterTopXValue = (int) ((xAxisSize * 0.65) + xAxisValue);
                int CenterTopYValue = (int) ((yAxisSize * 0.75) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + CenterTopXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + CenterTopYValue) / 2;
                break;
            case "center":
                int CenterXValue = (int) ((xAxisSize * 0.5) + xAxisValue);
                int CenterYValue = (int) ((yAxisSize * 0.5) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + CenterXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + CenterYValue) / 2;
                arrayOfCo_Ordinates[0] = (xAxisSize) / 2;
                arrayOfCo_Ordinates[1] = (int) ((yAxisSize / 2)*1.2);

                break;
            case "bottomCenter":
                int CenterBottomXValue = (int) ((xAxisSize * 0.7) + xAxisValue);
                int CenterBottomYValue = (int) ((yAxisSize * 0.5) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + CenterBottomXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + CenterBottomYValue) / 2;
                break;
            case "topRight":
                int RightTopXValue = (int) ((xAxisSize * 0.7) + xAxisValue);
                int RightTopYValue = (int) ((yAxisSize * 0.3) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + RightTopXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + RightTopYValue) / 2;
                break;
            case "centerRight":
                int RightCenterXValue = (int) ((xAxisSize * 0.5) + xAxisValue);
                int RightCenterYValue = (int) ((yAxisSize * 0.7) + yAxisValue);
                arrayOfCo_Ordinates[0] = (xAxisValue + RightCenterXValue) / 2;
                arrayOfCo_Ordinates[1] = (yAxisValue + RightCenterYValue) / 2;
                break;
            case "bottomRight":
                int RightBottomXValue = (int) ((xAxisSize * 0.95) + xAxisValue);
                int RightBottomYValue = (int) ((yAxisSize * 0.85) + yAxisValue);
                arrayOfCo_Ordinates[0] = RightBottomXValue;
                arrayOfCo_Ordinates[1] = RightBottomYValue;
                break;
            default:
                Logger.logWarning("Could not get the coordinates of the element");
        }
        return arrayOfCo_Ordinates;
    }

    /**
     * Gets the element value by taking its class name as a parameter
     * @param className Classname of the element
     * @return String elementValue
     */
    public static String getElementValueByClass(String className) {
        String elementValue = null;
        try {
            elementValue = driver.findElement(By.className(className)).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
        } catch (Exception exceptionDetail) {
            fail(exceptionDetail.toString());
        }
        return elementValue;
    }

    /**
     * Gets the element value by taking its name name as a parameter
     * @param name name of the element
     * @return String elementValue
     */
    public static String getElementValueByName(String name) {
        String elementValue = null;
        try {
            elementValue = driver.findElement(By.name(name)).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
        } catch (Exception exceptionDetail) {
            fail(exceptionDetail.toString());
        }
        return elementValue;
    }

    /**
     * Gets the element value
     * @param element whose value is to be returned
     * @return String elementValue
     */
    public static String getElementValue(WebElement element) {
        String elementValue = null;
        try {
            elementValue = element.getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
        } catch (Exception exceptionDetail) {
            fail(exceptionDetail.toString());
        }
        return elementValue;
    }

    /**
     * Tap on element using element xpath as parameter.
     * @param XPath element class name.
     * @return status returns true if element is tapped else false.
     */
    public static boolean findElementByXPathAndClick(String XPath) {
        Logger.logAction("Finding the element by xpath and tapping on it (if displayed), XPath:- " +XPath);
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                WebElement element = driver.findElementByXPath(XPath);
                if (element.isDisplayed() || element.isEnabled()) {
                    Logger.logComment("Element is displayed on and going to tap on it");
                    element.click();
                    Logger.logComment("Tapped on the element by xpath :- "+XPath);
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find the xpath :- " + XPath);
            }
            counter++;
        }
        fail("Couldn't find element by xpath :- " + XPath);
        return false;
    }

    /**
     * Verify tapping element using WebElement as parameter.
     * @param element element WebElement.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean findWebElementAndClick(WebElement element) throws Exception {
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                if (element.isDisplayed()) {
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + element);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return false;
    }

    /**
     * Verify element is displayed in screen using Web element
     * @param element element WebElement.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean isWebElementDisplayed(WebElement element) throws Exception {
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(counter + " time trying to find " + element);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return false;
    }

    /**
     * Verify element is displayed in screen using element name for ios and text attribute for android with out reattempting the check .
     * @param elementName element name for ios and element text for android.
     * @return status returns true if element displayed else false.
     */
    public static boolean withOutIterationCheckIsElementDisplayedByName(String elementName) {
        Logger.logAction("Checking - "+ elementName+" - element is displayed");
        int counter = 0;
        WebElement element = null;
        try {
            if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
                element = ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + elementName + "\")");
            } else {
                element = driver.findElementByName(elementName);
            }
            if (element.isDisplayed()) {
                Logger.logComment(elementName + " - element name is displayed and moving to next test step");
                return true;
            }
        } catch (Exception e) {
            Logger.logWarning(elementName + " - element name is not displayed in the current active screen");
            return false;
        }
        Logger.logWarning(elementName + " - element name is not displayed in the current active screen");
        return false;
    }

    /**
     * Verify element is displayed in screen using element xpath for ios
     * @param xpath element xpath
     * @return status returns true if element displayed else false.
     */
    public static boolean withOutIterationCheckIsElementDisplayedByXpath(String xpath) {
        Logger.logAction("Checking - "+ xpath+" - is displayed.");
        int counter = 0;
        WebElement element = null;
        try {
            if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
                element = ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + xpath + "\")");
            } else {
                element = driver.findElementByXPath(xpath);
            }
            if (element.isDisplayed()) {
                Logger.logComment(xpath + " - XPath is displayed and moving to next test step");
                return true;
            }
        } catch (Exception e) {
            Logger.logWarning(xpath + " - XPath is not displayed in the current active screen");
            return false;
        }
        Logger.logWarning(xpath + " - XPath is not displayed in the current active screen");
        return false;
    }

    /**
     * Verify element is enabled in  screen using element xpath
     * @param xpath element xpath
     * @return status returns true if element displayed else false.
     */
    public static boolean withOutIterationCheckIsElementVisibleByXpath(String xpath) {
        Logger.logAction("Checking "+ xpath+" is displayed or not ?");
        int counter = 0;
        WebElement element = null;
        String elementVisibility = null;
        try {
//            if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
//                element = ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + xpath + "\")");
//            } else {
            element = driver.findElementByXPath(xpath);
            elementVisibility = element.getAttribute(Labels_Hotels.VISIBLE_ATTRIBUTE);
//            }
            if (elementVisibility.equals("true")) {
                Logger.logComment(xpath + " - XPath is displayed, visible and moving to next test step");
                return true;
            }
        } catch (Exception e) {
            Logger.logWarning(xpath + " - XPath is not visible in the current active screen");
            return false;
        }
        Logger.logWarning(xpath + " - XPath is not visible in the current active screen");
        return false;
    }

    /**
     * Verify element is displayed in screen using element name for ios and text attribute for android with out reattempting the check .
     * @param elementName element name for ios and element text for android.
     * @return status returns true if element displayed else false.
     */
    public static boolean withOutIterationCheckIsElementEnabledByName(String elementName) {
        Logger.logAction("Check "+ elementName+" is displayed.");
        WebElement element = null;
        try {
            if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
                element = ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + elementName + "\")");
            } else {
                element = driver.findElementByName(elementName);
            }
            if (element.isEnabled()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Changes orientation to specified orientation which is sent as parameter orientation and asserts change orientation is done successfully
     * @Parm orientation that user wants to change, should be either PORTRAIT or LANDSCAPE
     */
    public static void changeOrientation(String orientation) {
        Logger.logAction("Change orientation to" + orientation);
        try {
            if (orientation.equalsIgnoreCase("PORTRAIT")) {
                driver.rotate(ScreenOrientation.PORTRAIT);
                assertTrue("Portrait mode should be displayed", getScreenOrientation().equalsIgnoreCase("PORTRAIT"));
            } else if (orientation.equalsIgnoreCase("LANDSCAPE")) {
                driver.rotate(ScreenOrientation.LANDSCAPE);
                assertTrue("Landscape mode should be displayed", getScreenOrientation().equalsIgnoreCase("LANDSCAPE"));
            }
        } catch (Exception orientationNotFound) {
            fail("Failed to change the device orientation");
        }
    }

    /**
     * Get the Screen orientation
     * For Android tablets get orientaion method returns landscape after rotating the device to landscape orientaion even thought the application is in portrait mode hence using the screen size to get the orientation
     * For ios also having the same issue as in android tablets, so using java executescript to execute instruments code
     * @param //orientation
     * @return
     */
    public static String getScreenOrientation() {
        try {
            if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
                int screenWidth = driver.manage().window().getSize().getWidth();
                int screenHeight = driver.manage().window().getSize().getHeight();
                String ScreenOrientation;
                if (screenHeight > screenWidth) {
                    ScreenOrientation = "Portrait";
                } else {
                    ScreenOrientation = "Landscape";
                }
                return ScreenOrientation;
            } else if (Labels_Hotels.platform.equals(Labels_Hotels.IOS)) {
                return String.valueOf(driver.getOrientation());
            }
        } catch (Exception exceptionDetail) {
            fail("Failed to get the screen orientation.");
        }
        return "unknown";
    }

    /**
     * Check the screen orientation is possible to change to Landscape/Portrait mode
     * @param orientation
     */
    public static  void checkCanNotChangeTheDeviceOrientation(String orientation) {
        Logger.logAction("Checking can not change the device orientation to "+orientation);
        try {
            if (orientation.equalsIgnoreCase("PORTRAIT")) {
                driver.rotate(ScreenOrientation.PORTRAIT);
            }
            else if (orientation.equalsIgnoreCase("LANDSCAPE")) {
                driver.rotate(ScreenOrientation.LANDSCAPE);
            }
            fail("Changed the device orientation to "+orientation);
        } catch (Exception orientationNotFound) {
            System.out.println("Screen could not change the orientation to "+orientation);

        }

    }

    /**
     * * This method verifies that the key board is displayed or not
     */
    public static boolean isKeyboardDisplayed() {
        try {
            if(Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
//                boolean status = driver.getKeyboard().equals("true");
                String deviceId = getAndroidDeviceId();
                String commandToEnableLocation = "adb -s " + deviceId + " shell dumpsys input_method | grep mInputShown";
                String commandToCheckKeyBoardIsDisplayed[] = General.createArrayOfWordFromString(commandToEnableLocation);
                String terminalOutput = General.executeTerminalCommandArray(commandToCheckKeyBoardIsDisplayed);
                return terminalOutput.contains("mInputShown=true");
//                return status;
            }
            else if(Labels_Hotels.platform.equals(Labels_Hotels.IOS)) {
                try {
                    boolean status = driver.findElementByClassName(Labels_Hotels.UIA_KEYBOARD).isDisplayed();
                    return status;
                } catch (Exception elementNotFound) {
                    Logger.logComment("elementNotFound - Exception happened in isKeyboardDisplayed method");
                    return false;
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the keyboard status");
        }
        return false;
    }

    /**
     * * This method verifies that the date picker is displayed or not
     */
    public static boolean isDatePickerDisplayed() throws Exception {
        Logger.logAction("Checking the date picker is displayed or not ?");
        if(Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)) {
            // ANDROID_DATE_PICKER : value and this method is changes based on the name given by the app developer to the displaying calender view in the app
            return isElementDisplayedById(ANDROID_DATE_PICKER);
            // Generic method to test the date picker is displayed or not . If app calendar view is customised then needs to write an customized method to check the calendar view is displayed or not, like above (For Example) method
//            String deviceId = getAndroidDeviceId();
//            String commandToEnableLocation = "adb -s " + deviceId + " shell dumpsys input_method | grep mInputShown";
//            String commandToCheckKeyBoardIsDisplayed[] = General.createArrayOfWordFromString(commandToEnableLocation);
//            String terminalOutput = General.executeTerminalCommandArray(commandToCheckKeyBoardIsDisplayed);
//            return terminalOutput.contains("mInputShown=true");
        }
        else if(Labels_Hotels.platform.equals(Labels_Hotels.IOS)) {
            try {
                boolean status = driver.findElementByClassName(Labels_Hotels.UIA_DATEPICKER).isDisplayed();
                Logger.logStep("Date Picker is displayed and moving to next step");
                return status;
            } catch (Exception elementNotFound) {
                return false;
            }
        }
        return false;
    }

    /**
     * This method gets the android device id
     * @return device Id
     */
    public static String getAndroidDeviceId() {
        if (Labels_Hotels.platform.equals("Android")) {
            Capabilities capabilities = driver.getCapabilities();
            String deviceId = (String) capabilities.getCapability("deviceName");
            return deviceId;
        } else {
            Logger.logWarning("Not an android device");
            return null;
        }
    }

    /**
     * Used to send text to text field using element id
     * @param elementId text field element id
     * @param message   text which has to enter in text field
     * @return boolean
     * @throws Exception
     */
    public static boolean sendTextById(String elementId, String message) throws Exception {
        int counter = 0;
        WebElement element;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                WebElement status = driver.findElementById(elementId);
                if (status.isEnabled()) {
                    element = driver.findElementById(elementId);
//                    element.clear();
                    Logger.logComment("Sending the keys:- "+message);
                    element.sendKeys(message);
                    Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementId);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        fail(counter+" - times tried, unable to parse the keys :- "+message);
        return false;
    }

    /**
     * Used to send text to text field using element name
     * @param elementName text field element id
     * @param message   text which has to enter in text field
     * @return boolean
     * @throws Exception
     */
    public static boolean sendTextByName(String elementName, String message) throws Exception {
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                boolean status = driver.findElement(By.id(elementName)).isDisplayed();
                if (status) {
                    driver.findElement(By.name(elementName)).clear();
                    driver.findElement(By.name(elementName)).sendKeys(message);
                    return true;
                }
            } catch (Exception e) {
                Logger.logWarning(counter + " time trying to find " + elementName);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Used to send text to text field using element class name
     * @param elementClass text field element class name
     * @param message      text which has to enter in text field
     * @return boolean
     * @throws Exception
     */
    public static boolean sendTextByClass(String elementClass, String message) throws Exception {
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                boolean status = driver.findElement(By.className(elementClass)).isDisplayed();
                if (status) {
                    driver.findElement(By.className(elementClass)).clear();
                    driver.findElement(By.className(elementClass)).sendKeys(message);
                    return true;
                }
            } catch (Exception e) {
                Logger.logWarning(counter + " time trying to find " + elementClass);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        return false;
    }

    /**
     * Used to send text to a text field using element xpath
     * @param elementXpath text field element xpath
     * @param message      text which has to enter in text field
     * @return boolean
     * @throws Exception
     */
    public static boolean sendTextByXpath(String elementXpath, String message, boolean clearExistingTextBeforeParsing) throws Exception {
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                WebElement element = driver.findElementByXPath(elementXpath);
                if (element.isEnabled()) {
                    if (clearExistingTextBeforeParsing == true){
                        element.clear();
                    }
                    Logger.logComment("Sending the keys:- "+message);
                    element.sendKeys(message);
                    Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                    return true;
                }
            } catch (Exception e) {
                Logger.logWarning(counter + " time trying to find " + elementXpath);
            }
            Thread.sleep(Labels_Hotels.WAIT_TIME_DEFAULT);
            counter++;
        }
        fail(counter+" - times tried, unable to parse the keys :- "+message);
        return false;
    }

    /**
     * Verify tapping element using element name as parameter.
     * @param elementName element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean findElementByNameAndClick(String elementName) throws Exception {
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementByName(elementName);
                if (element.isEnabled()){
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        fail("Unable to find the element by name and click on it :- "+elementName);
        return false;
    }

    /**
     * Verify tapping element using element id as parameter.
     * @param elementId element id.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean findElementByIdAndClick(String elementId) throws Exception {
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementById(elementId);
                if (element.isEnabled()){
                    Thread.sleep(1000);
//                    driver.tap(1,element,Labels_Hotels.DEFAULT_FINGER_FOR_TAP); // Todo:- Check the click functionality with tap
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementId);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return false;
    }
    /**
     * Return element text using element accessibility id as parameter.
     * @param elementId element class name.
     * @param attributeType is the tye of the attribute of parsing element
     * @return status returns true if element is having parsing attribute else false.
     * @throws Exception
     */
    public static String findElementByAccessibilityIdAndReturnText(String elementId, String attributeType) throws Exception {
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementByAccessibilityId(elementId);
                if (!element.getText().isEmpty()){
                    return element.getAttribute(attributeType);
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementId);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return null;
    }

    /**
     * Verify tapping element using element accessibility as parameter.
     * @param elementAccessibility element accessibility.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static boolean findElementByAccessibilityIdAndClick(String elementAccessibility) throws Exception {
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementByAccessibilityId(elementAccessibility);
                if (element.isEnabled()){
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementAccessibility);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return false;
    }

    /**
     * Verify tapping element using element name as parameter.
     * @param elementId element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static String findElementByIdAndReturnText(String elementId) throws Exception {
        int counter = 0;
        WebElement element = null;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                element = driver.findElementById(elementId);
                if (!element.getText().isEmpty()){
                    return element.getText();
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementId);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return null;
    }

    /**
     * Verify tapping element using element name as parameter.
     * @param elementName element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static String findElementByXpathAndReturnItsAttributeValue(String elementName) throws Exception {
        int counter = 0;
        String elementValue = Labels_Hotels.STRING_NULL;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                elementValue = driver.findElementByXPath(elementName).getAttribute(Labels_Hotels.VALUE_ATTRIBUTE);
                if (!elementName.isEmpty()){
                    return elementValue;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return elementValue;
    }
    /**
     * Verify finding element using element xpath as parameter and returning its text attribute.
     * @param elementName element class name.
     * @return status returns true if element is found else false.
     * @throws Exception
     */
    public static String findElementByXpathAndReturnItsAttributeText(String elementName) throws Exception {
        Logger.logAction("Finding the "+elementName+" element name and returning its value");
        int counter = 0;
        String elementValue = Labels_Hotels.STRING_NULL;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                elementValue = driver.findElementByXPath(elementName).getText();
                if (!elementValue.isEmpty()){
                    return elementValue;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return elementValue;
    }

    /**
     * Verify finding element using element xpath as parameter and returning its name attribute.
     * @param elementName element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static String findElementByXpathAndReturnItsAttributeName(String elementName) throws Exception {
        Logger.logAction("Finding the "+elementName+" element name and returning its name");
        int counter = 0;
        String elementValue = Labels_Hotels.STRING_NULL;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                elementValue = driver.findElementByXPath(elementName).getAttribute(Labels_Hotels.NAME_ATTRIBUTE);
                if (!elementValue.isEmpty()){
                    return elementValue;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return elementValue;
    }

    /**
     * Verify finding element using element xpath as parameter and returning its selected attribute.
     * @param elementName element class name.
     * @return status returns true if element is tapped else false.
     * @throws Exception
     */
    public static String findElementByXpathAndReturnItsAttributeSelected(String elementName) throws Exception {
        Logger.logAction("Finding the "+elementName+" element name and returning its selecting attribute");
        int counter = 0;
        String elementValue = Labels_Hotels.STRING_NULL;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                elementValue = driver.findElementByXPath(elementName).getAttribute(Labels_Hotels.SELECTED_ATTRIBUTE);
                if (!elementValue.isEmpty()){
                    return elementValue;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementName);
            }
            counter++;
            Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
        }
        return elementValue;
    }

    /**
     * Verify tapping element using element class name as parameter.
     * For iOS click operation scrolls the element till its displayed and then performs the action this is not the same for android.
     * Hence for android we are making a check if the element is displayed before performing the click operation
     * @param elementClassName element class name.
     * @return status returns true if element is tapped else false.
     */
    public static boolean findElementByClassNameAndClick(String elementClassName) {
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                WebElement element = driver.findElementByClassName(elementClassName);
                if (element.isDisplayed()) {
                    element.click();
                    return true;
                }
            } catch (Exception e) {
                Logger.logComment(counter + " time trying to find " + elementClassName);
            }
            counter++;
        }
        return false;
    }

    /**
     * This method taps on the element by using name
     * @return void
     * @throws Exception
     */
    public static boolean selectElementByName(String elementName) {
        try
        {
            if (isElementDisplayedByName(elementName)){
                driver.findElementByName(elementName).click();
                return true;
            }else{
                System.out.println(elementName + " is not displayed in the current active screen");
                return false;
            }
        }
        catch (Exception elementNotFound)
        {
            return false;
        }
    }

    /**
     * This method taps on the element by using Class name
     * @return void
     * @throws Exception
     */
    public static boolean selectElementByClassName(String elementName) {
        try
        {
            if (isElementDisplayedByClassName(elementName)){
                driver.findElementByClassName(elementName).click();
                return true;
            }else{
                System.out.println(elementName + " is not enabled in the current active screen");
                return false;
            }
        }
        catch (Exception elementNotFound)
        {
            return false;
        }
    }

    /**
     * This method taps on the element by using xpath
     * @param XPath
     * @return
     */
    public static boolean selectElementByXPath(String XPath) {
        try {
            if (isElementDisplayedByXPath(XPath)){
                driver.findElementByXPath(XPath).click();
                return true;
            }else{
                System.out.println("Element is dispalyed in the given XPath" + "Xpath: " +XPath);
                return false;
            }

        } catch (Exception elementNotFound) {
            return false;
        }
    }

    /**
     * Verifies  the element name is not displayed in the screen
     * @param elementName
     * @return
     */
    public static boolean isElementNotDisplayedByName(String elementName) {
        Logger.logAction("Is " + elementName + " element not displayed");
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                if (driver.findElement(By.name(elementName)).isDisplayed()) {
                    Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                    counter++;
                } else {
                    return true;
                }
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifies  the element name is not displayed in the screen
     * @param elementName
     * @return
     */
    public static boolean isElementNotDisplayedByClassName(String elementName) {
        Logger.logAction("Is " + elementName + " element not displayed");
        int counter = 0;
        while (counter < Labels_Hotels.MIN_ATTEMPTS) {
            try {
                if (driver.findElement(By.className(elementName)).isDisplayed()) {
                    Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                    counter++;
                } else {
                    return true;
                }
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a hash map of device type and UDID for all the connected ios device. This method runs the system_profiler SPUSBDataType command in terminal
     * @return HashMap<String, List> HashMap of Device Type and its UDID
     * @throws Exception
     */
    public static HashMap<String, List> getConnectedIosDevice() throws Exception {
        String commandToListUSBConnectedDevices[] = General.createArrayOfWordFromString(Labels_Hotels.TERMINAL_COMMAND_LIST_CONNECTED_USB_DEVICE);
        BufferedReader bufReader = new BufferedReader(new StringReader(General.executeTerminalCommandArray(commandToListUSBConnectedDevices)));
        String line = null;
        List ipadUdidList = new ArrayList();
        List ipodUdidList = new ArrayList();
        List iphoneUdidList = new ArrayList();
        HashMap<String, List> connectedIosDeviceUdid = new HashMap<>();
        while ((line = bufReader.readLine()) != null) {
            if (line.trim().equals("iPad:")) {
                while ((line = bufReader.readLine()) != null) {
                    if (line.contains("Serial Number: ")) {
                        String udid = line.trim().split("Serial Number: ")[1];
                        ipadUdidList.add(udid);
                        break;
                    }
                }
            }
            if (line.trim().equals("iPod:")) {
                while ((line = bufReader.readLine()) != null) {
                    if (line.contains("Serial Number: ")) {
                        String udid = line.trim().split("Serial Number: ")[1];
                        ipodUdidList.add(udid);
                        break;
                    }
                }
            }

            if (line.trim().equals("iPhone:")) {
                while ((line = bufReader.readLine()) != null) {
                    if (line.contains("Serial Number: ")) {
                        String udid = line.trim().split("Serial Number: ")[1];
                        iphoneUdidList.add(udid);
                        break;
                    }
                }
            }
        }
        connectedIosDeviceUdid.put("iPhone", iphoneUdidList);
        connectedIosDeviceUdid.put("iPad", ipadUdidList);
        connectedIosDeviceUdid.put("iPod", ipodUdidList);
        return connectedIosDeviceUdid;
    }

    /**
     * Returns iOS device type
     * @return String Device Type [iPad, iPod, iPhone]
     * @throws Exception
     */
    public static String getIosDeviceType() throws Exception {
        String deviceType=null;
        HashMap<String, List> connectedIosDeviceUdid = getConnectedIosDevice();
        for (Map.Entry<String, List> entry : connectedIosDeviceUdid.entrySet()) {
            if (entry.getValue().contains(driver.getCapabilities().getCapability("udid"))) {
                deviceType= entry.getKey();
            }
        }
        assertTrue("Not able to get the device type",deviceType!=null);
        return deviceType;
    }

    /**
     * Re install the app as part of the execution
     */
    public static void reInstallApp() {
        unInstallApp();
        installApp();
    }

    /**
     * Run the app in background
     */
    public static void runAppInBackground( int timeLimit){
        Logger.logAction("Pushing the app to background");
        if (Labels_Hotels.platform.equals(IOS)){
            driver.runAppInBackground(timeLimit);
            Logger.logComment("App is suspended to background for time limit of " + timeLimit + " second(s)");
        }else if (Labels_Hotels.platform.equals(ANDROID)){
            driver.runAppInBackground(timeLimit);
            Logger.logComment("App is suspended to background for time limit of " + timeLimit + " second(s)");
        } else{
            Logger.logError("Platform of the connected device is neither Android or iOS");
        }
    }

    /**
     * Check the app installation as part of the execution
     *
     */
    public static void checkAppInstallation(String platform) {
        if (platform.equals(Labels_Hotels.ANDROID)){
            Logger.logWarning("Yet to implement this method in Andorid");
        }else if (platform.equals(Labels_Hotels.IOS)){
            reInstallApp();
        }else {
            Logger.logError("unable to check the app installation");
        }
    }

    /**
     * Clearing the keys using keycode (Only for android platforms)
     * @param elementId
     * @param tapCounts
     */
    public static void clearKeysByUsingKeycode(String elementId, Integer tapCounts) {
        Logger.logAction("Clearing the keys by using keycode");
        try {
            if (Labels_Hotels.platform.equals(Labels_Hotels.ANDROID)){
                WebElement element = driver.findElementById(elementId);
                tapOnElementBasedOnLocation(element,"bottomRight");
                for (int count=0; tapCounts>=count; count++){
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACKSPACE);
                }
            }else if (Labels_Hotels.platform.equals(Labels_Hotels.IOS)){
                Logger.logError("Key code usage is only for android platforms not for iOS platforms");
            }else {
                Logger.logError("Key code usage is only for android platforms not for any other platforms");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to clear the keys using keycode process");
        }
    }

    /**
     * Wait till the element (name) is invisible
     * @throws Exception
     */
    public static void waitForAnElementToDisappear_ByName(String parsingName, Integer parsingIterationsCount) throws Exception{
        int count =0;
        while (count < parsingIterationsCount){
            try{
                if (isElementDisplayedByName(parsingName)){
                    Logger.logStep("Waiting till the "+parsingName+" is invisible in the current active screen");
                    driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(parsingName)));
                }else {
                    Logger.logComment(parsingName+" is not displayed in the current active screen");
                    break;
                }
            }catch (Exception exception){
                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                Logger.logComment(count+" :- time trying to find the element name");
            }
            count++;
        }
    }

    /**
     * Wait till the element (id) is invisible
     * @throws Exception
     */
    public static void waitForAnElementToDisappear_ById(String parsingId) throws Exception{
        int count =1;
        while (count < Labels_Hotels.MIN_ATTEMPTS){
            try{
                if (isElementDisplayedById(parsingId)){
                    Logger.logStep("Waiting till the "+parsingId+" is invisible in the current active screen");
                    driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(parsingId)));
                }else {
                    Logger.logComment(parsingId+" is not displayed in the current active screen");
                }
            }catch (Exception exception){
                Thread.sleep(Labels_Hotels.WAIT_TIME_MIN);
                Logger.logComment(count+" :- time trying to find the element name");
            }
            count++;
        }
    }

}


