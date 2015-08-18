package com.springapp.mvc.controller;

import com.springapp.mvc.pojos.Department;
import com.springapp.mvc.service.DepartmentService;
import com.springapp.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RaDU on 10.08.2015.
 */
@Controller
//@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    @RequestMapping(value = "/insert", method = RequestMethod.GET)
//    @ResponseBody
    public String insert(@RequestBody String a) {
        departmentService.insert(new Department("Test"));
        departmentService.insert(new Department("asdadsa"));
        System.out.println(a);
        return "depAdd";
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
//    @ResponseBody
    public String select(ModelMap model, @PathVariable("id") int depId) {
//    public String select(@PathVariable("id") int depId) {
        Department department = departmentService.select(depId);
        String message = "Departamentul " + department.getId() + " : " + department.getName();
        model.addAttribute("message", message);
        return "depShow";
    }

    //    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    @ResponseBody
    public String update() {
        Department department = new Department("update");
        department.setId(1);
        departmentService.updateDepartment(department);
        return "depUp";
    }

    //    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") int depId) {
//        List<Employee> employees =  employeeService.selectEmployeesFromDepartment(1);
//        for(Employee employee : employees) {
//            employeeService.reseteEmployeeDepartment(employee);
//        }

        departmentService.deleteDepartment(depId);
        String message = "Departamentul cu id-ul " + depId + " a fost sters!";
        return "depDel";
    }
}
