class LinkedList{
	//**********************
	/* a linked List is a recursive data structure that consists of a sequence of NODE OBJECTS, where each NODE 'points' to the next NODE in the list:

	 head --> [ DataItem1 | Next.] --> [ DataItem2 | Next.] --> [ DataItem3 | Next.] --> NULL

	 -> think of a Linked List as a group of blocks chained together
	 -> each NODE or 'block' contains an item AND a reference (i.e 'pointer') to the proceeding block/NODE
	 -> there are various types of linked list; the one depicted above is a SINGLY LINKED LIST; Other types include Doubly linked lists and Circular lists
	 -> a linked List is represented by a pointer to the first node of the linked list. The first node is called the head. If the linked list is empty, then the value of the head points to NULL. 

	 node implementation->
			 public class Node{ //The node objects respective class has 2 attributes (2 fields which describe/determine parameters for the Node object)
					String item; //Data
					Node next; //Reference to next node
			 }

	 CHARACTERISTICS***
		 -> the LAST NODE in the list does not point to another node; instead, it refers to the special value NULL, a sentinel object that is used to mark the end of the list
		 -> linked Lists are DYNAMIC and do NOT have indexed access
		 -> the Node implementation is self-referential; Look at example code, the line 'Node next;' references the class Node
		 -> unlike Arrays, Linked Lists do not store elements continuously in the computers memory (arrays do, their elements are stored right next to each other, as the indeces indicate)
		 -> adding/removing elements to a Linked List is much easier in comparison to Arrays. this is due to the non
 */ /*

	
	***************Constructing a Linked List*************/

	static class Node{  //this class defines our NODE OBJECT***
		int data;	 //initialization of the data item we store in that particular Node
		Node next; //reference to next node
		Node(int ndata){ //this is the method which creates a new node each time the method is called, 
			data = ndata; 
			next = null; //everytime we create a new node object, we add it as the last block to our list, hence its pointer references null and we can keep adding more nodes
		}
	}


	static Node Head; //declaration of Head as a variable of the Node object class

	public static void main(String[] args){
		LinkedList numList = new LinkedList(); //initialization of empty linked list

		numList.Head = new Node(111); //We have allocated 4 nodes dynamically. ATM their pointers go to NULL
		Node second = new Node(222);  // [ Node second | 22 ] ---> NULL
		Node third = new Node(333);
		Node fourth = new Node(444);
		Node fifth = new Node(555);

		Head.next = second; //Link first node w/ second node : [ Node second | 22 ] ---> [ Node third | 333 ] ---> NULL
		second.next = third; //Link second node w/ third node 
		third.next = fourth; //Link third node w/ fourth node
		fourth.next = fifth; //Link fourth node w/ fifth node

		//*****LastNode.next = head; //CIRCULAR LINKED LIST, by linking our last node to the the head, our list points back to its starting block,

		printList(numList); //prints the contents of a linked list starting with the head node
		System.out.println();
		

		/////EXCERCISE FUNCTIONS\\\\\
	  insertEnd(numList, 69); //inserts data at the end of our list
		printList(numList); 

		System.out.println();

	  insertFront(numList, 888); //inserts data at the front of our list;
		printList(numList); 
		removeNode(numList, Head); //removes the Head node 

		System.out.println();
		

		insertAfterN(numList, third, 97); //inserts data after the given node
	  printList(numList); 

		System.out.println();


		removeNode(numList, Head);
	  printList(numList); 

		System.out.println();

		removeNodeB(numList, 444);
	  printList(numList); 
		
		//Current Linked List is 222->333->97->555->69

		System.out.println();

		rotateList(3); //Rotate functions rotates list CounterClockwise 'k' nodes
		
		//Should print 555 -> 69 -> 222-> 333-> 97

	  printList(numList); 

		list.append(5);

	}


	public static void rotateList(int k){ //This function rotates a List 'k' nodes CounterClockwise (to the LEFT)
		//ALGO:
		//1) Change the NEXT of the Last Node to the Head Node (MAKES it a CIRCULAR LIST) / Loop until we reach the K + 1 Node *******
		
		//Rotating CCW 'K' nodes is the Equivalent to Making the Proceeding Node the Head of the List***
		//2) Change the Head Node = K + 1 Node
		//3) Change the NEXT of the Kth Node to NULL  (Makes it the End of the List)

		Node current = Head;
		int counter = 1;
		while(current.next != null && k > counter){ //Traverses to the K-th Node
			current = current.next;
			counter++;
		}

		Node Kth = current; // The 'K-th' Node

		while(current.next != null){
			current = current.next;
		}

		current.next = Head; //Last Node points to Head (Circular List)

		Head = Kth.next; //the Head is now the K+1 Node which was tmp stored in the variable Kth
		Kth.next = null; //K.th now points to Null, making it the Last Node

	}


	public static LinkedList insertFront(LinkedList list, int data){
		Node new_node = new Node(data); //initialiazation of our new NODE object w the input data

		if(Head == null){ //if our list is empty then we make this Node the HEAD NODE
			list.Head = new_node;
		}

		else{ //if we have a non-empty LinkedList, we will insert the node at the front
			Node oldFirst = list.Head; //TMP NODE becomes the head of list
			new_node.next = oldFirst; //New node points to head (oldFirst) making it leading Node
			Head = new_node; //make the head of our list the NEW NODE
		}

		return list; 
	}


	public static LinkedList insertEnd(LinkedList list, int data){
		//parT 1 - initialize Node we will insert
		Node new_node = new Node(data); //initialiation of new node (tmp)

		if(list.Head == null){ //in the case the linkedlist is empty (null), which is indicated by a head that points to null***
			list.Head = new_node; //then make this Node the head of the list
			return list;
		}

		//parT 2 - traverse list until we reach end and add Node to list then
		else{ //otherwise, when we have a non-empty list, we traverse list until we reach NULL, or the end and then add our NODE (data)
			Node last = list.Head; //we initialize TMP Node to be the head of the list
				while(last.next != null){ 
					last = last.next; //we make our TMP NODE = NExt Node
				}
			last.next = new_node; //while loop stops when we reach the last Node (its pointer is to null), and now we can POINT the last node to our input NODE
		}

		return list; //return the updated list with the inserted node at the end
	}


	public static LinkedList insertAfterN(LinkedList list, Node Prev, int new_data){
		Node new_node = new Node(new_data); //initialization of tthe Node we will insert in our list

		if(list.Head == null){ //in the case the linkedlist is empty (null)
			list.Head = new_node; //then make this Node the head of the list
			return list;
		}

		Node temp = list.Head; //declare Head of list as local var in method
		while(temp.next != Prev){ //parse until we reach node right before Prev Node
			temp = temp.next; //iterate by the next field, tmp var is updating from prev
		}
		temp = temp.next; //make the Temp node = the Prev Node

		//*****INSERTION OF NEW NODE
		new_node.next = temp.next; //our New Node will point to the proceeding Node of Prev Node == [ New_Node | new_data] --> [oldAfter Node | data ]
		temp.next = new_node; //link Prev Node to the newly inserted Node (changing the POINTER)

		return list;
	}


	public static LinkedList removeNode(LinkedList list, Node x){
		Node temp = list.Head;

		if(x.equals(Head)){ //in the case we want to remove the HEAD Node
			Head = temp.next; //make Head become the next node while temp points to NULL
			return list;
		}

		while(temp.next != null && temp.next != x){ //otherwise use while loop to find the previous Node to the one we want to Remove
			temp = temp.next;
		}
		Node temp1 = temp.next; //make Temp1 Node = the Node we want to get rid of
		temp.next = temp1.next; //point Node before Node we wnat to delete to the proceeding Node

		//temp.next = temp.next.next; //DOES SAME thing as LINES 163 & 164
		
		return list;
	}


	public static LinkedList removeNodeB(LinkedList list, int key){
		Node temp = list.Head;

		if(temp.data == key){
			Head = temp.next; //
			return list;
		}

		while((temp.next).data != key){ //while the next node does not holdthe KEY
			temp = temp.next; //update temp to be that Node
		}

		Node temp1 = temp.next; //new TMP node becomes the KEY NODE we will remove
		temp.next = temp1.next; //point temp (the Prev NODE) to Node after the one we removed

		return list;
	}


	public static void Append(Object x, Node head){
		Node n = head;
		while(n.next != null){ //traverse until last node is reached
			n = n.next;
		}
		n.next = new Node(x);
	}

	public static void printList(LinkedList list){ 
		Node x = list.Head; // declare our first Node variable, x, to be head (the first node)
		while(x != null){ //while loop prints each non empty nodes' contnet untill null is reached (null -> sentinel object which tells computer that we have reacehd the end of the list)
			System.out.print(x.data + " ");
			x = x.next;
		}
	}

	public static int TraverseLinkedList(int item){ //This method traverses thru a listed link and returns the dseired element we are searching ofr using a loop
		for(Node x = Head; x != null; x = x.next){
			if(x.data == item){
				return x.data;
			}
		}
		return -1; //if the data/element is not present in the linked list, return -1
	}

}
