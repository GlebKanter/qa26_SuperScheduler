package com.presentation.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class EventHelper extends HelperBase{

    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public void initCreationNew() {

    }
     public void killEvents(){

        while(driver.findElements(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/row_container_main']")).size()>0) {
            System.out.println(driver.findElements(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/row_container_main']")).size());
           click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/row_container_main']"));
        click(By.xpath("//*[@resource-id = 'com.example.svetlana.scheduler:id/delete_menu']"));
        }
    }
}




