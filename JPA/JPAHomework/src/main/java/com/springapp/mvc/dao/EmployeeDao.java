package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Department;
import com.springapp.mvc.pojos.Employee;

/**
 * Created by rursu on 8/10/2015.
 */
public interface EmployeeDao {
    void insert(Employee employee);
    Employee select(int employeeId);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}
