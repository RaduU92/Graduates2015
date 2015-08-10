package com.springapp.mvc.service;

import com.springapp.mvc.dao.DepartmentDao;
import com.springapp.mvc.pojos.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by RaDU on 10.08.2015.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional
    public void insert(Department department) {
        departmentDao.insert(department);
    }

    @Override
    @Transactional
    public Department select(int departmentId) {
        return departmentDao.select(1);
    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    @Override
    @Transactional
    public void deleteDepartment(int departmentId) {
        departmentDao.deleteDepartment(departmentId);
    }
}
