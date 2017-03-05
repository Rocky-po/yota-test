package ru.tieto.test.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by rocky-po on 01.03.17.
 */
public class YotaPage {

    /*
    Define page elements
     */
    private By decreaseSlider       = By.xpath("/html/body/div/div[2]/div[2]/div[2]/a");
    private By increaseSlider       = By.xpath("/html/body/div/div[2]/div[2]/div[5]/a");
    private By newNumberOfSpeed     = By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div/div/div[2]/strong");
    private By newSpeed             = By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div/div/div[2]/span");
    private By newPrice             = By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div/div/div[3]/strong");
    private By currentNumberOfSpeed = By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/div/div/div[2]/strong");
    private By currentSpeed         = By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/div/div/div[2]/span");
    private By currentPrice         = By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/div/div/div[3]/strong");
    private By connectionButton     = By.xpath("/html/body/div/div[2]/div[3]/div[2]/div/div/div/a");
    private By balance              = By.xpath("/html/body/div/div[1]/div/dl/dd/span");
    private By topUpAmount          = By.xpath("/html/body/div/div[1]/div/div/div[1]/div[1]/div[1]/input");
    private By doPayment            = By.xpath("/html/body/div/div[1]/div/div/div[1]/div[2]/a[1]");
    private By doReset              = By.xpath("/html/body/div/div[1]/div/div/div[1]/div[2]/a[2]");

    private final WebDriver driver;

    public YotaPage(WebDriver driver) {
        this.driver = driver;
    }

    public YotaPage open (String url){
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public YotaPage decreaseSlider(){
        WebElement element = driver.findElement(decreaseSlider);
        javaScriptClick(element);
        return this;
    }

    public YotaPage increaseSlider() {
        WebElement element = driver.findElement(increaseSlider);
        javaScriptClick(element);
        return this;
    }

    public YotaPage checkNewNumberOfSpeed(String expectedNumber) {
        String getNewNumber = driver.findElement(newNumberOfSpeed).getText();
        if (!expectedNumber.equals(getNewNumber))
            Assert.fail("Число новой скорости не соответствует ожидаемому значению: ожидаем - " + expectedNumber + ", получаем - " + getNewNumber);
        return this;
    }

    public YotaPage checkNewSpeed(String expectedSpeed) {
        String getNewSpeed = driver.findElement(newSpeed).getText().trim();
        if (!expectedSpeed.equals(getNewSpeed))
            Assert.fail("Единица измерения новой скорости не соответствует ожидаемому значению: ожидаем - " + expectedSpeed + ", получили - " + getNewSpeed);
        return this;
    }

    public YotaPage checkNewPrice(String expectedPrice) {
        String getNewPrice = driver.findElement(newPrice).getText();
        if (!expectedPrice.equals(getNewPrice))
            Assert.fail("Новая стоимость несоответствует ожидаемому значению: ожидаем - " + expectedPrice + ", получили - " + getNewPrice);
        return this;
    }

    public YotaPage checkCurrentNumberOfSpeed(String expectedNumber) {
        String getCurNumber = driver.findElement(currentNumberOfSpeed).getText();
        if (!expectedNumber.equals(getCurNumber))
            Assert.fail("Число текущей скорости не соответствует ожидаемому значению: ожидаем - " + expectedNumber + ", получили - " + getCurNumber);
        return this;
    }

    public YotaPage checkCurrentSpeed(String expectedSpeed) {
        String getCurSpeed = driver.findElement(currentSpeed).getText();
        if (!expectedSpeed.equals(getCurSpeed))
            Assert.fail("Единица измерения текущей скорости не соответствует ожидаемому значению: ожидаем - " + expectedSpeed + ", получили - " + getCurSpeed);
        return this;
    }

    public YotaPage checkCurrentPrice(String expectedPrice) {
        String getCurPrice = driver.findElement(currentPrice).getText();
        if (!expectedPrice.equals(getCurPrice))
            Assert.fail("Текущая стоимость несоответствует ожидаемому значению: ожидаем - " + expectedPrice + ", получили - " + getCurPrice);
        return this;
    }

    public YotaPage connectionNewConditions(){
        driver.findElement(connectionButton).click();
        return this;
    }

    public YotaPage getBalance(String expectedBalance){
        String getBalance = driver.findElement(balance).getText();
        if (!expectedBalance.equals(getBalance))
            Assert.fail("Текущий баланс несоответствует ожидаемому значению: ожидаем - " + expectedBalance + ", получили - " + getBalance);
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

    public YotaPage close(){
        driver.quit();
        return this;
    }

    public YotaPage waitForReview() throws InterruptedException {
        Thread.sleep(1500);
        return this;
    }

    private YotaPage javaScriptClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", element);
        return this;
    }
}