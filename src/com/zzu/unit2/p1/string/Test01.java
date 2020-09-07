package com.zzu.unit2.p1.string;

/**
 * 计算字符串长度
 * @author CMOS
 * @date 2020/9/7 08:06
 */
public class Test01 {
    public static void main(String[] args) {
        char[] arr = {'a','b','c','d','\0'};
        int i = 0;
        while(arr[i] != '\0'){
            i++;
        }
        System.out.println("字符串长度为："+i);
    }
}
