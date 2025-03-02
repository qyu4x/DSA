package org.sekai._02_data_structure._02a_linkedlist;

import java.util.Iterator;

public class SingleLinkedList <T> implements Iterable<T>{

    private int size;

    private Node<T> head;

    private Node<T> tail;

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            trav.next = null;
            trav.data = null;
            trav = trav.next;
        }

        this.head = this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T data) {
        addLast(data);
    }

    public void addFirst(T data) {
        if (size() == 0) {
            head = tail = new Node<>(data, null);
        } else {
            head = new Node<>(data, head);
        }
        size++;
    }

    public void addLast(T data) {
        if (size() == 0) {
            head = tail = new Node<>(data, null);
        } else {
            tail.next = new Node<>(data, null);
            tail = tail.next;
        }
        size++;
    }

    public void insertAfter(T key, T data) {
        if (isEmpty()) {
            throw new RuntimeException("Linked list is empty");
        }

        Node<T> trav = head;
        while (trav != null) {
            if (trav.data == key) {
                break;
            }
            trav = trav.next;
        }

        Node<T> temp = trav.next;
        trav.next = new Node<>(data, temp);
        if (temp == null) {
            tail = trav.next;
        }
        size++;
    }

    public void insertBefore(T key, T data) {
        if (isEmpty()) {
            throw new RuntimeException("Linked list is empty");
        }

        if (head.data == key) {
            head = new Node<>(data, head);
            return;
        }

        Node<T> trav = head;
        boolean isFoundKey = false;
        while (trav.next != null) {
            if (trav.next.data == key) {
                isFoundKey = true;
                break;
            }
            trav = trav.next;
        }

        if (isFoundKey) {
            trav.next = new Node<>(data, trav.next);
        }
    }

    public void insertAt(int index, T data) {
        if (index < 0 || index > size - 1) {
           throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            addLast(data);
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }


        Node<T> trv = head;
        for (int i = 0; i < index - 1; i++) {
             trv = trv.next;
        }

        trv.next = new Node<>(data, trv.next);
        size++;
    }


    public boolean removeFirst() {
        Node<T> temp = head.next;
        head.data = null;
        head.next = null;
        head = temp;
        return true;

    }

    public boolean removeAt(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            return false;
        }

        if (index == 0) {
            removeFirst();
            return true;
        }

        Node<T> trv = head;
        for (int i = 0; i < index - 1; i++) {
            trv = trv.next;
        }

        Node<T> temp = trv.next.next;
        Node<T> removedNode = trv.next;
        removedNode.next = null;
        removedNode.data = null;
        trv.next = temp;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> trv = head;

            @Override
            public boolean hasNext() {
                return trv != null;
            }

            @Override
            public T next() {
                T data = trv.data;
                trv = trv.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


}
