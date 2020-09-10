package com.zzu.unit2.p1.string;

import java.util.Arrays;

/**
 * @author CMOS
 * @date 2020/9/9 19:03
 */
public class Test03 {
    public static void main(String[] args) {
        // 主串
        String destStr = "BABABACABABCABAABD";
        // 模式串
        String subStr = "ABABCABAAB";
        // 测试next数组
        int[] next = getNext(subStr);
        System.out.println(Arrays.toString(next));
        // 测试KMP算法
        int index = kmpSearch(destStr, subStr);
        System.out.println(index);
    }

    /**
     * 实现KMP算法(在BF基础上进行修改)
     * @param destStr 主串
     * @param subStr 模式串
     * @return 返回模式串的第一个字符在主串中的索引位置。如果主串中不存在该模式串，则返回-1
     */
    public static int kmpSearch(String destStr, String subStr) {
        // 0.计算next数组
        int[] next = getNext(subStr);
        // 1.定义一个指针，用于指向主串中的第一个字符
        int x = 0;
        // 2.定义一个指针，用于指向模式串中的第一个字符
        int y = 0;
        // 3.定义一个循环，用于实现字符串的匹配操作
        while (x < destStr.length() && y < subStr.length()) {
            // 4.如果相等或y=-1时，则继续逐个比较后续字符
            if (y == -1 || destStr.charAt(x) == subStr.charAt(y)) {
                x++;
                y++;
            }
            // 5.如果不相等，x指针不移动，将y移动到next[y]中
            else {
                // x = x - y + 1;
                y = next[y];
            }
        }
        // 6.如果模式串遍历完毕，则证明匹配成功，否则就证明匹配失败
        if (y == subStr.length()) {
            return x - y;
        }
        else {
            return -1;
        }
    }

    /**
     * 计算next数组
     * @param subStr 模式串
     * @return 返回next数组
     */
    public static int[] getNext(String subStr) {
        // 1.定义一个next数组
        int[] next = new int[subStr.length()];
        // 2.设置next数组的第一个元素值为-1
        next[0] = -1;
        // 3.定义两个变量，y表示模式串中的索引值，len表示索引为y时对应的最长共有元素长度(即next数组的值)
        int y = 0, len = -1;
        // 4.定义一个循环，用于计算next数组，当索引取到倒数第二个的时候即可计算出索引为subStr.length的值，故索引值只取到subStr.length()-1即可
        while (y < subStr.length() - 1) {
            // 5.处理len和y指向模式串中的字符相等的情况
            if (len == -1 || subStr.charAt(len) == subStr.charAt(y)) {
                 y++;
                 len++;
                 next[y] = len;
            }
            // 6.处理len和y指向模式串中的字符不相等的情况
            else {
                len = next[len];
            }
        }
        // 7.返回计算出来的next数组
        return next;
    }
}
