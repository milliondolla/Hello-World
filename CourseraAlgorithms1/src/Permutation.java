import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

	private static int k;

	public static void main(String[] args) throws Exception {

		if (args.length == 0)
			throw new Exception("No args");

		k = Integer.parseInt(args[0]);

		if (k < 0)
			throw new Exception("K < 0");

		int n = 0;
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		String inStr = null;
		do {
			inStr = StdIn.readString();
			if (inStr == null || !inStr.equalsIgnoreCase("*")) {
				
				q.enqueue(inStr);
				n++;
			}else{
				break;
			}
		} while (!inStr.equalsIgnoreCase("*"));

		if (k > n)
			throw new Exception("Not enough elements suuplied");

		for (int i = 0; i <= k; i++) {
			StdOut.println(q.sample());
		}
	}

}
