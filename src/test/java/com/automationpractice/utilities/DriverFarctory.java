package com.automationpractice.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

final class DriverFarctory {
    private static Logger logger = Logger.getLogger(DriverFarctory.class);
    private static WebDriver driver;



 static WebDriver getDriver () {
    if (driver==null) driver= getActiveDriver();
     return driver;
   // return driver ==null ? getActiveDriver():driver;
}

static void closeDriver () {
     if (driver!=null) {
         driver.close();
         driver.quit();
         driver= null;
     }
}

    private synchronized static WebDriver getActiveDriver() {
    String browserType = AppProperties.BROWSER_TYPE;
    switch (browserType)
            {
                case "chrome":
                    driver = getChromeDriver();
                    break;
                case "firefox":
                    driver = getFirefoxDriver();
                    break;
                case "chrome-headless":
                    driver = getHeadlessChromeDriver();
                    break;
                default:
                    System.out.println("Browser type" + browserType + " invalid.");
                    break;
            }
            logger.info("Driver type set to "+browserType);
            return driver;
        }

        private static ChromeDriver getChromeDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            return new ChromeDriver(chromeOptions);
        }

        private static ChromeDriver getHeadlessChromeDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--headless");
            //chromeOptions
            return new ChromeDriver(chromeOptions);
        }


        private static FirefoxDriver getFirefoxDriver() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
}
