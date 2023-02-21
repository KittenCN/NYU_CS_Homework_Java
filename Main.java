import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sa=new Scanner(System.in);
        double n;
        double a;
        double b;
        double c;
        n=sa.nextDouble();
        a=n/5*60;
        b=n/15*60+5;
        c=n/35*60+10;
        if (a<b && a<c){
            System.out.print("WALK");
        }
        else if (b<a && b<c){
            System.out.print("BIKE");
        }
        else if (c<a && c<b){
            System.out.print("CAR");
        }
        sa.close();
    }
}