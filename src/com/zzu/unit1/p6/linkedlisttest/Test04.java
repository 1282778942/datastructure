package com.zzu.unit1.p6.linkedlisttest;

/**
 * 查找单链表倒数第k个节点，要求：不允许遍历获得单链表长度
 * @author CMOS
 * @date 2020/9/5 16:57
 */
public class Test04 {
    public static void main(String[] args) throws Exception {
        //创建一个单链表
        Node lastNode = new Node("77",null);
        Node node6 = new Node("66",lastNode);
        Node node5 = new Node("55",node6);
        Node node4 = new Node("44",node5);
        Node node3 = new Node("33",node4);
        Node node2 = new Node("22",node3);
        Node headNode = new Node("11",node2);
        Node node = findNode(headNode,3);
        System.out.println(node.getData());
    }

    /**
     * 核心思想：定义first和second两个指针同时指向首节点，
     * first指针先向后移动k-1个节点，然后两个节点同时向后移动，
     * 当first指针指向尾节点时，second节点指向倒数第k个节点
     * @param headNode
     * @param k
     * @return
     */
    public static Node findNode(Node headNode,int k) throws Exception {
        if(headNode == null){
            throw  new NullPointerException("headNode为空");
        }
        Node first = headNode;
        Node second = headNode;

        int size = 1;
        while (headNode.getNext() != null){
            headNode = headNode.getNext();
            size++;
        }
        if(k<1||k>size){
            System.out.println("k值非法");
            return null;
        }else{
            for(int i=0;i<k-1;i++){
                first = first.getNext();
            }
            while(first.getNext() != null){
                first = first.getNext();
                second = second.getNext();
            }
            return second;
        }
    }

}
