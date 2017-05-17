/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import model.Customer;
import model.Employee;
import model.Master;
import model.Md;
import model.Tax;
import model.Treatment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import model.TempTestEmp;
import model.TestEmp;

/**
 *
 * @author Shadhin
 */
public class DisplayData {

    MySqlConnection sqlConnection = new MySqlConnection();
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    String sql = "";

    public ArrayList<Customer> getCustomer() {
        sql = "select * from customer";
        Customer customer;
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("SSN"), rs.getString("Name"), rs.getString("Phone"), rs.getDouble("CFPhone"), rs.getString("Street"), rs.getString("City"), rs.getInt("CountryCode"));
                customerList.add(customer);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    // SSN='"+ssn+"' and Name='"+name+"' and Phone='"+phone+"' and CFPhone='"+cfPhone+"' and Street='"+street+"' and City='"+city+"' and CountryCode='"+cc+"'
    public ArrayList<Customer> getSelectedCustomer(String ssn, String name, String phone, String cfPhone, String street, String city, int cc) {
        sql = "select * from customer where SSN='" + ssn + "' or 1=1) and (Name='" + name + "' or 1=1) and (Phone='" + phone + "' or 1=1) and (CFPhone='" + cfPhone + "' or 1=1) and (Street='" + street + "' or 1=1) and (City='" + city + "' or 1=1) and (CountryCode='" + cc + "' or 1=1)";
        Customer customer;
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("SSN"), rs.getString("Name"), rs.getString("Phone"), rs.getDouble("CFPhone"), rs.getString("Street"), rs.getString("City"), rs.getInt("CountryCode"));
                customerList.add(customer);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public ArrayList<Employee> getEmployee() {
        sql = "select * from employee";
        Employee emp;
        ArrayList<Employee> empList = new ArrayList<Employee>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                emp = new Employee(rs.getInt("ID"), rs.getString("Name"), rs.getString("Department"), rs.getInt("Salary"), rs.getString("Manager"));
                empList.add(emp);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }

    public ArrayList<Master> getMaster() {
        sql = "select * from master";
        Master master;
        ArrayList<Master> masterList = new ArrayList<Master>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                master = new Master(rs.getInt("ID"), rs.getString("SSN"), rs.getString("Name"), rs.getString("Phone"), rs.getString("Street"), rs.getString("City"));
                masterList.add(master);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return masterList;
    }

    public ArrayList<Md> getMd() {
        sql = "select * from md";
        Md md;
        ArrayList<Md> mdList = new ArrayList<Md>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                md = new Md(rs.getInt("ID"), rs.getString("Name"), rs.getString("Department"), rs.getInt("Salary"), rs.getString("Manager"));
                mdList.add(md);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mdList;
    }

    public ArrayList<Tax> getTax() {
        sql = "select * from tax";
        Tax tax;
        ArrayList<Tax> taxList = new ArrayList<Tax>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tax = new Tax(rs.getInt("ID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Gender"), rs.getInt("AreaCode"), rs.getString("Phone"), rs.getString("City"), rs.getString("Statet"), rs.getInt("Zip"), rs.getString("MarritalStatus"), rs.getInt("Children"), rs.getInt("Salary"), rs.getDouble("Rate"), rs.getInt("SingleExEmp"), rs.getInt("MarriedExEmp"), rs.getInt("ChildExEmp"));
                taxList.add(tax);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taxList;
    }

    public ArrayList<Treatment> getTreatments() {
        sql = "select * from treatments";
        Treatment treat;
        ArrayList<Treatment> treatList = new ArrayList<Treatment>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                treat = new Treatment(rs.getInt("ID"), rs.getString("SSN"), rs.getInt("Salary"), rs.getDate("Date"), rs.getString("Treatment"), rs.getString("Insurance"));
                treatList.add(treat);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return treatList;
    }

    public List getColumnValues(String column) {
        List value = new LinkedList();
        TestEmp testEmp;
        sql = "select " + column + " from test_emp order by rand() limit 1";
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            rs.next();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String name = rsmd.getColumnName(i);
                String type = rsmd.getColumnTypeName(i);
//                System.out.println("Type: " + type);
                if (type.equalsIgnoreCase("int")) {
                    value.add(rs.getInt(name));
//                    System.out.println("int");
                } else if (type.equalsIgnoreCase("float")) {
                    value.add(rs.getFloat(name));
//                    System.out.println("float");
                } else if (type.equalsIgnoreCase("double")) {
                    value.add(rs.getDouble(name));
//                    System.out.println("double");
                } else if (type.equalsIgnoreCase("varchar")) {
                    value.add(rs.getString(name));
//                    System.out.println("String");
                }
            }
            rs.close();
            stmt.close();
            connection.close();
//            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public void getValue(String column, String where) {
        sql = "select " + column + " from test_emp where " + where;
        System.out.println("SQL: " + sql);
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();

            while (rs.next()) {
                System.out.println("-------------");
                for (int i = 1; i <= size; i++) {
                    String name = rsmd.getColumnName(i);
                    String type = rsmd.getColumnTypeName(i);
                    if (type.equalsIgnoreCase("int")) {
                        int value = rs.getInt(name);
                        System.out.println(value);
                    } else if (type.equalsIgnoreCase("float")) {
                        float value = rs.getFloat(name);
                        System.out.println(value);
                    } else if (type.equalsIgnoreCase("double")) {
                        double value = rs.getDouble(name);
                        System.out.println(value);
                    } else if (type.equalsIgnoreCase("varchar")) {
                        String value = rs.getString(name);
                        System.out.println(value);
                    }
                }
            }
            rs.close();
            stmt.close();
            connection.close();
//            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTempDtatabase(String where) {
        sql = "select * from test_emp where " + where;
//        System.out.println("SQL: " + sql);
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();

            Statement stmt1 = connection.createStatement();
            
            stmt1.execute("delete from temp_test_emp");
            while (rs.next()) {
                int id = rs.getInt("id");
                String fn = rs.getString("fn");
                String ln = rs.getString("ln");
                int cc = rs.getInt("cc");
                int ac = rs.getInt("ac");
                String phn = rs.getString("phn");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String zip = rs.getString("zip");
                int salary = rs.getInt("salary");
                String status = rs.getString("status");
                String update = "insert into temp_test_emp (id, fn, ln, cc, ac, phn, street, city, zip, salary, status) values('" + id + "','" + fn + "','" + ln + "','" + cc + "','" + ac + "','" + phn + "','" + street + "','" + city + "','" + zip + "','" + salary + "','" + status + "')";
                stmt1.executeUpdate(update);
            }
            rs.close();
            stmt.close();
            connection.close();
//            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void computeFrequency(String column) {
        sql = "select distinct " + column + " from temp_test_emp";
//        System.out.println("ComputeFrequency SQL: " + sql);
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();
            
//            String where = "";
            
//            Statement stmt1 = connection.createStatement();
            while (rs.next()) {
//                System.out.println("How Much");
                String where = "";
//                System.out.println("-------------");
                int count = size;
                for (int i = 1; i <= size; i++) {
                    String name = rsmd.getColumnName(i);
                    String type = rsmd.getColumnTypeName(i);
                    if (type.equalsIgnoreCase("int")) {
                        int value = rs.getInt(name);
                        where = where + name + "="+'"'+value+'"';
//                        System.out.println(value);
                    } else if (type.equalsIgnoreCase("float")) {
                        float value = rs.getFloat(name);
                        where = where + name + "="+'"'+value+'"';
//                        System.out.println(value);
                    } else if (type.equalsIgnoreCase("double")) {
                        double value = rs.getDouble(name);
                        where = where + name + "="+'"'+value+'"';
//                        System.out.println(value);
                    } else if (type.equalsIgnoreCase("varchar")) {
                        String value = rs.getString(name);
                        where = where + name + "="+'"'+value+'"';
//                        System.out.println(value);
                    }
                    if(count>1){
                        where = where + " and ";
                        count--;
                    }
                }
//                System.out.println("F where: "+ where);
                frequency(where);
            }
            rs.close();
            stmt.close();
            connection.close();
//            System.out.println("Close calculateFrequency!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void frequency(String where) {
        sql = "select * from temp_test_emp where "+where;
//        System.out.println("Frequency SQL: " + sql);
        try {
            connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int freq=0;
            Statement stmt1 = connection.createStatement();
            while (rs.next()) {
                freq++;
            }
//            System.out.println("Frequency: "+ freq);
            stmt1.execute("update temp_test_emp set frequency="+'"'+freq+'"'+"where "+where);
            rs.close();
            stmt.close();
            stmt1.close();
//            connection.close();
//            System.out.println("Close Frequency!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<TempTestEmp> getTempTestEmp() {
        sql = "select * from temp_test_emp";
        TempTestEmp tempTestEmp;
        ArrayList<TempTestEmp> arrayList = new ArrayList<TempTestEmp>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tempTestEmp = new TempTestEmp(rs.getInt("id"), rs.getString("fn"), rs.getString("ln"), rs.getInt("cc"), rs.getInt("ac"),rs.getString("phn"), rs.getString("street"), rs.getString("city"), rs.getString("zip"), rs.getInt("salary"), rs.getString("status"), rs.getInt("frequency"));
                arrayList.add(tempTestEmp);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    
    public ArrayList<TestEmp> getTestEmp() {
        sql = "select * from test_emp";
        TestEmp testEmp;
        ArrayList<TestEmp> arrayList = new ArrayList<TestEmp>();
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                testEmp = new TestEmp(rs.getInt("id"), rs.getString("fn"), rs.getString("ln"), rs.getInt("cc"), rs.getInt("ac"),rs.getString("phn"), rs.getString("street"), rs.getString("city"), rs.getString("zip"), rs.getInt("salary"), rs.getString("status"));
                arrayList.add(testEmp);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    
    public float getAvgFrequency(){
        sql = "select frequency from temp_test_emp";
        int i=0;
            float avg = 0;
        try {
            connection = sqlConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                avg+=rs.getInt("frequency");
                i++;
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Close!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avg/i;
    }
    
    public void errDataSelection(float avgFrq) {
        sql = "insert into error_data select * from temp_test_emp where frequency < "+ avgFrq;
//        System.out.println("Frequency SQL: " + sql);
        try {
            connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute("delete from error_data");
            stmt.executeUpdate(sql);
            rs.close();
            stmt.close();
//            connection.close();
//            System.out.println("Close Frequency!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public HashMap valueCounter(String columnName){
        sql = "select distinct "+columnName+" from temp_test_emp";
        //String type = rsmd.getColumnTypeName(1);
            HashMap<String, Integer> topValue = new HashMap<>();
        try {
            connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            Statement stmt1 = connection.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int n= rsmd.getColumnCount();
            
            
            while(rs.next()){
                String type = rsmd.getColumnTypeName(1);
                System.out.println("TYPE: "+type);
                String where="";
                switch(type.toLowerCase()){
                    case "int": where = where + rs.getInt(columnName);break;
                    case "float": where = where + rs.getFloat(columnName);break;
                    case "double": where = where + rs.getFloat(columnName);break;
                    case "varchar": where = where + rs.getString(columnName);break;
                    default: break;
                }
                System.out.println("WHere: "+where);
                String tempSQL = "select "+columnName+" from temp_test_emp where "+columnName+"="+"'"+where+"'";
                ResultSet rs1 = stmt1.executeQuery(tempSQL);
                int value = 0;
                while(rs1.next())
                    value++;
                System.out.println(columnName + " Value: "+ value);
                topValue.put(where, value);
            }
            //rs.close();
            stmt.close();
//            connection.close();
//            System.out.println("Close Frequency!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("toP valuE: "+ topValue);
    return topValue;
    }
    
}
