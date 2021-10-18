package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.EjemploNavegacionConstants;
import lippia.web.constants.EjemploPracticaConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class EjemploNavegacionService extends ActionManager {


    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void ingresarLaBusqueda(String text) {

        setInput(EjemploNavegacionConstants.INPUT_SEARCH_XPATH, text);
    }

    public static void clickSearchButton() {

        click(EjemploNavegacionConstants.SEARCH_BUTTON_NAME);
    }

    public static void verificaResultados() {
        //waitVisibility(EjemploNavegacionConstants.RESULTADO_BUSQUEDA);
        //Assert.assertTrue(isVisible(EjemploNavegacionConstants.RESULTADO_BUSQUEDA));
        waitVisibility(EjemploNavegacionConstants.SPAN_SEARCH);
        Assert.assertEquals(getText(EjemploNavegacionConstants.SPAN_SEARCH), "Search", "No esta en la pagina de bsuqueda");
    }

    public static void validateBusqueda(String busqueda) {
        String obtenido = WebActionManager.getElement(EjemploNavegacionConstants.PALABRA_BUSCADA).getText().toLowerCase().replace("\"", ""); //pasa el string del locator todo a minuscula,
        Assert.assertEquals(busqueda, obtenido, "La palabra no coincide con la busqueda");
    }

    public static void busquedaMenorAMAyor() {
        click(EjemploNavegacionConstants.DROPDOWN);
        WebActionManager.click(EjemploNavegacionConstants.DROPDOWN, "Price: Lowest first");
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

}