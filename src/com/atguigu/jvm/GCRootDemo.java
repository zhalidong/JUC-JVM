package com.atguigu.jvm;

/**
 * Created by zld on 2019/10/13 0013.
 *
 *GC ROOTS对象:虚拟机栈中的对象,方法区中静态对象 方法区常量引用对象 本地方法栈中引用的对象(nativd方法)
 *
 *
 *
 */





public class GCRootDemo {

    private  byte[] byteArray = new byte[100*1024*1024];

    public static void m1(){            //方法在栈内
        GCRootDemo t1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
