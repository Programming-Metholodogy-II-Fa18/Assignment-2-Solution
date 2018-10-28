import java.util.Arrays;

public class Main {

	public static void main(String[] args) {


		int[] a = {1, 98, 12, 215,3,6};

		
		System.out.println(Arrays.toString(a));

		Problem1Sort(a);

		System.out.println(Arrays.toString(a));


		int[] b = {1, 98, 1000, 12, 215};

		System.out.println(Arrays.toString(b));


		Problem1SortConstantSpace(b);

		System.out.println(Arrays.toString(b));

	}
	
	
	


	public static void Problem1Sort(int[] a) {

		@SuppressWarnings("unchecked")
		// uses O(N) extra space
		ArbitraryQueue<Integer>[] digits = (ArbitraryQueue<Integer>[]) new ArbitraryQueue[10];
		for(int i = 0; i < digits.length; i++) {
			digits[i] = new ArbitraryQueue<Integer>();
		}


		// find largest number by linear search, O(N) time
		int maximum = a[0];
		for(int i = 1; i < a.length; i++)
			if(a[i] > maximum) maximum = a[i];

		// digits in largest number, 'd'
		int count = (int) (Math.log10(maximum)+1);

		// external loop runs 'd' times
		for(int i = 0; i < count; i++) {

			// runs N times
			for(int j = 0; j < a.length; j++) {

				int digit = (int) (a[j] % Math.pow(10, i+1)/Math.pow(10, i));
				digits[digit].Enqueue(a[j]);
				//System.out.println(digit);
			}

			int index = 0;

			//runs totally 10 times
			for(int x = 0; x < digits.length; x++) {

				// grabs pointer to memory 10 times
				ArbitraryQueue<Integer> current = digits[x];

				// only runs N times
				while(current.totalNodes > 0) {
					a[index] = current.Pop();
					index++;
				}

			}

		}

		// 'd*(N+10*N) complexity -> 11*d*N
		// uses O(N) extra space to store the values in queues
		// sort is stable because we enqueue equal values in order and push them off at the same time

	}

	public static void Problem1SortConstantSpace(int[] a) {

		@SuppressWarnings("unchecked")
		// uses O(1) extra space, 10*2 = 20 integers
		int[] counts = new int[10];
		int[] positions = new int[10];


		// find largest number by linear search, O(N) time
		int maximum = a[0];

		for(int i = 1; i < a.length; i++)
			if(a[i] > maximum) maximum = a[i];

		// digits in largest number, 'd'
		int count = (int) (Math.log10(maximum)+1);

		// external loop runs 'd' times
		for(int i = 0; i < count; i++) {

			// this runs at most 10 times
			for(int x = 0; x < counts.length; x++) {
				counts[x] = 0;
				positions[x] = 0;
			}


			// runs N times
			for(int j = 0; j < a.length; j++) {

				int digit = (int) (a[j] % Math.pow(10, i+1)/Math.pow(10, i));
				counts[digit] = counts[digit]+1;
				//System.out.println(digit);
			}
			// runs 9 times
			for(int x = 1; x < counts.length; x++) {
				positions[x] = positions[x-1] + counts[x-1]; 
			}

			// runs N times
			for(int j = 0; j < a.length; j++) {

				int digit = (int) (a[j] % Math.pow(10, i+1)/Math.pow(10, i));
				int position = positions[digit];
				int temp = a[j];
				a[j] = a[position];
				a[position] = temp;
				if(positions[digit]+1 <  a.length)
					positions[digit] = positions[digit]+1;

			}


		}




	}


}
