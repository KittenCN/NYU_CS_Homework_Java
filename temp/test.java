package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class test {
    static void foo(int length){
        stack.push(1);
        
    }
    static void foo(int length, String seq){
        if(seq.length()==length){
            System.out.printf("%s \n",seq);
            return;
        }
        String seq0 = seq + "0";
        foo(length, seq0);
        if(seq.length() != length -1){
            String seq1 = seq + "1";
            foo(length, seq1);
        }
    }
    public static void main(String[] args) {
        
       foo(4);
    }
}
