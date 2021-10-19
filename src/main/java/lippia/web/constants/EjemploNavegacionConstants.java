package lippia.web.constants;

public class EjemploNavegacionConstants {

    //public static final String BUTTON_SIGNIN_XPATH = "xpath://a[contains(@title,'Log')]";
    //public static final String H1_TITULO_XPATH = "xpath://h1[text()='Authentication']";
    //public static final String INPUT_ADDRESS_XPATH = "xpath://input[@id='email']";
    public static final String INPUT_SEARCH_XPATH = "xpath://*[@id=\"search_query_top\"]"; //Input para la busqueda
    public static final String SEARCH_BUTTON_NAME = "xpath://*[@id=\"searchbox\"]/button";//boton para realizar la busqueda
    //public static final String RESULTADO_BUSQUEDA = "xpath://*[@id=\"center_column\"]/ul";
    public static final String SPAN_SEARCH = "xpath://*[@id=\"columns\"]/div[1]/span[2]";//spam que aparece a la izquierda para saber si estoy en la pagina correcta
    public static final String PALABRA_BUSCADA = "xpath://*[@id=\"center_column\"]/h1/span[1]"; //SPAN que muestra la palabra buscada
    public static final String DROPDOWN = "xpath://*[@id=\"uniform-selectProductSort\"]"; //dropdown para elegir el filtro en la busqueda (de mayor a menor, menos a mayor, alfabeticamente, etc)
    public static final String LISTA_PRECIOS = "xpath://*[@id=\"center_column\"]/ul/li[*]/div/div[2]/div[1]/span[1]"; //Locator de todos los precios que aparecen en la busqueda
    public static final String BOTON_LOGIN = "xpath://*[@id=\"SubmitLogin\"]"; //boton para logearme despues de ingresar usuario y contraseña
    public static final String INPUT_PASSWORD_XPATH = "xpath://*[@id=\"passwd\"]"; //input para ingresar el email de login

    //el input de email es INPUT_ADDRESS_XPATH
    public static final String SPAN_VERIFICAR_LOGIN_XPATH = "xpath://*[@id=\"columns\"]/div[1]/span[2]"; // Span que me dice que estoy en My account
    public static final String H1_VERIFICAR_LOGIN2_XPATH = "xpath://*[@id=\"center_column\"]/h1"; // H1 que me dice que estoy en My Account





}