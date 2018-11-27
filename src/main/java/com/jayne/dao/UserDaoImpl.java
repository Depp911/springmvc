package com.jayne.dao;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vikin on 2018/11/27.
 */
@Component
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public List<User> getAll() {
        return dao.query(User.class, null);
    }

    @Override
    public User insert(User user) {
        return dao.insert(user);
    }
}
