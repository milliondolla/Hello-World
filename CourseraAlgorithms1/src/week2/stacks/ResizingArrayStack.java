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
public class ResizingArrayStack<T> {

	private T[] s;
	private int N = 0;

	@SuppressWarnings("unchecked")
    public ResizingArrayStack() {
		s = (T[]) new Object[1]; 
	}

	public void push(T item) {

		// if array is full double the size and copy the elements
		if (N == s.length)
			resize(2 * s.length);
		s[N++] = item;
	}

	private void resize(int capacity) {
		T[] copy = (T[]) new Object[capacity]; 
		for (int i = 0; i < N; i++)
			copy[i] = s[i];
		s = copy;
	}

	public T pop() {
		T item = s[--N];
		s[N] = null;

		// halve the size of the array when it is a quarter full
		if (N > 0 && N == s.length / 4)
			resize(s.length / 2);

		return item;
	}

}
