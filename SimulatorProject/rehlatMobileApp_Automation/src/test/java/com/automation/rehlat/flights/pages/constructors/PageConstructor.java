package com.automation.rehlat.flights.pages.constructors;


import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.pages.BasePage;
import com.automation.rehlat.flights.pages.appSupport.AppSupportAndroid;
import com.automation.rehlat.flights.pages.appSupport.AppSupportIos;
import com.automation.rehlat.flights.pages.bookingPage.BookingPageAndroid;
import com.automation.rehlat.flights.pages.bookingPage.BookingPageIos;
import com.automation.rehlat.flights.pages.flights.FlightsAndroid;
import com.automation.rehlat.flights.pages.flights.FlightsIos;
import com.automation.rehlat.flights.pages.flightsSearchResults.FlightsSearchResultsAndroid;
import com.automation.rehlat.flights.pages.flightsSearchResults.FlightsSearchResultsIos;
import com.automation.rehlat.flights.pages.flightsSimilarOptionsSearchResults.FlightsSimilarOptionsSearchResultsAndroid;
import com.automation.rehlat.flights.pages.flightsSimilarOptionsSearchResults.FlightsSimilarOptionsSearchResultsIos;
import com.automation.rehlat.flights.pages.karam.KaramAndroid;
import com.automation.rehlat.flights.pages.karam.KaramIos;
import com.automation.rehlat.flights.pages.menu.MenuAndroid;
import com.automation.rehlat.flights.pages.menu.MenuIos;
import com.automation.rehlat.flights.pages.myProfile.MyProfileAndroid;
import com.automation.rehlat.flights.pages.myProfile.MyProfileIos;
import com.automation.rehlat.flights.pages.myTrips.MyTripsAndroid;
import com.automation.rehlat.flights.pages.myTrips.MyTripsIos;
import com.automation.rehlat.flights.pages.notificatios.NotificationsAndroid;
import com.automation.rehlat.flights.pages.notificatios.NotificationsIos;
import com.automation.rehlat.flights.pages.paymentOptions.PaymentOptionsAndroid;
import com.automation.rehlat.flights.pages.paymentOptions.PaymentOptionsIos;
import com.automation.rehlat.flights.pages.privacyPolicy.PrivacyPolicyAndroid;
import com.automation.rehlat.flights.pages.privacyPolicy.PrivacyPolicyIos;
import com.automation.rehlat.flights.pages.rateUs.RateUsAndroid;
import com.automation.rehlat.flights.pages.rateUs.RateUsIos;
import com.automation.rehlat.flights.pages.referYourFriends.ReferYourFriendsAndroid;
import com.automation.rehlat.flights.pages.referYourFriends.ReferYourFriendsIOS;
import com.automation.rehlat.flights.pages.reviewBooking.ReviewBookingAndroid;
import com.automation.rehlat.flights.pages.reviewBooking.ReviewBookingIos;
import com.automation.rehlat.flights.pages.settings.SettingsAndroid;
import com.automation.rehlat.flights.pages.settings.SettingsIos;
import com.automation.rehlat.flights.pages.signIn.SignInAndroid;
import com.automation.rehlat.flights.pages.signIn.SignInIos;
import com.automation.rehlat.flights.pages.signUp.SignUpAndroid;
import com.automation.rehlat.flights.pages.signUp.SignUpIos;
import com.automation.rehlat.flights.pages.travellerDetails.TravellerDetailsAndroid;
import com.automation.rehlat.flights.pages.travellerDetails.TravellerDetailsIos;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Assert;

public class PageConstructor {

    public static void initializePageObject(String page, String platform) {

        switch (page) {
            case "signIn":
                if (platform.equals(Labels_Flights.ANDROID)) {
                    BasePage.SignInScreen = new SignInAndroid();
                    BaseTest.SignInScreen = new SignInAndroid();

                } else if (platform.equals(Labels_Flights.IOS)) {
                    BasePage.SignInScreen = new SignInIos();
                    BaseTest.SignInScreen = new SignInIos();
                }
                break;

            case "flights":
                if (platform.equals(Labels_Flights.ANDROID)) {
                    BasePage.FlightsScreen = new FlightsAndroid();
                    BaseTest.FlightsScreen = new FlightsAndroid();

                } else if (platform.equals(Labels_Flights.IOS)) {
                    BasePage.FlightsScreen = new FlightsIos();
                    BaseTest.FlightsScreen = new FlightsIos();
                }
                break;

            case "menu":
                if (platform.equals(Labels_Flights.ANDROID)) {
                    BasePage.MenuScreen = new MenuAndroid();
                    BaseTest.MenuScreen = new MenuAndroid();

                } else if (platform.equals(Labels_Flights.IOS)) {
                    BasePage.MenuScreen = new MenuIos();
                    BaseTest.MenuScreen = new MenuIos();
                }
                break;
            case "signUp":
                if (platform.equals(Labels_Flights.ANDROID)) {
                    BasePage.SignUpScreen = new SignUpAndroid();
                    BaseTest.SignUpScreen = new SignUpAndroid();

                } else if (platform.equals(Labels_Flights.IOS)) {
                    BasePage.SignUpScreen = new SignUpIos();
                    BaseTest.SignUpScreen = new SignUpIos();
                }
                break;
            case "flightsSearchResults":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.FlightsSearchResultsScreen = new FlightsSearchResultsAndroid();
                    BaseTest.FlightsSearchResultsScreen = new FlightsSearchResultsAndroid();
                } else if (platform.equals(Labels_Flights.IOS)){
                    BasePage.FlightsSearchResultsScreen = new FlightsSearchResultsIos();
                    BaseTest.FlightsSearchResultsScreen = new FlightsSearchResultsIos();
                }
                break;
            case "flightsSimilarOptionsSearchResultsScreen":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsAndroid();
                    BaseTest.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsAndroid();
                } else if(platform.equals(Labels_Flights.IOS)){
                    BasePage.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsIos();
                    BaseTest.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsIos();
            }
            break;
            case "reviewBookingScreen":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.ReviewBookingScreen = new ReviewBookingAndroid();
                    BaseTest.ReviewBookingScreen = new ReviewBookingAndroid();
                }else{
                    BasePage.ReviewBookingScreen = new ReviewBookingIos();
                    BaseTest.ReviewBookingScreen = new ReviewBookingIos();
                }
             break;
            case "bookingPageScreen":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.BookingPageScreen = new BookingPageAndroid();
                    BaseTest.BookingPageScreen = new BookingPageAndroid();
                }else{
                    BasePage.BookingPageScreen = new BookingPageIos();
                    BaseTest.BookingPageScreen = new BookingPageIos();
                }
                break;
            case "travellerDetailsScreen":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.TravellerDetailsScreen = new TravellerDetailsAndroid();
                    BaseTest.TravellerDetailsScreen = new TravellerDetailsAndroid();
                }else{
                    BasePage.TravellerDetailsScreen = new TravellerDetailsIos();
                    BaseTest.TravellerDetailsScreen = new TravellerDetailsIos();
                }
                break;
            case "paymentOptionsScreen":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.PaymentOptionsScreen = new PaymentOptionsAndroid();
                    BaseTest.PaymentOptionsScreen = new PaymentOptionsAndroid();
                }else{
                    BasePage.PaymentOptionsScreen = new PaymentOptionsIos();
                    BaseTest.PaymentOptionsScreen = new PaymentOptionsIos();
                }
                break;
            case "myProfileScreen":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.MyProfileScreen = new MyProfileAndroid();
                    BaseTest.MyProfileScreen = new MyProfileAndroid();
                }else{
                    BasePage.MyProfileScreen = new MyProfileIos();
                    BaseTest.MyProfileScreen = new MyProfileIos();
                }
                break;
            case "referYourFriendsScreen":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.ReferYourFriendsScreen = new ReferYourFriendsAndroid();
                    BaseTest.ReferYourFriendsScreen = new ReferYourFriendsAndroid();
                }else{
                    BasePage.ReferYourFriendsScreen = new ReferYourFriendsIOS();
                    BaseTest.ReferYourFriendsScreen = new ReferYourFriendsIOS();
                }
                break;
            case "myTrips":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.MyTripsScreen = new MyTripsAndroid();
                    BaseTest.MyTripsScreen = new MyTripsAndroid();
                }else{
                    BasePage.MyTripsScreen = new MyTripsIos();
                    BaseTest.MyTripsScreen = new MyTripsIos();
                }
                break;
            case "settings":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.SettingsScreen = new SettingsAndroid();
                    BaseTest.SettingsScreen = new SettingsAndroid();
                }else{
                    BasePage.SettingsScreen = new SettingsIos();
                    BaseTest.SettingsScreen = new SettingsIos();
                }
                break;
            case "appSupport":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.AppSupportScreen = new AppSupportAndroid();
                    BaseTest.AppSupportScreen = new AppSupportAndroid();
                }else{
                    BasePage.AppSupportScreen = new AppSupportIos();
                    BaseTest.AppSupportScreen = new AppSupportIos();
                }
                break;
            case "rateUs":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.RateUsScreen = new RateUsAndroid();
                    BaseTest.RateUsScreen = new RateUsAndroid();
                }else{
                    BasePage.RateUsScreen = new RateUsIos();
                    BaseTest.RateUsScreen = new RateUsIos();
                }
                break;
            case "privacyPolicy":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.PrivacyPolicyScreen = new PrivacyPolicyAndroid();
                    BaseTest.PrivacyPolicyScreen = new PrivacyPolicyAndroid();
                }else{
                    BasePage.PrivacyPolicyScreen = new PrivacyPolicyIos();
                    BaseTest.PrivacyPolicyScreen = new PrivacyPolicyIos();
                }
                break;
            case "notifications":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.NotificationsScreen = new NotificationsAndroid();
                    BaseTest.NotificationsScreen = new NotificationsAndroid();
                }else{
                    BasePage.NotificationsScreen = new NotificationsIos();
                    BaseTest.NotificationsScreen = new NotificationsIos();
                }
                break;
            case "karam":
                if (platform.equals(Labels_Flights.ANDROID)){
                    BasePage.KaramScreen = new KaramAndroid();
                    BaseTest.KaramScreen = new KaramAndroid();
                }else{
                    BasePage.KaramScreen = new KaramIos();
                    BaseTest.KaramScreen = new KaramIos();
                }
                break;

            default:
                Assert.fail(page + "screen not found or defined" );
        }
    }
}
