package us.techcenture;


import com.automationpractice.utilities.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.MessageFormat;
import java.util.List;

final class CreateStudentPage extends CommonPage {
    private int timeOutInSeconds = 15;
    private static CreateStudentPage createStudentPage;
    private String fieldInputBox ="//td[contains(text(),\"{0}\")]/following-sibling::td/input";
    enum CreateStudentFields {NAME, LAST_NAME, COURSE, STUDENT_AGE }

     static CreateStudentPage getcreateStudentPage (WebDriver webDriver) {
    if (createStudentPage == null) createStudentPage = new CreateStudentPage(webDriver);
    return createStudentPage;
    }


    protected CreateStudentPage(WebDriver driver) {
        super(driver);
    }

    void enterStudentData (String fieldName, String fieldValue) {
         String xpath = MessageFormat.format(fieldInputBox,fieldName);
         sendKeys(By.xpath(xpath), fieldValue, timeOutInSeconds);
    }

    void enterStudentData (CreateStudentFields createStudentFields, String fieldValue ) {
        By textFieldLocator = null;
        switch ( createStudentFields) {
            case NAME: textFieldLocator = By.id("first_name");
            break;
            case LAST_NAME: textFieldLocator = By.id("last_name");
            break;
            case COURSE: textFieldLocator = By.id("course");
            break;
            case STUDENT_AGE:textFieldLocator = By.id ("age");
            break;
            default: break;
        }
        sendKeys(textFieldLocator, fieldValue, timeOutInSeconds);
    }

    void clickSaveButton () {
        clickButton("Save");
    }




    @Override
    protected boolean isLoaded() {
        return false;
    }
}
