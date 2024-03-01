package ru.praktikum.services.qa.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    // кнопка куки
    private By buttonCookie = By.id("rcc-confirm-button");
    // вопросы
    private By listQuestion = By.className("accordion__item");
    // ответы
    private By listAnswer = By.xpath(".//div[@class = 'accordion__panel']");
    // верхняя кнопка Заказать
    private By upOrderButton = By.className("Button_Button__ra12g");
    // нижняя кнопка Заказать
    private By downOrderButton = By.className("Home_FinishButton__1_cWm");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickButtonCookie(){
        driver.findElement(buttonCookie).click();
    }
    public void clickListQuestion(int number){
        List<WebElement> elements = driver.findElements(listQuestion);
        elements.get(number).click();
    }
    public String getTextOfListAnswer(int number){
        return driver.findElements(listAnswer).get(number).getText();
    }
    public By getDownOrderButton() {
        return downOrderButton;
    }
    public void clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
    }
    public void clickDownOrderButton() {
        driver.findElement(downOrderButton).click();
    }
   }
