package org.example.action;

import org.example.global.variable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class auth extends variable {

    public static void login() {
        driver.findElement(By.xpath("//*[@text='Me']")).click();
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.view.ViewGroup'])[4]/*/*[@class='android.widget.EditText'])[1]")).sendKeys((String) account_obj.get("email"));
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]")));
        driver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]")).sendKeys((String) account_obj.get("password"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.EditText']]]")));
        driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.EditText']]]")).click();
        driver.findElement(By.xpath("//*[@text='Login' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Email Address']]]")).click();
    }

    public static void logout() {
        driver.findElement(By.xpath("//*[@text='Me']")).click();
        driver.findElement(By.xpath("//*[@text='Logout']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }
}