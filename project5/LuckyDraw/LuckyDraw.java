package project5.LuckyDraw;
import java.util.ArrayList;
import java.util.Scanner;

public class LuckyDraw {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<String> numbers = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      numbers.add(i, Integer.toString(sc.nextInt()));
    }
    int numPots = n;
    while (true) {
      boolean removed = false;
      for (int i = 0; i < numbers.size() - 1; i++) {
        if ((Integer.parseInt(numbers.get(i)) + Integer.parseInt(numbers.get(i + 1))) % 2 == 0) {
          numbers.remove(i);
          numbers.remove(i);
          removed = true;
          numPots -= 2;
        }
      }
      if (!removed) {
        break;
      }
    }
    System.out.print(numPots);
    sc.close();
  }
}

