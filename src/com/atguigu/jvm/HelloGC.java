package com.atguigu.jvm;

/**
 * Created by zld on 2019/10/13 0013.
 *
 * JVM参数类型
        标配参数
        X参数
        XX参数
            boolean类型:jinfo -flag PrintGCDetails 4748 -XX:+PrintGCDetails
            KV设置类型-XX:Metaspacesize=128M
 *      -Xms等价于-XX:InitalHeapSize
 *      -Xmx等价于-XX:MaxHeapSize
 *
 *第一种查看参数
 *如何查看一个正在运行中的java程序  它的莫个JVM参数是否开启?具体值是多少?
 * jps
 *
 * jinfo -FLAG 具体参数 java进程编号
 *
 * 第二种查看参数盘点家底
 * java -XX:+PrintFlagsInitial:主要查看初始默认值
 * java -XX:+PrintFlagsFinal:查看修改更新
 * java -XX:+PrintCommandLineFlags:查看GC垃圾回收器
 */
public class HelloGC {
    public static void main(String[] args) throws Exception{

        System.out.println("******HelloGC");

        Thread.sleep(Integer.MAX_VALUE);

    }
}
