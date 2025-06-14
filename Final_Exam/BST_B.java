package Final_Exam;
import java.util.ArrayList; 

public class BST_B {

    private Node root;   //reference to the root node of the tree 

    /**
	 * Constructs a new, empty tree, sorted according to the natural ordering of its elements.
	 */
    public BST_B () {
        root = null; 
    }

	/**
	 * Adds the specified element to this tree if it is not already present. 
	 * If this tree already contains the element, the call leaves the 
     * tree unchanged and returns false.
	 * @param data element to be added to this tree 
     * @return true if this tree did not already contain the specified element 
	 */
    public boolean add ( String data ) { 
         
         if (root == null ) {// create the first node 
            root = new Node (data); 
            return true;
         }
         Node current = root;
         while (current != null ) {
             int comp = current.data.compareTo(data); 
             if (comp > 0) { //add in the left subtree
                if (current.left == null ) {
                    current.left = new Node (data);
                    return true; 
                }
                else {
                    current = current.left; 
                }
             }
             else if (comp < 0 ) {//add in the right subtree
                if (current.right == null ) {
                    current.right = new Node (data);
                    return true; 
                }
                else {
                    current = current.right; 
                }
             }
             else { //duplicate 
                return false; 
             }
         }
         //we should never get to this line 
         return false; 
    }
        

	/**
	 * Returns a list of values stored at the specified level of this tree. 
     * The order of values in the list should be from leftmost to 
     * rightmost as they are stored in the tree. 
     * 
     * For example, if the tree contains strings as follows and the 
     * specified level is 1 
     * 
     *            fly 
     *         /       \
     *      bird        pig 
     *         \       /   \
     *         dog   owl   turtle
     *         /            /
     *       cat         snail    
     *   
     * the returned list should contain strings: bird, pig, 
     * in that order. 
	 * @return an ArrayList object containing values stored at the specified 
     * level as described above; the returned list should be 
     * empty if the specified level does not exist in this tree (or if the 
     * specified level is negative) 
     */
	public ArrayList<String> levelValues( int level ) {
        
        //TO DO: implement this function 
        ArrayList<String> values = new ArrayList<>(); 
        if (level < 0 || root == null) {
            return values; 
        }
        levelValues(root, level, 0, values);
        return values;
	}

    private void levelValues(Node node, int level, int currentLevel, ArrayList<String> values) {
        if (node == null) {
            return;
        }
        if (currentLevel == level) {
            values.add(node.data);
            return;
        }
        levelValues(node.left, level, currentLevel + 1, values);
        levelValues(node.right, level, currentLevel + 1, values);
    }
    
    
    /**
     * Produces tree like string representation of this tree.
     * Returns a string representation of this tree in a tree-like format.
     * Each node is shown in its own line with the indentation showing the depth of the node in this tree.
     * The root is printed on the first line, followed by its left subtree, followed by its right subtree.
     *
     * @return string containing tree-like representation of this tree.
     */
    public String toStringTree( ) {
        StringBuffer sb = new StringBuffer(); 
        toStringTree(sb, root, 0);
        return sb.toString();
    }

    //uses preorder traversal to display the tree 
    //WARNING: will not work if the data.toString returns more than one line 
    private void toStringTree( StringBuffer sb, Node node, int level ) {
        //display the node 
        if (level > 0 ) {
            for (int i = 0; i < level-1; i++) {
                sb.append("   ");
            }
            sb.append("|--");
        }
        if (node == null) {
            sb.append( "->\n"); 
            return;
        }
        else {
            sb.append( node.data + "\n"); 
        }

        //display the left subtree 
        toStringTree(sb, node.left, level+1); 
        //display the right subtree 
        toStringTree(sb, node.right, level+1); 
    }


    /* 
     * Node class for this BST 
     */ 
    private class Node implements Comparable < Node > {

        String data;
        Node  left;
        Node  right;

        public Node ( String data ) {
            this.data = data;
        }

        public int compareTo ( Node other ) {
            return this.data.compareTo( other.data );  
        }
    }




}
