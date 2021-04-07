package cn.cuit.exam.domain;

public class Student {
    private String sno;
    private String sname;
    private String className;
    private String password;
    private String grade;
    private String major;
    private String school;

    public class Stu {
        String sno;
        String sname;
        String className;

        public Stu(String sno, String sname, String className) {
            this.sno = sno;
            this.sname = sname;
            this.className = className;
        }

        @Override
        public String toString() {
            return "Stu{" +
                    "sno='" + sno + '\'' +
                    ", sname='" + sname + '\'' +
                    ", className='" + className + '\'' +
                    '}';
        }
    }

    public Student(String sno, String sname, String className, String password, String grade, String major, String school) {
        this.sno = sno;
        this.sname = sname;
        this.className = className;
        this.password = password;
        this.grade = grade;
        this.major = major;
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student() {
    }

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
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", className='" + className + '\'' +
                ", password='" + password + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                "}\n";
    }
}
