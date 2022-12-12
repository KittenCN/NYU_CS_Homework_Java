import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sa=new Scanner(System.in);
        String st = sa.next();
        char cr = st.charAt(0);
        int cr_ascii = (int)(cr);
        int a=cr_ascii-1;
        char A=(char)(a);
        int b=cr_ascii+1;
        char B=(char)(b);
        String ac=sa.next();
        char as=ac.charAt(0);
        int as_ascii=(int)(as);
        int c=as_ascii-1;
        char C=(char)(c);
        int d=as_ascii+1;
        char D=(char)(d);
        System.out.println(cr+":"+cr_ascii+" "+"qianqu"+":"+A+" "+"houji"+":"+B);
        System.out.print(as+":"+as_ascii+" "+"qianqu"+":"+C+" "+"houji"+":"+D);
        sa.close();
    }
}