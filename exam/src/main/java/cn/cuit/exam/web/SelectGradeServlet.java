package cn.cuit.exam.web;

import cn.cuit.exam.dao.StudentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectGrade", value = "/SelectGrade")
public class SelectGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应和请求的格式
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        // 获取参数
        String school = request.getParameter("school");

        // 查询年级
        StudentDao dao = new StudentDao();
        List<String> grades = dao.getGrades(school);

        // 拼接json字符串
        StringBuilder json = new StringBuilder("[ ");
        for (String grade: grades) {
            json.append("{ \"name\": \"");
            json.append(grade);
            json.append("\" },");
        }
        String endsql = json.substring(0, json.length()-1) + " ]";
        System.out.println("endsql"+endsql);

        // 响应
        response.getWriter().print(endsql);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
