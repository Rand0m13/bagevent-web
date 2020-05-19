package com.bagevent.service.impl;

import com.bagevent.dao.UserDao;
import com.bagevent.entity.LoginLog;
import com.bagevent.entity.User;
import com.bagevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao UserDao;

    @Override
    public void insertUser(User user) {
        UserDao.insertUser(user);
    }

    @Override
    public User selectUser(String cellphone) {
        return UserDao.selectUser(cellphone);
    }

    @Override
    public void insertLoginLog(LoginLog loginLog) {
        UserDao.insertLoginLog(loginLog);
    }

    @Override
    public List<LoginLog> show(Integer user_id) {
        return UserDao.show(user_id);
    }
}
