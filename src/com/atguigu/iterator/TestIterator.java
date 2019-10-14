package com.atguigu.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zld on 2019/9/25 0025.
 *
 * 接口:
 *  hasNext
 *
 *  next
 *
 *  remove
 *  Iterator的实现类在哪里
 *
 *
 *  例如
 *  ArrayList:内部有一个内部类,Itr implements Iterator接口
 *
 *  每一种Collection系列集合的实现类都有一个内部类实现了Iterator接口
 */
public class TestIterator {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        Iterator it = arrayList.iterator();


    }


}
