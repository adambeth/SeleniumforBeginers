package com.adam.theinternet.loginTest;

import com.adam.workers.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class positiveTest {

    private WebDriver driver;



    @BeforeTest
    @Parameters("browser")
    public void setupClass(String browser) {

        driverFactory driverFactory = new driverFactory();
        driver = driverFactory.driverSelect(browser);
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();

    }
    @Test
    public void loginTest(){

        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys("adam");
        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//form[@id='login']/button[@class='radius']")).click();

    }

    @AfterTest
    public void tearDown(){

        driver.quit();

    }
}
