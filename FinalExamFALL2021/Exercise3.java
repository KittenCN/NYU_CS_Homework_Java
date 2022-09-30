package FinalExamFALL2021;

import java.util.*;

public class Exercise3 {
    public static int[] sort(int[] a,int[] b){
        int[] c = new int[a.length+b.length];
        int i=0,j=0,k = 0;
        while (i<a.length&&j<b.length){
            if(a[i]>=b[j]){
                c[k++] = b[j++];
            }else {
                c[k++] = a[i++];
            }
        }
        while (j<b.length){
            c[k++] = b[j++];
        }
        while (i<a.length){
            c[k++] = a[i++];
        }
        return c;
    }
    public static int[] StringArrayToIntArray(String strLine){
        String[] strA = strLine.split(" ");
        int[] ans = new int[strA.length];
        for(int i = 0; i < strA.length; ++i){
            ans[i] = Integer.parseInt(strA[i]);
        }
        return ans;
    }
    public static void show(int[] intArray){
        String strAns = "";
        for(int i = 0; i < intArray.length; ++i){
            strAns += Integer.toString(intArray[i]) + ' ';
        }
        System.out.println(strAns);
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);

        System.out.print("Enter the 1st array, separated by spaces: ");
        String strLine = sa.nextLine();
        int[] a = StringArrayToIntArray(strLine);
        System.out.print("Enter the 2nd array, separated by spaces: ");
        strLine = sa.nextLine();
        int[] b = StringArrayToIntArray(strLine);
        int[] ans = sort(a, b);
        show(ans);
        sa.close();
    }
}
