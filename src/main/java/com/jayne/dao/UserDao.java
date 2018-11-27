package com.jayne.dao;

import java.util.List;

/**
 * Created by Chenbin on 2017/10/11.
 */
public interface UserDao {

    List<User> getAll();

    User insert(User user);
}
