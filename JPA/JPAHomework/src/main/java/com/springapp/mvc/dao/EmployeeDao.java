package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Employee;

import java.util.List;

/**
 * Created by rursu on 8/10/2015.
 */
public interface EmployeeDao {
    void insert(Employee employee);

    Employee select(int employeeId);

    List<Employee> selectEmployeesFromDepartment(int departmentId);

    void updateEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
