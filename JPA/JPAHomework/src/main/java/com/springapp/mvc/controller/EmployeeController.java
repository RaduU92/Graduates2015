package com.springapp.mvc.controller;

import com.springapp.mvc.pojos.Department;
import com.springapp.mvc.pojos.Employee;
import com.springapp.mvc.service.DepartmentService;
import com.springapp.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.Calendar;

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

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        Department department = departmentService.select(2);
        //Date date = getDate(1990,1,1);
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

        employeeService.insert(new Employee("employee1", 1000, department, "strada", "oras", "stat", "zip", date));
        employeeService.insert(new Employee("employee2", 1100, department, "strada", "oras", "stat", "zip", date));
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
        //Date date = getDate(1992, 10, 10);
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

        Employee employee = new Employee("update", 1200, department, "strada", "oras", "stat", "zip", date);
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

    public Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return new Date(calendar.getTimeInMillis());
    }
}
