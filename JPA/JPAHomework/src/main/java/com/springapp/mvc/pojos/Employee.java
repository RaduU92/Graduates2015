package com.springapp.mvc.pojos;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.List;

/**
 * Created by rursu on 8/10/2015.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int salary;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Department.class)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department deptId;
    private String street;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "birthday")
    @Type(type = "date")
    private Date birthday;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Project.class, cascade = CascadeType.ALL)
    @JoinTable(name = "emp_prj", joinColumns = {@JoinColumn(name = "emp_id")}, inverseJoinColumns = {@JoinColumn(name = "prj_id")})
    private List<Project> projects;

    public Employee(String name, int salary, Department deptId, String street, String city, String state, String zipCode, Date birthday, List<Project> projects) {
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.birthday = birthday;
        this.projects = projects;
    }

    public Employee() {

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDeptId() {
        return deptId;
    }

    public void setDeptId(Department deptId) {
        this.deptId = deptId;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
