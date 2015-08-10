package com.springapp.mvc.controller;

import com.springapp.mvc.pojos.Department;
import com.springapp.mvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RaDU on 10.08.2015.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        departmentService.insert(new Department("Test"));
        departmentService.insert(new Department("asdadsa"));
        return "depAdd";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(ModelMap model) {
        Department department = departmentService.select(1);
        String message = "Departamentul " + department.getId() + " : " + department.getName();
        model.addAttribute("message", message);
        return "depShow";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        Department department = new Department("update");
        department.setId(1);
        departmentService.updateDepartment(department);
        return "depUp";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(ModelMap model) {
        departmentService.deleteDepartment(1);
        String message = "Departamentul cu id-ul 1 a fost sters!";
        model.addAttribute("message", message);
        return "depDel";
    }
}
