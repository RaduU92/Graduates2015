package com.endava.mvc.service;

import com.endava.mvc.model.User;

import java.util.List;

/**
 * Created by cudrescu on 8/3/2015.
 */
public interface UserService {

    public List<User> listUsers();

    public void addUser(User user);

    public void deleteUser();

    public void updateUser(User user);

}
