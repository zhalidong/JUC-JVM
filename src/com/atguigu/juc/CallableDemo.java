package com.atguigu.juc;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * Created by zld on 2019/9/26 0026.
 */
class Mythread implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("*****come in call method()");
        return 1024;
    }
}

/**
 * java多线程中,第三种获得多线程的方式
 * Callable带返回值,futureTask.get() 建议放在最后 多个线程抢占一个futureTask,只有一次;
 *
 *
 */

public class CallableDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        //两个线程一个是main  一个是A


        FutureTask<Integer> futureTask = new FutureTask(new Mythread());

        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();

//        while (!futureTask.isDone()){
//
//        }

        Integer result = futureTask.get();  //要求获得callable线程的计算结果,如果没有计算完成就要去强求,会导致阻塞,直到计算完成
        System.out.println(result);
    }
}