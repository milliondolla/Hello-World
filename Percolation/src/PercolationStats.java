import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private static final double D = 1.96;
	private final int trials;
	private double[] results;

	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials) {

		if (n < 0 || trials < 0)
			throw new IllegalArgumentException("'n' or 'trails' < 0");

		this.trials = trials;
		this.results = new double[trials];
	}

	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(results);
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(results);
	}

	// low endpoint of 95% confidence interval
	public double confidenceLo() {
		double m = mean();
		double s = stddev();
		return m - (D * s / Math.sqrt(trials));
	}

	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		double m = mean();
		double s = stddev();
		return m + (D * s / Math.sqrt(trials));
	}

	// test client (described below)
	public static void main(String[] args) {

		int nSize = Integer.parseInt(args[0]);
		int tTimes = Integer.parseInt(args[1]);

		PercolationStats stats = new PercolationStats(nSize, tTimes);

		for (int i = 0; i < tTimes; i++) {

			Percolation p = new Percolation(nSize);

			while (!p.percolates()) {

				int row = StdRandom.uniform(1, nSize + 1);
				int col = StdRandom.uniform(1, nSize + 1);

				if (!p.isOpen(row, col)) {
					p.open(row, col);
				}

				if (p.percolates()) {
					int x = p.numberOfOpenSites();
					int n = nSize * nSize;
					double avg = (double) x / n;
					stats.results[i] = avg;
					break;
				}
			}

		}

		StdOut.println("mean = " + stats.mean());
		StdOut.println("stdev = " + stats.stddev());
		StdOut.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
	}
}
