package com.zzu.p1.arrayList;

/**
 * 需要实现以下几个方法
 * 1)添加元素的方法  --> add(Object element)
 * 2)根据索引获取元素的方法  --> get(int index)
 * 3)根据索引删除元素的方法  --> remove(int index)
 * 4)根据索引插入元素的方法  --> add(int index, Object element)
 * @author CMOS
 * @date 2020/8/15 20:21
 */
public class ArrayList {
    /**
     * 定义一个数组，用于保存集合中的数据
     */
    private Object[] elementData;
    /**
     * 定义一个变量，用于保存数组中实际存放元素的个数
     */
    private int size;

    /**
     * 获取数组中实际存放元素的个数
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 无参构造方法（默认设置elementData数组的空间长度为10）
     */
    public ArrayList() {
        this.elementData = new Object[10];
    }

    /**
     * 有参构造方法（指定设置elementData数组的空间长度）
     * @param cap 需要设置elementData的空间长度
     */
    public ArrayList(int cap) {
        // 1.判断cap变量是否合法
        if(cap < 0)
            throw new RuntimeException("参数不合法，cap:" + cap);
        // 2.实例化elementData数组
        this.elementData = new Object[cap];
    }

    /**
     * 添加元素
     * @param element 需要添加的元素
     */
    public void add(Object element) {
        // 1.判断数组是否需要扩容
        ensureCapacityInternal();
        // 2.把element添加进入数组中
        elementData[size] = element;
        // 3.更新size的值
        size++;
    }

    /**
     * 根据索引获取元素值
     * @param index 索引值
     * @return 数组中index索引对应的元素值
     */
    public Object get(int index) {
        // 1.判断索引是否合法，合法的取值范围：[0, size - 1]
        rangeCheck(index);
        // 2.根据索引获取对应的元素值
        return elementData[index];
    }

    /**
     * 根据索引删除元素
     * @param index 索引值
     */
    public void remove(int index) {
        // 1.判断索引是否合法，合法取值范围：[0, size - 1]
        rangeCheck(index);
        // 2.把删除索引之后的元素往前挪动一位
        // 2.1先获得删除索引及其之后的所有索引值
        for(int i = index; i < size - 1; i++) { // i = size - 1
            // 2.2把后一个元素往前挪动一位
            elementData[i] = elementData[i + 1]; // i + 1 = size
        }
        // 3.把最后一个实际添加的元素设置为默认值
        elementData[size - 1] = null;
        // 4.更新size的值
        size--;
    }

    /**
     * 检查索引是否合法（get和remove）
     * @param index 需要检查的索引值
     */
    private void rangeCheck(int index) {
        // 判断索引是否合法，合法取值范围：[0, size - 1]
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("索引异常，index:" + index);
        }
    }

    /**
     * 根据索引插入元素
     * @param index 插入元素的索引位置
     * @param element 需要插入的元素
     */
    public void add(int index, Object element) {
        // 1.判断索引是否合法，合法的取值范围：[0, size] --> 插入的元素可以在实际添加元素的最末尾
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("索引异常，index:" + index);
        }
        // 2.判断数组是否需要扩容
        ensureCapacityInternal();
        // 3.插入索引及其之后的元素往后挪动一位（从后往前挪动）
        // 3.1获得插入索引及其之后的所有索引值
        for(int i = size - 1; i >= index; i--) {
            // 3.2把前一个元素往后挪动一位
            elementData[i + 1] = elementData[i];
        }
        // 4.在插入索引位置实现赋值操作
        elementData[index] = element;
        // 5.更新size的值
        size++;
    }

    /**
     * 判断数组是否需要执行扩容操作
     */
    private void ensureCapacityInternal() {
        // 1.当数组的空间长度等于数组实际存放元素的个数时，这时就需扩容操作
        if(elementData.length == size) {
            // 2.创建一个比原数组空间长度更大的新数组
            Object[] newArr = new Object[elementData.length * 2 + 1];
            // 3.把原数组中的元素拷贝进入新数组中
            for(int i = 0; i < size; i++) {
                newArr[i] = elementData[i];
            }
            // 4.让原数组保存新数组的地址值
            elementData = newArr;
        }
    }
}
