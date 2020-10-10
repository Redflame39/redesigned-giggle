package com.company;

//пользовательский итератор
public class DoubleIterator<E> {
    private Node<E> current; //ссылка на текущий элемент, на который указывает итератор
    private Node<E> previous; //ссылка на предыдущий элемент относительно того, на который указывает итератор
    private final LinkedList<E> ourList; //связанный список

    //конструктор
    public DoubleIterator(LinkedList<E> list)
    {
        ourList = list;
        reset();
    }

    //вернуть итератор в начало
    public void reset()
    {
        current = ourList.getFirst();
        previous = null;
    }

    //true, если следующий объект - null
    public boolean atEnd() {
        return (current.next == null);
    }

    //к следующему звену списка
    public void nextNode() {
        previous = current;
        current = current.next;
    }

    //получить текущий элемент
    public Node<E> getCurrent()
    {
        return current;
    }

    //вставить элемент данных E после текущего
    public void insertAfter(E item, PhoneType type)
    {
        Node<E> newLink = new Node<E>(item, type);
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

    //вставить элемент данных перед текущим
    public void insertBefore(E item, PhoneType type)
    {
        Node<E> newLink = new Node<E>(item, type);
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
        }
    }

    //удалить текущий элемент
    public E deleteCurrent()
    {
        E value = current.item;
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
