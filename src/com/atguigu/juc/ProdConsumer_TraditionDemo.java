package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData1{   //资源类
    private  int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void add()throws Exception{
        lock.lock();
        try {
            //1.判断
            while (number!=0){
                //等待 不能生产
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void plus()throws Exception{
        lock.lock();
        try {
            //1.判断
            while (number==0){
                //等待 不能生产
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


/**
 * Created by zld on 2019/10/10 0010.
 * 一个初始值为0的变量,两个线程对其交替操作一个加1一个减1,5轮 lock await sinal
 *      多线程判断用while不能用if
 *  1.资源类
 *
 *  sync和lock的区别
 *  1.synchronized是关键字 lock是类
 *  2.synchronized不需要用户手动释放锁,lock需要手动释放锁,不释放会死锁
 *  3.synchronized不可以中断,除非异常或者运行完成 lock可中断tryLock
 *  4.加锁是否公平synchronized非公平锁,
 *  5.锁绑定多个条件Condition
 *      ReentrantLock用来实现分组唤醒需要唤醒的线程,可以精确唤醒,而不是像synchronized那么随机唤醒一个线程要么唤醒全部线程
 *      A->B->c
 *
 *
 *
 */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {

        ShareData1 shareData1 = new ShareData1();

        new Thread(()->{
            for (int i = 1; i <=5; i++) {
                try {
                    shareData1.add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"AA").start();


        new Thread(()->{
            for (int i = 1; i <=5; i++) {
                try {
                    shareData1.plus();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"BB").start();

    }
}
