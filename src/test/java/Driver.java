import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Этот класс описывает функциональность драйвера
 *
 * @version 04.04.2020
 * @author Pukin Alexey
 */

public class Driver {

    @FindBy(id = "fakeArea")
    WebElement english;

    @FindBy(id = "translation")
    WebElement france;

    public void testYandex() {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://translate.yandex.ru/?lang=en-fr");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement english = driver.findElementById("fakeArea");
        english.click();
        english.sendKeys("My name is Alexey"); // ввод текста в окно

        WebElement france = driver.findElementById("translation");

        final Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(france)); // ждём перевода

        String otvet = france.getText(); // получаем текст перевода
        Assert.assertEquals("Mon nom est Alexey", otvet); // сравниваем с ожидаемым значением

        driver.close();

    }

}
