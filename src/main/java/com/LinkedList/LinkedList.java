package com.LinkedList;

public class LinkedList {

    public static class Node {
        int value;
        Node prox;

        public Node(int value) {
            this.value = value;
            this.prox = null;
        }

    }

    private Node head;
    private int size;

    public void add(int value) {
        Node newCell = new Node(value);
        if (head == null) {
            head = newCell;
        } else {
            Node temp = head;
            while (temp.prox != null) {
                temp = temp.prox;
            }
            temp.prox = newCell;
        }
        size++;
    }

}
