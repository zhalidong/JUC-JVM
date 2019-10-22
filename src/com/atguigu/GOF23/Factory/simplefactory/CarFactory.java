package com.atguigu.GOF23.Factory.simplefactory;

/**
 * Created by zld on 2019/10/19 0019.
 *
 *
 * 简单工厂类
 * 简单工厂模式也叫静态工厂模式
 * 就是工厂类一般是使用静态方法， 通过接收的参数的不同来返回不同的对象实例。
 * – 对于增加新产品无能为力！不修改代码的话，是无法扩展的。
 */
public class CarFactory {

    public static Car createCar(String type){
        if("奥迪".equals(type)){
            return new Audi();
        }else if("比亚迪".equals(type)){
            return new Byd();
        }else{
            return  null;
        }
    }

}
