package com.automationpractice.pages.my_account;

import com.automationpractice.pages.login.LoginPage;
import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends CommonPage {
    private final int timeOutInSeconds=15;
    private final Logger logger = Logger.getLogger(MyAccountPage.class);
   // private DriverHelper driverHelper =getDriverHelper();
    private By header = By.tagName("h1");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isLoaded() {
        return false;
    }

    public String getHeader () {
        return getText(header,timeOutInSeconds);
    }

}
