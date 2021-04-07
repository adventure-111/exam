package cn.cuit.exam.web;

import cn.cuit.exam.domain.Admin;
import cn.cuit.exam.domain.PageBean;
import cn.cuit.exam.domain.Student;
import cn.cuit.exam.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "studentData", value = "/studentData")
public class QueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求响应格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        // 获取参数
        String currentPage = request.getParameter("currentPage");   // 当前页数
        String rows = request.getParameter("rows");                 // 每页条数
        Admin user = (Admin)request.getSession(false).getAttribute("user");
        String school = user.getSchool();                              // 所在学院
        Map<String, String[]> condition = request.getParameterMap();    //查询条件

        // 调用service查询
        StudentService service = new StudentService();
        PageBean<Student> pageBean = service.queryStudent(currentPage, rows, school, condition);

        // 将pageBean存入request中
        request.setAttribute("pageBean", pageBean);
        // 将查询条件存入request中
        request.setAttribute("condition", condition);

        // 转发
        request.getRequestDispatcher("/studentData.jsp").forward(request,response);

    }
}
