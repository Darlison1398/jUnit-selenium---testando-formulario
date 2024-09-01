import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestMain {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://aplicacao-front-end.netlify.app/");
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void test_verify_title() {
        String titulo =  driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Praticando Javascript", titulo);
    }

    @Test
    public void test_input() {
        driver.findElement(By.id("nome")).sendKeys("Darlison Silva");
        driver.findElement(By.id("idade")).sendKeys("25");
        driver.findElement(By.id("salario")).sendKeys("2500");
    }

    @Test
    public void test_data_nascimento() {
        driver.findElement(By.id("dataN")).sendKeys("1998-10-13");
    }

    @Test
    public void test_checkBox() {
        driver.findElement(By.id("formado")).click();
    }

    @Test
    public void test_radio() {
        driver.findElement(By.id("masculino")).click();
    }

    @Test
    public void test_select() {
        WebElement selectElement = driver.findElement(By.id("listaFruta"));
        Select select = new Select(selectElement);
        select.selectByValue("Manga");

    }


//    @Test
//    public void test_button_attention(){
//        driver.findElement(By.id("btn-attt")).click();
//
//        driver.switchTo().window("modal-open");
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-open")));
//
//        driver.findElement(By.className("btn.btn-outline-dark")).click();
//
//        //driver.switchTo().window("modal-open");
//        //WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-close")));
//        //closeButton.click();
//       // driver.getWindowHandle();
//    }
}
