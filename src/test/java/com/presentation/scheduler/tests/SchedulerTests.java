package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SchedulerTests extends TestBase {
    @BeforeMethod
    public void precondition() throws InterruptedException, IOException {
        app.start();
        app.getUserHelper().logIn(new User()
                .withEmail("user@mail.com")
                .withPassword("123456Aa"));
        app.getUserHelper().skipSettings();
        app.getUserHelper().pause(2000);
        String plusButton = "//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_main']";
        if (app.getUserHelper().isElementPresent(By.xpath(plusButton))) {
            app.getUserHelper().click(By.xpath(plusButton));
        }
    }

    @Test
    public void clickCreate() {

        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_start_event']")));
    }

    @Test
    public void createEventWithAddStartButton() {

app.getUserHelper().click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_add_event']"));
        app.getUserHelper().fillTitle("new Event");
        app.getUserHelper().clickType();
        app.getUserHelper().tapType("OfficeParty");


       // app.getUserHelper().changeTime();
        app.getUserHelper().addBreak(2);
        app.getUserHelper().addCost("28");
        app.getUserHelper().changeDay("17");
        app.getUserHelper().clickFinish();
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_main']")));
    }
@AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
}

}
