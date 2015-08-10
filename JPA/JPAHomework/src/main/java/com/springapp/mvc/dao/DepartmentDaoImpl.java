package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Created by rursu on 8/10/2015.
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insert(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @Override
    public void select(int departmentId) {
        //sessionFactory.getCurrentSession().load(Department.class, departmentId);
        Department department = entityManager.find(Department.class, departmentId);
    }

    @Override
    public void updateDepartment(Department department) {
        Department mergedDepartment = entityManager.merge(department);
        mergedDepartment.setName("updatedDepartment");
    }

    @Override
    public void deleteDepartment(int departmentId) {
        Department department = entityManager.find(Department.class, departmentId);
        entityManager.remove(department);
    }
}
