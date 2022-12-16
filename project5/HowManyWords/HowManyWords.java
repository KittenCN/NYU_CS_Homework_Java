package project5.HowManyWords;

import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;
/**
 * 
 * Input: The input is a text with up to 5,000 lines. Each line has at most 200 characters. The input is terminated by EOF.
 * Output: A list of unique words that appear in the text, one per line. The output should be in alphabetical order and in lower
 * case. You are guaranteed that the number of unique words in the text is no more than 5,000.
 *
 * @author Joanna Klukowska
 * @author Jerry Yu
 *
 */
public class HowManyWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> words = new HashSet<>();
        while (sc.hasNext()) {
            String[] lineWords = sc.nextLine().split("[^a-zA-Z]+");
            for (String word : lineWords) {
                words.add(word.toLowerCase());
            }
        }
        TreeSet<String> sortedWords = new TreeSet<>(words);
        for (String word : sortedWords) {
            System.out.println(word);
        }
        sc.close();
    }
}
