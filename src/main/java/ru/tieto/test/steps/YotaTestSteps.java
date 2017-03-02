package ru.tieto.test.steps;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.tieto.test.Pages.YotaPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.IOException;

public class YotaTestSteps {

    WebDriver driver;
    YotaPage yotaPage;

    @BeforeScenario
    public void startProject() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "test-slider-1.0.0-SNAPSHOT.jar");
        processBuilder.directory(new File("./"));
        processBuilder.start();
        Thread.sleep(5000);
    }

    @BeforeStory
    @Step("I am a pending step")
    public void setup(){
        String url = "http://localhost:4567/index.html";
        System.setProperty("webdriver.gecko.driver", "./geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @Given("I see that new speed is <defaultNumber> of <defaultSpeed>")
    @Step("start with show new speed")
    public void checkDefaultNewSpeed(@Named("defaultNumber") String number, @Named("defaultSpeed") String speed){
        yotaPage.checkNewNumberOfSpeed(number);
        yotaPage.checkNewSpeed(speed);
    }

    @Given("I see that new price is <defaultPrice>")
    @Step("start with show new price")
    public void checkDefaultNewPrice(@Named("defaultPrice") String price){
        yotaPage.checkNewPrice(price);
    }

    @When("I click increase button")
    @Step("Increase slider")
    public void increaseSlider(){
        yotaPage.increaseSlider();
    }

    @Then("I see that new speed is <number> of <speed>")
    @Step("show result new speed")
    public void checkNewSpeed(@Named("number") String number, @Named("speed") String speed){
        yotaPage.checkNewNumberOfSpeed(number);
        yotaPage.checkNewSpeed(speed);
    }

    @Then("I see that new price is <price>")
    @Step("show result new price")
    public void checkNewPrice(@Named("price") String price){
        yotaPage.checkNewPrice(price);
    }

    @When("I click decrease button")
    @Step("Decrease slider")
    public void decreaseButton(){
        yotaPage.decreaseSlider();
    }

    @Given("I see that balance is <defaultBalance>")
    @Step("check default balance")
    public void checkDefaultBalance(@Named("defaultBalance") String defaultBalance){
        yotaPage.getBalance(defaultBalance);
    }

    @When("I add <payNumber> of money")
    @Step("Input money")
    public void inputMoney(@Named("payNumber") String number){
        yotaPage.setBalance(number);
    }

    @When("I click top up balance")
    @Step("Click add money")
    public void clickAddBalance(){
        yotaPage.doPayment();
    }

    @Then("I see that balance is <balance>")
    @Step("Check balance")
    public void checkBalance(@Named("balance") String balance){
        yotaPage.getBalance(balance);
    }

    @Given("I see default current <defaultNumber> of <defaultSpeed>")
    @Step("Default current conditions of speed")
    public void checkDefaultCurrentSpees(@Named("defaultNumber") String defaultNumber, @Named("defaultSpeed") String defaultSpeed){
        yotaPage.checkCurrentNumberOfSpeed(defaultNumber);
        yotaPage.checkCurrentSpeed(defaultSpeed);
    }

    @Given("I see default current <defaultPrice>")
    @Step("Default current conditions of price")
    public void checkDefaultPrice(@Named("defaultPrice") String defaultPrice){
        yotaPage.checkCurrentPrice(defaultPrice);
    }

    @When("I click connection button")
    @Step("Connection conditions")
    public void connectionNewConditions(){
        yotaPage.connectionNewConditions();
    }

    @Then("I see current <number> of <speed>")
    @Step("current conditions of speed")
    public void checkCurrentSpees(@Named("number") String number, @Named("speed") String speed){
        yotaPage.checkCurrentNumberOfSpeed(number);
        yotaPage.checkCurrentSpeed(speed);
    }

    @Then("I see current <price>")
    @Step("current conditions of price")
    public void checkPrice(@Named("price") String price){
        yotaPage.checkCurrentPrice(price);
    }

    @Then("I see that connection button is disables")
    @Step("Connection Button is disabled")
    public void disabledConnectionButton(){
        yotaPage.connectionButtonDisabled();
    }

    @AfterScenario
    public void defaultState(){
        yotaPage.doReset();
    }

    @AfterStory
    public void closeWindow(){
        driver.close();
    }


}
