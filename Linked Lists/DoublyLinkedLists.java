class DoublyLinkedLists{
	//A DOUBLY-LINKED LIST is a linked list with BI-DIRECTIONAL REFERENCE (NEXT && PREV POINTER)
	// DLL's (Doubly linked list) contain an EXTRA POINTER (the PREV)
	
  //LIST HEAD ---> [ Prev. | Node A | Next.] <---> [ Prev. | Node B | Next.] <---> [ Prev. | Node C| Next.] --> NULL
	//         NULL <---'
	
	//***DLL CHARARCTERISTICS:
	//->Can be traveresed in both FORWARD or BACKWARD direction
	//->We can quickly insert a New Node, unlike in Singly linked list, to insert or delete a node, we had to traverse the WHOLE list to find the NODE preceding the Node of our interest
	//->Using the Previous Pointer, this task is achieved much more quickly in a DLL

	static class Node{
		int data;
		Node next; //NEXT pointer
		Node prev; //PREV pointer
		Node(int Ndata){
			this.data = Ndata;
			next = null;
			prev = null; 
		}
	}

	static Node head; //initialization of Node Head

	public static void main(String[] args){
		DoublyLinkedLists list = new DoublyLinkedLists();

		pushFront(11);
		Append(12);
		Append(13);
		Append(14);

		insertAfter(list.head.next.next,66); //Inserts 66 after 13

		insertBefore(list.head.next,99); //Inserts 99 before 12 

		Append(15); //adds 15 to end of list
		Append(15); //adds 15 to end of list

		printList(list.head); 

		System.out.println();

		System.out.println(isPalindrome(head)); //Function parses thru DLL to see if its a palindrome

		System.out.println();

		//removeNodePos(3); //removes the THIRD NODE (12)
		removeNode(head.next); //function removes 99 (removes a given Node)

		printList(list.head); //prints list

		System.out.println();

	  DuplicateRemove(head,15); //Function removes Node(s) w/ key data

		System.out.println();


		printList(list.head); //prints DLL


	}


	static void pushFront(int data){ //Adds element to front of list
		Node temp = new Node(data); //initialize the Node w its respective Data

		temp.next = head; //FIRST ALWAYS DEFINE POINTER for NEW NODE 
		temp.prev = null; 

		head = temp; //make the current/new Node the LIST HEAD
	}


	static void Append(int data){ //function adds Element to end of Doubly linked likst
		Node last = new Node(data);

		//In Single list, to insert a New Node, we defined its NEXT POINTER FIRST
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		//HOWEVER!, in a DLL***, when we insert a New Node, we MUST define its PREV POINTER FIRST***
		last.prev = temp;  
		temp.next = last; 
		last.next = null;
	}


	static void insertAfter(Node Prev, int data){ //DLL INSERTION AFTER SPECIFIED NODE
		Node in = new Node(data);

		in.prev = Prev; //have the New Node point to the PREV Node
		in.next = Prev.next; //New Node points to Node after Prev Node
		Prev.next = in; //have Prev point to the New IN NODE

		if(in.next != null){ //Have the Node after our INSERTED NODE point PREV to NODE IN
			in.next.prev = in;
		  //Finally, have the Node after NODE PREV, point BACK to IN NODE
		}

		if(Prev == null){
			System.out.println("Can not insert Node at given position");
			return; //If this is an empty list, return to Main Method and print the statement above
		}

		//NOTE: for a SLL, a while loop was needed to traverse list to find NODE PREV, however this is not necessary in a DLL!
	}


	static void insertBefore(Node After, int data){
		Node in = new Node(data);
		
		in.prev = After.prev; //point inserted Node back to Node that PRECEDED Node After
		in.next = After; //inserted Node points NEXT to Node After
		After.prev = in; //Now we can have AFter point BACK to the New IN NODE

		if(in.prev != null){
			After.prev.prev.next = in; //FINALLY have the Node preceding After point NEXT to the IN NODE, which is now PRECEDING
		}

		else{
			head = in; //make the Input Node our List Head
		}

	}


	static boolean isPalindrome(Node head){ //Function checks if a given DLL is palindrome (RACECAR)
		int counterA = 1;
		Node tmpA = head;

		while(tmpA.next != null){ //finds length of DoublyLinkedList
			tmpA = tmpA.next;
			counterA++;
		}

		Node tmpB = head;
		int counterB = 1;
		while(counterB <= counterA/2 && tmpB.next != null){//sets a TMP NOD = the Middle Node of the DLL
			tmpB = tmpB.next;
			counterB++;
		}

		tmpA = tmpB; //set both of our TMP NODES to be the MIDDLE NODE

		while(tmpA.prev != null && tmpB.next != null ){ //Parses DLL in BOTH DIRECTIONS starting from MIDDLE NODE

			if(tmpA.prev.data == tmpB.next.data){ //if Next NODE = Prev Node (like a MIRROR), keep moving parsing outwards bi directinoally
				tmpA =  tmpA.prev;
				tmpB = tmpB.next;
			}

			else{ //otherwise symmetry is not present so return FALSE
				return false;
			}

		}

		return true; //if False isn't returned, then while loop parsed entire DLL, implying that each opposite set of NODEs were equal,
		//so the list must be a Palindrome!
	}


	static void removeNode(Node del){ //Function to delete a given Node from our DLL
	//BASE STRUC : [ Del.Prev | ] <--> [ Del | ] <--> [ Del.Next | ]

		if(del == null || head == null){ //Base case where list or given Node are empty
			return;
		}

		if(del == head){ //if the Node we want to remove is the Head
			head = del.next; //have the Head List become the Node after
		}

		if(del.next != null){ //in case where Del is NOT the LAST NODE
    //BEFORE: [ Del.Prev | ] <--> [ Del | ] <--> [ Del.Next | ] ******

			del.next.prev = del.prev; //Point Del.NEXT Back to Del.Prev , resulting in image below
			
    //AFTER:  [ Del.Prev | ] <-- [ Del.Next | ]
		}

		if(del.prev != null){ //if Node is not the Head node->

			del.prev.next = del.next; //Point preceding Node to Node after Del NODE
			
		//[Del.Prev | ] --> [ Del.Next | ] ******
		
		}

	}


	static void removeNodePos(int n){
		if(n == 1){ //if we want to remove the Head node
			removeNode(head);
		}

		else{ //any other node->

			Node temp = head;
			int counter = 1;

			while(temp.next != null && n > counter){ //parses up to the Nth Node
				temp = temp.next;
				counter++;
			}
			removeNode(temp); //remove Nth node
		}

	}

	static void DuplicateRemove(Node head, int key){
		if(head == null){ //if List is Empty
			return;
		}

		else{
			Node current = head; //IC
			while(current != null){ //parse thru DLL
				if(current.data == key){ //if Node holds data
					removeNode(current); //remove duplicate
					current = current.next; //parse next
				}

				else{
					current = current.next; //otherwise continue parsing
				}
			}
		}

	}

	static void printList(Node x){ //Function to print DLL in reverse OR forward traversal from any given NODE
		Node last = null; //for backwards traversal, IC of PREV node

		while(x != null){ //if our Node is not empty or we have reached the end of the list
			System.out.print(x.data + " "); //print contents
			last = x;
			x = x.next; //update x
		}

		System.out.println();

		//traverses list backwards
		while(last != null){
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}

}
