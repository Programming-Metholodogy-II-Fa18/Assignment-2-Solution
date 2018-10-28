
public class LinkedList {
	
	public ArbitraryQueue<Integer> aq = new ArbitraryQueue<Integer>();
	
	
	public void add(int data) {
		aq.Enqueue(data);
	}
	
	
	public void quicksort() {
		shuffle();
		System.out.println("-------QuickSort:-------");

		sort(0, aq.totalNodes-1);
	}
	
	public void shuffle() {
		System.out.println("-------Shuffling-------");
		for(int i = 0; i < aq.totalNodes; i=i+2) {
			swap(i, i+1);
		}
		System.out.println("-------Shuffled List:-------");
		printList();
	}
	
	
    private void sort( int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = aq.Traverse(lo);
        int i = lo + 1;
        while (i <= gt) {
            int cmp = aq.Traverse(i).compareTo(v);
            if      (cmp < 0) swap(lt++, i++);
            else if (cmp > 0) swap(i, gt--);
            else              i++;
        }

        sort(lo, lt-1);
        sort(gt+1, hi);
    }
	
	
	
	
	public void swap(int j, int k) {
		if(j !=k) {
		Integer dataj = aq.Traverse(j);
		Integer datak = aq.Traverse(k);
		System.out.println("Swapping " + dataj + " with " + datak);
		aq.setNode(j, datak);
		aq.setNode(k, dataj);
		printList();
		}
		
		
	}
	
	
	public void printList() {
		
		String s = "" + aq.Traverse(0);
		for(int i = 1; i < aq.totalNodes; i++) {
			s = s + "," + aq.Traverse(i);
		}
		System.out.println(s);
		

	}


}
