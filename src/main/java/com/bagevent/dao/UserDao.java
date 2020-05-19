package com.bagevent.dao;

import com.bagevent.entity.LoginLog;
import com.bagevent.entity.User;

import java.util.List;

public interface UserDao {
    void insertUser (User user);
    User selectUser (String cellphone);
    void insertLoginLog (LoginLog loginLog);
    List<LoginLog> show (Integer user_id);
}
