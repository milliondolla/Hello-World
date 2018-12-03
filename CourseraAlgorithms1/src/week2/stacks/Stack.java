package week2.stacks;

/**
 * Linked list impl of stach API
 * 
 * Add/remove from the beginning. 
 * 
 * Uses LIFO
 *
 */
public class Stack<T> {

	private Node first = null;

	// inner class
	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(T item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public T pop() {
		T item = first.item;
		first = first.next;
		return item;
	}

}
