import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Similar to a stack or queue, except that the item removed is chosen uniformly
 * at random from items in the data structure
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	// Maintain pointer to first and last nodes in a linked list
	private Node first, last = null;
	private int sz = 0;

	// inner class
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	// construct an empty randomized queue
	public RandomizedQueue() {
	}

	// is the randomized queue empty?
	public boolean isEmpty() {
		return first == null;
	}

	// return the number of items on the randomized queue
	public int size() {
		return sz;
	}

	// add the item
	public void enqueue(Item item) {

		if (item == null)
			throw new java.lang.IllegalArgumentException();

		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldlast;

		if (isEmpty())
			first = last;
		else
			oldlast.next = last;

		sz++;
	}

	// remove and return a random item
	public Item dequeue() {

		if (isEmpty())
			throw new java.util.NoSuchElementException();

		Item item = first.item;
		first = first.next;
		sz--;
		return item;

	}

	// return a random item (but do not remove it)
	public Item sample() {

		if (isEmpty())
			throw new java.util.NoSuchElementException();

		int index = StdRandom.uniform(0, size());

		Node itmToSample = first;

		while (index >= 0) {
			if (itmToSample.next != null) {
				itmToSample = itmToSample.next;
				index--;
			} else {
				break;
			}
		}

		return itmToSample.item;
	}

	// return an independent iterator over items in random order
	@Override
	public Iterator<Item> iterator() {
		return new RandomQueueIterator<Item>();
	}

	// unit testing (optional)
	public static void main(String[] args) {
	}

	private class RandomQueueIterator<Item> implements Iterator<Item> {

		private Node current = last;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (isEmpty())
				throw new java.util.NoSuchElementException();
			Item currItem = (Item) current.item;
			current = current.prev;
			return currItem;
		}

		@Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

	}

}
