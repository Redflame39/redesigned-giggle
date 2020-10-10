package com.company;

public class Node {
    PhoneWrap item;
    Node next;

    Node(int num, String name) {
        this.item = new PhoneWrap(num, name);
    }
}