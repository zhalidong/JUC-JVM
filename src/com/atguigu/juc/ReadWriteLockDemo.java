package com.atguigu.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class mycache{  //资源类
    private volatile Map<String,Object> map = new HashMap<>();   //volatile保持可见性
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();



    public void put(String key,Object value){

        rwlock.writeLock().lock();      //写锁
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch (Exception e){

        }finally {
            rwlock.writeLock().unlock();
        }
    }

    public void get(String key){

        rwlock.readLock().lock();      //写锁
        try {

            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            Object result=map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
        }catch (Exception e){

        }finally {
            rwlock.readLock().unlock();
        }

    }

}


/**
 * 独占锁:指该锁一次只能被一个线程所持有,对ReentrantLock和SYnc而言都是独占锁
    共享锁:指该锁可被多个线程所持有
        对ReentrantReadWriteLock其读锁是共享锁,其写锁是独占锁.
        读锁的共享锁可保证并发读是非常高效的,读写,写读,写写的过程是互斥的
 *
 * 多个线程同时读一个资源类没有任何问题,所以为了满足并发量,读取共享资源应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源,就不应该再有其他线程可以对该资源进行读或写
 *
 * 小总结: 读写锁  读写分离
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 *
 *      写操作:原子+独占 整个过程必须是一个完整的统一体,中间不允许被分割,被打断
 *
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        mycache m1 = new mycache();
        for (int i = 1; i <=5 ; i++) {
            final int temp = i;
            new Thread(()->{
                m1.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <=5 ; i++) {
            final int temp = i;
            new Thread(()->{
                m1.get(temp+"");
            },String.valueOf(i)).start();
        }

    }

}
