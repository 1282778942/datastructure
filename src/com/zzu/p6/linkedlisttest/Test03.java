package com.zzu.p6.linkedlisttest;

/**
 * 在O(1)时间删除单链表节点
 * @author CMOS
 * @date 2020/9/5 15:45
 */
public class Test03 {
    public static void main(String[] args) {
        //创建一个单链表
        Node lastNode = new Node("77",null);
        Node node6 = new Node("66",lastNode);
        Node node5 = new Node("55",node6);
        Node node4 = new Node("44",node5);
        Node node3 = new Node("33",node4);
        Node node2 = new Node("22",node3);
        Node headNode = new Node("11",node2);

        //删除节点为链表首节点
        /*
        Node head = deleteNode(headNode,headNode);
        utils.print(head);
         */

        //删除节点为链表尾节点
        /*
        utils.print(deleteNode(headNode,lastNode));

         */
        //删除节点为链表中间节点
        utils.print(deleteNode(headNode,node4));
    }

    /**
     * 在O(1)时间删除单链表节点
     * @param headNode 单链表的首节点
     * @param deleteNode 要删除的节点
     * @return 删除后的链表首节点
     */
    public static Node deleteNode(Node headNode,Node deleteNode){
        if(headNode==null || deleteNode==null){
            throw new NullPointerException("headNode或delNode为null");
        }
        //删除头
        if(headNode==deleteNode){
            Node nextNode = headNode.getNext();
            headNode.setNext(null);
            return nextNode;
        }
        //删除尾
        else if(deleteNode.getNext()==null){
            Node tempNode = headNode;
            while(tempNode.getNext() != deleteNode){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            return headNode;
        }
        //删除中间
        else{
            Node nextNode = deleteNode.getNext();
            deleteNode.setData(nextNode.getData());
            deleteNode.setNext(nextNode.getNext());
            nextNode.setNext(null);
            return headNode;
        }
    }
}
