class InsertionSort<Key extends Comparable<Key>>{
	//Insertion Sort works by inserting an element into leftside in its proper place from elements on the right side
	//-> Orders a subset of the array as it traverses the whole array
	// ALGORITHM
	// 1) Examine item N-y
	// 2) Insert item N-y into its proper place in the subArray of item 0 -> item N - (y-1)
	//  * N = array size, y = arbritrary cte
	// 3) [0, ... , N - (y-2), N - (y-1)][N - y]
	//				SubArray -^                   ^- Current Item
	// 4) Swap N - y with each item to its left in the subarray starting at N - (y-1) until its in its correct place

	// ******* Insertion Sort Algorithmic Analysis -> Types of arrays we can apply this algorithm and WHY ********
	// Unlike Selection Sort, the runnning time of Insertion Sort depends on the initial order of the items in the input
	// Insertion Sort works better than Selection sort in a situation where there is a large input array are
	// nearly or relatively in order, it performs much faster if entries are randomly inserted
	//
	// Partially Sorted Arrays:
	// The concept of a PSA follows this mathematical notion: An inversion is a pair of entries that are out of order in the Array
	// ex: EXAMPLE => Has 11 inversions => E-A, X-A, X-M, X-P, X-L, X-E, M-L, M-E, P-L, P-E, L-E
	// If the number of inversions in an array is less than a constant muiltple of the array size, we say the array is partially sorted
	// NumOf(Inversions) < k * Array.length
	//  
	//  Typical examples of Partially Sorted Arrays:
	//  - An array where each entry is not far from its final position
	//  - A small array appended to a large sorted array
	//  - An array with only a few entries that are not in place
	//
	//***** For Alogrithmic Analysis -> O(n) serves as a function to analyze time and space with an algorithms runtime *****
	//  -> Consider infinite limits and how we approach them analytically
	//  -> Constants are ignored -> 5n = O(n)
	//  -> Faster-Growing Terms dominate -> N^2 + N = O(N^2)
	//
	//************ O(n) Time Complexity => Best Case -> Worst Case -> Average Case -> Number of Comparisons, Number of Exchanges *************
	//
	// Let us determine how long it takes to sort the worst case scenario, a inversly ordered array of elements that requires the complete traversal subarray
	//
	// WORST CASE:
	// Key1 Key2 Key3 .....
	// [ 6 , 5 , 4 , 3 , 2 , 1 ]  //Assume key1 is already sorted
	// 
	//     ^                           (Key)   (Comparison = ^)  (Swaps = ^)    Total:
	// [ 6 , [ 5 ] , 4 , 3 , 2 , 1 ]     2           1         +        1             2
	//
	//     ^   ^
	// [ 5 , 6 , [ 4 ] , 3 , 2 , 1 ]     3           2         +        2             4
	//
	//     ^   ^   ^
	// [ 4 , 5 , 6 , [ 3 ] , 2 , 1 ]     4           3         +        3             6
	//
	//     ^   ^   ^   ^
	// [ 3 , 4 , 5 , 6 , [ 2 ] , 1 ]     5           4         +        4             8
	//
	//     ^   ^   ^   ^   ^
	// [ 2 , 3 , 4 , 5 , 6 , [ 1 ] ]     6           5         +        5             10
	//
	//  IN our worst case, to sort a given Key N = (N-1) comparisons + (N-1) exchanges = 2(N-1) 
	//  This brings the total comparisons/movements to 2(1) + 2(2) + ... 2((N-2) - 1) + 2((N-1) -1) + 2(N-1)
	//  = 2( 1 + 2 + ... + N-3 + N-2 + N-1) = 2( N(N-1)/2 ) <- Summation Formula SumOf(N, k to 1) = N
	//  = N(N-1) = N^2 - N => O(N^2) <- WORST CASE RUNTIME in BigO notation
	//
	//
	//  BEST CASE:
	//  - No swapping or movement needed
	//
	//                                 (Key)   (Comparison = ^)  (Swaps = ^)    Total:
	// [ 1 , [ 2 ] , 3 , 4 , 5 , 6 ]     2           1         +        0             1
	//
	// [ 1 , 2 , [ 3 ] , 4 , 5 , 6 ]     3           1         +        0             1
	//
	// [ 1 , 2 , 3 , [ 4 ] , 5 , 6 ]     4           1         +        0             1
	//
	// [ 1 , 2 , 3 , 4 , [ 5 ] , 6 ]     5           1         +        0             1
	//
	// [ 1 , 2 , 3 , 4 , 5 , [ 6 ] ]     6           1         +        0             1
	//
	// IN our best case, no exchanges are necessary and each Key only requires one comparison
	// So for a given Key N -> there are a total of N - 1 Comparsons and 0 exchanges


	private void insertionSort(Comparable[] inputArr)
	{
		int N = inputArr.length; //IC
		for(int i = 1; i < N; i++){
			for(int j = i; j > 0 ; j--){
				if(inputArr[j].compareTo(inputArr[j-1]) < 0){ //If current key is larger than ANY key in the Left SubArray
					Swap(inputArr, j, j-1); //Swap the key with the key to its Left until Key is in position
				}
			}
		}

		for(int k = 0; k < N; k++){
			System.out.print(inputArr[k] + " ");
		}

	}

	private void Swap(Comparable[] arr, int x, int y){ //Swaps to keys in an array
		Comparable temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}


	public static void main(String[] args){
		Comparable[] input = {12,3,5,7,8,19,0};

		InsertionSort<Integer> in = new InsertionSort<Integer>();

		in.insertionSort(input);

	}
	  

}
