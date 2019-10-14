package com.atguigu.jvm;

import java.util.Random;

/**
 * Created by zld on 2019/9/28 0028.
 * 查看机器配置  运行时数据区抽象为Runtime
 *
 * 配置堆内存参数
 *
 * 日志
 * [GC (Allocation Failure) [PSYoungGen: 2048K->504K(2560K)] 2048K->736K(9728K), 0.0924140 secs] [Times: user=0.03 sys=0.00, real=0.14 secs]


    GC的作用域是方法区和堆
 *
 */
public class T2 {

    public static void main(String[] args) {

        /*long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
        System.out.println("-Xmx:MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("-Xms:TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");*/


        String str = "www.tguigu.com";
        while(true){
            str+=str+new Random().nextInt(88888888)+new Random().nextInt(999999999);
        }




    }

}
