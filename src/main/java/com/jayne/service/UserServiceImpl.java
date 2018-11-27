package com.jayne.service;

import com.jayne.dao.User;
import com.jayne.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vikin on 2018/11/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public boolean addUser(User user) {
        User result = userDao.insert(user);
        return true;
    }
}
