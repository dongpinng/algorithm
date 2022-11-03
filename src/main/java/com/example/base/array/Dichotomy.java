package com.example.base.array;

import com.example.base.utils.ArrayUtils;

import static com.example.base.utils.ArrayUtils.*;

/**
 * 二分法
 */
public class Dichotomy {
    static int index = -1;

    /**
     * 逆序对 归并
     *
     * [3,5,4,1,2]
     * [3,1][3,2][5,4][5,1][5,2][4,1][4,2]
     */
    public static void reverseOrderPairs() {
        int[] a = getRandomArray();
        reverseOrderPairs(a);
        log(a);
    }

    private static void reverseOrderPairs(int[] a) {
        if(a == null || a.length < 2){
            return;
        }
        System.out.println(doReverseOrderPairs(a, 0, a.length - 1));
    }

    private static int doReverseOrderPairs(int[] a, int L, int R) {
        if (L < R) {
            int mid = L + ((R-L) >> 1);
            return doReverseOrderPairs(a, L,mid)+
            doReverseOrderPairs(a, mid+1, R)+
            printPairs(a, L, mid, R);
        }
        return 0;
    }

    private static int printPairs(int[] a, int l, int mid, int r) {
        int curPair = 0;
        int[] tmp = new int[r-l+1];
        int k = 0;
        int left = l;
        int right = mid+1;
        while(left <= mid && right <= r){
            if(a[left] > a[right]){
                curPair += (mid-left + 1);
                tmp[k++] = a[right++];
            }else{
                tmp[k++] = a[left++];
            }
        }
        while(left <= mid){
            tmp[k++] = a[left++];
        }
        while(right <= r){
            tmp[k++] = a[right++];
        }
        for(int i = 0;i<k;i++){
            a[l+i] = tmp[i];
        }
        return curPair;
    }

    /**
     * 小和问题 归并
     * [4,3,5,1,2]
     * 比5小的 4+3 = 7
     * 比2小的 1
     * 7+1 = 8
     */
    public static void sumSmall() {
        int[] a = getRandomArray();
        sumSmall(a);
    }

    private static void sumSmall(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        System.out.println("小和结果: "+ doSumSmall(a, 0, a.length - 1));
        log(a);
    }

    private static int doSumSmall(int[] a, int L, int R) {
        if (L < R) {
            int mid = L + ((R - L) >> 1);
            return doSumSmall(a, L, mid)
                    + doSumSmall(a, mid+1, R)
                    + sum(a, L, mid, R);
        }else{
            return 0;
        }

    }

    private static int sum(int[] a, int l, int mid, int r) {
        int currentSum = 0;
        int[] tmp = new int[r-l+1];
        int k = 0;
        int left = l;
        int right = mid + 1;
        while(left <= mid && right<= r){
            if (a[left] < a[right]) {
                currentSum += a[left] * (r - right + 1); // 因为加入了排序，所以这里可以直接计算有多少个比left大的数
                tmp[k++] = a[left++];
            }else{
                tmp[k++] = a[right++];
            }
        }
        while(left <= mid){
            tmp[k++] = a[left++];
        }
        while(right <= r){
            tmp[k++] = a[right++];
        }
        for(int i = 0;i<k;i++){
            a[l+i] = tmp[i];
        }
        System.out.println(currentSum);
        return currentSum;
    }

    /**
     * 无序数组，相邻数不相等,求一个局部最小的位置
     */
    public static void findPartMinX() {
        int[] a = getRandomArray();
        findPartMinX(a);
    }

    private static void findPartMinX(int[] a) {
        if (a == null) {
            return;
        }
        doFindPartMinX(a,0,a.length-1);
    }

    private static void doFindPartMinX(int[] a, int L, int R) {
        if (L <= R) {
            int mid = L + ((R-L)>>1);
            if(mid == 0){
                if(a[mid+1] > a[mid]){
                    System.out.println(a[mid] + "位置局部小");
                }
                return;
            }
            if(mid == a.length-1){
                if(a[mid-1] > a[mid]){
                    System.out.println(a[mid] + "位置局部小");
                }
                return;
            }
            if(a[mid-1] > a[mid] && a[mid+1] > a[mid]){
                System.out.println(a[mid] + "位置局部小");
            }else if(a[mid-1] < a[mid]){
                doFindPartMinX(a,L,mid);
            }else {
                doFindPartMinX(a,mid+1,R);
            }
        }
    }

    /**
     * 有序数组中，找到大于等于某个数的最左侧位置
     */
    public static void findRLeftX() {
        int[] a = new int[]{2,3,3,3,6,6,9,9};
        findRLeftX(a,7);
        System.out.println(index);
    }

    private static void findRLeftX(int[] a, int k) {
        if(a == null){
            System.out.println("unFind");
            return;
        }
        doFindRLeftX(a,0,a.length-1,k);
    }

    private static void doFindRLeftX(int[] a, int L, int R, int k) {
        if(L < R){
            int mid = L + ((R-L)>>1);
            if (a[mid] == k) {
                index = mid;
                doFindRLeftX(a,L,mid,k);
            }else if (a[mid] > k){
                doFindRLeftX(a,L,mid,k);
            }else{
                doFindRLeftX(a,mid+1,R,k);
            }
        }else{
            if(index == -1){
                index = L;
            }
        }
    }

    /**
     * 有序数组查找某个数是否存在
     */
    private static void findX() {
        int[] a = new int[]{2,4,5,10,15,19};
        findX(a,3);
    }

    private static void findX(int[] a,int k) {
        if(a == null){
            System.out.println("null");
            return;
        }
        doFindX(a,0,a.length-1,k);
    }

    private static void doFindX(int[] a, int L, int R,int k) {
        if(L < R){
            int mid = L + ((R-L)>>1);
            if (a[mid] == k) {
                System.out.println("findK" + k);
            }else if(a[mid] > k){
                doFindX(a,L,mid,k);
            }else{
                doFindX(a,mid+1,R,k);
            }
        }else {
            System.out.println("unFind");
        }
    }
}
