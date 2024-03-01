package ru.praktikum.services.qa.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage {
    private WebDriver driver;
    // поле ввода Имя
    private By userName = By.cssSelector("[placeholder = '* Имя']");
    // поле ввода Фамилия
    private By userSurname = By.cssSelector("[placeholder = '* Фамилия']");
    // поле ввода Адрес доставки
    private By deliveryAddress = By.cssSelector("[placeholder = '* Адрес: куда привезти заказ']");
    //станция метро
    private By metroStation = By.className("select-search__input");
    // поле ввода Телефон
    private By phoneNumber = By.cssSelector("[placeholder = '* Телефон: на него позвонит курьер']");
    // кнопка Далее
    private By buttonFurther = By.cssSelector("[class= 'Button_Button__ra12g Button_Middle__1CSJM']");

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String name) {
        driver.findElement(userName).sendKeys(name);
    }
    public void enterUserSurname(String surName) {
        driver.findElement(userSurname).sendKeys(surName);
    }
    public void enterDeliveryAddress(String userDeliveryAddress) {
        driver.findElement(deliveryAddress).sendKeys(userDeliveryAddress);
    }
    public void selectMetroStation(String station) {
        driver.findElement(metroStation).click();
        driver.findElement(By.xpath(String.format(".//*[text() = '%s']", station))).click();
    }
    public void enterPhoneNumber(String userPhoneNumber) {
        driver.findElement(phoneNumber).sendKeys(userPhoneNumber);
    }
    public void clickButtonFurther() {
        driver.findElement(buttonFurther).click();
    }
    public void enterFirstOrderPage(String name, String surName, String userDeliveryAddress, String station, String userPhoneNumber) {
        enterUserName(name);
        enterUserSurname(surName);
        enterDeliveryAddress(userDeliveryAddress);
        selectMetroStation(station);
        enterPhoneNumber(userPhoneNumber);
        clickButtonFurther();
    }
}
