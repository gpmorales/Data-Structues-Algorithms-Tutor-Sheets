//import Java.util.Stack;
class Stack{
	// ******************
	// Stacks are another useful type of Abstraction (data structure) which ONLY support TWO OPERATIONS***
	// In general, Stacks simpy store an array of Elements, stacked on top of each other like a Stack of Books 
	// We can only insert elements to the Top of the list or Remove elements from the top!!!
	
	//  1. Push(Object x) -> Inserts an element/object to the TOP of the stack
	//  2. Pop() -> Removes and Returns the FIRST/top element of our List (LIFO)
	//      ^^^Last element IN (Elem 5) is the First element Out ( when we call Stack.pop() )

	//  3. Peek() -> This function allows you to retrieve an item from the Top/Front of the Stack WITHOUT removing it***

	//  Visualization of a Stack: 	
 //Push() -> [ Elem 5 ]  -> Pop()  ***LAST IN, FIRST OUT / FIRST IN, LAST OUT***
	//         [ Elem 4 ]
	//         [ Elem 3 ]
	//         [ Elem 2 ]
	//         [ Elem 1 ]
	//
	//
	//  STACK DECLARATION**** 
	//  -Stack<ObjectType> stackName = new Stack<ObjectType>
	//
	//  STACK RESIZING****
	//  -When a Stack is FULL, CREATE an Array of TWICE the size and COPY items (takes 2N time, logically)
	//  -When the Stacks is ONE-QUARTER FULL, CUT array size in HALF & COPY items
	//
	//  POSSBILE LOGICAL ERRORS***
	//  -If a stack is FULL, calling push() will lead to an OVERFLOW error 
	//  -If a stack is EMPTY, calling pop() will lead to an UNDERFLOW error 
	//
	//  HOW TO IMPLEMENT A STACK**************
	//  -Using an Array
	//  -Using a Linked List 
	
	static int Max = 10;

	int top; //This is our POINTER, an INT var which always points to the TOP ELEMENT

	int[] a = new int[Max]; //This is the Array which will represent our Stack

	Stack() //Constructor
	{ 
		top = -1; //Every Stack object we declare will be empty initially, hence we must have the Top pointer indicate this by = -1
	} 


	boolean isEmpty(){ //Method call for our Stack
		return (top < 0); //If our pointer is -1 or any value less than zero, this is indicative of an Empty List
	}

	boolean isFull(){ // If our pointer is pointing to the last Box/space thats outside of the Array 
		return (top >= Max - 1);
	}


	public static void main(String[] args){
		Stack s = new Stack();
		
		s.push(11);
		s.push(12);
		s.push(13);
		s.push(14);
		s.push(15);
		s.push(16);
		s.push(17);
		s.push(18);
		s.push(19);

		s.pop();
		s.pop();
	  s.dynamicPop();

		s.dynamicPush(20); //Dyanmic push function can RESIZE stack by creating new copy of array 

		s.PrintStack();

		//FINAL REMARKS***
		// -> This implementation of the Stack is EASY to implement (arrays lol) AND saves Memory as we DO NOT employ Pointer Objects!!!
		// -> HOWEVER, this implentation is NOT DYNAMIC. We CANNOT RESIZE the Stack at runtime execution!!! 
		// -> Cannot grow or shrink automatically if we add or remove elements from top of Stack
	}


	public void push(int item){ //Push function inserts Element to the TOP of our Stack
		if( isFull() ){ //if our Stack is Full
			System.out.println("CAN NOT INSERT ELEMENT - STACK IS FULL");
			return;
		}

		else{
			a[++top] = item; //Our pointer is now 0 -> array[0] = item, we are PUSHING in our first element at the bottom of our Stack (array)
			// ++Var -> increments var by 1 and evaluates new value (aka Preincrement)
		}

	}


	public int pop(){ //Pop function returns TOP element and moves Pointer to Left (new Top element)
		if ( isEmpty() ){ //if our Stack is Empty
			System.out.println("CAN NOT RETURN ELEMENT - STACK IS EMPTY");
			return -1;
		}

		else{
			int temp = a[top]; //Store the top element of our Stack in a tmp variable
			a[top--] = 0; //make the top zero (null) as if there was no element there and move pointer (post increment top)
			return temp;
		}
	}


	public void dynamicPush(int item){ //Push function which allows for resizing if our Stack becomes full
		if( isFull() ){ //if our Stack is Full
			System.out.println("CAN NOT INSERT ELEMENT - STACK IS FULL");
			return;
		}

		else{
			a[++top] = item; //Our pointer is now 0 -> array[0] = item, we are PUSHING in our first element at the bottom of our Stack (array)
			// ++Var -> increments var by 1 and evaluates the new/updated value (aka Preincrement)

			if( isFull() ){ //if our Stack becomes full, we will resize it to TWICE the original size
				resize(2*a.length);
			}

		}
	}

	public int dynamicPop(){  //if Stack is 1/4 full, HALVE the Stack size			
		if( isEmpty() ){
			System.out.println("CAN NOT RETURN ELEMENT - STACK IS EMPTY");
			return -1;
		}

		else{
			int temp = a[top];
			a[top--] = 0; //Post increment, makes top element '0', move Top pointer to left ONE

			if(top == a.length/4 - 1 && top > 0){ //if our Stack is 1/4 FULL (pointer is at the index = arr.length/4)
				resize(a.length/2); //resize the array
			}

			return temp;
		}
	}


	public int peek(){ //function to retrive element from top of Stack WITHOUT removing it
		if( isEmpty() ){
			System.out.println("STACK IS EMPTY");
			return -1;
		}
		else{
			int temp = a[top];
			System.out.println("The Stack's top element is: " + temp);
			return temp;
		}
	}
	

	public void resize(int newCapacity){ //function to dynamically resize a Stack
		int[] newStack = new int[newCapacity]; //creation of new Array w size 'newCapacity'

		for(int i = 0; i <= top; i++){ //for loop copies every element in our original stack up to the last/top element (indicated by the TOp pointer)
			newStack[i] = a[i];
		}

		a = newStack; //make our Stack array = the New Array
		this.Max = newCapacity; //Make the Max (stack array length) = newCapacity (new array length)
		
		//****This is a JAVA KEYWORD which refers to the current object/variable, eliminating confusion for the variable names  in different sections of code/our class definition
	}

	public void PrintStack(){ //Function to Print a Stack
		for(int i = 0; i <= top ; i++){ //prints stack's contents
			System.out.print(a[i] + " ");
		}
		System.out.println(); //Terminal spacing
	}

}
