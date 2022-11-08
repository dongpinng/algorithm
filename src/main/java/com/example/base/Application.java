package com.example.base;

import com.example.base.node.CommonPart;
import com.example.base.node.Intersect;
import com.example.base.node.Palindrome;
import com.example.base.tree.BinaryTree;

public class Application {
    public static void main(String[] args) {
        /*.....*/
        BinaryTree.binaryTree();
    }
    /**
     *       时间           空间      稳定性
     * 选择  O(N2)         O(1)        ×
     * 冒泡  O(N2)         O(1)        √
     * 插入  O(N2)         O(1)        √
     * 归并  O(nlogn)      O(N)        √
     * 快排  O(nlogn)      O(logn)     x
     * 堆排  O(nlogn)      O(1)        x
     */
}
