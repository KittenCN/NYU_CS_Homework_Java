package project5.EfficientAdding;
import java.util.PriorityQueue;
import java.util.Scanner;
public class EfficientAdding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intNumbers = sc.nextInt();
        int[] numbers = new int[intNumbers];
        for(int i = 0; i < intNumbers; i++) {
            numbers[i] = sc.nextInt();
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : numbers) {
            heap.add(num);
        }
        int totalCost = 0;
        while (heap.size() > 1) {
            int num1 = heap.poll();
            int num2 = heap.poll();
            int sum = num1 + num2;
            totalCost += sum;
            heap.add(sum);
        }
        System.out.println(totalCost);
        sc.close();
    }
}
