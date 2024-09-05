package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Dsl {

    private WebDriver driver;

    public Dsl(WebDriver driver) {
        this.driver = driver;
    }

    public void tagNameAssert(String tagName, String tagText) {
        String titulo = driver.findElement(By.tagName(tagName)).getText();
        Assert.assertEquals(tagText, titulo);
    }

    public void input(String id_campo, String texto) {
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }

    public void data(String id, String texto_data) {
        driver.findElement(By.id(id)).sendKeys(texto_data);
    }

    public void button(String id_button){
        driver.findElement(By.id(id_button)).click();
    }

    public void checkbox(String id_checkBox) {
        driver.findElement(By.id(id_checkBox)).click();
    }

    public void radio(String id_radio) {
        driver.findElement(By.id(id_radio)).click();
    }

    public void selec_option(String id_option, String fruta) {
        WebElement selectElement = driver.findElement(By.id(id_option));
        Select select = new Select(selectElement);
        select.selectByValue(fruta);
    }

    public void tempWait(String id_element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_element)));
    }

    // Usa um seletor CSS para encontrar o botão de fechar
    public void getSelectorCss(String selector_css) {
        WebElement btn = driver.findElement(By.cssSelector(selector_css));
        btn.click();
    }

    public void offCanva(String id_element, String element_assert, String class_name, String css_selector){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement offcanvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_element)));
        assertTrue(offcanvas.getAttribute("class").contains(element_assert));
        WebElement header = offcanvas.findElement(By.className(class_name));
        WebElement close = header.findElement(By.cssSelector(css_selector));
        close.click();

    }
}
