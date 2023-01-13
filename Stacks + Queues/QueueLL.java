class QueueLL{ 
	// IMPLEMENTATION OF QUEUE USING A LINKED LIST
	
	class QueueNode{ //Queue node object definition
		int data;
		QueueNode next;

		QueueNode(int Ndata){
			this.data = Ndata;
			next = null;
		}
	}

	QueueNode Head; //Declaration of Queue's Head

	QueueNode Tail; //Declaration of Queue's Tail 

	boolean isEmpty(){ //helper function
		return (Head == null);
	}
	 //*An isFull() function is not necessary in this implementation of a Queue as linked lists are DYNAMIC by nature

	public static void main(String[] args){
		QueueLL Q = new QueueLL(); //Declaration of Queue object

		Q.Enqueue(23);
		Q.Enqueue(24);
		Q.Enqueue(25);
		Q.Enqueue(26);
		Q.Enqueue(27);
		Q.Enqueue(28);
		Q.Enqueue(29);

		Q.Dequeue();
		Q.Dequeue();

		Q.printQueue();

		System.out.println();
		
		Q.peek();

	}

	public void Enqueue(int data){ //inserts element at Tail of list
		QueueNode in = new QueueNode(data); //IC
		if( isEmpty() ){
			Head = in; //make Head of list our IN Node
			Tail = in;
		}

		else{
			QueueNode tmp = Head;
			while(tmp.next != null){ //parse thru whole list to insert element at End
				tmp = tmp.next;
			}
			tmp.next = in;
			Tail = in;
		}
	}

	public void Dequeue(){ //removes element from Head of list
		if( isEmpty() ){
			System.out.println("QUEUE IS EMPTY");
			return;
		}

		else{
			QueueNode tmp = Head; //tmp Node = OLD Head of List
			tmp = tmp.next; //Tmp = Node after HEad
			Head = tmp; //Make this Node the New Head
			return;
		}

	}

	public QueueNode peek(){ //retrieves Head of List
		System.out.println("Queue's front element is: " + Head.data);
		return Head;
	}

	public void printQueue(){ //function to print contents of Queue
		if( isEmpty() ){
			System.out.println("QUEUE IS EMPTY");
			return;
		}

		else{
			QueueNode tmp = Head;
			while(tmp != Tail.next){
				System.out.print(tmp.data + " ");
				tmp = tmp.next;
			}
		}
	}

}
