package week2.stacks;

/**
 * Linked list impl of stach API
 * 
 * Add/remove from the beginning. 
 * 
 * Uses LIFO
 *
 */
public class LinkedStackOfStrings {

	private Node first = null;

	// inner class
	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}

}
