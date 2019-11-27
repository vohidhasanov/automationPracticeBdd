package us.techcenture;

import com.automationpractice.utilities.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

 class CommonTechcentureDbQueries extends DatabaseConnection  {
    private static final Logger logger = Logger.getLogger(CommonTechcentureDbQueries.class);

    private static CommonTechcentureDbQueries commonTechcentureDbQueries;

    static CommonTechcentureDbQueries getCommonTechcentureDbQueries () {
        if (commonTechcentureDbQueries == null) commonTechcentureDbQueries = new CommonTechcentureDbQueries();
        return commonTechcentureDbQueries;
    }

    private CommonTechcentureDbQueries () {}
    String  getFirsNameOfStudent (int id) {
        String query = "select first_name from mysqldb.student where id ="+ id +";";
    String firstName = getQueryResult(query);
        return firstName;
    }


    String  getLastNameOfStudent (int id) {
        String query = "select last_name from mysqldb.student where id ="+ id +";";
        String lastName = getQueryResult(query);
        logger.info("Query"+ query);
        return lastName;
    }

    String  getCourseOfStudent (int id) {
        String query = "select course from mysqldb.student where id ="+ id +";";
        String course = getQueryResult(query);
        logger.info("Query"+ query);
        return course;
    }

    int  getAgeOfStudent (int id) {
        String query = "select age from mysqldb.student where id ="+ id +";";
        logger.info("Query"+ query);
        return Integer.parseInt(getQueryResult(query));
    }

    List<String> getStudentData (int id) {
        String query = "select * from mysqldb.student where id = "+ id +";";
        return getQueryResultAsList(query);
    }

    List <Map<String, Object>> getStudentsData () {
        String query ="select * from mysqldb.student;";
        return getQueryResultAsMaps(query);
    }




}
