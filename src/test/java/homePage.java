import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homePage extends Base {

    public homePage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    // Variables
    By loremBTN = By.className("navbar-brand");
    By formBTN = By.xpath("//*[@id='navbar-intest']/li/a");
    By loginBTN = By.id("loginBTN");
    By profileIMG = By.id("profileIMG");
    By profileTXT = By.id("profileTXT");
    By logoutBTN = By.id("logoutBTN");
    By pageText = By.id("notLoggedTitleTXT");
    By screenText = By.id("notLoggedScreen");
    By header = By.xpath("//*[@id='root']/div/div[1]/nav");
    By footer = By.className("footerClass");

    String titulo = "Home Page"; // Deberia fallar ya que el titulo es Homme Page
    String textoTitle = "Welcome to my Automation Testing Site";
    String textoScreen = "Please click Login button to log into the application or sign up!";


    // Metodos
    public void Navigate(String url, WebDriver driver) {
        this.navigate(url);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginBTN));
    }

    public void clicklogin() {
        this.click(loginBTN);
    }

    public void clickForm() {
        this.click(formBTN);
    }

    public void validarLogout(WebDriver driver) {
        Assert.assertEquals(!this.isDisplayed(profileTXT), true);
        Assert.assertEquals(!this.isDisplayed(logoutBTN), true);
        Assert.assertEquals(!this.isDisplayed(profileIMG), true);
        Assert.assertEquals(!this.isDisplayed(loginBTN), false);
        // verificarTitulo(); // Fallaria ya que el titulo es Homme Page y no Home Page
    }

    public void verificarTitulo() {
        this.verificarTitulo(titulo);
    }

    public void verificarLinksHome() {
        By jumbotron = By.id ("jumbotron");
        By LBLUser = By.id ("LBLUser");
        this.verificarLinks(loremBTN, jumbotron);
        this.verificarLinks(formBTN, LBLUser);
    }

    public void verificarTextos() {
        this.compareText(pageText, textoTitle);
        this.compareText(screenText, textoScreen);
    }

    public void validarHeaderYFooter(){
        this.validarHeader(header);
        this.validarFooter(footer);
    }

    public void validarLogIn() {
        isDisplayed(profileTXT);
        isDisplayed(logoutBTN);
        Assert.assertEquals(!this.isDisplayed(loginBTN), true);
    }

    public void clickLoren() {
        this.click(loremBTN);
    }



}
