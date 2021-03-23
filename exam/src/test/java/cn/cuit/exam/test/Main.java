package cn.cuit.exam.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int test() {
        try {
            System.out.println("1");
            return 3;
        } finally {
            System.out.println("2");
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
