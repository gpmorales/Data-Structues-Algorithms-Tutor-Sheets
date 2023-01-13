import java.util.*;
import java.io.IOException;
import java.lang.NullPointerException;
class BinarySearchTree<Key extends Comparable<Key> , Value>{ 
	// The Binary Tree is a recursively defined data structure. A Binary Tree is either empty (null)
	// or contains a NODE containing Data & TWO pointers to its Left Subtree/Left Child and to its Right Subtree/Right Child
	//  Structure Visualzation:
	//  Level 0             [ Root ]    *Each Node (box) contains 1) Data 2) Left Pointer 3) Right Pointer
	//                      /      \
	//  Left Subtree ->  [   ]      [Node] <- Right Subtree    Level 1*
	//                  /   \      /   \
	//  Level 2       [  ] [  ]  [  ] [  ] <- Leaf Node (Node w 2 empty/Null links)
	//                /  \            /  \
	//  Level 3  		[	]  [ ]        
	//
	// *** It should be noted that a Tree BINARY if each Node has AT MOST 2 Children (Left & Right)
	//
	// **** A Tree is a Binary Search Tree IF ****
	// ---> each Node's Key is LARGER than EVERY Node's Key to its LEFT 
	// ---> each Node's Key is SMALLER than EVERY Node's Key to its RIGHT
	// ---> This is known as Symmetric order
	//
	// - A BST is Binary tree in Symmetric order which contains a Key-Value pair********
	//
	// Properties:
	// - Level (start at 0 w Root Node) is the path length from the root to the current Node
	// - The Height of a tree is the maximum level + 1 / the maximum number of links 
	// - Visit : checking the node value, display node value, etc
	// - Path : sequence of nodes traversed by traveling from the root to a particular. Each path is UNIQUE
	//
	// TRAVERSAL & SEARCHING USING DEPTH FIRST ALGORITHM + RECURSION: line 153 , 343 ********
	
// NODE CLASS IMPLEMENETATION: COMPOSED OF 4 FIELDS***
	class Node{
		Key key; //Key (in our case an integer value)
		Value val; //corresponding value to key (a String , contains some data/info)
		Node right; //Pointer to right 
		Node left; //pointer to left
		
		Node(Key K, Value V){ //Constructor for our Node Class
			this.key = K;
			this.val = V;
			right = null;
			left = null;
		}
	}

	Node root; //root of our tree structure 

	int Size; //Number of Nodes in our tree

	void put(Key k, Value v){ //function to initalize Root of tree
		root = insert(k, v, root); //returns new Node(k, val) = root (line 52)
	}

	Node insert(Key k, Value val, Node in){ //function to insert data (MAINTAIN SYMMETRIC ORDER OF TREE)
		if(in == null){ //BASE CASE
			Size++;
			return new Node(k, val); //when we reach a leaf Node, return new node in corresponding place***
		}

		int cmp =  k.compareTo(in.key); //Compare k's int val w/ node in.key val (if smaller or -1, traverse left / if bigger, traverse right)

		if( cmp > 0 ){ //if our val > than our Input Node's val, CMP = 1, return the right node
			in.right = insert(k, val, in.right); 
			//***ALGORTHIM : We start w the root, if its null, return new Node, else compare the In.key w Root.key -> 
			//--> we return in.right = insert(k, val, root.right)
			//--> Check Comparison again, and return in.right = insert(k, val, root.right.right)
			//--> If this Node (root.right.right) is NULL then we insert the new node here (in its proper Spot)
		}

		else { //else have our left input undergo the algo
			in.left = insert(k, val, in.left);
		}

		return in; //returns the newly inserted Node in its place in the Tree
	}



	Value get(Key key){ //function returns Value to corresponding Key we want to find in our tree
		return Search(root, key); 
	}

	Value Search(Node in, Key key){  //search function which returns Value of Key to get(Key key)
		if(in == null){ 
			return null; //if our Tree is empty, return null
		}

		int cmp = key.compareTo(in.key); //cmp will always be -1,0,1 (indicating < , = , > )

		if( cmp < 0){ //return function w update Node in = in.left if cmp < 0 (key is smaller than current Node)
			return Search(in.left, key);
		}

		else if( cmp > 0) { //return function w update Node in = in.right if cmp > 0 (key is smaller than current Node)
			return Search(in.right, key);
		}

		else{ //Base Case
			return in.val;
		}
	}


	//***There are 3 Different Type of Binary Tree traversal : Pre-Order Traversal, Post-Order Traversal, In-Order Traversal***
	void PreOrderTraverse(Node in){ //in PreOrder Traversal, we print the current node (top/Root), then the Left subtree, then the Right subtree
		if( in == null){ //Base Case -> when we reach the leaf node return to Main method
			return;
		}

		System.out.print(in.key + " "); //print Current node

		if(in.left != null ){ //if left child !Empty
				PreOrderTraverse(in.left); //recursive call, print the Left subtree
		}
		if(in.right != null ){
				PreOrderTraverse(in.right); //then we print the right Subtree
		}		
	}


	void PostOrderTraverse(Node in){ //in PostOrder Traversal, print Left Subtree first, then Right Subtree, then Current Node
		if(in.left != null){ 
			PostOrderTraverse(in.left); //Print left subtree first
		}

		if(in.right != null){
			PostOrderTraverse(in.right); //Print right Subtree afterwards
		}

		System.out.print(in.key + " "); //Print current Node

		if(in == null){ //BASE CASE
			return;
		}
	}
	

	void InOrderTraverse(Node in){ //traverses tree in order of value (Sweeps Tree Left to Right)
		//Print left subtree, current node, then right tree
		if(in == null){
			return;
		}

		if(in.left != null){ //Print left subtree
			InOrderTraverse(in.left);
		}

		System.out.print(in.key + " "); //Print current node

		if(in.right != null){
			InOrderTraverse(in.right); //print Right subtree
		}

	}

	/*
	void Delete(Node input, Key key){ //Deletes Node w given key
		//Three Cases -> Node we want to delete is a Leaf Node (has no children)
		//-> Node to be deleted has ONE Child, we simply replace the Node we want to delete w/ its Child
		//-> Node to be deleted has TWO children; we choose a successor
		if(input == null){ 
			return ;
		}

		if(key.compareTo(input.key) < 0){ //traverse left for key if its smaller than our input
			input.left = Delete(input.left, key);
		}

		else if(key.compareTo(input.key) > 0){ //traverse right for key if its larger than our input
			input.right = Delete(input.right, key);
		}

		else{ //the key = input.key, we have found the key we want to delete
			if(input.right == null && input.left == null){
				input = null; //Delete Leaf Node
			}

			else if(input.right == null && input.left != null){ //if we have one child on the left
				Node tmp = input.left; //tmp var = this child
				input = tmp; // copy : input = child
				input.left = null; //delete old child
			}

			else if(input.left == null && input.right != null){ //if we have one child on the right
				Node tmp = input.right;
				input = tmp;
				input.right = null;
			}

			else{ //Otherwise if our Key has TWO Children
				System.out.println(111);
			}
		}

	}
	*/


	int RangeSize;

	Stack<Key> rangeSearch(Key k1, Key k2){ //Returns an iterable developed from getRange()
		Stack<Key> s = new Stack<Key>(); //Stack will hold Node/Key s that are btwn key 1 and key 2
		getRange(root, k1, k2, s);

		Iterator<Key> iter = s.iterator();
		while( iter.hasNext() ){
			System.out.print(iter.next() + " ");
		}

		System.out.println(RangeSize);

	  return s; //returns Stack
	}

	void getRange(Node in, Key k1, Key k2, Stack<Key> stack){ //returns an iterable of all Keys in BST between k1 & k2
		if(in == null){ 
			return;
		}

		//We start w left subtree, current node, then right subtree that way our iterable is in numerical order
		if(in.left != null){  //if our left subtree is not empty
			 int cmp = k1.compareTo(in.key); //IC cmp
				if(cmp < 0){ //if k1 is Smaller than our than our in key, keep traversing Left Subtree for smaller values that are still larger than k1
					getRange(in.left, k1, k2, stack);
				}
		}

		if(k1.compareTo(in.key) < 0 && k2.compareTo(in.key) > 0){ //If our in.key is Still greater than k1 AND smaller than k2 (IN RANGE)
			RangeSize++;
			stack.push(in.key); //push this Key into our stack
		}

		if(in.right != null){ //if the right subtree is not empty
			 int cmp = k2.compareTo(in.key); //IC cmp
				if(cmp > 0){ //if k2 is Greater than our than our in key, keep traversing Right Subtree for bigger values that are still smaller than k2
					getRange(in.right, k1, k2, stack);
				}
		}
	}



	Key getFloor(Key k){ //floor function
		return Floor(root, k).key;
	}

//*********** When searching/traversing through a BST, we must use the DEPTH FIRST SEARCH ALGORITHM /
// Intuitevly this is due to the fact that we are searching a specific set(s) of key(s) which fro larger Binary Trees (which preserve Symmetric Order)
// Their are much more subtrees we must parse thorugh (selecting either a left or right edge to traverse along) leading to an average search and insertion time of 1.39log2(N) (Our Best Case a balanced tree (

	Node Floor(Node input, Key key){ //returns Largest Key Less Than or Equal to Given Key
		if(input == null){ 
			return null;
		}

		if(key.compareTo(input.key) == 0){ //if input.key = given key, then its a Key/Node that alr exists in our key (so this value is returned
			return input;
		}

		if(key.compareTo(input.key) < 0){ //if input.key is Greater than the Key we are comparing/passing on
			return Floor(input.left, key); //then we must search Left Subtree (smaller vales)***
		}

		else{ //Base Case
			Node floor = Floor(input.right, key); //in the case we are in the Left subtree (where our Floor should be located)
			if(floor == null){ //if we are at a RIGHT Leaf Node, then INPUT.Right == null and hence INPUT is the Largest Possible Key (still in the Left Subtree) that is smaller than our Search Key
				return input; //return this as our ans
			}
			else{
				return floor; //otherwise Return the Input.Right Node as the largest key still Smaller than our Search Key
			}
		}

	}

	

	Key getCeiling(Key k) throws IOException { //Function to return ceiling of given Key
		try{
			return Ceiling(root, k).key;
		}

		catch(NullPointerException e){
			System.out.println("No Ceiling exists for the given value: " + k); 
			return null;
		}
	}

	Node Ceiling(Node input, Key key) { //Function to return value of Smallest Key Greater than or Equal to given Node
		if(input == null){ 
			return null;
		}

		if(key.compareTo(input.key) == 0){ // If our key == input.key, then the Key <= our Search Key is just input.key, 
			return input; //a key alr exists, we can return it
		}

		if(key.compareTo(input.key) > 0){ //If our input.key is Smaller than the input key, we must search the Right Subtree (has greater values)
			return Ceiling(input.right, key);
		}

		else{ //If our Key is Greater than our comparison key, we must check the Left side of the Subtree
			Node ceil = Ceiling(input.left, key); 
			if(ceil == null){ //if input.left == null, then the Left Leaf (input) on the right side is the Smallest key 
				return input;
			}
			else{ //otherwise we go to the Left node (input.left), which is Smaller than input BUT still greater than our SEarch Key
				return ceil;
			}
		}
	}


	Key Max(){ 
		return Max(root);
	}

	Key Max(Node input){ //function to return largest Key in a BST
		if(input == null){ //case where Tree is empty
			return null;
		}
		else if(input.right == null){ //BASE CASE, if we reach rightmost node, we completed parse
			return input.key;
		}
		else{
			return Max(input.right); //recursive call
		}
	}

	Key Min(){
		return Min(root);
	}

	Key Min(Node input){ //function to return smallest Key in a BST
		if(input == null){
			return null;
		}
		else if(input.left == null){
			return input.key;
		}
		else{
			return Min(input.left);
		}
	}


	public static void main(String[] args) throws IOException {
	try{
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();

		//SWITCH KEY & VALUE TYPES!!!
		tree.put(5, "String1"); //put() inserts new Root for tree
		tree.insert(3, "String2", tree.root);
		tree.insert(2, "String3", tree.root);
		tree.insert(4, "String4", tree.root);
		tree.insert(7, "String5", tree.root);
		tree.insert(9, "String6", tree.root);

		/*
		System.out.println(tree.root.key); //prints 5
		System.out.println(tree.root.val); //prints String1

		System.out.println();

		System.out.println(tree.root.right.right.key); //prints 9
		System.out.println(tree.root.right.right.val); //prints String6

		System.out.println();

		System.out.println(tree.get(7)); //returns String5
		System.out.println(tree.get(2)); //returns String3


		tree.PreOrderTraverse(tree.root); //Prints Current node, Left Subtree, then Right Subtree
		
		System.out.println();

		tree.PostOrderTraverse(tree.root); //Prints Left Subtree, then Right Subtree, and finally the Current Node

		System.out.println();

		tree.InOrderTraverse(tree.root); //Prints Left Subtree (smaller val), Current Node, then Right Subtree (larger val)

		System.out.println();
		*/


		BinarySearchTree<Integer, String> treeB = new BinarySearchTree<Integer, String>(); //Initialization of new Binary Tree

		/******* THE ORDER OF INSERTION CHANGES THE TREE SHAPE/ORDER OF NODES (SYMMETRY IS STILL MAINTAINED, HOWEVER) */
		treeB.put(50, "A");
		treeB.insert(30, "C", treeB.root);
		treeB.insert(20, "B", treeB.root);
		treeB.insert(40, "D", treeB.root);
		treeB.insert(70, "E", treeB.root);
		treeB.insert(60, "G", treeB.root);
		treeB.insert(80, "F", treeB.root);

		treeB.PostOrderTraverse(treeB.root);  //20 40 30  60 80 70  50

		System.out.println();

		/*
		System.out.println(treeB.Max()); //80
		System.out.println(treeB.Min()); //20

		System.out.println(treeB.Size); //7 Nodes
		*/

		System.out.println(treeB.getFloor(46)); //returns 40 (This is the largest key in our Binary Search tree that is still smaller than 47!!!)
		System.out.println(treeB.getCeiling(72)); //returns 80

		System.out.println();

		treeB.rangeSearch(23,65); //returns an Iterable of all keys that are btwn the 2 given inputs (30, 40, 50, 60)
		
	  //treeB.Delete(treeB.root, 20);

		System.out.println();

		treeB.InOrderTraverse(treeB.root);  

		//closestPrime(954); //returns nearest Prime Number of given integer




	}

	catch(Exception e){}

	}


}
