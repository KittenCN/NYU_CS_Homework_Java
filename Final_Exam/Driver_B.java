package Final_Exam;

public class Driver_B {
    public static void main( String [] args ) {
        
        BST_B tree = new BST_B(); 
        tree.add("fly");
        tree.add("bird");
        tree.add("pig");
        tree.add("dog");
        tree.add("owl");
        tree.add("turtle");
        tree.add("cat"); 
        tree.add("snail"); 
        
        System.out.println(tree.toStringTree() ); 
 
 
        System.out.println("\nReturned list: "); 
        System.out.println( tree.levelValues(3) + "\n");
         
    } 
}
