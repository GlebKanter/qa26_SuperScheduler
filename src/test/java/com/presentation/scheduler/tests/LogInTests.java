package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends TestBase{
    @Test
    public void testLogin(){
        app.getUserHelper().logIn(new User()
                .withEmail("user@mail.com")
                .withPassword("123456Aa"));
        app.getUserHelper().skipSettings();
        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());
    }

}
