package cn.cuit.exam.web;

import cn.cuit.exam.dao.MajorDao;
import cn.cuit.exam.domain.Admin;
import org.xml.sax.SAXNotRecognizedException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectMajor", value = "/SelectMajor")
public class SelectMajorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求响应格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        // 获取参数
//        Admin user = (Admin)request.getSession(false).getAttribute("user");
//        String school = user.getSchool();                              // 所在学院
        String school = request.getParameter("school");
        System.out.println("school"+school);

        // 查询学院专业
        MajorDao majorDao = new MajorDao();
        List<String> majorList = majorDao.getMajor(school);
        System.out.println("list:"+majorList);

        // 拼接json字符串
        StringBuilder json = new StringBuilder("[ ");
        for (String major: majorList) {
            json.append("{ \"name\": \"");
            json.append(major);
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
