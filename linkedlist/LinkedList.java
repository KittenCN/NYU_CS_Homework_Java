import java.util.NoSuchElementException;

/*
A generic linked list class. 
Does not allow null elements to be stored. 
*/

public class LinkedList<E> {
    //define internal Node class 
    private class Node {
        public E data; 
        public Node next; 

        public Node (E data) {
            this.data = data;
            this.next = null; 
        }

    }

    
    private Node head;
    private Node tail; 
    private int size;


    /*
    * Creates an empty list object.  
    */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /* Adds an element 'it' at position pos, shifts elements starting at pos by
    * one position to the right (higher position values). 
    * @param it the element to be added to this list 
    * @param pos the position at which the element should be added 
    * @return true, if the list has been modified as a result of this 
    * operation, false, otherwise (in this case the function should always return true)
    * @throws NullPointerException if it == null 
    * @throws NoSuchElementException if pos < 0 or pos > size
    */
    public boolean add (E it, int pos) throws NullPointerException, NoSuchElementException {
        Node n = new Node(it);
        if (pos < 0 || pos > size) {
            throw new NoSuchElementException("Invalid position");
        }
        if (it == null ){
            throw new NullPointerException("it should not be null"); 
        }
         
        //check where I'm adding 
        if (pos == 0 ) {
            n.next = head; 
            head = n;
            size++;
            return true; 
        }
        else if (pos == size) { //add to the end 
            tail.next = n;
            tail = tail.next;
            size++;
            return true; 
        }
        //adding everywhere else :
        else{
            Node prev = head; 
            for (int i = 0; i < pos-1; i++) {
                prev = prev.next; 
            }
            n.next = prev.next; 
            prev.next = n; 
            size++;
            return true; 
        }
    }


    /* Removes and returns an element at position pos, shifts elements starting
    *  at pos+1 by one to the left (lower position values)
    *  @param pos position from which the element should be removed 
    *  @return the element that was removed 
    *  @throws NoSuchElementException if pos < 0 or pos >= size
    */ 
    public E remove(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= size ) {
            throw new NoSuchElementException("invalid position");
        }
        //check where I'm removing
        if (pos == 0 ) {
            E temp = head.data;
            head = head.next;
            size--;
            return temp; 
        }
        else if (pos == size - 1) { //remove from the end 
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            E temp = prev.next.data;
            prev.next = null;
            tail = prev;
            size--;
            return temp; 
        }
        //removing everywhere else :
        else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            E temp = prev.next.data;
            prev.next = prev.next.next;
            size--;
            return temp;
        }
    }
    

    /* Determines if `it` is in the list and if so returns its position 
    *  (using zero-based indexing), otherwise returns -1. 
    *  @param it the value to be located in the list 
    *  @return index/position of `it` in the list, or -1 is `it` is not 
    *  in the list 
    */
    public int find (E it) {
        Node curr = head;
        int pos = 0;
        while (curr != null) {
            if (curr.data.equals(it)) {
                return pos;
            }
            curr = curr.next;
            pos++;
        }

        return -1;
    }


    /*
    * Produces string representation of this list. 
    * The string contains all elemetns stored in the list, one per line.
    * @return returns the string representation of this list 
    */
    public String toString () {
        if (head == null ) return ""; 
        String toReturn = ""; 
        Node current = head; 
        while (current != null ) {
            toReturn += current.data + " "; 
            current = current.next;
        }
        return toReturn; 
    }


}