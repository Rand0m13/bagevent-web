package com.bagevent.dao.impl;

import com.bagevent.dao.UserDao;
import com.bagevent.entity.LoginLog;
import com.bagevent.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User selectUser(String cellphone) {
        String hql = "SELECT new User(u.user_id , u.password) FROM User u where u.cellphone=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,cellphone);
        List<User> list = query.list();
        return list.get(0);
    }

    @Override
    public void insertLoginLog(LoginLog loginLog) {
        sessionFactory.getCurrentSession().save(loginLog);
    }

    @Override
    public List<LoginLog> show(Integer user_id) {
        String hql = "FROM LoginLog l where l.user_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,user_id);
        List<LoginLog> list = query.list();
        return list;
    }
}
