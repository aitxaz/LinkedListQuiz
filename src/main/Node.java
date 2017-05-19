package main;

public class Node {

	private int element; // we assume elements are integers
	private Node next;

	/** Creates a node with the given element and next node. */
	public Node(int e, Node n) {
		element = e;
		next = n;
	}

	/** Returns the element of this node. */
	public int getElement() {
		return element;
	}

	/** Returns the next node of this node. */
	public Node getNext() {
		return next;
	}

	// Modifier methods:
	/** Sets the element of this node. */
	public void setElement(int newElem) {
		element = newElem;
	}

	/** Sets the next node of this node. */
	public void setNext(Node newNext) {
		next = newNext;
	}
}
