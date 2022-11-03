package com.example.base.array;

import static com.example.base.utils.ArrayUtils.*;

/**
 * 插入排序 就是再i-(N-1)范围内确定最小的值，然后插入到i位置
 */
public class InsertSort {

    public static void insertSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, minIndex, i);
        }
        log(a);
    }
}
