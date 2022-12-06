package project4;

import java.util.*; 

public class BST < T extends Comparable <T> > {


    private BSTNode root;   //reference to the root node of the tree 
    private Comparator<T> comparator;   //comparator object to overwrite the 
                                //natural ordering of the elements 
    	
	private boolean found;  //helper variable used by the remove methods
    private boolean added ; //helper variable used by the add method 

    /**
	 * Constructs a new, empty tree, sorted according to the natural ordering of its elements.
	 */
    public BST () {
        root = null; 
        comparator = null; 
    }

    /**
	 * Constructs a new, empty tree, sorted according to the specified comparator.
	 */
    public BST(Comparator<T> comparator) {
        this.root = null; 
        this.comparator = comparator;
    }


	/**
	 * Adds the specified element to this tree if it is not already present. 
	 * If this tree already contains the element, the call leaves the 
     * tree unchanged and returns false.
	 * @param data element to be added to this tree 
     * @return true if this tree did not already contain the specified element 
     * @throws NullPointerException if the specified element is null  
	 */
    public boolean add ( T data ) { 
        if (data == null ) {
            throw new NullPointerException("no nulls allowed"); 
        }
        //adding first element to the tree 
        if (root == null ) {
            root = new BSTNode(data); 
            return true; 
        }

        return add(data, root) ; 

    }

    private boolean add(T data, BSTNode node ) {
        
        if ( node.data.equals(data) ) {
            return false; 
        }
        if (data.compareTo(node.data ) < 0 ) {
            if (node.left == null ) {
                node.left = new BSTNode(data); 
                return true; 
            }
            return add( data, node.left) ;
        }
        else {
            if (node.right == null ) {
                node.right = new BSTNode(data); 
                return true; 
            }
            return add(data, node.right) ; 
        }

    }


    public boolean contains( T data ) {
        BSTNode node = root;
        while (node != null){
            if (data.compareTo(node.data) == 0){
                return true;
            }
            else if (data.compareTo(node.data) < 0){
                node = node.left;
            }
            else if (data.compareTo(node.data) > 0){
                node = node.right;
            }
        }
        return false;

    }
    

    

	/*
	 * Returns the information held in the rightmost node of subtree
	 *
	 * @param subtree root of the subtree within which to search for the rightmost node
	 * @return returns data stored in the rightmost node of subtree
	 */
	private T getPredecessor(BSTNode subtree)
	{
        BSTNode temp = subtree.left;
        while (temp.right != null){
            temp = temp.right;
        }
        return temp.data; 
	}


	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
        //TO DO: implement this method 
        

		return 0;
	}


    public String toStringTree( ) {
        StringBuffer sb = new StringBuffer(); 
        toStringTree(sb, root, 0);
        return sb.toString();
    }

    //uses preorder traversal to display the tree 
    //WARNING: will not work if the data.toString returns more than one line 
    private void toStringTree( StringBuffer sb, BSTNode node, int level ) {
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
    private class BSTNode implements Comparable < BSTNode > {

        T data;
        BSTNode  left;
        BSTNode  right;

        public BSTNode ( T data ) {
            this.data = data;
        }

        public BSTNode (T data, BSTNode left, BSTNode right ) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int compareTo ( BSTNode other ) {
            if (BST.this.comparator == null )
                return this.data.compareTo ( other.data );
            else 
                return comparator.compare(this.data, other.data); 
        }
    }

    
}

