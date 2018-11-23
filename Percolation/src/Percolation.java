
public class Percolation {

	private int n;
	private WeightedQuickUnionUF wquf;
	private boolean[][] nByNGrid;
	private int cntrOpen;

	private int top = 0;
	private int bottom;

	/**
	 * create n-by-n grid, with all sites blocked
	 */
	public Percolation(int n) {

		if (n < 0)
			throw new java.lang.IllegalArgumentException();

		this.n = n;
		this.wquf = new WeightedQuickUnionUF(n * n * 2);
		this.cntrOpen = 0;
		this.bottom = n * n + 1;

		// create the grid N X N
		this.nByNGrid = new boolean[n + 1][n + 1];

		// set all sites to be blocked
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				nByNGrid[row][col] = false;
			}
		}
	}

	/**
	 * Opens site (row , column ) if it is not already.
	 */
	public void open(int row, int col) {

		nByNGrid[row][col] = true;
		
		int current = xyTo1D(row, col);

		if (row == 1) {
			wquf.union(current, 0);
		}
		if (row == n) {
			wquf.union(current, bottom);
		}

		if (col > 1 && isOpen(row, col - 1)) {
			wquf.union(current, xyTo1D(row, col - 1));
		}
		if (col < n && isOpen(row, col + 1)) {
			wquf.union(current, xyTo1D(row, col + 1));
		}
		if (row > 1 && isOpen(row - 1, col)) {
			wquf.union(current, xyTo1D(row - 1, col));
		}
		if (row < n && isOpen(row + 1, col)) {
			wquf.union(current, xyTo1D(row + 1, col));
		}
	}

	/**
	 * is site (row, col) open? i.e. not connected to the top
	 */
	public boolean isOpen(int row, int col) {
		return nByNGrid[row][col];
	}

	/**
	 * is site (row, col) full? - is it connected to the top
	 */
	public boolean isFull(int row, int col) {
		int idx = xyTo1D(row, col);
		return wquf.connected(idx, 0);
	}

	/**
	 * number of open sites
	 */
	public int numberOfOpenSites() {
		return this.cntrOpen;
	}

	/**
	 * Percolates iff any site on bottom row is connected to site on top row iff
	 * top & bottom are connected by open sites
	 */
	public boolean percolates() {
		return wquf.connected(top, bottom);
	}

	// Sites are in same component if connected by open sites

	/**
	 * Map 2D coordinates to 1D idx
	 */
	private int xyTo1D(int row, int col) {
		int idx = col + (n * row);
		return idx + 1;
	}

	/**
	 * Determine the col in 2D from 1D idx
	 */
	private int oneDToCol(int idx) {
		return (idx - 1) % n;
	}

	/**
	 * Determine the row in 2D from 1D idx
	 */
	private int oneDToRow(int idx) {
		return (idx - 1) / n;
	}

}
