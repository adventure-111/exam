package cn.cuit.exam.domain;

public class teacher_t {
    private String sno;
    private String tname;
    private String school;
    private int past;
    private char task;

    public teacher_t(String sno, String tname, String school, int past, char task) {
        this.sno = sno;
        this.tname = tname;
        this.school = school;
        this.past = past;
        this.task = task;
    }

    public teacher_t() {}

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public int getPast() {
        return past;
    }

    public void setPast(int past) {
        this.past = past;
    }

    public char getTask() {
        return task;
    }

    public void setTask(char task) {
        this.task = task;
    }
}
