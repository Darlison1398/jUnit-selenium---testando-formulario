import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Dsl;


public class TestMain {

    private WebDriver driver;

    private Dsl dsl;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("https://aplicacao-front-end.netlify.app/");
        dsl = new Dsl(driver);
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void test_verify_title() {
        dsl.tagNameAssert("h1", "Praticando Javascript");
    }

    @Test
    public void test_input() {

        dsl.input("nome", "Darlison Silva");
        dsl.input("idade", "25");
        dsl.input("salario", "3200");

    }

    @Test
    public void test_data_nascimento() {
        dsl.data("dataN", "1998-10-13");
    }

    @Test
    public void test_checkBox() {
        dsl.checkbox("formado");
    }

    @Test
    public void test_radio() {
        dsl.radio("masculino");
    }

    @Test
    public void test_select() {
        dsl.selec_option("listaFruta", "Manga");
    }


    @Test
    public void test_button_attention(){
        dsl.button("btn-attt");
        dsl.tempWait("box-modal-att");

        WebElement header = driver.findElement(By.className("modal-header"));
        WebElement btnClose = header.findElement(By.className("btn-close"));
        btnClose.click();

    }


    @Test
    public void test_button_aviso(){
        dsl.button("btn-attt-a");
        dsl.tempWait("box-modal-att-a");
        dsl.getSelectorCss("#box-modal-att-a .btn.btn-outline-dark");

    }


    @Test
    public void test_button_codigos(){
        dsl.getSelectorCss("button.btn.btn-primary[data-bs-toggle='offcanvas'][data-bs-target='#demo']");
        dsl.offCanva("demo", "show", "offcanvas-header", ".btn-close");

    }


    @Test
    public void test_button_mais() {
        dsl.button("btn-mais");
        dsl.tempWait("demo-box");

        WebElement header = driver.findElement(By.className("offcanvas-header"));
        WebElement closeBtn = header.findElement(By.className("btn-close"));
        closeBtn.click();

    }
}
