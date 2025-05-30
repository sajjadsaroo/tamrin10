package datastructures.lists;

import datastructures.interfaces.LinkedList;

public class CustomLinkedList<T> implements LinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    private int indexOf(Object o) {
        int idx = 0;
        for (Node<T> curr = head; curr != null; curr = curr.next, idx++) {
            if (curr.data.equals(o)) {
                return idx;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        for (Node<T> curr = head; curr != null; curr = curr.next) {
            if (curr.data.equals(o)) {
                unlink(curr);
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> node = node(index);
        return node.data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Node<T> node = node(index);
        T old = node.data;
        node.data = element;
        return old;
    }

    @Override
    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        T data = head.data;
        unlink(head);
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        T data = tail.data;
        unlink(tail);
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    private Node<T> node(int index) {
        Node<T> curr;
        if (index < (size / 2)) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void unlink(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null) { // node is head
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) { // node is tail
            tail = prev;
        } else {
            next.prev = prev;
        }
        size--;
    }
}
