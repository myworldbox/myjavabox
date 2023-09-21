package org.example.global;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.List;

public class allure extends variable {


    public static void create_test_result_container(String name, List<String> children) {

        // Generate a UUID for the report
        uuid = UUID.randomUUID().toString();

        // Create the test container
        container = new TestResultContainer()
                .setName(name)
                .setUuid(uuid)
                .setChildren(children);
    }

    public static void delete_test_case_container() {
        // Stop and write the test container
        Allure.getLifecycle().stopTestContainer(container.getUuid());
        Allure.getLifecycle().writeTestContainer(String.valueOf(container));
    }

    public static void create_test_result(String name, Status status, List<Attachment> attachments) {
        // Create the main test result
        testResult = new TestResult()
                .setUuid(UUID.randomUUID().toString())
                .setName(name)
                .setStatus(status)
                .setAttachments(attachments);
        testResult.setSteps(childSteps);
    }

    public static void create_step(String name, Status status, List<Attachment> attachments) {
        // Create a sub-step result
        subStepResult = new StepResult()
                .setName(name)
                .setStatus(status)
                .setAttachments(attachments);

        // Add the sub-step result to the child steps list
        childSteps.add(subStepResult);

    }

    public static void start_test_case() throws IOException, AWTException {
        // Start the main test case
        Allure.getLifecycle().scheduleTestCase(testResult);
        Allure.getLifecycle().startTestCase(testResult.getUuid());
        Allure.step("Sub-Test Case 1");
        // Allure.addAttachment(take_photo());
    }

    public static void stop_test_case() {
        // Stop and write the main test case
        Allure.getLifecycle().stopTestCase(testResult.getUuid());
        Allure.getLifecycle().writeTestCase(String.valueOf(testResult));
    }
    public static void init() {

        // Generate a UUID for the report
        create_test_result_container(test_case_id, Collections.emptyList());

        // Create a list to hold child steps
        childSteps = new ArrayList<>();
    }

    public static void end() {

        allure.create_test_result(test_case_id, Status.SKIPPED, Collections.emptyList());
        delete_test_case_container();
        generate_report();
    }

    public static void generate_report() {

        // Generate the result and container JSON files
        format.object_to_json_file(uuid + "-result.json", testResult);
        format.object_to_json_file(uuid + "-container.json", container);

        System.out.println("Allure report files generated successfully!");
    }

    public static void main(String[] args) {
        // Create sample SoftAssert failures
        List<Throwable> softAssertFailures = new ArrayList<>();
        softAssertFailures.add(new AssertionError("Failure 1"));
        softAssertFailures.add(new AssertionError("Failure 2"));

        // Capture screenshots for Test 1 and Test 2
        captureScreenshot("Test 1");
        captureScreenshot("Test 2");

        // Generate Allure test result JSON
        List<TestResult> testResults = generateTestResults(softAssertFailures);

        // Serialize Allure results to JSON
        String allureJson = serializeAllureResults(testResults);

        // Save JSON to a file
        String jsonFilePath = "allure-results.json";
        saveToJsonFile(allureJson, jsonFilePath);

        // Serve Allure report
        serveAllureReport();
    }

    private static List<TestResult> generateTestResults(List<Throwable> failures) {
        List<TestResult> testResults = new ArrayList<>();

        // Test 1
        Status status1 = failures.isEmpty() ? Status.PASSED : Status.FAILED;
        TestResult testResult1 = generateTestResult("Test 1", failures, status1);
        testResults.add(testResult1);

        // Test 2
        Status status2 = Status.PASSED;
        TestResult testResult2 = generateTestResult("Test 2", new ArrayList<>(), status2);
        testResults.add(testResult2);

        return testResults;
    }

    private static TestResult generateTestResult(String testName, List<Throwable> failures, Status status) {
        TestResult testResult = new TestResult()
                .setName(testName)
                .setStatus(status);

        for (Throwable failure : failures) {
            StepResult stepResult = new StepResult()
                    .setName(failure.getMessage())
                    .setStatus(Status.FAILED)
                    .setStatusDetails(new StatusDetails().setMessage(failure.getLocalizedMessage()));
            testResult.getSteps().add(stepResult);
        }

        // Attach screenshots to the test result
        // testResult.setAttachments(createAttachments(testName));

        return testResult;
    }

    public static void captureScreenshot(String testName) {
        try {
            // Capture screenshot
            BufferedImage screenshot = new Robot()
                    .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenshot, "png", baos);
            byte[] screenshotBytes = baos.toByteArray();

            // Create the "Screenshots" directory if it doesn't exist
            Path screenshotsDirectory = Path.of("Screenshots");
            if (!Files.exists(screenshotsDirectory)) {
                Files.createDirectories(screenshotsDirectory);
            }

            // Save screenshot to file
            String screenshotFilePath = screenshotsDirectory.resolve(testName + ".png").toString();
            Files.write(Path.of(screenshotFilePath), screenshotBytes);


        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Attachment take_photo() throws IOException, AWTException {
        // Capture screenshot
        BufferedImage screenshot = new Robot()
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(screenshot, "png", baos);
        byte[] screenshotBytes = baos.toByteArray();

        // Convert byte array to Base64-encoded string
        String screenshotString = Base64.getEncoder().encodeToString(screenshotBytes);

        Attachment attachment = new Attachment()
                .setName(testName + ".png")
                .setType("image/png")
                .setSource(screenshotString);

        return attachment;
    }

    private static String serializeAllureResults(List<TestResult> testResults) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(testResults);
    }

    private static void saveToJsonFile(String json, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
            System.out.println("Allure JSON saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save Allure JSON.");
        }
    }

    private static void serveAllureReport() {
        try {
            // Serve Allure report using the "allure serve" command
            ProcessBuilder processBuilder = new ProcessBuilder("allure", "serve");
            processBuilder.directory(new File("allure-results")); // Set the working directory to "allure-results"
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Allure report served successfully.");
            } else {
                System.out.println("Failed to serve Allure report.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Failed to serve Allure report.");
        }
    }

    @Step("{description}")
    public static void executeTest(String testName, String description) {
        try {
            // Execute your test logic here

            // If the test passes
            attachScreenshot(testName, description, takeScreenshot());
        } catch (Exception e) {
            // If the test fails
            attachScreenshot(testName, description, takeScreenshot());
            throw e;
        }
    }

    @io.qameta.allure.Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void takeScreenshotAndAttachToAllure() {
        byte[] screenshot = takeScreenshot();
        Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
    }

    @Step("{description}")
    public static void attachScreenshot(String testName, String description, byte[] screenshot) {
        Allure.addAttachment("TestSuite", new ByteArrayInputStream(screenshot));
        Allure.step(testName);
        Allure.step("Test status: " + Status.PASSED.name());

    }

    public static void generateAllureReport() {
        String command = String.format("allure generate --clean %s -o %s",
                System.getProperty("allure.results.directory"), System.getProperty("allure.report.directory"));
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}