
/**
 * Modify quick-union to avoid tall trees
 * 
 * Balance by linking root of smaller tree to root of larger tree
 *
 */
public class Wquf {
	private int[] id;
	private int[] sz;

	public Wquf(int n) {
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];// adds path compression
			i = id[i];
		}
		return i;
	}

	/**
	 * To Find, check if p and q have the same root Identical to quick-union
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	/**
	 * 
	 * Link root of smaller tree to root of larger tree
	 * 
	 * Update the sz[] array
	 * 
	 */
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		// where it differs from QuickUnionUF
		if (i == j)
			return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}

}
