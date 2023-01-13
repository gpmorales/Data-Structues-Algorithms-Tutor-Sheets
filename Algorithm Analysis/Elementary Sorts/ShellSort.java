class ShellSort<Key extends Comparable<Key>>{
	// The Shell Sort Algorithm is a Generalization of Insert Sort
	// As one can guess, Insert Sort performs poorly in large arrays where the smallest key happens to be near or at the end
	// This requires N - 1 Exchanges and Comparisons. This is because we can only swap adjacent key/items, forcing us to traverse the whole array by swapping all entries
	// to the left... However, if we could swap entries that are far apart, we could produce a group of partial sorted subarrays which can then be easily
	// and efficiently sorted. This will increase the speed of our algorithm
	//
	// Implementation-> Run Insertion Sort on a SUB-Array and create a series of h-sorted arrays
	//
	// h = 4
	// 0 1 2 3 4 5 6 7 8 9 10 ...    16
	// L E E A M H L E P S O L T X S R
	// L ----- M ----- P ----- T 
	//   E ----- H ----- S ----- X 
	//     E ----- L ----- O ----- S 
	//       A ----- E ----- L ----- R 
	//
	// There are ways to implement shellsort, such as using insertion sort on
	// each independent subsequence, moving them left or right. However, there is an even simpler method
	// Simply sort each independent array by decrementing by h instead of 1 when performing swaps in each sub array
	//

	private void Exchange(Key[] arr, int x1 , int x2){
		Key temp = arr[x1];
		arr[x1] = arr[x2];
		arr[x2] = temp;
	}

	private void Shellsort(Key arr[]){
		int N = arr.length;
		int h = 4;
		/*
		while( h < N/3 ){  //We want gaps between elements to be intially large
			h = 3*h;
		}
		*/
		while( h >= 1 ){
			for(int i = h; i < N; i++){ //Start at the H element in subArray just like in Insertion Sort where we assume first el is alr sorted so we start w the second one
			// i = h = 4
			//   0					 i													
			// [ 2, 3, 6, 1, 8, 10, 14, 11, 9, 1, 20, 12, 5]
			//   2 --------- 5 ------------ 8 ----------- 9
			//      1 ---------- 3 ----------- 10
			//         6 ---------- 14 ---------- 20
			//            1 ----------- 11 ---------- 12
			//i = h = 2
			//   2 --- 6 --- 5 ---- 14 ---- 8 --- 20 ---- 9
			//      1 --- 1 ---- 3 ---- 11 --- 10 ---- 12
			//
			//   2 --- 5 --- 6 ---- 8 ---- 9 ---- 14 --- 20 
			//      1 --- 1 ---- 3 ---- 10 --- 11 ---- 12
			//
			//i = h = 1
			//   2 1 5 1 6 3 8 10 9 11 14 12 20
			//   1 2 5 1 6 3 8 10 9 11 14 12 20
			//   1 1 2 5 6 3 8 10 9 11 14 12 20
			//   1 1 2 3 5 6 8 10 9 11 14 12 20
			//   1 1 2 3 5 6 8 9 10 11 14 12 20
			//   1 1 2 3 5 6 8 9 10 11 12 14 20
			//   Sorted!
			//
				for(int j = i; j >= h; j-=h){ //Traverse array starting at 2nd sub element,
					//Compare a[i] amongst a[i - 1*h], a[i - 2*h], a[i - 3*h] 
					//        a[j] amongst a[j - h], a[j - 2*h], a[i - 3*h] .... a[0]
					if(arr[j].compareTo(arr[j - h]) < 0){ //If the term beside is Greater, exchange the items until we reach the correction position in subarray
						Exchange(arr, j, j - h); 
					}
				}
			}

			h = h/2; //Decrease the size of the gaps in order to work w smaller more paritally sorted sub arrays -> less distance needs to be mvoed
			//***Eventually h becomes 1 which essentially is insertion sort
		}
	}

	private void printArray(Key[] arr){
		System.out.println();
		for(int i = 1; i < arr.length; i+=4){
			System.out.print(arr[i] + " ");
		}
	}


	public static void main(String[] args){
		ShellSort<Integer> ex = new ShellSort<Integer>();

		Integer[] input = {2, 3, 6, 1, 8, 10, 14, 11, 9, 1, 20, 12, 5};
		ex.Shellsort(input);

		ex.printArray(input);

	}



}
