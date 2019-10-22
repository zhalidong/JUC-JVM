package com.atguigu.GOF23.Factory.simplefactory;

/**
 * Created by zld on 2019/10/19 0019.
 * 测试在没有工厂模式的情况下,
 *
 *
 */
public class Client01 {



    public static void main(String[] args) {

        Car c1 = new Audi();
        Car c2 = new Byd();

        c1.run();
        c2.run();
    }



}
