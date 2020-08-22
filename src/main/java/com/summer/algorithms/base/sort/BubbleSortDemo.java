package com.summer.algorithms.base.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 冒泡排序
 *
 * @author adminstor
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        bubbleSort(a, a.length);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void bubbleSort(int[] a, int n) {
        if (n <= 1){
            return;
        }
        for(int i=0; i<n; i++){
            //提前退出冒泡循环的标志
            boolean flag = false;
            for(int j=0; j<n-i-1; j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            //没有数据交换， 提前退出
            if(!flag){
                break;
            }
        }
    }
}
