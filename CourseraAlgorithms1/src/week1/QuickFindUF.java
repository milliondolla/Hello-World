package week1;

public class QuickFindUF {
	
	private int[] id;

	public QuickFindUF(int N) {
		id = new int[N];
		// N array accesses
		for(int i=0; i < N; i++){
			id[i]=1;
		}
	}

	/**
	 * Check if p and q have the same id
	 */
	public boolean connected(int p, int q){
		// 2 array accesses 
		return id[p] == id[q];
	}
	
	/**
	 * To merge components containing p and q, change all entries whose id equals id[p] to id[q].
	 */
	public void union(int p, int q){
		
		int pid = id[p];
		int qid = id[q];
		
		// at most 2N+2 array accesses
		for(int i=0; i < id.length; i++){
			
			// change all ids equal to pid, to qid 
			if(id[i] == pid){ //use pid and NOT id[p]. It will result in a bug
				id[i] = qid;
			}
			
		}
		
	}
	
	/**
	 * Quick find defect:
	 * 1)	Union is too expensive (N array accesses)
	 * 2)	Trees are flat, but too expensive to keep them flat
	 * 
	 * Solution: Create Quick-Union
	 */
}
