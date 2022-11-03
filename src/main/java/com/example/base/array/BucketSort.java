package com.example.base.array;

import com.example.base.utils.ArrayUtils;

/**
 * 桶排序，不通过元素比较而是通过额外内存空间
 */
public class BucketSort {
    public static void bucketSort() {
        int[] a = ArrayUtils.getRandomArray();
        bucketSort(a);
        ArrayUtils.log(a);
    }

    private static void bucketSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int max = 1;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(getBit(a[i]), max);
        }
        int[] tmp = new int[a.length];//存放每次桶操作后的数组
        for (int i = 1; i <= max; i++) {
            int[] ten = new int[10];
            for(int j = 0; j < a.length; j++){
                int bitN = getNByBit(a[j],i);
                ten[bitN]++;
            }
            // 和前面的和相加
            for(int k = 1; k<ten.length; k++){
                ten[k] += ten[k-1];
            }
            //倒序归位
            for(int m = a.length-1; m >=0; m--){
                int bitN = getNByBit(a[m],i);
                tmp[--ten[bitN]] = a[m];
            }
            for(int n = 0;n<a.length;n++){
                a[n] = tmp[n];
            }
        }
    }

    private static int getNByBit(int n, int bit) {
        return n / (int)(Math.pow(10,bit-1)) %10;
    }

    private static int getBit(int n) {
        int bit = 1;
        while (n / 10 != 0) {
            n /= 10;
            bit++;
        }
        return bit;
    }
}
