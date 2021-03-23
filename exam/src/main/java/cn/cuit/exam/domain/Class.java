package cn.cuit.exam.domain;

public class Class {

    private String className;
    private String major;
    private String school;
    private int grade;
    private int classNum;

    public Class(String className, String major, String school, int grade, int classNum) {
        this.className = className;
        this.major = major;
        this.school = school;
        this.grade = grade;
        this.classNum = classNum;
    }

    public Class() {}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }
}
