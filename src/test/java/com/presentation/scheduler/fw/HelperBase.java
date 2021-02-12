package com.presentation.scheduler.fw;

import com.google.common.io.Files;

import com.presentation.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;


public class HelperBase {
    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void typeByCss(String cssSelector, String text) {
        if (text != null) {
            clickByCss(cssSelector);
            driver.findElement(By.cssSelector(cssSelector)).clear();
            driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
        }

    }

    public void attachPhoto(By locator, File file) throws IOException, InterruptedException {
        if (file != null) {
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
            System.out.println("Photo=done!");
            pause(5000);
            click(By.cssSelector("input[value='Submit']"));
        }
    }
    public void type(User user) {

        System.out.println("I can fill fild1 ->"+user.getEmail());
        System.out.println("I can fill fild2 ->"+user.getPassword());
    }
    public void clickByCss(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickForgotPassword(){
click(By.xpath("//span[normalize-space()='Click here']"));
    }
    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void selectElement(By locator) {
        WebElement selectElem = driver.findElement(locator);
        selectElem.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            selectElem.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            selectElem.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
    }

    public void typeFromTillDate(String fromDate, String tillDate) {
        WebElement selectElem = driver.findElement(By.xpath("//input[@placeholder='From']"));
        selectElement(By.xpath("//input[@placeholder='From']"));
        selectElem.sendKeys(fromDate);
        selectElem.sendKeys(Keys.ENTER);scrollDown();
        selectElem = driver.findElement(By.xpath("//input[@placeholder='Till']"));
        selectElement(By.xpath("//input[@placeholder='Till']"));
        selectElem.sendKeys(tillDate);
        selectElem.sendKeys(Keys.ENTER);

    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(300,0)");
    }

    public void clickYallaButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public void takeScreenshot(String pathToFile) throws IOException {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot =
                new File(pathToFile);
        Files.copy(tmp, screenshot);
    }

    public void fillEmail(String email) {
      By locator = (By.cssSelector("input[placeholder='Email']")) ;
      click(locator);
        type(locator, email);


    }

    public void clickRestore() {
        clickByCss("input[value='Restore']");
    }
}
