package com.atguigu.sort;

/**
 * Created by zld on 2019/9/28 0028.
 *
 * 使用冒泡实现数组元素
 *
 */
public class BubbleSortTest {

    public static void bubbleSort(int[] data){

        int arrayLength = data.length;

        for(int i=0;i<arrayLength-1;i++){
            boolean flag = false;
            for(int j=0;j<arrayLength-i-1;j++){
                if(data[j]>data[j+1]){
                    int temp = data[j+1];
                    data[j+1]=data[j];
                    data[j]=temp;
                    flag = true;
                }
            }

            if(!flag){
                break;
            }
        }
    }






    public static void main(String[] args) {

    }
}



