package com.example.base.array;

import static com.example.base.utils.ArrayUtils.*;

/**
 * 选择排序，就是保证在0-N-1之间有序
 */
public class SelectSort {
    public static void selectSort(int[] a) {
        if(a == null || a.length < 2){
            return;
        }
        for(int i = 1;i< a.length;i++){
            for(int j = i; j > 0 && a[j] < a[j-1];j--){
                swap(a,j,j-1);
            }
        }
        log(a);
    }
}
