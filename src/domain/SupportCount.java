/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Shadhin
 */
public class SupportCount {

    static MySqlConnection sqlConnection = new MySqlConnection();
    Connection connection = null;
    Statement stmt = null;
    ResultSetMetaData rsmd = null;
    ResultSet rs = null;
    String sql = "";
    List list = new LinkedList<>();

    public int getSupport(String tableName, String whereC) {
        sql = "select * from " + tableName + " where " + whereC;
//        System.out.println(sql);
        int i = 0;
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                i++;
//                System.out.println(i);
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public int distance(String column, String table) {
        sql = "select distinct "+column+" from " + table;
        int i = 0;
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                i++;
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
