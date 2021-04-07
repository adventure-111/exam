package cn.cuit.exam.test;

import cn.cuit.exam.dao.UserDao;
import cn.cuit.exam.domain.Admin;
import org.junit.Test;


public class UserDaoTest {

    @Test
    public void testLogin() {
        UserDao dao = new UserDao();
        Admin loginUser = new Admin();
        loginUser.setUsername("2019081188");
        loginUser.setPassword("123456");
        Admin user = dao.login(loginUser);

        System.out.println(user);
    }

    @Test
    public void updatePassword() {
        UserDao dao = new UserDao();
        Admin user = new Admin();

        user.setUsername("2019081188");
        user.setPassword("123");

        user = dao.updatePwd(user, "123456");
        System.out.println(user);
    }
}
