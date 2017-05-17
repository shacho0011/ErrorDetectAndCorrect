/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Shadhin
 */
public class Treatment {
    private int id;
    private String ssn;
    private int salary;
    private Date date;
    private String treat;
    private String insurance;

    public Treatment(int id, String ssn, int salary, Date date, String treat, String insurance) {
        this.id = id;
        this.ssn = ssn;
        this.salary = salary;
        this.date = date;
        this.treat = treat;
        this.insurance = insurance;
    }

    public Treatment() {
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTreat() {
        return treat;
    }

    public void setTreat(String treat) {
        this.treat = treat;
    }

    @Override
    public String toString() {
        return "Treatment{" + "ssn=" + ssn + ", salary=" + salary + ", date=" + date + ", treat=" + treat + ", insurance=" + insurance + '}';
    }
    
    
    
}
