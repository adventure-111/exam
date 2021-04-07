package cn.cuit.exam.dao;

import junit.framework.TestCase;

public class MajorDaoTest extends TestCase {

    public void testGetMajor() {
        MajorDao dao = new MajorDao();
        System.out.println(dao.getMajor("软件工程"));
    }
}