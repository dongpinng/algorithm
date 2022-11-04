package com.example.base.node;

import com.example.base.pojo.NodeList;

import java.util.Stack;

/**
 * 回文链表
 */
public class Palindrome {
    public static void palindrome(){
        NodeList n1 = new NodeList(1);
        NodeList n2 = new NodeList(22);
        NodeList n3 = new NodeList(111);
        NodeList n4 = new NodeList(22);
        NodeList n5 = new NodeList(1);
        n1.next = n2;
        n2.next = n4;
        n3.next = n4;
        n4.next = n5;
        palindrome(n1);
    }

    private static void palindrome(NodeList n) {
        boolean flag = true;
        NodeList fast = n;
        NodeList slow = n;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<Integer> stack = new Stack<>();
        while(slow != null){
            stack.push(slow.getValue());
            slow = slow.next;
        }
        NodeList head = n;
        while(!stack.isEmpty()){
            if (head.getValue() != stack.pop()) {
                flag = false;
                break;
            }
            head = head.next;
        }
        System.out.println(flag);
    }
}
