import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation2 {

	private static int k;

	public static void main(String[] args) {

		In in = new In(args[1]); // input file
		
		if (args.length == 0)
			throw new java.lang.IllegalArgumentException("No args");

		k = Integer.parseInt(args[0]);

		if (k < 0)
			throw new java.lang.IllegalArgumentException("K < 0");
		
		int n = 0;
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		String inStr = null;
		while (!in.isEmpty()) {
			inStr = in.readString();
			q.enqueue(inStr);
			n++;
		}

		if (k > n)
			throw new java.lang.IllegalArgumentException("Not enough elements supplied");

		for (int i = 0; i < k; i++) {
			StdOut.println(q.sample());
		}

	}

}
