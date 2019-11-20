package com.mockaroo.excel_generator;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class ExcelGeneratorSteps extends CommonStep {
final ExcelGeneratorPage excelGeneratorPage = ExcelGeneratorPage.getExcelGeneratorPage(getDriver());

    @Given("I user I should able to read excel file")
    public void i_user_I_should_able_to_read_excel_file() throws IOException {
        String filePath = Common.USER_HOME_DIR+"/Downloads/MOCK_DATA.xlsx";
    excelGeneratorPage.printExcelContent(filePath);
    }
}
