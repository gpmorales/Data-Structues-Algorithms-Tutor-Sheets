import java.util.ArrayList;
import java.util.Arrays;
public class ArrayOverview{
	//Array : data strcuture that stores a sequence of values that are the same type
	//***once an array is initialized, its dimensions cannot be altered nor can one add or remove elements!
	public static void main(String[] args){
		//INITIALIZATION:
		//DataType[][] ArrayName = new DataType[][];
		//Obj[] objArray = new Obj[100];
		
		int[] Arr = new int[5]; //initializes a 1-D int array w 5 elements (empty atm, sotes default value of 0)
		int[] Arr1 = {10,11,12,16,18,23,29,33,48,54,57,68,77,84,98}; //Another way to initialize an array

    double[][] z1 = new double[][]{{1.2, 2.0,3.40,9.91}, //Initialization of a 2-D double Array
                                   {12.3, 44, 4, 7},
                                   {1.0, 1.1, 3.6, 0.67},
                                   {1.11, 1.22, 1.34, 6.1}};

		//ARRAY LENGTH:
		int L = Arr.length; //the length of an array is given by the field '.length'

		//ACCESSING ELEMENTS:
		//Array elements are accessed using their index, which starts at 0, (i = 0, i = 1....)
		System.out.println(Arr1[5]);  //prints '23'


		//SEARCHING AN ARRAY ---->
		
		//---Linear Search---  traverse through array from the first element until we reach the final element, looking for  a 'key'
			//Linear Search Cost:
				//BEST CASE: 1 step (the proceeding element IS the key)
				//WORST CASE: N steps 
				//AVERAGE: N/2 

		//---Binary Search---  in an ORDERED Array, each step eliminates half the array until the key is found 
			//Binary Search Cost:
				//BEST CASE: 1 step (the proceeding element IS the key)
				//WORST CASE: log(N) 


		//IMPLEMENTATION OF BINARY SEARCH IN 1-D ORDERED ARRAY***
		System.out.println(indexOf(Arr1, 77)); //returns the index value of the specified key element we are trying to find in our ordered Array

		System.out.println();

		//TEST METHOD
		System.out.println(ArrayTransfer(z1));
		}

	
		//BINARY SEARCH METHOD (parses thru int array to find a key element)
		public static int indexOf(int[] array, int key){
			//key is in a[low...hi] or not present
			int low = 0; //index of first element
			int hi = array.length - 1; //index of last element
			
			while(low <= hi){ 
				 int mid = low + (hi - low)/2; //this gives us the middle index value for that particular search
					 if(key < array[mid]){ //if our key is less than the middle element (our array is ordered)...
						 hi = mid - 1; //...then we shift our upper bound to be the element right beofre the middle one, cutting our array in HALF
					 }

					 else if(key > array[mid]){//if our key is greater than the middle, we need to parse thru the top/upper HALF of the ordered array
						 low = mid + 1; //make the lower search bound the element proceeding the middle term
					 }

					 else{ //otherwise the middle term is the key element and we return it
						 return mid;
					 }
			}

			return -1; //if our Binary Search fails to find the key term, then return -1, indication that term is not present in Array

		}


		//this method transfers all the contents of an array to an ArrayList, and then returns the list to the main method where it is printed in the terminal
		public static ArrayList<Double> ArrayTransfer(double[][] arr){
		ArrayList<Double> DoubList = new ArrayList<>(); //Initialization
			for(int row = 0; row < arr.length; row++){
				for(int col = 0; col < arr[row].length; col++){
					DoubList.add(arr[row][col]);
				}
			}
			return DoubList;
		}

}
