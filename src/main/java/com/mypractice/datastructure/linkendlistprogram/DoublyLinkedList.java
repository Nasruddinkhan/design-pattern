package com.mypractice.datastructure.linkendlistprogram;


public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data) {

        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    private String outOfBoundMsg(int index) {
        return "Index:" + index + ", Size:" + size;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {

            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void indexAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }


        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> nextNode = current.next;
        newNode.prev = current;
        newNode.next = nextNode;
        current.next = newNode;
        nextNode.prev = newNode;
        size++;

    }
    public void print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;

        }
    }
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Add elements at end
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.print("After add(): ");
        list.print();

        // Add element at beginning
        list.addFirst(5);
        System.out.print("After addFirst(5): ");
        list.print();

        // Add element at last
        list.addLast(40);
        System.out.print("After addLast(40): ");
        list.print();

        // Insert at specific index
        list.indexAt(2, 15);
        System.out.print("After indexAt(2, 15): ");
        list.print();

        list.indexAt(0, 1);
        System.out.print("After indexAt(0, 1): ");
        list.print();

        list.indexAt(list.size, 50);
        System.out.print("After indexAt(size, 50): ");
        list.print();
    }
}
