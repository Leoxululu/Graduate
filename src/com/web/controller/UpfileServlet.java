package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.my.domain.Upfile;
import com.my.service.BusinessService;
import com.my.serviceimp.BusinessServiceImpl;
import com.my.utils.WebUtils;

public class UpfileServlet extends HttpServlet {

    // ��ת��jsp����ʾ�ϴ�ҳ��
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/addfile.jsp").forward(request, response);
        

    }

    // �����ϴ�
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            request.setAttribute("message", "��֧�ֵĲ���");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }

        try {
            /*
             * WebUtils�������ڲ����request����ȡ���ݣ����ϴ��ļ�����������
             * ���һ�����ϴ��ļ���Ϣ��װ��һ��Upfile�������淵�ظ��㡣
             */
            String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
            Upfile upfile = WebUtils.doUpload(request, savepath);

            BusinessService service = new BusinessServiceImpl();
            service.addUpfile(upfile);

            request.setAttribute("message", "�ϴ��ɹ�������");
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            // ����֪����ʲô�쳣(����Ԥ�ڵķ�Χ֮��)����û��Ҫ��¼�쳣
            request.setAttribute("message", "�ļ����ܳ���500M������");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "�ϴ�ʧ�ܣ�����");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

}