package com.zzu.unit2.p2.specialmatrix;

import java.util.Arrays;

/**
 * 对称矩阵的压缩存储
 * @author CMOS
 * @date 2020/9/10 16:34
 */
public class Test01 {

    public static void main(String[] args) {
        int[][] matrix = {{3,6,4,7,8},
                          {6,2,8,4,2},
                          {4,8,1,6,9},
                          {7,4,6,0,5},
                          {8,2,9,5,7}};
        //测试对称矩阵的压缩操作
        int[] compress = compress(5, matrix);
        //System.out.println(Arrays.toString(compress));
        //测试对称矩阵的解压缩操作
        int[][] decompression = decompression(5, compress);
        for(int[] a : decompression){
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 用于实现对称矩阵的解压缩操作
     * @param order 对称矩阵的阶数
     * @param array 压缩存储之后的一维数组
     * @return 解压缩之后的对称矩阵
     */
    public static int[][] decompression(int order,int[] array){
        int[][] matrix = new int[order][order];
        for(int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                if(i<=j){
                    matrix[i][j] = array[i*(i+1)/2+j];
                }else{
                    matrix[i][j] = array[j*(j+1)/2+i];
                }
            }
        }
        return matrix;
    }

    /**
     * 用于实现对称矩阵的压缩存储操作
     * @param order
     * @param matrix
     * @return
     */
    public static int[] compress(int order,int[][] matrix){
        int[] arr = new int[order*(order+1)/2];
        for(int i=0;i<order;i++){
            for(int j=0;j<=i;j++){
                arr[i*(i+1)/2+j] = matrix[i][j];
            }
        }
        return arr;
    }
}
