class PriorityQueueLL{
	// Priority Queue's are almost like a Queue EXCEPT that each element is associated with a PRIORITY VALUE
	// ...In PQ's, the Element with the HIGHEST PRIORTY gets removed first*** (Highest Priority - First Out)
	//
	// DECLARATION:
	//  PriorityQueue<E> s = new PriorityQueue<E>();
	//
	//  Java.util.PriorityQueue methods*** --> Offer(), poll(), peek(), iterator(), etc.
	//
	//  ***LINKED LIST IMPLEMENTATION***
	//  - The element with the highest priority will be the Head of our linked list
	//  - To insert an element we traverse thru the list to find its proper position in order to maintian the order of priority

	static class Node{ //our Node object class definition
		int data;
		int Priority;		
		Node next;

		Node(int Ndata, int P){
			this.data = Ndata;	
			this.Priority = P; //The lower the value of P, the higher its priority is on the list***
			next = null;
		}
	}


	static class PriorityQueue{ //Their are 2 TYPES of Priority Queues, Ascending and Descending

		Node head; //Declaration of our Node head

		Node newNode(int d, int p){ //iniatialized our PQ w the creation of the head
			head = new Node(d,p);
			return head;
		}

		Node push(Node head, int data, int priority){ //inserts new data into Queue
			Node in = new Node(data,priority); //creation of Node
			Node tmp = head; //tmp variable

			if(head.Priority > in.Priority){ //if has more priority then current head
				in = newNode(data, priority); //inserts as New head of list
				in.next = tmp;
				return in;
			}

			else{
				while(tmp.next != null && tmp.next.Priority <= in.Priority){ //if tmp.next has a smaller val (higher P), than 'in'
					tmp = tmp.next; //... then keep traversing list
				}

				in.next = tmp.next; //point In to the Node after out Tmp Node
				tmp.next = in; //point tmp to in -> [ TMP | ] --> [ IN | ] --> [ TMP.NEXT | ]
				return head; 
			}

		}

		Node pop(){ //returns Head of list, element w highest priority
			Node tmp = head;
			head = tmp.next;
			return tmp;
		}

		int peek(){ //returns Head of list w/o removing it
			if(head == null){
				System.out.println("PRIORITY QUEUE IS EMPTY");
				return -1;
			}

			else{
				System.out.println(head.data);
				return head.data;
			}
		}

		void printQ(){ //function prints Priority Queue 
			Node tmp = head;
			while(tmp != null){
				System.out.println(tmp.data);
				tmp = tmp.next;
			}
		}

	}


	public static void main(String[] args){
		PriorityQueue q = new PriorityQueue();

		q.newNode(12,3); //initializes head & the List

		q.push(q.head, 16, 5);
		q.push(q.head, 15, 4);
		q.push(q.head, 25, 1);


		q.push(q.head, 14, 10);
		q.push(q.head, 2, 9);
		q.push(q.head, 99, 0);
		q.push(q.head, 821, 8);
		q.push(q.head, 69, -1);

		q.pop(); //removes element with highest priority
		q.pop();
		q.pop();

		q.printQ(); //prints Priority Queue

	}

}
