package com.atguigu.JMM;

/**
 * Created by zld on 2019/10/6 0006.
 */
class MyNumber{
    volatile  int number = 0;
    public void addto1205(){
        this.number=1205;
    }
}

/**
 * JMM = 可见性
 */

public class T2 {

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"******come in");
            //暂停一会线程
            myNumber.addto1205();
            System.out.println(Thread.currentThread().getName()+"\t update number ,number value"+myNumber.number);
        },"aaa").start();

        while (myNumber.number==10){
            //需要一种通知机制告诉main线程,number已经修改为1205 跳出while
        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over");



    }
}
