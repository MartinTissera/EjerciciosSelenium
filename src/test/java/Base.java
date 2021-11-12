import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void setText(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    public void clear(By locator) {
        driver.findElement(locator).clear();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void select(String opcion, By locator) {
        Select dropDown = new Select(driver.findElement(locator));
        dropDown.selectByValue(opcion);
    }

    public void compareText(By locator, String texto) {
        Assert.assertEquals(driver.findElement(locator).getText(), texto);
    }

    public void comparar(By[] locators1, String[] locators2) {
        Assert.assertEquals(driver.findElement(locators1[0]).getText(), locators2[0]);
        Assert.assertEquals(driver.findElement(locators1[1]).getText(), locators2[1]);
        Assert.assertEquals(driver.findElement(locators1[2]).getText(), locators2[2]); // Comentar para pasar test
        Assert.assertEquals(driver.findElement(locators1[3]).getText(), locators2[3]);
        Assert.assertEquals(driver.findElement(locators1[4]).getText(), locators2[4]);
        Assert.assertEquals(driver.findElement(locators1[5]).getText(), locators2[5]); // Comentar para pasar test
        Assert.assertEquals(driver.findElement(locators1[6]).getText(), locators2[6]);
        Assert.assertEquals(driver.findElement(locators1[7]).getText(), locators2[7]);
        Assert.assertEquals(driver.findElement(locators1[8]).getText(), locators2[8]);
    }

    public void verificarTitulo(String titulo) {
        Assert.assertEquals(driver.getTitle(), titulo);
    }

    public void verificarLinks(By locator, By target) {
        driver.findElement(locator).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(!isDisplayed(target));
    }

    public void validarHeader(By locator) {
        Assert.assertEquals(driver.findElement(locator).getCssValue("position"), "static");
        Assert.assertEquals(driver.findElement(locator).getCssValue("top"), "0px");
        Assert.assertEquals(driver.findElement(locator).getCssValue("background-color"), "rgba(34, 34, 34, 1)");

    }

    public void validarFooter(By locator) {
        Assert.assertEquals(driver.findElement(locator).getText(), "Disclaimer: This project is a personal site meant to be used as a help test site to be able to perform some automation test on demand.");
        Assert.assertEquals(driver.findElement(locator).getCssValue("position"), "fixed");
        Assert.assertEquals(driver.findElement(locator).getCssValue("bottom"), "0px");
        Assert.assertEquals(driver.findElement(locator).getCssValue("background-color"), "rgba(0, 0, 0, 1)");
    }

    public void validarAtributo(By locator, String atributo1, String atributo2){
        Assert.assertEquals(driver.findElement(locator).getAttribute(atributo1), atributo2);
    }

}
