package com.atguigu.GOF23.Proxy;

/**
 * Created by zld on 2019/10/20 0020.
 */
//代理对象,静态代理
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;//目标对象,通过接口来聚合

    //构造器
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理开始....");
        target.teach();
        System.out.println("代理结束....");
    }
}
