package com.adam.theinernet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.adam.workers.driverFactory;


public class positiveTest {

    private WebDriver driver;

    private driverFactory driverFactory = new driverFactory();


    @BeforeTest
    @Parameters("browser")
    public void setupClass(String browser) {
   

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
