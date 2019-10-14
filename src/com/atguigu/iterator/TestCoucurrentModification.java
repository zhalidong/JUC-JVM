package com.atguigu.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zld on 2019/9/25 0025.
 *
 *
 * Iterator迭代器和foreach遍历 多线程并的问题
 * 用迭代器或foreach遍历时,再用集合对象的remove方法时会报异常
 * 因为迭代器和集合两条线路同时操作元素
 *
 *
 * 在foreach获取Iterator迭代器对象时,就会用expectedModCount记录当前集合被修改的次数modCount的值
 * expectedModCount = modCount;
 * 如果在迭代器或foreach遍历的过程中,发现expectedModCount != modCount,说明你用集合的add或remove等方法修改了当前集合的元素,
 * 就会报异常
 *
 *
 * 如果你用Iterator迭代器自己的删除方法的话 它会重新修改expectedModCount值,保证与modCount的值一样
 *
 *
 * 为了避免其他线程修改了集合的元素,导致当前这个操作的数据不正确,干脆失败,只要发现了
 * expectedModCount != modCount; 说明数据已经不是原来的数据了
 *
 */
public class TestCoucurrentModification {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add("张三");
        list.add("张三");
        list.add("张三");

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object next = it.next();
            System.out.println(next);
        }


    }

}
