
import java.util.*; 

public class SplitNegativePositive{
    public static void main (String [] args ) {
        
        Scanner in = new Scanner( System.in ); 
        ArrayList<Integer> list = new ArrayList<>();
        
        while (in.hasNextInt() ) {
            list.add( in.nextInt() ); 
        }
        
        //TODO: complete this method
        //(you may implement additional methods in this class if you wish)
        
        PriorityQueue<Integer> negative = new PriorityQueue<>(); 
        PriorityQueue<Integer> positive = new PriorityQueue<>(); 
        
        for(int i : list) {
            if(i < 0) {
                negative.offer(i); 
            }
            else {
                positive.offer(i); 
            }
        }
        
        while (!negative.isEmpty()) {
            System.out.print(negative.poll() + " ");
        }
        System.out.println();

        while (!positive.isEmpty()) {
            System.out.print(positive.poll() + " ");
        }
        
        in.close();
    }
    
}

