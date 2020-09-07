package com.zzu.unit1.p6.linkedlisttest;

/**
 * 获得两个单链表相交的第一个交点
 * 实现步骤:
 * 1）获得以head1为首节点的单链表长度，我们记为length1
 * 获得以head2为首节点的单链表长度，我们记为length2
 * 2）定义long指针，用于指向长度较长单链表的首节点
 * 定义short指针，用于指向长度较短单链表的首节点
 * 3）让long指针往后移动Math.abs(length1-length2)次
 * 4）定义一个循环，每次让long指针和short指针往后移动一次。当long指
 * 针和short指针指向同一个节点时，那么就停止循环操作。此时，long指针
 * 和short指针指向的节点就是两个单链表相交的第一个交点。
 * @author CMOS
 * @date 2020/9/6 15:41
 */
public class Test10 {
    public static void main(String[] args) {
        //创建一个单链表
        Node lastNode = new Node("77",null);
        Node node1_6 = new Node("66",lastNode);
        Node node1_5 = new Node("55",node1_6);
        Node node1_4 = new Node("44",node1_5);
        Node node1_3 = new Node("33",node1_4);
        Node node1_2 = new Node("22",node1_3);
        Node headNode1 = new Node("11",node1_2);

        //创建一个单链表
        Node node2_2 = new Node("bb",node1_5);
        Node headNode2 = new Node("aa",node2_2);

        System.out.println(mergeNode(headNode1,headNode2).getData());
    }

    /**
     * 获得两个单链表相交的第一个交点
     * @param headNode1 第一个单链表
     * @param headNode2 第二个单链表
     * @return 两个链表的交点
     */
    public static Node mergeNode(Node headNode1,Node headNode2){
        if(headNode1==null || headNode2==null){
            return null;
        }
        int length1 = getLength(headNode1);
        int length2 = getLength(headNode2);
        Node longNode = length1 > length2 ? headNode1 : headNode2;
        Node shortNode = length1 > length2 ? headNode2 : headNode1;
        for(int i=0;i<Math.abs(length1-length2);i++){
            longNode = longNode.getNext();
        }
        while (longNode != shortNode) {
            longNode = longNode.getNext();
            shortNode = shortNode.getNext();
        }
        return longNode;
    }

    /**
     * 获得单链表的长度
     * @param headNode 单链表的首节点
     * @return 单链表的长度
     */
    public static int getLength(Node headNode){
        int length = 0;
        Node tempNode = headNode;
        while (tempNode != null){
            tempNode = tempNode.getNext();
            length++;
        }
        return length;
    }
}
