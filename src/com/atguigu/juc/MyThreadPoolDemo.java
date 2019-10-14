package com.atguigu.juc;

import java.util.concurrent.*;

/**
 * Created by zld on 2019/10/12 0012.
 * 第四种java多线程的方式,线程池
 * 线程池:主要是控制运行的线程的数量,处理过程中将任务放入队列,然后在线程创建后启动这些任务,如果线程数量超过了最大数量,超出数量的线程排队等候,
 *          等其他线程执行完毕后,再从队列中取出任务来执行
 *
 * 特点,线程复用,控制最大并发数,管理线程
 *
 *
 *
 *  底层就是ThreadPoolExecutor
 *  参数:corePoolSize:常驻核心线程数
 *      maximumPoolSize:能容纳的最大的线程数
 *      keepAliveTime:多余的空闲线程的存活时间(多余的空闲线程会被销毁直到只剩下corePoolSize个线程为止)
 *      unit:keepAliveTime的单位
 *      workQueue:任务队列 未执行的任务 阻塞队列
 *      threadFactory:创建线程的工厂
 *      handler:拒绝策略,队列满了 工作线程大于线程池中的最大线程数
 *
 *
 *  Executors.newFixedThreadPool()  执行长期的任务,性能好很多
 *  Executors.newSingleThreadExecutor() 一个任务一个任务执行的场景
 *  Executors.newCachedThreadPool()     执行很多短期异步的小程序
 *
 *  线程池拒绝策略:
 *      等待队列已经满了,再也塞不下新任务了,同时线程池中的max线程也达到了,无法继续为新任务服务
 *
 *
 *  生产上用哪一个?
 *     不使用Executors去创建,手写线程池ThreadPoolExecutor
 *
 *  如何合理配置线程池数量?
 *      cpu密集型:CPU核数+1个线程的线程池
 *      IO密集型:
 *          1.CPU核数*2
 *          2.cpu核数/1 - 阻塞系数  系数在0.8-0.9
 *              比如8核CPU : 8/1 - 0.9 = 80个线程数
 *
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService threadpool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            //模拟10个用户来办理业务,每个用户就是一个来自外部的请求线程
            for (int i = 1; i <=10 ; i++) {
                threadpool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadpool.shutdown();
        }



    }

    private static void threadPoolInit() {
        //        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadpool = Executors.newFixedThreadPool(5);//一池5个处理线程
//        ExecutorService threadpool = Executors.newSingleThreadExecutor();//一池1个处理线程
//        ExecutorService threadpool = Executors.newCachedThreadPool();//一池N个处理线程


        try {
            //模拟10个用户来办理业务,每个用户就是一个来自外部的请求线程
            for (int i = 1; i <=10 ; i++) {
                threadpool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadpool.shutdown();
        }
    }

}
