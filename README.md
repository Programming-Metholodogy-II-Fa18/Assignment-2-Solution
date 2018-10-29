# Assignment-2-Solution
## Programming Methodology II
### Gradeigh Clark

Solutions to Assignment 2 for Programming Methdology I, 2018.

# Problem 1 - Digit-Key Sorting (Or: Radix Sort)
Implement a radix sort and demonstrate a run-time that is approximately linear -- O(k*N).
First solution -- O(N) extra space.
* Use a set of queues, bounded by the number of digits in base-10.
* Enqueue numbers from the array onto digit queues and push them off when done.
* Do this as many times as the number of digits in the largest number

The second solution requires O(1) extra space.
* This works by creating two arrays equal to the size of the number of digits in base 10. 2*10 = 20.
* In the first array, loop over the numbers to be sorted and count how many of each digit appears.
* In the second array, keep track of what position we should be inserting digit numbers at. position[i]= position[i-1]+count[i-1].
* Then, loop over the array and do in-place swaps while incrementing the positional counters.


# Problem 2 - In-place MergeSort
Problem is to implement mergesort that executes in-place and does not use O(N) extra space. 
We need to eliminate the copy to the auxiliary array and work inside the given array instead.
Solution:
* Shift the array in chunks every time we need to make a swap.
* We store three values for every chunk: the left end point, the right end point, and a value to hold the swap.
* We swap forward until we hit the right endpoint.
* When swapping is done, place the initial right endpoint at the left, and we accomplish the swap.
* It is similar to a 3-way quicksort.

The downside is that this solution will run quadratic in the worst case -- a sorted array. This is like quicksort as well.

# Problem 3 - 3-way Quicksort on a Linked List
Implement 3-way quicksort on a linked list while shuffling the LL.
Solution:
* Copy the quicksort code from the Sedgewick book.
* Copy the ArbitraryQueue data structure from HW1, which is a linked list.
* Switch the array references with Traverse indexes from the ArbitraryQueue API.



# Problem 4 A - Min and Max Arrangement
The problem is to arrange an array of random numbers into a {min max min ...} arrangement, where max > min on both sides.
Solution:
* Find the maximum value out of a set of 3: i-1,i, and i+1.
* Place the maximum in position i if it isn't already.
* Increment i by 2.
This solution runs O(N) time. An alternative is to sort the array and just swap adjacent values. That would be linearithmic and sub-optimal.

