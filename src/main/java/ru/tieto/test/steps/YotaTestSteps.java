package ru.tieto.test.steps;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.tieto.test.Pages.YotaPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

public class YotaTestSteps {

    Process process;
    YotaPage yotaPage;

    @BeforeStories
    public void startProject() throws IOException, InterruptedException {
        process = Runtime.getRuntime().exec("java -jar ./test-slider-1.0.0-SNAPSHOT.jar");
    }

    @BeforeStory
    @Step("I am a pending step")
    public void setup(){
        String url = "http://localhost:4567/index.html";
        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("marionette", true);
        yotaPage = new YotaPage( new ChromeDriver() );
        yotaPage.open(url);
    }

    @Given("I am on yota page")
    @Step("I am on yota page")
    public void checkPage(){
        yotaPage.checkPage();
    }

    @Given("I see that new speed is <defaultNewNumber> of <defaultNewSpeed>")
    @Step("start with show new speed")
    public void checkDefaultNewSpeed(@Named("defaultNewNumber") String number, @Named("defaultNewSpeed") String speed) {
        yotaPage.checkNewNumberOfSpeed(number);
        yotaPage.checkNewSpeed(speed);
    }

    @Given("I see that new price is <defaultNewPrice>")
    @Step("start with show new price")
    public void checkDefaultNewPrice(@Named("defaultNewPrice") String price) {
        yotaPage.checkNewPrice(price);
    }

    @When("I click increase button")
    @Step("Increase slider")
    public void increaseSlider() {
        yotaPage.increaseSlider();
    }

    @Then("I see that new speed is <newNumber> of <newSpeed>")
    @Step("show result new speed")
    public void checkNewSpeed(@Named("newNumber") String number, @Named("newSpeed") String speed) {
        yotaPage.checkNewNumberOfSpeed(number);
        yotaPage.checkNewSpeed(speed);
    }

    @Then("I see that new price is <newPrice>")
    @Step("show result new price")
    public void checkNewPrice(@Named("newPrice") String price) {
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

    @Given("I see default current <defaultCurNumber> of <defaultCurSpeed>")
    @Step("Default current conditions of speed")
    public void checkDefaultCurrentSpees(@Named("defaultCurNumber") String defaultNumber, @Named("defaultCurSpeed") String defaultSpeed) {
        yotaPage.checkCurrentNumberOfSpeed(defaultNumber);
        yotaPage.checkCurrentSpeed(defaultSpeed);
    }

    @Given("I see default current <defaultCurPrice>")
    @Step("Default current conditions of price")
    public void checkDefaultPrice(@Named("defaultCurPrice") String defaultPrice) {
        yotaPage.checkCurrentPrice(defaultPrice);
    }

    @When("I click connection button")
    @Step("Connection conditions")
    public void connectionNewConditions(){
        yotaPage.connectionNewConditions();
    }

    @Then("I see current <curNumber> of <curSpeed>")
    @Step("current conditions of speed")
    public void checkCurrentSpeed(@Named("curNumber") String number, @Named("curSpeed") String speed) {
        yotaPage.checkCurrentNumberOfSpeed(number);
        yotaPage.checkCurrentSpeed(speed);
    }

    @Then("I see current <curPrice>")
    @Step("current conditions of price")
    public void checkPrice(@Named("curPrice") String price) {
        yotaPage.checkCurrentPrice(price);
    }

    @Then("I see that connection button is disables")
    @Step("Connection Button is disabled")
    public void disabledConnectionButton(){
        yotaPage.connectionButtonDisabled();
    }

    @Then("I see that connection button is enable")
    @Step("Connection Button is enabled")
    public void enablesConnectionButton(){
        yotaPage.connectionButtonEnabled();
    }

    @When("I click reset button")
    @Then("I click reset button")
    @Step("click reset button")
    public void clickResetButton(){
        yotaPage.doReset();
    }

    @Then("I see that balance is not less than zero")
    @Step("balance can not be less then zero")
    public void checkThatBalanceAboveZero(){
        yotaPage.checkThatBalanceAboveZero();
    }

    @When("I wait changes")
    public void waitForReview() throws InterruptedException {
        yotaPage.waitForReview();
    }

    @AfterStory
    public void closeWindow() throws InterruptedException {
        yotaPage.doReset();
        yotaPage.waitForReview();
        yotaPage.close();
    }

    @AfterStories
    public void closeConnection(){
        process.destroy();
        boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
        try {
            if (isDebug)
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
