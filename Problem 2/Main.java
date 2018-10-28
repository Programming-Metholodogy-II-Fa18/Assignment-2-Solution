import java.util.Arrays;

public class Main {

	public static void main(String[] args) {


		int[] a = {1, 98, 12, 215,3,6};
		inPlaceMerge(a);
		System.out.println(Arrays.toString(a));

		
	}
	


	public static void inPlaceMerge(int[] a) {


		recursiveMerge(a,0,a.length-1);



	}


	public static void recursiveMerge(int[] a, int lo, int hi) {

		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		recursiveMerge(a, lo, mid);
		recursiveMerge(a,mid+1,hi);


		// logic: keep track of the left and right endpoints and work towards the middle
		// i.e. imagine this as quicksort but with merging
		int x = lo;
		int y = mid+1;


		while (x <= mid && y <= hi)
		{  
			if (a[x] < a[y] )
				x++;
			else
			{  
				// shift the array in chunks, preserving final value
				int temp = a[x];
				int temp2 = 0;
				int temp3 = a[y];
				for(int i = x; i <= y; i++) {
					temp2 = a[i];
					a[i] = temp;
					temp = temp2;
				}
				a[x] = temp3;
				x=x+1;  
				mid=mid+1;  
				y=y+1;
			}
		}
	}



}
