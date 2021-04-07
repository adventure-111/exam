package cn.cuit.exam.domain;

public class Teacher extends User{
    private String tname;
    private String school;


    public Teacher(String username, String passward, String tname, String school) {
        super(username, passward);
        this.tname = tname;
        this.school = school;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                " tname='" + tname + '\'' +
                ", school='" + school + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
