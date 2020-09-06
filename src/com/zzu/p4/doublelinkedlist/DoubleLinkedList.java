package com.zzu.p4.doublelinkedlist;

/**
 * 模拟双链表的实现
 * @author CMOS
 * @date 2020/8/17 10:31
 */
public class DoubleLinkedList {
    /**
     * 用于保存双链表中的首节点
     */
    private Node headNode;
    /**
     * 用于保存双链表中的尾节点
     */
    private Node lastNode;
    /**
     * 用于保存双链表中节点的个数
     */
    private int size;

    /**
     * 获取双链表中节点的个数
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 添加元素
     * @param element 需要添加的数据
     */
    public void add(Object element) {
        // 1.把需要添加的数据封装成节点对象
        Node node = new Node(element);
        // 2.处理双链表为空表的情况
        if(headNode == null) {
            // 2.1把node节点设置为双链表的首节点
            headNode = node;
            // 2.2把node节点设置为双链表的尾节点
            lastNode = node;
        }
        // 3.处理双链表不是空表的情况
        else {
            // 3.1设置lastNode的next值为node
            lastNode.next = node;
            // 3.2设置node的pre值为lastNode
            node.pre = lastNode;
            // 3.3设置node节点为双链表的尾节点
            lastNode = node;
        }
        // 4.更新size的值
        size++;
    }

    /**
     * 根据序号获得元素
     * @param index 序号
     * @return 序号所对应的节点对象的数据值
     */
    public Object get(int index) {
        // 1.判断序号是否合法，合法取值范围：[0, size - 1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("序号不合法，index：" + index);
        }
        // 2.根据序号获得对应的节点对象
        Node node = node(index);
        // 3.获得并返回node节点数据值
        return node.data;
    }

    /**
     * 根据序号删除元素
     * @param index 序号
     */
    public void remove(int index) {
        // 1.判断序号是否合法，合法取值范围：[0, size - 1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("序号不合法，index:" + index);
        }
        // 2.处理删除节点为首节点的情况
        if(index == 0) {
            // 2.1获得删除节点的下一个节点
            Node nextNode = headNode.next;
            // 2.2设置headNode的next值为null
            headNode.next = null;
            // 2.3设置nextNode的pre值为null
            if(nextNode != null) {//防止只有头节点时nextNode为空调用nextNode.pre报空指针异常
                nextNode.pre = null;
            }
            // 2.4设置nextNode为双链表的首节点
            headNode = nextNode;
        }
        // 3.处理删除节点为尾节点的情况
        else if(index == size - 1) {
            // 3.1获得删除节点的前一个节点
            Node preNode = lastNode.pre;
            // 3.2设置preNode的next值为null
            preNode.next = null;
            // 3.3设置lastNode的pre值为null
            lastNode.pre = null;
            // 3.4设置preNode为双链表的尾节点
            lastNode = preNode;
        }
        // 4.处理删除节点为中间节点的情况
        else {
            // 4.1获得删除节点对象
            Node delNode = node(index);
            // 4.2获得删除节点的前一个节点
            Node preNode = delNode.pre;
            // 4.3获得删除节点的后一个节点
            Node nextNode = delNode.next;
            // 4.4设置preNode的next值为nextNode
            preNode.next = nextNode;
            // 4.5设置nextNode的pre值为preNode
            nextNode.pre = preNode;
            // 4.6设置delNode的next值和pre值为null
            delNode.next = null;
            delNode.pre = null;
        }
        // 5.更新size的值
        size--;
    }

    /**
     * 根据序号插入元素
     * @param index 序号
     * @param element 需要插入的数据
     */
    public void add(int index, Object element) {
        // 1.判断序号是否合法，合法取值范围：[0, size]
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("序号不合法，index:" + index);
        }
        // 2.把需要添加的数据封装成节点对象
        Node node = new Node(element);
        // 3.处理插入节点在开头的情况
        if(index == 0) {
            // 3.1设置node的next值为headNode
            node.next = headNode;
            // 3.2设置headNode的pre值为node
            headNode.pre = node;
            // 3.3设置node节点为双链表的首节点
            headNode = node;
        }
        // 4.处理插入节点在末尾的情况
        else if(index == size) {
            add(element);
            return;
        }
        // 5.处理插入节点在中间的情况
        else {
            // 5.1获得插入位置所对应的节点对象
            Node curNode = node(index);
            // 5.2获得插入位置前面的那一个节点对象
            Node preNode = curNode.pre;
            // 5.3设置node节点和preNode节点之间的连线
            preNode.next = node;
            node.pre = preNode;
            // 5.4设置node节点和curNode节点之间的连线
            node.next = curNode;
            curNode.pre = node;
        }
        // 6.更新size的值
        size++;
    }

    /**
     * 根据序号获得对应的节点对象
     * @param index 序号
     * @return 序号所对应的节点对象
     */
    private Node node(int index) {
        // 1.如果查找的节点在双链表的前半区，则从前往后查找
        if(index < size / 2) {
            // 1.1定义一个零时节点，用于辅助双链表的遍历
            Node nextNode = headNode;
            // 1.2定义一个循环，从前往后查找index所对应的节点对象
            for(int i = 0; i < index; i++) {
                // 1.3更新nextNode的值
                nextNode = nextNode.next;
            }
            // 1.4返回index所对应的节点对象
            return nextNode;
        }
        // 2.如果查找的节点在双链表的后半区，则从后往前查找
        else {
            // 2.1定义一个零时节点，用于辅助双链表的遍历
            Node preNode = lastNode;
            // 2.2定义一个循环，从后往前查找index所对应的节点对象
            for(int i = size - 1; i > index; i--) {
                // 2.3更新preNode的值
                preNode = preNode.pre;
            }
            // 2.4返回index所对应的节点对象
            return preNode;
        }
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
         * 用于保存上一个节点的地址值
         */
        private Node pre;
        /**
         * 用于保存下一个节点的地址值
         */
        private Node next;
        /**
         * 构造方法
         * @param data
         */
        public Node(Object data) {
            this.data = data;
        }
    }
}

