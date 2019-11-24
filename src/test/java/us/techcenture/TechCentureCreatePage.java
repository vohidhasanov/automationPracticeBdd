package us.techcenture;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class TechCentureCreatePage extends CommonPage {
private static TechCentureCreatePage techCentureCreatePage;

public TechCentureCreatePage(WebDriver driver) {
        super(driver);
    }

    static TechCentureCreatePage getTechCentureCreatePage(WebDriver driver) {
        if (techCentureCreatePage == null) techCentureCreatePage = new TechCentureCreatePage(driver);
        return techCentureCreatePage;
    }


    void enterDataToCreateStudentTable (List<Map<String, String>> formData) {
        int formSize = formData.size();

        for (int index=0; index<formSize; index++) {
            String name = formData.get(index).get("Name");
            String lastName = formData.get(index).get("Last Name");
            String course = formData.get(index).get("Course");
            String studentAge = formData.get(index).get("Student Age");

            techCentureCreatePage.sendKeys(By.id("first_name"), 1, name,15);
            techCentureCreatePage.sendKeys(By.id("last_name"), 1, lastName,15);
            techCentureCreatePage.sendKeys(By.id("course"), 1, course,15);
            techCentureCreatePage.sendKeys(By.id("age"), 1, studentAge,15);
            Common.sleep(3);
        }

    }

    void saveCreateStudent () {
    click(By.cssSelector("[type='submit']"),15);
    }





    @Override
    protected boolean isLoaded() {
        return false;
    }
}
