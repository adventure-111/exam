package cn.cuit.exam.web;

import cn.cuit.exam.dao.UserDao;
import cn.cuit.exam.domain.admin_t;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePwd")
public class UpdatePwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String oldPwd = req.getParameter("oldPwd");
        String newPwd = req.getParameter("newPwd");

        UserDao dao = new UserDao();
        admin_t user = dao.updatePwd(new admin_t(username, oldPwd), newPwd);
        if (user == null) {
            req.setAttribute("error", "error");
            req.getRequestDispatcher("updatePwd.jsp").forward(req, resp);
        } else {
            req.setAttribute("user", user);
            req.getRequestDispatcher("guanli.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
