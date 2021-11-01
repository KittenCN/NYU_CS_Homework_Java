package HW3;
import java.util.*;
public class Exercise5B {
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        String st = "";
        int num = sa.nextInt();
        if(num == 0){
            System.out.println("0");
        }
        else if(num == 1){
            System.out.println("1");
        }
        else{
            while(num / 2 != 0){
                st = Integer.toString(num % 2) + st;
                num /= 2;
            }
            st = "1" + st;
            System.out.println(st);
        }
        sa.close();
    }
}
