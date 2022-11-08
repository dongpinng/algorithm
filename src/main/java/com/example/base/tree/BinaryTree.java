package com.example.base.tree;

import com.example.base.pojo.TreeNode;

import java.util.*;

/**
 * 二叉树递归序
 */
public class BinaryTree {

    private static int preValue = Integer.MIN_VALUE;
    /**
     *     1
     *   2   3
     * 4  5 6 7
     */
    public static void binaryTree() {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        binaryTreeRecursion(n1);
        //1 2 4 5 3 6 7
        preSequence(n1);
        System.out.println();
        //4 5 2 6 7 3 1
        post(n1);
        System.out.println();
        //4 2 5 1 6 3 7
        inOrder(n1);
        System.out.println();
        width(n1);
        System.out.println();
        maxWidth(n1);
        System.out.println();
        System.out.print("是否是搜索二叉树:" + isBST(n1));
        System.out.println();


    }
    //左树比头小，右树比头大
    private static boolean isBST(TreeNode n1) {
        if(n1 == null){
            return true;
        }
        boolean leftBst = isBST(n1.left);
        if(!leftBst){
            return false;
        }
        if(n1.getValue() <= preValue){
            return false;
        }else{
            preValue = n1.getValue();
        }
        return isBST(n1.right);
    }

    private static void maxWidth(TreeNode n1) {
        System.out.print("最大宽度:");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(n1);
        Map<TreeNode,Integer> levelMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int curLevel = 1;
        int curNodes = 0;
        levelMap.put(n1,1);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer nodeLevel = levelMap.get(node);
            if(nodeLevel == curLevel){
                curNodes++;
            }else{
                curLevel++;
                curNodes = 1;
            }
            if(node.left != null){
                levelMap.put(node.left,nodeLevel+1);
                queue.add(node.left);
            }
            if(node.right != null){
                levelMap.put(node.right,nodeLevel+1);
                queue.add(node.right);
            }
            max = Math.max(max,curNodes);
        }
        System.out.print(max);
    }

    // 队列实现
    private static void width(TreeNode n1) {
        System.out.print("宽度优先遍历:");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(n1);
        int max = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.getValue() + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    // 栈结构实现
    private static void inOrder(TreeNode n1) {
        System.out.print("中序遍历:");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || n1 != null) {
            if (n1 != null) {
                stack.push(n1);
                n1 = n1.left;
            }else{
                n1 = stack.pop();
                System.out.print(n1.getValue() + " ");
                n1 = n1.right;
            }
        }
    }

    // 栈结构实现
    private static void post(TreeNode n1) {
        System.out.print("后序遍历:");
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(n1);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            help.push(head);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!help.isEmpty()) {
            System.out.print(help.pop().getValue() + " ");
        }

    }

    // 栈结构实现
    private static void preSequence(TreeNode n1) {
        System.out.print("先序遍历:");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(n1);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            System.out.print(head.getValue() + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    private static void binaryTreeRecursion(TreeNode n1) {
        if (n1 == null) {
            return;
        }
        //前序/深度遍历(头-左-右)
        binaryTreeRecursion(n1.left);
        //中序遍历(左-头-右)
        binaryTreeRecursion(n1.right);
        //后序遍历(左-右-头)
    }
}
