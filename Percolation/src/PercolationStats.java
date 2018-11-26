import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private int n;
	private int trials;
	private int[] results;

	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials){
		
		if(n < 0 || trials < 0 ) throw new IllegalArgumentException("'n' or 'trails' < 0");
		
		this.n = n;
		this.trials = trials;
		this.results = new int[trials];
	}
	
	
	// sample mean of percolation threshold
	public double mean(){
		return StdStats.mean(results);
	}
	   
	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(results);
	}
	   
	// low  endpoint of 95% confidence interval
	public double confidenceLo(){
		double m = mean();
		double s = stddev();
		return m - (1.96 * s / Math.sqrt(trials));
	}
	   
	// high endpoint of 95% confidence interval
	public double confidenceHi()  {
		double m = mean();
		double s = stddev();
		return m + (1.96 * s / Math.sqrt(trials));
	}                

	// test client (described below)
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		
		PercolationStats stats = new PercolationStats(N, T);
		
		for(int i=1; i<=T; i++){
			
			Percolation p = new Percolation(N);
			
			while(!p.percolates()){
				
				int row = StdRandom.uniform(N);
				int col = StdRandom.uniform(N);
				
				if(!p.isOpen(row, col)){
					p.open(row, col);
				}
				
				if(p.percolates()){
					stats.results[i] = p.numberOfOpenSites();
					break;
				}
			}
			
			System.out.println("mean: "+stats.mean());
			
		}
	}

}
