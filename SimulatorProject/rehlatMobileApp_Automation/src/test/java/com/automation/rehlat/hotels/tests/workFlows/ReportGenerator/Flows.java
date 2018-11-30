package com.automation.rehlat.hotels.tests.workFlows.ReportGenerator;

import com.automation.rehlat.hotels.tests.BaseTest;
import org.junit.Test;

public class Flows extends BaseTest {
    @Test
    public void testFlows() throws Exception{
        String htmlReport = createHtmlStringOfExecutionResults("Execution_Results.json");
        sendEmail(htmlReport);
    }
}
