package com.zzu.p5.cyclesinglelinkedlist;

/**
 * 模拟环形环形单链表的实现
 * @author CMOS
 * @date 2020/8/17 08:22
 */
public class CycleSingleLinkedList {

    /**
     * 用于保存环形单链表中的首节点
     */
    private Node headNode;
    /**
     * 用于保存环形单链表中的尾节点
     */
    private Node lastNode;
    /**
     * 用于保存环形单链表中节点的个数
     */
    private int size;

    /**
     * 获取环形单链表中节点的个数
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
        // 2.处理环形单链表为空表的情况
        if(headNode == null) {
            // 2.1把node节点设置为环形单链表的首节点
            headNode = node;
            // 2.2把node节点设置为环形单链表的尾节点
            lastNode = node;
        }
        // 3.处理环形单链表不是空表的情况
        else {
            // 3.1让lastNode指向node节点
            lastNode.next = node;
            // 3.2更新lastNode的值
            lastNode = node;
        }
        // 4.设置lastNode的next值为headNode
        lastNode.next = headNode;
        // 5.更新size的值
        size++;
    }

    /**
     * 根据序号获取元素
     * @param index 序号
     * @return 序号所对应节点的数据值
     */
    public Object get(int index) {
        // 1.判断序号是否合法，合法取值范围：[0, size - 1]
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("序号不合法，index:" + index);
        }
        // 2.根据序号获得对应的节点对象
        Node node = node(index);
        // 3.获取并返回node节点的数据值
        return node.data;
    }

    /**
     * 根据序号删除元素
     * @param index 序号
     */
    public void remove(int index) {
        // 1.判断序号是否合法，合法取值范围：[0, size - 1]
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("序号不合法，index:" + index);
        }
        // 2.处理删除节点在开头的情况
        if (index == 0) {
            // 2.1获得删除节点的后一个节点
            Node nextNode = headNode.next;
            // 2.2设置headNode的next值为null
            headNode.next = null;
            // 2.3设置nextNode为环形单链表的首节点
            headNode = nextNode;
            // 2.4设置lastNode的next值为headNode
            lastNode.next = headNode;
        }
        // 3.处理删除节点在末尾的情况
        else if (index == size - 1) {
            // 3.1获得删除节点的前一个节点
            Node preNode = node(index - 1);
            // 3.2设置preNode的next值为null
            preNode.next = null;
            // 3.3设置preNode为环形单链表的尾节点
            lastNode = preNode;
            // 3.4设置lastNode的next值为headNode
            lastNode.next = headNode;
        }
        // 4.处理删除节点在中间的情况
        else {
            // 4.1获得index-1所对应的节点对象
            Node preNode = node(index - 1);
            // 4.2获得index+1所对应的节点对象
            Node nextNode = preNode.next.next;
            // 4.3获得删除节点并设置next值为null
            preNode.next.next = null;
            // 4.4设置preNode的next值为nextNode
            preNode.next = nextNode;
        }
        // 5.更新size的值
        size--;
        // 6.判断size的值是否为0，如果size的值为0，则设置headNode和lastNode为null
        if(size == 0) {
            headNode = null;
            lastNode = null;
        }
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
        // 3.处理插入节点在开头位置的情况
        if(index == 0) {
            // 3.1设置node的next值为headNode
            node.next = headNode;
            // 3.2设置node节点为环形单链表的首节点
            headNode = node;
            // 3.3设置lastNode的next值为headNode
            lastNode.next = headNode;
        }
        // 4.处理插入节点在末尾位置的情况
        else if(index == size) {
            // 4.1设置lastNode的next值为node
            lastNode.next = node;
            // 4.2设置node节点为环形单链表的尾节点
            lastNode = node;
            // 4.3设置lastNode的next值为headNode
            lastNode.next = headNode;
        }
        // 5.处理插入节点在中间位置的情况
        else {
            // 5.1获得index-1所对应的节点对象
            Node preNode = node(index - 1);
            // 5.2获得index所对应的节点对象
            Node curNode = preNode.next;
            // 5.3设置preNode的next为node
            preNode.next = node;
            // 5.4设置node的next为curNode
            node.next = curNode;
        }
        // 6.更新size的值
        size++;
    }

    /**
     * 根据序号获得对应的节点对象
     * @param index 序号
     * @return 序号对应的节点对象
     */
    private Node node(int index) {
        if(headNode == null) {
            throw new NullPointerException("环形单链表为空表");
        }
        // 1.定义一个临时节点，用于辅助环形单链表的遍历操作
        Node tempNode = headNode;
        // 2.定义一个循环，用于获取index对应的节点对象
        for(int i = 0; i < index%size; i++) {
            // 3.更新tempNode的值
            tempNode = tempNode.next;
        }
        // 4.返回index对应的节点对象
        return tempNode;
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
         * 构造方法
         * @param data
         */
        public Node(Object data) {
            this.data = data;
        }
    }
}
