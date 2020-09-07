package com.zzu.unit1.p5.cyclesinglelinkedlist;

/**
 * @author CMOS
 * @date 2020/8/19 08:05
 */
public class Test01 {
    public static void main(String[] args) {
        // 1.创建一个对象
        CycleSingleLinkedList list = new CycleSingleLinkedList();
        // 2.添加元素
        list.add("11"); // 0
//        list.add("22"); // 1
//        list.add("33"); // 2
        // "00"
        // 3.根据序号获取元素
        // System.out.println(list.get(3));
        // 4.根据序号删除元素
         list.remove(0);
        // 5.根据序号插入元素
//        list.add(3, "00");
        System.out.println();
    }
}
