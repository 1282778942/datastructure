package com.zzu.unit1.p6.linkedlisttest;

/**
 * 查找单链表的中间节点:
 * 要求不允许获得链表的长度，从而获得单链表的中间节点，
 * 如果单链表的长度为偶数，返回中间节点的任意一个；若为奇数，则返回中间节点
 * 核心思想：定义快慢指针，快指针走两步，慢指针走一步，当快指针走到尾节点时，慢指针则指向中间节点
 * @author CMOS
 * @date 2020/9/5 14:54
 */
public class Test02 {
    public static void main(String[] args) {
        Node lastNode = new Node("77",null);
        Node node6 = new Node("66",lastNode);
        Node node5 = new Node("55",node6);
        Node node4 = new Node("44",node5);
        Node node3 = new Node("33",node4);
        Node node2 = new Node("22",node3);
        Node headNode = new Node("11",node2);
        System.out.println(middleNode(headNode).getData());
    }

    /**
     * 返回中间节点的方法
     * @param headNode 单链表的首节点
     * @return 单链表的中间节点
     */
    public static Node middleNode(Node headNode){
        //处理headNode为null或只有一个节点的情况
        if(headNode==null || headNode.getNext()==null){
            return headNode;
        }
        Node fast = headNode;
        Node slow = headNode;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}
