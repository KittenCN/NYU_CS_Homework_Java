package project5.LuckyDraw;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * Input: The first line contains an integer 1 <= n <= 100000, giving the number of people who participate in the game. The
 * second line contains n integers indicating the ticket numbers of people standing in the line from first to last. Each
 * lottery ticket value is in the range of 1 to 100.
 * Output: The number of pots of gold that the mayor will need to hand out at the end of the day assuming he eliminates as
 * many people as possible.
 * Note: there should be no newline after the output.
 *
 * @author Joanna Klukowska
 * @author Jerry Yu
 *
 */
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

