package org.example.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class selenium {

    private static void takeScreenshot(AppiumDriver<MobileElement> driver, String fileName) {
        // Take screenshot as byte array
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Create the "Screenshots" directory if it doesn't exist
        Path screenshotsDirectory = Path.of("Screenshots");
        if (!Files.exists(screenshotsDirectory)) {
            try {
                Files.createDirectories(screenshotsDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Generate a unique file name based on current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = now.format(formatter);

        // Save the screenshot to a file
        String filePath = screenshotsDirectory.resolve(timestamp + "_" + fileName).toString();
        try {
            Files.write(Path.of(filePath), screenshotBytes);
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save screenshot.");
        }
    }
}