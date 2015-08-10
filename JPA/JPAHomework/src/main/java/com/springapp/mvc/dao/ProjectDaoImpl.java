package com.springapp.mvc.dao;

import com.springapp.mvc.pojos.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by rursu on 8/10/2015.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Project project) {
        entityManager.persist(project);
        entityManager.flush();
    }

    @Override
    public void select(int projectId) {
        Project project = entityManager.find(Project.class, projectId);
    }

    @Override
    public void updateProject(Project project) {
        Project mergedProject = entityManager.merge(project);
        mergedProject.setName("updatedName");
        mergedProject.setDescription("updatedDescription");
        mergedProject.setProjectManager("newManager");
    }

    @Override
    public void deleteProject(int projectId) {
        Project project = entityManager.find(Project.class, projectId);
        entityManager.remove(project);
    }
}
