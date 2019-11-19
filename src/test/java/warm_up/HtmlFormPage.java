package warm_up;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class HtmlFormPage extends CommonPage {
    // This class is Singleton
    // only one instance available for this object
    private static HtmlFormPage htmlFormPage;

    public static HtmlFormPage getHtmlFormPage (WebDriver driver) {
    if (htmlFormPage == null) htmlFormPage = new HtmlFormPage(driver);
        return htmlFormPage;
    }

   // private DriverHelper driverHelper = getDriverHelper();

    private By firstNameTextBox = By.cssSelector("[placeholder='Your name..']");
    private By lastNameTextBox = By.id("lname");
    private By countryTExtBox = By.name("country");
    private By subjectTextBox = By.id("subject");
    private By submitButton = By.cssSelector("[value='Submit']");

    private String htmlContactFormLocator = "HTML contact form";

   public HtmlFormPage(WebDriver driver) {  super(driver);  }

    @Override
    protected boolean isLoaded() {
        return false;
    }

    public void clickHtmlContactFormLink () {
       clickByLinkText(htmlContactFormLocator,15);
   }

   public void enterFistName (String fname) {
      sendKeys(firstNameTextBox, fname, 15);
   }

    public void enterLastName (String lname) {
        sendKeys(lastNameTextBox, lname, 15);
    }

    public void enterCountry (String country) {
       sendKeys(countryTExtBox, country, 15);
    }

    public void enterSubject (String subject) {
        sendKeys(subjectTextBox,subject,15);
    }

    public void clickSubmitButton () {
       click(submitButton, 15);
    }



}
