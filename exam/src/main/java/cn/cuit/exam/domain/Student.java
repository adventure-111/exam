package cn.cuit.exam.domain;

public class Student extends User{
    private String sname;
    private String className;
    private String major;

    public Student(String username, String password, String sname, String className, String major) {
        super(username, password);
        this.sname = sname;
        this.className = className;
        this.major = major;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sname='" + sname + '\'' +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    // 通过班名获取年级
    public static String getGrade(String cname) {
        String grade = cname.length() == 5 ? cname.substring(2, 4) : cname.substring(3, 5);

        return grade;
    }

    public String getGrade() {
        String grade = className.length() == 5 ? className.substring(2, 4) : className.substring(4, 6);

        return grade;
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
