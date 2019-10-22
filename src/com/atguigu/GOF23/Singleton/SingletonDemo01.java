package com.atguigu.GOF23.Singleton;

/**
 * Created by zld on 2019/10/19 0019.
 * 懒汉式单例(延迟加载)
 * 延迟加载,使用的时候才加载
 *
 * 资源利用率高了,但是,每次调用getInstance()方法都要同步,并发效率较低
 *
 */
public class SingletonDemo01 {
    //类初始化时,不初始化这个对象(用的时候再创建)
    private static SingletonDemo01 s;
    private SingletonDemo01(){}//私有化构造器

    public static synchronized SingletonDemo01 getInstance(){
        if(s==null){
            s = new SingletonDemo01();
        }
        return s;
    }
    public static void main(String[] args) {

    }
}
