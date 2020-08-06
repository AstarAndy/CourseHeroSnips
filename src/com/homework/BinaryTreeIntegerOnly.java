package com.homework;

/**
 * Simple, partial implementation of a BinaryTree that stores 
 * integers.  This class does NOT fully implment the features of a tree
 * and only supports Integers.
 * @author Student's Name
 *
 */
public class BinaryTreeIntegerOnly {
	
	/**
	 * This represents a single entry in the tree.  
	 * Each entry will have a left and right, in addition
	 * to this (the node itself)
	 * @author Student's name
	 *
	 */
	static class Node {
	    int value;
	    Node left;
	    Node right;
	 
	    Node(int value) {
	        this.value = value;
	        right = null;
	        left = null;
	    }
	}
	
	// Private member.  A root note
	
	private Node root;
	
	/**
	 * Used to  add child elements in order 
	 * @param whichNote The Node to add the value to
	 * @param value int The integer value to use as the node value
	 * @return
	 */
	private Node add(Node whichNote, int value) {
	    if (whichNote == null) {
	        return new Node(value);
	    }
	 
	    if (value < whichNote.value) {
	        whichNote.left = add(whichNote.left, value);
	    } else if (value > whichNote.value) {
	        whichNote.right = add(whichNote.right, value);
	    } else {
	        // value already exists
	        return whichNote;
	    }
	 
	    return whichNote;
	}

	/**
	 * This is used by the public to-string method
	 * to print out, in numeric order, the left, this, and
	 * right values.
	 * @param node
	 */
	private String traverseInOrder(Node node) {
	    String result = "";
		if (node != null) {
	        result =  traverseInOrder(node.left) + " " + node.value + traverseInOrder(node.right);
	    }
	    return result;
	}

	/**
	 * Use this method to add items to the tree.
	 * The tree will stay in numerical order
	 * @param value int The integer value to add to the tree
	 */
	public void add(int value) {
	    root = add(root, value);
	}
	
	@Override
	public String toString() {
		return traverseInOrder(root);
	}
	
	
	
	/**
	 * Primary entry point.  You can execute this from the 
	 * command line or from you IDE
	 * @param args
	 */
	public static void main(String...args) {
		BinaryTreeIntegerOnly btio = new BinaryTreeIntegerOnly();
		btio.add(8);
		btio.add(3);
		btio.add(10);
		btio.add(1);
		btio.add(6);
		btio.add(9);
		btio.add(14);
		System.out.println("The order list of the tree is: ");
		System.out.println(btio);
	}

}
