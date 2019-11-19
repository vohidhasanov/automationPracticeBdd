package com.automationpractice.steps.warm_up;

import com.automationpractice.pages.home.HomePage;
import com.automationpractice.pages.mackarooForm.MackarooFormPage;
import com.automationpractice.utilities.CommonStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class mackarooFormSteps extends CommonStep {
    private HomePage homePage = new HomePage(getDriver());
    private MackarooFormPage mackarooFormPage = new MackarooFormPage(getDriver());


    @Given("User navigates to mackaroo home page")
    public void user_navigates_to_mackaroo_home_page() {
        homePage.clickMackarooLink();
    }

    @When("User enters ID")
    public void user_enters_ID() {
        mackarooFormPage.enterIDandSelectIdType("abc123");
    }

    @When("User enters first_name to form and select firstName type")
    public void user_enters_first_name_to_form_and_select_firstName_type() {
      mackarooFormPage.enterFirstNameandType("James");
    }

    @When("User enters last_name to form and select lastname type")
    public void user_enters_last_name_to_form_and_select_lastname_type() {
      mackarooFormPage.enterLastNameandType("Brown");
    }

    @When("User enters email to form select emailType")
    public void user_enters_email_to_form_select_emailType() {
    mackarooFormPage.enterEmailAndType("abc@gmail.com");
    }

    @When("User enters gender to form and select Type")
    public void user_enters_gender_to_form_and_select_Type() {
       mackarooFormPage.enterGenderAndType("Male");
    }

    @When("User enters ip_adress to form and select Ip Type")
    public void user_enters_ip_adress_to_form_and_select_Ip_Type() {
      mackarooFormPage.enterIPAdressAndType("192.168.1.1");
    }

    @When("User enters row numbers")
    public void user_enters_row_numbers() {
        mackarooFormPage.enterNumberOfRows("500");
    }

    @When("User enters file format to dowonload")
    public void user_enters_file_format_to_dowonload() {
        mackarooFormPage.selectFileFormat("xlsx");
    }

    @Then("User click download button")
    public void user_click_download_button() {
        mackarooFormPage.downloadFile();
    }
}
