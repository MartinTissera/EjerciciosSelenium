import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends Base {

    public loginPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
 
    // Definir todos los localizadores
    
    By nombreUsuario = By.id("username");
    By pass = By.id("password");
    By clickBTN = By.id("c6d7d2ace");
    By profile = By.id("profileTXT");

    // Definir variables 
    String user = "tissera.martin92@gmail.com";
    String password = "Duracell1";

   
    public void loginOK (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until((ExpectedConditions.presenceOfElementLocated(nombreUsuario)));
        this.clear(nombreUsuario);
        this.setText(user, nombreUsuario);
        this.clear(pass);
        this.setText(password, pass);
        this.submit(pass);
        //this.click(clickBTN);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(profile));  
    }

}
