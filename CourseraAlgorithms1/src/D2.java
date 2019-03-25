import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class D2 {

	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();

		// StdOut.println(deque.isEmpty());
		// deque.addFirst(1);
		// StdOut.println(deque.isEmpty());
		// deque.addFirst(2);
		// deque.addLast(3);
		// StdOut.println(deque.size());
		//// ///////////////////////////////////////
		// deque.addFirst(1);
		// deque.addFirst(2);
		// deque.addFirst(3);
		// StdOut.println(deque.removeLast());
		//
		// StdOut.println(deque.size());

		////////////////////////////////////

		// StdOut.println(deque.isEmpty()); // ==> true
		// deque.addLast(2);
		// StdOut.println(deque.isEmpty()); // ==> false
		// deque.removeFirst();

		//////////////////////////////////////

		// deque.addFirst(1);
		// deque.removeLast();

		/////////////////////////////////////

		 StdOut.println(deque.size());
		 StdOut.println(deque.isEmpty()); // ==> true
		 StdOut.println(deque.size()); // ==> 0
		 deque.addLast(3);
		 StdOut.println(deque.size());
		 StdOut.println(deque.removeFirst()); // ==> 3
		 StdOut.println(deque.size());
		 StdOut.println(deque.isEmpty()); // ==> true

		//////////////////////////////////////////////
		// deque.addFirst(1);
		// StdOut.println(deque.removeFirst()); // ==> 1
		// StdOut.println(deque.isEmpty()); // ==> true

		//////////////////////////////////
//		 StdOut.println(deque.isEmpty());// ==> true
//		 StdOut.println(deque.isEmpty());// ==> true
//		 deque.addFirst(3);
//		 StdOut.println(deque.removeFirst());// ==> 3
//		 StdOut.println(deque.isEmpty());// ==> false

		//////////////////////////////////////////
		// deque.addLast(1);
		// StdOut.println(deque.isEmpty());// ==> false
		// deque.addLast(3);
		// deque.addLast(4);
		// deque.addLast(5);
		// deque.addLast(6);
		// StdOut.println(deque.removeFirst());// ==> 1
		// StdOut.println(deque.removeFirst());// ==> 6 must be 3

		///////////////////////////

		// deque.addFirst(1);
		// deque.addLast(2);
		// deque.removeLast();// ==> 2
		//
		// Iterator it = deque.iterator();
		// StdOut.println("--------------------");
		// while (it.hasNext()) {
		// StdOut.println(it.next());
		// }

		///////////////////

		// deque.addFirst(1);
		// StdOut.println(deque.isEmpty());// ==> false
		// deque.removeLast();
		// StdOut.println(deque.isEmpty());

		///////////////////////////

		// deque.addLast(1);
		// deque.removeLast();

		///////////////////////////////
//		 StdOut.println(deque.isEmpty());// ==> true
//		 deque.addLast(2);
//		 StdOut.println(deque.isEmpty());// ==> false
//		 deque.addLast(4);
//		 StdOut.println(deque.removeLast());// ==> 4
//		 StdOut.println(deque.removeLast());

		//////////////////////////////

//		 StdOut.println(deque.isEmpty());// ==> true
//		 StdOut.println(deque.isEmpty());// ==> true
//		 deque.addFirst(3);
//		 StdOut.println(deque.removeLast());// ==> 3
//		 StdOut.println(deque.isEmpty());// ==> true
//		 deque.addFirst(6);
//		 StdOut.println(deque.removeLast());// ==> 6
		
		
		/////////////////////////////////

//		StdOut.println(deque.isEmpty());// ==> true
//		deque.addFirst(2);
//		deque.addFirst(3);
//		StdOut.println(deque.removeLast());// ==> 2
//		StdOut.println(deque.removeLast());// ==> 3
//		deque.addFirst(6);
//		StdOut.println(deque.removeLast());// ==> 6
//		deque.addFirst(8);
//		StdOut.println(deque.removeLast());// ==> 8
		
		/////////////////////////////////////
		
//		deque.addLast(1);
//        deque.addFirst(2);
//        StdOut.println(deque.removeLast());//    ==> 1
//        StdOut.println(deque.removeLast());//    ==> 2
//        deque.addLast(5);
//        deque.addLast(6);
//        deque.addLast(7);
//        deque.addFirst(8);
//        
//        StdOut.println("----");
//        StdOut.println(deque.size()+": ");
//        Iterator it = deque.iterator();
//        while(it.hasNext()){
//        	StdOut.print(it.next()+" ");
//        }

	}

}
