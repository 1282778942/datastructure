package com.zzu.unit1.p4.doublelinkedlist;

/**
 * @author CMOS
 * @date 2020/8/17 14:45
 */
public class Test {
    public static void main(String[] args) {
        // 1.创建对象
        DoubleLinkedList list = new DoubleLinkedList();
        // 2.添加元素
        list.add("11"); // 0
        list.add("22"); // 1
        list.add("33"); // 2
        list.add("44"); // 3
        // "00"
        // 3.根据序号获取元素
        // System.out.println(list.get(0));
        // 4.根据序号删除元素
        // list.remove(0);
        // 5.根据序号插入元素
        list.add(2, "00");
        // 6.遍历双链表中的所有元素
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
