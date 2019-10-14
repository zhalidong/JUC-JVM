package com.atguigu.jvm;

/**
 * Created by zld on 2019/9/27 0027.
 *
 *
 *
 */
public class MyObject {

    public static void main(String[] args) {

        Object object = new Object();
        object.getClass();                          // 反射找出模板
        System.out.println(object.getClass().getClassLoader());

        /*MyObject myObject = new MyObject();
        //自定义
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());

        Thread t1 = new Thread();       //底层调用native void start0();
        t1.start();
        t1.start();     //start 调用两次 throw new IllegalThreadStateException();异常
        */
    }

}
