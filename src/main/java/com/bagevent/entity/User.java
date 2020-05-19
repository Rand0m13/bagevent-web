package com.bagevent.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Integer user_id;
    @Column(name="user_name")
    private String user_name;
    @Column(name="email")
    private String email;
    @Column(name="cellphone")
    private String cellphone;
    @Column(name="password")
    private String password;
    @Column(name="salt")
    private String salt;
    @Column(name="state")
    private Integer state;
    @Column(name="create_time")
    private Date create_time;

    public User() {
    }

    public User(Integer user_id,  String password) {
        super();
        this.user_id = user_id;
        this.password = password;

    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", create_time=" + create_time +
                '}';
    }
}
