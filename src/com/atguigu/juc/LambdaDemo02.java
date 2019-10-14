package com.atguigu.juc;

/**
 * Created by zld on 2019/9/26 0026.
 *
 * 1.函数式编程
 *
 *  1.拷贝中括号,写死右箭头 落地大括号
 *  2.@FunctionalInterface
 *  3.   default修饰的方法可以定义实现在接口中
 *  4.static修饰方法可以定义实现在接口中
 *
 */
@FunctionalInterface
interface Foo{
//    public  void sayHello();
    public  int add(int x,int y);


    default  int mul(int x,int y){
        return x*y;
    }

    public static int diy(int x,int y){
        return x/y;
    }

}



public class LambdaDemo02 {

    public static void main(String[] args) {

        /*Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("******");
            }

            @Override
            public int add(int x, int y) {
                return 0;
            }
        };

        foo.sayHello();*/


        Foo foo = (int x,int y) -> {
            System.out.println("***********");
            return x+y;
        };

        System.out.println(foo.add(3, 5));
        System.out.println(foo.mul(3, 5));

        System.out.println(Foo.diy(4, 2));

    }

}
