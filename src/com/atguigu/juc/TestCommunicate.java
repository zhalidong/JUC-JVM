package com.atguigu.juc;

/**
 * Created by zld on 2019/9/26 0026.
 *
 * 线程通信:
 *      什么情况需要用到线程通信?
 *     当遇到生产者和消费者问题时,需要用到线程通信,线程通信就是用wait和notify方法
 *     当一个(些)线程负责往缓冲区,添加数据,而另一个(些)线程负责从缓冲区取数据
 *     例如:把厨师当一个线程,服务员当一个线程,
 *
 *     当缓冲区满了的时候,生产者线程应该停下来(wait) 等消费者取走了,就可以重新唤醒/通知(notify) 生产者继续生产,
 *     反过来,当缓冲区空的时候,消费者线程应该停下来(wait),等生产者重新生产,就可以重新唤醒/通知(notify) 消费者继续取数据
 *
 *
 *
 *
 */
public class TestCommunicate {
    public static void main(String[] args) {





    }
}

//工作台
class WorkBENCH{
    private static final int MAX_VALUE=10;
    private  int num;

    public void take(){
        num--;
        System.out.println("取走了一份菜"+num);
    }

    public  void put(){

        num++;
        System.out.println("厨师有抄了一份菜"+num);
    }
}