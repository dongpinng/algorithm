package com.example.base.node;

import com.example.base.pojo.NodeList;
import com.example.base.utils.NodeUtils;

public class CommonPart {

    public static void commonPart(){
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
        NodeList n11 = new NodeList(3);
        NodeList n21 = new NodeList(5);
        NodeList n31 = new NodeList(6);
        NodeList n41 = new NodeList(7);
        n11.next = n21;
        n21.next = n31;
        n31.next = n41;
        NodeUtils.log(n11);

        commonPart(n1,n11);
    }

    private static void commonPart(NodeList l1, NodeList l2) {
        NodeList n1 = l1;
        NodeList n2 = l2;
        StringBuffer sb = new StringBuffer();
        while(n1 != null && n2 != null){
            if(n1.getValue() > n2.getValue()){
                n2 = n2.next;
            }else if(n1.getValue() < n2.getValue()){
                n1 = n1.next;
            }else{
                sb.append(n1.getValue() + ",");
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
