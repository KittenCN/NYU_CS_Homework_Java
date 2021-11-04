package QiuanYu_Homework_6;
import java.util.Scanner;
import java.util.Random;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        String[][] state = {{"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"},{"Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","St. Paul","Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton","Santa Fe","Albany","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg","Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"}};
        boolean[] visited = new boolean[50];
        int correctcnt = 0;
        for(int i = 0; i < 50; i++) {
            Random r = new Random();
            int n = r.nextInt(49);
            if(!visited[n]) {
                visited[n] = true;
                System.out.println("What is the capital of " + state[0][n] + "?");
                String answer = sa.nextLine();
                if(answer.toLowerCase().equals(state[1][n].toLowerCase())) {
                    System.out.println("Your answer is correct!");
                    correctcnt++;
                } 
                else {
                    System.out.println("The correct answer should be " + state[1][n]);
                }
            }
        }
        System.out.println("The correct count is " + correctcnt);
        sa.close();
    }
}
