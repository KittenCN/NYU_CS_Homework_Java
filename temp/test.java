package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        foo [] list = new foo[5]; 

        list[0] = new foo(2,-3);
        list[1] = new foo(2,13);
        list[2] = new foo(2,5);
        list[3] = new foo(2,1);
        list[4] = new foo(2,-20);

        Arrays.sort(list);
        System.out.println( Arrays.toString(list) ); 
    }
}
