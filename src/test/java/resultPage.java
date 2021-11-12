import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class resultPage extends Base {

    public resultPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    By locatorTexto = By.id("Texto");
    String parrafo = "Se llama Miss M T. Tambien se le conoce como nickname." + "\n" +"Afirma que si es Software Developer." + "\n"  + "Para contactarle, simplemente llame al: 1501293, o escríbale a su casilla de eMail: asdas@asdasd ." + "\n"  + "Si quieres conocerle mas, nos cuenta lo siguiente: simbo." + "\n"  + "O bien lee su Bio en su personalsite.com.";

    By nombre = By.id("FirstName");
    By apellido = By.id("LastName");
    By nickname = By.id("NickName");
    By email = By.id("Email");
    By sitio = By.id("Url");
    By mobile = By.id("Mobile");
    By acerca = By.id("About");
    By botonDev = By.id("Developer");
    By title = By.id ("Title");
    By logOut = By.id ("logoutBTN");

    String titulo = "Results Page";

    
    public void verificarTitulo (){
            this.verificarTitulo(titulo);
    }

    public By[] datosParrafo (){
        By[] datos = {nombre , apellido , nickname , email , sitio , mobile , acerca , botonDev, title};
        return datos;
    }

    public void logOut(){
        this.click(logOut);
    }

}
