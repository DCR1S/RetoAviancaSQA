package com.avianca.automation.pageobjects;

import com.avianca.automation.utils.Javascript;
import com.avianca.automation.utils.Times;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.avianca.com/co/es/")

public class BookFlightAviancaPage extends PageObject {

public By origenInput = By.xpath("//div[@class='form-group new-animate  new-focus']//label//div//input");
public By destinoInput = By.xpath("//label[contains(text(), \"Hacia\")]//div//input");
public By fechaViajeSelect = By.xpath("//label[contains(text(), \"Fechas\")]//div//input");
public By fechaInicialOption = By.xpath("//div[@data-month='2021.7']//div[@data-day='2021.7.31']");
public By fechaFinalOption = By.xpath("//div[@data-month='2021.8']//div[@data-day='2021.8.11']");
public By buscarVuelosButton = By.xpath("//button[@title='Buscar vuelos']");
public By tarifaEconomicaButton = By.xpath("(//button[@class='select-cabin-button'])[3]");
public By tarifaEconomicaIdaConfirmButton = By.xpath("(//button[@class='ff-price-container'])[2]");
public By tarifaEconomicaVueltaConfirmButton = By.xpath("(//button[@class='ff-price-container'])[1]");
public By confirmAllButton = By.id("continue-btn-footer");
public By horaIda1 = By.xpath("//div[@class='flight-details ng-star-inserted']//div[@class='hour']");
public By horaLlegada1 = By.xpath("//div[@class='flight-details ng-star-inserted']//div[3]/span");
public By precio1 = By.xpath("//bound-displayer-cont[1]/bound-displayer-pres/div/div[2]/div[2]/span/span[2]");
public By horaLlegada2 = By.xpath("//bound-displayer-cont[2]/bound-displayer-pres//div[3]/span");
public By horaIda2 = By.xpath("//bound-displayer-cont[2]/bound-displayer-pres//div[3]/span//parent::node()//parent::node()/div");
public By precio2 = By.xpath("//bound-displayer-cont[2]/bound-displayer-pres/div/div[2]/div[2]/span/span[2]");




 public void sendTXT(String texto, By locator){
   getDriver().findElement(locator).sendKeys(texto);
 }

 public void sendEnter(By locator){
     getDriver().findElement(locator).sendKeys(Keys.ENTER);
 }

 public void clear(By locator){
     getDriver().findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
 }

 public void sendArrowDown(By locator){
     getDriver().findElement(locator).sendKeys(Keys.ARROW_DOWN);
 }

 public void click(By locator){
     getDriver().findElement(locator).click();
 }

 public void submit(By locator){
        getDriver().findElement(locator).submit();
    }

 public void clickBuscarVuelos(){
    getDriver().findElement(fechaViajeSelect).sendKeys(Keys.ENTER);
 }

 public void selecccionarVueloDeIda() throws InterruptedException {
     getDriver().manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
     getDriver().findElement(tarifaEconomicaButton).click();
     Times.waitFor(2000);
     Javascript.scrollDown(getDriver(),"800");
     Times.waitFor(2000);
     Javascript.clickJS(getDriver(),tarifaEconomicaIdaConfirmButton);
     Times.waitFor(2000);


 }

    public void selecccionarVueloDeVuelta() throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);
        getDriver().findElement(tarifaEconomicaButton).click();
        Times.waitFor(2000);
        Javascript.scrollDown(getDriver(),"800");
        Times.waitFor(2000);
        Javascript.clickJS(getDriver(),tarifaEconomicaVueltaConfirmButton);
        Times.waitFor(2000);


    }

    public void closePopUp(){
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();// Presiona el botón OK
    }





    public String getText(By locator){
     return getDriver().findElement(locator).getText();
    }

}
