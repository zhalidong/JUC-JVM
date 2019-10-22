package com.atguigu.GOF23.Singleton;

/**
 * Created by zld on 2019/10/19 0019.
 * 单例模式双重检锁
 *      这个模式将同步内容下方到if内部,
 *      提高了执行效率,
 *      不必每次获取对象时都进行同步,
 *      只有第一次才同步创建了以后就没必要了
 *
 *
 */
public class SingletonDemo03 {

    private static volatile SingletonDemo03 instance = null;

    public static SingletonDemo03 getInstance() {
        if (instance == null) {
            SingletonDemo03 sc;
            synchronized (SingletonDemo03.class) {
                sc = instance;
                if (sc == null) {
                    synchronized (SingletonDemo03.class) {
                        if(sc == null) {
                            sc = new SingletonDemo03();
                        }}
                        instance = sc;
                }
            }
        }
                return instance;
    }
}
