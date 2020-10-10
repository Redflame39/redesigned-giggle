package com.company;

public class SinglePhoneList {

    private int size;

    public Node first;
    public Node last;

    public SinglePhoneList() {
        size = 0;
        first = null;
        last = null;
    }

    public void add(int num, String name) {
        Node newNode = new Node(num, name);
        if (isEmpty())
            first = newNode;
        else {
            last.next = newNode;
        }
        last = newNode;
        size++;

    }

    public void add(int num, String name, int pos) {
        Node current = first;

        pos--;
        for (int i = 0; i < pos; i++) {
            current = current.next;
            if (current.next == null) return;
        }
        Node newNode = new Node(num, name);
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
    }

    public void insertFirst(int num, String name)
    {
        Node newNode = new Node(num, name);
        if (isEmpty())
            last = newNode;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void insertLast(int num, String name)
    {
        Node newNode = new Node(num, name);
        if (isEmpty())
            first = newNode;
        else
            last.next = newNode;
        last = newNode;
        size++;
    }

    public PhoneWrap get(int pos) {
        Node current = first;
        for (int i = 0; i < pos; i++) {
            if (current.next == null) return null;
            else current = current.next;
        }
        return current.item;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public void deleteIndex(int pos) {
        Node current = first;
        for (int i = 0; i < pos - 1; i++) {
            if (current.next == null) return;
            else current = current.next;
        }
        if (size == 1) {
            first= null;
            return;
        }
        current.next = current.next.next;
        size--;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void incSize() {
        size++;
    }
}
