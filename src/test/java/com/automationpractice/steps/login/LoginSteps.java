package com.automationpractice.steps.login;

import com.automationpractice.pages.home.HomePage;
import com.automationpractice.pages.login.LoginPage;
import com.automationpractice.pages.my_account.MyAccountPage;
import com.automationpractice.utilities.AppProperties;
import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.TestDataGenerator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import io.cucumber.java.it.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonStep {
    private WebDriver driver = getDriver();

    private LoginPage loginPage = new LoginPage(driver);
    private MyAccountPage myAccountPage  = new MyAccountPage(driver);

  @Given ("User navigates to home page")
    public void user_Navigates_to_home_page (){

  }


    @When("User input email adress and password")
    public void user_input_email_adress_and_password() {
      String email ="abc213@mailinator.com";
      String password ="abc1234";
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

           }

    @When("User clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        loginPage.clickSignInButton();
                }

    @Then("User is on account page")
    public void user_is_on_account_page() {
        String actualHeader = myAccountPage.getHeader();
      assertEquals("MY ACCOUNT", actualHeader);
    }


    @When("User input {string} email  and {string} password")
    public void user_input_and(String email, String password) {
      loginPage.enterEmail(email);
      loginPage.enterPassword(password);
        Common.sleep(4);
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String errorMessage) {
      String actualErrorMessage = loginPage.getErrorMessage();
       assertTrue("Error message", actualErrorMessage.contains(errorMessage));
    }

    @When("User inputs email, password and clicks on sign in button and validate error message")
    public void user_inputs_email_password_and_clicks_on_sign_in_button_and_validate_error_message(DataTable dataTable) {
        List <Map<String, String>> listOfRows = dataTable.asMaps(String.class, String.class);
        for (int row = 0; row<listOfRows.size(); row++) {
            String email = listOfRows.get(row).get("email");
            String password = listOfRows.get(row).get("password");
            String errorMessage = listOfRows.get(row).get("error message");

            user_input_and(email, password);
            user_clicks_on_sign_in_button();
            user_should_see_error_message(errorMessage);
        }
    }

}
