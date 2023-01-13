public class LinkedListPr{

	static class Node{
		int data;
		Node next;
		Node(int Ndata){
			this.data = Ndata;
			next = null;
		}
	}

	static Node head;

	public static void main(String[] args){
		/*
		LinkedListPr list = new LinkedListPr();

		list.head = new Node(90);
		Node second = new Node(22);
		Node third = new Node(8);
		Node fourth = new Node(137);

		head.next = second;
		second.next = third;
		third.next = fourth;

		push(list, 101);
		printlist(list);

		System.out.println();


		/*
		for(int i = 0; i < 5; i++){ //for loop creates Nodes w i as the INT data in each successive Node
			Unisertion(exlist, i);
		}
		*/

		LinkedListPr exlist = new LinkedListPr();
		push(exlist, 9);

		Unisertion(exlist, 1);
		Unisertion(exlist, 6);
		Unisertion(exlist, 7);
		Unisertion(exlist, 3);
		Unisertion(exlist, 1);
		Unisertion(exlist, 2);
		Unisertion(exlist, 5);
		Unisertion(exlist, 4);
		
		//This makes the list 9 -> 1 -> 6 -> 0 -> 3 -> 1


		printlist(exlist);

		//getMiddle(head); //getMiddle method returns middle Node of any linkedlist given the head

		//MergeSort(exlist);

	}


	public static void MergeSort(LinkedListPr list){
		int listLength = 0;
		for(Node x = list.head; x != null; x = x.next){
			listLength++;
		}

		int[] arr = new int[listLength]; 

	}

	public static int getMiddle(Node head){ //RETURNS data of Middle Node of any Linked List
		 int counter = 0; //FIRST BLOC -> Finds 'length' of Linked List
		 Node tmp = head;

		 while(tmp.next != null){
			counter++;
			tmp = tmp.next;
		 }
		 counter++; 
																											

		 int counter2 = 0; //SECOND BLOC -> traverses to the mid Node using length of the List
		 Node mid = head;
		 while(counter2 < counter/2){ //Our second counter increments as we travel to towards center
			 counter2++;
			 mid = mid.next;
		 }
		 //when the counter == counter/2 (num of elements/2), return that nodes data

		 System.out.println(mid.data);

		 return mid.data;

	 }

	public static void printlist(LinkedListPr list){
		for(Node x = list.head; x != null; x = x.next){
			System.out.print(x.data + " ");
		}
	}


	public static void push(LinkedListPr list, int data){ //insert at beginning of a Linked List
		Node temp = new Node(data);

		if(list.head == null){ //if our list is empty
			head = temp; //make the head our New node
			return; //return the list
		}

		else{ //otherwise
			temp.next = head; //point the NEW Node to Head (makes it the FIRST NODE
			head = temp; //and make the head of the list the New Node TEMP
		}

	}

	public static void Unisertion(LinkedListPr list, int data){ //inserts Node at the end of a LinkedList
		Node temp = new Node(data); //initialization

		if(list.head == null){ //if our list is empty
			head = temp; //make the head our New node
			return; //return the list
		}

		else{
			Node last = list.head; //TMP node 
				while(last.next != null){  //loop parses until we reach the final Node of the list
					last = last.next;
				}
			last.next = temp; //point final Node to temp/ our NEW NODE
		}

	}


}
