package cn.cuit.exam.domain;

public class funcLib {
    static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    static boolean isLetter(char ch) {
        if (ch >= 'a' && ch <= 'z') return true;
        return ch >= 'A' && ch <= 'Z';
    }
}
