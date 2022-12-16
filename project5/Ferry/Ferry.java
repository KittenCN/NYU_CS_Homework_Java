package project5.Ferry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * Input: The first line of input contains three integers N, T and M (1 <= N, T, M <= 10,000). Each of the following
 * M lines gives the arrival time of a car and the bank at which the car arrives (left or right). The cars are ordered
 * by their arrival times (so the arrival times are non-decreasing) and the time spent on loading and unloading can be
 * ignored.
 * Output: For each car, you should print one line containing one number, the time at which the car is unloaded at the
 * opposite bank.
 *
 * @author Joanna Klukowska
 * @author Jerry Yu
 *
 */
public class Ferry {
    private static class Car {
        public int time;
        public String bank;
    
        public Car(int time, String bank) {
          this.time = time;
          this.bank = bank;
        }
      }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int m = sc.nextInt();
        List<Car> cars = new ArrayList<>();
        int waitcars = 0;
        for (int i = 0; i < m; i++) {
          int time = sc.nextInt();
          String bank = sc.next();
          cars.add(new Car(time, bank));
        }
        int currentTime = 0;
        String currentBank = "left";
        List<Car> ferry = new ArrayList<>();

        while (!cars.isEmpty()) {
            int min_time = Integer.MAX_VALUE;
            for(Car car : cars) {
                if(car.time <= currentTime){
                    waitcars++;
                }
                if(car.time < min_time) {
                    min_time = car.time;
                }
            }
            for (int i = 0; i < ferry.size(); i++) {
                System.out.println(currentTime);
            }
            ferry.clear();
          while (cars.size() > 0 && ferry.size() < n) {
            Car car = cars.get(0);
            if (car.time > currentTime || !car.bank.equals(currentBank)) {
              break;
            }
            ferry.add(car);
            cars.remove(0);
            waitcars--;
          }
          if(waitcars > 0 || ferry.size() > 0) {
            currentTime += t;
            currentBank = currentBank.equals("left") ? "right" : "left";
          }
          else{
            currentTime += min_time;
          }
        }
          for (int i = 0; i < ferry.size(); i++) {
            System.out.println(currentTime);
          }
        sc.close();
      }
    }
