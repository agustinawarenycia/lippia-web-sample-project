package lippia.web.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.WebActionManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.EjemploNavegacionConstants;
import lippia.web.services.EjemploNavegacionService;
import org.testng.Assert;

import java.util.Objects;

public class EjemploNavegacionSteps extends PageSteps {


    @Given("que estoy en la pagina de web de Automation Practice")
    public void queEstoyEnLaPaginaDeWebDeAutomationPractice() {
        EjemploNavegacionService.navegarWeb();
    }

    @When("^ingreso una busqueda  \"(.*)\"$")
    public void ingresoUnaBusquedaDeVestido(String text) {
        EjemploNavegacionService.ingresarLaBusqueda(text);
        EjemploNavegacionService.clickSearchButton();
    }




    @Then("^la palabra \"(.*)\" se busco realmente$")
    public void  laPalabraBusquedaSeBuscoRealmente(String busqueda) {
        EjemploNavegacionService.validateBusqueda(busqueda);
    }




    @Then("se valida que esten bien ordenados")
    public void seValidaQueEstenBienOrdenados() {
        EjemploNavegacionService.validatePrecios();
        WebActionManager.waitVisibility(EjemploNavegacionConstants.LISTA_PRECIOS);

    }


//Steps del logeo


    @And("^el usuario ingresa su usurio '(.*)' y su contraseña '(.*)'$")
    public void elUsuarioIngresaSuUsurioUsuarioYSuContraseñaContrasenia(String usuario, String contrasenia) {
        EjemploNavegacionService.ingresoUsuarioYContrasenia(usuario,contrasenia);
    }

    @Then("verifico que se ha logeado correctamente y me deslogueo")
    public void meRedirigeAlInicioYVerificoQueSeHaLogeadoCorrectamente() {
        EjemploNavegacionService.validateLogin();
        EjemploNavegacionService.logOut();
    }

    @When("^ingreso una busqueda (.*)$")
    public void ingresoUnaBusqueda(String text) {
        EjemploNavegacionService.ingresarLaBusqueda(text);
        EjemploNavegacionService.clickSearchButton();
    }



    @When("^el usuario pulsa el botón \"(.*)\"$")
    public void elUsuarioPulsaElBotón(String boton) {
        EjemploNavegacionService.clickButton();
        EjemploNavegacionService.verificarSignInPage();
    }
    @Then("^la palabra (.*) se busco realmente$")
    public void laPalabraDressSeBuscoRealmente(String text) {
        EjemploNavegacionService.validateBusqueda(text);
       // if(Objects.equals(text, "dress"))
        //    Assert.assertTrue(true);
    }



    @And("la pagina me muestra los resultados, verificaa (.*) y selecciono los precios de menor a mayor")
    public void laPaginaMeMuestraLosResultadosVerificaaBusquedaYSeleccionoLosPreciosDeMenorAMayor(String text) {
        EjemploNavegacionService.verificaResultados();
        EjemploNavegacionService.validateBusqueda(text);
        EjemploNavegacionService.busquedaMenorAMAyor();

    }
}