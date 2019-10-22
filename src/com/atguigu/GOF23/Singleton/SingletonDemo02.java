package com.atguigu.GOF23.Singleton;

/**
 * 单例模式:
 保证一个类只有一个实例,并且提供一个访问该实例的全局访问点,内存占用系统开销小

 常见应用场景:
 项目中,读取配置文件的类,一般也只有一个对象,没有必要每次使用配置文件,每次new一个对象去读取
 网站计数器
 数据库连的设计
 在spring中,每个bean默认都是单例的

 饿汉式:
 线程安全,调用效率高,但是不能延迟加载
 懒汉式
 线程安全,调用效率不高,可以延迟加载
 *
 * Created by zld on 2019/10/19 0019.
 * 饿汉式单例对象(立即加载)没有延迟
 *  饿汉式单例模式代码,static变量会在类装载时初始化,此时不会涉及多个线程对象访问该对象的问题,不会产生并发访问的问题
 *
 */
public class SingletonDemo02 {
    private  static SingletonDemo02 s= new SingletonDemo02();//类初始化时,立即加载这个对象 由于类加载的时候是天然的线程安全
    private  SingletonDemo02(){}//私有化构造函数

    //方法没有同步,调用效率高
    public static SingletonDemo02 getInstance(){
        return  s;
    }

    public static void main(String[] args) {
        SingletonDemo02 s1 = SingletonDemo02.getInstance();
        SingletonDemo02 s2 = SingletonDemo02.getInstance();
        System.out.println(s1==s2);//结果为true
    }
}
