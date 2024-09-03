import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

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


    @Test
    public void test_button_attention(){
        driver.findElement(By.id("btn-attt")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box-modal-att")));

        WebElement header = driver.findElement(By.className("modal-header"));
        WebElement btnClose = header.findElement(By.className("btn-close"));
        btnClose.click();

    }


    @Test
    public void test_button_aviso(){
        driver.findElement(By.id("btn-attt-a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box-modal-att-a")));

        // Usa um seletor CSS para encontrar o botão de fechar
        WebElement btnClose = driver.findElement(By.cssSelector("#box-modal-att-a .btn.btn-outline-dark"));

        // Espera até que o botão esteja clicável e então o clica
        wait.until(ExpectedConditions.elementToBeClickable(btnClose)).click();

    }


    @Test
    public void test_button_codigos(){
        WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary[data-bs-toggle='offcanvas'][data-bs-target='#demo']"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement offcanvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));

        assertTrue(offcanvas.getAttribute("class").contains("show"));

        WebElement header = offcanvas.findElement(By.className("offcanvas-header"));
        WebElement close = header.findElement(By.cssSelector(".btn-close"));
        close.click();

    }


    @Test
    public void test_button_mais() {
        driver.findElement(By.id("btn-mais")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo-box")));

        //driver.findElement(By.id("page")).click();

        WebElement header = driver.findElement(By.className("offcanvas-header"));
        WebElement closeBtn = header.findElement(By.className("btn-close"));
        closeBtn.click();

    }
}
