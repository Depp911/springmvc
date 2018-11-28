package com.jayne.dao;

import org.springframework.stereotype.Component;

/**
 * Created by vikin on 2018/11/28.
 */
@Component
public class UserLoginInfoDaoImpl extends BaseDao implements UserLoginInfoDao {

    @Override
    public UserLoginInfo add(UserLoginInfo userLoginInfo) {
        return dao.insert(userLoginInfo);
    }
}
