package com.endava.mvc.service;

import com.endava.mvc.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by cudrescu on 8/4/2015.
 */
public interface UserService {

    public User saveUser(User user);

    public User getUser(Long id);

}
