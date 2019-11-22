package com.automationpractice.utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public final class Common {
    private static Logger logger = Logger.getLogger(Common.class);
    public static final String USER_HOME_DIR = System.getProperty("user.home");
    public static final String USER_DIR = System.getProperty("user.dir");


private Common () {}

    public static void sleep (int second) {
        try {
            int secondsSleep = second*1000;
            Thread.sleep(secondsSleep);
            logger.info("sleep for "+secondsSleep+" seconds");
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean isFile (String pathName) {
    File file = new File(pathName);
    boolean isFile = file.exists();
    int numberOfAttemps = 0;
    while (!isFile && numberOfAttemps <=5) {
        sleep(1);
        isFile=file.exists();
        numberOfAttemps++;
    }
    return isFile;
    }

    public static void deleteFiles (String directoryPath) {
        File file = new File  (System.getProperty("user_id")+directoryPath);
        for ( File file1: file.listFiles()) {
            boolean isfileDeleted =  file1.delete();
            if (isfileDeleted) System.out.println("File \"" +file1.toPath().getFileName()+"\" deleted");
            System.out.println("File \"" +file1.toPath().getFileName()+"\" not deleted");
              }

    }

    public static void failTest (String errorMessage) {
        throw new RuntimeException(errorMessage);

    }

    public static String takeScreenShotFroReporting(WebDriver driver)
    {   long ms = System.currentTimeMillis();
        String path =System.getProperty("user.dir")+"/target/ScreenShots/FileName"+ms;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File ( path+".png"));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return path +".png";
    }


//    public static void main(String[] args) {
//        WebDriver driver = Driver.driver.getDriver("chrome");
//        driver.get("https://email-verify.my-addr.com/list-of-most-popular-email-domains.php");
//        List<WebElement> rowElement = driver.findElements(By.xpath("(//h2[text()='Top 100']/..//table//tr)"));
//
//        for (int x=1; x<=rowElement.size(); x++) {
//        String email = driver.findElement(By.xpath("((//h2[text()='Top 100']/..//table//tr)["+ x+"]//td)[3]")).getText();
//        email = "\"@"+email+"\", ";
//        System.out.print(email);
//        }
//
//
//
//    }

}
