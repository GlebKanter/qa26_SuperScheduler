package com.presentation.scheduler.fw;


import com.presentation.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase {
    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void logIn(String email, String password) throws InterruptedException {
        clickByCss("[href='/login']");

        fillLoginForm(new User()
                .withEmail(email)
                .withPassword(password));
        pause(2000);
        clickByCss("[type=submit]");
    }


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


    public void clickLogoutButtonOnHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void logOut() {
        clickLogoutButtonOnHeader();
    }
}