package cn.cuit.exam.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String n = "";
        while (true) {
            try {
                n = sc.nextLine();
                int m = Integer.parseInt(n);
                list.add(m);
            } catch (NumberFormatException e) {
                if (!n.equals("end")) {
                    System.out.println("输入了非数字，数字格式转换异常");
                }
                break;
            }
        }
        if (list.size() == 0) {
            System.out.println("无数据输入");
        } else {
            int pos = 0;
            for (int i = 1; i < list.size(); ++i) {
                if (list.get(i) > list.get(pos)) pos = i;
            }
            System.out.println("最大值为" + list.get(pos) + "，索引号为" + pos);
        }
    }
}
