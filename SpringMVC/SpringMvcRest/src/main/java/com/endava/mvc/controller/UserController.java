package com.endava.mvc.controller;

import com.endava.mvc.model.User;
import com.endava.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cudrescu on 8/4/2015.
 */
//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<User> getUserSecondEx(@RequestParam("id") Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return null;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User username) {
        System.out.println(username.getFirstName());
        return null;
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable String userId) {
        return true;
    }

}
