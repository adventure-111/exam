package cn.cuit.exam.web;

import cn.cuit.exam.dao.UserDao;
import cn.cuit.exam.domain.admin_t;

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

        admin_t loginUser = new admin_t();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        if (username == null || password == null) {
            HttpSession session = req.getSession(false);
            if (session.getAttribute("user") == null) {
                req.getRequestDispatcher("login_tip.html").forward(req, resp);
            } else {
                req.getRequestDispatcher("/guanli.jsp").forward(req, resp);
            }
        } else {
            UserDao dao = new UserDao();
            admin_t user = dao.login(loginUser);
            StringBuilder json = new StringBuilder();
            if (user == null) {
                json.append("{\"success\" : true}");
            } else {
                req.getSession().setAttribute("user", user);
                json.append("{\"success\" : true}");
            }
            System.out.println("json = " + json);
            resp.getWriter().print(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
