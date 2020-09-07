package com.zzu.unit1.p2.arraytest;

import java.util.Arrays;

/**
 * 数组的反转（实现方案二）
 * 例如：数组{11, 22, 33, 44, 55, 66}反转后为{66, 55, 44, 33, 22, 11}
 * @author CMOS
 * @date 2020/8/17 07:56
 */
public class arrayTest2 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66};
        reverseOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 实现数组的反转
     * @param arr 需要反转的数组
     */
    public static void reverseOrderArray(int[] arr) {
        // 1.通过循环，获得数组前半部分的元素
        for(int i = 0; i < arr.length / 2; i++) {
            // 2.把arr[i]和arr[arr.length - 1 - i]做交换
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
