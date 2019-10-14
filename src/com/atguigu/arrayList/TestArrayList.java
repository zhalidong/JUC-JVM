package com.atguigu.arrayList;

import java.util.ArrayList;

/**
 * Created by zld on 2019/9/25 0025.
 *
 * 动态数组:内部实现是数组
 *      1.初始化大小 10
 *      如果JDK1.8时new ArrayList(); 发现数组初始化为 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 长度为0的数组
 *      如果JDK1.6时new ArrayList(); 发现数组初始化为 一个长度为10 的数组
 *      如果JDK1.7时new ArrayList(); 发现数组初始化为 一个长度为0 的数组
 *
 *      2.添加元素时,如果数组满了,如何扩容
 *      扩容1.5倍
 *
 *      JDK1.7和1.8时,因为一开始是空数组,那么第一次扩展为长度为10的数组
 *      然后不够了 再扩容为原来的1.5倍
 *
 *
 *      3.删除元素时,数组会不会减小
 *      不会
 *      但是想Arraylist有一个这个方法trimToSize()可以调整大小
 *
 *
 */
public class TestArrayList {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();

    }


}
