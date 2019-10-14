package com.atguigu.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by zld on 2019/9/25 0025.
 *
 * set的底层实现,内部实现
 *
 * Hashset :内部实现是HashMap
 *              添加(add)到hashset的元素是hashmap的key,所有的value共享同一个object常量的对象PRESENT
 *
 *
 *
 * Linkedhashset:内部实现是LinkedHashMap
 *              添加(add)到Hashset的元素是LinkedHashMap的key,所有的value共享同一个object常量的对象PRESENT
 * TreeSet:内部实现是treeMap
 *  *           添加(add)到hashset的元素是treeMap的key,所有的value共享同一个object常量的对象PRESENT
 *
 */
public class TestSet {

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("张三");


        LinkedHashSet lset = new LinkedHashSet();

        TreeSet tree = new TreeSet();
    }


}
