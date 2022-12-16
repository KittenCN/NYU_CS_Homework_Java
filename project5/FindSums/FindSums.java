package project5.FindSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Input: The first line of the input contains two integers S (1 <= S <= 1,000) and N (1 <= N <= 12), indicating the target
 * sum and the number of values in the multiset, respectively.
 * The second line contains N integers, all of which are between 1 and 100 - these are the elements of the multiset.
 * Output: First, print a line Sums of S: where S is the value given in the input. Then print one line for every subset satisfying
 * the condition or a line containing NONE if there is no such subset.
 * For every subset, numbers are printed in decreasing order and separated by a plus sign (+). The subsets themselves
 * are sorted lexicographically in decreasing order, i.e. they are sorted by their first integer, then the second integer in
 * case of tie, and so on. Additionally, the subsets you print should not contain repetitions (i.e., you should never print
 * two lines that are identical).
 *
 * @author Joanna Klukowska
 * @author Jerry Yu
 *
 */

public class FindSums {
    static int S, N, sum;
    static int[] set;
    static boolean[] used;
    static int count = 0;
    static String last = "";
    static ArrayList<String> result = new ArrayList<>();

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static void dfs(int dep, int sum, String sr) {
        if(sum == S ){
            String tmp = "";
            String[] arr = sr.split(",");
            for(int i = 0; i < arr.length - 1; ++i){
                if(Integer.parseInt(arr[i + 1]) > Integer.parseInt(arr[i])){
                    return;
                }
                tmp += arr[i] + "+";
            }
            tmp += arr[arr.length - 1];
            String[] tmp2 = last.split(",");
            for(int i = 0; i < tmp2.length; ++i){
                if(tmp.equals(tmp2[i])){
                    return;
                }
            }
            System.out.println(tmp);
            count += 1;
            last += tmp + ",";
            return;
        }
        if(sum > S){
            return;
        }
        for(int i = dep; i < N; ++i){
            if(used[i] == false){
                used[i] = true;
                dfs(dep + 1, sum + set[i], sr + Integer.toString(set[i]) + ',');
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        N = sc.nextInt();
        set = new int[N];
        used = new boolean[N];
    
        for (int i = 0; i < N; i++){
            set[i] = sc.nextInt();
            used[i] = false;
        }          
        Arrays.sort(set);
        reverse(set);
        System.out.println("Sums of " + S + ":");
        dfs(0, 0, "");
        if(count == 0){
            System.out.println("NONE");
        }
        sc.close();
    }
}
