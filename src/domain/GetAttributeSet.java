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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import model.Treatment;
import thesisproject.AprioriAlgo;
import thesisproject.AprioriAlgoTest;
import thesisproject.TestClass;

/**
 *
 * @author Shadhin
 */
public class GetAttributeSet {

    MySqlConnection sqlConnection = new MySqlConnection();
    Connection connection = null;
    Statement stmt = null;
    ResultSetMetaData rsmd = null;
    ResultSet rs = null;
    String sql = "";
    List list;
    List column = new LinkedList();

    public List getAttributeSet(String tableName) {
        sql = "select * from " + tableName;
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                list = new LinkedList();
                if (!rsmd.getColumnName(i).equalsIgnoreCase("id")) {
                    String columnName = rsmd.getColumnName(i);
                    list.add(columnName);
                    column.add(list);
                }
                
            }

            
            rs.close();
            stmt.close();
            connection.close();
//            AprioriAlgoTest aprioriAlgo = new AprioriAlgoTest();
//            aprioriAlgo.test(list, columnCount-1);
//            System.out.print(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return column;
    }
}
