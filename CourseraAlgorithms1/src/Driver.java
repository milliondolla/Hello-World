import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		
//		QueueOfStrings qos = new QueueOfStrings();
//		
//		qos.enqueue("A");
//		qos.enqueue("S");
//		qos.enqueue("D");
//		qos.enqueue("F");
//		
//		ResizingArrayStack<String> ra = new ResizingArrayStack<String>();
//		
//		ra.push("A");
//		ra.push("S");
//		ra.push("D");
//		ra.push("F");
//		
//		
//		System.out.print(qos.dequeue()+" ");
//		System.out.println(ra.pop());
//		
//		System.out.print(qos.dequeue()+" ");
//		System.out.println(ra.pop());
//		
//		System.out.print(qos.dequeue()+" ");
//		System.out.println(ra.pop());
//		
//		System.out.print(qos.dequeue()+" ");
//		System.out.println(ra.pop());
		
		Deque<String> dq = new Deque<String>();
		
		dq.addLast("z");
		dq.addFirst("y");
		dq.addLast("ss");
		dq.addFirst("ee");
		
// test #1		
//		System.out.println(dq.removeFirst());
//		System.out.println(dq.removeFirst());
//		System.out.println(dq.removeFirst());
//		System.out.println(dq.removeFirst());

// test #2
//		System.out.println(dq.removeLast());
//		System.out.println(dq.removeLast());
//		System.out.println(dq.removeLast());
//		System.out.println(dq.removeLast());
	
// test #3		
//		System.out.println(dq.size());
//		dq.removeFirst();
//		System.out.println(dq.size());
//		dq.removeFirst();
//		System.out.println(dq.size());
//		dq.removeFirst();
//		System.out.println(dq.size());
//		dq.removeFirst();
//		System.out.println(dq.size());
		
// Test #4		
//		Iterator<String> it = dq.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
	}

}
