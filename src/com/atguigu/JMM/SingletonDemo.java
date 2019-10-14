package com.atguigu.JMM;

/**
 * Created by zld on 2019/10/8 0008.
 * 多线程下单例模式 双端检锁机制 不一定线程安全,原因是有指令重排的存在 ,加入volatile可以禁止指令重排
 *
 *
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法");
    }
    //DCL模式 双端检锁机制 加锁前和加锁后都进行null判断
    public static  SingletonDemo getInstance(){
        if(instance==null){

            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return  instance;
    }
    public static void main(String[] args) {



        //多线程之后  情况发生了变化
        for (int i = 1; i <=10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();


        }



    }

}
