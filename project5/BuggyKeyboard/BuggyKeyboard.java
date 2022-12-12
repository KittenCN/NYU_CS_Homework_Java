package project5.BuggyKeyboard;

import java.util.Scanner;

public class BuggyKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '<') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            }
            else {
                result.append(c);
            }
        }
        System.out.print(result.toString());
        sc.close();
    }  
}
