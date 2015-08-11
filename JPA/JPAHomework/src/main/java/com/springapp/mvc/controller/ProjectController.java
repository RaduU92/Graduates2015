package com.springapp.mvc.controller;

import com.springapp.mvc.pojos.Employee;
import com.springapp.mvc.pojos.Project;
import com.springapp.mvc.service.EmployeeService;
import com.springapp.mvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RaDU on 11.08.2015.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        projectService.insert(new Project("Test", "projectManager1", "description1", null));
        projectService.insert(new Project("asdadsa", "projectManager2", "description2", null));
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
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employeeService.select(2));
        Project project = new Project("update", "managerUpdated", "descriptionUpdated", employees);
        project.setId(2);
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
