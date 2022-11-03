package com.example.base.array;

import static com.example.base.utils.ArrayUtils.*;

/**
 * 冒泡排序 就是每次遍历最大值一直冒泡到最后
 */
public class BubbleSort {

    public static void bubbleSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(a[j] > a[j+1]){
                    swap(a,j+1,j);
                }
            }
        }
        log(a);
    }
}
