package week3;

/**
 * Insertion sort, with stride length h
 * 
 * Since successive increment values of hh differ by at least a factor of 3,
 * there are \sim \log_3 n -> log 3n increment values. For each increment value
 * hh, the array is already hh-sorted so it will make \sim n∼n compares.
 *
 */
public class ShellSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		
		/* 3x + 1 increment sequence*/
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...
		///////////////////////////////////
		
		
		while (h >= 1) { // h-sort the array.
			
			/* INSERTION sort */
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			////////////////////////////////////////////////

			h = h / 3;// -> MOVE to next increment
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
