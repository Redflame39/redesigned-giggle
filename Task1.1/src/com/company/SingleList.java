package com.company;

public class SingleList {

    private int size;
    public int seniorDegree;

    public Node first;
    public Node last;

    public SingleList() {
        size = 0;
        seniorDegree = 0;
        first = null;
        last = null;
    }

    public void add(int a, int n) {
        if (a == 0) return;

        Node newNode = new Node(a, n);
        if (isEmpty())
            first = newNode;
        else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        if(n > seniorDegree) seniorDegree = n;
    }

    public void add(int a, int n, int pos) {
        Node current = first;

        pos--;
        for (int i = 0; i < pos; i++) {
            current = current.next;
            if (current.next == null) return;
        }
        Node newNode = new Node(a, n);
        if (current == last)
        {
            newNode.next = null;
            last = newNode;
        } else
        {
            newNode.next = current.next;
        }
        current.next = newNode;
        size++;
        if(n > seniorDegree) seniorDegree = n;
    }

    public CoefWrap get(int pos) {
        Node current = first;
        for (int i = 0; i < pos; i++) {
            if (current.next == null) return null;
            else current = current.next;
        }
        return current.item;
    }

    public Node getLast() {
        return last;
    }

    public void deleteIndex(int pos) {
        Node current = first;
        for (int i = 0; i < pos-1; i++) {
            if (current.next == null) return;
            else current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public int getA(int num) {
        Node current = first;
        while (current.item.n != num) {
            if (current.next == null) return 0;
            else current = current.next;
        }
        return current.item.a;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private class Node {
        CoefWrap item;
        Node next;

        Node(int a, int n) {
            this.item = new CoefWrap(a, n);
        }
    }

}
