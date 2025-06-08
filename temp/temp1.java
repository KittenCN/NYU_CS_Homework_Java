package temp;
import java.lang.reflect.Array;
import java.util.*;
 
public class temp1 {
    public static void tickets(){
        ArrayList<Object> tickets = new ArrayList<>();
        tickets.add(0101);
        tickets.add("Andrew");
        tickets.add(0203);
        tickets.add("Rufus");
        tickets.add(0710);
        tickets.add("Sally");

        for(int i = 1; i < tickets.size(); i += 2){
            System.out.println("Ticket Number: " + tickets.get(i-1) + ", Name: " + tickets.get(i));
        }
    }

    public static void ticketsTo2DArray(ArrayList<Object> tickets){
        String[][] TIX = new String[7][10];
        for(int i = 0; i < tickets.size(); i += 2){
            int number = (int) tickets.get(i);
            String name = (String) tickets.get(i + 1);

            int row = number / 100 - 1;
            int col = number % 100 - 1;
            TIX[row][col] = name;
        }

    }
}