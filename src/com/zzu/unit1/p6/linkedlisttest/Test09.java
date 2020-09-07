package com.zzu.unit1.p6.linkedlisttest;

/**
 * 获取环形链表的环起始节点
 * 实现步骤:
 * 1）获得带环单链表中环的长度，我们记为length。
 * 2）定义first和second指针，并且设置初始值为单链表的首节点。
 * 3）让first指针往后移动length次。
 * 4）定义一个循环，每次让first和second指针往后移动一次。当
 * first和second指针指向的是同一个节点时，那么就停止循环。此
 * 时，first和second指向的节点就是带环单链表中环的起始点。
 * @author CMOS
 * @date 2020/9/6 14:45
 */
public class Test09 {
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
        System.out.println(getRingLength(headNode));



    }

    /**
     * 首次获得快慢指针相遇节点
     * @param headNode
     * @return
     */
    public static Node getMeetNode(Node headNode) throws Exception {
        if(headNode == null){
            throw new Exception("headNode为空");
        }
        Node fast = headNode;
        Node slow = headNode;
        Node meetNode = null;
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow){
                meetNode = fast;
                return meetNode;
            }
        }
        return null;
    }

    /**
     * 从相遇节点开始遍历，得到环的长度
     * @param headNode
     * @return
     */
    public static int getRingLength(Node headNode) throws Exception {
        Node meetNode = getMeetNode(headNode);
        if(meetNode == null){
            return 0;
        }
        Node temp = meetNode;
        int length = 0;
        while (true){
            temp = temp.getNext();
            length++;
            if(temp == meetNode){
                break;
            }
        }
        return length;
    }

    /**
     * 定义快慢指针，初始指向headNode节点
     * fast指针往后移动length次，然后fast和slow同步向后移动
     * 直到fast和slow指向同一节点，该节点即为环开始节点
     * @param headNode
     * @return
     */
    public static Node getRingStart(Node headNode) throws Exception {
        int length = getRingLength(headNode);
        if(length == 0){
            return null;
        }
        Node first = headNode;
        Node second = headNode;
        for(int i=0;i<length;i++){
            first = first.getNext();
        }
        while(first != second){
            first = first.getNext();
            second = second.getNext();
        }
        return first;
    }
}
