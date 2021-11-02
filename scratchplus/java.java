package scratchplus;
import java.util.*;
 
public class java{
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        int max = 0;
        int digit = 0;
        int counter = 0;
        while(sa.hasNext()){
            int temp = sa.nextInt();
            if(temp > max){
                max = temp;
                digit = counter;
            }
            counter++;
        }
        System.out.print(max +"\n" + digit);
        sa.close();
    }
}