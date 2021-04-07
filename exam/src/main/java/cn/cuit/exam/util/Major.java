package cn.cuit.exam.util;

import java.util.HashMap;

public class Major {
    private HashMap<String, String> majorname;
    private HashMap<String, String> majorid;

    private void setMajorName() {
        majorname.put("0101", "大气科学本科");
        majorname.put("0102", "大气科学本科(英才)");
        majorname.put("0103", "应用气象学本科");

        majorname.put("0201", "电子工程本科(大气)");
        majorname.put("0202", "电子工程本科(航电)");
        majorname.put("0203", "电子工程本科(信处)");
        majorname.put("0204", "电子信息工程本科");
        majorname.put("0205", "电子信息科学技术(航)");
        majorname.put("0206", "电子信息科学技术本科");
        majorname.put("0207", "生物医学工程本科");

        majorname.put("0301", "财务管理本科");
        majorname.put("0302", "财务管理本科(理财)");
        majorname.put("0303", "财务管理本科(税筹)");
        majorname.put("0304", "会计学本科");
        majorname.put("0305", "会计学本科(ACCA)");
        majorname.put("0306", "会计学本科(注会)");
        majorname.put("0307", "会展经济与管理本科");
        majorname.put("0308", "劳动与社会保障本科");
        majorname.put("0309", "旅游管理本科");
        majorname.put("0310", "人力资源管理本科");
        majorname.put("0311", "市场营销本科");
        majorname.put("0312", "行政管理本科");

        majorname.put("0401", "材料物理本科");
        majorname.put("0402", "电子科学(实验)");
        majorname.put("0403", "电子科学(卓越)");
        majorname.put("0404", "电子科学与技术本科");
        majorname.put("0405", "光电信息科学与工程");
        majorname.put("0406", "应用物理学本科");

        majorname.put("0501", "计算机科学本科(工程)");
        majorname.put("0502", "计算机科学本科(应用)");
        majorname.put("0503", "计算机科学与技术本科");
        majorname.put("0504", "数字媒体技术本科");

        majorname.put("0601", "测控技术与仪器本科");
        majorname.put("0602", "电气工程及自动化本科");
        majorname.put("0603", "机器人工程本科");
        majorname.put("0604", "机械电子工程(航)");
        majorname.put("0605", "机械电子工程本科");
        majorname.put("0606", "自动化（数控）");
        majorname.put("0607", "自动化本科");

        majorname.put("0701", "空间信息技术本科");
        majorname.put("0702", "软件工程本科");
        majorname.put("0703", "数据科学与大数据技术");

        majorname.put("0801", "通信工程本科");
        majorname.put("0802", "微电子科学与工程本科");

        majorname.put("0901", "金融工程本科");
        majorname.put("0902", "经济统计学本科");
        majorname.put("0903", "经济统计学本科(金保)");
        majorname.put("0904", "经济统计学本科(政统)");
        majorname.put("0905", "统计学本科");
        majorname.put("0906", "统计学本科(数挖智能)");

        majorname.put("1001", "翻译本科");
        majorname.put("1002", "英语本科");

        majorname.put("1101", "网络工程本科");
        majorname.put("1102", "物联网工程本科");
        majorname.put("1103", "信息安全本科");
        majorname.put("1104", "信息安全本科(实验)");
        majorname.put("1105", "信息对抗本科");

        majorname.put("1201", "汉语国际教育本科");
        majorname.put("1202", "汉语言文学本科");
        majorname.put("1203", "社会工作本科");
        majorname.put("1204", "视觉传达设计(动漫)");
        majorname.put("1205", "视觉传达设计(网艺)");
        majorname.put("1206", "视觉传达设计本科");

        majorname.put("1301", "电子商务本科");
        majorname.put("1302", "工程管理本科");
        majorname.put("1303", "物流工程本科");
        majorname.put("1304", "物流管理本科");
        majorname.put("1305", "信管本科");

        majorname.put("1401", "数学与应用数学本科");
        majorname.put("1402", "信息与计算科学本科");

        majorname.put("1501", "测绘工程本科");
        majorname.put("1502", "地理信息科学本科");
        majorname.put("1503", "环境工程本科");
        majorname.put("1504", "环境工程本科(卓越)");
        majorname.put("1505", "环境科学本科");
        majorname.put("1506", "遥感科学与技术本科");
    }

    private void setMajorid() {
        majorid.put("大气科学本科"   ,"0101" );
        majorid.put("大气科学本科(英才)","0102");
        majorid.put("应用气象学本科"  ,"0103" );

        majorid.put("电子工程本科(大气)","0201" );
        majorid.put("电子工程本科(航电)","0202" );
        majorid.put("电子工程本科(信处)","0203" );
        majorid.put("电子信息工程本科" ,"0204" );
        majorid.put("电子信息科学技术(航电)","0205" );
        majorid.put("电子信息科学技术本科" ,"0206" );
        majorid.put("生物医学工程本科" ,"0207" );

        majorid.put("财务管理本科"   ,"0301"     );
        majorid.put("财务管理本科(理财)","0302" );
        majorid.put("财务管理本科(税筹)","0303" );
        majorid.put("会计学本科"    ,"0304" );
        majorid.put("会计学本科(ACCA)","0305" );
        majorid.put("会计学本科(注会)","0306" );
        majorid.put("会展经济与管理本科","0307");
        majorid.put("劳动与社会保障本科","0308");
        majorid.put("旅游管理本科"   ,"0309" );
        majorid.put("人力资源管理本科" ,"0310" );
        majorid.put("市场营销本科"   ,"0311" );
        majorid.put("行政管理本科"   ,"0312" );

        majorid.put("材料物理本科"   ,"0401" );
        majorid.put("电子科学(实验)" ,"0402" );
        majorid.put("电子科学(卓越)" ,"0403" );
        majorid.put("电子科学与技术本科","0404" );
        majorid.put("光电信息科学与工程","0405" );
        majorid.put("应用物理学本科"  ,"0406" );

        majorid.put("计算机科学本科(工程)","0501" );
        majorid.put("计算机科学本科(应用)","0502" );
        majorid.put("计算机科学与技术本科)","0503" );
        majorid.put("数字媒体技术本科" ,"0504" );

        majorid.put("测控技术与仪器本科","0601" );
        majorid.put("电气工程及自动化本科","0602" );
        majorid.put("机器人工程本科"  ,"0603" );
        majorid.put("机械电子工程(航)","0604" );
        majorid.put("机械电子工程本科" ,"0605" );
        majorid.put("自动化（数控）"  ,"0606" );
        majorid.put("自动化本科"    ,"0607" );

        majorid.put("空间信息技术本科" ,"0701" );
        majorid.put("软件工程本科"   ,"0702" );
        majorid.put("数据科学与大数据技术","0703" );

        majorid.put("通信工程本科"   ,"0801" );
        majorid.put("微电子科学与工程本科","0802" );

        majorid.put("金融工程本科"   ,"0901" );
        majorid.put("经济统计学本科"  ,"0902" );
        majorid.put("经济统计学本科(金保)","0903" );
        majorid.put("经济统计学本科(政统)","0904" );
        majorid.put("统计学本科"    ,"0905"     );
        majorid.put("统计学本科(数挖智能)","0906" );

        majorid.put("翻译本科"     ,"1001" );
        majorid.put("英语本科"     ,"1002" );

        majorid.put("网络工程本科"   ,"1101" );
        majorid.put("物联网工程本科"  ,"1102" );
        majorid.put("信息安全本科"   ,"1103");
        majorid.put("信息安全本科(实验)","1104");
        majorid.put("信息对抗本科"   ,"1105" );

        majorid.put("汉语国际教育本科" ,"1201" );
        majorid.put("汉语言文学本科"  ,"1202" );
        majorid.put("社会工作本科"   ,"1203" );
        majorid.put("视觉传达设计(动漫)","1204" );
        majorid.put("视觉传达设计(网艺)","1205" );
        majorid.put("视觉传达设计本科" ,"1206" );

        majorid.put("电子商务本科"   ,"1301" );
        majorid.put("工程管理本科"   ,"1302" );
        majorid.put("物流工程本科"   ,"1303" );
        majorid.put("物流管理本科"   ,"1304" );
        majorid.put("信管本科"     ,"1305" );

        majorid.put("数学与应用数学本科","1401");
        majorid.put("信息与计算科学本科","1402");

        majorid.put("测绘工程本科"   ,"1501" );
        majorid.put("地理信息科学本科" ,"1502" );
        majorid.put("环境工程本科"   ,"1503" );
        majorid.put("环境工程本科(卓越)","1504" );
        majorid.put("环境科学本科"   ,"1505" );
        majorid.put("遥感科学与技术本科","1506");
    }

    /**
     * 获取专业名
     * @param id
     * @return name
     */
    public String getName(String id) {
        this.setMajorName();
        return majorname.get(id);
    }

    /**
     * 获取专业id
     * @param name
     * @return
     */
    public String getId(String name) {
        this.setMajorid();
        return majorid.get(name);
    }
}
