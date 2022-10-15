import java.util.Scanner;
    public class A extends B{
        public String toString(){
            return "A";
        }
    }
    public class B{
        public String toString(){
            return "B";
        }
    }
    public class tt{
        public static void main(String[] args){
            B a = new A();
            A b = new A();
            System.out.println(b);
            System.out.println(a);
        }
}