package cn.cuit.exam.dao;

import cn.cuit.exam.domain.Teacher;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoTest extends TestCase {

    TeacherDao dao = new TeacherDao();

    public void testAdd() {
        dao.add(new Teacher("test4", "123", "test1", "7"));
        dao.add(new Teacher("test5", "123", "test1", "7"));
        dao.add(new Teacher("test6", "123", "test1", "7"));
    }

    public void testDelete() {
        dao.delete("test1");
    }

    public void testDeleteList() {
        List<String> list = new ArrayList<>();
        list.add("test4");
        list.add("test5");
        list.add("test6");
        dao.deleteList(list);
    }

    public void testUpdate() {
        dao.update("test4", "update", "123");
        dao.update("test5", "test1", "1234");
    }

    public void testQueryAll() {
        System.out.println(dao.queryAll("7"));
    }

    public void testQueryBySno() {
//        System.out.println(dao.queryBySno("test4", "7"));
        System.out.println(dao.queryBySno("not_In", "7"));
    }

    public void testQuery() {
        System.out.println(dao.query("7", "test1", null));
        System.out.println(dao.query("8", "test1", null));
        System.out.println(dao.query("7", null, null));
        System.out.println(dao.query("7", null, "test4"));
    }
}