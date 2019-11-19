package com.automationpractice.pages.login;

import com.automationpractice.pages.home.HomePage;
import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {
    private final int timeOutInSeconds=15;
    private final Logger logger = Logger.getLogger(LoginPage.class);
   // private DriverHelper driverHelper =getDriverHelper();
    private By emailTextBox = By.id ("email");
    private By passwordTextBox = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isLoaded() {
        return false;
    }

    public void enterEmail (String email) {
       sendKeys(emailTextBox,email, timeOutInSeconds);
        logger.info("Entered email as "+email);
    }

    public void enterPassword (String password) {
        sendKeys(passwordTextBox,password, timeOutInSeconds);
        logger.info("Entered password as "+password);
    }

    public void clickSignInButton () {
       click(signInButton,timeOutInSeconds);
        logger.info("Clicked on Sign In button");
    }

    public String getErrorMessage () {
        return getText(By.cssSelector(".alert-danger"),timeOutInSeconds);
    }


}
