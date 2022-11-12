package ru.geekbrains;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E>  implements MyList<E>, Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                Node n = getNode(currentIndex++);
                return n.get();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    private class Node {
        private E element;
        Node next;
        Node prev;
        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E get(){
            return element;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int p) {
        check((p));
        Node node = head;
        for (int i = 0; i < p; i++)
            node = node.next;
        return node.element;
    }

    @Override
    public void insert(int index, E element) {
        check(index);
        if(index == 0){
            Node tmp = new Node(element, head, null);
            if(head != null ) {
                head.prev = tmp;
            }
            head = tmp;
            if(tail == null) {
                tail = tmp;
            }
        }
        else if(index == size-1)
            add(element);
        else{
            Node t = getNode(index);
            Node tmp = new Node(element, t, t.prev);
            t.prev = tmp;
            t.prev.next = tmp;
        }
        size++;
    }

    @Override
    public void add(E element) {
        Node tmp = new Node(element, null, tail);
        if(tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if(head == null) {
            head = tmp;
        }
        size++;
    }

    private Node getNode(int index) {
        check((index));
        Node node = head;
        for (int i = 1; i <= index; i++)
            node = node.next;
        return node;
    }

    public void deleteFirst() {
        delete(0);
    }

    public void deleteLast() {
        delete(size);
    }

    @Override
    public void delete(int p) {
        check(p);
        Node element = getNode(p);
        element.prev.next = element.next;
        size--;
    }

    public void check(int index) {
        if(index < 0 || index > size-1){
            try {
                throw new IndexOutOfBoundsException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
