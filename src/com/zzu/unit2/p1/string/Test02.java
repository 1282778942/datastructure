package com.zzu.unit2.p1.string;

/**
 * 字符串模式匹配之BF算法
 * @author CMOS
 * @date 2020/9/8 08:05
 */
public class Test02 {
    public static void main(String[] args) {
        String destString = "mengkang";
        String subString = "gka";
    }

    /**
     * 实现BF算法
     * @param destString 主串
     * @param subString 模式串
     * @return 返回模式串的第一个字符在主串中的第一个索引位置。若主串中不存在模式串，返回-1；
     */
    public static int bfSearch(String destString,String subString){
        int x = 0;
        int y = 0;
        while (x<destString.length() && y<subString.length()){
            if (destString.charAt(x) == subString.charAt(y)){
                x++;
                y++;
            }else{
                x = x-y+1;
                y = 0;
            }
        }
        if (y==subString.length()){
            return x-y;
        }
        else {
            return -1;
        }
    }
}
