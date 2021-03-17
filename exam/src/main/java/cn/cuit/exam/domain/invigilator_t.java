package cn.cuit.exam.domain;

public class invigilator_t {
    private String sno;
    private String present;

    public invigilator_t(String sno, String present) {
        this.sno = sno;
        this.present = present;
    }

    public invigilator_t() {}

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
