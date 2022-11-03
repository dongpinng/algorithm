package com.example.base.array;

/**
 * 异或运算
 */
public class XOR {

    /**
     * 找到一组数组中出现奇数次的2个数
     */
    public static void findTwiceOddNum() {
        int[] a = new int[]{1,1,1,3,3,2,2,6,6,6};
        findTwiceOddNum(a);
    }

    private static void findTwiceOddNum(int[] a) {
        if(a == null){
            System.out.println("null");
            return;
        }
        int n = 0;
        for(int i = 0;i < a.length;i++){
            n ^= a[i];
        }
        int rightOne = n & (~n + 1);
        int other = 0;
        for(int i = 0;i < a.length;i++){
            if ((rightOne & a[i]) != 0) {
                other ^= a[i];
            }
        }
        System.out.println("两个奇数次的数分别是" + other + "," + (other^n));
    }

    /**
     * 找到一组数组中出现奇数次的一个数
     */
    public static void findOnceOddNum() {
        int[] a = new int[]{1,1,1,2,2,3,3,4,4};
        findOnceOddNum(a);
    }

    private static void findOnceOddNum(int[] a) {
        if(a == null){
            System.out.println("null");
            return;
        }
        int n = 0;
        for(int i = 0; i< a.length ; i++){
            n ^= a[i];
        }
        System.out.println("出现奇数次的数是" + n);
    }
}
