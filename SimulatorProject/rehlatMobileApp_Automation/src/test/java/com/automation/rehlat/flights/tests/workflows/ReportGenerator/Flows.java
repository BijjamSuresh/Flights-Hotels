package com.automation.rehlat.flights.tests.workflows.ReportGenerator;

import com.automation.rehlat.flights.tests.BaseTest;
import org.junit.Test;

public class Flows extends BaseTest {
    @Test
    public void testFlows() throws Exception{
        String htmlReport = createHtmlStringOfExecutionResults("Execution_Results_Pixel2_KWI_Domain.json");
        sendEmail(htmlReport);
    }
}
