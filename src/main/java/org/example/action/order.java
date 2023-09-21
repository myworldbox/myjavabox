package org.example.action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.example.global.variable;
import org.openqa.selenium.By;

import java.time.Duration;

public class order extends variable {

    public static class market {

        public static void buy() {

            driver.findElement(By.xpath("//*[@text='Markets']")).click();
            driver.findElement(By.xpath("(((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.view.ViewGroup'])[1]/*[@class='android.view.ViewGroup'])[3]/*[@text])[1]")).click();
            driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).click();
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.getKeyboard().sendKeys("2");
            // driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.FrameLayout' and ./parent::*[@id='content']]]/*[@class='android.view.ViewGroup'])[1]")).click();
            driver.findElement(By.xpath("//*[@id='inputArea']")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]]]]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[11]/*/*/*[@text='BUY'])[2]")).click();
            driver.findElement(By.xpath("//*[@text='BUY' and ./parent::*[./parent::*[@id='RNE__Overlay']]]")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]]]]/*/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
            // driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]]]]/*/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
            driver.findElement(By.xpath("//*[@text='Home']")).click();
        }


        public static void buy_with_param() {
            driver.findElement(By.xpath("//*[@text='Markets']")).click();
            driver.findElement(By.xpath("(((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.view.ViewGroup'])[1]/*[@class='android.view.ViewGroup'])[3]/*[@text])[1]")).click();
            driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).click();
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.getKeyboard().sendKeys("2");
            driver.findElement(By.xpath("//*[@id='inputArea']")).click();
            driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.Switch'])[1]")).click();
            driver.findElement(By.xpath("//*[@text='Buy Stop']")).click();
            driver.findElement(By.xpath("//*[@text='GTC']")).click();
            driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).click();
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
            driver.getKeyboard().sendKeys("2");
            driver.findElement(By.xpath("//*[@text='Order Type']")).click();
            driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.Switch'])[2]")).click();
            new TouchAction(driver)
                    .press(PointOption.point(573, 1818))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1267)))
                    .moveTo(PointOption.point(565, 1200))
                    .release()
                    .perform();
        driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.EditText'])[2]")).sendKeys("1");
            driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.EditText'])[2]")).sendKeys("10");
            driver.findElement(By.xpath("//*[@id='inputArea']")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]]]]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[9]/*/*/*[@text='BUY'])[2]")).click();
            driver.findElement(By.xpath("//*[@text='BUY' and ./parent::*[./parent::*[@id='RNE__Overlay']]]")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]]]]/*/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
            driver.findElement(By.xpath("//*[@text='Home']")).click();
        }

        public static void modify() {}
        public static void sell() {
            driver.findElement(By.xpath("//*[@text='Markets']")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[5]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
            driver.findElement(By.xpath("//*[@text='Close Position' and ./parent::*[./parent::*[./parent::*[@class='android.view.ViewGroup']]]]")).click();
            driver.findElement(By.xpath("//*[@text='Close Position']")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]]]]/*/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
            driver.findElement(By.xpath("//*[@text='Home']")).click();
        }
    }

    public static class pending{

        public static void buy() {

        }
        public static void modify() {

            driver.findElement(By.xpath("//*[@text='Portfolio']")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[2]")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("1");
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[2]")).sendKeys("10");
            driver.findElement(By.xpath("//*[@text='Edit Position' and ./parent::*[./parent::*[./parent::*[@class='android.view.ViewGroup']]]]")).click();
            driver.findElement(By.xpath("//*[@text='Edit Position']")).click();
            driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]]]]/*/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']]])[1]/*/*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
            driver.findElement(By.xpath("//*[@text='Home']")).click();

        }
        public static void sell() {}
    }
}
