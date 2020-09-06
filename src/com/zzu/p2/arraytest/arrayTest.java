package com.zzu.p2.arraytest;

import java.util.Arrays;

/**
 * 数组的反转（实现方案一）
 * 例如：数组{11, 22, 33, 44, 55, 66}反转后为{66, 55, 44, 33, 22, 11}
 * @author CMOS
 * @date 2020/8/17 07:50
 */
public class arrayTest {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66};
        int[] newArr = reverseOrderArray(arr);
        System.out.println(Arrays.toString(newArr));
    }

    /**
     * 实现数组的反转
     * @param arr 需要反转的数组
     * @return 反转之后的数组
     */
    public static int[] reverseOrderArray(int[] arr) {
        // 1.定义一个新数组，用于保存反转之后的结果
        int[] newArr = new int[arr.length];
        // 2.把arr数组中的所有元素倒序的存入newArr数组中
        // 2.1通过循环获得arr数组中的每一个元素
        for(int i = 0; i < arr.length; i++) {
            // 2.2把arr数组中的元素倒序存入newArr数组中
            newArr[arr.length - 1 - i] = arr[i];
        }
        // 3.把反转之后的数组返回
        return newArr;
    }
}
