package us.techcenture;

import com.automationpractice.utilities.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StudentListPage extends CommonPage {
    private static StudentListPage studenListPage;
    private int timeOutInSeconds = 15;

    static StudentListPage getStudentListPage (WebDriver webDriver) {
        if (studenListPage == null) studenListPage = new StudentListPage(webDriver);
        return studenListPage;
    }


    protected StudentListPage(WebDriver driver) {
        super(driver);
    }

    void clickCreatNewStudentLink ( ) {
        clickByLinkText("Create new Student");
    }


    String [] getStudentData (String name) {
        String [] studentData = new String [5];
        List<WebElement> rowElements = getElements(By.cssSelector("tbody tr"), timeOutInSeconds);

        for (int index = 0; index < rowElements.size(); index++) {
            WebElement rowElement = rowElements.get(index);
            if (index ==0) continue;
//            System.out.println(rowElement.getSize());
//            System.out.println(rowElement.isDisplayed());

            String actualFirstName = rowElement.findElement(By.xpath(" .//td[2]")).getText();
//            try {
//                actualFirstName = rowElement.findElement(By.xpath(" .//td[2]")).getText();
//            } catch ( NoSuchElementException  e) {
//                continue;
//            }

            if (actualFirstName.equalsIgnoreCase(name)) {
                studentData[0] = rowElement.findElement(By.xpath(" .//td[1]")).getText();
                studentData[1] = rowElement.findElement(By.xpath(" .//td[2]")).getText(); // we skip becouse we know the name it is name cell
                studentData[2] = rowElement.findElement(By.xpath(" .//td[3]")).getText();
                studentData[3] = rowElement.findElement(By.xpath(" .//td[4]")).getText();
                studentData[4] = rowElement.findElement(By.xpath(" .//td[5]")).getText();
                break;
            }
        }
        return studentData;
    }






    @Override
    protected boolean isLoaded() {
        return false;
    }
}
