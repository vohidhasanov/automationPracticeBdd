package com.mockaroo.excel_generator;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

final class ExcelGeneratorPage extends CommonPage {
    private static int timeOutInSeconds=15;
    private static ExcelGeneratorPage excelGeneratorPage;
    private static final Logger logger = Logger.getLogger(ExcelGeneratorPage.class);
  //  private DriverHelper driverHelper = getDriverHelper();

    static ExcelGeneratorPage getExcelGeneratorPage (WebDriver webDriver) {
    if (excelGeneratorPage==null) excelGeneratorPage = new ExcelGeneratorPage(webDriver);
    return excelGeneratorPage;
    }

    private ExcelGeneratorPage(WebDriver driver) {
        super(driver);
    }

    void printExcelContent (String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet =  workbook.getSheetAt(0);
        int numberOfRows = sheet.getLastRowNum();

        for (int row=0; row <= numberOfRows; row++) {
            Row rowObj = sheet.getRow(row);
            int colomns = rowObj.getLastCellNum();

            for (int colomn=0; colomn<colomns; colomn++) {
                Cell cell = rowObj.getCell(colomn);
                System.out.print(cell.toString()+ "|");

                if (colomn == colomns-1) System.out.println("/n");
            }
         //   System.out.println();
        }
        workbook.close();
        fileInputStream.close();
    }
    int getNumberOfRows () {
    return getElements(By.cssSelector("#fields .fields"),timeOutInSeconds).size();
    }

    void deleteRows (int numberOfRowsToDelete) {
        List<WebElement> rowElements = getElements(By.cssSelector("#fields .fields"),timeOutInSeconds);

        for (int row = 1; row<=numberOfRowsToDelete; row++) {
            int index = rowElements.size() - row;

            WebElement rowElement = rowElements.get(index);
            WebElement deleteIcon = rowElement.findElement(By.cssSelector(".column-remove"));
            deleteIcon.click();
            Common.sleep(2);
            //rowElements.get(index).findElement(By.cssSelector(".column-remove")).click(); // other way
        }
    }

    void enterFieldName (int row, String fieldName) {
        boolean isRow = isRow(row+1);
        if (!isRow)
        clickAtAnotherFieldButton();

        //sendKeys(By.id("schema_columns_attributes_"+ row +"_name"),fieldName,timeOutInSeconds);
        sendKeysList(By.cssSelector("[placeholder^='enter name...']"), row, fieldName, timeOutInSeconds);
    }

   private void clickAtAnotherFieldButton() {

        click(By.linkText("Add another field"),timeOutInSeconds);
   }

   private boolean isRow (int row) {
        boolean isRow = false;
        try {
            isRow = getElement(By.cssSelector("#fields .fields"), row, timeOutInSeconds).isDisplayed();
        } catch (Exception e) {
            logger.error(e.getMessage() );
        }
        return isRow;
    }



    @Override
    protected boolean isLoaded() {
        return false;
    }
}
