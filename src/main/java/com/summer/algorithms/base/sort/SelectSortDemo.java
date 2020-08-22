package com.summer.algorithms.base.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author adminstor
 */
public class SelectSortDemo {
    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        selectSort(a, a.length);
        Arrays.stream(a).forEach(System.out::println);
    }

    private static void selectSort(int[] a, int n){
        if(n<=1){
            return;
        }
        for(int i=0; i<n; i++){
            // 最小值索引
            int minIndex = i;
            for(int j=i; j<n; j++){
                if(a[minIndex] > a[j]){
                    minIndex = j;
                }
            }
            // 交换数据
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}
