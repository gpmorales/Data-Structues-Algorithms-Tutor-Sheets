import java.util.*;
class QueuewS{ // IMPLEMENTATION OF A QUEUE USING TWO STACKS
	// Given a Stack which supports Push (insertion at Top) and Pop (deletion from Top) , implement a Queue
	// ---> Using Stacks s1 and s2, create a Queue 'q'
	//
	// METHOD 1: MAKE Enqueue operation costly. Use one Stack, s1, to hold the Oldest Element, hence allowing Dequeue() to simply be achieved by calling pop() on Stack 1
	// ALGORITHM: 1) While S1 !Empty, push All contents from S1 to S2 | 2) S1 is Empty -> Push x3 into S1 | 3) Push everything BACK into S1
	//
	//  Stack1 (input)   Stack2 (output)  | S1 is empty / Now we push X   |  Push everything from S2 -> S1
	//  [  ]             [  ]               [  ]      [  ]                   [  ]      [  ]
	//  [  ]             [  ]               [  ]      [  ]                   [x1]      [  ]
	//  [  ]             [  ]               [  ]      [x2]                   [x2]      [  ] 
	//  [x2]  Push() --> [x1]    *insert E  [x3]      [x1]                   [x3]      [  ]
	//                                     Stack 1   Stack 2                Stack 1   Stack 2    ***NOW REPEAT ALGO
	
	static class Queue{ //Class definition of our Queue, This method makes the Enqueue operation COSTLY 
		Stack<Integer> input = new Stack<Integer>(); //Stack<E> = new Stack<E>() , Declaration of Stack object from Java.util.Stack class
		Stack<Integer> output = new Stack<Integer>();

		void Enqueue(int X){ //MAIN Queue operation: insert at Tail
			while( !input.empty() ){ //empty() method checks if Stack is empty
				output.push(input.pop());
			}

			input.push(X); //insert new element into Stack1

			while(!output.empty()){ //push elements from Stack 2 (output) into Stack 1, which will Push them on Top , hence the inserted element will be at the bottom of Stack Input
				input.push(output.pop());
			}
		}

		int Dequeue(){ //MAIN Queue operation: remove from Top 
			if( input.empty() ){ //empty is built
				System.out.println("QUEUE IS EMPTY");
				return -1;
			}
			else{
				int tmp = input.peek();
				input.pop();
				return tmp;
			}
		}

		void printList(){ //prints List using java's Iterator class, has 2 methods: hasNext() and next()
		Iterator<Integer> iter = input.iterator();
			while(iter.hasNext()){
				System.out.print(iter.next() + " ");
			}
		}

	}

	
	static class QueueB{ //Method 2 makes the Deqeue operation COSTLY 
		Stack<Integer> S1 = new Stack<Integer>();
		Stack<Integer> S2 = new Stack<Integer>();

		//In the Enqueue operation, the new element is inserted at the top of S1 (push)
		//Our Dequeue operation consists of pushing all elements from Stack 1 to Stack 2 and returning the Top of S2 (pop)

		void Enqueue(int X){
				S1.push(X);
		}


		int Dequeue(){ //removes element from top of list
			while( !S1.empty() ){
				S2.push(S1.peek());
				S1.pop();
			}
		  int tmp = S2.peek();
			S2.pop();
			return tmp;
		}

		void printList(){
		Iterator<Integer> iter = S2.iterator();
			while(iter.hasNext()){
				System.out.print(iter.next() + " ");
			}
		}
	}

	public static void main(String[] args){
		Queue Q = new Queue(); //Declaration

		Q.Enqueue(12); //FIRST IN, FIRST OUT when Dequeue is called
		Q.Enqueue(13);
		Q.Enqueue(14);
		Q.Enqueue(15);
		Q.Enqueue(16); //Adds element at Tail of list

		Q.Dequeue();
		
		Q.printList();

		System.out.println();

	  QueueB q = new QueueB(); //Method 2

		q.Enqueue(1);
		q.Enqueue(2);
		q.Enqueue(3);
		q.Enqueue(4);
		q.Enqueue(5);

		q.Dequeue(); //removes 1
		q.Dequeue(); //removes 2

		q.printList();
	}

}
