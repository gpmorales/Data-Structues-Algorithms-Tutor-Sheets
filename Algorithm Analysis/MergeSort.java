class MergeSort<Key extends Comparable<Key>>{
// We will be analyzing algorthims that work on the principle of MERGING,
// specifically by combining two sorted arrays to make one large sorted array
//
// ***** THIS VERSION OF MERGE SORT IS KNOWN AS TOP-DOWN SORT *****
// This is because we conside the whole Array initially as a whole,
// we thne break the array down, cutting it in half, then cut that sub array in half,
// essentially breaking up a large problem into many small ones that are easier to solve
//
// This implementation is faster than other elementary algorithms -> with the WORST CASE having O(nlogn) time complexity
// O(nlogn) < O(n^2)
//
// Merge Sort using recursion and splits array in half -> creating a tree of subarrays which gets sorted when we reach singly elemented Sub Arrays
//
// // MERGESORT RECURSIVE IN PLACE ABSTRACT VISUALIZATION     Big O(N) complexity:
//      [ .... .... .... .... N .... .... .... .... ]             1 * O(N) (1 Array of N items)
//                 /									   \												
//      [ ....... N/2 ......]    [....... N/2 ...... ]						2 * O(N/2)
//          /           \           /           \
//    [.. N/4 ..] [.. N/4 ..]    [.. N/4 ..] [.. N/4 ..]          4 * O(N/4)
//     /       \   /       \      /       \   /       \
//   [N/8]  [N/8] [N/8] [N/8]   [N/8]  [N/8] [N/8]  [N/8]         8 * O(N/8)
//     .      .     .     .       .      .     .      .
//     .      .     .     .       .      .     .      .
//    [ ]    [ ]   [ ]   [ ]     [ ]    [ ]   [ ]    [ ]          N * O(1)
//
//  *** O(N) = N * Log(N) for all cases ***
//
//  Analyzing Comparisons
//  C(N) = Comparisons(N)
//  C(0) = C(1) = 0 -> We perform 0 comparisons for a singular element/no element
//	Using the recursive relation we know that to
//
//	For C(N) = C(lowerBound[N/2]) + C(upperBound[N/2]) + N  ( i.e N = 11, 11/2 = 5.5 )
//	- Comparisons in left subarray + right subarray + comparisons to Merge arrays
//
//  If we let N = 2 ^ n,  then lower(N/2) = upper(N/2) = 2^n/2 = 2 ^ n - 1 for all N
//
//  Hence C(2^n) = C(2^n-1) + C(2^n-1) + 2^n
//
//
// *** ALGORITHM PSEUDO-CODE ***
// Using recursion, this method takes on the following tree of instructions
// Sort(a[N])  -> First call
//	 Sort(a[0 , N/2]) ->First Sort left subArray call
//	 Sort(a[M/2 , N]) ->First Sort Right subArray call
//	 Merge(arr, a[N/2,N], a[0,N/2]) -> first Merge (last one in recursion tree)
//
//	 Sort(a[0 , N/2]) - Left Final Subarray
//			Sort(a[0 , N/4]) -> Sort left SubArray
//			Sort(a[N/4 , N/2]) -> Sort Right SubArray
//			Merge(arr, a[0 , N/4], a[N/4 , N/2]) -> First Half sorted
//
//	 Sort(a[N/2 , N]) - Right Final Subarray
//			Sort(a[N/2 , 3*N/4]) -> Sort left SubArray
//			Sort(a[3*N/4 , N])   -> Sort Right SubArray
//			Merge(arr, a[N/2 , 3*N/4], a[3*N/4 , N]) 
//
//			.
//			.
//			.
//
//	  Sort(a[0,1]) //Until Array has length of 2
//			Merge(arr, a[0] , a[1])
//
//	  Sort(a[1,2])
//			Merge(arr, a[1], a[2])
//
// ***** THIS VERSION OF MERGE SORT IS KNOWN AS TOP-DOWN SORT *****
// This is because we conside the whole Array initially as a whole,
// we think break the array down, cutting it in half, then cut that sub array in half
// breaking up a large problem into many small ones that are easier to solve
//

	private Key[] TempArray;

	private void AbstractMergeSort(Key[] arr)
	{
		int N = arr.length;
		if( N < 2) return;

		int Mid = N/2;
		Key[] leftSubArr = arrayOfSize(Mid);
		Key[] rightSubArr = arrayOfSize(N - Mid);

		for(int i = 0; i < Mid; i++){
			leftSubArr[i] = arr[i];
		}

		for(int j = Mid; j < N; j++){
			rightSubArr[j - Mid] = arr[j];
		}
		//Divide and conquer alogrithm
		AbstractMergeSort(leftSubArr); //Sort Left element/subarray
		AbstractMergeSort(rightSubArr); //Sort Right element/subarray
		Merge(arr, leftSubArr,rightSubArr); // Merge left and right element/subarrays into a temp sorted array
	}


	private Key[] arrayOfSize(int len) //Creates an auxilary array
	{
		TempArray = (Key[]) new Comparable[len];
		return TempArray;
	}


	private void Exchange(Key[] arr, int a, int b) //Exchanges two entries, swaps until is in correct place, used in Insertion Sort
	{
		 Key temp = arr[a];
		 arr[a] = arr[b];
		 arr[b] = temp;
	}


	private void Merge(Key[] arr, Key[] Left, Key[] Right) //This is an in-place Merge() method that works with 3 arrays
	{
		int i = 0; //left el pointer
		int j = 0; //right el pointer
		for(int k = 0; k < arr.length; k++)
		{
			if( i > Left.length - 1 ) //If left elements are exahusted, take from right array
			{
				arr[k] = Right[j++];
			}

			else if( j > Right.length - 1) //if Right array elements are exhausted take from left array
			{
				arr[k] = Left[i++];
			}


			else if( Right[j].compareTo(Left[i]) < 0 ) //Otherwise if the current Right key is smaller than the Left, insert Right
			{
				arr[k] = Right[j++];
			}

			else{ //Else the left key is the one we should take
				arr[k] = Left[i++];
			}
		}
	}

	private void printArray(Key[] arr)
	{
		for(int k = 0; k < arr.length; k++){
			System.out.print(arr[k] + " ");
		}
	}
		
	public static void main(String[] args)
	{

		MergeSort<Integer> merg = new MergeSort<Integer>(); //Object instantiation, can not use Class instance since Key and Comparable are classes w non static members
		Integer[] input = {1, 32 ,54 ,2, 10, 12, 23,-1, 23, 3 , 32, 9, 99, -12};

		//merg.AbstractMergeSort(input);

		/*
		Integer[] L = {5};
		Integer[] R = {3};
		Integer[] A = {0,0};
		merg.Merge(A, L, R);
		*/

		System.out.println();

		merg.BottomUpMergeSort(input);

		merg.printArray(input);

	}


// ****** -BOTTOM-UP MERGE SORT- ******
// When we merge the two final subarrays in Top-Down merge, the truth is that most of our merges occur with the much smaller subarrays
// that are found after many recusive calls, as seen in the bottom of our Recursive diagram where we merge 2 elements into a sub array
// and then that subarray with another sorted subarray
//
// Instead of performing our merges as we build our subarrays back up into our finally sorted array
// We can do a pass on the whole array of tiny subarrays and merge them
// Then do a second pass to merge those subarrays
// And so forth until we perform a merge with the whole array
//
// Pass Initial = 1-by-1 merges
// 2-by-2 merges
// 4-by-4 merges
// Consists of subarrays of the same size

	private void BottomUpMergeSort(Key[] arr)
	{

		int N = arr.length;
		for(int sz = 1; sz < N; sz = sz + sz) //Each pass increases the size of our subarrays
		{
			for(int lo = 0; lo < N - sz; lo += sz + sz) //When our subarray
			{
				merge(arr, lo , lo + sz - 1 , Math.min(lo + sz + sz - 1, N - 1));
			}
		}
	}


	private void merge(Key[] arr, int lo, int mid, int hi)
	{
		Key[] aux = (Key[]) new Comparable[hi + 1];
		//System.out.println(lo + " " + mid + " ");

		for(int k = 0; k <= hi; k++)
		{
			aux[k] = arr[k];
		}

		int i = lo;  //left side
		int j = mid + 1; //right side
		for(int k = lo; k <= hi; k++)
		{
			if( i > mid ) //If the left key is exhausted
			{
				arr[k] = aux[j++]; //take from right sub array
			}

			else if( j > hi ) //If the right key is exhausted
			{
				arr[k] = aux[i++]; //take from left sub array
			}

			else if( aux[j].compareTo(aux[i]) < 0 ) //If right sub array is smaller than left, take right el
			{
				arr[k] = aux[j++];
			}

			else 
			{
				arr[k] = aux[i++];
			}
		}
	}

}
