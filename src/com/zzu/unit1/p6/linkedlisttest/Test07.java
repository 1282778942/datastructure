package com.zzu.unit1.p6.linkedlisttest;

/**
 * 判断单链表是否有环
 * @author CMOS
 * @date 2020/9/6 09:29
 */
public class Test07 {
    public static void main(String[] args) {
        //创建一个单链表
        Node lastNode = new Node("77",null);
        Node node6 = new Node("66",lastNode);
        Node node5 = new Node("55",node6);
        Node node4 = new Node("44",node5);
        Node node3 = new Node("33",node4);
        Node node2 = new Node("22",node3);
        Node headNode = new Node("11",node2);
        lastNode.setNext(headNode);
        System.out.println(isRing(node3));
    }

    /**
     * 判断单链表是否有环
     * @param headNode 单链表首节点
     */
    public static boolean isRing(Node headNode){
        if(headNode == null){
            return false;
        }
        Node fast = headNode;
        Node slow = headNode;

        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast==slow){
                return true;
            }

        }
        return false;
    }
}
