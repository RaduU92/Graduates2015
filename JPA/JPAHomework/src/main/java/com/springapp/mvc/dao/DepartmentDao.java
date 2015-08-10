package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Department;

/**
 * Created by rursu on 8/10/2015.
 */
public interface DepartmentDao {
    void insert(Department department);
    void select(int departmentId);
    void updateDepartment(Department department);
    void deleteDepartment(int departmentId);
}
