package com.bagevent.service;

import com.bagevent.entity.LoginLog;
import com.bagevent.entity.User;

import java.util.List;

public interface UserService {
    void insertUser (User user);
    User selectUser (String cellphone);
    void insertLoginLog (LoginLog loginLog);
    List<LoginLog> show (Integer user_id);
}
