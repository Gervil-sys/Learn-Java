package org.example.lab4.lab4_1;

public class MinStackImpl implements MinStack<Integer> {

    private static class Node {
        private final int value;
        private final int min;
        private Node next;

        public Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    @Override
    public void push(Integer value) {
        int currentMin = (head == null) ? value : Math.min(value, head.min);
        head = new Node(value, currentMin, head);
        size++;
    }

    @Override
    public Integer pop() {
        if (head == null) return null;

        int removed = head.value;
        head = head.next;
        size--;
        return removed;
    }

    @Override
    public Integer top() {
        if (head == null) return null;
        return head.value;
    }

    @Override
    public Integer min() {
        if (head == null) return null;
        return head.min;
    }
}
