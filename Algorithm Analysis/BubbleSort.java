class BubbleSort<Key extends Comparable<Key>>{
	// Bubble Sort uses an analgous form of sorting as described below:
// The largest bubbles reach the surface first. I.O.W The Largest Entry will reach its
// correct final position first, then the Second Largest Entry will reach its final position
// and so forth until the Array is sorted!
// 
//************ O(n) Time Complexity => Best Case -> Worst Case -> Average Case -> Number of Comparisons, Number of Exchanges *************
//
// Let us determine how long it takes to sort the worst case scenario, a inversly ordered array of elements that requires the complete traversal subarray
//
// WORST CASE:
// Key1 Key2 Key3 .....
// [ 6 , 5 , 4 , 3 , 2 , 1 ]  //Assume key1 is already sorted
// 
//                                 (Key)   (Comparison = ^)  (Exchanges = ^)    Total:
//         ^   ^   ^   ^   ^
// [ [ 6 ] , 5 , 4 , 3 , 2 , 1 ]     -           5         +        5             10
//
//         ^   ^   ^   ^   
// [ [ 5 ] , 4 , 3 , 2 , 1 , 6 ]     -           4         +        4             8
//
//         ^   ^   ^
// [ [ 4 ] , 3 , 2 , 1 , 5 , 6 ]     -           3         +        3             6
//
//         ^   ^   
// [ [ 3 ] , 2 , 1 , 4 , 5 , 6 ]     -           2         +        2             4
//
//         ^
// [ [ 2 ] , 1 , 3 , 4 , 5 , 6 ]     -           1         +        1             2
//
//  IN our worst case, to sort a given Key N = (N-1) comparisons + (N-1) exchanges = 2 * SumOf( n - 1, N, 1) 
//  = 2( 1 + 2 + ... + N-3 + N-2 + N-1) = 2( N(N-1)/2 ) <- Summation Formula SumOf(n , N to 1) = n(n+1)/2
//  = N(N-1) = N^2 - N => O(N^2) <- WORST CASE RUNTIME in BigO notation
//
//
//  BEST CASE:
//  - No swapping or movement needed
//
//                                 (Key)   (Comparison = ^)  (Exchanges = ^)    Total:
//         ^   ^   ^   ^   ^
// [ [ 1 ] , 2 , 3 , 4 , 5 , 6 ]     -           5         +        0             5 = (N-1) comparisons
//
// N-1 => O(N) for BEST CASE using Bubble Sort
//
// IN our best case, no exchanges are necessary and a total of N comparisons are required
// So for a given Key N -> there are a total of N - 1 Comparsons and 0 exchanges
//
//

	private void bubbleSort(Key arr[]){
		int N = arr.length;
		int count = 0;
		int i = 1;
		while( i < N){ //Start by comparing first two terms // while(array not sorted), excess
			for(int j = 0; j < N - 1; j++){
				if(arr[j].compareTo(arr[j+1]) > 0){
					count++;
					Exchange(arr, j+1, j);
					PrintArr(arr);
				}
			}
			i++;
		}

		System.out.println("The total number of exchanges: " + i);
	}

	private void Exchange(Key arr[], int x, int y){
		Key temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	private void PrintArr(Key arr[]){ //Helper Method
		System.out.println();
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args){ //Driver Code
		BubbleSort<Integer> example = new BubbleSort<Integer>();

		Integer[] input = { 13, 43, 23, 1 , 4 , 5 , 6, 3 , 12 };
		// {1, 4, 5, 6, 3, 12}
		//  I
		// {1, 4, 5, 6, 3, 12}
		//
		// {1, 4, 5, 6, 3, 12}

		example.bubbleSort(input);
		//example.PrintArr(input);

	}

}
