package us.techcenture;

import com.automationpractice.utilities.CommonPage;
import org.openqa.selenium.WebDriver;

final class HomePage1 extends CommonPage {
    private static HomePage1 homePage1;
   // private DriverHelper   driverHelper;

    static HomePage1 getHomePage (WebDriver webDriver) {
        if (homePage1 == null) homePage1 = new HomePage1(webDriver);
        return homePage1;
    }


    protected HomePage1(WebDriver driver) {
        super(driver);
    }


    void clickCreateStudentButton () {
    clickButton("CREATE STUDENT");

    }

    @Override
    protected boolean isLoaded() {
        return false;
    }
}
