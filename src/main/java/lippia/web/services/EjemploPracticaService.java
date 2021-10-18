package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.EjemploPracticaConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class EjemploPracticaService extends ActionManager {

    public static void navegarWeb(){
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void clickButton(){
        click(EjemploPracticaConstants.BUTTON_SIGNIN_XPATH);
    }

    public static void verificarSignInPage(){
        waitVisibility(EjemploPracticaConstants.INPUT_ADDRESS_XPATH);
        Assert.assertTrue(isVisible(EjemploPracticaConstants.INPUT_ADDRESS_XPATH));
        waitVisibility(EjemploPracticaConstants.H1_TITULO_XPATH);
        Assert.assertEquals(getText(EjemploPracticaConstants.H1_TITULO_XPATH),"AUTHENTICATION","No se encuentra el titulo");
    }
}