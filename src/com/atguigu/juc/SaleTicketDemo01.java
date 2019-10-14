package com.atguigu.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zld on 2019/9/26 0026.
 *
 * 题目:三个售票员             卖出              30张票
 * 笔记:如何编写企业级多线程代码
 *      固定的编程套路+模板是什么
 *
 *  1 在高内聚 低耦合的前提下,线程           操作          资源类
 *
 *      1.1一言不合,先创建一个资源类
 *
 */

class  Ticket{//资源类 = 实例变量 + 实例方法
    private  int number =30;

//    List list = new ArrayList();

    Lock lock = new ReentrantLock();//可重入锁

    public  void sale(){

    lock.lock();

    try {
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"\t卖出第:"+(number--)+"\t 还剩下"+number);
        }
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        lock.unlock();
    }



    }

}


public class SaleTicketDemo01
{

    public static void main(String[] args) {    //主线程  一切程序入口
        Ticket ticket = new Ticket();

        //函数式接口编程
        new Thread(()->{ for(int i=0;i<=40;i++) ticket.sale(); },"A").start();
        new Thread(()->{ for(int i=0;i<=40;i++) ticket.sale(); },"B").start();
        new Thread(()->{ for(int i=0;i<=40;i++) ticket.sale(); },"C").start();






//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, "A").start();




        /*Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();*/

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=40;i++){
                    ticket.sale();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=40;i++){
                    ticket.sale();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=40;i++){
                    ticket.sale();
                }
            }
        }, "C").start();*/







    }
}









