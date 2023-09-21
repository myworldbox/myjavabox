import com.google.gson.Gson;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.model.TestResultContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.UUID;

public class kkk {

    public static void main(String[] args) throws IOException {
        // Generate UUID for the report
        String uuid = UUID.randomUUID().toString();

        // Create test result container
        TestResultContainer container = new TestResultContainer();
        container.setName("Test Container");
        container.setUuid(uuid);

        // Generate UUID-container.json
        Gson gson = new Gson();
        String containerJson = gson.toJson(container);

        // Create allure-results directory if it doesn't exist
        Path allureResultsDir = Path.of("allure-results");
        if (!Files.exists(allureResultsDir)) {
            Files.createDirectory(allureResultsDir);
        }

        writeToFile("allure-results/" + uuid + "-container.json", containerJson);

        // Create and update test result
        TestResult testResult = new TestResult();
        testResult.setUuid(UUID.randomUUID().toString());
        testResult.setName("Test Name");
        testResult.setStatus(Status.PASSED);

        // Attachments (optional)
        String screenshotPath = "path/to/screenshot.png";
        attachScreenshot(testResult, screenshotPath);

        // Generate UUID-results.json
        String resultJson = gson.toJson(testResult);
        writeToFile("allure-results/" + uuid + "-results.json", resultJson);

        System.out.println("Allure report files generated successfully!");
    }

    private static void attachScreenshot(TestResult testResult, String screenshotPath) throws IOException {
        byte[] screenshotBytes = Files.readAllBytes(Path.of(screenshotPath));
        String attachmentName = "Screenshot";
        Allure.getLifecycle().addAttachment(attachmentName, "image/png", "png", screenshotBytes);
        StepResult stepResult = new StepResult();
        stepResult.setStatus(Status.PASSED);
        stepResult.setName(attachmentName);
        testResult.setSteps(Collections.singletonList(stepResult));
    }

    private static void writeToFile(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}