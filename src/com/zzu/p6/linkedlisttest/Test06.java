package com.zzu.p6.linkedlisttest;

import java.util.Stack;

/**
 * 从尾到头打印单链表
 * 方案一：将单链表反转后打印输出，见Test01
 * 方案二：使用栈，利用后进先出的特点反向输出
 * 方案三：使用递归调用，实现反向输出
 * @author CMOS
 * @date 2020/9/6 08:57
 */
public class Test06 {
    public static void main(String[] args) {
        //创建一个单链表
        Node lastNode = new Node("77",null);
        Node node6 = new Node("66",lastNode);
        Node node5 = new Node("55",node6);
        Node node4 = new Node("44",node5);
        Node node3 = new Node("33",node4);
        Node node2 = new Node("22",node3);
        Node headNode = new Node("11",node2);
        reversePrint(headNode);
    }

    /**
     * 从尾到头打印单链表
     * @param headNode
     */
    public static void reversePrint(Node headNode){
        if(headNode==null){
            throw new NullPointerException("headNode为null");
        }
        Stack<Node> stack = new Stack<>();
        while (headNode != null){
            stack.push(headNode);
            headNode = headNode.getNext();
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().getData());
        }
    }

    /**
     * 使用递归实现单链表的反向输出
     * @param headNode 链表首节点
     */
    public static void printRecursion(Node headNode){
        if(headNode == null){
            return;
        }
        printRecursion(headNode.getNext());
        System.out.println(headNode.getData());
    }
}
