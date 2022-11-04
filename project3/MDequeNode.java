package project3;

public class MDequeNode<E> {
    private E data;
    private MDequeNode<E> next;
    private MDequeNode<E> prev;

    public MDequeNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public MDequeNode(E data, MDequeNode<E> prev, MDequeNode<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public MDequeNode<E> getNext() {
        return next;
    }

    public MDequeNode<E> getPrev() {
        return prev;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(MDequeNode<E> next) {
        this.next = next;
    }

    public void setPrev(MDequeNode<E> prev) {
        this.prev = prev;
    }

    public String toString() {
        return data.toString();
    }
}
