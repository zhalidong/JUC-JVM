package com.atguigu.collection;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by zld on 2019/9/25 0025.
 * 集合:
 *         主要是两大类:
 *              1.Collection:(接口)一组对象    单身party
 *              2.Map:键值对 (key,value) 家庭party
 *
 * 1.list
 *      列表:可重复的,有序(按顺序存储)
 *          实现类 例如arraylist(动态数组)
 * 2.set
 *      集:不可重复 无序的(和添加数据无关)
 *
 *
 *
 */
public class TestCollection {

    @Test
    public void test1(){
        ArrayList c = new ArrayList();
        c.add("张三");
        c.add("李四");
        ArrayList c1 = new ArrayList();
        c1.add("王五");
        c1.add("赵六");

        System.out.println(c.size());
    }

}
