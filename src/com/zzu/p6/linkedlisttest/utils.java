package com.zzu.p6.linkedlisttest;

/**
 * @author CMOS
 * @date 2020/9/5 15:02
 */
public class utils {
    /**
     * 实现单链表的遍历操作
     * @param headNode
     */
    public static void print(Node headNode){
        Node tempNode = headNode;
        while(tempNode != null){
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }
}
