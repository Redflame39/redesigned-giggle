package com.company;

public class Iterator {
    private Node current;
    private final RingList ourList;

    public Iterator(RingList list) {
        ourList = list;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
    }

    public boolean atEnd() {
        return (current == ourList.last);
    }

    public void nextNode() {
        current = current.next;
    }

    public Node getCurrent() {
        return current;
    }

    public void deleteCurrent()
    {
        Node preCurrent = ourList.first;
        while(!preCurrent.next.equals(current)) {
            preCurrent = preCurrent.next;
        }
        preCurrent.next = preCurrent.next.next;
    }
}
