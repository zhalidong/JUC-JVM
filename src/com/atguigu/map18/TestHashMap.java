package com.atguigu.map18;

/**
 * Created by zld on 2019/9/25 0025.
 *
 * JDK1.8的Hashmap:底层实现:数组+链表/红黑树
 *
 * 1.为什么要从链表修改为链表或红黑树
 *  当莫个链表比较长的时候,查找效率还是比较低
 *  为了提高效率,那么把table[index]下面的链表做调整
 *  如果table[index]的链表的节点个数比较少,8个或以内 就保持链表,如果超过8个,就考虑把链表转变为一课红黑树
 *  TREEIFY_THRESHOLD:从链表转为红黑树的临界值
 *
 *
 *
 *  2.什么时候树化
 *  table[index]下的节点数一打到8就树化吗
 *  如果table[index]节点的数量已经达到8个了,还要判断table.length是否达到64,如果没有达到64,先扩容
 *
 *
 *  MIN_TREEIFY_CAPACITY:最小树化容量64
 *
 *  3.什么时候树-->链表
 *  当你删除节点时,这课树的节点个数少于6个,会变成链表
 *  UNTREEIFY_THRESHOLD:6个
 *
 *  树的结构复杂,当节点少了之后,用链表更好
 *
 *  4.put的过程
 *  1.[index]的计算问题
 *      第一步用key的hashcode值调用hash()函数,干扰hash值,使得(key,value)更均匀的分布table数组中
 *      JDK1.8中hash()算法更优化
 *      第二步:hash值与table.length-1做&运算,保证index在[0-length-1]范围内
 *  2.扩容问题
 *      第一种:当莫个table[index]的链表的个数达到8个,并且table.length<64,那么会扩容
 *      第二种:size>=threshold,并且table[index]!=null
 *          threshold = table.length * loadFactor (它的默认值default_load_factor:0.75)
 *  3.当把(key,value)添加到链表中,JDK1.8是在链表的尾部
 */
public class TestHashMap {
}
