package com.automationpractice.utilities;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class);
    private static  Connection connection;


    static {
    init();
    }

    private static void init () {
        if (connection == null) connection = new DatabaseConnection().getConnection();
    }

    public static void closeDbConnection () {
        if (connection != null) {
            try {
                connection.close();
                connection=null;
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    protected DatabaseConnection () {}

    private  Connection getConnection () {
        Connection connection = null;
        String dbUrl = AppProperties.DB_URL;
        String dbPort = AppProperties.DB_PORT;
        String dbName = AppProperties.DB_NAME;
        String dbUser =AppProperties.DB_USER;
        String dbPassword = AppProperties.DB_PASSWORD;

        dbUrl = "jdbc:mysql://"+dbUrl + ":" +dbPort + "/" + dbName;

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser,dbPassword);
        } catch (SQLException e) {
            logger.error(e.getMessage());
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
            logger.error(e.getMessage());
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
            logger.error(e.getMessage());
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
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }




}
