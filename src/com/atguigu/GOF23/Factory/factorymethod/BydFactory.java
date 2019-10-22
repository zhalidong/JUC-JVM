package com.atguigu.GOF23.Factory.factorymethod;

/**
 * Created by zld on 2019/10/19 0019.
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
