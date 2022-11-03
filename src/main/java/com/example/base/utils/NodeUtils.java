package com.example.base.utils;

import com.example.base.pojo.NodeList;

public class NodeUtils {
   public static void log(NodeList nodeList){
       NodeList n = nodeList;
       StringBuilder sb = new StringBuilder();
       while(n != null){
           sb.append(n.getValue());
           if(n.next != null){
               sb.append(" -> ");
           }
           n = n.next;
       }
       System.out.println(sb);
   }
}
