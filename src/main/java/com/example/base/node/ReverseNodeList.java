package com.example.base.node;

import com.example.base.pojo.NodeList;
import com.example.base.utils.NodeUtils;

public class ReverseNodeList {
    public static void reverseNodeList(){
        NodeList n1 = new NodeList(1);
        NodeList n2 = new NodeList(2);
        NodeList n3 = new NodeList(3);
        NodeList n4 = new NodeList(4);
        NodeList n5 = new NodeList(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        NodeUtils.log(n1);
        reverseNodeList(n1);
    }

    private static void reverseNodeList(NodeList node) {
        NodeList n = node;
        NodeList head = null;
        while(n != null){
            NodeList tmp = n.next;
            n.next = head;
            head = n;
            n = tmp;
        }
        NodeUtils.log(head);
    }
}
