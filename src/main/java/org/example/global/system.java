package org.example.global;

import io.qameta.allure.model.Status;
import org.example.action.navigate;
import org.example.action.auth;
import org.example.action.order;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public abstract class system extends variable {

    @Test
    public static void execution() {

        try {
            switch (action_id) {
                case "navigate.check_update":
                    navigate.check_update();
                    break;
                    case "navigate.open":
                    navigate.open();
                    break;
                case "navigate.close":
                    navigate.close();
                    break;
                case "auth.login":
                    auth.login();
/*
                    Thread.sleep(5000);
                    boolean watchlistPresent = !driver.findElements(By.xpath("//*[@text='Watchlist']")).isEmpty();

                    if(!watchlistPresent) {
                        System.out.println("Watchlist title should be visible after login");
                    }
                    softAssert.assertTrue(watchlistPresent, "Watchlist title should be visible after login");
                    softAssert.assertAll();
*/
                    break;
                case "auth.logout":
                    auth.logout();
                    break;
                case "order.market.buy":
                    order.market.buy();
/*
                    Thread.sleep(5000);
                    boolean button_1_exist = driver.findElements(By.xpath("//*[@text='0.01']")).isEmpty();
                    boolean button_2_exist = driver.findElements(By.xpath("//*[@text='0.1']")).isEmpty();
                    boolean button_3_exist = driver.findElements(By.xpath("//*[@text='0.5']")).isEmpty();
                    boolean button_4_exist = driver.findElements(By.xpath("//*[@text='1']")).isEmpty();
                    boolean button_5_exist = driver.findElements(By.xpath("//*[@text='5']")).isEmpty();

                    if(!button_1_exist && !button_2_exist && !button_3_exist && !button_4_exist && !button_5_exist) {
                        System.out.println("No in market buy");
                    } else {
                        System.out.println("we are in market buy");
                    }

 */
                    break;
                case "order.market.buy_with_param":
                    order.market.buy_with_param();
                    break;
                case "order.pending.buy":
                    order.pending.buy();
                    break;
                case "order.market.modify":
                    order.market.modify();
                    break;
                case "order.pending.modify":
                    order.pending.modify();
                    break;
                case "order.market.sell":
                    order.market.sell();
                    break;
                case "order.pending.sell":
                    order.pending.sell();
                    break;

            }
            allure.create_step(action_id, Status.PASSED, attachments);

            //allure.takeScreenshotAndAttachToAllure();
        } catch (Exception ignored) {
            allure.create_step(action_id, Status.FAILED, attachments);
            // allure.takeScreenshotAndAttachToAllure();
            // allure.captureScreenshot(action_id);
        }
    }

    public static void string_to_function(String className, String methodName, String functionParameter)
            throws Exception {
        // Get the class dynamically
        Class<?> clazz = Class.forName(className);

        // Get the method with the specified name
        Method method = clazz.getDeclaredMethod(methodName, String.class);

        // Create an instance of the class (assuming it has a default constructor)
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // Invoke the method on the instance
        method.invoke(instance, functionParameter);
    }

    public static void run_java(String filePath) throws InterruptedException, IOException {
        Process process = Runtime.getRuntime().exec("java " + filePath);

        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Java file executed successfully.");
        } else {
            System.out.println("Java file execution failed.");
        }
    }
}
