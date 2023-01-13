// Example of a Java implementation of a Binary Search Tree
class BST {
	// A binary tree node
	class Node {
		int key;
		Node left, right;
		Node(int data) {
			key = data;
			left = right = null;
		}
	}

	private Node root;

	public BST(){
		root = null;
	}

	// --------------- public BST methods --------------- //
	public int getMinValue() {
		Node current = root;
		/* loop down to find the leftmost leaf */
		while (current.left != null)
				current = current.left;
		return (current.key);
	}

	public int getMaxValue() {
		Node current = root;
		/* loop down to find the rightmost leaf */
		while (current.right != null)
				current = current.right;
		return (current.key);
	}

	// get minimum of a given subtree (not necessarily the entire tree)
	public int getMinValue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current.key);
	}

	public void insert(int key) {
		root = insert(root, key);
	}

	public Node search(int key) {
		return search(root, key);
	}

	public Node delete(int key) {
		return delete(root, key);
	}

	public int findCeil(int input){
		return findCeil(root, input);
	}

	// --------------- private BST methods --------------- //
	/* Given a binary search tree and a number,
	inserts a new node with the given number in
	the correct place in the tree. Returns the new
	root pointer. */
	private Node insert(Node node, int key) {
		/* 1. If the tree is empty, return a new,
		single node */
		if (node == null) {
			return (new Node(key));
		} else {
			/* 2. Otherwise, recur down the tree */
			if (key <= node.key) {
				node.left = insert(node.left, key);
			} else {
				node.right = insert(node.right, key);
			}
			/* return the (unchanged) node pointer */
			return node;
		}
	}

	/* Given a non-empty binary search tree,
	search for a given key and return the node that
	contains it, if exists. Return null if key does not exist. */
	private Node search(Node node, int key) {
	 // 1. what are the base cases?
	 // Either we find the key, or we're done traversing
	 // the tree and the key is not there.
	 if(  node == null || node.key == key ){
		 	return node;
	 }
   // 2. if search key is smaller than (the current) root's key?
	 if( key < node.key ){
		  return search(node.left, key); // passing the result back
			// to the most-recent caller (the parent)...
	 }
	 // 3. if search key is larger than (the current)  root's key?
	 else{
		 return search(node.right, key); // passing the result back
	 }
	}

	/* Given a non-empty binary search tree,
	search for a given key and delete the node that
	contains it. Return null if key does not exist. */
	public Node delete(Node node, int key)
	{
		// Base Case: If tree is empty
		if (node == null) return node;

		// Otherwise, recur down the tree
		if( key < node.key )
			 node.left = delete( node.left, key );
		else if( key > node.key )
		 	node.right = delete( node.right, key );
		else { //node.key == key => found the node to be deleted!
			// Case 1: if node is a leaf
			if( node.left == null && node.right == null )
				return null;

			// Case 2: if node has one subtree
			if( node.left == null ) // has right subtree
				return node.right;
			else if( node.right == null ) // has left subtrees
				return node.left;

			// Case 3: if node has two subtrees
			// Step 1: find the min of right subtree
			int replaceKey = getMinValue(node.right);
			// Step 2: replace the delete node's key with replaceKey
			node.key = replaceKey;
			// Step 3: delete the node with replaceKey
			node.right = delete(node.right, replaceKey);
		} //end of node.key == key
		return node;
	}

	/* Find the ceil of a given input in BST. Ceil is defined as the
	"smallest key in the tree that is greater than or equal to the given key".
	If input is larger than the max key in BST, return -1 */
	private int findCeil(Node node, int input) {
		// Base case
		if (node == null) {
			return -1;
		}

		// We found equal key
		if (node.key == input) {
			return node.key;
		}

		// If root's key is smaller, ceil must be in right subtree
		if (node.key < input) {
			return findCeil(node.right, input);
		}

		// Else, either left subtree or root has the ceil value
		int ceil = findCeil(node.left, input);

		if (ceil >= input)
			return ceil;
		else
			return node.key;
	} // end of ceil



	/* ----------------- BST Traversal Methods ------------- */
	public void printPostorder(){ printPostorder(root); }
	public void printInorder(){ printInorder(root); }
	public void printPreorder(){ printPreorder(root); }

	private void printPostorder(Node node)
	{
		if (node == null)
			return;
		// first recur on left subtree
		printPostorder(node.left);
		// then recur on right subtree
		printPostorder(node.right);
		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder*/
	private void printInorder(Node node)
	{
		if (node == null)
			return;
		/* first recur on left child */
		printInorder(node.left);
		/* then print the data of node */
		System.out.print(node.key + " ");
		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	private void printPreorder(Node node)
	{
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");
		/* then recur on left subtree */
		printPreorder(node.left);
		/* now recur on right subtree */
		printPreorder(node.right);
	}
	/* ----------------- End of BST Traversal Methods ------------- */
}
