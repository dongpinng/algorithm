package com.example.base.array;

import static com.example.base.utils.ArrayUtils.*;

public class QuickSort {
    public static void quickSort(int[] a) {
        if (a == null || a.length < 2) {
            return ;
        }
        doQuickSort(a, 0, a.length-1);
        log(a);
    }

    private static void doQuickSort(int[] a, int L, int R) {
        if (L < R) {
            swap(a,R,L + (int)(Math.random() * (R-L+1)));
            int[] p = partition(a,L,R);
            doQuickSort(a, L,p[0]);
            doQuickSort(a, p[1] + 1, R);
        }
    }

    private static int[] partition(int[] a, int l, int r) {
        int less = l-1;
        int more = r;
        while(l < more){
            if(a[l] < a[r]){
                swap(a,++less,l++);
            }else if(a[l] > a[r]){
                swap(a,--more,l);
            }else{
                l++;
            }
        }
        swap(a,r,more);
        return new int[]{less,more};
    }
}
