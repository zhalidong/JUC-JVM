package com.atguigu.GOF23.Proxy;

/**
 * Created by zld on 2019/10/20 0020.
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中....");
    }
}
