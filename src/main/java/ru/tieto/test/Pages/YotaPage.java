package ru.tieto.test.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rocky-po on 01.03.17.
 */
public class YotaPage {

    /*
    Define page elements
     */
    private By decreaseSlider       = By.className("decrease");
    private By increaseSlider       = By.className("increase");
    private By newNumberOfSpeed     = By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div/div/div[1]/strong");
    private By newSpeed             = By.id("");
    private By newPrice             = By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div/div/div[3]/strong");
    private By currentNumberOfSpeed = By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/div/div/div[2]/strong");
    private By currentSpeed         = By.xpath("");
    private By currentPrice         = By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/div/div/div[3]/strong");
    private By connectionButton     = By.linkText("Подключить");
    private By balance              = By.xpath("/html/body/div/div[1]/div/dl/dd/span");
    private By topUpAmount          = By.id("amount");
    private By doPayment            = By.linkText("Пополнить счет");
    private By doReset              = By.linkText("Сброс");

    private final WebDriver driver;

    public YotaPage(WebDriver driver) {
        this.driver = driver;
    }

    public YotaPage decreaseSlider(){
        driver.findElement(decreaseSlider).click();
        return this;
    }

    public YotaPage increaseSlider(){
        driver.findElement(increaseSlider).click();
        return this;
    }

    public YotaPage checkNewNumberOfSpeed(String expectedNumber){
        if (!expectedNumber.equals(driver.findElement(newNumberOfSpeed).getText()))
            Assert.fail("Число новой скорости не соответствует ожидаемому значению");
        return this;
    }

    public YotaPage checkNewSpeed(String expectedSpeed){
        if (!expectedSpeed.equals(driver.findElement(newSpeed).getText()))
            Assert.fail("Единица измерения новой скорости не соответствует ожидаемому значению");
        return this;
    }

    public YotaPage checkNewPrice(String expectedPrice){
        if (!expectedPrice.equals(driver.findElement(newPrice).getText()))
            Assert.fail("Новая стоимость несоответствует ожидаемому значению");
        return this;
    }

    public YotaPage checkCurrentNumberOfSpeed(String expectedNumber){
        if (!expectedNumber.equals(driver.findElement(currentNumberOfSpeed).getText()))
            Assert.fail("Число текущей скорости не соответствует ожидаемому значению");
        return this;
    }

    public YotaPage checkCurrentSpeed(String expectedSpeed){
        if (!expectedSpeed.equals(driver.findElement(currentSpeed).getText()))
            Assert.fail("Единица измерения текущей скорости не соответствует ожидаемому значению");
        return this;
    }

    public YotaPage checkCurrentPrice(String expectedPrice){
        if (!expectedPrice.equals(driver.findElement(currentPrice).getText()))
            Assert.fail("Текущая стоимость несоответствует ожидаемому значению");
        return this;
    }

    public YotaPage connectionNewConditions(){
        driver.findElement(connectionButton).click();
        return this;
    }

    public YotaPage getBalance(String expectedBalance){
        if (!expectedBalance.equals(driver.findElement(balance).getText()))
            Assert.fail("Текущий баланс несоответствует ожидаемому значению");
        return this;
    }

    public YotaPage setBalance(String balance){
        driver.findElement(topUpAmount).clear();
        driver.findElement(topUpAmount).sendKeys(balance);
        return this;
    }

    public YotaPage doPayment(){
        driver.findElement(doPayment).click();
        return this;
    }

    public YotaPage connectionButtonDisabled(){
        if (!"btn disabled".equals(driver.findElement(connectionButton).getAttribute("class")))
            Assert.fail("Кнопка подключить - активна, хотя должна быть неактивна");
        return this;
    }

    public YotaPage doReset(){
        driver.findElement(doReset).click();
        return this;
    }


}
