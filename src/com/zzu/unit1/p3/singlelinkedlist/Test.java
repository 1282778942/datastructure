package com.zzu.unit1.p3.singlelinkedlist;

/**
 * @author CMOS
 * @date 2020/8/17 09:30
 */
public class Test {
    public static void main(String[] args) {
        // 1.创建一个对象
        SingleLinkedList list = new SingleLinkedList();
        // 2.添加元素
        list.add("11"); // 0
        list.add("22"); // 1
        list.add("33"); // 2
        list.add("44"); // 3
        list.add("55"); // 4
        // "00"
        // 3.根据序号获取元素
        // System.out.println(list.get(3));
        // 4.根据序号删除元素
//         list.remove(0);
        // 5.根据序号插入元素
        list.add(0, "00");
        // 6.遍历单链表中的所有元素
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
