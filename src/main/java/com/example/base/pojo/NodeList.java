package com.example.base.pojo;

public class NodeList {
    public NodeList next;
    public NodeList prev;
    private int value;

    public NodeList(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
