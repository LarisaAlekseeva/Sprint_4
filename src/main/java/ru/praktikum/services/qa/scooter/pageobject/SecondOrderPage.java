package ru.praktikum.services.qa.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {
    private WebDriver driver;
    // поле ввода Когда привезти самокат
    private By whenDeliveryScooter = By.cssSelector("[placeholder = '* Когда привезти самокат']");
    // поле Срок аренды
    private By periodRent = By.className("Dropdown-placeholder");
    // выбор цвета самоката чёрный жемчуг
    private By colourScooterBlack = By.id("black");
    // выбор цвета самоката серая безысходность
    private By colourScooterGray = By.id("grey");
    // поле ввода комментария
    private By userComment = By.cssSelector("[placeholder = 'Комментарий для курьера']");
    // кнопка Заказать
    private By buttonOrder = By.xpath(".//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    // кнопка Да
    private By buttonYes = By.xpath(".//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterWhenDeliveryScooter(String date) {
        driver.findElement(whenDeliveryScooter).sendKeys(date);
        driver.findElement(By.xpath(String.format(".//*[contains(@class, 'react-datepicker__day') and (text() = '%s')]", date.split("\\.")[0]))).click();
    }
    public void clickRentTime(String quantityDays) {
        driver.findElement(periodRent).click();
        driver.findElement(By.xpath(String.format(".//*[text() = '%s']", quantityDays))).click();
    }
    public void clickButtonColourScooterBlack() {
        driver.findElement(colourScooterBlack).click();
    }
    public void clickButtonColourScooterGray() {
        driver.findElement(colourScooterGray).click();
    }
    public void enterDateOfUserComment(String comment) {
        driver.findElement(userComment).sendKeys(comment);
    }
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }
    public void enterSecondOrderPageColourBlack(String date, String quantityDays, String comment) {
        enterWhenDeliveryScooter(date);
        clickRentTime(quantityDays);
        clickButtonColourScooterBlack();
        enterDateOfUserComment(comment);
        clickButtonOrder();
        clickButtonYes();
    }
    public void enterSecondOrderPageColourGrey(String date, String quantityDays, String comment) {
        enterWhenDeliveryScooter(date);
        clickRentTime(quantityDays);
        clickButtonColourScooterGray();
        enterDateOfUserComment(comment);
        clickButtonOrder();
        clickButtonYes();
    }
}
