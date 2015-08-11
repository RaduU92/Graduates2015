package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Project;

/**
 * Created by rursu on 8/10/2015.
 */
public interface ProjectDao {
    void insert(Project project);

    Project select(int projectId);

    void updateProject(Project project);

    void deleteProject(int projectId);
}
