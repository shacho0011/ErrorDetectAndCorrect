/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shadhin
 */
public class Tax {
    private int id;
    private String fname;
    private String lname;
    private String gender;
    private int areaCode;
    private String phone;
    private String city;
    private String state;
    private int zip;
    private String marritalStatus;
    private String children;
    private int salary;
    private double rate;
    private int singleEx;
    private int marriedEx;
    private int childEx;

    public Tax() {
    }

    
    public Tax(String fname, String lname, String gender, int areaCode, String phone, String city, String state, int zip, String marritalStatus, String children, int salary, double rate, int singleEx, int marriedEx, int childEx) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.areaCode = areaCode;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.marritalStatus = marritalStatus;
        this.children = children;
        this.salary = salary;
        this.rate = rate;
        this.singleEx = singleEx;
        this.marriedEx = marriedEx;
        this.childEx = childEx;
    }

    public Tax(int aInt, String string, String string0, String string1, int aInt0, String string2, String string3, String string4, int aInt1, String string5, int aInt2, int aInt3, double aDouble, int aInt4, int aInt5, int aInt6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getChildEx() {
        return childEx;
    }

    public void setChildEx(int childEx) {
        this.childEx = childEx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getMarritalStatus() {
        return marritalStatus;
    }

    public void setMarritalStatus(String marritalStatus) {
        this.marritalStatus = marritalStatus;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getSingleEx() {
        return singleEx;
    }

    public void setSingleEx(int singleEx) {
        this.singleEx = singleEx;
    }

    public int getMarriedEx() {
        return marriedEx;
    }

    public void setMarriedEx(int marriedEx) {
        this.marriedEx = marriedEx;
    }
    
    
}
