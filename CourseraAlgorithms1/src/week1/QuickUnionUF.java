package week1;

/**
 * Avoid quadratic algorithm in find from QuickFind
 *
 */
public class QuickUnionUF {

	private int[] id;

	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	/** 
	 * To Find, check if p and q have the same root
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	/**
	 * To merge components containing p and q, set the id of p's root to the id of q's root
	 */
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	/**
	 * Quick-union defect:
	 * 1)	Trees can get tall
	 * 2)	Find too expensive (could be N array accesses).
	 * 
	 * Solution: create Weighted quick-union. 
	 * 
	 */

}
