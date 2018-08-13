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

    // 跳转到jsp，显示上传页面
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/addfile.jsp").forward(request, response);
        

    }

    // 处理上传
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            request.setAttribute("message", "不支持的操作");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }

        try {
            /*
             * WebUtils工具类内部会从request里面取数据，把上传文件保存下来，
             * 并且还会把上传文件信息封装到一个Upfile对象里面返回给你。
             */
            String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
            Upfile upfile = WebUtils.doUpload(request, savepath);

            BusinessService service = new BusinessServiceImpl();
            service.addUpfile(upfile);

            request.setAttribute("message", "上传成功！！！");
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            // 明显知道是什么异常(在我预期的范围之内)，就没必要记录异常
            request.setAttribute("message", "文件不能超过500M！！！");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "上传失败！！！");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

}