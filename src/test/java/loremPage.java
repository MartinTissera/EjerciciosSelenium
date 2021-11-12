import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loremPage extends Base{

    public loremPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    //Variables

    By header = By.xpath("//*[@id='root']/div/div[1]/nav");
    By footer = By.className("footerClass");
    By textDisplayed = By.id("news");
    By hiddenText = By.id("hiddenText1");

    By queEsLoremLocator = By.partialLinkText("¿Qué es Lorem Ipsum?");
    By porUsamosLocator = By.partialLinkText("¿Por qué lo usamos?");
    By deDondeVieneLocator = By.partialLinkText("¿De dónde viene?");
    By dondeConseguirloLocator = By.partialLinkText("¿Dónde puedo conseguirlo?");

    By youtubeLink = By.xpath("//*[@id='titleScreen']/div[3]/div[1]/div/div/p[2]/a");
    By facebookLink = By.xpath("//*[@id='titleScreen']/div[3]/div[2]/div/div/p[2]/a");
    By seleniumLink = By.xpath("//*[@id='titleScreen']/div[3]/div[3]/div/div/p[2]/a");

    String titulo = "Lorem Ipsum Page";
    String texto = "Notice: This is a testing site meant to be used for automation test trainings";
    String textoOculto = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";
    
    String queEsLorem = "¿Qué es Lorem Ipsum?";
    String porqueUsamos = "¿Por qué lo usamos?";
    String deDondeViene = "¿De dónde viene?";
    String dondeConseguirlo = "¿Dónde puedo conseguirlo?";

    String target = "target";
    String _blank = "_blank";
    String _self = "_self"; // Para comprobar

    public void validarHeaderYFooter(){
        this.validarHeader(header);
        this.validarFooter(footer);
    }

    public void verificarTitulo(){
        this.verificarTitulo(titulo);
    }

    public void verificarLoremTexts(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textDisplayed)); 
        this.compareText(textDisplayed, texto);
    }

    public void verificarHiddenText(){
        this.compareText(hiddenText, textoOculto); // Deberia fallar ya que el texto esta oculto
        // if (isDisplayed(hiddenText)){
        //     this.compareText(hiddenText, textoOculto); 
        // } 
    }

    public void verificarSecciones() {
        this.compareText(queEsLoremLocator, queEsLorem);
        this.compareText(porUsamosLocator, porqueUsamos);
        this.compareText(deDondeVieneLocator, deDondeViene);
        this.compareText(dondeConseguirloLocator, dondeConseguirlo);
    }

    public void verificarLinks() {
        this.validarAtributo(youtubeLink, target, _blank);
        this.validarAtributo(facebookLink, target, _blank); // Deberia fallatar ya que el atributo es _self, comentar para pasar
        this.validarAtributo(seleniumLink, target, _blank); // Deberia fallatar ya que el atributo es _self, comentar para pasar
    }





    
}
