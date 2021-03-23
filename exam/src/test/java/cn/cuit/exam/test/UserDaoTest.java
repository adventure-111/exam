package cn.cuit.exam.test;

import cn.cuit.exam.dao.UserDao;
import cn.cuit.exam.domain.School;
import cn.cuit.exam.domain.Admin;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin() {
        UserDao dao = new UserDao();
        Admin loginUser = new Admin();
        loginUser.setUsername("jsj");
        loginUser.setPassword("123");
        Admin user = dao.login(loginUser);

        System.out.println(user.getSchool());
    }

    @Test
    public void updatePassword() {
        UserDao dao = new UserDao();
        Admin user = new Admin();

        user.setUsername("jsj");
        user.setPassword("123");

        user = dao.updatePwd(user, "123456");
        System.out.println(user);
    }

    @Test
    public void test1() {
//        System.out.println(School.getName("1"));
    }
}
