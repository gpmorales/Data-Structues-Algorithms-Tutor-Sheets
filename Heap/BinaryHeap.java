import java.lang.Math;
class BinaryHeap<Key extends Comparable<Key>>{
	/* A BINARY HEAP is a Binary Tree which satisfies the follwing two properties 
	 * 1) Heap-Order -> The parent's key is ALWAYS Greater OR Equal to its Children's Key | 
	 * 2) Complete Binary Tree -> All levels are completely filled except possibly the last level has ALL keys LEFT as possbile
	 *    - Children are inserted Left -> Right
	 * 
	 * EXAMPLE: Min Heap
	 *
	 *       [10]                [10]
	 *       /  \                /  \
	 *    [20]  [100]        [15]    [30]
	 *    /                  /  \    /  \
	 * [30]               [40] [50] [90] [40]
	 *
	 *
	 * EXAMPLE: Max Heap
	 *
	 *       [17] <- Root holds largest key in heap-ordered binary tree
	 *       /  \
	 *    [15]   [10]
	 *    /  \    /
	 *  [6] [10] [7]
	 *
// A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an ARRAY
// - The root element will be at Arr[0]
// - For the i-th node we use the following formula to traverse our Array
// - Arr[(i-1)/2] Returns the parent Node of the i-th Node
// - Arr[(2*i) + 1] Returns Left Child of the i-th Node
// - Arr[(2*i) + 2] Returns Right Child of the i-th Node
// Ex: For the 4th Node: 9, its parent is found at index = 4-1/2 = 1 , or 3
	 *       
	 *        [1] (0)
	 *       /   \
	 * (1) [3]   [6] (2)
	 *    /  \   /
	 *  [5] [9] [8]
	 *  (3) (4) (5)
	 *
	 *   [ 1 | 3 | 6 | 5 | 9 | 8 ]
	 * i : 0   1   2   3   4   5
	
// Definition -> A Binary Tree is HEAP ordered if the key in each Node is LARGER than or Equal ********
// to the keys in that Node's two Children *******
// * Equivalently, the key in each node of a Heap-ordered binary tree is SMALLER than or equal to the key in that Node's parent
// ** The largest key in an a heap ordered binary tree is found at the Root
	
// DEFINITION -> A Binary Tree is a collection of keys arranged in a complete heap-ordered binary tree,
//  represented in a Level Order array (Not using the first entry


// ***TRAVERSING A HEAP***
// Given some Node in position K in our Heap/Array, the Parent of this Node is found in position K/2
// Conversely, the Left Child of this Node in position K is found at 2*K , EX: For the 2nd Node: 6 -> at position 5 is its left child, 8, as seen in the array 
// The Right Child is found at position 2*K + 1
// ***********
// Hence to move upwards in a heap / to the parent node, we simply perfrom Arr[k] -> Arr[k/2]
// To move down the tree, either left or right, we simply do Arr[k] -> Arr[2*k] | Arr[2*k + 1]


// ******************* INSERTION/DELETION + HEAPIFYING *****************
// When we insert a new Node into our Heap or update the value of an existing Node, there is a chance that our heap order is violated,
// for example, a Node is inserted at the bottom that holds a larger value than its parent, or some other Node's value is increased
// This will violate heap order -> there are two cases of this type of violation
//
// Swim() / Bottom-Up ReHeapify => IF heap order is violated because a Node's key is LARGER than its parent, then we EXCHANGE this Node
// with its parent. If this restores order, then we are done. Otherwise we must continue exchaning this node until both the old parent
// and the other child are smaller than the moved Node and the Node itself is smllaer than its new Parent, Swimming Upwards
//
// Sink() / Top-Down ReHeapify => IF heap order is violated becuase a Node's key becomes SMALLER that one or both of its Child's key
// then we can exhange this Node with the LARGER of its two Children, 'sinking' it down until its new parent is larger or equal */


// OUR API - Application Programming Interface:

private Key[] HeapArray; //Our Heap Array declaration
private int N = 0; //Pointer for insertion in our Heap Array;

@SuppressWarnings("rawtypes")
private BinaryHeap(int Max){ //Constructor
	HeapArray = (Key[]) new Comparable[Max + 1]; //intialization of our heap array
}

private boolean isEmpty(){ return N == 0; } //Helper method, returns false is Array is empty / pointer is at first index

private int size(){ return N; } //Helper method returns size of our Heap

private void Exchange(int i, int j){ //Helper methods wich will allow us to implement a more seamless API for our Heap
	Key temp = HeapArray[i];
	HeapArray[i] = HeapArray[j];
	HeapArray[j] = temp;
}

private boolean lessThan(int i, int j){ //Compares to Keys/ Letters using Comparable interface
	if(HeapArray[i].compareTo(HeapArray[j]) < 0){
		return true;
	}
	else{
		return false;
	}
}

private void insert(Key input){
	HeapArray[++N] = input; //Insertion of a new item in our Heap occurs at the last level / end of array
	Swim(N); //We must 'swim' our item to its correct position (parent must be larger that its children)
}

private void Swim(int k){ // Our Swim method will exchange a larger Child and its parent until heap order is restored
	while( k > 1 && !lessThan(k, k/2)){ //if our input Node is larger than our parent, exchange it with the parent until Heap order is restored
		Exchange(k/2 , k); //Exhange the parent node with its child
		k = k/2; //The K we will use to make our comparisons will be at the parents position
	}
}

private void Sink(int k){ //Our Sink Method will exchange a smaller Parent with the LARGER of its two Children
	while( 2*k <= N ){ //We dont want to sink our item past the most left-most child on the final level or our Heap
		int j = 2*k; //Check left Child first
		if( j < N && lessThan(j , j + 1 ) ){ //We must exchange parent with larger of our two children
			j++; //If left child is less than right, we go to position of right child
		}

		if( lessThan(j,k) ){ //If either child is less than our parent, heap order is maintained and no exhanges are needed
			break;
		}

		Exchange(j, k); //Exchange current Node k (parent) with j (left or right child)
		k = j; //Our input is now the current child node, and we keep sinking until we restore order
	}
}

private Key deleteMax(){ //Method deletes root our heap and exhanges the last element with it
	Key Max = HeapArray[1]; //Retrieve root of heap in temo var
	Exchange(1,N--); //Exchange root of heap with last element
	Sink(1); //Restore heap order by sinking the new Root
	return Max; //return our max key which was saved in the var Max
}

private void Print(){ //Method to print contents of our Heap
	for(int i = 1; i <= N; i++){
		if(HeapArray[i] == null){
			System.out.println(null);
		}
		else{
			System.out.println(HeapArray[i] + " ");
		}
	}
}
	
public static void main(String[] args){
	BinaryHeap<String> Heap = new BinaryHeap<String>(20); //Object from our Binary Heap class is instantiated

	Heap.insert("T");
	Heap.insert("S");
	Heap.insert("R");
	Heap.insert("A");
	Heap.insert("X");
	Heap.insert("B");
	Heap.insert("F");
	Heap.insert("C");
	Heap.insert("P");
	Heap.insert("L");
	Heap.insert("Y");

	//Heap.HeapSortAlt();

	//Heap.printHeap();
	String[] input = {"","S","O","R","T","E","X","A","M","P","L","E"};

	Heap.HeapSort(input);

	System.out.println();


	}

//*********SORTING ALGORITHMS*********
// HEAP SORT IS a comparison-based sorting technqiue based on the Binary Heap data structure
// Similar to Selection Sort, where we first find the minimum/maximum element, place it in the beginning of our array,
// While Removing it from our search
//
//
// Heapify() -> a method which builds a Binary Heap from a Binary Tree using an array abstraction
// We either create Min or Max heaps from this Recurisve Algorithm
	private void HeapSort(Key[] arr){
		int Len = arr.length;
		for(int i = Len/2; i > 0; i--){ //Len/2 gives us the last NON-Leaf Node
			Sink(arr, i, Len); //Heapifys by properly sinking all the parents of the non-leaf nodes
		}
		//Builds Max Heap by heapifying each litte subtree from the last Subtree (len/2) to the Root by Sinking and rearranging elements

		int N = Len--; //Our pointer will start at last element
		while(N > 0){  //This swaps the Root (Max) el, with the last one, then performs the Heapify/Sink() operation to restore heap order
			Swap(1, N--, arr); //Swap the max root with last el, move the Pointer to next to last el
			Sink(arr, 1, Len); //Sink new root to maintain Heap order
		}

		//Prints out our Array 
		System.out.println();
		for(int i = 1; i < arr.length; i++){
				System.out.print(arr[i] + " ");
		}
	}

	private Key[] HeapSortAlt(){ //Alternative HeapSort algo using deleteMax() method and a 2nd array - assumes Tree is Max Heap
		Key[] ge = (Key[]) new Comparable[N+1];
		System.out.println();
		for(int i = ge.length - 1; i >= 0; i--){
			ge[i] = deleteMax();
		}
		
		for(int i = 0; i < ge.length; i++){
			System.out.print(ge[i] + " ");
		}

		return ge;

	}

	private void printHeap(Key[] Array){ //Prints our Array in a Tree like manner
		System.out.println(Array.length);
		int Q = (int) Math.floor(Math.log10(Array.length)/Math.log10(2));
		for(int i = 0; i <= Q; i++){
			for(int j = (int)Math.pow(2,i); j < (int)Math.pow(2,i+1) && j != Array.length ; j++){
				System.out.print(" ");
				System.out.print(Array[j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private void Sink(Key[] arr, int k, int Len){ //Our Sink Method will exchange a smaller Parent with the LARGER of its two Children
		while( 2*k < Len){ //We dont want to sink our item past the most left-most child on the final level or our Heap
			int j = 2*k; //Check left Child first
			if( j < arr.length - 1 && arr[j].compareTo(arr[j + 1]) < 0 ){ //We must exchange parent with larger of our two children
				j++; //If left child is less than right, we go to position of right child
			}

			if( arr[j].compareTo(arr[k]) < 0 ){ //If the child is smaller we are good
				break;
			}

			Swap(j, k, arr); //Exchange current Node k (parent) with j (left or right child)
			k = j; //Our input is now the current child node, and we keep sinking until we restore order
		}
	}

	private void Swap(int i, int j, Key[] array){ //Method to exchange keys
		Key temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
