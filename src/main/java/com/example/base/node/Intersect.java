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
        n6.next = n4;

        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n4;

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
                bothRingList(list1,list2);
            }else{

            }
        }
    }
}
