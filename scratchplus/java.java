package scratchplus;
import java.util.*;
public class java{
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        int bound = sa.nextInt();
        int min = Integer.MAX_VALUE;
        int[] array = new int[bound];
        boolean check = true;
        int result = 1;
        for(int i = 0; i < bound; i++){
            array[i] = sa.nextInt();
        }
        for(int i = 0; i < bound; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        for(int i = 1; i <= min; i++){
            for(int j = 0; j < bound; j++){
                if (array[j] % i != 0){
                    check = false;
                }
                if ((array[j] % i == 0) && (j == bound - 1) && check){
                    result = i;
                }
                if (j == bound - 1){
                    check = true;
                }
            }
        }
        System.out.print(result);
        sa.close();
    }
}