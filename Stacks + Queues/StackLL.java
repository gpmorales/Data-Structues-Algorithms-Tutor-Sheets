//Implementation of Stack using a LINKED LIST
class StackLL{

	//Using a Singly Linked List we can implement a Stack data Structure
	// Simply have a function Pop() to Remove the Last Node of the list and return it
	// ...and a second function Push() which Inserts a Node at the end of the list
	
	// NOTE: STACKS INSERTION AND DELETION HAPPEN AT THE SAME END

	static StackNode root; //This will act as our Head Node (First in) of our list 

	class StackNode{ //our StackNode object;
		int data; //Data we are storing in our Node obj
		StackNode next; //Declaration of our NEXT pointer obj

		StackNode(int Ndata){ //Self referential call to insert New Data into our node
			this.data = Ndata;
			next = null;
		}
	}

	boolean isEmpty(){ //helper function " we could include this in our if statement in line 42 w just if(root == null) "
		if(root == null){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args){
		StackLL s = new StackLL(); //declaration of the Stack object

		s.push(100); //push function
		s.push(101);

		for(int i = 2; i < 6; i++){ //for loop to quickly insert more elements into our Linked List-based Stack
			s.push(i + 100);
		}
		// Our stack is 100 101 102 103 104 105 

	  s.pop();
	  s.pop();

		printStack();

	}

	public void push(int data){ //function to insert Element at top of Stack
		StackNode in = new StackNode(data); //initialization of Node/Stack element

		if( isEmpty() ){ //if our Stack is empty make inserted element the root
			root = in;
		}

		else{
			StackNode tmp = root;

			while(tmp.next != null){ //parses until the we reach top of the Stack
				tmp = tmp.next;
			}
			tmp.next = in; //Insert new element at end
		}

	}

	public int pop(){ //this function returns the Top Element of the Stack / removes Last Node from list
		if( isEmpty() ){
			System.out.println("STACK IS EMPTY - CANNOT RETURN ELEMENT");
			return -1;
		}

		else{
			StackNode tempA = root;
			while(tempA.next.next != null){
				tempA = tempA.next;
			}

			int Top = tempA.next.data; //save Data from Top element
			tempA.next = null; //remove Last element by having prev Node NEXT = Null (end of List)
			return Top;
		}
	}

	public static void printStack(){ //function to print contents of Stack
		if(root == null ){
			System.out.println("STACK IS EMPTY");
		}

		else{
			StackNode tmp = root; 
			while(tmp != null){
				System.out.print(tmp.data + " ");
				tmp = tmp.next;
			}
		}
	}

}
