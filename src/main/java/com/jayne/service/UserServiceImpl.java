package com.jayne.service;

import com.jayne.api.Executable;
import com.jayne.api.TransactionApi;
import com.jayne.dao.User;
import com.jayne.dao.UserDao;
import com.jayne.dao.UserLoginInfo;
import com.jayne.dao.UserLoginInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vikin on 2018/11/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserLoginInfoDao userLoginInfoDao;

    @Autowired
    TransactionApi transactionApi;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        boolean result = addUserWithoutTx(user);
//        int i = Integer.valueOf("dffd");
        return result;
    }

    @Override
    public boolean addUser2(User user) {
        return transactionApi.runInTransaction(new Executable<Boolean>() {
            @Override
            public Boolean exec() {
                return addUserWithoutTx(user);
            }
        });
    }

    private boolean addUserWithoutTx(User user){
        User result = userDao.insert(user);
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserId(result.getId());
        userLoginInfoDao.add(userLoginInfo);
        return true;
    }
}
