package com.automationpractice.utilities;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class);

    private Connection getConnection () {
        Connection connection = null;
        String dbUrl = AppProperties.DB_URL;
        String dbPort = AppProperties.DB_PORT;
        String dbName = AppProperties.DB_NAME;
        String dbUser =AppProperties.DB_USER;
        String dbPassword = AppProperties.DB_PASSWORD;

        dbUrl = dbUrl + ":" +dbPort + "/" + dbName;

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser,dbPassword);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }


}
