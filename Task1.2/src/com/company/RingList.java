package com.company;

public class RingList {

    private int size;

    public Node first;
    public Node last;

    public RingList() {
        first = null;
        last = null;
    }

    public void add(int num) {
        Node newNode = new Node(num);
        if (isEmpty())
            first = newNode;
        else {
            last.next = newNode;
        }
        last = newNode;
        newNode.next = first;
        size++;
    }

    public void add(int num, int pos) {
        Node current = first;

        pos--;
        for (int i = 0; i < pos; i++) {
            current = current.next;
            if (current.next == null) return;
        }
        Node newNode = new Node(num);
        if (current == last) {
            newNode.next = first;
            last = newNode;
        } else {
            newNode.next = current.next;
        }
        current.next = newNode;
        size++;
    }

    public int get(int pos) {
        Node current = first;
        for (int i = 0; i < pos; i++) {
            if (current.next == null) return 0;
            else current = current.next;
        }
        return current.num;
    }

    public int getLast() {
        return last.num;
    }

    public void deleteIndex(int pos) {
        Node current = first;
        for (int i = 0; i < pos - 1; i++) {
            if (current.next == null) return;
            else current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void deleteKey(int key) {
        Node current = first;
        while (true) {
            if (current.next.num == key) {
                current.next = current.next.next;
                size--;
                return;
            }
        }
    }

    public Node getFirst() {
        return first;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void decSize() {
        size--;
    }

}
