package cn.cuit.exam.domain;

public class Course {
    private String code;
    private String cname;
    private String school;
    private int courseNum;

    public Course(String code, String cname, String school, int courseNum) {
        this.code = code;
        this.cname = cname;
        this.school = school;
        this.courseNum = courseNum;
    }

    public Course() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }
}
