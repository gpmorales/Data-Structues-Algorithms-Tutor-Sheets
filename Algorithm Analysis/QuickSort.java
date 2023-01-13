class QuickSort<Key extends Comparable<Key>>{
// Quick Sort is a divde-and-conquer alogrithm which is powerful due substantially faster performance time,
// ability to work well with a diverse set of data types, ands it facile implementation
//
// Quick sorts works by partitioning a whole array and then sorting the partitoned sections
// which are then sorted individually.
// This is not a stable algorithm but it is recursive AND takes O(log(N))
//
// Complementary to MergeSort, in Quick Sort we rearrange the array about a pivot, dividing it into two
// sections. We then rearrange these 2 Sub sections such that they are sorted, the Whole array is ordered!
//
// Input:
// K R A T E L E P U I M Q C X O S
//
// Partition:
//				    * <- Pivot
//  E C A I E K L P U T M Q R X O S
//Not greater |  Not smaller
//
// Sort Left:
//  A C E E I |
//
// Sort Right:
//					  | L M O P Q R S T U X
//
// Merge:
//  A C E E I |K| L M O P Q R S T U X
//
//  *** ARRAY SORTED***
//

	private void QuickSort(Key[] arr, int lo, int end)
	{
		if( lo < end)
		{
			int pivot = Sort(arr, lo, end); //returns index of our pivot
			QuickSort(arr, lo, pivot - 1); //Sort left half first up to pivot
			QuickSort(arr, pivot + 1, end); //Sort right half, everything after pivot 
			//Repeat until sorted
		}
		return; //Terminates recurisve call
	}

	// Our pivot satifies three conditions
	// -> Pivot is in correct position in final sorted array
	// -> All items to the left of the pivot are smaller
	// -> All items to right of the pivot are greater


	private int Sort(Key[] arr, int lo, int end) //Method partitions an Array into sub array w pivot...
 // which has all greater values to its right, and all smaller values located to its left 
	{
		int Oldpivot = end; //Our old pivot is located in the last entry of the subarray
		int LeftWall = lo - 1; // item that is LARGER than Oldpivot from left portion of array
		for(int i = lo; i < end; i++) //Parse up to the Pivot
		{
			if(arr[i].compareTo(arr[Oldpivot]) < 0) //If the current obj is smaller than the old pivot, it is not our Left Wall
			{
				LeftWall++;  //Keep incrementing so we can swap the LeftWall
				Exchange(arr, i, LeftWall); //move leftwall to the right, closer to pivot
			}
		}

		LeftWall++; //finally increment this so its on right side of the rightWall ( number smaller than Pivot)
		Exchange(arr, LeftWall, end); //Exchange Leftwall and pivot ->  
		return LeftWall;
	}

	private void Exchange(Key[] arr, int i, int j)
	{
		Key temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void PrintArray(Key[] arr)
	{
		for(int j = 0 ; j < arr.length; j++)
		{
			System.out.print(arr[j] + " ");
		}
	}

	public static void main(String[] args)
	{
		QuickSort<String> driver = new QuickSort<String>();

		String[] input = { "Q", "E", "A", "T", "S" , "C" , "R" , "X", "G", "B" };

		int end = input.length - 1;
		driver.QuickSort(input, 0, end); 

		//driver.PrintArray(input);

	}

}
