package org.example.test;

import com.google.gson.Gson;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.model.TestResultContainer;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllureReport {

    public static void main() {
        // Create a test result container (TestSuite)
        TestResultContainer testSuite = new TestResultContainer()
                .setName("My Test Suite").setUuid("234234");

        // Create a list to hold the test results
        List<TestResult> testResults = new ArrayList<>();

        // Create a test result for a test case
        TestResult testResult = new TestResult()
                .setName("My Test Case").setUuid("234234213123")
                .setStatus(Status.PASSED);

        // Add the test result to the list
        testResults.add(testResult);


        // Generate the Allure report
        generateAllureReport(testSuite);
    }

    private static void generateAllureReport(TestResultContainer testSuite) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(testSuite);
            Allure.addAttachment("AllureReport", "application/json", json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String toJsonString(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    private static List<String> convertToJsonStrings(List<TestResult> testResults) {
        List<String> jsonStrings = new ArrayList<>();
        Gson gson = new Gson();
        for (TestResult testResult : testResults) {
            String jsonString = gson.toJson(testResult);
            jsonStrings.add(jsonString);
        }
        return jsonStrings;
    }
}