package com.avianca.test.stepdefinitions;
import com.avianca.automation.models.DataInjection;
import com.avianca.automation.pageobjects.BookFlightAviancaPage;
import com.avianca.automation.steps.BookFlightAviancaSteps;
import com.avianca.automation.utils.SpecialMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.junit.BeforeClass;
import org.slf4j.LoggerFactory;

public class BookFlightStepDefinitions {

    @Steps
    BookFlightAviancaSteps pageSteps;
    DataInjection dataInjection = new DataInjection();
    Logger log = Logger.getLogger(BookFlightStepDefinitions.class);
    BookFlightAviancaPage aviancaPage;


    @Given("^that a web user wants to reserve a flight at avianca$")
    public void thatAWebUserWantsToReserveAFlightAtAvianca(){
          pageSteps.openBrowser();
          log.info("SE ABRIO EL NAVEGADOR, PROCEDIENDO A HACER AUTOMATIZACION DE \nRESERVA DE VUELO EN LA PAGINA AVIANCA");

    }


    @When("^he fills all the requested fields$")
    public void heFillsAllTheRequestedFields() throws InterruptedException {
        log.info("Se selecciono "+dataInjection.getOrigen()+" como ciudad de origen");
        log.info("Se selecciono "+dataInjection.getDestino()+" como ciudad de destino");
        pageSteps.fillFlightData();
    }

    @Then("^he should see his flight reservation$")
    public void heShouldSeeHisFlightReservation() throws InterruptedException {
        log.info("Datos de Vuelo completados");

    }
}
