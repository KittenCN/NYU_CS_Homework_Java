package HW3;
public class ascii {
    public static void main(String[] args){
        int n = 1;
        for(int i = 65; i <= 126; ++i){
            System.out.print((char)i);
            if(++n > 5){
                System.out.println(" ");
                n = 1;
            }
        }
    }
}
