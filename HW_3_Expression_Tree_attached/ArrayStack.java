package HW_3_Expression_Tree_attached;

public class ArrayStack<E> implements Stack<E> {
    public static final int capacity = 1000;
    private E[] _data;
    private int t = -1;
    public ArrayStack() { this(capacity); }

    @SuppressWarnings({"unchecked"})
    public ArrayStack(int _capacity) { 
        _data = (E[]) new Object[_capacity]; 
    }

    @Override
    public int size() { 
        return (t + 1); 
    }

    @Override
    public boolean isEmpty() { 
        if (t == -1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == _data.length) {
            throw new IllegalStateException("Stack is full");
        }
        ++t;
        _data[t] = e;
    }

    @Override
    public E top() {
        if (isEmpty()){
            return null;
        }
        return _data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null; 
        } 
        E answer = _data[t];
        _data[t] = null; 
        t--;
        return answer;
    }
}