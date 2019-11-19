package com.automationpractice.steps.contact_us;

import com.automationpractice.pages.contact_us.ContactUsPage;
import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.TestDataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ContactUsSteps extends CommonStep {
    private WebDriver driver = getDriver();
    private ContactUsPage contactUsPage;

    public ContactUsSteps () {
        if (contactUsPage == null) contactUsPage = new ContactUsPage(getDriver());
    }

    @When("User populates Contact Us form")
    public void user_populates_Contact_Us_form() {
        String firstName = TestDataGenerator.getRandomFirstName();
        String lastName = TestDataGenerator.getRandomLastName();
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Files/5555.docx";

        contactUsPage.selectSubjectHeading("Webmaster");
        contactUsPage.enterEmailAdress(TestDataGenerator.getRandomEmail(firstName, lastName));
        contactUsPage.enterOrderReference("RandomText");
        contactUsPage.attachFile(filePath);
        contactUsPage.enterMessageTextBox(TestDataGenerator.getRandomText(300));

      //  throw new cucumber.api.PendingException();
    }

    @And("User clicks on Send button")
    public void user_clicks_on_Send_button() {
    contactUsPage.clickSendButton();
    }

    @Then("User should view success message")
    public void user_should_view_success_message() {
        System.out.println("done");
    }
}
