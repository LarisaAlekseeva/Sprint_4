import ru.praktikum.services.qa.scooter.pageobject.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPageTest {
    private WebDriver driver;
    private String expected = "Заказ оформлен";

    @Test
    public void orderClickUpOrderButton() {
        driver = new ChromeDriver();
        HomePage object = new HomePage(driver);
        FirstOrderPage user = new FirstOrderPage(driver);
        SecondOrderPage rent = new SecondOrderPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        object.clickUpOrderButton();
        user.enterFirstOrderPage("Петр", "Петров", "Люблинская", "Преображенская площадь", "79267654321");
        rent.enterSecondOrderPageColourBlack("15.02.2024", "четверо суток", "привет");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3")));
        String result = driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")).getText();
        Assert.assertTrue("Заказ не оформлен", result.contains(expected));
    }

    @Test
    public void orderClickDownOrderButton() {
        driver = new ChromeDriver();
        HomePage object = new HomePage(driver);
        FirstOrderPage user = new FirstOrderPage(driver);
        SecondOrderPage rent = new SecondOrderPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        object.clickButtonCookie();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(object.getDownOrderButton()));
        object.clickDownOrderButton();
        user.enterFirstOrderPage("Иван", "Иванов", "улица Черкизовская, д 1, кв.1", "Черкизовская", "79261234567");
        rent.enterSecondOrderPageColourGrey("27.01.2024", "двое суток", "позвоните за час");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3")));
        String result = driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")).getText();
        Assert.assertTrue("Заказ не оформлен", result.contains(expected));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}