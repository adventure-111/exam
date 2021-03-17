package cn.cuit.exam.domain;

import java.util.HashMap;

public class School {
    static private HashMap<String, String> school = new HashMap<>();

    static {
        school.put("1", "大气科学院");
        school.put("2", "电子工程学院");
        school.put("3", "管理学院");
        school.put("4", "光电工程学院");
        school.put("5", "计算机学院");
        school.put("6", "控制工程学院");
        school.put("7", "软件工程学院");
        school.put("8", "通信工程学院");
        school.put("9", "统计学院");
        school.put("10", "外国语学院");
        school.put("11", "网络空间安全学院");
        school.put("12", "文化艺术学院");
        school.put("13", "物流学院");
        school.put("14", "应用数学学院");
        school.put("15", "资源环境学院");
    }

    public static String getName(String id) {
        return school.get(id);
    }
}
