/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Shadhin
 */
public class InsertData {

    MySqlConnection mySqlConnection = new MySqlConnection();
    Connection connection = null;
    Statement stmt = null;
    String sql = "";

    public void insertCustomer(String ssn, String name, String phone, double cfPhone, String street, String city, int countryCode) {
        sql = "insert into customer(SSN, Name, Phone, CFPhone, Street, City, CountryCode) values('" + ssn + "','" + name + "','" + phone + "','" + cfPhone + "','" + street + "','" + city + "','" + countryCode + "')";
        try {
            connection = mySqlConnection.getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertEmployee(String name, String dept, int salary, String manager) {
        sql = "insert into employee(Name, Department, Salary, Manager) values('" + name + "','" + dept + "','" + salary + "','" + manager + "')";
        try {
            connection = mySqlConnection.getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertMaster(String ssn, String name, String phone, String street, String city) {
        sql = "insert into master(SSN, Name, Phone, Street, City) values('" + ssn + "','" + name + "','" + phone + "','" + street + "','" + city + "')";
        try {
            connection = mySqlConnection.getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertMd(String name, String dept, int salary, String manager) {
        sql = "insert into md(Name, Department, Salary, Manager) values('" + name + "','" + dept + "','" + salary + "','" + manager + "')";
        try {
            connection = mySqlConnection.getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertTax(String fname, String lname, String gender, int areaCode, String phone, String city, String state, int zip, String marritalStatus, String child, int salary, double rate, int singleEx, int marriedEx, int childEx) {
        sql = "insert into tax(FirstName, LastName, Gender, AreaCode, Phone, City, State, Zip, MarritalStatus, Children, Salary, Rate, SingleExEmp, MarriedExEmp, ChildExEmp) values('" + fname + "','" + lname + "','" + gender + "','" + areaCode + "','" + phone + "','" + city + "','" + state + "','" + zip + "','" + marritalStatus + "','" + child + "','" + salary + "','" + rate + "','" + singleEx + "','" + marriedEx + "','" + childEx + "')";
        try {
            connection = mySqlConnection.getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertTreatment(String ssn, int salary, Date date, String treatment, String insurance) {
        sql = "insert into treatments(SSN, Salary, Date, Treatment, Insurance) values('" + ssn + "','" + salary + "','" + date + "','" + treatment + "','" + insurance + "')";
        try {
            connection = mySqlConnection.getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
