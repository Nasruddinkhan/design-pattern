package com.mypractice.datastructure.linkendlistprogram;

public class SingleLinkedList<T> {

    private Node<T> head;
    private int size;
    static class Node<T>{
        T data;
        Node<T> next;

        Node( T data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
        }else{
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<>(data);

        if (head == null){
            head = newNode;
        }else {
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
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
    }

    public T get(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        Node<T> current = head;
        for (int i = 0; i < index ; i++) {
            current = current.next;
        }
        return current.data;
    }
    public void addAtIndex(int index, T data){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0){
            newNode.next = head;
            head = newNode;
        }else{
            Node<T> current = head;
            for (int i = 0; i<index-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    private String outOfBoundMsg(int index){
        return "Index:"+ index + ",Size:"+size;
    }
    public static void main(String[] args) {
        SingleLinkedList<String>  singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add("Nasruddin");
        singleLinkedList.add("Sufiya");
        singleLinkedList.add("Sufiya");
        singleLinkedList.addFirst("Khan");
        singleLinkedList.addLast("Sufi Khan");
        singleLinkedList.addAtIndex(3, "Jalaluddin khan");
       // singleLinkedList.printList();
        System.out.println(singleLinkedList.get(0));
    }
}
