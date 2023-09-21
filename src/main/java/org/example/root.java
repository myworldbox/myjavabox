package org.example;

import io.qameta.allure.model.Status;
import org.example.action.init;
import org.example.global.allure;
import org.example.global.format;
import org.example.global.system;
import org.example.global.variable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

public class root extends variable {

    public static JSONObject findObjectById(JSONArray jsonArray, String id) {
        if (jsonArray != null) {
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String objectId = (String) format.obj_get_child(jsonObject, "id");
                if (Objects.equals(id, objectId)) {
                    return jsonObject;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            init.setUp();

            JSONArray testCases = (JSONArray) format.obj_get_child(run_json, "test_case_id");

            assert testCases != null;
            for (Object testCaseId : testCases) {

                JSONObject testCase = findObjectById((JSONArray) format.obj_get_child(pipeline_json, "test_case"), (String) testCaseId);
                JSONArray actions = (JSONArray) format.obj_get_child(testCase, "action");

                 test_case_id = (String)testCaseId;
                System.out.println("\ntest_case <---> " + testCaseId);

                allure.init();

                assert actions != null;
                for (Object actionObj : actions) {
                                JSONObject action = (JSONObject) actionObj;
                                action_id = (String) format.obj_get_child(action, "action_id");
                                input_id = (String) format.obj_get_child(action, "input_id");

                                System.out.println("\naction_id ---> " + action_id);
                                System.out.println("input_id ---> " + input_id);

                                account_obj = findObjectById((JSONArray) format.obj_get_child(correct_json, "account"), input_id);
                                if (account_obj == null) {
                                    account_obj = findObjectById((JSONArray) format.obj_get_child(wrong_json, "account"), input_id);
                                }

                                order_obj = findObjectById((JSONArray) format.obj_get_child(correct_json, "order"), input_id);
                                if (order_obj == null) {
                                    order_obj = findObjectById((JSONArray) format.obj_get_child(wrong_json, "order"), input_id);
                                }

                                System.out.println("[account] ---> " + account_obj);
                                System.out.println("[order] ---> " + order_obj);

                                system.execution();
                                Thread.sleep(5000);
                            }
                allure.end();
                }
            init.tearDown();
        } catch (Exception e) {
            allure.end();
            init.tearDown();
        }
    }
}