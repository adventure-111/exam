package cn.cuit.exam.web;

import cn.cuit.exam.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateStudentServlet", value = "/UpdateStudent")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求响应格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        // 获取参数
        String url = request.getParameter("url");
        Map<String, String[]> condition = request.getParameterMap();

        // 调用service修改
        StudentService service = new StudentService();
        service.updateStudent(condition);

        System.out.println(url);
        // 重定向
        response.sendRedirect(request.getContextPath()+url);
    }
}
