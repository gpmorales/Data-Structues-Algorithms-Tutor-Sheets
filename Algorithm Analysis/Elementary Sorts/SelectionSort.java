class SelectionSort{
	//Perhaps the simplest sorting algorithm
	// 1) First find smallest item in Array and exchange it with the FIRST entry
	// 2) Find the second smallest item and exchange it with the SECOND entry
	// 3) Repeat this until the Array is sorted

//This method is called Selection Sort because it works by repeatedly selecting the smallest item ***
//
// ***** O(n) Time Complexity => Best Case -> Worst Case -> Average Case -> Number of Comparisons, Number of Exchanges *****
//
// Let us determine how long it takes to sort the worst case scenario, a inversly ordered array of elements that requires the complete traversal subarray
//
// WORST CASE:
// Key1 Key2 Key3 .....
// [ 6 , 5 , 4 , 3 , 2 , 1 ]  // Assume key1 is already sorted
//
//                                 (Key)   (Comparison = ^)  (Exchanges = ^)    Total: 
//         ^   ^   ^   ^   ^                              
// [ [ 6 ] , 5 , 4 , 3 , 2 , 1 ]     1           5         +        1          (n - 1)
//
//		         ^   ^   ^   ^                              
// [ 1 , [ 5 ] , 4 , 3 , 2 , 6 ]     2           4         +        1          (n - 2)

//							   ^   ^   ^
// [ 1 , 2 , [ 4 ] , 3 , 5 , 6 ]     3           3         +        1		       (n - 3)

//                     ^   ^
// [ 1 , 2 , 3 , [ 4 ] , 5 , 6 ]     4           2         +        0				   (n - 4)

//                         ^
// [ 1 , 2 , 3 , 4 , [ 5 ] , 6 ]    N-1          1         +        0				   (n - 5)

//
// 
//  IN our worst case, to sort a given Key N  = (N - 1) + (N - 2) + (N - 3) + ... + 3 + 2 + 1 comparisons
//
//  // Algebra :
//  // This is equivalent of the above: (N - 1 + 1) + (N - 2 + 2) + (N - 3 + 3) ... + (N - N/2) <- no constant to pair with
//  // In otherwords we have: N + N + N .... + N - N/2 
//
//  // Since we have N/2 terms that are N's and one N/2 term which we could subtract one from and dsitrbute it amongst each term as there are N/2 terms
//  // (N - 1) + (N - 1) + (N - 1) + .... + (N - 1) a total of N - 2 times = (N - 1)*(N/2) 
//    = N(N-1)/2 = N(N-1) = N^2 - N => O(N^2) <- WORST CASE RUNTIME in BigO notation
//
//  // Our AVERAGE CASE is (Worst Case + Best Case) / 2 = (2*N^2) / 2 = O(N^2)
//
//  BEST CASE:
// IN our best case, no exchanges are necessary and each Key still requires N(N-1)/2 ~ N^2/2 Comparisons
// So for a given Key N -> O(N^2) => BEST TIME
//



	public static void sort(Integer[] arr){
		//We will sort arr into increasing order
		for(int i = 0; i < arr.length; i++){
			Integer min = i; //keeps track of index 1
			for(int j = i + 1; j < arr.length; j++){ //parse every el after first one (we continue exchanges after the 1st, 2nd, 3rd...)
				if(arr[j] < arr[min]){ //compare first el w/ every el afterwards 
					min = j; //update index of min val
				}
			}
			//Exhange the current entry (smallest one)
			Exchange(arr, i, min);
		}
	}

// Selection sort uses ~N^2/2 comparisons and N exchanges to sort an Array of length N
// This can be observed in an N by N table where LOWERCASE letters correspond to compares
//
	//              arr[i]
	// i  min  0 1 2 3 4 5 6 7 8 9 10
	//				 S O R T E X A M P L E		
	// 0   6   S O R T E X a M P L E   <- arr[min] = A (we lowercase it)
	// 1   4   a O R T e X S M P L E
	// 2  10   a e R T O X S M P L e
	// 3   9   a e e T O X S M P l R
	// 4   7   a e e l O X S m P T R
	// 5   7   a e e l m X S o P T R
	// 6   8   a e e l m o S X p T R
	// 7  10   a e e l m o p X S T r
	// 8   8   a e e l m o p r s T X
	// 9   9   a e e l m o p r s t X
	//10  10   a e e l m o p r s t x
	
	
	public static void Exchange(Integer[] arr, int i, int j){ //Simple Alogrithm to exchange 2 elements in array
		if(i != j){ //If the indeces are the same, we don't need an exchange
			arr[i] = arr[i] + arr[j]; //a -> a + b
			arr[j] = arr[i] - arr[j]; // b -> a+b - b = a
			arr[i] = arr[i] - arr[j]; // a+b - a = b
		}
	}

	public static void printArray(Integer[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}


	public static void main(String[] args){
		Integer[] input = new Integer[]{2,1,0,3,5,8,-2};
		sort(input);
		printArray(input);

	}







}
