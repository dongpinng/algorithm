package com.example.base.array;

import static com.example.base.utils.ArrayUtils.*;

/**
 * 利用二分法排序
 */
public class MergeSort {

    public static void mergeSort(int[] a) {
        if(a == null || a.length < 2){
            return;
        }
        doMergeSort(a,0,a.length-1);
        log(a);
    }

    private static void doMergeSort(int[] a, int L, int R) {
        if (L < R) {
            int mid = L + ((R-L)>>1);
            doMergeSort(a,L,mid);
            doMergeSort(a,mid+1,R);
            merge(a,L,mid,R);
        }
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int[] tmp = new int[r-l+1];
        int k = 0;
        int left = l;
        int right = mid + 1;
        while (left <=mid && right <= r) {
            tmp[k++] = a[left] <= a[right]?a[left++]:a[right++];
        }
        while (left <= mid){
            tmp[k++] = a[left++];
        }
        while (right <= r){
            tmp[k++] = a[right++];
        }
        for (int i = 0;i < k;i++){
            a[l + i] = tmp[i];
        }
    }

}
