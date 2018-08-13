package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.domain.Upfile;
import com.my.domain.User;
import com.my.service.BusinessService;
import com.my.service.UserService;
import com.my.serviceimp.BusinessServiceImpl;
import com.my.serviceimp.UserServiceImpl;

public class AddUserServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String account=request.getParameter("account");
	        String password =request.getParameter("password");
	        String username=request.getParameter("username");
	        String academy=request.getParameter("academy");
	        String major =request.getParameter("major");
	        String birthday =request.getParameter("birthday");
	        String power=request.getParameter("power");
	        response.setContentType("text/html;charset=utf-8");
	        User user=new User();
	        user.setAccount(account);
	        user.setPassword(password);
	        user.setUsername(username);
	        user.setAcademy(academy);
	        user.setMajor(major);
	        user.setBirthday(birthday);
	        user.setPower(power);
	        UserService userService=new UserServiceImpl();
	        userService.addUser(user);
	        request.getRequestDispatcher("/WEB-INF/pages/usermanage.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
}
