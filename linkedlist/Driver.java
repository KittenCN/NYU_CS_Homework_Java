package linkedlist;

import java.util.*; 

public class Driver {



    // method for testing the implementation 
    // (note that this main function is far from providing 
    // complete tests, it is just a starting point for you to continue)
    public static void main (String[] args) {
        //LinkedList<String> sList = new LinkedList<>();
        LinkedList<Integer> iList = new LinkedList<>();

        for (int i = 0; i< 5; i++) {
            iList.add(i, 0); 
        }

        System.out.println(iList);

        iList.remove(3);
        
        System.out.println(iList);

        int pos = iList.find(5); 

        System.out.println(pos); 


    }


}