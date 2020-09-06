package com.zzu.p6.linkedlisttest;

/**
 * 环形链表中获取环的长度
 * @author CMOS
 * @date 2020/9/6 10:56
 */
public class Test08 {
    public static void main(String[] args) throws Exception {
        //创建一个单链表
        Node lastNode = new Node("77",null);
        Node node6 = new Node("66",lastNode);
        Node node5 = new Node("55",node6);
        Node node4 = new Node("44",node5);
        Node node3 = new Node("33",node4);
        Node node2 = new Node("22",node3);
        Node headNode = new Node("11",node2);
        lastNode.setNext(node4);
        Node meetNode = getMeetNode(headNode);
        System.out.println(ringNum(meetNode));
    }

    /**
     * 获得快慢指针相交的节点
    * @param headNode 单链表的首节点
     * @return 快慢指针相交的节点
     */
    public static Node getMeetNode(Node headNode){
        if(headNode == null){
            return null;
        }
        Node fast = headNode;
        Node slow = headNode;
        Node meetNode = null;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast==slow){
                meetNode = fast;
                return meetNode;
            }
        }
        return null;
    }

    /**
     * 从快慢指针相交的节点开始遍历，查找环中节点个数
     * @param meetNode
     * @return
     */
    public static int ringNum(Node meetNode){
        int size = 1 ;
        Node temp = meetNode.getNext();
        while(temp != meetNode){
            temp = temp.getNext();
            size++;

        }
        return size;
    }

}
