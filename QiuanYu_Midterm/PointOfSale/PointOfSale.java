package QiuanYu_Midterm.PointOfSale;
import java.util.*;
import static java.lang.System.out;
import java.text.DecimalFormat;
public class PointOfSale {
    static Scanner sa = new Scanner(System.in);
    public static boolean auth(){
        out.println("Login");
        out.print("Password: ");
        String stPwd = sa.nextLine();
        int intWPwd = 0;
        while(stPwd.equals("5XC") == false){
            intWPwd++;
            if(intWPwd >= 3){
                return false;
            }
            out.println("Wrong Password, try it again!");
            out.print("Password: ");
            stPwd = sa.nextLine();
        }
        return true;
    }
    public static char menu(){
        out.println("");
        out.println("A: Coffee\r\n" + "B: Tea\r\n" + "C: Croissant\r\n" + "F: Finalize the bill\r\n" + "*: Cancel this bill and reset for new customer\r\n" + "Q: Quit Program\r\n");
        out.print("Please select:(A/B/C/F/*/Q) ");
        char cr = sa.next().charAt(0);
        cr = Character.toUpperCase(cr);
        return cr;
    }
    public static void quit(){
        out.println("Bye!");
        System.exit(0);
    }
    public static void finalize(int cnta, int cntb, int cntc){
        DecimalFormat df = new DecimalFormat("#.00");
        out.println("");
        out.println("*********BILL**********");
        if(cnta > 0) out.println("Coffee     X " + cnta + "    $" +  df.format(cnta * 1.3));
        if(cntb > 0) out.println("Tea        X " + cntb + "    $" +  df.format(cntb * 1.0));
        if(cntc > 0) out.println("Croissant  X " + cntc + "    $" +  df.format(cntc * 1.8));
        out.println("***********************");
        out.println("     " + "Total Cost:" + df.format(cnta * 1.3 + cntb * 1 + cntc * 1.8));
        out.println("");
        out.println("Press ENTER to Next Customer!");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }
    public static void main(String[] args) {
        boolean boolQuit = false;
        int cnta = 0, cntb = 0, cntc = 0;
        if(auth() == false) quit();
        while(boolQuit == false){    
            switch(menu()){
                case 'A':
                    cnta++;
                    out.println("Add a cup of Coffee");
                    break;
                case 'B':
                    cntb++;
                    out.println("Add a cup of Tea");
                    break;
                case 'C':
                    cntc++;
                    out.println("Add a Croissant");
                    break;
                case 'F':
                    finalize(cnta, cntb, cntc);
                    cnta = cntb = cntc = 0;
                    break;
                case '*':
                    cnta = cntb = cntc = 0;
                    out.println("Reset current bill and Next customer!");
                    break;
                case 'Q':
                    boolQuit = true;
                    break;
                default:
                    out.println("Wrong code!");
                    break;
            }
        }
        sa.close();
    }
}
