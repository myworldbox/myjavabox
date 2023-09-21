package org.example.test;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.model.TestResultContainer;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class test {

    public static void main(String[] args) {
        // Create Allure result directory
        Path allureResultsDirectory = Path.of("allure-results");
        allureResultsDirectory.toFile().mkdirs();

        // Generate test results
        TestResultContainer container = new TestResultContainer()
                .setUuid(UUID.randomUUID().toString())
                .setName("My Test Suite");
        List<String> testResultUuids = createTestResults(container);

        // Set the child test result UUIDs
        container.setChildren(testResultUuids);

        // Write test results to JSON files in Allure format
        writeTestResultContainer(container, allureResultsDirectory);
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
        Allure.getLifecycle().updateTestCase((Consumer<TestResult>) result -> {
            result.setUuid(uuid);
            result.setName(testName);
            result.setStatus(status);
        });

        // Add the UUID to the container's children
        container.getChildren().add(uuid);

        return uuid;
    }

    private static void writeTestResultContainer(TestResultContainer container, Path outputDirectory) {
        Path containerFilePath = outputDirectory.resolve("container-" + container.getUuid() + ".json");
        Allure.getLifecycle().writeTestContainer(String.valueOf(container));
        Allure.getLifecycle().writeTestContainer(String.valueOf(containerFilePath.toFile()));
    }
}