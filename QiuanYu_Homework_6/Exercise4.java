package QiuanYu_Homework_6;
import java.util.*;
public class Exercise4 {
    public static ArrayList<Character> stack = new ArrayList<Character>();
    public static boolean isEmpty() {
        return stack.isEmpty();
    }
    public static void push(char c) {
        stack.add(c);
        return;
    }
    public static char pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        }
        else {
            char c = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return c;
        }
    }
    public static void show() {
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
        return;
    }
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        System.out.println("There are four commands in the system, and the use method is as follows:");
        System.out.println("1. push: push a character into the stack. e.g: push a");
        System.out.println("2. pop: pop a character from the stack. e.g: pop");
        System.out.println("3. show: show the stack. e.g: show");
        System.out.println("4. exit: exit the system. e.g: exit");
        System.out.print("Please input the command: ");
        while (sa.hasNext()) {
            String s = sa.next();
            if (s.equals("push")) {
                char c = sa.next().charAt(0);
                push(c);
            } 
            else if (s.equals("pop")) {
                System.out.println(pop());
            } 
            else if (s.equals("show")) {
                show();
            } 
            else if (s.equals("exit")) {
                System.out.println("Bye!");
                break;
            } 
            else {
                System.out.println("The command is not correct, please input again:");
            }
            System.out.print("Please input the command: ");
        }
        sa.close();
    }
}
