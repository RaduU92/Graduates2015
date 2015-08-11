package com.springapp.mvc.controller;

import com.springapp.mvc.pojos.Project;
import com.springapp.mvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RaDU on 11.08.2015.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        projectService.insert(new Project("Test","projectManager1","description1"));
        projectService.insert(new Project("asdadsa","projectManager2","description2"));
        return "proAdd";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(ModelMap model) {
        Project project = projectService.select(1);
        String message = "Proiectul " + project.getId() + " : " + project.getName();
        model.addAttribute("message", message);
        return "proShow";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        Project project = new Project("update","managerUpdated","descriptionUpdated");
        project.setId(1);
        projectService.updateProject(project);
        return "proUp";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(ModelMap model) {
        projectService.deleteProject(1);
        String message = "Proiectul cu id-ul 1 a fost sters!";
        model.addAttribute("message", message);
        return "proDel";
    }
}
