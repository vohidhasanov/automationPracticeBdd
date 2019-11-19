package com.automationpractice.pages.contact_us;


import com.automationpractice.steps.contact_us.ContactUsSteps;
import com.automationpractice.utilities.*;


import io.cucumber.java.eo.Se;
import junit.extensions.TestDecorator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.util.Set;

//import static com.automationpractice.utilities.TestDataGenerator.*;

public class ContactUsPage extends CommonPage {

    private WebDriver driver;
    private final int timeOutInSeconds=15;
    private final Logger logger = Logger.getLogger(ContactUsPage.class);
 //   private DriverHelper driverHelper =getDriverHelper();
    private By email = By.id("email");
    private By emailAdressTextBox = By.id("email");
    private By orderReferenceTextBox = By.id("id_order");
    private By attachFileTextBox = By.id("fileUpload");
    private By messageTextBox = By.id("message");
    private By sendButton = By.id("submitMessage");
    private By subjectHeadingDropDown = By.id("id_contact");
   // String filePath = System.getProperty("user.dir") + "/src/test/resources/Files/5555.docx";


    public ContactUsPage(WebDriver driver) {
        super(driver) ;
   this.driver = driver;
    }

    @Override
    protected boolean isLoaded() {
        return false;
    }
@Test
    public void selectSubjectHeading (String subject)
    {
        Select select = new Select (driver.findElement(subjectHeadingDropDown));
        select.selectByVisibleText(subject);
    }


    public void enterEmailAdress(String email)
    {
          sendKeys(emailAdressTextBox,email,timeOutInSeconds);
    }

    public void enterOrderReference (String orderReference)
    {
       sendKeys(orderReferenceTextBox,orderReference,timeOutInSeconds);
    }

    public void attachFile (String filePath)
    {
        driver.findElement(attachFileTextBox).sendKeys(filePath);
       // driverHelper.sendKeys(attachFileTextBox, filePath, timeOutInSeconds);
    }

     public void enterMessageTextBox (String message) {
        sendKeys(messageTextBox, message,timeOutInSeconds);
     }

     public void clickSendButton () {
        //driver.findElement(By.id("submitMessage")).click();
        // driver.findElement(By.xpath("//span[text()='Send']")).click();
       click(sendButton,timeOutInSeconds);
     }


 //   public void contactUsFormFilling () {


//     driverHelper.jsExecuteScript ("arguments[0].setAttribute('class', '')", driverHelper.getElement(By.xpath("//div[@class='selector']"),timeOutInSeconds));
//        Select select = new Select(driverHelper.getElement(By.id("id_contact"),timeOutInSeconds));
//        select.selectByValue("2");
//
//        Common.sleep(2);
//
//     driverHelper.sendKeys(email, "abc213@google.com", timeOutInSeconds);
//
//
//
//        driverHelper.jsClick(By.id("fileUpload"));
        //String filePath = System.getProperty("user.dir") + "/src/test/resources/Files/5555.docx";
//        String filePath2= System.getProperty("Files/5555.docx");
//        String fileName = Paths.get(filePath).getFileName().toString();
//
//       // driverHelper.sendKeys(By.xpath("//span[@class='filename']"),filePath,timeOutInSeconds);
//        //driverHelper.jsExecuteScript("document.getElementsByName('fileUpload').value= 'C:\\Users\\Vohid-PC\\gitRepo\\automationPracticeBdd\\src\\test\\resources\\Files\\5555.docx';");
//        driverHelper.jsExecuteScript("arguments[0].setAttribute('class', '')",driverHelper.getElement(By.id("uniform-fileUpload"),timeOutInSeconds));
//        driverHelper.sendKeys(By.name("fileUpload"), filePath, timeOutInSeconds);
//        String uploadedFile = driverHelper.getElement(By.id("fileUpload"),timeOutInSeconds).getAttribute("value");
//        System.out.println("The uploaded file "+uploadedFile);
//        uploadedFile =Paths.get(uploadedFile).getFileName().toString();
//        System.out.println("Uploaded File another time");
//        Assert.assertEquals(fileName, uploadedFile);
//
////        Set<String> windows = driver.getWindowHandles();
////        for ( String window:windows) {
////            String mainWindow =driverHelper.getMainWindowHandle();
////            if (window!=mainWindow) driver.switchTo().window(window).close();
////        }
//
//
//
//
//        Common.sleep(4);
//
//        driverHelper.sendKeys(By.id("message"), TestDataGenerator.getRandomText(500), timeOutInSeconds );
//
//        Common.sleep(6);



//}


 }