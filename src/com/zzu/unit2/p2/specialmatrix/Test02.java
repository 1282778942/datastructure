package com.zzu.unit2.p2.specialmatrix;

import java.util.Arrays;

/**
 * 下三角矩阵的压缩存储
 * @author CMOS
 * @date 2020/9/11 08:59
 */
public class Test02 {
    public static void main(String[] args) {
        int[][] matrix = {{3,8,8,8,8},
                          {6,2,8,8,8},
                          {4,8,1,8,8},
                          {7,4,6,0,8},
                          {8,2,9,5,7}};
        int[] arr = compress(5,matrix);
        System.out.println(Arrays.toString(arr));
        int[][] matrix2 = decompression(5,arr);
        for(int[] a : matrix2){
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 用于实现下三角矩阵的解压缩操作
     * @param order 下三角矩阵的阶数
     * @param matrix 压缩存储之后的一维数组
     * @return 解压缩之后的下三角矩阵
     */
    public static int[][] decompression(int order,int matrix[]){
        int[][] arr = new int[order][order];
        for(int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                if(i >=j){
                    arr[i][j] = matrix[i*(i+1)/2+j];
                }else{
                    arr[i][j] = matrix[order*(order+1)/2];
                }
            }
        }
        return arr;
    }

    /**
     * 用于实现下三角矩阵的压缩存储操作
     * @param order 下三角矩阵的阶数
     * @param matrix 需要压缩存储的下三角矩阵
     * @return 返回压缩存储之后的一维数组
     */
    public static int[] compress(int order,int[][] matrix){
        int[] arr = new int[order*(order+1)/2+1];
        for(int i=0;i<order;i++){
            for(int j=0;j<=i;j++){
                arr[i*(i+1)/2 + j] = matrix[i][j];
            }
        }
        arr[order*(order+1)/2] = matrix[0][1];
        return arr;
    }

}
