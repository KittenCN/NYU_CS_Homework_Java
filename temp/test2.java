package temp;

public class test2 {
    void swap ( double d1, double d2 ) {
        double tmp;
        tmp = d1;
        d1 = d2;
        d2 = tmp;
    }
    public static void main(String[] args) {
        double num1 = 1.0;
        double num2 = 2.0;
        test2 t = new test2();
        t.swap(num1, num2);
        System.out.println(num1 + " " + num2);
    }
}
