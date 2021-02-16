package com.presentation.scheduler.fw;

import com.google.common.io.Files;

import com.presentation.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


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

        System.out.println("I can fill fild1 ->" + user.getEmail());
        System.out.println("I can fill fild2 ->" + user.getPassword());
    }

    public void clickByCss(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }



    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickForgotPassword() {
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
        selectElem.sendKeys(Keys.ENTER);
        scrollDown();
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
        By locator = (By.cssSelector("input[placeholder='Email']"));
        click(locator);
        type(locator, email);


    }

    public void clickRestore() {
        clickByCss("input[value='Restore']");
    }

    public void tapAdd() {
        click(By.id("com.example.svetlana.scheduler:id/fab_add_event"));
    }

    public void fillTitle(String title) {
    //    type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']"),title);
        MobileElement element = (MobileElement) driver.findElementByXPath("//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']");
        element.setValue(title);
    }

    public void clickType() {

         click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_type_input']"));
    }

    public void tapType(String text) {
//        type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']"),text);
        MobileElement element = (MobileElement) driver.findElementByXPath("//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']");
        element.setValue(text);
        driver.hideKeyboard();
    }



    public void changeTime() {

        click(By.xpath("//[@resource-id = 'com.example.svetlana.scheduler:id/info_main_container']"));
        click(By.xpath("//*[@text = '9']"));
        click(By.xpath("//*[@text = '20']"));

        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_tp_date_to_txt']"));
        click(By.xpath("//*[@text = '22']"));
        click(By.xpath("//*[@text = '30']"));

        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_timePicker_ok_btn']"));
    }

    public void addBreak(int breaks) {

        if (breaks > 0) {
            for (int i = 0; i <= breaks - 1; i++) {

               click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_break_plus_btn']"));
            }
        }

        //click(By.xpath("//*[@text = 'Delete break']"));//delete break
    }
    public void dellBreak(int breaks) {

        if (breaks > 0) {
            for (int i = 0; i <= breaks - 1; i++) {

                click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_break_minus_btn']"));
            }
        }


    }



    public void moveElementToLeft(By locator) {
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();

        int leftPoint = (int) (size.width * 0.2);
        int rightPoint = (int) (size.width * 0.8);
        int middlePoint = (int) (size.width * 0.5);

        WebElement element = driver.findElement(locator);

        //points of element
        int leftX = (int) (element.getLocation().getX() * 0.2);
        int upperY = (int) (element.getLocation().getY());
        int rightX = (int) ((leftX + element.getSize().getWidth()) * 0.8);
        int lowerY = (int) ((upperY + element.getSize().getHeight()));
        int middleY = (upperY + lowerY) / 2;

        action
                .longPress(PointOption.point(middlePoint, middleY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(rightX, middleY))
                .release()//prervat deistvie, tut longPress
                .perform();//command apply action

    }

    public void selectNextDay() {
        moveElementToLeft(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/date_container_layout']"));
    }

    public void clickFinish() {

        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_save_btn']"));//click ADD
    }
}

