package com.bagevent.controller;


import com.bagevent.entity.LoginLog;
import com.bagevent.entity.User;
import com.bagevent.service.UserService;
import com.bagevent.util.MD5Util;
import com.bagevent.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/reg")
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String cellphone = req.getParameter("cellphone");
        Timestamp ts = new Timestamp(System.currentTimeMillis());//精确到毫秒
        //java.sql.Date create_time= new java.sql.Date(new Date().getTime());

        User user = new User();
        user.setUser_name(username);
        //将密码md5加密
        MD5Util md5Util = new MD5Util();
        user.setPassword(md5Util.encode(password));
        user.setEmail(email);
        user.setCellphone(cellphone);
        user.setSalt(md5Util.encode(password));
        user.setState(1);
        user.setCreate_time(ts);

        System.out.println(user);
        userService.insertUser(user);
        resp.sendRedirect("/views/login.jsp");
    }

    @RequestMapping("/login")
    @ResponseBody
    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String cellphone = req.getParameter("cellphone");//用户传来的手机号
        String password = req.getParameter("password");

        MD5Util md5Util = new MD5Util();
        password=md5Util.encode(password);//用户传来的密码

        User user = new User();
        user=userService.selectUser(cellphone);

        if (password.equals(user.getPassword())){
            System.out.println("密码正确");
            req.setAttribute("user",user);
            req.getRequestDispatcher("/loginlog").forward(req,resp);

        } else {
            System.out.println("密码错误");
            resp.sendRedirect("/views/login.jsp");
        }

    }

    @RequestMapping("/loginlog")
    @ResponseBody
    public void loginLog(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //插入登录记录
        Timestamp ts = new Timestamp(System.currentTimeMillis());//精确到毫秒
        LoginLog loginLog = new LoginLog();
        User user = (User) req.getAttribute("user");

        Integer login_user_id = user.getUser_id();//用户登陆时记住的id
        //System.out.println("传过来了吗"+login_user_id);

        loginLog.setUser_id(login_user_id);
        loginLog.setLogin_time(ts);
        String login_ip = req.getRemoteAddr();
        System.out.println(login_ip);
        loginLog.setLogin_ip(login_ip);
        req.setAttribute("id",login_user_id);

        userService.insertLoginLog(loginLog);

        //resp.sendRedirect("/show");
        req.getRequestDispatcher("/views/show.jsp").forward(req,resp);
    }


    @RequestMapping("/show")
    @ResponseBody
    public AjaxResult show(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        System.out.println("进入show");
        Integer login_user_id = Integer.valueOf(req.getParameter("id"));
        System.out.println("传过来了吗"+login_user_id);
        List<LoginLog> list = userService.show(login_user_id);
        System.out.println(list.toString());
        AjaxResult result = new AjaxResult();
        result.setObj(list);
        result.setMsg("success");
        return result;
    }

}
