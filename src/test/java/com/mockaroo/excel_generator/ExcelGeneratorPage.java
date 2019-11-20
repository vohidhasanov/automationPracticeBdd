package com.mockaroo.excel_generator;

import com.automationpractice.utilities.CommonPage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

final class ExcelGeneratorPage extends CommonPage {

    private static ExcelGeneratorPage excelGeneratorPage;

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
            }
            System.out.println();
        }
        workbook.close();
        fileInputStream.close();
    }




    @Override
    protected boolean isLoaded() {
        return false;
    }
}
