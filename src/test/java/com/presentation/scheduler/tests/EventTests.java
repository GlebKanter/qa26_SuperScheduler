package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class EventTests extends TestBase {
    @BeforeMethod
    public void precondition() throws InterruptedException, IOException {
        app.start();
        app.getUserHelper().logIn(new User()
                .withEmail("user@mail.com")
                .withPassword("123456Aa"));
        app.getUserHelper().skipSettings();
        app.getUserHelper().pause(2000);
    }

    @Test
    public void delAllEvents() {

        app.event().killEvents();
    }


}
