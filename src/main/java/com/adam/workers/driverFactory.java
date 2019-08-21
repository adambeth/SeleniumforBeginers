package com.adam.workers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver driverSelect(String browser) {
        // Create driver
        System.out.println("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }
}
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class driverFactory {
//    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//
//    public WebDriver driverSelect(String browser){
//
//        switch (browser.toLowerCase()){
//
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//                driver.set(new ChromeDriver());
//                break;
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//                driver.set(new FirefoxDriver());
//                break;
//
//            default:
//                throw new IllegalStateException("Unexpected value: " + browser.toLowerCase());
//        }
//        return driver;
//
//    }
//}
//
