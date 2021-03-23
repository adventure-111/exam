package cn.cuit.exam.domain;

public class Invigilator {
    private String sno;
    private String present;

    public Invigilator(String sno, String present) {
        this.sno = sno;
        this.present = present;
    }

    public Invigilator() {}

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }
}
