package com.automationpractice.pages.home;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonPage {
    private final int timeOutInSeconds=15;
    private final Logger logger = Logger.getLogger(HomePage.class);
   // private DriverHelper driverHelper =getDriverHelper();
    private WebDriver driver;


    private By signInLink = By.linkText("Sign in");
    private By contactUsLink = By.linkText("Contact us");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isLoaded() {
        return false;
    }

    public void clickSignInLink () {
       click(signInLink,timeOutInSeconds);
        logger.info("Clicked on Sign In Link");
    }

    public void clickContactUsLink() {
       click(contactUsLink, timeOutInSeconds);
        logger.info("Clicked on Contact Us Link");
    }

    public void clickMackarooLink() {
     operUrl("https://mockaroo.com/");
        logger.info("Clicked on Macharoo.com");
    }

}
