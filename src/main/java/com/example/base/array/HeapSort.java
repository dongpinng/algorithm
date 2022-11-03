package com.example.base.array;

import com.example.base.utils.ArrayUtils;

import java.util.PriorityQueue;

/**
 * 堆排序，先构造成大根堆，然后将顶部节点和最后一个交换，重新构建大根堆
 */
public class HeapSort {

    /**
     * 1
     * /  \
     * 3    2
     */
    public static void heapSort() {
        int[] a = ArrayUtils.getRandomArray();
        heapSort(a);
        ArrayUtils.log(a);
    }

    private static void heapSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }
        int heapSize = a.length;
        ArrayUtils.swap(a, 0, --heapSize);
        while (heapSize > 0) {
            for (int i = 0; i < heapSize; i++) {
                heapify(a, i, heapSize);
            }
            ArrayUtils.swap(a, 0, --heapSize);
        }
    }

    private static void heapify(int[] a, int i, int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && a[left + 1] > a[left] ? left + 1 : left;//左子和右子比较
            largest = a[largest] > a[i] ? largest : i;//子和父比较
            if (largest == i) {
                // 不用往下已经是最大的了
                break;
            }
            ArrayUtils.swap(a, largest, i);
            i = largest;
            left = 2 * largest + 1;
        }
    }

    /**
     * 近似k位置有序的数组排序
     */
    public static void similarKSort(){
        int[] a = new int[]{4,3,1,7,2,6,5};
        int k = 3;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0; //取数放入堆中
        for(; index <= Math.min(k,a.length-1);index++){
            heap.add(a[index]);
        }
        int i = 0;
        for(; index < a.length;index++,i++){
            a[i] = heap.poll();
            heap.add(a[index]);
        }
        while(!heap.isEmpty()){
            a[i++] = heap.poll();
        }
        ArrayUtils.log(a);
    }
}
