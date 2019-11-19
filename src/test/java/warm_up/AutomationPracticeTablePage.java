package warm_up;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.Arrays;
import java.util.List;

public final class AutomationPracticeTablePage extends CommonPage {
    private static AutomationPracticeTablePage automationPracticeTablePage;

    public static AutomationPracticeTablePage getAutomationPracticeTablePage (WebDriver driver) {
        if (automationPracticeTablePage == null) automationPracticeTablePage = new AutomationPracticeTablePage(driver);
        return automationPracticeTablePage;
    }

    private AutomationPracticeTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected boolean isLoaded() {
        return false;   //  return header.getText().equals("some text");
    }

    @FindBy(tagName = "h1")  private WebElement header;
  @FindBy(css = "#content [summary='Sample Table']") private WebElement tableElement;

  @FindBys({
           @FindBy(how = How.CSS, using = "#content [summary='Sample Table'] th"),
//          @FindBy(css = "#content [summary='Sample Table']tr")  // It is old way to do it
    })     private List <WebElement> headers;
@FindBys({@FindBy(how = How.XPATH, using = "//table[@summary='Sample Table']//tr[1]/td")}) private List <WebElement> colomnNumbers;
@FindBys({@FindBy (how = How.CSS, using = "#content [scope]")}) List <WebElement> rightHeaders;
@FindBys({@FindBy (how = How.XPATH, using = "//table[@summary='Sample Table']//tr[1]/td")}) private List <WebElement> tableData;


  //@FindBys({@FindBy (id="")}) private WebElement colomns;
//    @FindAll({  @FindBy (id="")
//                ,@FindBy (css="")
//                ,@FindBy (tagName="")
//
//    }) private List <WebElement> colomns1;

// public boolean isLoaded () {
//     return header.getText().equals("some text");}


  public String getHeader () {
    return header.getText();
    }

  public boolean isTableDisplayed () {
    return tableElement.isDisplayed();
  }

  public void printAllValues () {

    int rowNum = headers.size();
    int headerNum = colomnNumbers.size();
    int rightSideHeaderSize = rightHeaders.size();
    List<WebElement> tfootTh = getElements(By.xpath("//tfoot/tr/th"),15);
    List <WebElement> tfootTd = getElements(By.xpath("//tfoot/tr/td"),15);


        for (int index=0; index<headerNum; index++) {
            System.out.print(headers.get(index).getText()+"  | ");

        }
      System.out.println();
      System.out.print("__________________________________________________________");
      System.out.println();
        for (int index =9; index<rightSideHeaderSize; index++ ) {
            System.out.print(rightHeaders.get(index).getText()+" | ");
            for (int rowsIndex=2; rowsIndex<headerNum; rowsIndex++) {
                System.out.print(tableData.get(rowsIndex).getText()+"  | ");
            }
            System.out.println();
        }
      System.out.print("__________________________________________________________");
      System.out.println();

        for (int index=0; index<tfootTh.size(); index++) {
            System.out.print(tfootTh.get(index).getText()+"  |  ");
            for (int index1=0; index1 < tfootTd.size(); index1++) {
                System.out.print(tfootTd.get(index1).getText()+ "  | ");
            }
        }







//    for (int index = 0; index<rowNum; index++) {
//        int colomns = headers.get(index).findElements(By.tagName("th")).size();
//        for (int colomnNumber = 0; colomnNumber<colomns; colomnNumber++) {
//            System.out.print(headers.get(colomnNumber).getText()+" | " );
//            System.out.println();
//        }
//
//    }

  }
}
