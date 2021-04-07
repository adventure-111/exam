package cn.cuit.exam.web;

//web

import cn.cuit.exam.dao.UserDao;
import cn.cuit.exam.domain.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/manage")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin loginUser = new Admin();
        loginUser.setUsername(username);
        loginUser.setPassword(password);


        if ( username == null || password == null) {    // 直接输入 /exam/manage 的情况
            HttpSession mysession = req.getSession(false);
            if ( (Admin)mysession.getAttribute("user") == null ) {
                // 未登录跳转到登录提示页面
                req.getRequestDispatcher("/login_tip.html").forward(req, resp);
            } else {
                req.getRequestDispatcher("/guanli.jsp").forward(req, resp);
            }
        } else {
            UserDao dao = new UserDao();
            Admin user = dao.login(loginUser);
            StringBuilder json = new StringBuilder();
            // {"success" : false } {"success" : true }
            if (user == null) {
                json.append("{\"success\" : false }");
            } else {
                req.getSession().setAttribute("user", user); //创建session对象保存user
                json.append("{\"success\" : true }");
            }
            System.out.println("json="+json);
            resp.getWriter().print(json);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
