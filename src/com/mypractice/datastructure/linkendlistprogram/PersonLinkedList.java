package com.mypractice.datastructure.linkendlistprogram;

public class PersonLinkedList<T> {

    private Node<T> head;
    private int size;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data);
        size++;
    }

    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    private String outOfBoundMsg(int index) {
        return "Index:" + index + ", Size:" + size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No Element Found");
        }
        return head.data;
    }

    private T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("No Element Found");
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    private T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    private T removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(0));
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    private T removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(0));
        }
        if (size == 1) {
            return removeFirst();
        }
        Node<T> current = head;
        for (int i = 0; i < size - 2; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    private T removeIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        if (index == 0) {
            return removeFirst();
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    private void reverse() {
        if (isEmpty()) {
            return;
        }
        Node<T> prev = null;
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current = next;
        }
        head = null;
        size = 0;
    }

    // ✅ MAIN METHOD USING PERSON OBJECT
    public static void main(String[] args) {

        PersonLinkedList<Person> list = new PersonLinkedList<>();

        list.add(new Person(1, "Nasruddin Khan"));
        list.add(new Person(2, "Sufiya Khan"));
        list.addFirst(new Person(3, "SFK"));
        list.addLast(new Person(4, "First Nasruddin"));

        list.printList();

        list.reverse();
        list.printList();

        list.removeIndex(1);
        list.printList();

        list.clear();
        list.printList();
    }
}
