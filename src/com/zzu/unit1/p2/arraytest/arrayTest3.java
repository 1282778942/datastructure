package com.zzu.unit1.p2.arraytest;

import java.util.Arrays;

/**
 * 使奇数位于偶数前面
 * 输入一个整型数组，实现一个方法来调整该数组中的元素的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * @author CMOS
 * @date 2020/8/17 08:06
 */
public class arrayTest3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        replaceOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 使奇数位于偶数前面
     * @param arr 需要调整奇偶数位置的数组
     */
    public static void replaceOrderArray(int[] arr) {
        // 1.处理arr为null的情况
        if(arr == null)
            throw new NullPointerException("空指针异常，arr:" + arr);
        // 2.定义两个下标，min的初始值为0，max的初始值为arr.length - 1
        int min = 0, max = arr.length - 1;
        // 3.定义一个循环，用于调整数组中奇偶数的位置
        while(min < max) { // 如果min小于max，则一直调整数组中元素的位置
            // 4.让min从前往后找，如果arr[min]的值为偶数，则停止查找
            while (min < max && arr[min] % 2 != 0) {
                min++;
            }
            // 5.让max从后往前找，如果arr[max]的值为奇数，则停止查找
            while(min < max && arr[max] % 2 == 0) {
                max--;
            }
            // 6.如果min的值不等于max，则交换arr[min]和arr[max]的值
            if(min != max) {
                int temp = arr[min];
                arr[min] = arr[max];
                arr[max] = temp;
            }
        }
    }
}
