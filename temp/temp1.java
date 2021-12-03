package temp;
import java.util.Arrays;
import java.util.Scanner;
 
public class temp1 {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        int number = sa.nextInt();
        int[] mountains = new int[number];
        int modifiedHeight = 0;
        for(int i = 0; i < number; i++) {
            mountains[i] = sa.nextInt();
        }
        Arrays.sort(mountains);
        for(int i = 0; i < number; i++) {
            for(int j = number - 1; j > i; j--) {
                if(mountains[j] - mountains[i] < 17) {
                    break;
                }
                else {
                    int heightDifference = mountains[j] - mountains[i] - 17;
                    int addHeight = heightDifference / 2;
                    int chopHeight =  heightDifference - addHeight;
                    mountains[i] += addHeight;
                    mountains[j] -= chopHeight;
                    modifiedHeight = modifiedHeight + addHeight * addHeight + chopHeight * chopHeight;
                }
            }
        }
        Arrays.sort(mountains);
        System.out.println("----------------------------------------");
        String result = "";
        for(int i = 0; i < number; i++) {
            result += mountains[i] + " ";
        }
        System.out.println(result);
        // System.out.print(modifiedHeight);
        sa.close();
    }
}