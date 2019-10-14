package com.atguigu.sort;

/**
 * Created by zld on 2019/9/28 0028.
 *
 * 二分查找算法 必须先有序
 *
 *
 */
public class twoSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 77, 89, 90 };

        int value = 90;
        int head = 0;                   //首索引
        int end =arr.length-1;          //尾索引
        boolean isflag = true;

        while (head<=end){

            int middle = (head+end)/2;
            if(arr[middle]==value){
                System.out.println("数据找到了,索引为:"+middle+":"+arr[middle]);
                isflag=false;
                break;
            }else if(arr[middle]>value){
                end= middle-1;
            }else {
                head = middle+1;
            }

        }
        if(isflag){
            System.out.println("数据不存在与数组中");
        }


    }





}