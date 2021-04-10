package cn.cuit.exam.web;

import cn.cuit.exam.dao.StudentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "deleteStudent", value = "/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String[] stuIDS= request.getParameterValues("id");

        StudentDao dao = new StudentDao();
        dao.delete(Arrays.asList(stuIDS));

    }
}
