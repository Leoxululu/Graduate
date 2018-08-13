package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.jms.Session;
import javax.mail.internet.NewsAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.wrappers.StringTrimmedResultSet;

import com.my.domain.MessageBoard;
import com.my.domain.Upfile;
import com.my.service.BusinessService;
import com.my.service.MesBoardService;
import com.my.serviceimp.BusinessServiceImpl;
import com.my.serviceimp.MesBoardServiceImpl;

public class LeaveMessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			HttpSession session = request.getSession();
			String username= (String) session.getAttribute("username");
			String account=(String) session.getAttribute("useraccount");
			Date uptime=new Date(System.currentTimeMillis());
			String title=request.getParameter("title");
			String description=request.getParameter("description");
			MessageBoard message=new MessageBoard();
			message.setAccount(account);
			message.setName(username);
			message.setTitle(title);
			message.setUptime(uptime);
			message.setDescription(description);
			MesBoardService mesBoardService=new MesBoardServiceImpl();
			mesBoardService.addMessage(message);
			request.getRequestDispatcher("/page/messageBoard.jsp");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	this.doGet(request, response);
    }

}
