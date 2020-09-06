package com.zzu.p6.linkedlisttest;

/**
 * 合并两个有序链表
 * @author CMOS
 * @date 2020/9/5 18:01
 */
public class Test05 {
    public static void main(String[] args) {
        //创建一个单链表
        Node lastNode1 = new Node(12,null);
        Node node1_6 = new Node(9,lastNode1);
        Node node1_5 = new Node(8,node1_6);
        Node node1_4 = new Node(7,node1_5);
        Node node1_3 = new Node(5,node1_4);
        Node node1_2 = new Node(3,node1_3);
        Node headNode1 = new Node(1,node1_2);
        //创建一个单链表
        Node lastNode2 = new Node(26,null);
        Node node2_6 = new Node(18,lastNode2);
        Node node2_5 = new Node(17,node2_6);
        Node node2_4 = new Node(13,node2_5);
        Node node2_3 = new Node(6,node2_4);
        Node node2_2 = new Node(4,node2_3);
        Node headNode2 = new Node(2,node2_2);

        //测试合并链表
        Node headNode = mergeList(headNode1, headNode2);
        utils.print(headNode);
    }

    /**
     * 将两个有序单链表进行合并
     * @param headNode1 第一个单链表
     * @param headNode2 第二个单链表
     * @return 合并完以后的链表头节点
     */
    public static Node mergeList(Node headNode1,Node headNode2){
        if(headNode1==null && headNode2==null){
            return null;
        }
        if(headNode1 == null){
            return headNode2;
        }
        if(headNode2 == null){
            return headNode1;
        }
        Node headNode=null,lastNode=null;
        if((int)headNode1.getData()>(int) headNode2.getData()){
            headNode = headNode2;
            lastNode = headNode2;
            headNode2 = headNode2.getNext();
        }
        else{
            headNode = headNode1;
            lastNode = headNode1;
            headNode1 = headNode1.getNext();
        }
        while (headNode1!=null && headNode2!=null){
            if((int)headNode1.getData()>(int) headNode2.getData()){
                lastNode.setNext(headNode2);
                lastNode = headNode2;
                headNode2 = headNode2.getNext();
            }
            else{
                lastNode.setNext(headNode1);
                lastNode = headNode1;
                headNode1 = headNode1.getNext();
            }
        }
        if(headNode1 != null){
            lastNode.setNext(headNode1);
        }
        else{
            lastNode.setNext(headNode2);
        }
        return headNode;
    }
}
