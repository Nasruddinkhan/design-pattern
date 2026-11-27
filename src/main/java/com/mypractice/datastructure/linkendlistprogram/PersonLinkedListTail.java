package com.mypractice.datastructure.linkendlistprogram;

public class PersonLinkedListTail<T> {
     Node<T> head;
     Node<T> tail;

     int size;

    static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data){
       Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void print(){
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> current = head;
        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();

    }

    public void printHeadToTail() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> current = head;
        while (true) {
            System.out.print(current.data);

            if (current == tail) {
                break; // reached tail
            }

            System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        PersonLinkedListTail<Person> personList = new PersonLinkedListTail<>();
        personList.add(new Person(1, "Nasruddin Khan"));
        personList.add(new Person(2, "Jalaluddin Khan"));
        personList.print();
        personList.printHeadToTail();
    }
}
