package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;

public class MenuButtonTests extends TestBase {


    @BeforeMethod
    public void precondition() throws InterruptedException, IOException {
        app.start();
        app.getUserHelper().logIn(new User()
                .withEmail("user@mail.com")
                .withPassword("123456Aa"));
        app.getUserHelper().skipSettings();
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickMenuButton();


    }

    @Test(priority = 0)
    public void isMenuButtonClickable() {

        Assert.assertTrue(app.getUserHelper().isMenuAvailable());
    }

    @Test(priority = 1)//(enabled = false)
    public void isEventListButtonClickable() {

        app.getUserHelper().clickEventList();
        Assert.assertTrue(app.getUserHelper().isEventsAvailable());
    }

    @Test(priority = 2)
    public void isCreateScheduleClickable() {

        app.getUserHelper().clickCreateSchedulerButton();
        Assert.assertTrue(app.getUserHelper().isScheduleCreate());
    }

    @Test(priority = 3)
    public void isDrivingCostsClickable() throws InterruptedException {

        app.getUserHelper().clickDrivingCosts();
        Assert.assertTrue(app.getUserHelper().isDriveCostsClickable());
    }

    @AfterMethod//(enabled = false)
    public void tearDown() throws IOException {

        if (!app.getUserHelper().isMenuAvailable()) {
            app.getUserHelper().clickMenuButton();
        }
        app.getUserHelper().clickLogoutButton();
        app.stop();

    }
}
