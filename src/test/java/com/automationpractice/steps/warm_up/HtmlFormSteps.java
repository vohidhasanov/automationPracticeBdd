package com.automationpractice.steps.warm_up;

import com.automationpractice.utilities.CommonStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import warm_up.HtmlFormPage;

public class HtmlFormSteps extends CommonStep {
    private HtmlFormPage htmlFormPage = HtmlFormPage.getHtmlFormPage(getDriver());  // = new HtmlFormPage(getDriver());

//    public HtmlFormSteps () {
//        if (htmlFormPage ==null) htmlFormPage =new HtmlFormPage(getDriver());
//
//    }

    @Given("User navigates to TOOLS QA home page")
    public void user_navigates_to_TOOLS_QA_home_page() {
        getDriver().get("https://demoqa.com");
    }

    @When("User clicks HTML form link")
    public void user_clicks_HTML_form_link() {
      htmlFormPage.clickHtmlContactFormLink ();
    }

    @When("User enters {string} first name")
    public void user_enters_first_name(String fname) {
        htmlFormPage.enterFistName(fname);
    }

    @When("User enters {string} last name")
    public void user_enters_last_name(String lname) {
        htmlFormPage.enterLastName(lname);
    }

    @When("User enters {string} country")
    public void user_enters_country(String country) {
        htmlFormPage.enterCountry(country);
    }

    @When("User enters {string} subject")
    public void user_enters_subject(String subject) {
       htmlFormPage.enterSubject(subject);
    }

    @When("User clicks submit button")
    public void user_clicks_submit_button() {
      htmlFormPage.clickSubmitButton();
    }

    @Then("User should see successful page")
    public void user_should_see_successful_page() {

    }


}
