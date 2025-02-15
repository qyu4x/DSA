package org.sekai._02_data_structure._01_dynamicarrays;


import java.util.Iterator;

class IntArray implements Iterable<Integer>{

    private int[] arr;
    private int length = 0;
    private int capacity = 0;


    private static final int DEFAULT_CAP = 1 << 4;

    public IntArray() {
        this.arr = new int[DEFAULT_CAP];
        this.capacity = this.arr.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public int get(int index) {
        return this.arr[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index > this.length - 1) throw new IndexOutOfBoundsException("Index out of bound");
        this.arr[index] = value;
    }

    public void add(int value) {
        if (this.length + 1 > this.capacity) {
            this.capacity = this.capacity * 2;
            int[] extendedArr = new int[this.capacity];

            for (int i = 0; i < this.length; i++) {
                extendedArr[i] = this.arr[i];
            }
            this.arr = extendedArr;
        }
        this.arr[this.length++] = value;
    }

    public void removeAt(int removeIndex) {
        if (removeIndex < 0 || removeIndex > this.length - 1) throw new IndexOutOfBoundsException("Index out of bound");
        if (removeIndex == this.length - 1) {
            this.arr[removeIndex] = 0;
        }

        for (int i = removeIndex; i < this.length - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        --this.length;
    }

    public boolean remove(int element) {
        for (int i = 0; i < this.length; i++) {
            if (this.arr[i] == element) {
                this.removeAt(i);
                return true;
            }
        }

        return false;
    }

    public void reverse() {
        for (int i = 0; i < this.length / 2; i++) {
            int temp = this.arr[i];
            this.arr[i] = this.arr[this.length - 1 - i];
            this.arr[this.length - 1 - i] = temp;
        }
    }

    public String toString() {
        if (this.length == 0) return "[]";

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < this.length; i++) {
            builder.append(this.arr[i]);
            if (i < this.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public Integer next() {
                return arr[index++];
            }
        };
    }
}

public class IntArrayTest {
    public static void main(String[] args) {

        IntArray array = new IntArray();
        for (int i = 0; i < 100; i++) {
            array.add(i + 1);
        }

        array.remove(1);
        array.remove(5);

        System.out.println(array.toString());

        for (int arr : array) {
            System.out.println(arr);
        }

        System.out.println(array.size());


        array.reverse();
        for (int arr : array) {
            System.out.println(arr);
        }

    }
}

