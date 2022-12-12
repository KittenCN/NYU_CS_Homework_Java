package project5.FindSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
