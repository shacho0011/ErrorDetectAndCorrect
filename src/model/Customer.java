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
public class Customer {
    private int id;
    private String ssn;
    private String name;
    private String phone;
    private double cfPhone;
    private String street;
    private String city;
    private int countryCode;

    public Customer(int id, String ssn, String name, String phone, double cfPhone, String street, String city, int countryCode) {
        this.id = id;
        this.ssn = ssn;
        this.name = name;
        this.phone = phone;
        this.cfPhone = cfPhone;
        this.street = street;
        this.city = city;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCfPhone() {
        return cfPhone;
    }

    public void setCfPhone(double cfPhone) {
        this.cfPhone = cfPhone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }
    
}
