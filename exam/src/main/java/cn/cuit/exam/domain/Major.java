package cn.cuit.exam.domain;

import java.util.HashMap;

public class Major {

    static public HashMap<String, String> major;

    static {
        major.put("0101", "大气科学本科");
        major.put("0102", "大气科学本科(英才)");
        major.put("0103", "应用气象学本科");

        major.put("0201", "电子工程本科(大气)");
        major.put("0202", "电子工程本科(航电)");
        major.put("0203", "电子工程本科(信处)");
        major.put("0204", "电子信息工程本科");
        major.put("0205", "电子信息科学技术(航)");
        major.put("0206", "电子信息工程本科");
        major.put("0207", "生物医学工程本科");

        major.put("0301", "财务管理本科");
        major.put("0302", "财务管理本科(理财)");
        major.put("0303", "财务管理本科(税筹)");
        major.put("0304", "会计学本科");
        major.put("0305", "会计学本科(ACCA)");
        major.put("0306", "会计学本科(注会)");
        major.put("0307", "会展经济与管理本科");
        major.put("0308", "劳动与社会保障本科");
        major.put("0309", "旅游管理本科");
        major.put("0310", "人力资源管理本科");
        major.put("0311", "市场营销本科");
        major.put("0312", "行政管理本科");

        major.put("0401", "材料物理本科");
        major.put("0402", "电子科学(实验)");
        major.put("0403", "电子科学(卓越)");
        major.put("0404", "电子科学与技术本科");
        major.put("0405", "光电信息科学与工程");
        major.put("0406", "应用物理学本科");

        major.put("0501", "计算机科学本科(工程)");
        major.put("0502", "计算机科学本科(应用)");
        major.put("0503", "计算机科学与技术本科");
        major.put("0504", "数字媒体技术本科");

        major.put("0601", "测控技术与仪器本科");
        major.put("0602", "电气工程及自动化本科");
        major.put("0603", "机器人工程本科");
        major.put("0604", "机械电子工程(航)");
        major.put("0605", "机械电子工程本科");
        major.put("0606", "自动化（数控）");
        major.put("0607", "自动化本科");

        major.put("0701", "空间信息技术本科");
        major.put("0702", "软件工程本科");
        major.put("0703", "数据科学与大数据技术");

        major.put("0801", "通信工程本科");
        major.put("0802", "微电子科学与工程本科");

        major.put("0901", "金融工程本科");
        major.put("0902", "经济统计学本科");
        major.put("0903", "经济统计学本科(金保)");
        major.put("0904", "经济统计学本科(政统)");
        major.put("0905", "统计学本科");
        major.put("0906", "统计学本科(数挖智能)");

        major.put("1001", "翻译本科");
        major.put("1002", "英语本科");

        major.put("1101", "网络工程本科");
        major.put("1102", "物联网工程本科");
        major.put("1103", "信息安全本科");
        major.put("1104", "信息安全本科(实验)");
        major.put("1105", "信息对抗本科");

        major.put("1201", "汉语国际教育本科");
        major.put("1202", "汉语言文学本科");
        major.put("1203", "社会工作本科");
        major.put("1204", "视觉传达设计(动漫)");
        major.put("1205", "视觉传达设计(网艺)");
        major.put("1206", "视觉传达设计本科");

        major.put("1301", "电子商务本科");
        major.put("1302", "工程管理本科");
        major.put("1303", "物流工程本科");
        major.put("1304", "物流管理本科");
        major.put("1305", "信管本科");

        major.put("1401", "数学与应用数学本科");
        major.put("1402", "信息与计算科学本科");

        major.put("1501", "测绘工程本科");
        major.put("1502", "地理信息科学本科");
        major.put("1503", "环境工程本科");
        major.put("1504", "环境工程本科(卓越)");
        major.put("1505", "环境科学本科");
        major.put("1506", "遥感科学与技术本科");
    }

    /**
     * 获取学院名
     * @param id
     * @return name
     */
    public String getName(String id) {
        return major.get(id);
    }

}
