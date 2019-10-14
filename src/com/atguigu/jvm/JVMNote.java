package com.atguigu.jvm;

/**
 * Created by zld on 2019/9/27 0027.
 *
 * JVM:java虚拟机
 *
 *  1.类加载器:负责加载class文件
 *      java虚拟机自带的加载器
 *      1.启动类加载器（Bootstrap）                 rt.jar
 *      2.扩展类加载器（Extension）                 ext/*.jar
 *      3.应用程序类加载器（AppClassLoader）
 *
 *      用户自定义加载器
 *          用户可以定制类的加载方式
 *
 *      双亲委派
 *
 *  2.native
 *      native是一个关键字
 *
 *  3.pc寄存器
 *      记录了方法之间的调用和执行情况,类似排班表
 *      用来存储指向下一条指令地址
 *
 *  4.方法区 线程共享,存在GC
 *  1.存储类的结构信息 比如构造方法字节码内容
 *  最典型的就是永久代和元空间
 *
 *  5 stack
 *      栈管运行,堆管存储
 *
 *      栈也叫栈内存，主管Java程序的运行，是在线程创建时创建，
 *      它的生命期是跟随线程的生命期，线程结束栈内存也就释放，对于栈来说不存在垃圾回收问题，
 *
 *
 * 栈保存哪些东西
 *      8种基本类型的变量+对象的引用变量+实例方法都是在函数的栈内存中分配
 *
 *      java 方法 = 栈帧
 *
 *      栈帧中主要保存3 类数据：
 *          本地变量（Local Variables）:输入参数和输出参数以及方法内的变量；
 *          栈操作（Operand Stack）:记录出栈、入栈的操作；
 *          栈帧数据（Frame Data）:包括类文件、方法等等。
 *
 *      递归  造成栈溢出  Exception int thread "main" java.lang.stackOverflowerError
 *
 *
 *  6.堆 heap
 *  一个JVM实例只存在一个堆内存，堆内存的大小是可以调节的。
 *  类加载器读取了类文件后，需要把类、方法、常变量放到堆内存中，
 *  保存所有引用类型的真实信息，以方便执行器执行，堆内存分为三部分
 *  1.新生代
 *      伊甸元区
 *          满了会触发YGC = 轻GC 伊甸元区基本全部清空
 *      幸存者0区   from区
 *      幸存者1区   to区
 *      from区和to区,他们的位置和名分不是固定的,每次GC后会交换,谁空谁是to
 *
 *  2.老年代
 *      满了开启 FULL GC   FULL GC多次 ,发现养老区空间没办法腾出来 OOM堆内存溢出
 *  3.元空间/永久代
 *  存放rt.jar JDK携带的元数据
 *  元空间与永久代之间最大的区别在于：
        永久带使用的JVM的堆内存，但是java8以后的元空间并不在虚拟机中而是使用本机物理内存。
 *  7.heap --> 对象的生命周期 --> OOM  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 *  8.堆参数调优
 *      -Xms 初始分配大小默认是物理内存的1/64
 *      -Xmx 最大分配内存 默认是物理内存的1/4
 *      输出GC日志
 *   名称:GC前内存占用   GC后内存占用   该内存总大小
 *
 *  [GC (Allocation Failure)
 *
 *  [PSYoungGen: 2048K->504K(2560K)]            2048K->736K(9728K), 0.0924140 secs]
 *  GC类型       GC前内存 GC后内存 新生代总大小      GC前堆内存
 *  [Times: user=0.03 sys=0.00, real=0.14 secs]
 *
 *  9.GC---> 作用区域 方法区 堆
 *  分代收集算法
 *
 *  GC4大算法
 *      1.引用计数法 有对象引用+1 没对象引用-1 到0就回收
 *      2.复制算法  复制之后交换,空的就是TO区(复制->清空->互换)  年轻代使用
 *      3.标记清除  先标记要回收的对象,后清除这个对象            老年代使用
 *      4.标记压缩  先标记,再扫描                            老年代使用
 *      老年代使用标记清除或者是标记清除和标记整理结合
 *
 *  System.gc();手动唤醒GC
 *
 *  垃圾:内存中已经不再要使用的空间
 *
 *  GC ROOTS就是一组活跃的引用,从GC对象开始作为起点,进行链路的扫描和访问,如果可达,活跃的,不可达就回收
 *
 *  GC ROOTS对象:虚拟机栈中的对象,方法区中静态对象 方法区常量引用对象 本地方法栈中引用的对象(nativd方法)
 *
 *
 */
public class JVMNote {
    //m
    public int add(int x,int y){

        int result = -1;
        result=x+y;
        return result;

    }

    public static void m1(){

        m1();   //递归  造成栈溢出
    }

    //Exception int thread "main" java.lang.stackOverflowerError
    public static void main(String[] args) {
       //object引用类型在栈中   new 的实例对象在堆中
        /*MyObject object = new MyObject();
        System.out.println("111111");
        m1();
        System.out.println("3333333");*/

        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
        System.out.println("-Xmx:MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("-Xms:TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");



    }

}
