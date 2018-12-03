package week2.queues;

/**
 * Maintain pointer to first and last nodes in a linked list
 * 
 * Insert/remove from opposite ends - FIFO
 *
 */
public class QueueOfStrings {

	//Maintain pointer to first and last nodes in a linked list
	private Node first, last = null;

	// inner class
	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Same as stack pop()
	 */
	public String dequeue() {
		String item = first.item;
		first = first.next;
		return item;
	}

	public void enqueue(String item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
	}

}
