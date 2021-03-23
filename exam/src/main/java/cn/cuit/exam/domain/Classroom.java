package cn.cuit.exam.domain;

public class Classroom {
    private String classroom;
    private int crNum;

    public Classroom(String classroom, int crNum) {
        this.classroom = classroom;
        this.crNum = crNum;
    }

    public Classroom() {}

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
