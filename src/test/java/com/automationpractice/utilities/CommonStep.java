package com.automationpractice.utilities;

import junit.framework.AssertionFailedError;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonStep {
    private static final Logger LOGGER = Logger.getLogger(CommonStep.class);

    private static SoftAssertions softAssertions = getSoftAssertions();

    private static SoftAssertions getSoftAssertions () {
        return softAssertions == null? new SoftAssertions():softAssertions;
    }


    protected WebDriver getDriver() {
        return DriverFarctory.getDriver();
    }

    protected static void closeDriver() {
        DriverFarctory.closeDriver();
    }

    protected void validateEquals (String actualStr, String expectedStr) {
    softAssertions.assertThat(actualStr).isEqualTo(expectedStr);
    try {
        Assert.assertEquals(expectedStr, actualStr);
    } catch (ComparisonFailure e) {
        LOGGER.error(e.getMessage());
        Common.takeScreenShotFroReporting(getDriver());
//        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
//        byte []  screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
//        scenario.embed(screenshot,"image/png");
    }
    }

    protected void validateAll () {
        softAssertions.assertAll();
    }

}
