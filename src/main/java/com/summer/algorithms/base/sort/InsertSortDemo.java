package com.summer.algorithms.base.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author adminstor
 */
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        insertSort(a, a.length);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void insertSort(int[] a, int n){
        if(n<=1){
            return;
        }
        for(int i=1; i<n; i++){
            int value = a[i];
            // 查找插入位置
            int j=i-1;
            for(; j>=0; --j){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            // 插入数据
            a[j+1] = value;
        }
    }
}
