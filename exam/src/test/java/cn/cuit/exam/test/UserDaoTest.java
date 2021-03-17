package cn.cuit.exam.test;

import cn.cuit.exam.dao.UserDao;
import cn.cuit.exam.domain.School;
import cn.cuit.exam.domain.admin_t;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin() {
        UserDao dao = new UserDao();
        admin_t loginUser = new admin_t();
        loginUser.setUsername("jsj");
        loginUser.setPassword("123");
        admin_t user = dao.login(loginUser);

        System.out.println(user.getSchool());
    }

    @Test
    public void updatePassword() {
        UserDao dao = new UserDao();
        admin_t user = new admin_t();

        user.setUsername("jsj");
        user.setPassword("123");

        user = dao.updatePwd(user, "123456");
        System.out.println(user);
    }

    @Test
    public void test1() {
        System.out.println(School.getName("1"));
    }
}
