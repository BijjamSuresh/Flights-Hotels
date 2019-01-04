package com.automation.rehlat.flights.tests.workflows.ReportGenerator;

import com.automation.rehlat.flights.Labels_Flights;
import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class Flows extends BaseTest {
    @Test
    public void testFlows() throws Exception{
//        addTestResultStatusToExecutionResultsJsonFile("testCase1","false");
        String htmlReport = createHtmlStringOfExecutionResults("Execution_Results_"+ Labels_Flights.DEVICE_NAME+"_"+Labels_Flights.CURRENT_RUNNING_DOMAIN+"_Domain.json");
        sendEmail(htmlReport);
    }
}
