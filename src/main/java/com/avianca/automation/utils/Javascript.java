package com.avianca.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;

public class Javascript {

    public static void clickJS(WebDriver driver, By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(by));
    }

    public static void scrollDown(WebDriver driver, String pixelsToDown){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = MessageFormat.format("window.scrollBy(0, {0}.", pixelsToDown);
        script = script+')';
        js.executeScript(script);
    }

    public static void popUp(WebDriver driver,String origen, String destino, String horaIda1, String horaLlegada1, String precio1, String horaIda2, String horaLlegada2, String precio2){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert(\"" +origen+ " - " +destino+" - Total a pagar: "+precio1+" + "+precio2+" - Vuelo 1: "+horaIda1+" - "+horaLlegada1 +" / Vuelo2:  "+horaIda2+" - "+horaLlegada2+"\")");
    }
}
