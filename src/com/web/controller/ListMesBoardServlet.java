package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.domain.MessageBoard;
import com.my.service.MesBoardService;
import com.my.serviceimp.MesBoardServiceImpl;

public class ListMesBoardServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		MesBoardService service=new MesBoardServiceImpl();
		List<MessageBoard> Meslist=service.getAll();
		request.setAttribute("Meslist", Meslist);
		request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
