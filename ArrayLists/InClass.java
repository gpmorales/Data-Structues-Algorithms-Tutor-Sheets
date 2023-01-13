import java.util.*;
import java.util.ArrayList;
public class InClass{
	/* Array Lists in JAVA support:
	 * -> Accessing or updating a particular index
	 *
	 *  Desired:
	 * -> Add items (append)
	 * -> Delete items
	 * -> Dynamic resizing

	 ArryList<Object> numbers = new ArrayList<Object>();
	 numbers.add(100);
	 System.out.println(numbers); // Prints whole array list

	 Methods:
		size() - return number of elements in the list  ( Time is O(1) )

		get(int index) - returns element at a specified position ( Time is O(1) )

		add(Element e) - Appends item into 

		add(int index, Element e)

		remove(int index)



		*/

		public static void main(String[] args){

			ArrayList<Boolean> n = new ArrayList<Boolean>();

			n.add(false);
			n.add(true);
			n.add(false);


			// Parsing through ArrayLists
			for(int i = 0; i < n.size(); i++){
				System.out.println("Item: " + n.get(i));
			}

			System.out.println();

			Iterator<Boolean> iter = n.iterator(); //Connects to list, if we modify iterator we modify our list (iterator is an object which points to front of list, at index = 0)
			while(iter.hasNext()){
				System.out.println("Item: " + iter.next());
			}

			System.out.println();

			int[] N = {1,4,5}
			for(int item : N){
				System.out.println("Item: " + item);
			}

		}














}
