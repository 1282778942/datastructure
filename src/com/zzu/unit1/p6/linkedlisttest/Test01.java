package com.zzu.unit1.p6.linkedlisttest;

/**
 * 单链表的反转
 * @author CMOS
 * @date 2020/8/19 10:32
 */
public class Test01 {

    public static void main(String[] args) {
        //创建一个单链表
        Node lastNode = new Node(44,null);
        Node node3 = new Node(33,lastNode);
        Node node2 = new Node(22,node3);
        Node headNode = new Node(11,node2);
        System.out.println("反转前的链表：");
        utils.print(headNode);
        System.out.println("********");
        Node reverse = reverseLinkedList(headNode);
        System.out.println("反转后的链表：");
        utils.print(reverse);
    }

    public static Node reverseLinkedList(Node headNode){
        //1.空链表或只有首节点，直接返回原首节点
        if(headNode==null || headNode.getNext()==null){
            return headNode;
        }
        Node reverse = null;
        while (headNode != null){
            //获得headNode的下一个节点
            Node nextNode = headNode.getNext();
            //把headNode插入到反转后链表的最前面
            headNode.setNext(reverse);
            //更新反转后链表的首节点
            reverse = headNode;
            //更新需要反转链表的首节点
            headNode = nextNode;

        }
        return reverse;
    }


}
