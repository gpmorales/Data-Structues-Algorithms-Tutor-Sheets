import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
public class ArrayListIntro{
	//What are Data Structures? What are their purpose? Why do we use them?
	//DEFINITION -> A DATA STRUCTURE is a logical construct used to store and manage information
	
	//ArrayList => a resizable (dynamic) array defined in java.util package***
	
	//KEY CHARACTERISITCS:
	//ArrayLists are DYNAMIC. I.O you can ADD/REMOVE elements to ArrayLists (change their dimensions)******
	//ArrayLists are ONE-DIMENSIONAL (like a list)
	//ArrayLists can ONLY hold Objects (Strings, Turtle, etc) , and not primitives (int, double, boolean, float, etc)
	//TIP: to have arrayList hold primitives, we can use the wrapper class of that primitive type (ex: Integer for int)
	
	//ArrayList Methods:
		//size() - number of elements in the list
		//get(int index) - element at a specific
		//add(object) - appends element to the end of list
		//add(int index, object) - inserts element at a specific index and shifts subsequent items to the right
		//remove(int index) - remove element at a specific index and shifts subsequent items to the left 
		//iterator() - returns an object that facilitates traversing the ArrayList in a flexible way***

	//General Methods:
		// hasNext() - returns true if there another item, false if not
		// next() - get the next item and move the current position to the next object
		// remove() - removes an item from the underlying item 


	/*****An external method might be necessary if you want to remove elements from ArrayList using iterator
		Arraylist<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("!");

		Iterator<String> iter = list.iterator();
			while(iter.hasNext()){
				System.out.print(iter.next() +  " ");
			}*/

	public static void main(String[] args){
		//Array initialization
		String[] S = new String[5]; //1-D array with 4 elements
		String[] S_new = new String[]{"hi", "hello"}; //Initialization of 1-D string array
		System.out.println(S.length); //Printing the length of an ARRAY (.length is a field)
		System.out.println(S_new[1]); //Prints the i-th element of an ARRAY 
		System.out.println();
		//With normal arrays, one we declare the array, it is not possible to add more elements nor change the dimensions


		//ArrayList initialization*****
		//ArrayList<DataType> listName = new ArrayList<>(); //NOTICE**** how we did not declare the size of the ArrayList
		ArrayList<String> FriendList = new ArrayList<>(Arrays.asList("hi","hello", "hey"));

		System.out.println(FriendList.get(0)); //Printing an element from the ArrayList, prints 'hello"
		//The elements in an ArrayList work the same as for Arrays, with the first element having index 0, then index 1, and so forth
		
		FriendList.add("Good afternoon"); //Adding a new element to our ArrayList
		System.out.println(FriendList.size()); //Printing the length of an ARRAYLIST (Method call, use of brackets)*****

	  FriendList.remove(0); //Removing the first element, shifts everything to left
		System.out.println(FriendList.get(0)); //Should print 'hello', the term to the left of 'hi', which we removed
		System.out.println();

		//Printing an ARRAYLIST
		System.out.println(FriendList); //prints out the whole list, not itertor needed as seen w Arrays


		////EXCERCISES\\\\
		//This block of code declares an ArrayList that holds int (a primitve type that we wrap into an Object using its wrapper class) and adds 3 elements to our initially empty ArrayList
		ArrayList<Integer> NumList = new ArrayList<>();
		NumList.add(1);
		NumList.add(11);
		NumList.add(112);


		//This while loop prints each item of the ArrayList like a for loop would for a normal Array
		Iterator<Integer> iter = NumList.iterator(); //Declaration of iterator class, which iterates thru any collection of objects
		while(iter.hasNext()){
			System.out.print(iter.next() + " "); 
		}

		//This for loop prints contents of the ArrayList as it would for a normal array
		System.out.println();
		for(int i = 0; i < NumList.size(); i++){
			System.out.print(NumList.get(i) + " ");
		}

	}

	//KEY REMARKS****
	//                 | Search | Insertion | Deletion |  Resizing  | 
	//UNORDERED Arrays |  SLOW  |    FAST   |   SLOW   |  DIFFCULT  |
	//ORDERED Arrays   |  FAST  |    SLOW   |   SLOW   |  DIFFCULT  |
	//IDEALLY?         |  FAST  |    FAST   |   FAST   |    EASY    |

	
	//Ideally, we need data structures to have certain characterstics, such as the ability to easily allow the insertion of more data, easy resizing, and the fast deletion of unwanted items
	

}
