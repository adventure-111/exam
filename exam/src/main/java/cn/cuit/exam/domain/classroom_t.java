package cn.cuit.exam.domain;

public class classroom_t {
    private String classroom;
    private int crNum;

    public classroom_t(String classroom, int crNum) {
        this.classroom = classroom;
        this.crNum = crNum;
    }

    public classroom_t() {}

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getCrNum() {
        return crNum;
    }

    public void setCrNum(int crNum) {
        this.crNum = crNum;
    }
}
