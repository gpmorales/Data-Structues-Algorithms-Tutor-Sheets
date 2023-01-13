import java.util.*;
class StackuQ{ //IMPLEMENTATION OF STACK USING TWO QUEUES
	// Given a Queue which supports Enqueue (insertion at Tail) and Dequeue (deletion at Head of list), create a Stack*****
	// ---> Using Queues q1 and q2, create a Stack 's'
	//
	// METHOD 1: Enqueue element x to Q2, 1 by 1 Dequeue everything fro Q1 to Q2, Swap names of Q1 & Q2
	//   ***This technique ensures that the newly inserted element is always at the front of Q1
	//
	//  Q2               Q1                                      AFTER DEQUE + SWAP:        
	// [  ]             [  ]                                       [  ]      [  ]
	// [  ]             [  ]                                       [x3]      [  ]
	// [  ]        <-   [x2]                                       [x2]      [  ] 
	// [x3]             [x1] *Dequeue elements from Q1 to Q2       [x1]      [  ]   ***NOW REPEAT ALGORTHIM FROM STEP1
	//  ^--Enqueue (push)                                           Q1        Q2


	static class Stack{  //Constructor for our Stack Object
		Queue<Integer> Q1 = new LinkedList<Integer>(); //declaration of our Queue Q1 as a Linked List from java.util class
		Queue<Integer> Q2 = new LinkedList<Integer>(); //Queue<E> queue = new LinkedList<E>

		int curr_size; //IC of Stack size

		Stack(){ //IC for Stack obj
			curr_size = 0;
		}

		void push(int x){ //Main Stack Opertaion
			curr_size++;
			Q2.add(x); //Add element x into Queue2
			while( !Q1.isEmpty() ){ //while
				Q2.add(Q1.peek());  //inserts top/head element into TAIL of Q2 (Dequeuing)
				Q1.remove(); //function removes element Head of list (x1)
			}
			Queue<Integer> q = Q1; //make copy of Q1 (our now empty Stack)
			Q1 = Q2; //Q1 is empty -> becomes Q2
			Q2 = q; //Q2 -> becomes q, our tmp copy of the empty Q1
		}

		void pop(){ //Main STACK Opertaion
			if( Q1.isEmpty() ){
				System.out.println("STACK IS EMPTY - RELEASING FILE RESOURCES");
				return;
			}

			else{
				curr_size--;
				Q1.remove(); //Removes Head element like Pop() would
			}
		}

		int size(){ //method for size of stack
			System.out.println("STACK CURRENT SIZE: " + curr_size);
			return curr_size;
		}
		
		void printStack(){ //print Queue Q1 using the Itertor Class**
			Iterator<Integer> iter = Q1.iterator();
			while(iter.hasNext()){
				System.out.println(iter.next());
			}
			System.out.println();
		}

	}

	static class StackB{ //ALT METHOD: Make Pop() the costly operation
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		int size;

		StackB(){
			size = 0;
		}

		int pop(){ //Main Stack operation
			if( q1.isEmpty() ){
				System.out.println("STACK IS EMPTY - RELEASING FILE RESOURCES");
				return -1;
			}

			else{
				while( size > 1){ //Dequeue all elements from S1 into S2, except for the last element, which we return / pop
					q2.add(q1.peek());
					q1.remove();
					size--;
				}
				int temp = q1.peek();
				q1.remove();
				return temp;
			}

		}

		void push(int X){ //Main Stack operation
			size++;
			q1.add(X); //inserts element in S1
		}

		void printStack(){
			Iterator<Integer> iter = q2.iterator();
			while(iter.hasNext()){
				System.out.print(iter.next() + " ");
			}
		}

	}

	public static void main(String[] args){

		Stack s = new Stack();

		s.push(20); //BUILT IN add function for linked lists
		s.push(21); 
		s.push(22);
		s.push(23);
		s.push(24);
		s.push(25);

		s.pop(); //Last in , First Out
		s.pop(); 

		s.printStack();

		s.size(); //returns size of Stack

		System.out.println();

		StackB S = new StackB(); //makes Pop operation costly 

		S.push(3);
		S.push(4);
		S.push(5);
		S.push(6);
		S.push(7);

		S.pop();
		S.pop();

		S.printStack();
	}
}
