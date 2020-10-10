package com.company;

class Iterator {
    private Node current;
    private Node previous;
    private SinglePhoneList ourList;


    public Iterator(SinglePhoneList list)
    {
        ourList = list;
        reset();
    }


    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }


    public boolean atEnd()
    {
        return (current.next == null);
    }


    public void nextNode() {
        previous = current;
        current = current.next;
    }


    public Node getCurrent()
    {
        return current;
    }


    public void insertAfter(int num, String name)
    {
        Node newLink = new Node(num, name);
        if (ourList.isEmpty())
        {
            ourList.setFirst(newLink);
            current = newLink;
        } else
        {
            newLink.next = current.next;
            current.next = newLink;
            nextNode();
        }
    }


    public void insertBefore(int num, String name)
    {
        Node newLink = new Node(num, name);
        if (previous == null)
        {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else
        {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
            ourList.incSize();
        }
    }


    public PhoneWrap deleteCurrent()
    {
        PhoneWrap value = current.item;
        if (previous == null)
        {
            ourList.setFirst(current.next);
            reset();
        } else
        {
            previous.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }
}
