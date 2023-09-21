package org.example.action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.example.global.variable;
import org.openqa.selenium.By;

public class navigate extends variable {

    public static void open() {
        driver.findElement(By.xpath("//*[@text='E+Play']")).click();
    }

    public static void close() {
        PointOption<?> point = PointOption.point(118 + 239 / 2, 2145 + 126 / 2);
        new TouchAction<>(driver).tap(point).perform();
        driver.findElement(By.xpath("//*[@text='Close all']")).click();
    }

    public static void check_update() {
        driver.findElement(By.xpath("//*[@text='RETRY']")).click();
    }
}
