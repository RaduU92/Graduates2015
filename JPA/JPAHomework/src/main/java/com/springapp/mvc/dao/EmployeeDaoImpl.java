package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Employee;
import com.springapp.mvc.service.EmployeeService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rursu on 8/10/2015.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public Employee select(int employeeId) {
        Employee employee = new Employee();
        List<Employee> employees = sessionFactory.getCurrentSession().createCriteria(Employee.class).add(Restrictions.eq("id", employeeId)).list();
        if (employees.size() == 1) {
            employee.setId(employees.get(0).getId());
            employee.setName(employees.get(0).getName());
            employee.setBirthday(employees.get(0).getBirthday());
            employee.setCity(employees.get(0).getCity());
            employee.setDeptId(employees.get(0).getDeptId());
            employee.setSalary(employees.get(0).getSalary());
            employee.setState(employees.get(0).getState());
            employee.setStreet(employees.get(0).getStreet());
            employee.setZipCode(employees.get(0).getZipCode());
        } else {
            if (employees.size() < 1) {
                employee.setId(employeeId);
                employee.setName("NU EXISTA!!!!");
            } else {
                employee.setId(employeeId);
                employee.setName("EXISTA MAI MULTI ANGAJATI CU ACEST ID!!!");
            }
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().createCriteria(Employee.class).add(Restrictions.eq("id", employeeId)).uniqueResult();
        if (employee != null) {
            sessionFactory.getCurrentSession().delete(employee);
        }
    }
}
