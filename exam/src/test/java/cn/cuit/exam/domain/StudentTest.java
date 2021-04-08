package cn.cuit.exam.domain;

import junit.framework.TestCase;

public class StudentTest extends TestCase {

    public void testGetGrade() {
        Student st = new Student();
        String grade = st.getGrade("大数据195");
        System.out.println(grade);
    }
}