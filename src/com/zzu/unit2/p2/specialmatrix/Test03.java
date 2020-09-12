package com.zzu.unit2.p2.specialmatrix;

import java.util.Arrays;

/**
 * 对角矩阵的压缩存储
 * @author CMOS
 * @date 2020/9/12 15:47
 */
public class Test03 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 6, 0, 0, 0},
                          {9, 2, 5, 0, 0},
                          {0, 7, 1, 6, 0},
                          {0, 0, 4, 0, 2},
                          {0, 0, 0, 8, 7}};
        int[] arr = compress(5,matrix);
        System.out.println(Arrays.toString(arr));
        int[][] matrix2 = decompression(5,arr);
        for(int[] a : matrix2){
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 用于实现对角矩阵的解压缩操作
     * @param order 对角矩阵的阶数
     * @param matrix 压缩存储之后的一维数组
     * @return 解压缩之后的对角矩阵
     */
    public static int[][] decompression(int order,int matrix[]){
        int[][] arr = new int[order][order];
        for(int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                if(Math.abs(i-j)<=1){
                    arr[i][j] = matrix[2*i+j];
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    /**
     * 用于实现对角矩阵的压缩存储操作
     * @param order 对角矩阵的阶数
     * @param matrix 需要压缩存储的对角矩阵
     * @return 返回压缩存储之后的一维数组
     */
    public static int[] compress(int order,int[][] matrix){
        //假设在一个n阶对角矩阵中，每一行带状区域的元素最多为3个
        int[] arr = new int[(3-1)*order+(order-2)*3];
        for(int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                if(Math.abs(i-j)<=1){
                    arr[2*i+j] = matrix[i][j];
                }
            }
        }
        return arr;
    }
}
