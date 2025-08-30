package com.mypractice.datastructure.linkendlistprogram;

public class SingleLinkedListWithTail<T> {
    Node<T> head;
    int size = 0;
    Node<T> tail;
    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add( T data){
        Node<T> addNode = new Node<>(data);
        if (head == null){
            head = addNode;
        }else{
            tail.next = addNode;
        }
        tail = addNode;
        size++;
    }

    public void printAll(){
        Node<T> current = head;
        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void printRecursive(){
        printHelper(head);
        System.out.println();
    }

    private void printHelper(Node<T> head) {
        if (head==null) return;
        System.out.print(head.data+" -> ");
        printHelper(head.next);
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    private String outOfBoundMsg(int index){
        return "Index:"+ index + ",Size:"+size;
    }
    public T get(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        if (index==0){
            return head.data;
        }
        if (index == size ) {
            return tail.data;
        }

        Node<T> current = head;
        for (int i = 0; i <index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void addAtIndex(int index, T data){

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }

        System.out.println("Size "+ size + " Index "+ index);
       Node<T> newNode = new Node<>(data);
        if (index == 0){
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        }else if (index == size) {
            if (tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T removeByIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        Node<T> current = head;
        // Removing first element
        if (index == 0) {
            T data = current.data;
            head = current.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return data;
        }

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> nodeToRemove =  current.next;
        current.next = nodeToRemove.next;
        if (index == size - 1) {
            tail = current;
        }
        size--;
        return nodeToRemove.data;
    }

    public void removeAll() {
        if (head == null) {
            throw new RuntimeException("No element found");
        }
        head = null;
        tail = null;
        size = 0;
    }
    public T removeLast(){
        if (head == null){
            throw new RuntimeException("No element found");
        }
        if (head == tail) {
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        Node<T> removeTail = tail;
        removeTail.next = null;
        tail = current;
        tail.next = null;
        size--;
        return removeTail.data;
    }
    public static void main(String[] args) {
        SingleLinkedListWithTail<String> list = new SingleLinkedListWithTail<>();
        list.add("A"); // head = tail = A
        list.add("B"); // A -> B, tail = B
        list.add("C"); // A -> B -> C, tail = C
        list.printAll();
        list.printRecursive();
        list.addFirst("F");
        list.printAll();
        list.addLast("D");
        list.printAll();
        list.addAtIndex(1, "G");
        list.addAtIndex(4, "K");
        list.addAtIndex(0, "M");
        list.addAtIndex(8, "P");
        list.printAll();
        list.removeAll();
      //  System.out.println(list.removeLast());
        System.out.println("After remove all");
        list.printAll();
    }
}
