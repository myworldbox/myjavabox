package org.example.action;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.example.global.variable;
import org.testng.annotations.*;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class init extends variable {

    @BeforeMethod
    public static void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, device_id);
        driver = new AndroidDriver<>(new URL(appium_url), dc);
        driver.setLogLevel(Level.INFO);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}