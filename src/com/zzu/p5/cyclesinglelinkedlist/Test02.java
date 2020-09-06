package com.zzu.p5.cyclesinglelinkedlist;

/**
 * 环形单链表的约瑟夫问题
 * @author CMOS
 * @date 2020/8/19 08:14
 */
public class Test02 {
    public static void main(String[] args) {
        // 创建一个环形单链表
        Node lastNode = new Node(11);
        Node node10 = new Node(10, lastNode);
        Node node9 = new Node(9, node10);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node headNode = new Node(1, node2);
        lastNode.next = headNode;
        // 执行约瑟夫方法
        josephus(headNode, lastNode, 11, 5, 3);
    }

    /**
     * 约瑟夫问题
     * @param headNode 环形单链表的首节点
     * @param lastNode 环形单链表的尾节点
     * @param size 环形单链表中节点的个数
     * @param start 从编号为start的小孩开始报数
     * @param count 每次数几下
     */
    public static void josephus(Node headNode, Node lastNode, int size, int start, int count) {
        // 1.处理不合法的情况
        // 1.1处理headNode为null的情况
        if(headNode == null) {
            throw new NullPointerException("headNode为null");
        }
        // 1.2处理start和count不合法的情况
        if(start < 1 || start > size || count < 1) {
            throw new IllegalArgumentException("参数不合法");
        }
        // 2.设置编号为start的小孩开始报数，并且使用headNode指向该节点
        // 把headNode和lastNode往后移动start-1次
        for (int i = 0; i < start - 1; i++) {
            headNode = headNode.next;
            lastNode = lastNode.next;
        }
        // 3.定义一个循环，用于循环的执行报数操作
        while (size != 0) { // 如果size等于0，则停止报数
            // 4.执行报数操作，也就是找到需要出圈的小孩，我们使用headNode指向需要出圈的节点
            // 把headNode和lastNode往后移动count-1次
            for (int i = 0; i < count - 1; i++) {
                headNode = headNode.next;
                lastNode = lastNode.next;
            }
            // 5.输出需要出圈小孩的编号，也就是输出headNode保存的数据值
            System.out.println(headNode.data);
            // 6.实现小孩的出圈操作，也就是把headNode从环形单链表中删除
            // 6.1获得删除节点的后一个节点
            Node nextNode = headNode.next;
            // 6.2设置lastNode的next值为nextNode
            lastNode.next = nextNode;
            // 6.3设置headNode的next值为null
            headNode.next = null;
            // 7.更新size的值
            size--;
            // 8.设置headNode指向nextNode
            headNode = nextNode;
        }
    }


        /**
         * 节点类
         */
    private static class Node {
        /**
         * 用于保存节点中的数据值
         */
        private Object data;
        /**
         * 用于保存下一个节点的地址值
         */
        private Node next;

        /**
         * 专门为data做初始化的工作
         * @param data
         */
        public Node(Object data) {
            this.data = data;
        }

        /**
         * 专门为data和next做初始化的工作
         * @param data
         * @param next
         */
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
