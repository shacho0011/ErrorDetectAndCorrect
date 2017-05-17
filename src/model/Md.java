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
public class Md {
    private int id;
    private String name;
    private String dept;
    private int salary;
    private String manager;

    public Md() {
    }
    
    

    public Md(int id, String name, String dept, int salary, String manager) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Md{" + "name=" + name + ", dept=" + dept + ", salary=" + salary + ", manager=" + manager + '}';
    }
    
    
    
}
