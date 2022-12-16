package project5.BuggyKeyboard;

import java.util.Scanner;

/**
 * 
 * Input: A string s containing text written on Gabrielle’s computer. The length of s is less than 10ˆ6 The string will contain only lower case letters, spaces, and the character <. Output
 * Output: A string containing text that was actually intended. Note that there should be no spaces or new line after the last character in the output.
 *
 * @author Joanna Klukowska
 * @author Jerry Yu
 *
 */

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
