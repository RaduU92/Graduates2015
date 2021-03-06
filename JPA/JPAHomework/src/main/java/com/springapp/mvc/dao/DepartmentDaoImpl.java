package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Department;
import com.springapp.mvc.pojos.Employee;
import com.springapp.mvc.service.EmployeeService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rursu on 8/10/2015.
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void insert(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public Department select(int departmentId) {
        Department department = new Department("");
        List<Department> departments = sessionFactory.getCurrentSession().createCriteria(Department.class).add(Restrictions.eq("id", departmentId)).list();
        if (departments.size() == 1) {
            department.setId(departments.get(0).getId());
            department.setName(departments.get(0).getName());
        } else {
            if (departments.size() < 1) {
                department.setId(departmentId);
                department.setName("NU EXISTA!!!!");
            } else {
                department.setId(departmentId);
                department.setName("EXISTA MAI MULTE DEPARTAMENTE CU ACEST ID!!!");
            }
        }
        return department;
    }

    @Override
    public void updateDepartment(Department department) {
        sessionFactory.getCurrentSession().update(department);
    }

    @Override
    public void deleteDepartment(int departmentId) {
        Department department = (Department) sessionFactory.getCurrentSession().createCriteria(Department.class).add(Restrictions.eq("id", departmentId)).uniqueResult();
        if (department != null) {
            /*Trebuie setata nula legatura catre employee*/
//            List<Employee> employees = employeeService.selectEmployeesFromDepartment(departmentId);
//            for (Employee employee : employees) {
//                employee.setDeptId(null); //iau un departament care nu exista
//                employeeService.updateEmployee(employee);
//            }
            sessionFactory.getCurrentSession().delete(department);
         }
    }
}
