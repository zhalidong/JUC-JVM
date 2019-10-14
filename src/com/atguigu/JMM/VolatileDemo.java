package com.atguigu.JMM;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zld on 2019/10/2 0002.
 *
 *  验证volatile的可见性 主内存和别的线程之间的可见性
 *
 * JMM(java内存模型 )三大特性:可见性(通知机制)  原子性 有序性
 *
 * 工作内存和主内存同步延迟现象导致的可见性问题
 * 可以使用sync或volatile关键字解决,他们都可以使一个线程修改后的变量立即对其他线程可见
 *
 *
 */

class   MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number= 60;
    }

    //此时number是加了volatile修饰 不保证原子性
    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }


}

/**
 * volatile轻量级同步机制
 *      可见性(通知机制)  不保证原子性 禁止指令重排  ==按照代码顺序执行 不使用编译器的代码优化  单线程不存在  只有在多线程中才存在
 *  验证volatile的可见性
 * 1.1 加入number = 0 number变量之前没有使用 volatile修饰 没有可见性
 * 1.2 添加了volatile修饰 可以解决可见性问题
 *
 * 2.验证volatile修饰不保证原子性
 * 2.1 原子性指的是什么意思
 *  不可分割 完整性 也就是莫个线程正在做具体义务时,中间不可以被加塞或者被分割,需要整体完整
 *  要么同时成功 要么同时失败
 *
 *  2.2 volatile修饰不保证原子性的案例演示
 *
 *
 *  2.3 why
 *
 *  2.4 如何解决原子性
 *      1.加sync
 *      2.使用我们的JUC下的AtomicInteger   底层是CAS
 *
 *
 */
public class VolatileDemo {

    public static void main(String[] args) {
//        seekokByVolatile();

        MyData myData = new MyData();
        //20个线程
        for (int i = 1; i <=20; i++) {

            new Thread(()->{
                for (int j = 1; j <=1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程都全部计算完成后,再用main线程取得最后的结果
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"value:"+myData.atomicInteger);

    }


    /**
     * volatile可以保证可见性,及时通知其他线程,在物理内存的值已经被修改
     */
    public static void seekokByVolatile(){
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"value:"+myData.number);
        },"AAA").start();

        while (myData.number==0){
            //main线程就一直再这里循环,直到number不再等于0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over get numbwe"+myData.number);

    }



}




