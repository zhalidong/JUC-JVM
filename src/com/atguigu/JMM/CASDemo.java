package com.atguigu.JMM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zld on 2019/10/8 0008.
 *
 * CAS是什么?  ==> compareAndSet 比较当前工作内存中的值和主内存中的值,如果相同则执行操作,否则继续比较直到主内存和工作内存中的值一致为止
 * CAS应用
 *      CAS有3个操作数,内存值V,旧的预期值A,要修改的更新值B,当且预期值A和内存值V相同时,将内存值V修改为B,否则什么都不做
 *
 *  比较并交换  比较主物理内存的值和线程的期望值一样,就交换
 *  底层是unsafe类 此类中方法直接调用底层资源
 *  CAS缺点:
 *      循环时间长,开销大
 *      只能保证一个共享变量的原子性
 *      ABA问题
 *
 *   ABA问题:
 *      A线程从a改成b然后又改成了a ,B线程以为就是a没有变化过 其实是变化了
 *
 *
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data :"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data :"+atomicInteger.get());
        /**
         *     public final int getAndIncrement() {
         return unsafe.getAndAddInt(this, valueOffset, 1);
         }
         *this:当前对象
         *valueOffset:内存偏移量,内存地址
         */
        atomicInteger.getAndIncrement();

    }

}
