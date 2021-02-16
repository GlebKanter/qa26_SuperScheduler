package com.presentation.scheduler.fw;


import com.presentation.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

//    public void logIn(String email, String password) throws InterruptedException {
//        clickByCss("[href='/login']");
//
//        fillLoginForm(new User()
//                .withEmail(email)
//                .withPassword(password));
//        pause(2000);
//        clickByCss("[type=submit]");
//    }


    public boolean isRegistrationFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(., 'Registration')]"));
    }

    public void clickLogInButton() {
        clickByCss("[href='/login']");
    }


    public void selectCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("first_name"), user.getfName());
        type(By.cssSelector("#second_name"), user.getlName());

        System.out.println("email is: " + user.getEmail());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }


    public void fillLoginForm(User user) {

        driver.findElement(By.cssSelector("[name=email]")).clear();
        typeByCss("[name=email]", user.getEmail());
        driver.findElement(By.cssSelector("[name=password]")).clear();
        typeByCss("[name=password]", user.getPassword());
    }

    public void clickAddButton() {
        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/long_term_fr_save_btn']"));
    }

    public boolean isScheduleCreate() {
        String addButton = "//*[@resource-id = 'com.example.svetlana.scheduler:id/long_term_fr_save_btn']";
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(addButton)));
        return isElementPresent(By.xpath(addButton));
    }

    public void clickLogoutButton() {

        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/nav_fr_logout']"));
    }

    public boolean isUserLoggedIn() {

        String plusButton = "//android.widget.ImageButton[@content-desc='Open']";
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(plusButton)));
        return isElementPresent(By.xpath(plusButton));
    }

    public void logOut() {
        clickMenuButton();
        clickLogoutButton();
    }

    public void logIn(User user) {
        type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']"), user.getEmail());
        type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']"), user.getPassword());
        driver.hideKeyboard();
        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/login_btn']"));

    }

    public void skipSettings() {

        String skipButton = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip_container']";
        if (isElementPresent(By.xpath(skipButton))) {
            click(By.xpath(skipButton));
        }
    }

    public void clickMenuButton() {
        click(By.xpath("//android.widget.ImageButton[@content-desc='Open']"));
    }

    public void clickEventList() {
        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/nav_fr_event_list']"));
    }

    public boolean isMenuAvailable() {
        MobileElement element = (MobileElement) driver.findElementByAccessibilityId("Close");
        return element != null;
    }

    public void clickCreateSchedulerButton() {
        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/nav_fr_schedule']"));
    }

    public boolean isDriveCostsClickable() {
        return isElementPresent(By.xpath("//*[@text = 'DRIVING COSTS']"));
    }

    public void clickDrivingCosts() {
        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/nav_fr_driving']"));
    }

    public boolean isEventsAvailable() {
        MobileElement element = (MobileElement) driver.findElementByXPath("//*[@text='DATE']");
        return element != null;
    }

    public void changeDay(String date) {
        selectNextDay();
    }

    public void addCost(String cost) {
        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_wage_edit']"));

        type((By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")),cost);               //String.valueOf(event.getAmmount()));

        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/info_wage_save']"));


    }
}

