package com.example.base.node;

import com.example.base.pojo.NodeList;

/**
 * 两个可能有环链表是否相交
 */
public class Intersect {
    public static void intersect(){
        NodeList n1 = new NodeList(1);
        NodeList n2 = new NodeList(2);
        NodeList n3 = new NodeList(3);
        NodeList n4 = new NodeList(4);
        NodeList n5 = new NodeList(5);
        NodeList n6 = new NodeList(6);
        NodeList n7 = new NodeList(7);
        NodeList n8 = new NodeList(8);
        NodeList n9 = new NodeList(9);
        NodeList n10 = new NodeList(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        intersect(n1,n7);
    }

    private static void intersect(NodeList list1, NodeList list2) {
        // 判断链表是否有环，返回环的值
        NodeList i1 = getRingInsertion(list1);
        NodeList i2 = getRingInsertion(list2);
        // s1 => 其中一个链表有环 => 无法相交
        // s2 => 都无环 => 如果相交，终点是一样的。找到最近相交的点
        if (i1 == null && i2 == null) {
            notAllRingList(list1, list2);
        }
        // s3 => 都有环 => 如果相交，终点一致，要么在环前，要么在环上
        if (i1 != null && i2 != null){
            if(i1 == i2){
                bothRingList(list1,list2,i1,i2);
            }else{
                NodeList n = i1;
                while(i1 != i2 && i1 != n){
                    i1 = i1.next;
                }
                if (i1 != n) {
                    System.out.println("有环链表相交于" + i1.getValue() + "点");
                }else{
                    System.out.println("有环链表无交点");
                }
            }
        }
    }

    private static void bothRingList(NodeList l1, NodeList l2, NodeList i1, NodeList i2) {
        NodeList n1 = l1;
        NodeList n2 = l2;
        int n = 0;
        while(n1 != null && n1 !=i1){
            n++;
            n1 = n1.next;
        }
        while(n2 != null && n2 != i2){
            n--;
            n2 = n2.next;
        }
        n1 = n > 0 ? l1 : l2;//长链表
        n2 = n > 0 ? l2 : l1;//短链表
        n = Math.abs(n);
        // 保持链表长度一致，遇到的第一个节点就是相交的点
        while(n-- > 0) {
            n1 = n1.next;
        }
        while(n1 != n2){
            if(n1 == null || n2 == null){
                break;
            }else{
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        if(n1 == null || n2 == null){
            System.out.println("有环链表无交点");
        }else{
            System.out.println("有环链表相交于" + n1.getValue()+"点");
        }
    }

    private static void notAllRingList(NodeList l1, NodeList l2) {
        NodeList n1 = l1;
        NodeList n2 = l2;
        int n = 0;
        while(n1 != null){
            n++;
            n1 = n1.next;
        }
        while(n2 != null){
            n--;
            n2 = n2.next;
        }
        n1 = n > 0 ? l1 : l2;
        n2 = n > 0 ? l2 : l1;
        n = Math.abs(n);
        while(n-- > 0) {
            n1 = n1.next;
        }
        while(n1 != n2){
            if( n1 == null || n2 == null){
                break;
            }else{
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        if(n1 == null || n2 == null){
            System.out.println("无环链表无相交点");
        }else{
            System.out.println("无环链表相交于" + n1.getValue()+"点");
        }
    }

    private static NodeList getRingInsertion(NodeList list) {
        NodeList ringNode = null;
        NodeList fast = list;
        NodeList slow = list;
        if (list == null || list.next == null) {
            return ringNode;
        }
        fast = fast.next.next;
        slow = slow.next;
        // 快慢指针，如果fast == slow 那么将slow节点重置到初始节点，并都按照1步数前进，直到fast==slow
        while (fast != slow) {
            if(fast == null || fast.next == null){
                break;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        if(fast == slow){
            slow = list;
            while(slow != fast){
                fast = fast.next;
                slow = slow.next;
            }
            ringNode = fast;
        }
        return ringNode;
    }
}
