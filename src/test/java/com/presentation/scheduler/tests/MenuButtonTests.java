package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class MenuButtonTests extends TestBase {
    @BeforeMethod
    public void precondition() throws InterruptedException {
        app.getUserHelper().logIn(new User()
                .withEmail("user@mail.com")
                .withPassword("123456Aa"));
        app.getUserHelper().skipSettings();
        app.getUserHelper().clickMenuButton();
        app.getUserHelper().pause(2000);

    }

    @Test(priority = 0)
    public void isMenuButtonClickable() {

        Assert.assertTrue(app.getUserHelper().isMenuAvailable());
    }

    @Test (priority = 1)//(enabled = false)
    public void isEventListButtonClickable() {
        app.getUserHelper().clickEventList();
        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());
    }

    @Test (priority = 2)
    public void isCreateScheduleClickable(){
        app.getUserHelper().clickCreateSchedulerButton();
        Assert.assertTrue(app.getUserHelper().isScheduleCreate());
    }

    @Test (priority = 3)
    public void isDrivingCostsClickable(){
        app.getUserHelper().clickDrivingCosts();
        Assert.assertTrue(app.getUserHelper().isDriveCostsClickable());
    }

    @AfterMethod
    public void tearDown() {
        if (!app.getUserHelper().isMenuAvailable()) {
            app.getUserHelper().clickMenuButton();
        }
        app.getUserHelper().clickLogoutButton();

    }
}
