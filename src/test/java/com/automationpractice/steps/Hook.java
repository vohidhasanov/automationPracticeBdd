package com.automationpractice.steps;

import com.automationpractice.pages.home.HomePage;
import com.automationpractice.utilities.AppProperties;
import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.DatabaseConnection;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hook extends CommonStep {
private static final Logger logger= Logger.getLogger(Hook.class);
private WebDriver driver = getDriver();

@Before  // Before annotation from cucumber runs before each Scenario
    public void setUP () {
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

  //  driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);

    }

    @After
    public void tearDown (Scenario scenario) {//Scenario scenario
    if (scenario.isFailed()) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte []  screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot,"image/png");
   }
    validateAll();
        DatabaseConnection.closeDbConnection();
    }

    @AfterStep
    public void afterStep (Scenario scenario) {
    if (AppProperties.IS_EACH_STEP_SCREENSHOT) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte []  screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot,"image/png");
    }
    }
}
