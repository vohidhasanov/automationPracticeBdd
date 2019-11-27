package us.techcenture;

import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonStep;
import com.automationpractice.utilities.DataStoreUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class CreateStudentStep extends CommonStep {

        private HomePage1 homePage1 = HomePage1.getHomePage(getDriver());
    private StudentListPage studentListPage = StudentListPage.getStudentListPage(getDriver());
    private CreateStudentPage createStudentPage = CreateStudentPage.getcreateStudentPage(getDriver());
    private CommonTechcentureDbQueries techcentureDbQueries =   CommonTechcentureDbQueries.getCommonTechcentureDbQueries();


    @Given("User navigates to home page {string}")
    public void user_navigates_to_home_page(String url) {
        getDriver().get(url);
    }

    @When("User clicks on CREATE STUDENT button")
    public void user_clicks_on_CREATE_STUDENT_button() {
        homePage1.clickCreateStudentButton();
    }

    @When("User clicks on CREATE NEW STUDENT button")
    public void user_clicks_on_CREATE_NEW_STUDENT_button() {
        studentListPage.clickCreatNewStudentLink();
    }

    @When("User inputs name, last name, course and student age")
    public void user_inputs_name_last_name_course_and_student_age(DataTable dataTable) {
        List<String> dataTableList = dataTable.asList(String.class);
//        for (int index = 0; index<dataTableList.size(); index++) {
//            String  fieldName = index % 2 == 0 ?
//        }

        String name = dataTableList.get(1);
        String lastName = dataTableList.get(3);
        String course = dataTableList.get(5);
        String age = dataTableList.get(7);

        createStudentPage.enterStudentData(CreateStudentPage.CreateStudentFields.NAME, name);
        createStudentPage.enterStudentData(CreateStudentPage.CreateStudentFields.LAST_NAME, lastName);
        createStudentPage.enterStudentData(CreateStudentPage.CreateStudentFields.COURSE, course);
        createStudentPage.enterStudentData(CreateStudentPage.CreateStudentFields.STUDENT_AGE, age);

        DataStoreUtils.storeData("first name", name);
        DataStoreUtils.storeData("last name", lastName);
        DataStoreUtils.storeData("course", course);
        DataStoreUtils.storeData("age", age);

    }

    @When("User clicks SAVE button")
    public void user_clicks_SAVE_button() {
        createStudentPage.clickSaveButton();
    }

    @Then("User should see his name in the student list")
    public void user_should_see_his_name_in_the_student_list() {
    String name = DataStoreUtils.getObjectAsString("first name");
    String [] studentData = studentListPage.getStudentData(name);

        String actualID = studentData [0];
        String actualName = studentData [1];
        String actualLastName = studentData [2];
        String actualCourse = studentData [3];
        String actualAge = studentData [4];

        assertEquals(name, actualName);
        assertEquals(actualLastName, DataStoreUtils.getObjectAsString("last name"));
        assertEquals(actualCourse, DataStoreUtils.getObjectAsString("course"));
        assertEquals(actualAge, DataStoreUtils.getObjectAsString("age"));

        DataStoreUtils.storeData("student id", actualID);
    }

    @Then("User should validate student data in database")
    public void user_should_validate_student_data_in_database() {
    int id = DataStoreUtils.getObjectAsInt("student id");
        String firstName = techcentureDbQueries.getFirsNameOfStudent(id);
        String lastName = techcentureDbQueries.getLastNameOfStudent(id);
        String course = techcentureDbQueries.getCourseOfStudent(id);
        int age = techcentureDbQueries.getAgeOfStudent(id);

        assertEquals(firstName, DataStoreUtils.getObjectAsString("first name"));
        assertEquals(lastName, DataStoreUtils.getObjectAsString("last name"));
        assertEquals(course, DataStoreUtils.getObjectAsString("course"));
        assertEquals(String.valueOf(age), DataStoreUtils.getObjectAsString("age"));

        System.out.println("the first name from the Database = "+firstName);
        System.out.println(techcentureDbQueries.getStudentData(91));

        List <Map<String, Object>> list = techcentureDbQueries.getStudentsData();
        for (int index=0; index<list.size(); index++) {
            Map <String, Object> map = list.get(index);
            for (Map.Entry<String, Object> m : map.entrySet()) {
                System.out.print(m.getKey()+"-"+ m.getValue()+" ");
            }
            System.out.println();
        }

    }

}
