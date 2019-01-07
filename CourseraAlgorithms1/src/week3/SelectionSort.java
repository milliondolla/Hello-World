package week3;

/**
 * Selection sort: In iteration i, find index min of smallest remaining entry 
 * 
 * Uses (N-1)+(N-2)+...+1+0 ~ N*N / 2 compares and N exchanges. 
 * Even if the array is sorted it will use quadratic time -> running time is insensitive to input
 * 
 *
 */
public class SelectionSort {

	public static void sort(Comparable[] a) {

		int N = a.length;

		for (int i = 0; i < N; i++) {

			int min = i; // idx of smallest remaining entry

			for (int j = i + 1; j < N; j++) {
				 if(less(a[j], a[min])){
					 min = j;
				 }
				 exch(a, i, min);
			}

		}

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
