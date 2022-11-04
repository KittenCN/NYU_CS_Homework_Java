
import java.util.*; 

public class DriverC {



    // method for testing the implementation 
    // (note that this main function is far from providing 
    // complete tests, it is just a starting point for you to continue)
    public static void main (String[] args) {
        LinkedListC iList = new LinkedListC();
        Integer values [] = {35, 9, 18, 18, 23, 47}; 
        for (int i = 0; i< values.length; i++) {
            iList.add(values[i]); 
        }

        System.out.println(iList);

        iList.addAfter(3, 18); 
        System.out.println(iList);
    }


}
