package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.EjemploNavegacionConstants;
import lippia.web.services.EjemploNavegacionService;
import lippia.web.services.EjemploPracticaService;

public class EjemploNavegacionSteps extends PageSteps {


    @Given("que estoy en la pagina de web de Automation Practice")
    public void queEstoyEnLaPaginaDeWebDeAutomationPractice() {
        EjemploNavegacionService.navegarWeb();
    }

    @When("^ingreso una busqueda de vestido (.*)$")
    public void ingresoUnaBusquedaDeVestido(String text) {
        EjemploNavegacionService.ingresarLaBusqueda(text);
        EjemploNavegacionService.clickSearchButton();
    }


    @Then("la pagina me devuelve una vista y verifica los datos")
    public void laPaginaMeDevuelveUnaVistaYVerificaLosDatos() {
        EjemploNavegacionService.verificaResultados();
    }

    @Then("^la palabra (.*) se busco realmente$")
    public void laPalabraBusquedaSeBuscoRealmente(String busqueda) {
        EjemploNavegacionService.validateBusqueda(busqueda);
    }


    @Then("selecciono los precios de menor a mayor")
    public void seleccionoLosPreciosDeMenorAMayor() {
        EjemploNavegacionService.busquedaMenorAMAyor();
    }

    @Then("se valida que esten bien ordenados")
    public void seValidaQueEstenBienOrdenados() {
        EjemploNavegacionService.validatePrecios();
    }
}