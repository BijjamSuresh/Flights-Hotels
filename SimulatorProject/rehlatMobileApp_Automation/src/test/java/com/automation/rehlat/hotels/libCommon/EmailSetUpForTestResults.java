package com.automation.rehlat.hotels.libCommon;

import com.automation.rehlat.flights.tests.BaseTest;

public class EmailSetUpForTestResults extends BaseTest {
    public static String createHtmlDocument(String emailId, String phoneNumber) {
        try {
            StringBuilder htmlStringBuilder=new StringBuilder();
            htmlStringBuilder.append("<table style=\"height: 59px; border-color: 330000; background-color: FFCC99;\" border=\"3\" width=\"585\"");
            htmlStringBuilder.append("<thead>");
            htmlStringBuilder.append("<tr>");
            htmlStringBuilder.append("<th>BOT FLOW</th>");
            htmlStringBuilder.append("<th>STATUS</th>");
            htmlStringBuilder.append("</tr>");
            htmlStringBuilder.append("</thead>");
            htmlStringBuilder.append("<tfoot>");
            htmlStringBuilder.append("<tr>");
            htmlStringBuilder.append("</tr>");
            htmlStringBuilder.append("</tfoot>");
            htmlStringBuilder.append("<tbody>");
            htmlStringBuilder.append("<tr>");
            htmlStringBuilder.append("<td>"+"Hotels_TripDetailsORChange_ViewBookingDetails_EmailId_BookingId"+"</td>");
            htmlStringBuilder.append("<td>"+emailId+"</td>");
            htmlStringBuilder.append("</tr>");
            htmlStringBuilder.append("<tr>");
            htmlStringBuilder.append("<td>"+"Hotels_TripDetailsORChange_ViewBookingDetails_PhoneNumber_BookingId"+"</td>");
            htmlStringBuilder.append("<td>"+phoneNumber+"</td>");
            htmlStringBuilder.append("</tr>");
            htmlStringBuilder.append("</tbody>");
            htmlStringBuilder.append("</table>");
            return htmlStringBuilder.toString();
//            WriteToFile(htmlStringBuilder.toString(),"fbBotReport.html");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to create the html file of test result");
        }
        return null;
    }
}
