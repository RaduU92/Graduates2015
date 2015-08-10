package com.springapp.mvc.service;

import com.springapp.mvc.dao.ProjectDao;
import com.springapp.mvc.pojos.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by RaDU on 11.08.2015.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    @Transactional
    public void insert(Project project) {
        projectDao.insert(project);
    }

    @Override
    @Transactional
    public Project select(int projectId) {
        return projectDao.select(projectId);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    @Override
    @Transactional
    public void deleteProject(int projectId) {
        projectDao.deleteProject(projectId);
    }
}
