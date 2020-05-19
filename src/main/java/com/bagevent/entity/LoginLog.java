package com.bagevent.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="userloginlog")
public class LoginLog {
    @Id
    @GeneratedValue
    @Column(name="login_id")
    private Integer login_id;
    @Column(name="user_id")
    private Integer user_id;
    @Column(name="login_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date login_time;
    @Column(name="login_ip")
    private String login_ip;

    public LoginLog() {
    }

    public LoginLog(Integer user_id, Date login_time, String login_ip) {
        this.user_id = user_id;
        this.login_time = login_time;
        this.login_ip = login_ip;
    }

    public Integer getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Integer login_id) {
        this.login_id = login_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "login_id=" + login_id +
                ", user_id=" + user_id +
                ", login_time='" + login_time + '\'' +
                ", login_ip='" + login_ip + '\'' +
                '}';
    }
}
