package com.springapp.mvc.service;

import com.springapp.mvc.dao.EmployeeDao;
import com.springapp.mvc.pojos.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by RaDU on 11.08.2015.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void insert(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    @Transactional
    public Employee select(int employeeId) {
        return employeeDao.select(employeeId);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }
}
