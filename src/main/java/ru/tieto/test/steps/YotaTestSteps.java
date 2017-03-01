package ru.tieto.test.steps;

import org.jbehave.core.annotations.*;
import org.junit.Test;
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

    @Given("I see that current speed is <number> of <speed>")
    @Step("start with show current speed")
    public void startCheckCurrentSpeed(@Named("number") String number, @Named("speed") String speed){
        yotaPage.checkCurrentNumberOfSpeed(number);
        yotaPage.checkCurrentSpeed(speed);
    }

    @Given("I see that current price is <price>")
    @Step("start with show current price")
    public void startCheckCurrentPrice(@Named("price") String price){
        yotaPage.checkCurrentPrice(price);
    }

    @Given("I see that new speed is <number> of <speed>")
    @Then("I see that new speed is <number> of <speed>")
    @Step("start with show new speed")
    public void checkNewSpeed(@Named("number") String number, @Named("speed") String speed){
        yotaPage.checkNewNumberOfSpeed(number);
        yotaPage.checkNewSpeed(speed);
    }

    @Given("I see that new price is <price>")
    @Then("I see that new price is <price>")
    @Step("start with show new price")
    public void checkNewtPrice(@Named("price") String price){
        yotaPage.checkNewPrice(price);
    }

    @When("I click increase button")
    @Step("Increase slider")
    public void increaseSlider(){
        yotaPage.increaseSlider();
    }

    @When("I click decrease button")
    public void decreaseButton(){
        yotaPage.decreaseSlider();
    }

    @Given("I see that balance is <defaultBalance>")
    @Step("check current balabce")
    public void checkCu

    @AfterScenario
    public void defaultState(){
        yotaPage.doReset();
    }

    @AfterStory
    public void closeWindow(){
        driver.close();
    }


}
