/**
 * Это класс с тестами
 *
 * @version 04.04.2020
 * @author Pukin Alexey
 */

public class Test {

    @org.junit.Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver1\\chromedriver.exe");

        Driver driver = new Driver();

        driver.testYandex();

    }

}
