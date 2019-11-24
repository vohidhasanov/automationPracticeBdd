package us.techcenture;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class TechCentureCreateSteps extends CommonStep {
    private final TechCentureCreatePage techCentureCreatePage = TechCentureCreatePage.getTechCentureCreatePage(getDriver());

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
    techCentureCreatePage.operUrl(url);

    }

    @When("User click Creat button and fills form")
    public void user_click_Creat_button_and_fills_form(DataTable formTable) {
        techCentureCreatePage.jsClick(By.xpath("//button[text()='CREATE STUDENT']"));
        techCentureCreatePage.clickByLinkText(("Create new Student"),15);
        List<Map<String, String>> formData = formTable.asMaps(String.class, String.class);
        techCentureCreatePage.enterDataToCreateStudentTable(formData);
//        int formSize = formData.size();
//
//        for (int index=0; index<formSize; index++) {
//            String name = formData.get(index).get("Name");
//            String lastName = formData.get(index).get("Last Name");
//            String course = formData.get(index).get("Course");
//            String studentAge = formData.get(index).get("Student Age");
//
//            techCentureCreatePage.sendKeys(By.id("first_name"), 1, name,15);
//            techCentureCreatePage.sendKeys(By.id("last_name"), 1, lastName,15);
//            techCentureCreatePage.sendKeys(By.id("course"), 1, course,15);
//            techCentureCreatePage.sendKeys(By.id("age"), 1, studentAge,15);
//            Common.sleep(3);
//        }

    }

    @When("User clicks Save button")
    public void user_clicks_Save_button() {
    techCentureCreatePage.saveCreateStudent();
    }



}
