package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.domain.User;
import com.my.service.UserService;
import com.my.serviceimp.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	  //设置编码
    //得到用户名和密码
    //调用userservice中的login()方法，返回user对象
    //判断user是否为空。
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String account=req.getParameter("account");//从html文件中获取输入的用户名
        String password=req.getParameter("password");
        String power=req.getParameter("power");
        resp.setContentType("text/html;charset=utf-8");//设置读取的格式
        UserService sv=new UserServiceImpl();
        HttpSession session = req.getSession();
        User user = null;
        try {
            user = sv.login(account, password, power);//在service类中的login方法判断用户名或者密码是否正确
            session.setAttribute("username", user.getUsername());
            session.setAttribute("useraccount", user.getAccount());
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            req.setAttribute("message", "网络异常");
        }
        if(user==null){
            //若为空 写"用户名和密码不匹配"
            resp.getWriter().print("用户名和密码不匹配,3秒之后跳转");
            //案例2-定时跳转
        	resp.setHeader("refresh", "3;url=/updown");
        }else{
            //3.2若不为空 写"xxx:欢迎回来"
            resp.getWriter().print(user.getAccount()+":欢迎回来");
            switch (Integer.parseInt(user.getPower())) {
			case 1:
				req.setAttribute("account",account );
				req.getRequestDispatcher("/WEB-INF/pages/student.jsp").forward(req, resp);
				break;
			case 2:
				req.getRequestDispatcher("/WEB-INF/pages/teacher.jsp").forward(req, resp);
				break;
			case 3:
	            req.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(req, resp);
			}
            }
        }
    }
