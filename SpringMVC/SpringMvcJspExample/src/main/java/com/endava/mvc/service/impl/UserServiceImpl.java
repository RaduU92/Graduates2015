package com.endava.mvc.service.impl;

import com.endava.mvc.model.User;
import com.endava.mvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private List<User> userList = new ArrayList<User>();

    @Override
    public List<User> listUsers() {
        return this.userList;
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void deleteUser() {
    }

    @Override
    public void updateUser(User user) {
    }

}
