package com.mockaroo.excel_generator;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.DataStoreUtils;
import com.automationpractice.utilities.ExcelUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelGeneratorSteps extends CommonStep {
private final ExcelGeneratorPage excelGeneratorPage = ExcelGeneratorPage.getExcelGeneratorPage(getDriver());

    @Given("I user I should able to read excel file")
    public void i_user_I_should_able_to_read_excel_file() throws IOException {
        String filePath = Common.USER_HOME_DIR+"/Downloads/MOCK_DATA.xlsx";
    excelGeneratorPage.printExcelContent(filePath);
    }

    @Given("User navigates to {string} website")
    public void user_navigates_to_website(String url) {
    getDriver().get(url);
    }

    @When("User add field name and type")
    public void user_add_field_name_and_type(DataTable dataTable) {
        List<Map<String, String>> dataTableList = dataTable.asMaps(String.class, String.class);
        int numberOfRows = excelGeneratorPage.getNumberOfRows();

        if (numberOfRows > dataTableList.size())
            excelGeneratorPage.deleteRows(numberOfRows-dataTableList.size());

        for (int index =0; index<dataTableList.size(); index++) {
               String fieldName = dataTableList.get(index).get("field name");
               String typeName = dataTableList.get(index).get("type");
               excelGeneratorPage.enterFieldName(index, fieldName);
               excelGeneratorPage.chooseType(index, typeName);
               Common.sleep(1);
            }
    }

    @When("User adds {int} rows with file format {string}")
    public void user_adds_rows_with_file_format(Integer row, String format) {
       excelGeneratorPage.addRows(row);
       excelGeneratorPage.selectFileFormatType(format);
       Common.sleep(3);
    }

    @When("User clicks download button")
    public void user_clicks_download_button() {
       excelGeneratorPage.clickDownloadButton();
    }

    @Then("User validate the file is downloaded successfully")
    public void user_validate_the_file_is_downloaded_successfully() throws IOException {
    String filePath = Common.USER_HOME_DIR+"/Downloads/MOCK_DATA.xlsx"; //C:\Users\Vohid-PC\gitRepo\automationPracticeBdd\src\test\resources\Files
        boolean isFileDownloaded = Common.isFile(filePath);
    assertTrue("File is not downloaded", isFileDownloaded);
    //excelGeneratorPage.printExcelContent(filePath);

    Map <Integer, List <String>> excellDataMap = ExcelUtils.getExcelDataAsMaps(filePath);
    for (Map.Entry<Integer, List <String>> map : excellDataMap.entrySet()) {
        System.out.print(map.getKey()+ "\t");
        for (int index=0; index<map.getValue().size(); index++)
            System.out.print(map.getValue().get(index)+"\t");

        System.out.println("\n====================================================================");
    }
        DataStoreUtils.storeData("excel data", excellDataMap);

    Common.sleep(3);
    }

    @Then("User saves data in new {string}")
    public void user_saves_data_in_new(String fileName) throws IOException {
        ExcelUtils.wrieteToExcel(fileName);
    }

//    @Then("User randomly select firstName and SecondName")
//    public void user_randomly_select_firstName_and_SecondName() throws IOException {
//        String filePath = Common.USER_HOME_DIR+"/Downloads/MOCK_DATA.xlsx";
//    excelGeneratorPage.pickRandomDataFromExcelFile(filePath, 2);
//    }

}
