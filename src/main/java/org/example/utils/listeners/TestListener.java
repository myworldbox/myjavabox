package org.example.utils.listeners;

import io.qameta.allure.Allure;
import org.example.action.init;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener extends init implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void saveScreenshot (ITestResult iTestResult, WebDriver driver) {
        Allure.addAttachment(getTestMethodName(iTestResult), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        if (driver != null) {
            System.out.println("Screenshot in progress");
            saveScreenshot(iTestResult, driver);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        if (driver != null) {
            System.out.println("Screenshot in progress");
            saveScreenshot(iTestResult, driver);
        }
    }
}
