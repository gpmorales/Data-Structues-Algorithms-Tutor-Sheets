import java.util.*;
class Deque{
	// A Deque or Double-Ended Queue is a generalized version of the Queue which supports Insertion and Deletion at BOTH ENDS
	// Hence we can use this structure to emulate either a Stack or Queue!
	//
	// ***Deque Operations*** (THROW EXCEPTIONS IF OP FAILS)
	// addFirst() - Inserts element into front of Deque
	// addLast() - Inserts element at back/tail of Deque
	// removeFirst() - Deletes element from front of Deque
	// removeLast() - Deletes element from back/tail of Deque
	//
	//  *Java.util.deque Methods*
	// offerFirst() - offers to insert element at front OR returns Null or Exception IF operation FAILS***
	// offerLast() -  offers to insert element at tail and -^
	// pollFirst() - removes top element and -^
	// pollLast() - removes last element and -^
	//
	// isEmpty() - checks if Deque has elements
	// getLast() - examines last element 
	// getFirst() - examines first element

	public static void main(String[] args){
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

		stack.addFirst(22);
		stack.addFirst(23);
		stack.offerFirst(24);

		stack.addLast(11);

		printList(stack);

		stack.removeFirst();

		printList(stack);

		stack.pollLast();

		printList(stack);
	}

	public static void printList(ArrayDeque<Integer> list){
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		System.out.println();
	}










}
