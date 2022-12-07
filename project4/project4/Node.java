package project4;

/**
 * The Node class nodes for noding the binary tree.
 * 
 * @author QiuanYu
 *
 */

public class Node<E> {
    E element;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    public Node(E element, Node<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasTwoChildren() {
        return left != null && right != null;
    }
}
