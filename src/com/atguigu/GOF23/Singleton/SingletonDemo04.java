package com.atguigu.GOF23.Singleton;

/**
 * Created by zld on 2019/10/19 0019.
 * 单例模式(静态内部类实现方式,也是一种懒加载方式)
 *  要点:
 *      -外部类没有static属性,则不会像饿汉式那样立即记载对象
 *      -只有真正调用getInstance(),才会加载静态内部类,
 *      加载类时线程安全,instance是static final类型,
 *      保证了内存中只有这样一个实例存在,而且只能被赋值一次,从而保证了线程安全性
 *
 *      -兼备了并发高效调用和延迟记载的优势
 *
 *
 */
public class SingletonDemo04 {
    //静态内部类 该类中有一个静态属性
    private static class SingletonClassInstance {
        private static final SingletonDemo04 instance = new SingletonDemo04();  //常量
    }
    //提供静态公有方法,直接返回
    public static SingletonDemo04 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonDemo04() { }
}



