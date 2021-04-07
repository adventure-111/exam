package cn.cuit.exam.dao;

import cn.cuit.exam.domain.Student;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest extends TestCase {
    StudentDao studentDao = new StudentDao();
    public void testAddStudent() {
        for (int i=1; i<=40; i++) {
            Student stu = new Student(String.format("stu%07d", i), "123", "stuname", "软工197", "软件工程");
            studentDao.addStudent(stu);
        }

    }

    public void testDelStudent() {
        System.out.println(studentDao.delete("111"));
    }

    public void testDelStudentList() {
        List<String> snoList = new ArrayList<>();
        for (int i=1; i<=40; i++) {
            snoList.add(String.format("stu%07d", i));
        }

        studentDao.delete(snoList);
    }

    public void testQueryBySno() {
        System.out.println(studentDao.queryBySno("7", "st1"));
    }

    public void testQuery() {
    }


    public void testUpdateStu() {
        Map<String, String[]> map = new HashMap<>();
        map.put("username", new String[]{"st15"});
        map.put("sname", new String[]{"test1"});
        map.put("password", new String[]{"test1"});
        map.put("classname", new String[]{"xx193"});
        map.put("major", new String[]{"test"});
        map.put("school", new String[]{"7"});
        studentDao.update(map);
    }

}