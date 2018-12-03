package week2.stacks;

/**
 * Enhance @See FixedCapacityStackOfStrings to grow and shrink an array without
 * the Client having to specify the size of the array
 * 
 * If array is full double the size and copy the elements
 * 
 * Halve the size of the array when it is a quarter full
 *
 * Array is between 25% and 100% full
 */
public class ResizingArrayStackOfStrings {

	private String[] s;
	private int N = 0;

	public ResizingArrayStackOfStrings() {
		s = new String[1];
	}

	public void push(String item) {

		// if array is full double the size and copy the elements
		if (N == s.length)
			resize(2 * s.length);
		s[N++] = item;
	}

	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = s[i];
		s = copy;
	}

	public String pop() {
		String item = s[--N];
		s[N] = null;

		// halve the size of the array when it is a quarter full
		if (N > 0 && N == s.length / 4)
			resize(s.length / 2);

		return item;
	}

}
