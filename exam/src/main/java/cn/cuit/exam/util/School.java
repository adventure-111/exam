package cn.cuit.exam.util;

import java.util.HashMap;

public class School {
    private HashMap<String, String> schoolname;
    private HashMap<String, String> schoolid;

    private void setSchoolname() {
        schoolname.put("1", "大气科学学院");
        schoolname.put("2", "电子工程学院");
        schoolname.put("3", "管理学院");
        schoolname.put("4", "光电工程学院");
        schoolname.put("5", "计算机学院");
        schoolname.put("6", "控制工程学院");
        schoolname.put("7", "软件工程学院");
        schoolname.put("8", "通信工程学院");
        schoolname.put("9", "统计学院");
        schoolname.put("10", "外国语学院");
        schoolname.put("11", "网络空间安全学院");
        schoolname.put("12", "文化艺术学院");
        schoolname.put("13", "物流学院");
        schoolname.put("14", "应用数学学院");
        schoolname.put("15", "资源环境学院");
    }

    private void setSchoolId() {
        schoolid.put("大气","1");
        schoolid.put("电子","2");
        schoolid.put("管理"  ,"3" );
        schoolid.put("光电","4");
        schoolid.put("计算" ,"5" );
        schoolid.put("控制","6");
        schoolid.put("软件","7");
        schoolid.put("通信","8");
        schoolid.put("统计", "9");
        schoolid.put("外国"    ,"10");
        schoolid.put("网络" ,"11");
        schoolid.put("文化"   ,"12");
        schoolid.put("物流"     ,"13");
        schoolid.put("应用"   ,"14");
        schoolid.put("资源"   ,"15");
    }

    /**
     * 获取学院名
     * @param id
     * @return name
     */
    public String getName(String id) {
        this.setSchoolname();
        return schoolname.get(id);
    }

    /**
     * 获取学院id
     * @param name
     * @return
     */
    public String getId(String name) {
        this.setSchoolId();
        return schoolid.get(name.substring(0, 2));
    }

}
