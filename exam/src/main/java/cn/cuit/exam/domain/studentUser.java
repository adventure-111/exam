package cn.cuit.exam.domain;

public class studentUser {
    private String sno;
    private String sname;
    private String classname;

    private String username;
    private String password;
    private String role;

    public studentUser(String sno, String sname, String classname, String username, String password, String role) {
        this.sno = sno;
        this.sname = sname;
        this.classname = classname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public studentUser() {}

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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
