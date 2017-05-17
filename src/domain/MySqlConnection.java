/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Shadhin
 */
import java.sql.*;

public class MySqlConnection {

    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/edc?zeroDateTimeBehavior=convertToNull";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    Connection connection = null;
    Statement stmt;

    public Connection getConnection() {

        try {
            Class.forName(DB_DRIVER);
            //System.out.println("Loading...");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //System.out.println("Connecting...");
            stmt = connection.createStatement();
            //System.out.println("Connection OK!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
