package cn.cuit.exam.domain;

public class student_t {
    private String sno;
    private String sname;
    private String className;

    public student_t(String sno, String sname, String className) {
        this.sno = sno;
        this.sname = sname;
        this.className = className;
    }

    public student_t() {}

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "student_t{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
