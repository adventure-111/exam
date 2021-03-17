package cn.cuit.exam.test;

import cn.cuit.exam.dao.StudentDao;
import cn.cuit.exam.domain.student_t;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {

    @Test
    public void test1() {
        StudentDao dao = new StudentDao();
        student_t stu = dao.queryBySno("2019081188");
        System.out.println(stu.getClassName());
    }

    @Test
    public void test2() {
        StudentDao dao = new StudentDao();
        List<student_t> list = dao.queryForStudent(null, 0, null, null, null);
        System.out.println(list);
    }

}
