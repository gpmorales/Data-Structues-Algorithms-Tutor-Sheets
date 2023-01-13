public class CircularList{
	//A CIRCULAR LINKED LIST is a linked list where all NODES connect to from a CIRCLE, hence the last Node points back to the Head of the list instead of pointing to NULL
	//THERE IS NO NULL & can be Singly connected or Doubly connected
	
	//---ADVANTAGES & APPLICATIONS OF A CIRCULAR NODE---
	// -> Since this data structure is circular, we can choose ANY Node to be our 'starting' point
	// -> We can traverse the whole list by starting at ANY Node and stop when we reach the same Node AGAIN!
	//
	
	static class Node{
		int data;
		Node next;
		Node(int ndata){
			this.data = ndata;
			next = null;
		}

	}

	static Node head;

	public static void main(String[] args){
		CircularList list = new CircularList();

		/*
		list.head =  new Node(10);
		Node second = new Node(11);
		Node third = new Node(12);
		Node fourth = new Node(21);
		Node fifth = new Node(17);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth; 
		fifth.next = head;//****BY pointing last Node back to the HEAD, this becomes a CIRCULAR LinkedList

		insertFront(9);
		insertFront(2);
		insertEnd(99);
		insertAt(3, 11); //function inserts new Node before Node w key item
		insertAt(77, 21);

		TraverseList(list);
		System.out.println();
		*/


		//int[] arr = new int[]{9,19,7,2,111,3,112,10,201,0,2000,81,19,210,293,788,991,345,-1,45};

		int[] arr = new int[]{10,20,30,40,50};
		
 	  Node temp = null; //initialization of empty List

		for(int i = 0; i < arr.length; i++){
			temp = new Node(arr[i]); 
			sortedInsert(list,temp);
		}
		
		TraverseList(list); //function Prints our Circular List

		//rotateListCCW(4); //This function rotates our list COUNTERCLOCKWISE by 'N' Nodes

		System.out.println();

		rotateListCW(2); //This function rotates our list CLOCKWISE by 'N' Nodes
		TraverseList(list); 
		//
	}


	static void rotateListCW(int k){
		Node tmp = head;
		int counter = 1;
		while(tmp.next != head){
			tmp = tmp.next;
			counter++;
		}

		Node tmpB = head;
		while(tmpB.next != head && k < counter){
			tmpB = tmpB.next;
			k++;
		}

		head = tmpB; //makes (CLL Length - K) Node the Head of the List

	}

	static void rotateListCCW(int k){ //Rotates list Counter Clockwise
		Node tmp = head;
		for(int i = 0; i < k; i++){
			tmp = tmp.next;
		}
		head = tmp;

	}


	static void TraverseList(CircularList list){ //Prints Circular List
		Node temp = list.head;

		if(head != null){ //if our list is not empty, then peform the cmds below 
			
	 //A DO-WHILE Statement is a loop similar to a while loop, EXCEPT that its GUARANTEED TO RUN AT LEAST ONE TIME!!!!
			do{
				System.out.print(temp.data + " ");
				temp = temp.next;
				}
			while(temp != head);
		//Once we reach the last Node whose next = Head; the Loop ENDS
		}

	//Notice that the Boolean expression appears at the end of the loop, so the statements in the loop execute once before the Boolean is tested.
	//If the Boolean expression is true, the control jumps back up to do statement, and the statements in the loop execute again. This process repeats until the Boolean expression is false.

	}


	static void sortedInsert(CircularList list, Node current){
		Node temp = list.head; //Always start w the head of the circular list

		if(temp == null){ //CASE where List is EMPTY
			list.head = current; //make the Inserted Node our List HEAD
			current.next = current; //Loop the Inserted Node to ITSELF
		}

		else if(temp.data >= current.data){ //if the Node we are Inserting has a LESSER VALUE, INSERT NODE AT BEGINNING (before HEAD)

			while(temp.next != head){//loop parses to Node the PRECEDES HEAD
				temp = temp.next;
			//When the loop ends, tmp is the node PRECEDING the HEAD in our CIRCULAR LIST
			}

			//Insert Node before HEAD 
			temp.next = current; //point to our new Node from the head;
			current.next = list.head; //point the Node to the current HEad of the List
			list.head = current; //make the list Head hte newly inserted node

		}

		else{ //in the case where the current Node we are INSERTING is larger than the Head, we insert the node AFTERWARDS

			while(temp.next != head && temp.next.data < current.data){
				temp = temp.next;
			}
		//when loop ends, our TMP Node is Node that holds a SMaller Value than the Node we are Inserting (current node) 
		//...BUT temp.next.data > than the Nodes data we are inserting
				current.next = temp.next; 
				temp.next = current;
		}

	}


	static void insertFront(int data){ //INSERTION of NODE in BEGINNING OF CIRCULAR LIST
		Node new_head = new Node(data); //initialization

		if(head == null){ //case where list is empty
			head = new_head;
			new_head.next = head;
		}

		Node last = head; //IC

		while(last.next != head){ //while loop traverses until we reach Node PRECEDING the LIST HEAD
			last = last.next;
		}

		last.next = new_head; //make the last Node point to our New_Head 
		new_head.next = head; //New_Head points to our List head
		head = new_head; //the new_Head is now our list.Head***

	}


	static void insertEnd(int data){ //Method to insert node at End of List
		Node new_last = new Node(data);

		if(head == null){ //if our list is empty
			head = new_last;
			new_last.next = head;
		}

		Node last = head;

		while(last.next != head){
			last = last.next;
		}

		last.next = new_last;
		new_last.next = head;
	}


	static void insertAt(int data, int key){ //Method to insert Node before a Given Key NODE
		Node in = new Node(data);

		Node temp = head;

		while(temp.next != head && temp.next.data != key){
			temp = temp.next;
		}
		//Temp = the node before the Key Node

		in.next = temp.next; //FIRST DEFINE IN's POINTER, i.o.w have the new Node point to the Key Node***
		temp.next = in; //have the Node before the Key Node point to IN node (INSERTS it btwn)

		/*
		[TEMP | ] --> [ IN | ] --> [TEMP.NEXT | KEY]
		*/

	}


}
