package QiuanYu_Homework_5;
import java.util.Scanner;
public class Exercise4 {
    public static boolean isSorted(int[] list){
        for(int i = 1; i < list.length - 1; i++){
            if(list[i] > list[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.print("Enter list: ");
        int n = sa.nextInt();
        int[] intList = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            intList[i] = sa.nextInt();
        }
        intList[0] = n;
        if(isSorted(intList)){
            System.out.println("The list is already sorted.");
        }
        else{
            System.out.println("The list is not sorted.");
        }
        sa.close();
    }
}
