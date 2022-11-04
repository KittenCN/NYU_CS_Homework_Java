import java.util.NoSuchElementException;

/*
A  linked list  of Integer objects.  
Does not allow null elements to be stored. 
*/

public class LinkedListC {

    //define internal Node class 
    private class Node { 
        public Integer data; 
        public Node next; 

        public Node (Integer data) {
            this.data = data;
            this.next = null; 
        }
    }

    
    private Node head;
    private Node tail; 

    /*
    * Creates an empty list object.  
    */
    public LinkedListC() {
        head = null;
        tail = null;
    }

    /* Adds an element 'it' to the end of this list. 
     * @param it the element to be added to this list 
     * @throws NullPointerException if it == null 
     */
    public void add (Integer it) throws NullPointerException {
        if (it == null ){
            throw new NullPointerException("it should not be null"); 
        }
        Node n = new Node(it); 
        //add the very first value 
        if ( head == null ) {
            head = n;
            tail = n; 

        }
        else { //add to the end 
            tail.next = n;
            tail = tail.next;
        }
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


    /* Adds the value toAdd after the first occurence of `after` 
     * in this list.   
     * For example, if the list is 
     *  head -> 35 -> 15 -> 10 -> 2 -> null 
     * and addAfter(7, 10) is called, the list should become 
     *  head -> 35 -> 15 -> 10 -> 7 -> 2 -> null 
     * @param toAdd value to be added 
     * @param after value after which toAdd should be added 
     * @return false, if `after` does not exist in the current list 
     */
    public boolean addAfter(Integer toAdd, Integer after) {
        
        //TODO; implement this method 
        if(toAdd == null || after == null){
            throw new NullPointerException("toAdd or after should not be null");
        }
        Node tmp = head;
        if(tmp == null){
            return false;
        }
        while(tmp != null){
            if(tmp.data == after){
                Node n = new Node(toAdd);
                n.next = tmp.next;
                tmp.next = n;
                return true;
            }
            tmp = tmp.next;
        }
        return false; 
    }

}
