package project4;

import java.util.*;


public class BST<E> extends BinaryTree<E> {
	private Comparator<E> comparator;

	public BST() {

	}

	public BST(E[] collection) {
		for (E element:collection){
			add(element);
		}
	}

	public boolean add(E element) {
		elementNotNullCheck(element);
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return true;
		}

		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		do {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { 
				node.element = element;
				return false;
			}
		} while (node != null);

		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
		return true;
	}

	public void clear(){
		this.root=null;
	}

	public void remove(E element) {
		remove(node(element));
	}

	public E ceiling(E element){
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if(cmp>=0){
				node=node.right;
			}else {
				break;
			}
		}
		if(node!=null){
			if (node.left!=null) return node.left.element;
			return node.element;
		}
		return null;

	}

	public E higher(E element){
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if(cmp>0){
				node=node.right;
			}else {
				break;
			}
		}
		if(node!=null){
			if (node.left!=null) return node.left.element;
			return node.element;
		}
		return null;

	}

	public boolean isEmpty(){
		return this.root==null;
	}
	public E last(){
		Node<E> node = root;
		while (node.right != null) {
			node=node.right;
		}
		return node.element;
	}
	public E first(){
		Node<E> node = root;
		while (node.left != null) {
			node=node.left;
		}
		return node.element;
	}

	public E floor(E element){
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if(cmp<=0){
				node=node.right;
			}else {
				break;
			}
		}
		if(node!=null){
			if (node.right!=null) return node.right.element;
			return node.element;
		}
		return null;
	}

	public E lower(E element){
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if(cmp<0){
				node=node.right;
			}else {
				break;
			}
		}
		if(node!=null){
			if (node.right!=null) return node.right.element;
			return node.element;
		}
		return null;

	}

	public Iterator<E> iterator(){
		List<E> list=new ArrayList<>();
		midOder(this.root,list);
		return list.listIterator();
	}

	public Iterator<E> postorderIterator(){
		List<E> list=new ArrayList<>();
		postOrder(this.root,list);
		return list.listIterator();
	}
	private void midOder(Node<E> root, List<E> list) {
		if (root!=null){
			midOder(root.left,list);
			list.add(root.element);
			midOder(root.right,list);
		}
	}
	private void postOrder(Node<E> root, List<E> list) {
		if (root!=null){
			postOrder(root.left,list);
			postOrder(root.right,list);
			list.add(root.element);
		}
	}

	public Iterator<E> preorderIterator(){
		List<E> list=new ArrayList<>();
		preOrder(this.root,list);
		return list.listIterator();
	}

	private void preOrder(Node<E> root, List<E> list) {
		if (root!=null){
			list.add(root.element);
			preOrder(root.left,list);
			preOrder(root.right,list);
		}
	}

	public  int height() {
		if (this.root == null) {
			return 0;
		}
		int leftHeight = 0;
		int rightHeight = 0;
		if (root.left != null) {
			leftHeight += height(root.left) + 1;
		}
		if (root.right != null) {
			rightHeight += height(root.right) + 1;
		}
		return Math.max(leftHeight, rightHeight);
	}

	public boolean contains(E element) {
		return node(element) != null;
	}

	public int size(){
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(this.root, sb, "");
		return sb.toString();
	}

	public String toStringTreeFormat(){
		LevelOrderPrinter printer=new LevelOrderPrinter(this);
		return printer.printString();
	}
	private void toString(Node<E> node, StringBuilder sb, String prefix) {
		if (node == null) return;
		toString(node.left, sb, prefix + "L---");
		sb.append(prefix).append(node.element).append("\n");
		toString(node.right, sb, prefix + "R---");
	}

	private void remove(Node<E> node) {
		if (node == null) return;

		size--;

		if (node.hasTwoChildren()) { 
			Node<E> s = successor(node);
			node.element = s.element;
			node = s;
		}

		Node<E> replacement = node.left != null ? node.left : node.right;

		if (replacement != null) { 
			replacement.parent = node.parent;
			if (node.parent == null) { 
				root = replacement;
			} else if (node == node.parent.left) {
				node.parent.left = replacement;
			} else { // node == node.parent.right
				node.parent.right = replacement;
			}
		} else if (node.parent == null) { 
			root = null;
		} else { 
			if (node == node.parent.left) {
				node.parent.left = null;
			} else { // node == node.parent.right
				node.parent.right = null;
			}
		}
	}

	private Node<E> node(E element) {
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) return node;
			if (cmp > 0) {
				node = node.right;
			} else { // cmp < 0
				node = node.left;
			}
		}
		return null;
	}

	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}

	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
}
