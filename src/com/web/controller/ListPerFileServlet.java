package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.Daoimp.UpfileDaoImpl;
import com.my.dao.UpfileDao;
import com.my.domain.Upfile;
import com.my.service.BusinessService;
import com.my.serviceimp.BusinessServiceImpl;

public class ListPerFileServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ListPerFileServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account=request.getParameter("account");
		BusinessService service = new BusinessServiceImpl();
        List<Upfile> list = service.getPerUpfile(account);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/pages/perupfile.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
