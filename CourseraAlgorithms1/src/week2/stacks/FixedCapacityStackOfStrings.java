package week2.stacks;

/**
 * Array impl of stack API
 *
 * Add/remove from the beginning.
 * 
 * Uses LIFO
 *
 */
public class FixedCapacityStackOfStrings {

	private String[] s;
	private int N = 0;

	public FixedCapacityStackOfStrings(int capacity) {
		s = new String[capacity];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(String item) {
		s[N++] = item;
	}

	/**
	 * Pop and avoid object loitering
	 */
	public String pop() {
		String item = s[--N];
		s[N] = null;
		return item;
	}

}
