package com.zzu.p6.linkedlisttest;

/**
 * 复杂链表的复制
 * @author CMOS
 * @date 2020/9/6 16:53
 */
public class Test11 {
    public static void main(String[] args) {
        // 1.创建一个复杂链表
        Node lastNode = new Node("E",null);
        Node node4 = new Node("D", lastNode);
        Node node3 = new Node("C", node4);
        Node node2 = new Node("B", node3);
        Node headNode = new Node("A", node2);
        headNode.random = node3;
        node2.random = lastNode;
        node4.random = node2;
        // 2.复杂链表的复制
        Node cloneNode = cloneNode(headNode);
        System.out.println();
    }

    /**
     * 复杂链表的复制
     * @param headNode 复杂链表的首节点
     * @return 返回复制后复杂链表的首节点
     */
    public static Node cloneNode(Node headNode){
        // 1.处理headNode为null的情况
        if (headNode == null) {
            return null;
        }
        // 2.复制复杂链表中的每一个节点，并且把复制的节点添加到被复制节点的后面
        Node curNode = headNode;
        while (curNode != null) {
            // 创建一个复制节点（N'）
            Node node = new Node(curNode.data);
            // 设置node节点的next值为curNode的后一个节点
            node.next = curNode.next;
            // 设置curNode的next值为node
            curNode.next = node;
            // 更新curNode的值
            curNode = node.next;
        }
        // 3.设置每一个复制节点的random指针
        curNode = headNode;
        while (curNode != null) {
            // 获得复制节点（N'）
            Node node = curNode.next;
            // 处理curNode的random指针不为null的情况
            if (curNode.random != null) {
                // 设置node的random值为curNode.random的下一个节点
                node.random = curNode.random.next;
            }
            // 更新curNode的值
            curNode = node.next;
        }
        // 4.把长链表拆分为两个链表
        // 定义一个节点，用于保存拷贝后复杂链表的首节点
        Node head = headNode.next;
        curNode = headNode;
        while (curNode != null) {
            // 获得复制节点（N'）
            Node node = curNode.next;
            // 设置curNode的next值为node.next
            curNode.next = node.next;
            // 设置node的next值为node.next.next
            node.next = node.next == null ? null : node.next.next;
            // 更新curNode的值
            curNode = curNode.next;
        }
        // 5.返回拷贝后复杂链表的首节点
        return head;
    }

    /**
     * 节点类
     */
    private static class Node {
        /**
         * 用于保存节点中的数据
         */
        private Object data;
        /**
         * 用于保存指向下一个节点的地址值
         */
        private Node next;
        /**
         * 用于保存指向任意节点的地址值
         */
        private Node random;

        /**
         * 专门为data做初始化工作
         * @param data
         */
        public Node(Object data) {
            this.data = data;
        }

        /**
         * 专门为data和next做初始化工作
         * @param data
         * @param next
         */
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
