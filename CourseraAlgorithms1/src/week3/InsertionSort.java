package week3;

/**
 * In iteration i, swap a[i] with each larger entry to its left
 * 
 * When elements are sorted ascending order: N-1 compares and 0 exchanges. Basically just validates that it is sorted (Best case). Uses linear time
 * When elements are sorted descending order: 0.5*N*N compares and exchanges (worst case).
 * When elements are sorted partially(only a few items are swapped around): runs in linear time -> number of exchanges == number of inversions
 *
 */
public class InsertionSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
	}

	/**
	 * Is v smaller than w.
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * Exchange the larger value with the smaller value
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
