import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] a = {9,10,11,3,2,15};
		Problem4A(a);
		System.out.println(Arrays.toString(a));
		
	}
	
	
	
	public static void Problem4A(int[] a) {
		
		// pick the largest value of the current 3 indices and swap around them
		// O(N)
		for(int i = 1; i < a.length; i = i+2) {
			int x = i-1;
			int y;
			if( i != a.length-1)
			y = i+1;
			else
				y = i;
			int z = Math.max(a[x],Math.max(a[i],a[y]));
			int index = 0;
			
			if(z == a[x]) index = x;
			else if (z == a[y]) index = y;
			else index = i;
			
			if(index != i) {
				int temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}

		}
		
	}



}
