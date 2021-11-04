package QiuanYu_Homework_4;
import java.util.*;
public class Exercise6 {
    public static char getRandomChar(){
        Random r = new Random();
        return (char)((int)'a' + r.nextInt(25));
    }
    public static void main(String[] args) {
        System.out.print(getRandomChar());
    }
}
