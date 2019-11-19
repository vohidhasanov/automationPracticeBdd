package com.automationpractice.steps.home;

import com.automationpractice.pages.home.HomePage;
import com.automationpractice.utilities.CommonStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps extends CommonStep {
    private HomePage homePage = new HomePage(getDriver());


    @When("User clicks on sign in link")
    public void user_clicks_on_sign_in_link() {
        homePage.clickSignInLink();
    }

    @Given("User clicks on Contact Us link")
    public void user_clicks_on_Contact_Us_link() {
      homePage.clickContactUsLink();
    }


}
