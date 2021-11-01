package HW3;
import java.util.*;
public class poi {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sa.nextInt();
        System.out.print("What power do you want " + num + " to be raised to? ");
        int raisnum = sa.nextInt();
        int product = 1;
        for (int i = 1; i <= raisnum; ++i){
            System.out.print(num + " ");
            if(i != raisnum){
                System.out.print("x ");
            }
            else{
                System.out.print("= ");
            }
            product *= num;
        }
        System.out.print(product);
        sa.close();
    }
}
