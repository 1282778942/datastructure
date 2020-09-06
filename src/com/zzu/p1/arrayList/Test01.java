package com.zzu.p1.arrayList;

/**
 * @author CMOS
 * @date 2020/8/15 20:22
 */
public class Test01 {
    public static void main(String[] args) {
        // 创建ArrayList对象
        ArrayList list = new ArrayList(3);
        // 添加元素
        list.add("aa"); // 0
        list.add("bb"); // 1
        list.add("cc"); // 2
        list.add("dd"); // 3
        list.add("ee"); // 4

         //根据索引添加元素
        list.add(1,"ff");
//         遍历集合中的所有元素，合法的索引范围：[0, size - 1]
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
