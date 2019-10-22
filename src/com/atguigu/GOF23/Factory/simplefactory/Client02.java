package com.atguigu.GOF23.Factory.simplefactory;

/**
 * 工厂模式：
 核心本质：
 – 实例化对象，用工厂方法代替new操作。
 – 将选择实现类、创建对象统一管理和控制。从而将调用者跟我们的实 现类解耦。
 – 实现了创建者和调用者的分离。
 – 详细分类：
 简单工厂模式 用来生产同一等级结构中的任意产品。（对于增加新的产品，需要修改已 有代码）
 工厂方法模式 用来生产同一等级结构中的固定产品。（支持增加任意产品）
 抽象工厂模式 用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持 增加产品族）
 *
 *
 * Created by zld on 2019/10/19 0019.
 * 简单工厂情况下
 *
 *
 */
public class Client02 {

    public static void main(String[] args) {

        Car c1 = CarFactory.createCar("奥迪");
        Car c2 = CarFactory.createCar("比亚迪");

        c1.run();
        c2.run();
    }



}
