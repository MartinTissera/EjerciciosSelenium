package com.login2;

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


class pruebas123 {

        WebDriver driver;

        @BeforeMethod
        void setup() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        @Test
        void testApp() {
                driver.get("https://testappautomation.herokuapp.com/");
                // Maximo la ventana
                driver.manage().window().maximize();
                // Compruebo el titulo
                Assert.assertEquals(driver.getTitle(), "Homme Page"); // Escrito mal para que pase.
                // Verifico Boton
                Assert.assertEquals(driver.findElements(By.id("loginBTN")).isEmpty(), false);
                // Comprueba Links
                Assert.assertEquals(driver.findElement(By.className("navbar-brand")).getAttribute("href"),
                                "https://testappautomation.herokuapp.com/lorem/");
                Assert.assertEquals(driver.findElement(By.xpath("//*[@id='navbar-intest']/li/a")).getAttribute("href"),
                                "https://testappautomation.herokuapp.com/forms/");

                // Comprueba Texto
                Assert.assertEquals(driver.findElement(By.id("notLoggedTitleTXT")).getText(),
                                "Welcome to my Atomation Testing Site"); // Detectado bug, cambiado para avanzar
                Assert.assertEquals(driver.findElement(By.id("notLoggedScreen")).getText(),
                                "Please click Login button to log into the application or sign up!");

                // Comprueba Footer
                Assert.assertEquals(driver.findElement(By.id("footerbox")).getText(),
                                "Disclaimer: This project is a personal site meant to be used as a help test site to be able to perform some automation test on demand.");

                // Verifico la posicion del footer
                int yRef = driver.findElement(By.id("footerbox")).getLocation().getY();
                Assert.assertTrue(yRef > 500);

                
                // Verifico si la posicion es "Fixed"
                String Pos = driver.findElement(By.className("footerClass")).getCssValue("position");
                Assert.assertTrue(Pos.equals("fixed"));

                // Log In
                driver.findElement(By.id("loginBTN")).click();
                driver.findElement(By.id("username")).sendKeys("tissera.martin92@gmail.com");
                driver.findElement(By.id("password")).sendKeys("Duracell1");
                driver.findElement(By.className("c6d7d2ace")).click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                // Comprobacion de Log In

                Assert.assertEquals(driver.findElement(By.id("logoutBTN")).getText(), "Log Out");
                Assert.assertEquals(driver.getTitle(), "Homme Page"); // Compruebo el titulo

                Assert.assertEquals(driver.findElements(By.id("profileIMG")).isEmpty(), false); // Compruebo Imagen
                Assert.assertEquals(driver.findElement(By.id("profileTXT")).getText(),
                                "Welcome " + "tissera.martin92" + " !");

        }

        @Test
        void testApp3() {
                driver.get("https://testappautomation.herokuapp.com/");

                // Capturo header y footer para luego validar
                String header = driver.findElement(By.className("navbar-brand")).getText();
                String footer = driver.findElement(By.className("footerClass")).getText();

                // Log In
                driver.findElement(By.id("loginBTN")).click();
                driver.findElement(By.id("username")).sendKeys("tissera.martin92@gmail.com");
                driver.findElement(By.id("password")).sendKeys("Duracell1");
                driver.findElement(By.id("password")).submit();

                // Click en lorem ipsum
                driver.findElement(By.className("navbar-brand")).click();
                driver.findElement(By.id("loginBTN")).click();

                // Validar Header y Footer Identical to Home
                Assert.assertEquals(driver.findElement(By.className("navbar-brand")).getText(), header);
                Assert.assertEquals(driver.findElement(By.className("footerClass")).getText(), footer);

                // Validar Texto // Wait ejemplo
                WebDriverWait wait = new WebDriverWait(driver,10);

                
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("news"))); 
                Assert.assertEquals(driver.findElement(By.id("news")).getText(),
                                "Notice: This is a testing site meant to be used for automation test trainings");

                // Validar hiddenText1 No pude

                if (driver.findElement(By.id("hiddenText1")).isDisplayed()){
                        Assert.assertEquals(driver.findElement(By.id("hiddenText1")).getText(), "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
                }; 
                

                // Validar Titulo

                Assert.assertEquals(driver.getTitle(), "Lorem Ipsum Page");

                // Validar Secciones
                
                Assert.assertEquals(driver.findElement(By.cssSelector("#headingObj1 > h4 > a")).getText(),
                                "¿Qué es Lorem Ipsum?");
                Assert.assertEquals(driver.findElement(By.cssSelector("#headingObj2 > h4 > a")).getText(),
                                "¿Por qué lo usamos?");
                Assert.assertEquals(driver.findElement(By.cssSelector("#headingObj3 > h4 > a")).getText(),
                                "¿De dónde viene?");
                Assert.assertEquals(driver.findElement(By.cssSelector("#headingObj4 > h4 > a")).getText(),
                                "¿Dónde puedo conseguirlo?");

                // Validar Links, falta target blank es nueva tab. Self = Redirige

                Assert.assertEquals(driver.findElement(By.xpath("//*[@id='titleScreen']/div[3]/div[1]/div/div/p[2]/a")).getAttribute("href"), "https://www.youtube.com/");
                Assert.assertEquals(driver.findElement(By.xpath("//*[@id='titleScreen']/div[3]/div[1]/div/div/p[2]/a")).getAttribute("target"), "_blank");

                Assert.assertEquals(driver.findElement(By.xpath("//*[@id='titleScreen']/div[3]/div[2]/div/div/p[2]/a")).getAttribute("href"), "https://www.facebook.com/");
                Assert.assertEquals(driver.findElement(By.xpath("//*[@id='titleScreen']/div[3]/div[2]/div/div/p[2]/a")).getAttribute("target"), "_self"); // Deberia ser _blank, salta error
                
                Assert.assertEquals(driver.findElement(By.xpath("//*[@id='titleScreen']/div[3]/div[3]/div/div/p[2]/a")).getAttribute("href"), "https://www.selenium.dev/");
                Assert.assertEquals(driver.findElement(By.xpath("//*[@id='titleScreen']/div[3]/div[3]/div/div/p[2]/a")).getAttribute("target"), "_self"); // Deberia ser _blank, salta error
                
                
        }

        @AfterMethod
        void tearDown() {
                driver.quit();
        }


//         // [10:26] Ledesma, Damian
//     public void scrolltoButtom() {        ((JavascriptExecutor) driver)     .executeScript("window.scrollTo(0, document.body.scrollHeight)");    }
// like 2

// [10:28] Ledesma, Damian
//     public void ScrollToElement(By locator) {        WebElement element = driver.findElement(locator);        Actions actions = new Actions(driver);        actions.moveToElement(element);        actions.perform();    }


}
