package project5.HowManyWords;

import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;

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
