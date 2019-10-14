package com.atguigu.map17;

/**
 * Created by zld on 2019/9/25 0025.
 *
 *  JDK1.7以及之前的HashMap的底层实现是数组 + 链表
 *  1.数组的类型
 *  2.为什么有链表
 *
 *  3.数组的初始化的长度是多少
 *      初始化长度默认是16
 *      如果手动指定,那么必须是2的n次方,如果不是 会自动纠正2的n次方
 *
 *   4.数组是否会扩容
 *   会
 *
 *   为什么要扩容?如果不扩容,会导致链表变的很长,那么效率会降低
 *
 *
 *   什么情况会扩容?
 *      有一个变量threshold会判断是否需要扩容
 *          当这个值达到临界值,就会扩容,还要看当前添加(key,value)时是否table[index]==null
 *          如果table[index]!=null,那么就会扩容 ,如果table[index]==null,那么本次先不扩容
 *
 *   DEFAULT_LOAD_FACTOR:默认加载因子0.75
 *   threshold = table.length * 0.75
 *
 *
 *  5.index如何计算
 *      拿到一个key的hash值之后,如何计算[index]
 *          1.如果key是null,[index]=0
 *          2.第一步:先用hashcode值通过hash(key)函数得到一个比较分散的hash值
 *            第二步:再根据hash值与table.length做运算得到index
 *                  hash & table.length-1  按位于 确保index在[0-length-1]范围内
 *  6.如何避免key不可重复的
 *  换句话说如果key重复了这么办
 *  如果key相等,那么我们会替换旧的value
 *  key相同:先判断hash值,如果hash相同了,判断key的地址或者equals是否相等
 *
 *
 *  7.新的(key,value)添加到table[index]后,发现table[index]不为空,咋么连接的
 *  (key,value)是作为table[index]的头,原来下面的元素作为我的next
 *
 */

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put(1,"哈哈");
        map.put(2,"哈哈");
        map.put(3,"哈哈");
        map.put(4,"哈哈");
        map.put(5,"哈哈");
        map.put(6,"哈哈");

    }


}
