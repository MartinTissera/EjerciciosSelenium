import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class formPage extends Base {

    public formPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }


    By header = By.xpath("//*[@id='root']/div/div[1]/nav");
    By footer = By.className("footerClass");
    By LBLUser = By.id("LBLUser");

    By nombre = By.id("TXTUser");
    By apellido = By.id("TXTPass");
    By nickname = By.id("TXTNick");
    By email = By.id("TXTEmail");
    By sitio = By.id("TXTUrl");
    By mobile = By.id("TXTMobile");
    By acerca = By.id("TXTAbout");
    By botonDev = By.id("RADButDevYes");
    By titulo = By.id("SELTitle");
    By enviar = By.id("BTNSubmit");

    String stringNom = "M";
    String stringApe = "T";
    String stringNick = "nickname";
    String stringEmail = "asdasd@asdasd";
    String stringSite = "personalsite.com";
    String stringMobile = "1501293";
    String stringTitulo = "Dr";
    String stringAbout = "=)";
    String stringDev = "si";

    By jumbotron = By.id("jumbotron");

    public void fullOk(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(LBLUser));
        this.setText(stringNom, nombre);
        this.setText(stringApe, apellido);
        this.setText(stringNick, nickname);
        this.setText(stringEmail, email);
        this.setText(stringSite, sitio);
        this.setText(stringMobile, mobile);
        this.select(stringTitulo, titulo);
        this.setText(stringAbout, acerca);
        this.click(botonDev);
        this.click(enviar);
    }

    public String[] datosFormulario() {
        String[] datos = { stringNom, stringApe, stringNick, stringEmail, stringSite, stringMobile, stringAbout,
                stringDev, stringTitulo };
        return datos;
    }

    public void HeaderYFooter() {
        this.validarHeader(header);
        this.validarFooter(footer);
    }

}
