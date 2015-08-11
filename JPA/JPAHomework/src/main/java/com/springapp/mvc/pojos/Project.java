package com.springapp.mvc.pojos;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rursu on 8/10/2015.
 */
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name = "project_manager")
    private String projectManager;
    private String description;
    @ManyToMany(mappedBy = "projects", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Employee> employees;

    public Project(String name, String projectManager, String description, List<Employee> employees) {
        this.name = name;
        this.projectManager = projectManager;
        this.description = description;
        this.employees = employees;
    }

    public Project() {

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

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
