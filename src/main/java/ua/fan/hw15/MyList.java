package ua.fan.hw15;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.OptionalInt;

public class MyList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    private int index;

    public int getIndex() {
        return index;
    }

    public void add(E value) {
        MyNode<E> oldTail = tail;
        MyNode<E> newNode = new MyNode<>(value, null, oldTail);
        tail = newNode;
        if (oldTail == null) {
            head = newNode;
        } else {
            oldTail.next = newNode;
        }
    }

    public Optional<E> getFromLast(E value) {
        index = 0;
        for (MyNode<E> i = tail; i != null; i = i.getPrev()) {
            if (i.getValue().equals(value)){
                return Optional.ofNullable(i.getValue());
            } else if (!i.getValue().equals(value) && i!=head){
                index++;
            }
        }
        index = 0;
        return Optional.empty();
    }

    @Override
    public String toString() {
        StringBuilder printList = new StringBuilder();
        for (MyNode<E> i = head; i != null; i = i.getNext()) {
            if (i != tail) {
                printList.append(i.getValue()).append(", ");
            } else {
                printList.append(i.getValue()).append(".");
            }
        }
        return printList.toString();
    }

    @Getter
    @Setter
    private static class MyNode<E> {
        private E value;
        private MyNode<E> next;
        private MyNode<E> prev;

        public MyNode(E value, MyNode<E> next, MyNode<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
