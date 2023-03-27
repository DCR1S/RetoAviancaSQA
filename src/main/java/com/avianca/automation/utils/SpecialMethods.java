package com.avianca.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class SpecialMethods {

    private static int consecutivo = 0;

    public static void takeScreenShotFullPage(WebDriver driver){
        try {
            String directoryName = System.getProperty("user.dir");
            java.util.Date fecha = new Date();
            DateFormat formateadorFecha = DateFormat.getDateInstance(DateFormat.LONG);
            String ruta = directoryName+"\\screenshots\\screenshot_"+consecutivo+"_"+formateadorFecha.format(fecha)+".jpg";
            System.out.println("Screenshot en la ruta : "+ruta);
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "jpg", new File(ruta));
            consecutivo++;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void takeScreenShotShortPage(WebDriver driver){
        try {

            String directoryName = System.getProperty("user.dir");
            java.util.Date fecha = new Date();
            DateFormat formateadorFecha = DateFormat.getDateInstance(DateFormat.LONG);
            String ruta = directoryName+"\\screenshots\\screenshot_"+consecutivo+"_"+formateadorFecha.format(fecha)+".jpg";
            System.out.println("Screenshot en la ruta : "+ruta);

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ruta));
            consecutivo++;
        }catch (IOException errorsito){
            errorsito.printStackTrace();
        }
    }

}


