package com.automation.rehlat.flights.tests.sanityTests;


import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.libCommon.Logger;
import com.automation.rehlat.flights.pages.BasePage;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class SampleTestCase extends BaseTest {
    @Test
    public void testSampleTestCase() {
        Logger.beginTest("Test Sample Test Case Is Started");
        driver.navigate().back();
        driver.navigate().back();
        driver.swipe(507,450,507,850, Labels_Flights.SWIPE_DURATION_MIN);
        try{
            Thread.sleep(4000);
            String appIconName = findElementByXpathAndReturnItsAttributeText("//android.widget.FrameLayout[@content-desc=\"Xperia™ Home\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.TextView");
            if (appIconName.equalsIgnoreCase("Messenger")){
                findElementByXPathAndClick("//android.widget.FrameLayout[@content-desc=\"Xperia™ Home\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.TextView");
                Logger.logStep("Tapped on messenger icon");
                findElementByXPathAndClick("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.view.ViewGroup[4]");
                if (isElementDisplayedByAccessibilityId("FLIGHTS")){
                    Thread.sleep(4000);
                    findElementByXPathAndClick("//android.widget.Button[@content-desc=\"FLIGHTS\"]");
                    if (isElementDisplayedByAccessibilityId("TRIP DETAILS/CHANGE")){
                        findElementByXPathAndClick("//android.widget.Button[@content-desc=\"TRIP DETAILS/CHANGE\"]");
                        if (isElementDisplayedByAccessibilityId("VIEW BOOKING DETAILS")){
                            findElementByXPathAndClick("//android.widget.Button[@content-desc=\"VIEW BOOKING DETAILS\"]");
                            sendTextByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.EditText","8050510545");
                            driver.findElementByAccessibilityId("Send").click();
                            driver.hideKeyboard();
                            if (isElementDisplayedByAccessibilityId("FLIGHTS")){
                                Logger.logError("Flight details are not displayed for the user contact number :- 8050510545");
                            }
                            else if(isElementDisplayedByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")){
                                String confirmationNumber = findElementByXpathAndReturnItsAttributeText("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
                                if(confirmationNumber.equalsIgnoreCase("4B57TE")){
                                    String itineraryLabel = findElementByXpathAndReturnItsAttributeText("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.Button");
                                    if (itineraryLabel.equalsIgnoreCase("View Itinerary")){
                                        findElementByXPathAndClick("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.Button");
                                        BasePage.waitTillTheProgressIndicatorIsInvisibleByClassName_IOS("android.widget.ProgressBar",1);
                                        String  receipt = findElementByXpathAndReturnItsAttributeText("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.TextView");
                                        if (receipt.equalsIgnoreCase("Receipt")){
                                            Logger.logStep("Correct itinerary screen is displayed");
                                        }
                                    }else {
                                        Logger.logComment("View Itinerary label is not displayed");
                                    }
                                }else {
                                    Logger.logComment("PNR ID to be displayed :- "+"4B57TE");
                                    Logger.logComment("PNR ID is displayed :- "+confirmationNumber);
                                    Logger.logError("Incorrect PNR ID is displayed");
                                }
                            }else {
                                Logger.logError("Flight Itinerary Confirmation Id ");
                            }

                        }else {
                            Logger.logError("View booking details screen is not displayed");
                        }
                    }else {
                        Logger.logError("Trips details or change option is not displayed");
                    }
                }else {
                    Logger.logError("Flights options is not displayed in the bot");
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }

//        FlightsScreen.checkSelectLanguageModalIsDisplayed();
//
//        FlightsScreen.checkSelectLanguageModalIsDisplayed();
//
//        FlightsScreen.checkSelectLanguageModalIsDisplayed();
//
//        FlightsScreen.checkSelectLanguageModalIsDisplayed();
//
//        FlightsScreen.checkSelectLanguageModalIsDisplayed();
//
//        FlightsScreen.checkSelectLanguageModalIsDisplayed();
//
//        FlightsScreen.checkSelectLanguageModalIsDisplayed();
//
//        FlightsScreen.checkSelectLanguageModalIsDisplayed();

        Logger.endTest("Test Sample Test Case Ended");
    }


}
