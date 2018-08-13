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
	  //���ñ���
    //�õ��û���������
    //����userservice�е�login()����������user����
    //�ж�user�Ƿ�Ϊ�ա�
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String account=req.getParameter("account");//��html�ļ��л�ȡ������û���
        String password=req.getParameter("password");
        String power=req.getParameter("power");
        resp.setContentType("text/html;charset=utf-8");//���ö�ȡ�ĸ�ʽ
        UserService sv=new UserServiceImpl();
        HttpSession session = req.getSession();
        User user = null;
        try {
            user = sv.login(account, password, power);//��service���е�login�����ж��û������������Ƿ���ȷ
            session.setAttribute("username", user.getUsername());
            session.setAttribute("useraccount", user.getAccount());
        } catch (Exception e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
            req.setAttribute("message", "�����쳣");
        }
        if(user==null){
            //��Ϊ�� д"�û��������벻ƥ��"
            resp.getWriter().print("�û��������벻ƥ��,3��֮����ת");
            //����2-��ʱ��ת
        	resp.setHeader("refresh", "3;url=/updown");
        }else{
            //3.2����Ϊ�� д"xxx:��ӭ����"
            resp.getWriter().print(user.getAccount()+":��ӭ����");
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
