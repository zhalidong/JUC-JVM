package com.atguigu.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zld on 2019/10/10 0010.
 *
 *  volatile/cas/atomicInteger/线程交互/原子引用
 *
 *
 *
 */
class MyResource{
    private volatile boolean flag = true;    //默认开启生产,进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (flag){
            data = atomicInteger.incrementAndGet()+"";
            retValue=blockingQueue.offer(data,2l, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 老板叫停,表示flag=false");
    }



}


public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {

    }
}
