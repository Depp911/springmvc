package com.jayne.service;

import com.jayne.dao.User;

import java.util.List;

/**
 * Created by vikin on 2018/11/27.
 */
public interface UserService {

    List<User> getAllUsers();

    boolean addUser(User user);

    boolean addUser2(User user);
}
