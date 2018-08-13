package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.domain.User;
import com.my.service.BusinessService;
import com.my.serviceimp.BusinessServiceImpl;

public class ListUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BusinessService service = new BusinessServiceImpl();
        List<User> user = service.getAllUser();
        request.setAttribute("User", user);
        
        
    	request.getRequestDispatcher("/WEB-INF/pages/usermanage.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
