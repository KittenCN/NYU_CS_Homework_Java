package project3;

import java.util.ArrayList;

public class MDeque<E> extends java.lang.Object implements java.lang.Iterable<E> {
    private MDequeNode<E> front, end;
    private int size;

    public MDeque() {
        front = null;
        end = null;
        size = 0;
    }

    public void pushBack(E item) {
        if(item == null){
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            front = new MDequeNode<E>(item);
            end = front;
        } else {
            MDequeNode<E> newNode = new MDequeNode<E>(item, end, null);
            end.setNext(newNode);
            end = newNode;
        }
        size++;
    }

    public void pushFront(E item) {
        if(item == null){
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            front = new MDequeNode<E>(item);
            end = front;
        } else {
            MDequeNode<E> newNode = new MDequeNode<E>(item, null, front);
            front.setPrev(newNode);
            front = newNode;
        }
        size++;
    }

    public void pushMiddle(E item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            front = new MDequeNode<E>(item);
            end = front;
        } else {
            MDequeNode<E> newNode = new MDequeNode<E>(item);
            MDequeNode<E> middle = front;
            for (int i = 0; i < (size + 1) / 2; i++) {
                middle = middle.getNext();
            }
            if ((size + 1) % 2 == 0) {
                newNode.setNext(middle);
                newNode.setPrev(middle.getPrev());
                middle.getPrev().setNext(newNode);
                middle.setPrev(newNode);
            } else {
                newNode.setNext(middle.getNext());
                newNode.setPrev(middle);
                middle.getNext().setPrev(newNode);
                middle.setNext(newNode);
            }
        }
        size++;
    }

    public E peekMiddle() {
        if (size == 0) {
            return null;
        } else {
            MDequeNode<E> middle = front;
            for (int i = 0; i < size / 2; i++) {
                middle = middle.getNext();
            }
            if (size % 2 == 0) {
                return middle.getPrev().getData();
            } else {
                return middle.getData();
            }
        }
    }

    public E peekFront() {
        if (size == 0) {
            return null;
        } else {
            return front.getData();
        }
    }

    public E peekBack() {
        if (size == 0) {
            return null;
        } else {
            return end.getData();
        }
    }

    public E popFront() {
        if (size == 0) {
            return null;
        } else {
            E data = front.getData();
            front = front.getNext();
            if (front != null) {
                front.setPrev(null);
            } else {
                end = null;
            }
            size--;
            return data;
        }
    }

    public E popBack() {
        if (size == 0) {
            return null;
        } else {
            E data = end.getData();
            end = end.getPrev();
            if (end != null) {
                end.setNext(null);
            } else {
                front = null;
            }
            size--;
            return data;
        }
    }

    public E popMiddle() {
        if (size == 0) {
            return null;
        } else {
            MDequeNode<E> middle = front;
            for (int i = 0; i < size / 2; i++) {
                middle = middle.getNext();
            }
            E data;
            if (size % 2 == 0) {
                data = middle.getPrev().getData();
                middle.getPrev().getPrev().setNext(middle);
                middle.setPrev(middle.getPrev().getPrev());
            } else {
                data = middle.getData();
                middle.getNext().setPrev(middle.getPrev());
                middle.getPrev().setNext(middle.getNext());
            }
            size--;
            return data;
        }
    }

    public int size() {
        return size;
    }

    public java.util.Iterator<E> iterator(){
        ArrayList<E> list = new ArrayList<E>();
        MDequeNode<E> current = front;
        while(current != null){
            list.add(current.getData());
            current = current.getNext();
        }
        return list.iterator();
    }

    public java.util.Iterator<E> reverseIterator(){
        ArrayList<E> list = new ArrayList<E>();
        MDequeNode<E> current = end;
        while(current != null){
            list.add(current.getData());
            current = current.getPrev();
        }
        return list.iterator();
    }

    public java.lang.String toString() {
        String s = "";
        MDequeNode<E> current = front;
        while (current != null) {
            s += current.getData() + " ";
            current = current.getNext();
        }
        return s;
    }
}
