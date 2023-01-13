class Queue{
	// Queue's, similarly to Stacks, are a linear data structure that SUPPORTS ONLY INSERTION at the END
	// ...and DELETION at the FRONT*****
	//
	//  1. Enqueue() - inserts element at the Tail of the list
	//  2. Dequeue() - removes element from Head of list
	//
	//  *Visualization of a Queue*
	//
	//  Dequeue <-- [ Head ][   ][   ][   ][   ][ Tail ] <-- Enqueue
	//  
	//  KEY NOTES:
	//  - Queues follow the FIRST IN, FIRST OUT rule (FIFO), the first item of the queue is the first to be removed
	//  - The First element of a Queue is referred to as the HEAD
	//  - The Last element of a Queue is referred to as the TAIL
	//
	//  QUEUE DECLARATION & IMPLEMENTATION in JAVA:
	//  - As seen before, we can implement a Queue by storing its contents in an Array OR Linked List (documentation implies using a LL)
	//
	//  JAVA METHODS:
	//

	static int Max = 10;

	int Head = -1;	//Pointer obj for top of list, initially -1 to indicate empty 

	int Tail = -1;	 //Pointer obj for back of list

	int[] arr = new int[Max];

	boolean isEmpty(){
		return (Head == -1 && Tail == -1);
	}

	boolean isFull(){
		return (Tail == Max - 1);
	}

	public static void main(String[] args){
		Queue Q = new Queue();

		Q.Enqueue(16);
		Q.Enqueue(17);
		Q.Enqueue(18);
		Q.Enqueue(19);
		Q.Enqueue(20);

		Q.Dequeue(); //removes 16
		Q.Dequeue(); //remvoes 17
		Q.Dequeue(); //remvoes 18

		Q.Enqueue(21); //adds 21 to tail of list
		Q.Enqueue(22); //adds 22 to tail of list
		

		Q.printQueue();
	}


	public void Enqueue(int data){ //Adds element at tail of list
		if( isEmpty() ){
			arr[++Tail] = data; //increment Tail to be the first index
			Head++; //also increment Head -> [ Head/Tail]
		}

		else if( isFull() ){
			System.out.println("QUEUE IS FULL");
			return;
		}

		else{
			arr[++Tail] = data;
		}
	}


	public void Dequeue(){ //Removes element at Head of list
		if( isEmpty() ){
			System.out.println("QUEUE IS EMPTY");
			return;
		}

		else{
			arr[Head++] = 0; //post increment
		}
	}

	public void printQueue(){ //prints contents of Queue
		if( isEmpty() ){
			System.out.println("QUEUE IS EMPTY - RELEASING FILE RESOURCES");
			return;
		}
		else{
			for(int i = Head; i <= Tail; i++){ 
				System.out.print(arr[i] + " ");
			}
		}

	}

}
