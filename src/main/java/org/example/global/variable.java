package org.example.global;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.model.Attachment;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.model.TestResultContainer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class variable {

    public static final String reportDirectory = "reports";
    public static final String reportFormat = "xml";
    public static final String testName = "myjavabox";
    public static AndroidDriver<AndroidElement> driver = null;
    public static final DesiredCapabilities dc = new DesiredCapabilities();
    public static final String device_id = "R28M406DDWD";
    public static final String appium_url = "http://localhost:5000/wd/hub";
    public static JSONObject account_obj;
    public static JSONObject order_obj;

    public static String test_case_id;
    public static String action_id;
    public static String input_id;

    public static SoftAssert softAssert = new SoftAssert();

    public static JSONObject correct_json = format.json_to_obj("./src/main/java/org/example/json/correct.json");
    public static JSONObject run_json = format.json_to_obj("./src/main/java/org/example/json/run.json");
    public static JSONObject pipeline_json = format.json_to_obj("./src/main/java/org/example/json/pipeline.json");
    public static JSONObject wrong_json = format.json_to_obj("./src/main/java/org/example/json/wrong.json");

    public static TestResultContainer container;
    public static TestResult testResult;
    public static StepResult subStepResult;

    public static String uuid;

    public static List<StepResult> childSteps;
    public static List<Attachment> attachments;
}
