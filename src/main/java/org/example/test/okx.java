package org.example.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.model.TestResultContainer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class okx {

    public static void main(String[] args) {
        // Generate test results
        TestResultContainer container = new TestResultContainer()
                .setName("My Test Suite");
        List<String> testResultUuids = createTestResults(container);

        // Set the child test result UUIDs
        container.setUuid(UUID.randomUUID().toString());
        container.setChildren(testResultUuids);

        // Generate Allure report
        generateAllureReport(container);
    }

    private static List<String> createTestResults(TestResultContainer container) {
        List<String> testResultUuids = new ArrayList<>();

        testResultUuids.add(createTestResult(container, "Test 1", Status.PASSED));
        testResultUuids.add(createTestResult(container, "Test 2", Status.FAILED));
        testResultUuids.add(createTestResult(container, "Test 3", Status.BROKEN));

        return testResultUuids;
    }

    private static String createTestResult(TestResultContainer container, String testName, Status status) {
        String uuid = UUID.randomUUID().toString();

        // Create the TestResult object
        TestResult testResult = new TestResult()
                .setUuid(uuid)
                .setName(testName)
                .setStatus(status);

        // Schedule the test result with Allure
        Allure.getLifecycle().scheduleTestCase(testResult);

        // Write the test result to a JSON file
        Allure.getLifecycle().startTestCase(uuid);
        Allure.getLifecycle().updateTestCase(result -> {
            result.setUuid(uuid);
            result.setName(testName);
            result.setStatus(status);
        });
        Allure.getLifecycle().stopTestCase(uuid);

        // Add the UUID to the container's children
        container.getChildren().add(uuid);

        return uuid;
    }

    private static void generateAllureReport(TestResultContainer container) {
        // Create Allure result directory
        Path allureResultsDirectory = Paths.get("allure-results");
        allureResultsDirectory.toFile().mkdirs();

        // Write test results to JSON files in Allure format
        writeTestResultContainer(container, allureResultsDirectory);

        // Serve the Allure report
        //AllureReportServer.serve(allureResultsDirectory.toAbsolutePath().toString());
    }

    private static void writeTestResultContainer(TestResultContainer container, Path outputDirectory) {
        try {
            // Convert the container object to JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(container);

            // Write the JSON to the file
            String filename =  container.getUuid() + "-container.json";
            Path containerFilePath = outputDirectory.resolve(filename);
            FileWriter fileWriter = new FileWriter(containerFilePath.toFile());
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}