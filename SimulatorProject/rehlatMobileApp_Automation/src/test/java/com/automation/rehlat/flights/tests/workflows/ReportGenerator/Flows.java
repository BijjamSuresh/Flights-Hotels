package com.automation.rehlat.flights.tests.workflows.ReportGenerator;

import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class Flows extends BaseTest {
    @Test
    public void testFlows() throws Exception{
//        addTestResultStatusToExecutionResultsJsonFile("testCase1","false");
        String htmlReport = createHtmlStringOfExecutionResults("Execution_Results_Pixel2_EG_Domain.json");
        sendEmail(htmlReport);
    }
}
