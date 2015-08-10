package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by rursu on 8/10/2015.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Employee employee) {
        entityManager.persist(employee);
        entityManager.flush();
    }

    @Override
    public void select(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee mergedEmployee = entityManager.merge(employee);
        mergedEmployee.setName("testName");
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
    }
}
