package org.sekai._02_data_structure._02a_singlelinkedlist;

import java.util.Iterator;

public class DoubleLinkedList <T> implements Iterable<T>{

    private T data;

    private int size;

    private Node<T> head;

    private Node<T> tail;


    public class Node<T> {
        private T data;

        private Node<T> next;

        private Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public void add(T data) {
        insertLast(data);
    }

    public void insertFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node<>(data, null, null);
            size++;
            return;
        }

        head.prev = new Node<>(data, head, null);
        head = head.prev;
        size++;
    }

    public void insertLast(T data) {
        if (isEmpty()) {
            head = tail = new Node<>(data, null, null);
            size++;
            return;
        }

        tail.next = new Node<>(data, null, tail);
        tail.next.prev = tail;
        tail = tail.next;
        size++;
    }


    public void insertBefore(T key, T data) {
        if (head.data == key) {
            head.prev = new Node<>(data, head, null);
            head = head.prev;
            size++;
            return;
        }

        Node<T> trav = head;
        while (trav != null) {
            if (trav.data == key) {
                break;
            }

            trav = trav.next;
        }

        trav.prev.next = new Node<>(data, trav, trav.prev);
        trav.prev = trav.prev.next;
        size++;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }
}
