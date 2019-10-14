package com.atguigu.juc;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zld on 2019/10/10 0010.
 *
 *在多线程中,所谓阻塞,在莫些情况下挂起线程(阻塞),一旦条件满足,被挂起的线程会自动被唤醒
 *
 *
 *
 * 阻塞队列:当队列是空的时候,获取操作会被阻塞,满的时候,添加操作会被阻塞
 * 1.阻塞队列有没有好的一面
 *
 * 2.不得不阻塞,如何管理
 *
 *
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{
        //List list = null;

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);



        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));



        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

    }

}
