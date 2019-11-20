package com.automationpractice.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class DriverHelper {
    private WebDriver driver;
    private String mainWindowHandle;
    

    public DriverHelper(WebDriver driver)
    { this.driver=driver; }


    public void operUrl(String url) {
        driver.get(url);
                //   Reporter.step.info("Navigated to: "+url);
        mainWindowHandle =driver.getWindowHandle();
    }


    public String getMainWindowHandle() {
        return mainWindowHandle;
    }


    public void webElementVisibility(By by, int timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getElement (By by, int timeOutInSeconds)
    {
        webElementVisibility(by, timeOutInSeconds);
        return driver.findElement(by);
    }

    public WebElement getElement (By by, int index, int timeOutInSeconds)
    {
        webElementVisibility(by, timeOutInSeconds);
        return driver.findElements(by).get(index-1);
    }

    public void clickByLinkText(String linkText, int timeOutInSeconds) {
        click(By.linkText(linkText), timeOutInSeconds);
        //Reporter.step.info("Clicked button "+by.toString().substring(by.toString().indexOf(':')));
    }

    public void click(By by, int timeOutInSeconds) {
        getElement(by, timeOutInSeconds).click();
        //Reporter.step.info("Clicked button "+by.toString().substring(by.toString().indexOf(':')));
    }

    public List<WebElement> getElements (By by, int timeOutInSeconds)
    {
        webElementVisibility(by, timeOutInSeconds);
        return driver.findElements(by);
    }
    public void click(By by, int index, int timeOutInSeconds) {
        getElements(by, timeOutInSeconds).get(index-1).click();}

    public void clickByXpath (String xpath, int timeOutInSeconds) {getElement(By.xpath(xpath), timeOutInSeconds).click();}

    public void sendKeys (By by, String text, int timeOutInSeconds) {
        WebElement textBox = getElement(by, timeOutInSeconds);
        textBox.clear();
        textBox.sendKeys(text);
    }

    public void sendKeysList (By by, int index,  String text, int timeOutInSeconds) {
        WebElement textBoxs = getElement(by, index+1,timeOutInSeconds);
        textBoxs.clear();
        textBoxs.sendKeys(text);
    }

    public String getText (By by, int timeOutInSeconds) {
        return getElement(by, timeOutInSeconds).getText().replaceAll("\\s+", " ").trim();
    }

    public void takeScreenShot()
    {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File ( System.getProperty("user.dir")+"/target/ScreenShots/FileName"+System.currentTimeMillis()+".png "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void switchToMainWindow() {
        driver.switchTo().window(mainWindowHandle);
    }

    private void executeJS(String script, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, webElement);
    }

    public void jsExecuteScript(String script, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, webElement);
    }

    public void jsExecuteScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void jsClick (By by) {
        WebElement webElement = driver.findElement(by);
        executeJS("arguments[0].click()", webElement);
    }

    public void click1 (By by) {
        try {
            click(by, 15);
        } catch (WebDriverException e)
        {
           // Common.sleep(1);
            scrollToElement(by);
            click(by,15);
        }
    }
    // If normal click above doesn't work Jsclick will click, becouse it finds and clicks anyway
    public void click2 (By by) {
        try {
            click(by, 15);
        } catch (WebDriverException e)
        {
            jsClick(by);
        }
    }

    public void scrollToElement (By by ) {
        WebElement webElement = getElement(by, 15);
        executeJS("arguments[0].scrollIntoView(true)", webElement);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    public void scrollToElement (int x, int y ) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll("+ x +", "+ y +")");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    public void highlightElement (By by) {
        WebElement webElement = getElement(by, 15);
        executeJS("arguments[0].style.border='3px dotted red'", webElement);


    }

    public void validateEquals (By by, String expectedText) {

        if (!getText(by, 15).equals(expectedText)) {
            highlightElement(by);
            takeScreenShot();
            assertEquals(getText(by,15), expectedText);
        }
    }

    public void validateEquals (String actualString, String expectedText) {

        if (!actualString.equals(expectedText)) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript ("arguments[0].style.border='3px dotted red'", webelement);
            takeScreenShot();
            assertEquals(actualString, expectedText);
        }
    }
}
