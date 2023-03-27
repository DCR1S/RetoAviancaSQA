package com.avianca.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Times {

    public static void waitFor(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public static void implicitWait (int time, WebDriver driver){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS) ;
    }

    public static void explicitWait (int time, By locator, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
