package scratchplus;
import java.util.*;
public class C1033_A{
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        int people = sa.nextInt();
        int tub = sa.nextInt();
        int result = 0;
        int[] takeTime = new int[people];
        int[] sumTub = new int[tub];
        for(int i = 0; i < people; i++){
            takeTime[i] = sa.nextInt();
        }
        int[] sortTime = takeTime;
        Arrays.sort(sortTime);
        for(int i = 0; i < tub; i++){
            int current = 0;
            for(int j = i; j < people; j += tub){
                current += sortTime[j];
                sumTub[i] += current;
            }
            result += sumTub[i];
        }
        System.out.println(result);
        sa.close();
    }
}