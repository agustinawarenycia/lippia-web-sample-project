package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.EjemploNavegacionConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class EjemploNavegacionService extends ActionManager {


    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void ingresarLaBusqueda(String text) {

        setInput(EjemploNavegacionConstants.INPUT_SEARCH_XPATH,text);
    }

    public static void clickSearchButton() {

        click(EjemploNavegacionConstants.SEARCH_BUTTON_NAME);
    }

    public static void verificaResultados() {
        waitVisibility(EjemploNavegacionConstants.SPAN_SEARCH);
        Assert.assertEquals(getText(EjemploNavegacionConstants.SPAN_SEARCH), "Search", "No esta en la pagina de bsuqueda");
    }

    public static void validateBusqueda(String busqueda) {
        String obtenido = WebActionManager.getElement(EjemploNavegacionConstants.PALABRA_BUSCADA).getText().toLowerCase().replace("\"", "").replace(" ", ""); //pasa el string del locator todo a minuscula y saco las comillas
        busqueda.replace("\"", "");
        Assert.assertEquals(busqueda, obtenido, "La palabra no coincide con la busqueda");
    }

    public static void busquedaMenorAMAyor() {
        click(EjemploNavegacionConstants.DROPDOWN);
        WebActionManager.click(EjemploNavegacionConstants.DROPDOWN_PRECIO_BAJO_XPATH, "Price: Lowest first");

    }

    public static void validatePrecios() {
        double aux=-1000;

        List<WebElement> listaDePrecios = WebActionManager.getElements(EjemploNavegacionConstants.LISTA_PRECIOS);
        double precio = 0;

        for (WebElement precios : listaDePrecios) {
          precio = convertStringToDouble(precios.getText());

           Assert.assertTrue(aux<precio, "No esta ordenado");
           aux=precio;

        }

    }

    private static Double convertStringToDouble(String texto) {
        texto=texto.replace("$", "");
        return Double.valueOf(texto);
    }

    public static void ingresoUsuarioYContrasenia(String email, String password){
        setInput(EjemploNavegacionConstants.INPUT_ADDRESS_XPATH, email );
        setInput(EjemploNavegacionConstants.INPUT_PASSWORD_XPATH, password);
        WebActionManager.click(EjemploNavegacionConstants.BOTON_LOGIN);

    }
    public static void validateLogin(){
        waitVisibility(EjemploNavegacionConstants.SPAN_VERIFICAR_LOGIN_XPATH);
        Assert.assertTrue(isVisible(EjemploNavegacionConstants.SPAN_VERIFICAR_LOGIN_XPATH));
            }


    public static void clickButton(){
        click(EjemploNavegacionConstants.BUTTON_SIGNIN_XPATH);
    }
    public static void verificarSignInPage(){
        waitVisibility(EjemploNavegacionConstants.INPUT_ADDRESS_XPATH);
        Assert.assertTrue(isVisible(EjemploNavegacionConstants.INPUT_ADDRESS_XPATH));
        waitVisibility(EjemploNavegacionConstants.H1_TITULO_XPATH);
        Assert.assertEquals(getText(EjemploNavegacionConstants.H1_TITULO_XPATH),"AUTHENTICATION","No se encuentra el titulo");
    }

    public static void logOut() {
        WebActionManager.click(EjemploNavegacionConstants.LOG_OUT_BUTON);
    }
}