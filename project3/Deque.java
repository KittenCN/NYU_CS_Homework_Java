package project3;

public interface Deque<E> {
    public void pushBack(E item);
    public void pushFront(E item);
    public void pushMiddle(E item);
    public E peekMiddle();
    public E peekFront();
    public E peekBack();
    public E popFront();
    public E popBack();
    public E popMiddle();
    public int size();
    public java.util.Iterator<E> iterator();
    public java.util.Iterator<E> reverseIterator();
    public java.lang.String toString();
}
