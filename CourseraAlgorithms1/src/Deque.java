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
        // return (first == null && last == null);
        return sz == 0;
    }

    // return the number of items on the deque
    public int size() {
        return sz;
    }

    // add the item to the front
    public void addFirst(Item item) {

        if (item == null)
            throw new java.lang.IllegalArgumentException();

        // ref to current firsts
        Node oldFirst = first;

        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = oldFirst;
        newFirst.prev = null;

        if (oldFirst != null) {
            oldFirst.prev = newFirst;
            // oldFirst.next = null;//TODO
        }

        first = newFirst;

        // manage last. If last is null set to first. Otherwise last must become
        // oldFirst with updated prev
        if (last == null) {
            last = first;
            last.next = null;
            last.prev = first;
        }
        // else {
        // last.next = null;
        // last.prev = first;
        // }

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
        if (isEmpty() || first == null)
            first = last;
        else {
            oldlast.next = last;
        }

        sz++;

        // if(first.prev == null) StdOut.println("prev valid"); else
        // StdOut.println("prev invalid") ;
        //
        // if(last.next == null) StdOut.println("last valid"); else StdOut.println("las
        // invalid") ;

    }

    // remove and return the item from the front
    public Item removeFirst() {
        // same as dequeue (pop)
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            Item item = first.item;

            if (size() == 1) {
                first = null;
                last = null;
            } else {
                first = first.next;

                if (isEmpty() || first == null) {
                    first = last;
                } else {
                    first.prev = null;
                }
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

            if (size() == 1) {

                first = null;
                last = null;

            } else {

                if (oldLast != null) {
                    last = oldLast.prev;
                    if (last != null) {
                        last.next = null;
                    }
                }

                if (isEmpty() && first == null) {
                    last.next = null;
                    first = last;
                    first.prev = null;
                }
            }

            // // empty deque
            // if (isEmpty() && first == null) {
            // last.next = null;
            // first = last;
            // first.prev = null;
            // }

            sz--;

            return oldLast.item;
        }
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (isEmpty() || hasNext() == false)
                throw new java.util.NoSuchElementException();
            Node currItem = current;
            current = current.next;
            return currItem.item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

    }
}
