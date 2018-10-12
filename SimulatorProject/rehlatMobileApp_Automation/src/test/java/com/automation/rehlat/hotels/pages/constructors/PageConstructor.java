package com.automation.rehlat.hotels.pages.constructors;


import com.automation.rehlat.hotels.Labels_Hotels;
import com.automation.rehlat.hotels.pages.bookingSummary.BookingSummaryAndroid;
import com.automation.rehlat.hotels.pages.bookingSummary.BookingSummaryIos;
import com.automation.rehlat.hotels.pages.guestTravellersDetails.GuestTravellersDetailsAndroid;
import com.automation.rehlat.hotels.pages.guestTravellersDetails.GuestTravellersDetailsIos;
import com.automation.rehlat.hotels.pages.hotelProfile.HotelsProfileAndroid;
import com.automation.rehlat.hotels.pages.hotelProfile.HotelsProfileIos;
import com.automation.rehlat.hotels.pages.hotels.HotelsAndroid;
import com.automation.rehlat.hotels.pages.hotels.HotelsIos;
import com.automation.rehlat.hotels.pages.hotelsSearchResults.HotelsSearchResultsAndroid;
import com.automation.rehlat.hotels.pages.hotelsSearchResults.HotelsSearchResultsIos;
import com.automation.rehlat.hotels.pages.paymentsOptions.PaymentOptionsAndroid;
import com.automation.rehlat.hotels.pages.paymentsOptions.PaymentOptionsIos;
import com.automation.rehlat.hotels.pages.selectRooms.SelectRoomsAndroid;
import com.automation.rehlat.hotels.pages.selectRooms.SelectRoomsIos;
import com.automation.rehlat.hotels.pages.signIn.SignInAndroid;
import com.automation.rehlat.hotels.pages.signIn.SignInIos;
import com.automation.rehlat.hotels.pages.signUp.SignUpAndroid;
import com.automation.rehlat.hotels.pages.signUp.SignUpIos;
import com.automation.rehlat.hotels.tests.BaseTest;
import com.automation.rehlat.hotels.pages.BasePage;
import com.automation.rehlat.hotels.pages.menu.MenuAndroid;
import com.automation.rehlat.hotels.pages.menu.MenuIos;
import org.junit.Assert;

public class PageConstructor {

    public static void initializePageObject(String page, String platform) {

        switch (page) {
            case "signIn":
                if (platform.equals(Labels_Hotels.ANDROID)) {
                    BasePage.SignInScreen = new SignInAndroid();
                    BaseTest.SignInScreen = new SignInAndroid();

                } else if (platform.equals(Labels_Hotels.IOS)) {
                    BasePage.SignInScreen = new SignInIos();
                    BaseTest.SignInScreen = new SignInIos();
                }
                break;

            case "hotels":
                if (platform.equals(Labels_Hotels.ANDROID)) {
                    BasePage.HotelsScreen = new HotelsAndroid();
                    BaseTest.HotelsScreen = new HotelsAndroid();

                } else if (platform.equals(Labels_Hotels.IOS)) {
                    BasePage.HotelsScreen = new HotelsIos();
                    BaseTest.HotelsScreen = new HotelsIos();
                }
                break;

            case "menu":
                if (platform.equals(Labels_Hotels.ANDROID)) {
                    BasePage.MenuScreen = new MenuAndroid();
                    BaseTest.MenuScreen = new MenuAndroid();

                } else if (platform.equals(Labels_Hotels.IOS)) {
                    BasePage.MenuScreen = new MenuIos();
                    BaseTest.MenuScreen = new MenuIos();
                }
                break;
            case "signUp":
                if (platform.equals(Labels_Hotels.ANDROID)) {
                    BasePage.SignUpScreen = new SignUpAndroid();
                    BaseTest.SignUpScreen = new SignUpAndroid();

                } else if (platform.equals(Labels_Hotels.IOS)) {
                    BasePage.SignUpScreen = new SignUpIos();
                    BaseTest.SignUpScreen = new SignUpIos();
                }
                break;
            case "bookingSummary":
                if (platform.equals(Labels_Hotels.ANDROID)){
                    BasePage.BookingSummaryScreen = new BookingSummaryAndroid();
                    BaseTest.BookingSummaryScreen = new BookingSummaryAndroid();
                } else if (platform.equals(Labels_Hotels.IOS)){
                    BasePage.BookingSummaryScreen = new BookingSummaryIos();
                    BaseTest.BookingSummaryScreen = new BookingSummaryIos();
                }
                break;
            case "hotelsProfile":
                if (platform.equals(Labels_Hotels.ANDROID)){
                    BasePage.HotelsProfileScreen = new HotelsProfileAndroid();
                    BaseTest.HotelsProfileScreen = new HotelsProfileAndroid();
                } else if(platform.equals(Labels_Hotels.IOS)){
                    BasePage.HotelsProfileScreen = new HotelsProfileIos();
                    BaseTest.HotelsProfileScreen = new HotelsProfileIos();
            }
            break;
            case "hotelsSearchResults":
                if (platform.equals(Labels_Hotels.ANDROID)){
                    BasePage.HotelsSearchResultsScreen = new HotelsSearchResultsAndroid();
                    BaseTest.HotelsSearchResultsScreen = new HotelsSearchResultsAndroid();
                }else{
                    BasePage.HotelsSearchResultsScreen = new HotelsSearchResultsIos();
                    BaseTest.HotelsSearchResultsScreen = new HotelsSearchResultsIos();
                }
             break;
            case "selectRooms":
                if (platform.equals(Labels_Hotels.ANDROID)){
                    BasePage.SelectRoomsScreen = new SelectRoomsAndroid();
                    BaseTest.SelectRoomsScreen = new SelectRoomsAndroid();
                }else{
                    BasePage.SelectRoomsScreen = new SelectRoomsIos();
                    BaseTest.SelectRoomsScreen = new SelectRoomsIos();
                }
                break;
            case "paymentOptionsScreen":
                if (platform.equals(Labels_Hotels.ANDROID)){
                    BasePage.PaymentOptionsScreen = new PaymentOptionsAndroid();
                    BaseTest.PaymentOptionsScreen = new PaymentOptionsAndroid();
                }else{
                    BasePage.PaymentOptionsScreen = new PaymentOptionsIos();
                    BaseTest.PaymentOptionsScreen = new PaymentOptionsIos();
                }
                break;
            case "guestTravellersDetailsScreen":                                                                                                  
                if (platform.equals(Labels_Hotels.ANDROID)){
                    BasePage.GuestTravellersDetailsScreen = new GuestTravellersDetailsAndroid();
                    BaseTest.GuestTravellersDetailsScreen = new GuestTravellersDetailsAndroid();
                }else{
                    BasePage.GuestTravellersDetailsScreen = new GuestTravellersDetailsIos();
                    BaseTest.GuestTravellersDetailsScreen = new GuestTravellersDetailsIos();
                }
                break;
            case "myProfileScreen":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.MyProfileScreen = new MyProfileAndroid();
//                    BaseTest.MyProfileScreen = new MyProfileAndroid();
                }else{
//                    BasePage.MyProfileScreen = new MyProfileIos();
//                    BaseTest.MyProfileScreen = new MyProfileIos();
                }
                break;
            case "referYourFriendsScreen":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.ReferYourFriendsScreen = new ReferYourFriendsAndroid();
//                    BaseTest.ReferYourFriendsScreen = new ReferYourFriendsAndroid();
                }else{
//                    BasePage.ReferYourFriendsScreen = new ReferYourFriendsIOS();
//                    BaseTest.ReferYourFriendsScreen = new ReferYourFriendsIOS();
                }
                break;
            case "myTrips":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.MyTripsScreen = new MyTripsAndroid();
//                    BaseTest.MyTripsScreen = new MyTripsAndroid();
                }else{
//                    BasePage.MyTripsScreen = new MyTripsIos();
//                    BaseTest.MyTripsScreen = new MyTripsIos();
                }
                break;
            case "settings":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.SettingsScreen = new SettingsAndroid();
//                    BaseTest.SettingsScreen = new SettingsAndroid();
                }else{
//                    BasePage.SettingsScreen = new SettingsIos();
//                    BaseTest.SettingsScreen = new SettingsIos();
                }
                break;
            case "appSupport":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.AppSupportScreen = new AppSupportAndroid();
//                    BaseTest.AppSupportScreen = new AppSupportAndroid();
                }else{
//                    BasePage.AppSupportScreen = new AppSupportIos();
//                    BaseTest.AppSupportScreen = new AppSupportIos();
                }
                break;
            case "rateUs":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.RateUsScreen = new RateUsAndroid();
//                    BaseTest.RateUsScreen = new RateUsAndroid();
                }else{
//                    BasePage.RateUsScreen = new RateUsIos();
//                    BaseTest.RateUsScreen = new RateUsIos();
                }
                break;
            case "privacyPolicy":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.PrivacyPolicyScreen = new PrivacyPolicyAndroid();
//                    BaseTest.PrivacyPolicyScreen = new PrivacyPolicyAndroid();
                }else{
//                    BasePage.PrivacyPolicyScreen = new PrivacyPolicyIos();
//                    BaseTest.PrivacyPolicyScreen = new PrivacyPolicyIos();
                }
                break;
            case "notifications":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.NotificationsScreen = new NotificationsAndroid();
//                    BaseTest.NotificationsScreen = new NotificationsAndroid();
                }else{
//                    BasePage.NotificationsScreen = new NotificationsIos();
//                    BaseTest.NotificationsScreen = new NotificationsIos();
                }
                break;
            case "karam":
                if (platform.equals(Labels_Hotels.ANDROID)){
//                    BasePage.KaramScreen = new KaramAndroid();
//                    BaseTest.KaramScreen = new KaramAndroid();
                }else{
//                    BasePage.KaramScreen = new KaramIos();
//                    BaseTest.KaramScreen = new KaramIos();
                }
                break;
            default:
                Assert.fail(page + "screen not found or defined" );
        }
    }
}
