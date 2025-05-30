package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;


public class CustomStack<T> implements Queue<T> {

    private CustomLinkedList<T> list;

    public CustomStack() {
        this.list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(T t) {
        list.addFirst(t);
        return true;
    }

    @Override
    public boolean offer(T t) {
        return add(t);
    }

    @Override
    public T remove() {
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public T element() {
        return list.getFirst();
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
