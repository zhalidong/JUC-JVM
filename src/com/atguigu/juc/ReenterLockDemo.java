package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone01 implements Runnable{
    public  synchronized void  sendSMS()throws Exception{

        System.out.println(Thread.currentThread().getName()+"\t sendsms()");
        sendemail();
    }

    public  synchronized void  sendemail()throws Exception{

        System.out.println(Thread.currentThread().getName()+"\t sendemail()");
    }

    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t get()");
            set();
        }finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t set()");
        }finally {
            lock.unlock();
        }
    }
}




/**
 * Created by zld on 2019/10/9 0009.
 *公平锁:是指多个线程按照申请锁的顺序来获取锁,类似排队打饭,先来后到
    并发包中ReentrantLock的创建可以指定构造函数的boolean类型来得到公平锁或非公平锁,默认是非公平锁(synchronized也是非公平锁)

 非公平锁:是指多个线程获取锁的顺序并不是按照申请锁的顺序,有可能后申请的线程比先申请的线程优先获取锁,在高并发的情况下,有可能会造成优先级反转或者饥饿现象
    上来就直接尝试占有锁,如果尝试失败,就会采用公平锁 优点在于吞吐量比公平锁大
 *
 *
 *
 *
 *可重入锁(递归锁) 作用:避免死锁
 *同一个线程外层函数获得锁之后,内存递归函数仍然能获取该锁的代码
    在同一个线程在外层方法获取锁的时候,在进入内层方法会自动获取锁
    也就是说,线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 *case one  synchronized是一个典型的可重入锁
 * t1	 sendsms()              t1 在外层方法获取锁的时候
   t1	 sendemail()            t1 在进入内层方法会自动获取锁

   t2	 sendsms()
   t2	 sendemail()
 *
 *
 * case two ReenterLock是一个典型的可重入锁
 *
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone01 phone01 = new Phone01();

        new Thread(()->{
            try {
                phone01.sendSMS();

            } catch (Exception e) {
                e.printStackTrace();
            }

        },"t1").start();

        new Thread(()->{
            try {
                phone01.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"t2").start();

        Thread t3 = new Thread(phone01);
        Thread t4 = new Thread(phone01);

        t3.start();
        t4.start();


    }
}
