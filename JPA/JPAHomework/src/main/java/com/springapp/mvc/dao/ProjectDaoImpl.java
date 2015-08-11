package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Project;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rursu on 8/10/2015.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Project project) {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    @Override
    public Project select(int projectId) {
        Project project = new Project();
        List<Project> projects = sessionFactory.getCurrentSession().createCriteria(Project.class).add(Restrictions.eq("id", projectId)).list();
        if (projects.size() == 1) {
            project.setId(projects.get(0).getId());
            project.setName(projects.get(0).getName());
            project.setDescription(projects.get(0).getDescription());
            project.setProjectManager(projects.get(0).getProjectManager());
            project.setEmployees(projects.get(0).getEmployees());
        } else {
            if (projects.size() < 1) {
                project.setId(projectId);
                project.setName("NU EXISTA!!!!");
                project.setDescription("-");
                project.setProjectManager("-");
            } else {
                project.setId(projectId);
                project.setName("EXISTA MAI MULTE DEPARTAMENTE CU ACEST ID!!!");
                project.setDescription("-");
                project.setProjectManager("-");
            }
        }
        return project;
    }

    @Override
    public void updateProject(Project project) {
        sessionFactory.getCurrentSession().update(project);
    }

    @Override
    public void deleteProject(int projectId) {
        Project project = (Project) sessionFactory.getCurrentSession().createCriteria(Project.class).add(Restrictions.eq("id", projectId)).uniqueResult();
        if (project != null) {
            sessionFactory.getCurrentSession().delete(project);
        }
    }
}
