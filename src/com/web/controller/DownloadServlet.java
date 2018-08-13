package com.web.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.domain.Upfile;
import com.my.service.BusinessService;
import com.my.serviceimp.BusinessServiceImpl;

public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        BusinessService service = new BusinessServiceImpl();
        Upfile upfile = service.findUpfile(id);

        File file = new File(upfile.getSavepath() + "\\" + upfile.getUuidname());

        /*
         * ɾ���ļ���Ҫɾ��Ӳ���ϵ��ļ�����Ҫ�����ݿ�ļ�¼��ɾ����
         * 
         * file.delete();
         */
        if (!file.exists()) {
            request.setAttribute("message", "������Դ�ѱ�ɾ��������");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }

        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(upfile.getFilename(), "UTF-8"));

        FileInputStream in = new FileInputStream(file);
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = response.getOutputStream();
        while ((len=in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}