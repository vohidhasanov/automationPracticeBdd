package com.automationpractice.pages.mackarooForm;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.lang.reflect.Array;

public class MackarooFormPage extends CommonPage {
    private WebDriver driver;
    private final Logger logger = Logger.getLogger(MackarooFormPage.class);
  //  private DriverHelper driverHelper = getDriverHelper();
    private By idForm = By.id("schema_columns_attributes_0_name");
        private By idFormType = By.xpath("//div[text()='App Bundle ID']");
    private By fistName = By.id("schema_columns_attributes_1_name");
        private By fistNameType = By.xpath("//div[text()='First Name (Male)']");
    private By lastName = By.id("schema_columns_attributes_2_name");
        private By lastNameType = By.xpath("//div[text()='Last Name']");
    private By email = By.id("schema_columns_attributes_3_name");
        private By emaailType = By.xpath("//div[text()='Email Address']");
    private By gender = By.id("schema_columns_attributes_4_name");
        private By genderType = By.xpath("//div[text()='Gender']");
    private By IpAddress = By.cssSelector("[value='ip_address']");
        private By IpAddressType = By.xpath("//div[text()='IP Address v4']");
    private By rowNumbers = By.id("num_rows");



    public MackarooFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isLoaded() {
        return false;
    }

    public void enterIDandSelectIdType (String name) {
        sendKeys(idForm, name, 15 );
        logger.info("Entered ID");
        click(By.cssSelector("[class='column column-type']"),15);
        click(idFormType,15);
            Common.sleep(3);
    }

    public void enterFirstNameandType (String fname) {
       sendKeys(fistName, fname,15);
        logger.info(("Entered firstname "+fname));
       click(By.xpath("(//div[@class='column column-type'])[2]"),15);
        click(fistNameType,15);
        Common.sleep(3);
    }

    public void enterLastNameandType (String lname) {
       sendKeys(lastName, lname,15);
        logger.info(("Entered lastname "+lname));
        click(By.xpath("(//div[@class='column column-type'])[3]"),15);
        click(lastNameType,15);
        Common.sleep(3);
    }

    public void enterEmailAndType (String Myemail) {
        sendKeys(email, Myemail,15);
        logger.info("Entered Email: "+Myemail);
        click(By.xpath("(//input[@placeholder='choose type...'])[4]"),15);
        click(emaailType,15);
        Common.sleep(3);
    }

    public void enterGenderAndType (String Mygender) {
        sendKeys(gender, Mygender,15);
        click(By.cssSelector("[value='Gender']"),15);
        click(genderType,15);
        Common.sleep(3);
    }

    public void enterIPAdressAndType (String MyIpAddress) {
        sendKeys(IpAddress, MyIpAddress, 15);
        click(By.cssSelector("[value='IP Address v4']"),15);
        click(IpAddressType,15);
        Common.sleep(3);
    }

    public void enterNumberOfRows(String numberOfRows) {
        sendKeys(rowNumbers, numberOfRows,15);
        Common.sleep(2);
    }

    public void selectFileFormat(String FileFormat) {
        WebElement selectFileTypeDropDown = getElement(By.id("schema_file_format"),15);
        Select select = new Select(selectFileTypeDropDown);
        select.selectByValue(FileFormat);
        Common.sleep(2);
    }

    public void downloadFile () {
        click(By.id("download"),15);
        Common.sleep(3);
        String expectedDownloadedFileName = "MOCK_DATA.xlsx";
        File file = new File("C://Users//Vohid-PC//Downloads//MOCK_DATA.xlsx");
        String actualFile =file.getName();
        System.out.println("Downloaded file: "+actualFile);
        //String trimmedDownloadedFile = actualFile.substring(actualFile.lastIndexOf('/')+1);
      //  System.out.println("Trimmed fileName: "+trimmedDownloadedFile);
        Assert.assertEquals(expectedDownloadedFileName, actualFile);
        Common.sleep(3);

    }

}
