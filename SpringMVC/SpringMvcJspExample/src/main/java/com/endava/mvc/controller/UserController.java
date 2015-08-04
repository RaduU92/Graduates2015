package com.endava.mvc.controller;

import com.endava.mvc.model.User;
import com.endava.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by cudrescu on 8/3/2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserView(Model model) {
        return "addUser";
    }

    @RequestMapping(value = "/addUser/save", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute("userForm") User user) {

        System.out.println(user.getFirstName());
        userService.addUser(user);

        return "redirect:listUsers";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public String deleteUser(Model model) {

        userService.deleteUser();

        return "redirect:listUsers";
    }

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public String listUsers(Model model) {

        List<User> userList = userService.listUsers();
        model.addAttribute("userList", userList);

        return "listUsers";
    }

}
