package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.domain.Upfile;
import com.my.service.BusinessService;
import com.my.serviceimp.BusinessServiceImpl;

public class a extends HttpServlet {

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        BusinessService service = new BusinessServiceImpl();
	        List<Upfile> list = service.getAllUpfile();
	        request.setAttribute("list", list);
	        request.getRequestDispatcher("/WEB-INF/pages/listfile.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }


}