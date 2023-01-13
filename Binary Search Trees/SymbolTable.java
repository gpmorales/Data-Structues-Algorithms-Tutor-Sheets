public class SymbolTable<Key, Value>{ //*******
	// A Symbol Table is an ABSTRACT data type that is utilized to track information about the occurences of various...
	// ...entities such as variable names, Objects, function names, interfaces, and more
	// ***This is accomplished by associating certain VALUES (our input) with a KEY***
	//
	// ->IMPORTANCE: To construct the tools we need to build algorithms around structures like Binary Trees, Hash Tables, and others
	// --> we must understand how to construct and implement Symbol Tables
	//
	// *BASIC IMPLEMENTATION*
	// - We can construct a symbol table by using arrays, Binary Searchs, or in THIS case, an Unordered Linked List
	//
	// <-Key-Value pair Abstraction->                        | EX: DNS lookup                            |  -> We inset a domain name w/ specified IP address
	// - Insert a Value with a specified Key                 | Domain:               |    IP address:    |  -> OR we lookup the IP address corresponding to a Domain name
	// - Given a Key, search for the corresponding Value     | www.cs.princeton.com  |   128.112.136.11  |
	//                                                       | www.cs.emory.com      |   130.132.143.15  |
	//                                                       | www.google.com        |   209.132.143.15  |
	//                                                              *KEY*                   *VALUE*
	//
	// *In an ordered Symbol Table, keys are comparable objects that allow for Sorting
	//
	//  <- SYMBOL TABLE PRIMARY OPERATIONS ->
	//  -> INSERTION of a Key-Value pair into our table
	//  -> SEARCH for Value associated with a particular Key
	//
	//  Application : Compiler -> Purpose of Search: Find properties of Variables | KEY => Variable Name | VALUE =>  Variable type and value
	//   
	//   -> WE ASSUME that the key are IMMUTABLE - keys do not change their value while in
	//  Java Methods():
	//  void put(Key k, Value v) ---> inserts 'k-v' pair into table (a[k] = v)
	//  Value get(Key k) ---> returns Value of a particular key
	//  void delete(Key k) ---> removes key (& values) from table
	//  boolean contains() --> is there a value paired with a Key?
	//  boolean isEmpty() -->  is table empty?
	//  Iterable<Key> keys() -->  all keys in the table are printed w values


	// SEQUENTIAL SEARCH SYMBOL TABLE (Linked List implementation***)
	class Node{
		Key key; //the Object Key is defined in the overarching class SYNTAX SymbolTable<Key, Value> *****
		Value value;
		Node next;

		Node(Key K, Value V){
			this.key = K;
			this.value = V;
			next = null;
		}
	}

	Node head;

	Value get(Key k){ //function to return value associated w a key (Dictionary -> key is word, definition value)
		Node tmp = head;
		while(tmp.next != null){
			if(k.equals(tmp.key)){
				System.out.println("Corresponding Value of " + k + " : " + tmp.value);
				return tmp.value;
			}
			tmp = tmp.next;
		}
		return null;
	
	}

	void put(Key k, Value v){
		if(head == null){
			head = new Node(k,v);
			return; //return to Main method
		}

		Node tmp = head;
		while(tmp.next != null){
			//search table for an existing key, that way we will update if is such a key-pair value alr exists
			if(k.equals(tmp.key)){
				tmp.value = v; //replace value of tmp w/ new Value 'v'
				return; 
			}
			tmp = tmp.next;
		}

		Node in = new Node(k,v); //OTHERWISE, insert new Pair at front of list
		in.next = head;
		head = in;
	}

	void print(){
		for(Node x = head; x != null; x = x.next){
			System.out.println(x.key + " " + x.value);
		}
	}

	public static void main(String[] args){
		SymbolTable<String, Integer> tableA = new SymbolTable<String, Integer>(); //Declaration of a symbol table

	  tableA.put("A" , 50);
	  tableA.put("B" , 51);
	  tableA.put("C", 52);
	  tableA.put("D", 53);
	  tableA.put("E", 54);

		tableA.get("B");

		tableA.print();

		System.out.println();

		SymbolTable<String, Integer> tableB = new SymbolTable<String, Integer>(); //Declaration of a symbol table

		String input = "SEARCHEXAMPLE";

		for(int i = 0; i < input.length(); i++){
			tableB.put(input.charAt(i) + "", i);
		}

		tableB.print(); //OUTPUT IS CORRECT!! VALUES ARE UPDATED CORRECTLY (algo section 3.1 - YT)

	}

}
