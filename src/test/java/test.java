import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    private WebDriver driver;
    loginPage login;
    homePage home;
    formPage form;
    resultPage result;
    loremPage lorem;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new loginPage(driver);
        home = new homePage(driver);
        form = new formPage(driver);
        result = new resultPage(driver);
        lorem = new loremPage(driver);
    }

    @Test void test2(){
        home.Navigate("https://testappautomation.herokuapp.com/", driver);
        home.verificarTitulo(); // Deberia fallar Home Page != Homme Page
        home.verificarTextos(); // Deberia fallar Automation != Atomation
        home.verificarLinksHome();
        home.Navigate("https://testappautomation.herokuapp.com/", driver);
        home.validarHeaderYFooter();
        home.clicklogin();
        login.loginOK(driver);
        home.validarLogIn();
        
    }

    @Test
    public void test3() {
        home.Navigate("https://testappautomation.herokuapp.com/", driver);
        home.clicklogin();
        login.loginOK(driver);

        lorem.validarHeaderYFooter();
        home.clickLoren();
        lorem.verificarTitulo();
        lorem.verificarLoremTexts(driver); 
        lorem.verificarHiddenText(); // Deberia fallar ya que el texto oculto
        lorem.verificarSecciones();
        lorem.verificarLinks(); // Deberia fallar ya que hay dos links que no son _blank
    }

    @Test
    public void test4() {
        home.Navigate("https://testappautomation.herokuapp.com/", driver);
        home.clicklogin();
        login.loginOK(driver);

        home.clickForm();
        form.HeaderYFooter();
        form.fullOk(driver);

        result.verificarTitulo();
        result.comparar(result.datosParrafo(), form.datosFormulario()); // Deberia fallar en nickname y el numero de celu
        result.logOut();

        home.validarLogout(driver); // Fallaria ya que el titulo es Homme Page y no Home Page
    }

    @AfterTest
    public void tearDown() {
    driver.quit();
    }
}
