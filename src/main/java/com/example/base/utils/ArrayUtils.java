package com.example.base.utils;

public class ArrayUtils {
    public static int[] getRandomArray() {
        int[] a = new int[15];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.abs((int) (Math.random() * 30
                    + Math.random() * 5 - Math.random() * 15));
        }
        log(a);
        return a;
    }

    public static void log(int[] a) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int item : a) {
            sb.append(item).append(",");
        }
        String s = sb.substring(0, sb.length() - 1);
        System.out.println(s + "]");
    }

    public static void swap(int[] a, int x, int y) {
        if (x != y) {
            a[x] = a[x] ^ a[y];
            a[y] = a[x] ^ a[y];
            a[x] = a[x] ^ a[y];
        }
    }
}
