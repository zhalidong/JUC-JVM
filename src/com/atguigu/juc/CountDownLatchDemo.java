package com.atguigu.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zld on 2019/10/10 0010.
 *  让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒
 *  CountDownLatch主要有两个方法,当一个或多个线程调用await方法时,调用线程会被阻塞
 *  其他线程调用CountDown方法会将计数器减1(调用CountDown方法的线程不会阻塞)
 *  当计数器的值变为0时,因调用await方法被阻塞的线程会被唤醒,继续执行
 *
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);


        for (int i = 1; i <=6; i++) {

            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"\t国,被灭");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t一统中国");

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);


        for (int i = 1; i <=6; i++) {

            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"\t上完自习,离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长最后关门走人");
    }

}
