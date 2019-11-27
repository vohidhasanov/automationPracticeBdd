package com.automationpractice.utilities;

//import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HR_DB_DEMO {
   // private static final Logger logger = Logger.getLogger(HR_DB_DEMO.class);
    private static Connection connection;






    public static void closeDbConnection () {
        if (connection != null) {
            try {
                connection.close();
                connection=null;
            } catch (SQLException e) {
        //        logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    protected HR_DB_DEMO() {}



    public static void main(String[] args) {
        connection = getConnection();


        List<Map<String, Object>> list = new HR_DB_DEMO().getQueryResultAsMaps("select*from film");
        for (int index = 0; index < list.size(); index++) {
            Map<String, Object> map = list.get(index);
            for (Map.Entry<String, Object> m : map.entrySet()) {
                System.out.print(m.getKey() + "-" + m.getValue() + " ");
            }
            System.out.println();
        }
    }
    static   Connection getConnection () {
        Connection connection = null;
        String dbUrl = "database-2.ckajjvtsvcoe.us-east-1.rds.amazonaws.com";
        String dbPort = "5432";
        String dbName = "dvdrental";
        String dbUser ="user";
        String dbPassword = "user";

        dbUrl = "jdbc:postgresql://"+dbUrl + ":" +dbPort + "/" + dbName;

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser,dbPassword);
        } catch (SQLException e) {
     //       logger.error(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    protected String getQueryResult (String query)  {
    String result = "";
    //statement
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result = resultSet.next() ? resultSet.getString(1) : "";
            statement.close();;
            resultSet.close();
        } catch (SQLException e) {
   //         logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    protected List<String> getQueryResultAsList (String query) {
        List <String> queryResults = new ArrayList<>();
        String value = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int colums = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int index = 1; index<=colums; index++) {
                    value = resultSet.getObject(index).toString();

                queryResults.add(value);
            }
            }
            statement.close();
            statement.close();
        } catch (SQLException e) {
     //       logger.error(e.getMessage());
            e.printStackTrace();
        }
        return queryResults;
    }

    protected List <Map<String, Object>> getQueryResultAsMaps (String query) {
        List <Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> map;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int colums = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                map = new HashMap<String, Object> ();
                for (int index=1; index<=colums; index++) {
                    String key = resultSetMetaData.getColumnLabel(index);
                    Object object = resultSet.getObject(index);
                    map.put(key, object);
                }
                result.add(map);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
     //       logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}




