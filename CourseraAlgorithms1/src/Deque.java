import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	// Maintain pointer to first and last nodes in a linked list
	private Node first, last = null;
	private int sz = 0;

	// inner class
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	// construct an empty deque
	public Deque() {

	}

	// is the deque empty?
	public boolean isEmpty() {
		return (first == null || last == null);
	}

	// return the number of items on the deque
	public int size() {
		return sz;
	}

	// add the item to the front
	public void addFirst(Item item) {

		if (item == null)
			throw new java.lang.IllegalArgumentException();

		Node oldFirst = first;

		Node newFirst = new Node();
		newFirst.item = item;
		newFirst.next = oldFirst;

		oldFirst.prev = newFirst;

		first = newFirst;
		sz++;

	}

	// add the item to the end
	public void addLast(Item item) {

		if (item == null)
			throw new java.lang.IllegalArgumentException();

		// the same as enqueue
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

	// remove and return the item from the front
	public Item removeFirst() {
		// same as dequeue (pop)
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		} else {
			Item item = first.item;
			first = first.next;

			if (isEmpty()) {
				first = last;
			} else {
				first.prev = null;
			}

			sz--;
			return item;
		}
	}

	// remove and return the item from the end
	public Item removeLast() {

		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		} else {

			Node oldLast = last;

			last = oldLast.prev;

			if (isEmpty()) {
				first = last;
			} else {
				last.next = null;
			}

			return oldLast.item;
		}

	}

	// return an iterator over items in order from front to end
	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator<Item>();
	}

	private class DequeIterator<Item> implements Iterator<Item> {

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(isEmpty()) throw new java.util.NoSuchElementException();
			Item currItem = (Item) current.item;
			current = current.next;
			return currItem;
		}

		@Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

	}
}
