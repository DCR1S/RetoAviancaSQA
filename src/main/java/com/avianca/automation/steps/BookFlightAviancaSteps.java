package com.avianca.automation.steps;

import com.avianca.automation.models.DataInjection;
import com.avianca.automation.pageobjects.BookFlightAviancaPage;
import com.avianca.automation.utils.Javascript;
import com.avianca.automation.utils.SpecialMethods;
import com.avianca.automation.utils.Times;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;

public class BookFlightAviancaSteps {

    BookFlightAviancaPage aviancaPage = new BookFlightAviancaPage();
    DataInjection dataInjection = new DataInjection();
    Logger log = Logger.getLogger(BookFlightAviancaSteps.class);

    @Step
    public void openBrowser(){
        aviancaPage.open();
        SpecialMethods.takeScreenShotShortPage(aviancaPage.getDriver());
    }

    @Step
    public void fillFlightData() throws InterruptedException {

        Javascript.scrollDown(aviancaPage.getDriver(), "400");
        aviancaPage.clear(aviancaPage.origenInput);
        Times.waitFor(1000);
        aviancaPage.sendTXT(dataInjection.getOrigen(),aviancaPage.origenInput);
        Times.waitFor(1000);
        aviancaPage.sendArrowDown(aviancaPage.origenInput);
        aviancaPage.sendEnter(aviancaPage.origenInput);
        Times.waitFor(1000);
        aviancaPage.clear(aviancaPage.destinoInput);
        Times.waitFor(1000);
        aviancaPage.sendTXT(dataInjection.getDestino(),aviancaPage.destinoInput);
        Times.waitFor(1000);
        aviancaPage.sendArrowDown(aviancaPage.destinoInput);
        aviancaPage.sendEnter(aviancaPage.destinoInput);
        Times.waitFor(1000);
        Javascript.clickJS(aviancaPage.getDriver(),aviancaPage.fechaInicialOption);
        Times.waitFor(1000);
        Javascript.clickJS(aviancaPage.getDriver(),aviancaPage.fechaFinalOption);
        SpecialMethods.takeScreenShotShortPage(aviancaPage.getDriver());
        aviancaPage.clickBuscarVuelos();
        Times.waitFor(2000);
        SpecialMethods.takeScreenShotShortPage(aviancaPage.getDriver());
        Times.waitFor(5000);
        aviancaPage.selecccionarVueloDeIda();
        SpecialMethods.takeScreenShotShortPage(aviancaPage.getDriver());
        Times.waitFor(2000);
        aviancaPage.selecccionarVueloDeVuelta();
        Javascript.scrollDown(aviancaPage.getDriver(), "420");
        Times.waitFor(1000);
        log.info("VUELO DE IDA -------------------------------------");
        log.info("HORA IDA: "+aviancaPage.getText(aviancaPage.horaIda1));
        log.info("HORA LLEGADA: "+aviancaPage.getText(aviancaPage.horaLlegada1));
        log.info("PRECIO: "+aviancaPage.getText(aviancaPage.precio1));
        log.info("--------------------------------------------------");
        log.info("VUELO DE VUELTA -------------------------------------");
        log.info("HORA IDA: "+aviancaPage.getText(aviancaPage.horaIda2));
        log.info("HORA LLEGADA: "+aviancaPage.getText(aviancaPage.horaLlegada2));
        log.info("PRECIO: "+aviancaPage.getText(aviancaPage.precio2));
        log.info("-----------------------------------------------------");
        Times.waitFor(1000);
        Javascript.popUp(aviancaPage.getDriver(),dataInjection.getOrigen(), dataInjection.getDestino(), aviancaPage.getText(aviancaPage.horaIda1), aviancaPage.getText(aviancaPage.horaLlegada1), aviancaPage.getText(aviancaPage.precio1), aviancaPage.getText(aviancaPage.horaIda2), aviancaPage.getText(aviancaPage.horaLlegada2), aviancaPage.getText(aviancaPage.precio2));
        Times.waitFor(7000);
        aviancaPage.closePopUp();
        Times.waitFor(1000);
        SpecialMethods.takeScreenShotShortPage(aviancaPage.getDriver());
        Times.waitFor(1000);


    }
}
