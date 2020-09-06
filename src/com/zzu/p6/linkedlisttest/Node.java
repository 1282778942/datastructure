package com.zzu.p6.linkedlisttest;

/**
 * @author CMOS
 * @date 2020/8/19 14:53
 */
public class Node {
    /**
     * 用于保存节点中的数据
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

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
