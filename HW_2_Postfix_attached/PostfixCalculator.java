package HW_2_Postfix_attached;
import java.util.*;
class Stack {
    float float_arrResult[];
    int int_size;
    int int_tos;
    Stack(int int_size) {
        float_arrResult = new float[int_size];
        this.int_size = int_size;
        this.int_tos = -1;
    }
    public int isFull() {
        if (this.int_tos == this.int_size - 1)
            return 1;
        else
            return 0;
    }
    public int isEmpty() {
        if (this.int_tos == -1)
            return 1;
        else
            return 0;
    }
    public void push(float x) {
        float_arrResult[++this.int_tos] = x;
    }
    public float pop() {
        return float_arrResult[this.int_tos--];
    }
    public float peek() {
        return float_arrResult[this.int_tos];
    }
}

public class PostfixCalculator {
    public static float calculate(String str_Calculate) {
        Stack stack = new Stack(str_Calculate.length());
        for (int i = 0; i < str_Calculate.length(); i++) {
            char ch = str_Calculate.charAt(i);
            if (Character.isDigit(ch))
                stack.push(ch - '0');
            else {
                float val1 = stack.pop();
                float val2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '^':
                        stack.push((float)Math.pow(val2, val1));
                    break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str_Calculate = "", result = "";
        int int_size;
        System.out.print("type your infix Expression:");
        str_Calculate = sc.nextLine();
        str_Calculate = '(' + str_Calculate + ')';
        int_size = str_Calculate.length();
        Converter c1 = new Converter(int_size);
        String s = c1.toPostFix(str_Calculate);
        System.out.println("converted to postfix: " + s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                result += s.charAt(i);
        }
        System.out.println("answer is " + calculate(result));
        sc.close();
    }
}