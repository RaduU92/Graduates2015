package com.springapp.mvc.controller;

import com.springapp.mvc.pojos.Department;
import com.springapp.mvc.pojos.Employee;
import com.springapp.mvc.pojos.Project;
import com.springapp.mvc.service.DepartmentService;
import com.springapp.mvc.service.EmployeeService;
import com.springapp.mvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RaDU on 11.08.2015.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        Department department = departmentService.select(2);
        Date date = new Date(new java.util.Date().getTime());
        employeeService.insert(new Employee("employee1", 1000, department, "strada", "oras", "stat", "zip", date, null));
        employeeService.insert(new Employee("employee2", 1100, department, "strada", "oras", "stat", "zip", date, null));
        return "EmpAdd";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(ModelMap model) {
        Employee employee = employeeService.select(1);
        String message = "Angajatul " + employee.getId() + " : " + employee.getName();
        model.addAttribute("message", message);
        return "EmpShow";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        Department department = departmentService.select(2);
        Date date = new Date(new java.util.Date().getTime());
        List<Project> projects = new ArrayList<Project>();
        projects.add(projectService.select(1));
        Employee employee = new Employee("update", 1200, department, "strada", "oras", "stat", "zip", date, projects);
        employee.setId(1);
        employeeService.updateEmployee(employee);
        return "EmpUp";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(ModelMap model) {
        employeeService.deleteEmployee(1);
        String message = "Angajatul cu id-ul 1 a fost sters!";
        model.addAttribute("message", message);
        return "EmpDel";
    }
}
