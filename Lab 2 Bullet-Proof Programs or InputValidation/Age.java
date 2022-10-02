import java.util.Scanner;
public class Age{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your age(a positive integer): ");
        while(!in.hasNextInt()){
            System.out.println("Invalid input. Please enter a positive integer: ");
            in.next();
        }
        int age = in.nextInt();
        while(age < 0 || age > 120){
            System.out.println("Invalid age. Please enter a positive integer: ");
            age = in.nextInt();
        }
        System.out.println("Enter your name: ");
        String name = in.next();
        while(name == null || name.length() == 0 || name.length() > 20 || name.contains(" ") || name.contains("0") || name.contains("1") || name.contains("2") || name.contains("3") || name.contains("4") || name.contains("5") || name.contains("6") || name.contains("7") || name.contains("8") || name.contains("9")){
            System.out.println("Invalid name. Please enter a non-empty string: ");
            name = in.next();
        }
        System.out.println(name + " is " + age + " years old.");
        in.close();
    }
}