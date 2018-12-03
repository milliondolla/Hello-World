package week2.stacks;

/**
 * Array impl of stack API
 *
 * Add/remove from the beginning.
 * 
 * Uses LIFO
 *
 */
public class FixedCapacityStack<T> {

	private T[] s;
	private int N = 0;

	public FixedCapacityStack(int capacity) {
		 s = (T[]) new Object[capacity]; 
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(T item) {
		s[N++] = item;
	}

	/**
	 * Pop and avoid object loitering
	 */
	public T pop() {
		T item = s[--N];
		s[N] = null;
		return item;
	}

}
