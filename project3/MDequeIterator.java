package project3;

public class MDequeIterator<T> implements java.util.Iterator<T> {
    private MDequeNode<T> current;
    private boolean forward;

    public MDequeIterator(MDequeNode<T> front, MDequeNode<T> end, boolean forward) {
        if(forward){
            current = front;
        }
        else{
            current = end;
        }
        this.forward = forward;
        
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        T data = current.getData();
        if (forward) {
            current = current.getNext();
        } else {
            current = current.getPrev();
        }
        return data;
    }

}
