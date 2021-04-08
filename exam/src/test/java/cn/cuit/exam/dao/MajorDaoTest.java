package cn.cuit.exam.dao;

import junit.framework.TestCase;

public class MajorDaoTest extends TestCase {

    public void testGetMajor() {
        MajorDao dao = new MajorDao();
        System.out.println(dao.getMajors("软件工程"));
    }
}