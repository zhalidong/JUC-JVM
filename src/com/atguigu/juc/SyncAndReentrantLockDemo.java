package com.atguigu.juc;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zld on 2019/10/10 0010.
 * 多线程之间按顺序调用,实现A->B->C三个线程启动,要求如下:
 * AA打印5次,BB打印10次,CC打印15次
 * 接着....
 * 来10轮
 *
 *
 */
class ShareResource{
    private int number = 1;     //A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
          try {
              //1判断
              while (number!=1){
                c1.await();
              }
                //干活
              for (int i = 1; i <=5; i++) {
                  System.out.println(Thread.currentThread().getName()+i);
              }
              //通知B线程
                number = 2;
              c2.signal();
          }catch (Exception e){
              e.printStackTrace();
          }finally {
              lock.unlock();
          }

    }

    public void print10(){
        lock.lock();
        try {
            //1判断
            while (number!=2){
                c2.await();
            }
            //干活
            for (int i = 1; i <=5; i++) {
                System.out.println(Thread.currentThread().getName()+i);
            }
            //通知B线程
            number = 3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void print15(){
        lock.lock();
        try {
            //1判断
            while (number!=3){
                c3.await();
            }
            //干活
            for (int i = 1; i <=5; i++) {
                System.out.println(Thread.currentThread().getName()+i);
            }
            //通知B线程
            number = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}


public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(()->{
            for (int i = 1; i <=5; i++) {
                shareResource.print5();
            }
        },"A").start();

    }
}
