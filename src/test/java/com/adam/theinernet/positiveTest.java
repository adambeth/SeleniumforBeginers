package com.adam.theinernet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class positiveTest {
    WebDriver driver;
    @BeforeClass
    public void startChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    public void loginTest(){
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys("adam");
        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//form[@id='login']/button[@class='radius']")).click();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();

    }
}
