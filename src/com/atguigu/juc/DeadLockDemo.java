package com.atguigu.juc;

import java.util.concurrent.TimeUnit;

/**
 * Created by zld on 2019/10/13 0013.
 * 死锁:两个或两个以上的进程在执行过程中,因争抢资源而造成的一种互相等待的现象
 *
 *
 *
 */

class HoldLockThread implements Runnable{
    private String LockA;
    private String LockB;

    public HoldLockThread(String lockA, String lockB) {
        LockA = lockA;
        LockB = lockB;
    }

    @Override
    public void run() {
        synchronized (LockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+LockA+"\t 尝试获得"+LockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }

        synchronized (LockB){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+LockB+"\t 尝试获得"+LockA);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }


    }
}

public class DeadLockDemo {

    public static void main(String[] args) {
        String locka = "locka";
        String lockb = "lockb";

        new Thread(new HoldLockThread(locka,lockb),"ThreadAAAA").start();
        new Thread(new HoldLockThread(lockb,locka),"ThreadBBBB").start();

        /**查看进程的命令
         * Linux ps -ef | grep xxx
         * windows jps 查看的只是java
         *
         * jps -l查看进程号
         * jstack 找到死锁查看
         *
         */


    }

}
